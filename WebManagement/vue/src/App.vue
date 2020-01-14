
<template>
  <v-app id="app">
   <v-dialog v-model="loading" fullscreen >
  <v-container fluid fill-height style="background-color: rgba(255, 255, 255, 0.5);">
    <v-layout justify-center align-center>
      <v-progress-circular
        indeterminate
        color="primary">
      </v-progress-circular>
    </v-layout>
  </v-container>
</v-dialog>
<mainmenu />
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


import mainmenu from '@/components/mainmenu'
import {BaseCommon} from '@/assets/scripts/Common';
  export default {
    components: {
      mainmenu
    },
    data: () => ({
      loading:false,
      isShowBar:true
     })
    ,
	beforecreated(){
      BaseCommon.restful.Call('/member/getmyinfo').then(res => { 
        // eslint-disable-next-line no-debugger
          if(!(res===null || res ==="" )) this.$store.dispatch('baseStore/setMemberInfo',null);
          else this.$store.dispatch('baseStore/setMemberInfo',res);
      });
     
   
  },
    mounted() {
        this.$store.watch(()=>{
        this.loading = this.$store.getters['baseStore/getIsLoading'];
        this.isShowBar = this.$store.getters['baseStore/getIsShowBar'];             
      })
       
  
    }
     ,method:()=>({
          
    }),computed:{
        
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
