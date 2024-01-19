<template>
    <div class="form" v-on:submit.prevent="addPet()">
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
                <input name="isAvailable" type="radio" id="available" v-model="pet.available" value=true>

                <label for="unavailable">Unavailable</label>
                <input name="isAvailable" type="radio" id="unavailable" v-model="pet.available" value=false>
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
            Pet Id:<input type="text" v-model="pet.petId">
            <input type="submit" v-on:click.prevent="addPet()">
        </form>
    </div>
</template>

<script>
import PetService from '../services/PetService.js'
export default {
    data() {
        return {
            pet: {}
        }
    },

    methods: {

        createPet() {
            PetService.createPetListing(this.pet, this.pet.petId).then(
                (response) => {
                    this.$router.push({ name: "pets" })
                }
            )
        },
        addPet(){
            if(!this.pet.petId){
                this.createPet();
            } else {
                this.updatePet();
            }
        },
        updatePet(){
            PetService.updatePetListing(this.pet, this.$route.params.petId).then(
                (response) =>{
                    this.$router.push({name: 'pets'})
                }
            )
        }

    }


}

</script>

<style></style>