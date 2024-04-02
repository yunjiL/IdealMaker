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

export const getGalleryGenderAPI = async (gender:string) => {
    let genderNum = 1;
    if(gender === 'Woman') genderNum = 2;
    try {
        const response = await axios.get(`/gallery/search/gender?genderId=${genderNum}`)
        return response.data
    } catch(error) {
        handleApiError('갤러리 성별 결과를 가져오는 중 오류 발생 ', error)
    }
}

export const getGalleryTypeAPI = async (type:string) => {
    try {
        const response = await axios.get(`/gallery/search/animal-type?animalType=${type}`)
        return response.data
    } catch(error) {
        handleApiError('갤러리 타입 결과를 가져오는 중 오류 발생 ', error)
    }
}

// 에러 처리
const handleApiError = (message:any, error:any) => {
    console.error(`${message}: `, error);
    throw new Error(message);
};
