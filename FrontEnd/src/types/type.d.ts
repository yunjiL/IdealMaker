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

export interface ImageResult{
    isError: boolean;
    idealId: number;
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
    animalType: string;
    genderId: number;
    idealId: number;
    idealURL: string;
}

export interface IdealPickState {
    examples: Example[];
    setExamples: (examples: Example[]) => void;
    removeExample: (example: Example) => void;
    winner: Example[] | null;
    setWinner: (winner: Example) => void;
}

export interface ResultData {
    idealUrl : string;
    animalType: string;
}





export interface galleryType {
    content: galleryContent[];
    pageable: Pageable;
    last: boolean;
    totalPages: number;
    totalElements: number;
    size: number;
    number: number;
    sort: Sort;
    first: boolean;
    numberOfElements: number;
    empty: boolean;
}

export interface galleryContent {
    idealId: number;
    idealURL: string;
    animalType: AnimalType;
    genderId: GenderId;
}

enum AnimalType {
    Rabbit = "토끼상",
    Wolf = "늑대상",
    Deer = "사슴상",
    Cat = "고양이상",
    Dog = "강아지상"
}

enum GenderId {
    Male = 1,
    Female = 2
}

interface Pageable {
    pageNumber: number;
    pageSize: number;
    sort: Sort;
    offset: number;
    paged: boolean;
    unpaged: boolean;
}

interface Sort {
    empty: boolean;
    sorted: boolean;
    unsorted: boolean;
}

export interface AnimalTypeRanking {
    animalType: string;
    animalImage: null | string;
    chooseNum: number;
}

export interface AnimalRankingData {
    animalTypeRanking: AnimalTypeRanking[];
}
