import MainLogo from "../../assets/icons/MainLogo.tsx";
import {Link, useNavigate} from 'react-router-dom';
import {useEffect, useState} from "react";

const IdealMain = () => {
    const navigate = useNavigate()
    const [showGenderSelect, setShowGenderSelect] = useState(false);

    const handleToggleGenderSelect = () => setShowGenderSelect(!showGenderSelect);
    const idealPickSelect = (gender:number) => navigate("/idealPick",{state:{gender}, replace:true})

    useEffect(() => {
        if(sessionStorage.getItem('ideal-pick-storage')===null) {
            window.location.reload()
        }
    }, []);

    return (
        <div className="flex flex-col justify-center h-screen">
            <div>
                <p className="text-center text-[200%]">당신이 꿈꿔왔던 바로 그것!</p>
            </div>
            <div className="flex justify-center">
                <MainLogo/>
            </div>
            <div>
                <p className="text-center text-[300%] font-bold">AI 이상형</p>
                <p className="text-center text-[250%] font-bold">제조기</p>
            </div>

            <div className="flex justify-center mb-[4%]">
                <Link to="/invite" className="text-center p-2 w-[55%] bg-bluegray rounded-3xl shadow-custom-outer hover:bg-[#AEC1E0] active:scale-90 duration-300">AI 이상형 만들러 가보기</Link>
            </div>
            <div className="flex justify-center mb-[4%]">
                <Link to="/gallery" className="text-center p-2 w-[55%] bg-[#D1F7FF] rounded-3xl shadow-custom-outer hover:bg-[#2BE6FF] active:scale-90 duration-300">AI 이상형 갤러리 가보기</Link>
            </div>
            <div className="flex justify-center mb-[4%]">
                <button onClick={handleToggleGenderSelect} className="text-center p-2 w-[55%] bg-lightpink rounded-3xl shadow-custom-outer hover:bg-[#F798A5] active:scale-90 duration-300">AI 이상형 월드컵 하러가기</button>
            </div>

            {showGenderSelect ? (
                <div className="flex justify-center mb-[2%]">
                    <button onClick={() => idealPickSelect(1)}
                            className="mr-4 p-2 bg-[#D1F7FF] hover:bg-[#2BE6FF] rounded-3xl">남자
                    </button>
                    <button onClick={() => idealPickSelect(2)}
                            className="p-2 bg-[#FFDBFB] hover:bg-lightpink rounded-3xl">여자
                    </button>
                </div>
            ) : (
                <div className="flex justify-center mb-[2%]">
                    <button onClick={() => idealPickSelect(1)}
                            className="mr-4 p-2 bg-[#D1F7FF] hover:bg-[#2BE6FF] rounded-3xl invisible">fix
                    </button>
                    <button onClick={() => idealPickSelect(2)}
                            className="p-2 bg-[#FFDBFB] hover:bg-lightpink rounded-3xl invisible">fix
                    </button>
                </div>
            )}
        </div>
    )
}

export default IdealMain