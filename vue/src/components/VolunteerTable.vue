<template>
  <div class="container">
    <div class="table">
    <table id="volunteers">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Phone Number</th>
                <th>Status</th>
                <th>Approve</th>
            </tr>
        </thead>
        <tbody>
            <tr>
            <td>
                <input type="checkbox" >
            </td>
            <td>
                <input type="text" id="firstNameFilter">
            </td>
            <td>
                <input type="text" id="emailFilter">
            </td>
            <td>
                <input type="text" id="phoneNumberFilter">
            </td>
            <td>
                <input type="checkbox" id="statusFilter">
            </td>
            </tr>
            <tr
            v-for="volunteer in filteredVolunteers"
            v-bind:key="volunteer.userId"
            v-bind:volunteer="volunteer"
            >
            <td>
                <input type="checkbox" v-model="selectedVolunteerIds" v-bind:id="volunteer.id" v-bind:value="volunteer.id">
            </td>
                <td>{{ volunteer.appName }}</td>
                <td>{{ volunteer.appEmail }}</td>
                <td>{{ volunteer.appPhoneNumber }}</td>
                <td>{{ volunteer.status }}</td>
                <td>
                    <button>Approve</button>
                </td>
            </tr>
        </tbody>
    </table>
    </div>
    <div class="actions">
        <button>Make Admin</button>
        <button v-on:click="deleteApplication()">Delete Volunteer</button>
    </div>
  </div>
</template>

<script>
import ApplicationService from '../services/ApplicationService'
export default {

    data(){
        return{
            selectedVolunteerIds: [],
            filter: {
                name: "",
                email: "",
                phone: "",
                status: "",
            }
        }
    },

    created() {
        ApplicationService.getApplications().then(
            (response) => {
                this.$store.commit("SET_VOLUNTEERS", response.data)
            }
        )
    },
    computed: {
        volunteers(){
            return this.$store.state.volunteers;
        },
        filteredList(){
            let filteredVolunteers = this.$store.state.volunteers;
            if(this.filter.name != ""){
                filteredVolunteers = filteredVolunteers.filter((volunteer) =>
                    volunteer.appName.toLowerCase().includes(this.filter.name.toLowerCase())
                )
            }
            if(this.filter.email != ""){
                filteredVolunteers = filteredVolunteers.filter((volunteer) => 
                    volunteer.appEmail.toLowerCase().includes(this.filter.email.toLowerCase())
                )
            }
            if(this.filter.phone != ""){
                filteredVolunteers = filteredVolunteers.filter((volunteer) =>
                    volunteer.appPhoneNumber.includes(this.filter.phone)
                )
            }
            if(this.filter.status != ""){
                filteredVolunteers = filteredVolunteers.filter((volunteer) => 
                    volunteer.status.includes(this.filter.status)
                )
            }

            return filteredVolunteers;
        }
    },
    methods: {

        //TODO: add functionality to grab id of selected volunteer
        delete(){
            ApplicationService.deleteApplication().then(
                (response) => {
                    this.$router.push({name: 'admin'})
                }
            )
        },
        approve(){
            ApplicationService.approveApplication().then(
                (reponse) => {
                    this.$router.push({name: 'admin'})
                }
            )
        }
    }
}
</script>

<style>

</style>