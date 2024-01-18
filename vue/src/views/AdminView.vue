<template>
    <div class="admin-container">
        <!--As an admin, I want to see all pending volunteer applications and have the option to approve or decline them.
        Approving an application should create a new volunteer user (who will then be able to login).
        DONE - Declining an application should remove the application from list of pending applications, but not remove the data from the database.-->
        <!--As an admin, I want to be able to search all applications (pending, approved and declined) by name-->
        <!--STACI - As a volunteer or administrator, I want the ability to update all information about a pet, including the photo.-->
        <!--When a pet has been adopted, I need to be able to add information about who adopted it, and change its status so the listing 
        no longer appears in the list of available pets (but the data should remain in the database).-->
        <!--As an admin, I want to be able to promote a volunteer to also be an admin.-->
        <!--Email Approved/Declined Volunteers-->
        <div>Volunteer and Admin List
            <VolunteerTable></VolunteerTable>
        </div>

        <div>
            <div>Add Pet</div>
            <new-pet-form></new-pet-form>
        </div>


        <div>Update Pet</div>
        <!--create update pet card-->

        <div>User/Admin Management</div>
        <!--second table to VIEW who the admins are - admin only status-->

    </div>
</template>

<script>
import NewPetForm from '../components/NewPetForm.vue'
import VolunteerTable from '../components/VolunteerTable.vue'

export default {
    components: {
        NewPetForm,
        VolunteerTable
    },
    data() {
        return {
            users: [],
        }
    },



}
</script>

<style>
.admin-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;

}
</style>