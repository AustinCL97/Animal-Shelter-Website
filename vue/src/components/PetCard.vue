<template>
  <div class="card">
  
    <h2>{{ pet.petName }}</h2>
    <h3>{{ pet.petBreed }}</h3>
    <h3>{{ pet.petAge }} Years</h3>
    <div class="photo-container">
      <button @click="prevPhoto" class="arrow">❮</button>
    <div v-for="photo in photos" :key="photo.photoId" v-show="currentPhoto === photo">
    <img class="photo" :src="photo.photoUrl" alt="pet photo">
    </div>

    <button @click="nextPhoto" class="arrow">❯</button>
    </div>
    <h4>{{ pet.petColor }}</h4>
    <h5>{{ pet.petWeight }}lbs</h5>
    <p>{{ pet.petCity }}</p>
    <p>{{ pet.petState }} {{ pet.zipCode }}</p>
    <div class="description">
      <p>{{ pet.petDescription }}</p>
    </div>
    <div class="buttons">
      <button v-show="pet.available === true" class="adopt" v-on:click="this.$router.push({name: 'details'})">ADOPT ME</button>
    </div>
  </div>
</template>

<script>
import PetService from '../services/PetService.js'
import PhotoService from '../services/PhotoService.js'
import AdoptedView from '../views/AdoptedView.vue';

export default {
  data() {
    return {
      photos: [],
      currentPhoto: null,
     
    }
  },

  computed: {
     
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
    },
    setToFalse(){
      this.condition = false;
    },
    adoptPet(){

    }
  },

  props: {
    pet: Object,

  },
  created() {
    if(this.pet.petId !== undefined) {
    PhotoService.listPhotos(this.pet.petId).then(
      (response) => {
        if (response.data.length > 0) {
          this.photos = response.data;
          this.currentPhoto = this.photos[0];
        }
      }
    )
  }
  }
}
</script>

<style>
.card {
  border: 2px solid black;
  border-radius: 5px;
  width: 450px;
  height: 750px;
  margin: 20px;
  text-align: center;
  background: #FA9884;
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
.description{
  overflow-y: scroll;
  height: 100px;
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