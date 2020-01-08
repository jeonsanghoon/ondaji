
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
          <v-col
            cols="12"
            sm="8"
            md="4"
          >
            <v-card class="elevation-12">
              <v-toolbar
                color="primary"
                dark
                flat
              >
                <v-toolbar-title>로그인</v-toolbar-title>
                <v-spacer />
                </v-toolbar>
                    <form action="/member/logindo" method="post">
              <v-card-text>
            
                  <v-text-field
                    v-model="member_id"
                    label="Login"
                    id="member_id"
                    name="member_id"
                    
                    prepend-icon="person"
                    type="text"
                  />

                  <v-text-field
                    v-model="member_pw"
                    id="memer_pw"
                    label="Password"
                    name="memer_pw"
                    prepend-icon="lock"
                    type="password"
                  />
              
              </v-card-text>
              <v-card-actions>
                <v-spacer />
                <v-btn color=primary class="mr-4" @click="login">로그인</v-btn>
                <v-btn @click="formclear">초기화</v-btn>
              </v-card-actions>
                </form>
            </v-card>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
  </v-app>
</template>


<script>
import ax from 'axios';
export const axios = ax

   
export default {
  
  data() {
    return{
     msg:"로그인페이지"
     ,member_id:""
     ,member_pw:""
    }
  },
  methods:{
    formclear:function(){
      
      this.member_id="";
      this.member_pw="";
    },login(){
      axios.post('/member/dologin', {member_id: this.member_id,member_pw:this.member_pw}) .then(res => { console.log(res.data) })
    }
  },compute:{

 
  }
}
</script>
<style lang="scss">
  @import "@/assets/styles/Common.scss";
</style>

