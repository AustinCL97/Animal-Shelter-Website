<template>
  <div class="card">
    <h2>Pet Name: {{ pet.petName }}</h2>
    <h3>Breed:{{ pet.petBreed }}</h3>
    <img class="photo" :src="photo.photoUrl" alt="pet photo">
    <p>City: {{ pet.petCity }}</p>
    <p>State: {{ pet.petState }} {{ pet.zipCode }}</p>
    <p>Pet Description: {{ pet.petDescription }}</p>

    <div class="buttons">
      <button class="adopt">ADOPT ME</button>
    </div>
  </div>
</template>

<script>
import PetService from '../services/PetService.js'
import PhotoService from '../services/PhotoService.js'

export default {
  data() {
    return {
      photo: {}
    }
  },
  methods: {

  },

  props: {
    pet: Object,

  },
  created() {
    PhotoService.listPhotos(this.pet.petId).then(
      (response) => {
        if (response.data.length > 0) {
          this.photo = response.data[0];
        }

      }
    )
  }
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 5px;
  width: 450px;
  height: 600px;
  margin: 20px;
  text-align: center;
  background: lightgray;
}

.photo {
  width: 200px;
  height: 300px;
  border-radius: 5px;
  object-fit: cover;
  border: 2px black solid;
}
</style>