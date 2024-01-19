<template>
  <div class="photo-form" v-on:submit="addPhoto()">
    <form>
        <div>
            <label>Photo URL:</label>
            <input type="text" v-model="newPhoto.photoUrl">
        </div>
        <div>
            <label>Pet ID</label>
            <input type="text" v-model="newPhoto.petId">
        </div>
        <input type="submit" v-on:click.prevent="addPhoto()">
    </form>
  </div>
</template>

<script>
import PetService from '../services/PetService';
import PhotoService from '../services/PhotoService';
export default {
   data(){
    return {
        newPhoto: {}
    }
   },

   methods: {
    addPhoto(){
        PetService.addPetPhoto(this.newPhoto, this.$route.params.photoId).then(
            (response) => {
                this.$router.push({ name: "pets" })
            }
        )
    },
    created() {
     PhotoService.getPhoto().then(
       (response) => {
         this.$store.commit("SET_PHOTOS", response.data)
       }
     )
   }
   }
}
</script>

<style>
.photo-form{
    height: 250px;
    widows: 400px;
    border-style: solid;
    border-width: 2px;
    border-color: black;
    border-radius: 5px;
}
</style>