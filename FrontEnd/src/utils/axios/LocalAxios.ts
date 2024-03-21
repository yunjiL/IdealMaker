import axios from "axios";

const LocalAxios = () => {
    const instance = axios.create({
        baseURL:'import.meta.env.VITE_API_KEY',
        headers: {
            "Content-Type": "application/json;charset=utf-8",
        },
    })
    return instance
}

export default LocalAxios