import axios from 'axios';

const http = axios.create(
    {baseURL: 'http://localhost:9000/'}
)

export default {

    createApplication(volunteer){
        const url = "/Applications/apply/";
        return axios.post(url, volunteer);
    },

    getApplications(){
        const url = '/Applications'
        return axios.get(url)
    },

    deleteApplication(id){
        const url = 'delete/' //THIS IS A PLACEHOLDER
        return axios.delete(id);
    },

    approveApplication(id, volunteer){
        const url = '/Applications/' + id + '/approve'
        return axios.put(url, volunteer)
    }

}