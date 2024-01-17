<template>
  <div class="pet-list">
    <PetCard v-for="pet in pets" v-bind:key="pet.id" v-bind:pet="pet"></PetCard>
  </div>
</template>

<script>
import PetCard from '../components/PetCard.vue';

export default {
  computed: {
    pets(){
        return this.$store.state.pets
    }
  },
    components:{PetCard}
}
</script>

<style>
.pet-list{
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
}
</style>