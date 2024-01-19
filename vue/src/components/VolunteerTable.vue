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
                <th>Reject</th>
               
            </tr>
        </thead>
        <tbody>
            
            <tr class="search">
     
            <td>
                <input v-model="filter.name" type="text" id="firstNameFilter">
            </td>
            <td>
                <input v-model="filter.email" type="text" id="emailFilter">
            </td>
            <td>
                <input v-model="filter.phone" type="text" id="phoneNumberFilter">
            </td>
            <td>
                <select id="statusFilter" v-model="filter.status">
                    <option value>Show All</option>
                    <option value="pending">pending</option>
                    <option value="Approved">approved</option>
                    <option value="Rejected">rejected</option>
                </select>
            </td>
            <td>
                <p></p>
            </td>
            <td>
                <p></p>
            </td>
            </tr>
            
            <tr
            v-for="volunteer in filteredList"
            v-bind:key="volunteer.userId"
            v-bind:volunteer="volunteer"
            >
           
                <td>{{ volunteer.appName }}</td>
                <td>{{ volunteer.appEmail }}</td>
                <td>{{ volunteer.appPhoneNumber }}</td>
                <td>{{ volunteer.status }}</td>
                <td>
                    <button v-on:click="approve(volunteer)" v-show="volunteer.status != 'Approved'">Approve</button>
                    <button v-on:click="promote(volunteer.userId)" v-show="volunteer.status == 'Approved'">Make Admin</button>
                </td>
                <td>
                    <button v-on:click="reject(volunteer)" v-show="volunteer.status != 'Approved' && volunteer.status != 'Rejected'">Reject</button>

                </td>
            </tr>
        </tbody>
    </table>
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
       this.refresh();
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
            ApplicationService.deleteApplication(this.selectedVolunteerIds).then(
                (response) => {
                    this.$router.push({name: 'admin'})
                }
            )
        },
        approve(volunteer){
            let id = volunteer.applicationId
            ApplicationService.approveApplication(id, volunteer).then(
                (response) => {
                    this.refresh();
                }
            )
        },
        reject(volunteer){
            let id = volunteer.applicationId
            ApplicationService.rejectApplication(id, volunteer).then(
                (response) => {
                    this.refresh();
                }
            )
        },
        refresh(){
            ApplicationService.getApplications().then(
            (response) => {
                this.$store.commit("SET_VOLUNTEERS", response.data)
            }
        )
        },
        promote(id){
            
            ApplicationService.makeAdmin(id).then(
                (response) => {
                    this.refresh();
                }
            )
        }
    }
}
</script>

<style>
tr:nth-child(even){
    background-color: #d3d3d3;
}
.container{
    border: 2px solid black;
    border-radius: 5px;
    height: 150px;
    width: 775px;
   
}
.table{
    overflow-y: scroll;
    max-height: 150px;
   
}

table thead{
    top: 0%;
    position: sticky;
    background: white;
}
.search{
    top: 20px;
    position: sticky;
    background: white;
}


</style>