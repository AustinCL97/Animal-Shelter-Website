<template>
  <PetCard v-for="pet in pets" v-bind:key="pet.id"/>
</template>

<script>
import PetCard from '../components/PetCard.vue';
export default {
    pets(){
        return this.$store.state.pets
    },
    components:{PetCard}
}
</script>

<style>

</style>