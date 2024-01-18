<template>
  <div class="card">
    <h2>{{ pet.petName }}</h2>
    <h3>{{ pet.petBreed }}</h3>
    <img class="photo" :src="pet.img" alt="pet photo">
    <p>{{ pet.petCity }}</p>
    <p>{{ pet.petState }} {{ pet.zipCode }}</p>
    <p>{{ pet.petDescription }}</p>

    <div class="buttons">
        <button class="adopt">ADOPT ME</button>
    </div>
  </div>
</template>

<script> 
import PetService from '../services/PetService.js'
import PhotoService from '../services/PhotoService.js'

export default {

    methods: {
      
    },

    props:{
        pet: Object, 
        photo
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