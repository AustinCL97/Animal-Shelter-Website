<template>
  <div class="container">
    <h2>Volunteer Contact List</h2>
    <div class="table">
        <table id="volunteer-contact">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>

                </tr>
            </thead>
            <tbody>
                <tr class="search">
                    <td>
                        <input v-model="filter.name" id="nameFilter" type="text">
                    </td>
                    <td>
                        <input v-model="filter.email" id="emailFilter" type="text">
                    </td>
                    <td>
                        <input v-model="filter.phone" id="phoneFilter" type="text">
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
                </tr>
            </tbody>
        </table>
    </div>
  </div>
</template>

<script>
import ApplicationService from '../services/ApplicationService';
export default {
    data(){
        return{
            selectedVolunteerIds: [],
            filter: {
                name: "",
                email: "",
                phone: "",

            }
        }
    },
    created(){
        this.refresh()
    },
    computed: {
        volunteers(){
          return this.$store.state.volunteers;
        },
        filteredList(){
            let volunteers = this.$store.state.volunteers;
            let filteredVolunteers = volunteers.filter((volunteer) => 
                volunteer.status.toLowerCase().includes("approved")
            )

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

            return filteredVolunteers;
        }
    },
    methods: {
        refresh(){
            ApplicationService.getApplications().then(
                (response) => {
                    this.$store.commit("SET_VOLUNTEERS", response.data)
                }
            )
        },
        //NICE TO HAVE: method to copy emails/phone numbers to clip board
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
    height: 250px;
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
    position: sticky;
    background: white;
}

h2{
    text-align: center;
}
</style>