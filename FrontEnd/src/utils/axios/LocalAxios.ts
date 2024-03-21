import axios from "axios";

const LocalAxios = () => {
    const instance = axios.create({
        baseURL:import.meta.env.VITE_API_KEY,
        headers: {
            "Content-Type": `application/json;charset=UTF-8`,
            "Accept": "application/json",
            "Access-Control-Allow-Origin": `http://localhost:3000`,
            'Access-Control-Allow-Credentials':"true",
        },
    })
    return instance
}

export default LocalAxios