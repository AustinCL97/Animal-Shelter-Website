<template>
  <div>
    <h2>Pet Details for: {{ $route.params.pet.petName }}</h2>
    <PetDetails :pet="findPet"/>
  </div>
</template>

<script>
import PetDetails from '../components/PetDetails.vue'
export default {    
    components: {PetDetails},

    computed: {
        findPet(){
            return this.$store.state.pet.find(pet => pet.id ===
            this.$route.params.id);
        }
    }
}
</script>

<style>

</style>