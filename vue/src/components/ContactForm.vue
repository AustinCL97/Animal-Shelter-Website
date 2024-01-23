<template>
  
<form>
    
    <div class="main">
        <div class="second">
        <h2>Send us an email!</h2>
        <h5 v-on:click="copyToClipboard()">JustinParker@ParkersPets.com</h5>
        <label>Name </label>
            <input type="text" v-model="contactDetails.name" />
    
        <label>Email </label>
            <input type="text" v-model="contactDetails.email" />
    
        <label>Message </label>
            <textarea class="message" v-model="contactDetails.message" maxlength="500"></textarea>
            <button v-on:click.prevent id="send">Send</button>
        </div>
    </div>
</form>
</template>

<script>
export default {
    data(){
        return{
            contactDetails:{}
        }
    },
    methods: {
  copyToClipboard() {
    const textToCopy = this.$el.querySelector('h5').textContent; // Get text from the clicked element
    navigator.clipboard.writeText(textToCopy)
      .then(() => {
        alert('Text copied to clipboard!'); // Optional success message
      })
      .catch(err => {
        console.error('Failed to copy text: ', err);
      });
  }
}
}
</script>

<style scoped>
div{
    display: flex;
    flex-direction: column; 
    align-items: center;
    border: black 5px solid;
    margin: 20px;
    padding: 20px;
    border-radius: 50px;
}
p{
    color: rgb(238, 114, 20);
}

h1, h2{
    text-decoration: underline;
}
h2{
    padding: 0px;
    margin: 0px;
}
.message{
  width: 20vw;
  height: 10vh;
  text-align: left;
  resize: none;
  overflow: auto;
}
.main{
    background-color: rgb(157, 171, 134);
}
.second{
    background-color: rgb(222, 215, 177);
}
button{
    margin: 10px;
}

</style>