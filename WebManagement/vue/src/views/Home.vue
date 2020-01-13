<template>

  <div class="home">
    <mainmenu />
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import mainmenu from './../components/mainmenu'
export default {

  name: 'home',
  components: {
    HelloWorld,
    mainmenu
  }
}
</script>
