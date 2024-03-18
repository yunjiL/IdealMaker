import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {Toast} from "../../../utils/toast/Toast.tsx";
import {useState} from "react";
import "./styles.css"

const ReportModal = () => {
    const [text, setText] = useState("");
    const [error, setError] = useState(false);
    const submit = (e:React.MouseEvent<HTMLButtonElement>) => {
        if (!text.trim()) {
            e.preventDefault();
            setError(true);
            setTimeout(() => setError(false), 3000);
            return;
        }
        Toast.success("제보 감사합니다!")
    }

    return (
        <div>
            <dialog id="reportModal" className={`modal ${error ? "shake" : ""}`}>
                <div className="modal-box bottom-sheet">
                    <h3 className="font-bold text-[140%]">사진이 이상해요!</h3>
                    <p className="py-4">사진이 이상할 경우, 자세한 내용을 하단에 적어주세요.</p>
                    <textarea className="w-[100%] border-2 rounded-xl p-2"
                              value={text} onChange={(e) => setText(e.target.value)}
                    ></textarea>
                    {error && <p className="text-[#FF0023]">내용을 입력해주세요</p>}
                    <div className="modal-action">
                        <form method="dialog" className={"w-[100%] flex justify-end"}>
                            <button className="btn mr-[3%]" onClick={submit}>제출하기</button>
                            <button className="btn">닫기</button>
                        </form>
                    </div>
                </div>
            </dialog>
            <ToastContainer/>
        </div>
    )
}

export default ReportModal