import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {Toast} from "../../utils/toast/Toast.tsx";

const ReportModal = () => {
    const submit = () => {
        Toast.success("제보 감사합니다!")
    }

    return (
        <div>
            <dialog id="my_modal_1" className="modal">
                <div className="modal-box bottom-sheet">
                    <h3 className="font-bold text-[140%]">사진이 이상해요!</h3>
                    <p className="py-4">사진이 이상할 경우, 자세한 내용을 하단에 적어주세요.</p>
                    <textarea className="w-[100%] border-2 rounded-xl p-2"></textarea>
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