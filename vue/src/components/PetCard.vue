<template>
  <div class="card">
    <h2>{{ pet.name }}</h2>
    <h3>{{ pet.breed }}</h3>
    <img src="" alt="pet photo">
    <p>{{ pet.city }}</p>
    <p>{{ pet.state }} {{ pet.zip }}</p>
    <p>{{ pet.description }}</p>

    <div class="buttons">
        <button class="adopt">ADOPT ME</button>
    </div>
  </div>
</template>

<script>
export default {
    props:{
        pet: Object
    }
}
</script>

<style>
    .card{
    border: 2px solid black;
    border-radius: 5px;
    width: 250px;
    height: 400px;
    margin: 20px;
    text-align: center;
}
</style>