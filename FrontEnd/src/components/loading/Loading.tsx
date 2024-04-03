import LoadingLogo from "../../assets/icons/LoadingLogo.tsx";
import LoadingCircle from "../../assets/icons/LoadingCircle.tsx";

const Loading = () => {
    return (
        <div className="flex flex-col justify-center h-screen">
            <div className="flex justify-center">
                <p className="text-center mb-[10%] mr-[3%] text-[150%]">당신의 이상형을 제조 중이에요..</p>
                <LoadingCircle/>
            </div>
            <div className="flex justify-center">
                <LoadingLogo/>
            </div>
        </div>
    )
}

export default Loading