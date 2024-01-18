<template>
  <div>
    <form>
        <div>
            <label>Photo URL:</label>
            <input type="text">
        </div>
        <div>
            <label>Pet ID</label>
            <input type="text">
        </div>
        <input type="submit">
    </form>
  </div>
</template>

<script>
export default {
   return: {
        data(){
            newPhoto: {}
        }
   }
}
</script>

<style>

</style>