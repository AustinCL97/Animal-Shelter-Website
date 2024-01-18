<template>
  <div class="photo-form">
    <form>
        <div>
            <label>Photo URL:</label>
            <input type="text" v-bind="newPhoto.photoUrl">
        </div>
        <div>
            <label>Pet ID</label>
            <input type="text" v-bind="newPhoto.petId">
        </div>
        <input type="submit">
    </form>
  </div>
</template>

<script>
import PetService from '../services/PetService';
export default {
   data(){
    return {
        newPhoto: {}
    }
   },
   methods: {
    addPhoto(){
        PetService.addPetPhoto(this.newPhoto).then(
            (response) => {
                this.$router.push({ name: "pets" })
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