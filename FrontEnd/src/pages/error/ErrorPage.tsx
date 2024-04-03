import LoadingLogo from "../../assets/icons/LoadingLogo.tsx";
import AnswerButton from "../../components/forms/AnswerButton.tsx";
import {useNavigate} from "react-router-dom";

const ErrorPage = () => {
    const navigate = useNavigate();
    return (
        <div className="flex flex-col justify-center h-screen">
            <div className="flex justify-center">
                <p className="text-center mb-[10%] mr-[3%] text-[150%]"> 당신 내면의 이상형부터 찾는 것은 어떨까요? </p>
            </div>
            <div className="flex justify-center">
                <LoadingLogo/>
            </div>
            <div>
                <AnswerButton
                    questionText={"다시 만들러 가기"}
                    onClick={() => {navigate("/") }}
                    style={"pink-button"}/>
            </div>
        </div>
    )
}

export default ErrorPage