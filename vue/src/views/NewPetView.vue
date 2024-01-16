<template>
  <div class="form">
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
        <div>
            <label>Available to Adopt?</label>
            <input v-model="pet.isAvailable" type="radio">
        </div>
        <div>
            <label>Description:</label>
            <input v-model="pet.description" type="textarea">
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