import LocalAxios from "../utils/axios/LocalAxios.ts"
import {ConceptFormResult, CustomMan, CustomWoman, ImageResult} from "../types/type";

const axios = LocalAxios()

export const getResultAPI = async (imageId: number) => {
    try {
        const response = await axios.get(`/result/${imageId}`)
        return response.data
    } catch (error) {
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

export const getResultRankAPI = async () => {
    try {
        const response = await axios.get('/ranking')
        return response.data
    } catch(error) {
        handleApiError('동물상 이상형 순위 가져오는 중 오류 발생 ', error)
    }
}


export const getFormAPI = async (surveyId: string, genderId: string) => {
    try {
        const url = `/survey?type=${surveyId}&gender=${genderId}`;
        const response = await axios.get(url)
        return response.data

    } catch (error) {
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

export const postFormResultAPI = async (data: ConceptFormResult | CustomMan | CustomWoman, surveyType: string) => {
    try {

        let url = `/survey/${surveyType}`;
        if (surveyType === "custom") {
            url += `/${data.genderId}`;
        }
        console.log(data)
        const response = await axios.post(url, JSON.stringify(data));
        const result: ImageResult = {
            isError: false,
            idealId: response.data
        }
        return result
    } catch (error) {
        const result: ImageResult = {
            isError: true,
            idealId: -1
        }
        return result
    }
}

// 에러 처리
const handleApiError = (message: any, error: any) => {
    throw new Error(message);
};

