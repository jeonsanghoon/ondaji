
<template>
  <v-app id="app">
   

    <v-content>
      <v-container
        class="fill-height"
        fluid
      >
        <v-row
          align="center"
          justify="center"
        >
          <v-col class="text-center">
      
               <router-view/>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer
      color="indigo"
      app
       v-if=isShowBar
    >
      <span class="white--text">&copy; 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import store from "./store";
  export default {
    props: {
      source: String,
      isShowBar:String
    },
    data: () => ({
     
     
     })
    ,
	created(){
     console.log("store from $store", this.$store);
    console.log("store from store: ", store);
   
  }
     ,method:()=>({
          
    }),
     computed: {
     
     }
  }
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
