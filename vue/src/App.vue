<template>
  <div id="capstone-app">
     <header>
      <img  class="img" src="./images/Animal Shelter Wide.jpg" alt="Shelter Puppies">
    </header>
    <div id="nav">
      <router-link class="links" v-bind:to="{ name: 'home'}">Home</router-link>&nbsp;|&nbsp;
      
      <router-link v-if="$store.state.user.authorities[0].name == 'ROLE_ADMIN'" class="links" v-bind:to="{name: 'admin'}" >Admin</router-link> &nbsp;|&nbsp;
    
      <router-link class="links" v-bind:to="{name: 'volunteer'}">Volunteer</router-link> &nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{name: 'contactUs'}">Contact Us</router-link> &nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{name: 'adopted'}">Adopted Pets</router-link> &nbsp;|&nbsp;
      <router-link class="links" v-bind:to="{ name: 'logout'}" >Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<script>

</script>

<style scoped>
#capstone-app {
  display: flex;
  flex-direction: column;
  align-items: center;
 
}

.img{
  height: 20vh;
  width: 90vw;
  border: 5px solid black;
  margin: 5px;
  
  padding: 10px;  
}

#nav{
  color: rgb(247, 183, 135);
  background: rgb(82, 120, 83);
  
}



</style>


