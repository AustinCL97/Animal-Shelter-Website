import axios from "axios";

const http = axios.create(
    {baseURL:'http://localhost:9000/photos'}
)

export default {
    createPhoto(photo){
        const url = '/add';
        return http.post(url, photo);
    },
    getPhoto(photoId){
        const url = '/' + photoId;
        return http.get(url);
    },
    listPhotos(petId){
        const url = '/pet/' + petId;
        return http.get(url);
    },
    removePhoto(photoId){
        const url = '/remove/' + photoId;
        return http.delete(url);
    }
}

