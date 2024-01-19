<template>
  <div id="capstone-app">
     <header>
      <img src="./images/Animal Shelter Wide.jpg" alt="Shelter Puppies">
    </header>
    <div id="nav">
      <router-link class="links" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{ name: 'logout' }" >Logout</router-link>&nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{name: 'admin'}">Admin</router-link> &nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{name: 'volunteer'}">Volunteer</router-link> &nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{name: 'contactUs'}">Contact Us</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
.link{
  
}

</style>


