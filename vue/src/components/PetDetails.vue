<template>
  <section>
    <h2>Pet Details for {{ pet.name }}</h2>
    <h3>Name: {{ pet.name }}</h3>
    <img :src="pet.img"/>
    <h3>ID: {{ pet.petId }}</h3>
    <h3>Breed:{{ pet.breed }}</h3>
    <h3>Color: {{ pet.color }}</h3>
    <h3>Age: {{ pet.age }}</h3>
    <h3>Available: {{ pet.isAvailable }}</h3>
    <h3>Weight: {{ pet.weight }}</h3>
    <span>Location: {{ pet.city}}, {{pet.state}}, {{pet.zip}}</span>
    <p>Description: {{ pet.description }}</p>
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
    }
}
</script>

<style>

</style>