import axios from 'axios';

export default {

    createApplication(volunteer){
        const url = "/Applications/apply/";
        return axios.post(url, volunteer);
    }

}