import ReportModal from "../../components/modals/report/ReportModal.tsx";
import {useEffect, useState} from "react";
import {getResultAPI} from "../../apis/ResultAPI.tsx";

interface ResultData {
    idealURL : string;
    animalType: string;
    animalImage : string;
}

const IdealResult = () => {
    const[result, setResult] = useState<ResultData>()
    const report = () => {
        (document.getElementById('reportModal') as HTMLDialogElement).showModal()
    }

    useEffect(()=>{
        getResultAPI(1).then((data)=>{
            setResult(data)
        })
    },[])
    console.log(result)
    return (
        <div>
            <div>
                <p className="text-center text-2xl mt-[6%] mb-[6%]">당신이 꿈꿔왔던 이상형이에요.</p>
            </div>

            <div className={"flex justify-center mb-[8%]"}>
                <img src={result?.idealURL} alt={"example"} className={"w-[75%] bg-bluegray rounded-2xl"}/>
            </div>

            <div>
                <p className="text-center text-2xl mb-[6%]">이상형은 어떤 동물상일까요?</p>
            </div>

            <div className="flex justify-evenly mb-[6%]">
                <div className="flex flex-col w-[35%]">
                    <img src={result?.animalImage} alt={"dog"} className={"w-[100%] rounded-full mx-auto mb-[3%]"}/>
                    <p className="text-xl text-center">{result?.animalType}</p>
                </div>
            </div>

            <div className="flex justify-center mb-[6%]">
                <button className="bg-bluegray p-2 rounded-2xl shadow-custom-outer active:scale-75 duration-300 hover:bg-[#AEC1E0]">더 많은 이상형 보러가기 &gt;&gt;</button>
            </div>

            <div className="flex justify-center mb-[8%]">
                <button className="bg-lightpink p-2 rounded-2xl shadow-custom-outer active:scale-75 duration-300 hover:bg-[#F798A5]"
                        onClick={report}
                >사진이 이상해요</button>
            </div>

            <ReportModal/>
        </div>
    )
}

export default IdealResult