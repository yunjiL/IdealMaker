import React, {useState} from 'react';
import './styles.css'
import {useNavigate} from "react-router-dom";
import {Toast} from "../../utils/toast/Toast.tsx";
import {ToastContainer} from "react-toastify";

const Invite = () => {
    const [inviteCode, setInviteCode] = useState('');
    const [shakeError, setShakeError] = useState(false);
    const navigate = useNavigate()

    const handleKeyPress = (e: React.KeyboardEvent<HTMLInputElement>) => {
        if (e.key === 'Enter') validateCode();
    }

    const validateCode = () => {
        if (inviteCode === 'qq11') {
            localStorage.setItem('validated', 'yes');
            Toast.success("초대 코드 인증 완료!",{autoClose:500})
            setTimeout(() => {
                navigate('/form');
            }, 1000);
        } else {
            setShakeError(true);
            setTimeout(() => setShakeError(false), 1000);
        }
    }

    return (
        <div className="h-screen flex flex-col justify-center">
            <div>
                <p className="text-center text-[300%]">초대코드 입력</p>
            </div>
            <div className="flex justify-center">
                <input
                    className={`font-black w-[80%] rounded-2xl shadow-custom-inner p-2 ${shakeError ? 'shake-animation' : ''}`}
                    placeholder="초대코드를 입력해주세요."
                    onChange={(e) => setInviteCode(e.target.value)}
                    onKeyDown={handleKeyPress}
                    value={inviteCode}
                />
            </div>
            {shakeError ? (<p className="text-[#FF0023] text-center">초대코드를 다시 입력해주세요.</p>)
                         :(<div className="invisible">fix</div>)}
            <ToastContainer/>
        </div>
    );
}

export default Invite;
