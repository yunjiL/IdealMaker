import LocalAxios from "../utils/axios/LocalAxios.ts"
import {ConceptFormResult, CustomMan, CustomWoman} from "../types/type";

const axios = LocalAxios()

export const getResultAPI = async (imageId:number) => {
    try {
        const response = await axios.get(`/result/${imageId}`)
        return response.data
    } catch(error) {
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

export const getFormAPI = async(surveyId:string, genderId:string)=>{
    try{
        const url = `/survey?type=${surveyId}&gender=${genderId}`;
        console.log(url)
            const response = await axios.get(url)
        return response.data

    }catch(error){
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

export const postFormResultAPI = async(data:ConceptFormResult|CustomMan|CustomWoman, surveyType:string) =>{
    try{

    let url = `/survey/${surveyType}`;
    if(surveyType==="custom"){
        url+=`/${data.genderId}`;
    }
        const response = await axios.post(url, JSON.stringify(data))
        console.log(response.data)
        return response.data
    }catch(error){
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

// 에러 처리
const handleApiError = (message:any, error:any) => {
    console.error(`${message}: `, error);
    throw new Error(message);
};

