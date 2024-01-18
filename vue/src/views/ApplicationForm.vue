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
    import PetService from '../services/PetService.js'
    export default {
        data(){
            return{
                volunteer:{}
            }
        },
        methods: {
            createApplication()
        }
    };
    </script>
    
    <style>
    </style>