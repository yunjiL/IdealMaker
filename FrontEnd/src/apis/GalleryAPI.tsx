import LocalAxios from "../utils/axios/LocalAxios.ts";

const axios = LocalAxios()

export const getGalleryAPI = async () => {
    try {
        const response = await axios.get(`/gallery`)
        return response.data
    } catch(error) {
        handleApiError('결과를 가져오는 중 오류 발생 ', error)
    }
}

// 에러 처리
const handleApiError = (message:any, error:any) => {
    console.error(`${message}: `, error);
    throw new Error(message);
};
