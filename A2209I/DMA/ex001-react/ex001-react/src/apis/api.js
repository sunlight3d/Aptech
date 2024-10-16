import axios from "axios";
export const HttpMethod = {
    GET: 1, 
    POST: 2, 
    PUT: 3, 
    DELETE: 4
}
export const BASE_URL = "https://localhost:7136/api"
export const sendRequest = async ({url, data, headers, httpMethod}) => {
    let response = {};
    try {
        switch (httpMethod) {
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