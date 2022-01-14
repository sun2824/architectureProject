import axios from 'axios'
import store from '~/store'

const DOMAIN = process.env.BACKEND_URL
const UNAUTHORIZED = 401

const headers = {
    'Access-Control-Allow-Methods': 'GET,POST',
    'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json;charset=utf-8'
}

export default {
    request: (method, url, data) => {
        const axiosRequest = axios.create({});
        const token = store.getters['token/getToken'];

        if(token !== null || token !== undefined){
            axios.defaults.headers.common['Authorization'] = token ? token : null;
        }

        headers.responseType = 'blob'

        return axiosRequest({
            headers: headers,
            method,
            url: DOMAIN + url,
            data
        }).then(res => {
            if(res===UNAUTHORIZED){
                console.log('error');
            }
        })

    }/*,
    requestLogin: (data) => {

    }*/
}