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
    <div v-if="$store.state.user.authorities && $store.state.user.authorities[0].name === 'ROLE_VOLUNTEER' || $store.state.user.authorities[0].name === 'ROLE_ADMIN'" class="links" v-bind:to="{name: 'admin'}" >
        <volunteer-table></volunteer-table>
    </div>
</form>    

</template>

<script>

import ApplicationService from '../services/ApplicationService.js'
import VolunteerTable from './VolunteerTable.vue';
export default {
  components: { VolunteerTable },
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
</style>