<template>
<h1>Please Enter Volunteer Details</h1>
<form v-on:submit.prevent="createApplication()">
    <div>
        <label>Volunteer Name</label>
            <input type="text" v-model="volunteer.appName" />
    </div>
    <div>
        <label>Volunteer Phone Number</label>
            <input type="text" v-model="volunteer.appPhoneNumber" />
    </div>
     <div>
        <label>Volunteer Email Address</label>
            <input type="text" v-model="volunteer.appEmail" />
    </div>
    <input type="submit" />
</form>    


  
</template>

<script>

import ApplicationService from '../services/ApplicationService.js'
export default {
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
    }
};
</script>

<style>
</style>