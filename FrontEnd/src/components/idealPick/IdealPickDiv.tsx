import {buttonBG} from "../../utils/idealPick/IdealPickFunc.tsx";
import {Link, useNavigate} from "react-router-dom";

interface PicProps {
    pic:string;
    name:string;
    show:boolean;
    side:string;
}

export const IdealPickDiv = ({pic, name, show, side}:PicProps) => {
    const navigate = useNavigate()
    const moveHome = async () => {
        sessionStorage.clear()
        navigate("/")
    }

    return (
        <>
        <div className="flex justify-center mt-[10%] mb-[5%]">
            <img src={pic} alt={"animal"}
                 className="w-[80%] h-[200px] bg-bluegray rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"/>
        </div>

        <div className="flex justify-center mb-[5%]">
            <p className="text-center text-[150%] invisible">{name}</p>
        </div>

        {show ? (
        <div className={"flex justify-center mb-[7%]"}>
            <button className={buttonBG(side)}>선택</button>
        </div>
        ):(
        <Link to="/" onClick={moveHome}>
        <div className={"flex justify-center mb-[7%] text-2xl hover:animate-bounce"}>홈으로 돌아가기</div>
        </Link>
        )}

        </>
    )
}
