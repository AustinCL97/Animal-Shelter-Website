<template>
  <div class="container">
    <div class="table">
    <table id="users">
        <thead>
            <tr>
                
                <th>User ID</th>
                <th>Username</th>
                <th>Name</th>
                <th>Role</th>
               
            </tr>
        </thead>
        <tbody>
            
            <tr class="search">
     
            <td>
                <input v-model="filter.userId" type="text" id="userId">
            </td>
            <td>
                <input v-model="filter.username" type="text" id="username">
            </td>
            <td>
                <input v-model="filter.name" type="text" id="name">
            </td>
            <td>
                <input v-model="filter.role" type="text" id="role">
            </td>
            
            <td>
                <p></p>
            </td>
            <td>
                <p></p>
            </td>
            </tr>
            
            <tr
            v-for="user in filteredList"
            v-bind:key="user.userId"
            v-bind:user="user"
            >
           
                <td>{{ user.id }}</td>
                <td>{{ user.username }}</td>
                <td>{{ user.name }}</td>
                <td>{{ user.role }}</td>
                
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
            selectedUserIds: [],
            filter: {
                userId: "",
                username: "",
                name: "",
                role: ""
            }
        }
    },
    created() {
       this.refresh();
    },
    computed: {
        users(){
            return this.$store.state.users;
        },
        filteredList(){
            let filteredUsers = this.$store.state.users;
            if(this.filter.userId != ""){
                filteredUsers = filteredUsers.filter((user) =>
                    user.id.includes(this.filter.userId)
                )
            }
            if(this.filter.username != ""){
                filteredUsers = filteredUsers.filter((user) => 
                    user.username.toLowerCase().includes(this.filter.username.toLowerCase())
                )
            }
            if(this.filter.name != ""){
                filteredUsers = filteredUsers.filter((user) =>
                user.name.includes(this.filter.name)
                )
            }
            if(this.filter.role != ""){
                filteredUsers = filteredUsers.filter((user) => 
                    user.role.includes(this.filter.role)
                )
            }

            return filteredUsers;
        }
    },
    methods: {
        refresh(){
            ApplicationService.getUsers().then(
                (response) => {
                    this.$store.commit("SET_USERS", response.data)
                }
            )
        }
    }
}
</script>

<style>

</style>