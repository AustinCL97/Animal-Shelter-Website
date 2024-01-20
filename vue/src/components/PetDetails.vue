<template>
  <section>
    <h2>Pet Details for {{ pet.pet }}</h2>
   
    <h3>Name: {{ pet.petName }}</h3>
    <img :src="pet.img" :alt="pet.petName"/>
    <h3>ID: {{ pet.petId }}</h3>
    <h3>Breed:{{ pet.petBreed }}</h3>
    <h3>Color: {{ pet.petColor }}</h3>
    <h3>Age: {{ pet.petAge }}</h3>
    <h3>Available: {{ pet.isAvailable }}</h3>
    <h3>Weight: {{ pet.petWeight }}</h3>
    <span>Location: {{ pet.petCity}}, {{pet.petState}}, {{pet.petZip}}</span>
    <p>Description: {{ pet.petDescription }}</p>
  </section>
</template>

<script>

export default {
 
    props: {
        pet: Object,
        enableAdd:{
            type:Boolean,
            default: false
        }
    },

}
</script>

<style>

</style>