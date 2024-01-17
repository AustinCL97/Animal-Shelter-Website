<template>
  <div class="card">
    <h2>{{ pet.name }}</h2>
    <h3>{{ pet.breed }}</h3>
    <img class="photo" :src="pet.img" alt="pet photo">
    <p>{{ pet.city }}</p>
    <p>{{ pet.state }} {{ pet.zip }}</p>
    <p>{{ pet.description }}</p>

    <div class="buttons">
        <button class="adopt">ADOPT ME</button>
    </div>
  </div>
</template>

<script> 
import PetService from '../services/PetService.js'
export default {
    methods: {
      
    },

    props:{
        pet: Object
    },
}
</script>

<style>
    .card{
    border: 2px solid black;
    border-radius: 5px;
    width: 450px;
    height: 600px;
    margin: 20px;
    text-align: center;
    }

    .photo{
      width: 200px;
      height: 300px;
      border-radius: 5px;
    }
</style>