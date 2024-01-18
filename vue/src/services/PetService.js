import axios from "axios"

const http = axios.create(
    {baseURL: 'http://localhost:9000/'}
)

export default {
    getAdoptablePets(){
        const url = 'pets/available';
        return http.get(url);
    },
    getSuccessStories(){
        const url = 'success-stories'
        return http.get(url);
    },
    createPetListing(pet){
        const url = 'pets/addNew';
        return http.post(url, pet);
    },
    updatePetListing(pet){
        const url = 'pets';
        return http.put(url, pet);
    },
    deletePetListing(id){
        const url = 'pets/' + id;
        return http.delete(url);
    },
    getAdoptablePetsWithPhotos(photoId){
        const url = 'pets/with-photos/${photoId}';
        return http.get(url);
    }


}