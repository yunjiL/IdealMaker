import MainLogo from "../../assets/icons/MainLogo.tsx";
import {Link} from 'react-router-dom';

const IdealMain = () => {
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
                <Link to="/form" className="text-center p-2 w-[55%] bg-bluegray rounded-3xl shadow-custom-outer hover:bg-[#AEC1E0] active:scale-90 duration-300" >AI 이상형 만들어 가보기</Link>
            </div>
            <div className="flex justify-center mb-[4%]">
                <button className="p-2 w-[55%] bg-lightpink rounded-3xl shadow-custom-outer hover:bg-[#F798A5] active:scale-90 duration-300">AI 이상형 월드컵 하러가기</button>
            </div>
        </div>
    )
}

export default IdealMain