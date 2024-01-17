<template>
  <div class="form" v-on:submit.prevent="addPet">
    <form>
        <div>
            <label>Pet Name:</label>
            <input v-model="pet.petName" type="text">
        </div>
        <div>
            <label>Breed:</label>
            <input v-model="pet.petBreed" type="text">
        </div>
        <div>
            <label>Color:</label>
            <input v-model="pet.petColor" type="text">
        </div>
        <div>
            <label>Age in Years:</label>
            <input v-model="pet.petAge" type="number">
        </div>
        <div class="radio">
            <label for="available">Available</label>
            <input name="isAvailable" type="radio" id="available" v-bind="pet.isAvailable" value="true">

            <label for="unavailable">Unavailable</label>
            <input name="isAvailable" type="radio" id="unavailable" v-bind="pet.isAvailable" value="false">
            
        </div>
       
        <div>
            <label>Weight</label>
            <input v-model="pet.petWeight" type="number">
        </div>
        <div>
            <label>ZIP Code:</label>
            <input v-model="pet.zipCode" type="number">
        </div>
        <div>
            <label>City:</label>
            <input v-model="pet.petCity" type="text">
        </div>
        <div>
            <label>State:</label>
            <input v-model="pet.petState" type="text">
        </div>
        <div>
            <label>Description:</label>
            <input v-model="pet.petDescription" type="textarea" rows="5" cols="33" maxlength="10000">
        </div>
        <input type="submit">
    </form>
  </div>
</template>

<script>
import PetService from '../services/PetService.js'
export default {
    data(){
        return{
            pet: {}
        }
    },

    methods:{
        addPet(){
            const petId = this.$route.params.petId;

            if(petId){
                PetService.updatePetListing(this.pet)
                .then(
                    (response) => {
                        alert("Listing Updated!")
                        this.$router.push({name: 'pets'})
                    }
                )
            } else {
                PetService.createPetListing(this.pet)
                .then(
                    (response) => {
                        alert("Listing Added!")
                        this.$router.push({name: 'pets'})
                    }
                )
            }
        },

        
    }
}
</script>

<style>

</style>