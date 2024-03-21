import LocalAxios from "../utils/axios/LocalAxios.ts"

const axios = LocalAxios()

export const getResultAPI = async (imageId:number) => {
    try {
        const response = await axios.get(`/result/${imageId}`)
        return response
    } catch(error) {
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

// 에러 처리
const handleApiError = (message:any, error:any) => {
    console.error(`${message}: `, error);
    throw new Error(message);
};
