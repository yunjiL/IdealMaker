export const IdealPickFunc = (amount: number) => {
    if (amount >16) return '32강'
    else if (amount <=16 && amount >8) return '16강'
    else if (amount <=8 && amount >4) return '8강'
    else if (amount <=4 && amount >2) return '4강'
    else if (amount ==2 ) return '결승'
    else return '우승'
}

export const dynamicClass = (selected:string,side: 'left' | 'right') => {
    const baseClass = "transition-all duration-500 ease-in-out";
    if (selected === 'none') {
        return `${baseClass} w-[50%] flex flex-grow flex-col justify-center`;
    } else if (selected === side) {
        return `${baseClass} w-full flex flex-grow flex-col justify-center`;
    } else {
        return `${baseClass} w-0 hidden flex flex-grow flex-col justify-center`;
    }
}

export const buttonBG = (side:string) => {
    const baseClass = "w-[30%] p-2 rounded-xl transition-transform duration-500 ease-out hover:scale-110 active:scale-90"
    switch(side) {
        case 'left':
            return `${baseClass} bg-[#FFB6C1]`
        case 'right':
            return `${baseClass} bg-[#2BE6FF]`
        default :
            return `${baseClass}`
    }
}

export const animalPic = (animal:string) => {
    switch (animal) {
        case '토끼상':
            return "src/assets/images/rabbit.webp"
        case '늑대상':
            return "src/assets/images/wolf.webp"
        case '강아지상':
            return "src/assets/images/dog.webp"
        case '사슴상':
            return "src/assets/images/deer.webp"
        case '고양이상':
            return "src/assets/images/cat.webp"

    }
}