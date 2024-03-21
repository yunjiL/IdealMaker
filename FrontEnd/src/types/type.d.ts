/* 기초 설문조사 시작 */ 

export interface BasicForm{
    surveyId: string;
    genderId: string;
}


/* 기초 설문조사 끝 */ 


/* 이상형 설문조사 시작 */ 
export interface ConceptForm{
    genderInfo: {genderId: number, gender:string};

    ageList: {ageId:number, age:string}[];
    faceShapeList: {faceShapeId:number, faceShape:string}[];
    skinColorList: {skinColorId:number, skinColor:string}[];
    eyeStyleList: {eyeStyleId:number, eyeStyle:string}[];
    conceptList: {conceptId:number, concept:string}[];

    pupilColor:string;
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
    genderId: number;
    ageId:number;
    faceShapeId:number;
    skinColorId:number;
    eyeStyleId:number;
    conceptId:number;
    pupilColor:string;
}