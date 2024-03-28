/* 기초 설문조사 시작 */
export interface BasicForm{
    surveyId: string;
    genderId: string;
}

/* 기초 설문조사 끝 */

export interface Answer {
    id: number;
    value: string;
}


/* 이상형 설문조사 시작 */ 
export interface Question{
    title: string;
    type: string;
    question: string;
    answers: Answer[] | null;
}

export interface ConceptForm{
    surveyType: string;
    genderId:number;
    questions:Question[];
}


export interface CustomMan extends ConceptForm{
    backgroundList: {backgroundId:number, background:string}[];
    clothList: {clothId:number, cloth:string}[];
    hairStyleList: {hairStyle:number, hairStyle:string}[];
    hairColor:string;
}

export interface CustomWoman extends CustomMan{
    hairLengthList: {hairLengthId:number, hairLength:string}[];
    makeUpList: {makeUpId:number, makeUp:string}[];
}
/* 이상형 설문조사 시작 */ 


export interface ConceptFormResult{
    [index:string]:number|string|Color;

    genderId: number;
    ageId:number;
    faceShapeId:number;
    skinColorId:number;
    eyeStyleId:number;
    conceptId:number;
    pupilColor:string;
}

/* 이상형 월드컵 */
export interface Example {
    id: number;
    name: string;
}

export interface IdealPickState {
    examples: Example[];
    setExamples: (examples: Example[]) => void;
    removeExample: (example: Example) => void;
    winner: Example[] | null;
    setWinner: (winner: Example) => void;
}
