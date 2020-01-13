<template>
<div class="mainmenu">
  <v-container >
    <v-navigation-drawer
      v-model="drawer"
      app
      v-if=isShowBar
    >
      <v-list dense>
        <v-list-item  link to="/">
          <v-list-item-action>
            <v-icon>mdi-home</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>Home</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
        <v-list-item link to="/member/about">
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content>
            <v-list-item-title>About</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
         <v-list-item link to="/member/login" v-if=isLogin>
          <v-list-item-action>
            <v-icon>mdi-contact-mail</v-icon>
          </v-list-item-action>
          <v-list-item-content >
            <v-list-item-title>로그인</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar
      app
      color="indigo"
      dark
      v-if=isShowBar
    >
      <v-app-bar-nav-icon @click.stop="drawer = !drawer" />
      <v-toolbar-title>Application</v-toolbar-title>
      <v-spacer />
     {{myinfodisplay}}
          <v-menu bottom left>
            <template v-slot:activator="{ on }">
              <v-btn
                dark
                icon
                v-on="on"
              >
                <v-icon>mdi-dots-vertical</v-icon>
              </v-btn>
            </template>

            <v-list>
              <v-list-item
                v-for="(item, i) in items"
                :key="i"
                 @click="myMenuClick(item)"
              >
                <v-list-item-title>{{ item.title }}</v-list-item-title>
              </v-list-item>
            </v-list>
          </v-menu>
    </v-app-bar>
</v-container>
</div>
</template>

<script>
import {BaseCommon} from '@/assets/scripts/Common';

export default {
  name: 'mainmenu',
    data: () => ({
      drawer: null,
      isShowBar: true,
      isLogin:false
      ,items:[{title:"내정보",url:"/"},{title:"로그아웃",url:"-1"}]
      ,myinfodisplay:""
     }),
		beforeCreate() {
      BaseCommon.restful.Call('/member/getmyinfo').then(res => { 
        // eslint-disable-next-line no-debugger
        debugger;
         if(res!=null) {
           this.isLogin = false;
            this.myinfodisplay= res.member_name + " 님";
         } else this.isLogin =true;

      });
    },methods:{
      myMenuClick:function(item)
      {
        if(item.url ==="-1")
        {
          console.log("로그아웃");
          BaseCommon.restful.Call('/logout').then(res => { 
             console.log(res);
             this.$router.push("/member/login");
          });
        }
        else
          this.$router.push(item.url);
      }

    }
}
</script>