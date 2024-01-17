<template>
  <div class="pet-list">
    <PetCard v-for="pet in pets" v-bind:key="pet.id" v-bind:pet="pet"></PetCard>
  </div>
</template>

<script>
import PetCard from '../components/PetCard.vue';
import PetService from '../services/PetService.js';


export default {
  computed: {
    pets(){
        return this.$store.state.pets
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

<style>
.pet-list{
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>