<template>
<h1>Please Enter Volunteer Details</h1>
<form v-on:submit.prevent="createApplication()" class="volunteer-form">
    <div class="form-group">
        <label for="volunteerName"> Your Name</label>
            <input type="text" v-model="volunteer.appName" id="volunteerName" class="form-input" />
    </div>
    <div class="form-group">
        <label for="volunteerPhoneNumber">Your Phone Number</label>
            <input type="text" v-model="volunteer.appPhoneNumber" id="volunteerPhoneNumber" class="form-input" />
    </div>
     <div class="form-group">
        <label for="volunteerEmail">Your Email Address</label>
            <input type="text" v-model="volunteer.appEmail" id="volunteerEmail" class="form-input" />
    </div>
    <input type="submit" class="submit-button" />
    
    <div v-if="$store.state.user.authorities && ($store.state.user.authorities[0].name === 'ROLE_VOLUNTEER' || $store.state.user.authorities[0].name === 'ROLE_ADMIN')" class="links" v-bind:to="{name: 'admin'}" >
        <ContactTable class="volunteer-table"></ContactTable>
    </div>
   
</form>    

</template>

<script>

import ApplicationService from '../services/ApplicationService.js'
import ContactTable from '../components/ContactTable.vue'
export default {
    components: {ContactTable},
    data(){
        return{
            volunteer:{}
        }
    },
    methods: {
        createApplication(){
            ApplicationService.createApplication(this.volunteer, this.$route.params.applicationId)
                        .then(
                            (response) => {
                                this.$router.push({name: "pets"})
                            }
                        )
            
        }
    },
};
</script>

<style>
.form-title {
    font-size: 24px;
    color:yellow;
    margin-bottom: 20px;
}

.volunteer-form {
    max-width: 400px;
    margin: 0 auto;
    text-align: center;
    }

.form-group {
    margin-bottom: 20px;
}

.form-label {
    font-size: 16px;
    color: #555;
    display: block;
    margin-bottom: 8px;
}

.form-input {
    width: 100%;
    padding: 10px;
    box-sizing: border-box;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 14px;
}

.submit-button {
    background-color: #4caf50;
    color: #fff;
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}
.submit-button:hover {
    background-color: #45a049;
}
.volunteer-table {
  margin: 0 auto;
  text-align: center;
  
}
</style>