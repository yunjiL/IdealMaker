import { useState, useEffect } from 'react';
import pic from "@/assets/images/react.svg";
import { useIdealPickStore } from "../../stores/IdealPick.tsx";
import Trophy from "../../assets/icons/Trophy.tsx";

interface Example {
    id: number;
    name: string;
}

const IdealPick = () => {
    const { examples, removeExample, setExamples, setWinner } = useIdealPickStore();
    const [newExamples, setNewExamples] = useState<Example[]>([]);
    const [selected, setSelected] = useState('none');
    const [isChoosing, setIsChoosing] = useState(false);
    const Choose = (side: 'left' | 'right') => {
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
            window.location.reload(); // 이 부분을 적절한 로직으로 대체 가능
        }, 1200);
    }

    //아래 2개 함수는 utils로 가야된다.
    const dynamicClass = (side: 'left' | 'right') => {
        const baseClass = "transition-all duration-500 ease-in-out";
        if (selected === 'none') {
            return `${baseClass} w-[50%] flex flex-grow flex-col justify-center`;
        } else if (selected === side) {
            return `${baseClass} w-full flex flex-grow flex-col justify-center`;
        } else {
            return `${baseClass} w-0 hidden flex flex-grow flex-col justify-center`;
        }
    }
    const selectRandomExamples = () => {
        const shuffled = [...examples].sort(() => 0.5 - Math.random());
        setNewExamples(shuffled.slice(0, 2));
    }


    useEffect(() => {
        if (examples===null||examples.length==0) {
            setExamples(examples)
        } else if (examples.length >= 2 && !isChoosing) {
            selectRandomExamples()
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
            <div>
                <p className="text-center text-2xl">32강</p>
            </div>
            <div className={"flex flex-col flex-grow"}>
            {examples.length == 1 ? (
                <div className="w-full">
                    <div className="flex justify-center mb-[5%]">
                        <img src={pic} alt={"single"} className="w-[80%] h-[300px] bg-bluegray rounded-xl"/>
                    </div>
                    <div className="flex justify-center mb-[5%]">
                        <p className="text-center text-[150%]">{examples[0].name}</p>
                    </div>
                    <div className={"flex justify-center mb-[7%]"}>
                        <p className={"text-center text-3xl"}>우승</p>
                    </div>
                </div>
            ) : (
                <div id="selection"
                     className={`flex-grow flex ${selected === 'right' ? 'flex-row-reverse' : ''}`}>
                    {(selected === 'none' || selected === 'left') && (
                        <div id="left" className={`bg-[#FFDBFB] ${dynamicClass('left')}`} onClick={() => Choose('left')}>
                            <div className="flex justify-center mt-[10%] mb-[5%]">
                                <img src={pic} alt={"left"}
                                     className="w-[80%] h-[300px] bg-bluegray rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"/>
                            </div>
                            <div className="flex justify-center mb-[5%]">
                                <p className="text-center text-[150%]">{newExamples[0]?.name}</p>
                            </div>
                            <div className={"flex justify-center mb-[7%]"}>
                                <button
                                    className={"w-[30%] p-2 bg-[#FFB6C1] rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"}>선택
                                </button>
                            </div>
                        </div>
                    )}

                    {(selected === 'none' || selected === 'right') && (
                        <div id="right" className={`bg-[#D1F7FF] ${dynamicClass('right')}`} onClick={() => Choose('right')}>
                            <div className="flex justify-center mt-[10%] mb-[5%]">
                                <img src={pic} alt={"right"}
                                     className="w-[80%] h-[300px] bg-bluegray rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"/>
                            </div>
                            <div className="flex justify-center mb-[5%]">
                                <p className="text-center text-[150%]">{newExamples[1]?.name}</p>
                            </div>
                            <div className={"flex justify-center mb-[7%]"}>
                                <button
                                    className={"w-[30%] p-2 bg-[#2BE6FF] rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"}>선택
                                </button>
                            </div>
                        </div>
                    )}
                </div>
            )}
            </div>
        </div>
    )
}

export default IdealPick;