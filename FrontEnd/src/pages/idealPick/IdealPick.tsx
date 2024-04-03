import { useState, useEffect } from 'react';
import { useIdealPickStore } from "../../stores/IdealPick.tsx";
import Trophy from "../../assets/icons/Trophy.tsx";
import {celebration, dynamicClass, IdealPickFunc} from "../../utils/idealPick/IdealPickFunc.tsx";
import {Example} from "../../types/type";
import {IdealPickDiv} from "../../components/idealPick/IdealPickDiv.tsx";
import {useLocation} from "react-router-dom";
import {getWorldCupAPI} from "../../apis/WorldCupAPI.tsx";

const IdealPick = () => {
    const { examples, removeExample, setExamples,winner, setWinner } = useIdealPickStore();
    const [newExamples, setNewExamples] = useState<Example[]>([]);
    const [selected, setSelected] = useState('none');
    const [isChoosing, setIsChoosing] = useState(false);
    const { gender } = useLocation().state;
    const selectRandomExamples = () => {
        const shuffled = [...examples].sort(() => 0.5 - Math.random());
        setNewExamples(shuffled.slice(0, 2));
    }
    const Choose = (side: 'left' | 'right') => {
        if(isChoosing) return;
        setSelected(side);
        setIsChoosing(true);

        const chosenExample = newExamples[side === 'left' ? 0 : 1];
        if (!chosenExample) return;

        // 선택된 example을 winner 배열에 추가
        setWinner(chosenExample);
        // 화면에 표시된 두 객체를 examples 배열에서 제거
        newExamples.forEach(example => removeExample(example));
        setTimeout(async () => {
            setIsChoosing(false);
            window.location.reload();
        }, 1200);
    }

    useEffect(() => {
        if (!examples||examples.length==0 && winner===null) {
            getWorldCupAPI(gender).then((data)=>{
                setExamples(data)
            })
            setTimeout(()=> {
                window.location.reload()
            },100)
        } else if (examples.length >= 2 && !isChoosing) {
            selectRandomExamples()
        } else {
            setExamples(examples)
        }
        if(examples.length==1) {
            setTimeout(() => {
                celebration();
            }, 1000);
        }
    }, [isChoosing]);

    return (
        <div className="flex flex-col min-h-screen justify-center">
            <div className={"flex justify-center mt-[8%]"}>
                <p className={"my-auto text-2xl mr-[5%] mb-[8%]"}>이상형 월드컵</p>
                <Trophy/>
            </div>
            <div>
                <p className="text-center text-2xl mb-[5%]">당신의 선택은??</p>
            </div>
            <div className="flex justify-center mb-[3%]">
                <p className="bg-[#91C3FD] rounded-2xl w-[15%] text-center text-2xl">{IdealPickFunc(examples.length+(winner?.length ?? 0))}</p>
            </div>

            <div className={"flex flex-col flex-grow"}>
            {examples.length == 1 ? (
                <div className="w-full">
                    <IdealPickDiv pic={examples[0]?.idealURL} name={examples[0].animalType} show={false} side={'none'}/>
                </div>
            ) : (
                <div id="selection" className={`flex-grow flex ${selected === 'right' ? 'flex-row-reverse' : ''}`}>
                    {(selected === 'none' || selected === 'left') && (
                        <div id="left" className={`bg-[#FFDBFB] ${dynamicClass(selected,'left')}`} onClick={() => Choose('left')}>
                            <IdealPickDiv pic={newExamples[0]?.idealURL} name={newExamples[0]?.animalType} show={true} side={'left'}/>
                        </div>
                    )}

                    {(selected === 'none' || selected === 'right') && (
                        <div id="right" className={`bg-[#D1F7FF] ${dynamicClass(selected,'right')}`} onClick={() => Choose('right')}>
                            <IdealPickDiv pic={newExamples[1]?.idealURL} name={newExamples[1]?.animalType} show={true} side={'right'}/>
                        </div>
                    )}
                </div>
            )}
            </div>
        </div>
    )
}

export default IdealPick;