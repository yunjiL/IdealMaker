import pic from "@/assets/images/react.svg";
import {buttonBG} from "../../utils/idealPick/IdealPickFunc.tsx";

interface props {
    name:string;
    show:boolean;
    side:string;
}

export const IdealPickDiv = ({name, show, side}:props) => {
    return (
        <>
        <div className="flex justify-center mt-[10%] mb-[5%]">
            <img src={pic} alt={"left"}
                 className="w-[80%] h-[300px] bg-bluegray rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"/>
        </div>

        <div className="flex justify-center mb-[5%]">
            <p className="text-center text-[150%]">{name}</p>
        </div>

        {show && (
        <div className={"flex justify-center mb-[7%]"}>
            <button className={buttonBG(side)}>선택</button>
        </div>
        )}
        </>
    )
}
