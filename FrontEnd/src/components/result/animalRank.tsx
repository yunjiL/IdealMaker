import {animalPic} from "../../utils/idealPick/IdealPickFunc.tsx";

interface animalRankProps {
    animalType: string;
    chooseNum:number|null;
    width:number
}

const AnimalRank = ({animalType, chooseNum, width} : animalRankProps) => {
    return (
        <div className="flex flex-col w-[35%]">
            <img src={animalPic(`${animalType}`)} alt={"animal"}
                 className={`w-[${width}%] rounded-full mx-auto mb-[3%]`}/>
            <p className="text-xl text-center">{animalType}</p>
            {chooseNum == null ? (
            <div></div>)
            : (
            <p className="text-xl text-center">{chooseNum}번 생성</p>
            )}
        </div>
    )
}

export default AnimalRank