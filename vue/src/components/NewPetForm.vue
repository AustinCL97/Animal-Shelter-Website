<template>
    <div class="form" v-on:submit.prevent="addPet()">
        <form>
            <div class="add">Add/Update Pet</div>
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
                <label>Weight:</label>
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
                <label class="desc-label">Description:</label>
                <textarea class="desc" v-model="pet.petDescription" maxlength="500"></textarea>
            </div>
        
            Pet Id:<input type="number" v-model.number="pet.petId">
            <div>
                <label>Adopted by:</label>
                <input v-model="pet.adoptedBy" type="text">
            </div>

            <input id="submit" type="submit" v-on:click.prevent="addPet()">

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
            PetService.updatePetListing(this.pet, this.pet.petId).then(
                (response) =>{
                    this.$router.push({name: 'pets'})
                }
            )
        }

    }


}

</script>

<style scoped>
div .form{
    display: flex;
    align-content: center;
    justify-content: center;
    border-style: solid;
    border-width: 2px;
    border-color: black;
    border-radius: 5px;
    background-color: rgb(157, 171, 134, 0.7);
    padding: 10px;
    margin: 2px;
    
}
div .form input{
    display: flex;
    align-content: center;
    justify-content: center;
}
.radio{
    display: flex;
    justify-content: center;
    padding: 2px;
}
input{
    margin: 2px;
}
.desc{
    text-align: left;
    resize: none;
    overflow: auto;
    width: 169px;
    height: 5vh;
    
}
.desc-label{
    display: flex;
    align-content: flex-start;
}
.add{
    font-weight: bolder;
    text-decoration: underline;
    margin-bottom: 10px;
}
#submit{
  margin-top: 10px;
}


</style>