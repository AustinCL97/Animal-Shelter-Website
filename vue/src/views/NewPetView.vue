<template>
  <div class="form" v-on:submit.prevent="addPet()">
    <form>
        <div>
            <label>Pet Name:</label>
            <input v-model="pet.name" type="text">
        </div>
        <div>
            <label>Breed:</label>
            <input v-model="pet.breed" type="text">
        </div>
        <div>
            <label>Color:</label>
            <input v-model="pet.color" type="text">
        </div>
        <div>
            <label>Age in Years:</label>
            <input v-model="pet.age" type="number">
        </div>
        <div class="radio">
            <label for="available">Available</label>
            <input name="isAvailable" type="radio" id="available" v-bind="pet.isAvailable" value="true">

            <label for="unavailable">Unavailable</label>
            <input name="isAvailable" type="radio" id="unavailable" v-bind="pet.isAvailable" value="false">
            
        </div>
       
        <div>
            <label>Weight</label>
            <input v-model="pet.weight" type="number">
        </div>
        <div>
            <label>ZIP Code:</label>
            <input v-model="pet.zip" type="number">
        </div>
        <div>
            <label>City:</label>
            <input v-model="pet.city" type="text">
        </div>
        <div>
            <label>State:</label>
            <input v-model="pet.state" type="text">
        </div>
        <div>
            <label>Description:</label>
            <input v-model="pet.description" type="textarea" rows="5" cols="33" maxlength="10000">
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
            PetService.createPetListing(this.pet, this.$route.params.petId).then(
                (response) => {
                    this.$router.push({name: "pets"})
                }
            )
        },
     
    }

        
    }

</script>

<style>

</style>