<template>
  
  <div class="page">

  <div class="search">
    <span>
      <label for="name-filter">Name</label>
      <input v-model="filter.name" id="name-filter" type="text" class="">
    </span>
    <span>
      <label for="breed-filter">Breed</label>
      <input v-model="filter.breed" id="breed-filter" type="text">
    </span>
    <span>
      <label for="color-filter">Color</label>
      <input v-model="filter.color" id="color-filter" type="text">
    </span>
    <span>
      <label for="age-filter">Age In Years</label>
      <input v-model="filter.age" type="number">
    </span>
  </div>

  <div class="pet-list">
    <PetCard v-for="pet in filteredList" v-bind:key="pet.petId" v-bind:pet="pet"></PetCard>
  </div>
  
  </div>
</template>

<script>
import PetCard from '../components/PetCard.vue';
import PetService from '../services/PetService.js';


export default {
  data(){
    return{
      filter: {
        name: "",
        breed: "",
        color: "",
        age: "",
      }
    }
  },
  computed: {
    pets(){
        return this.$store.state.pets
    },
    filteredList(){
      let filteredPets = this.$store.state.pets
      if(this.filter.name != ""){
        filteredPets = filteredPets.filter((pet) =>
          pet.petName.toLowerCase().includes(this.filter.name.toLowerCase())
        )
      }
      if(this.filter.breed != ""){
        filteredPets = filteredPets.filter((pet) =>
          pet.petBreed.toLowerCase().includes(this.filter.breed.toLowerCase())
        )
      }
      if(this.filter.color != ""){
        filteredPets = filteredPets.filter((pet) =>
          pet.petColor.toLowerCase().includes(this.filter.color.toLowerCase())
        )
      }
      if(this.filter.age != ""){
        filteredPets = filteredPets.filter((pet) => 
          pet.petAge === this.filter.age
        )
      }


      return filteredPets;
    }
  },
    components:{PetCard},
   created() {
     PetService.getAdoptablePets().then(
       (response) => {
         this.$store.commit("SET_PETS", response.data)
       }
     )
   }
}
</script>

<style scoped> 
body, html {
  margin: 0;
  padding: 0;
}

.pet-list{
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}

.search{
  display: flex;
  justify-content: center;
  width: 100%;
  background-color: #FFE5CA;
<<<<<<< HEAD
  margin-top: 0%;

=======
  margin-top: -10px;
  padding-top: 10px;
>>>>>>> 64eaf277eaf33134bfc1a558132d52c717594fc2
}

.search label{
  display: block;
  text-align: center;
}
.search span{
  padding: 10px;
}

.page{
  background-color: #FFF3E2;
}
</style>