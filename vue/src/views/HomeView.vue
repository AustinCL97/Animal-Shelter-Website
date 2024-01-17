<template>
  <div class="home">
    <h1>Home</h1>
    <router-link v-bind:to="{name: 'pets'}">Available Pets</router-link>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
};
</script>
