<template>
  <div class="card">
    <h2>Pet Name: {{ pet.petName }}</h2>
    <h3>Breed:{{ pet.petBreed }}</h3>
    <div class="photo-container">
      <button @click="prevPhoto" class="arrow">❮</button>
    <div v-for="photo in photos" :key="photo.photoId" v-show="currentPhoto === photo">
    <img class="photo" :src="photo.photoUrl" alt="pet photo">
    </div>

    <button @click="nextPhoto" class="arrow">❯</button>
    </div>
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
      photos: [],
      currentPhoto: null
    }
  },
  methods: {
    nextPhoto() {
      const currentIndex = this.photos.indexOf(this.currentPhoto);
      const nextIndex = (currentIndex + 1) % this.photos.length;
      this.currentPhoto = this.photos[nextIndex];
    },
    prevPhoto() {
      const currentIndex = this.photos.indexOf(this.currentPhoto);
      const prevIndex = (currentIndex - 1 + this.photos.length) % this.photos.length;
      this.currentPhoto = this.photos[prevIndex];
    }
  },

  props: {
    pet: Object,

  },
  created() {
    PhotoService.listPhotos(this.pet.petId).then(
      (response) => {
        if (response.data.length > 0) {
          this.photo = response.data;
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

.photo-container {
  position: relative;
  overflow: hidden;
}

.photo {
  width: 200px;
  height: 300px;
  border-radius: 5px;
  object-fit: cover;
  border: 2px black solid;
  display: block;
  margin: 0 auto;
}

.arrow {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  font-size: 24px;
  background: none;
  border: none;
  cursor: pointer;
  outline: none;
}

.arrow:first-child {
  left: 10px;
}

.arrow:last-child {
  right: 10px;
}
</style>