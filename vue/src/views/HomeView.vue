<template>
  <div class="home">
    <h1>Welcome to Parker's Pets Animal Shelter</h1>
    <div v-if="!isLoggedIn">
      <router-link to="/login">Login Now</router-link> |
      <router-link to="/register">Register</router-link>
    </div>
    <div>Available Pets</div>

    <section v-if="isLoggedIn">
      <h2>Volunteer Application Form</h2>
      <application-form></application-form>
    </section>

   <pet-view></pet-view>

   <section>
      <h2>Mission Statement</h2>
        <p>
          Parker's Pet Animal Shelter is dedicated to providing a safe and loving <br>
          haven for animals in need. Our mission is to rescue, rehabilitate, and <br>
          re-home pets, fostering a compassionate community that values the well-being of <br>
          every animal. Through education, advocacy, and adoption services, we strive to <br>
          create a world where every pet has a chance for a happy and fulfilling life 
        </p>
    </section>
  </div>
</template>

<script>
import ApplicationForm from '../views/ApplicationForm.vue'
import PetView from '@/views/PetView.vue';
export default {
  components: {
    ApplicationForm,
    PetView,
  },
  computed: {
    //checks to see if they are logged in.
    isLoggedIn(){
      return this.$store.state.token !== '';
    }
  }
};
</script>
