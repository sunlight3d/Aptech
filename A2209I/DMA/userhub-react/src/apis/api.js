import axios from "axios";
export const HttpMethod = {
    GET, POST, PUT, DELETE
}
const BASE_URL = "https://localhost:7169/api"
export const sendRequest = async ({url, data, headers, type}) => {
    let response = {};
    try {
        switch (type) {
            case HttpMethod.GET:
                response = await axios.get(url, data);
                break;
            case HttpMethod.POST:
                response = await axios.post(url, data, {headers})
                break;
            case HttpMethod.PUT:
                response = await axios.put(url, data, {headers})
                break;
            case HttpMethod.DELETE:
                //response = await axios.delete(url, data, {headers})
                break;
        }
        return response;
    }catch(error) {
        console.log(`Error getting data from server: ${error}`)
    }
}