import ReportModal from "../../components/modals/report/ReportModal.tsx";
import {useEffect, useState} from "react";
import {getResultAPI, getResultRankAPI} from "../../apis/ResultAPI.tsx";
import {Link, useLocation} from "react-router-dom";
import {AnimalRankingData, ResultData} from "../../types/type";
import AnimalRank from "../../components/result/animalRank.tsx";
// import {useQuery} from "@tanstack/react-query";
// import Loading from "../../components/loading/Loading.tsx";


const IdealResult = () => {
    const[result, setResult] = useState<ResultData>()
    const [animalRank, setAnimalRank] = useState<AnimalRankingData>({ animalTypeRanking:[]});
    const {idealId} = useLocation().state;
    // const{data:result, isError} = useQuery({queryKey:["result"], queryFn:()=>getResultAPI(1)})
    // if(isError) return <Loading/>
    const report = () => {
        (document.getElementById('reportModal') as HTMLDialogElement).showModal()
    }

    useEffect(()=>{
        getResultAPI(idealId).then((data)=>{setResult(data)})
        getResultRankAPI().then((data)=>{setAnimalRank(data)})
    },[])

    return (
        <div>
            <div>
                <p className="text-center text-2xl mt-[6%] mb-[6%]">당신이 꿈꿔왔던 이상형이에요.</p>
            </div>

            <div className={"flex justify-center mb-[8%]"}>
                <img src={result?.idealUrl} alt={"example"} className={"w-[75%] bg-bluegray rounded-2xl"}/>
            </div>

            <div>
                <p className="text-center text-2xl mb-[6%]">이상형은 어떤 동물상일까요?</p>
            </div>

            <div className="flex justify-evenly mb-[6%]">
                <AnimalRank animalType={result?.animalType ?? ''} chooseNum={null} width={100}/>
            </div>

            <div>
                <p className="text-center text-2xl mb-[6%]">전체 사용자 동물상 순위</p>
            </div>
            <div className="flex justify-evenly mb-[6%]">
                <AnimalRank animalType={animalRank.animalTypeRanking[0]?.animalType} chooseNum={animalRank.animalTypeRanking[0]?.chooseNum} width={80}/>
                <AnimalRank animalType={animalRank.animalTypeRanking[1]?.animalType} chooseNum={animalRank.animalTypeRanking[1]?.chooseNum} width={80}/>
                <AnimalRank animalType={animalRank.animalTypeRanking[2]?.animalType} chooseNum={animalRank.animalTypeRanking[2]?.chooseNum} width={80}/>
            </div>

            <div className="flex justify-center mb-[6%]">
                <Link to="/gallery">
                    <button
                        className="bg-bluegray p-2 rounded-2xl shadow-custom-outer active:scale-75 duration-300 hover:bg-[#AEC1E0]">더
                        많은 이상형 보러가기 &gt;&gt;</button>
                </Link>
            </div>

            <div className="flex justify-center mb-[8%]">
                <button
                    className="bg-lightpink p-2 rounded-2xl shadow-custom-outer active:scale-75 duration-300 hover:bg-[#F798A5]"
                    onClick={report}
                >사진이 이상해요
                </button>
            </div>

            <ReportModal/>
        </div>
    )
}

export default IdealResult