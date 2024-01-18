<template>
  <div id="capstone-app">
     <header>
      <img src="./images/Animal Shelter Wide.jpg" alt="Shelter Puppies">
    </header>
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> |
      <router-link v-bind:to="{ name: 'admin'}" >Admin</router-link>
    </div>
    <router-view />
  </div>
</template>
