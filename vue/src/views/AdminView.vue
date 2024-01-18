<template>
    <div>
        <!--DONE - As a volunteer, I want a listing of other volunteers and admins with contact info.-->
        <!--As an admin, I want to see all pending volunteer applications and have the option to approve or decline them.
        Approving an application should create a new volunteer user (who will then be able to login).
        Declining an application should remove the application from list of pending applications, but not remove the data from the database.-->
        <!--As an admin, I want to be able to search all applications (pending, approved and declined) by name-->
        <!--As a volunteer or administrator, I want the ability to update all information about a pet, including the photo.-->
        <!--When a pet has been adopted, I need to be able to add information about who adopted it, and change its status so the listing 
        no longer appears in the list of available pets (but the data should remain in the database).-->
        <!--As an admin, I want to be able to promote a volunteer to also be an admin.-->
        <!--Email Approved/Declined Volunteers-->
        <div>Volunteer and Admin List</div>
        <ul>
            <li v-for="user in users" :key="user.id">
                {{ user.name }} {{ user.contactInfo }} {{user.status }}
                <button v-if="user.status === 'pending'" v-on:click="approveUser(user.id)">Approve</button>
                <button v-if="user.status === 'pending'" v-on:click="denyUser(user.id)">Deny</button>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data(){
        return {
            users: [],
        }
    },
    methods: {
        approveUser(userId){
            const userToApprove = this.users.find(user => user.id === userId);

            if(userToApprove){
                userToApprove.status = 'approved';
                console.log('User Approved: ' + userId)
            }
        },
        denyUser(userId){
            const userToDeny = this.user.find(user => user.id === userId);

            if(userToDeny){
                userToDeny.status = 'denied'
                console.log('User Denied:' + userId)
            }
        }
    }
}
</script>

<style></style>