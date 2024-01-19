<template>
  <div>
    <PetDetails :pet="findPet"/>
  </div>
</template>

<script>
import PetDetails from '../components/PetDetails.vue'
import PetServices from '../services/PetService'
export default {    

    components: {PetDetails},
    props:{

    },
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