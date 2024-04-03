import {create} from 'zustand';
import {createJSONStorage, devtools, persist} from 'zustand/middleware';
import {Example, IdealPickState} from "../types/type";

export const useIdealPickStore = create<IdealPickState>()(
   devtools(
    persist(
        (set,get) => ({
            examples: [],
            setExamples: (examples:Example[]) => {
                const currentWinner = get().winner;
                if ((examples === null || examples.length == 0) && currentWinner && currentWinner.length > 0) {
                    set({ examples: currentWinner, winner: null });
                    return;
                } else {
                    set({ examples });
                }
            },
            removeExample: (exampleToRemove: Example) => {
                const updatedExamples = get().examples.filter(example => example?.idealId !== exampleToRemove.idealId);
                set({ examples: updatedExamples });
            },
            winner: null,
            setWinner: (newWinner:Example) => {
                const currentWinner = get().winner;
                if (currentWinner === null) {
                    // 현재 winner가 null이면, newWinner로 새 배열을 생성
                    set({ winner: [newWinner] });
                } else {
                    // 현재 winner가 배열이면, newWinner를 기존 배열에 추가
                    set({ winner: [...currentWinner, newWinner] });
                }
            },
        }),
        {
            name: 'ideal-pick-storage',
            storage : createJSONStorage(()=>sessionStorage)
        }
    )
   )
);
