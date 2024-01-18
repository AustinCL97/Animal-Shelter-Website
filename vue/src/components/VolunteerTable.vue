<template>
  <div class="container">
    <table id="volunteers">
        <thead>
            <tr>
                <th>Name</th>

                <th>Email</th>
                <th>Phone Number</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <tr>
            <td>
                <input type="checkbox" id="select-all">
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
            v-for="volunteer in volunteers"
            v-bind:key="volunteer.userId"
            v-bind:volunteer="volunteer"
            >
                <td></td>
            </tr>
        </tbody>
    </table>
  </div>
</template>

<script>
export default {
    created() {

    },
    computed: {
        volunteers(){
            return this.$store.state.volunteers;
        }
    }
}
</script>

<style>

</style>