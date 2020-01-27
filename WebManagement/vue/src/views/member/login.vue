<template>
  <v-container fill-height>
    <v-row justify="center" align="center">
      <v-col cols="12" lg="4" sm="6">
        <v-alert :color="type" icon="check_circle" :value="value" v-if="type">
          {{ loginmessage }}
        </v-alert>
        <v-card class="elevation-12">
          <v-toolbar color="primary" dark flat>
            <v-toolbar-title><h3>로그인</h3></v-toolbar-title>
            <v-spacer />
          </v-toolbar>
          <form action="/member/logindo" method="post" class=" pb-3 pl-2 pr-2">
            <v-card-text>
              <v-text-field
                v-model="member_id"
                label="아이디"
                id="member_id"
                name="member_id"
                ref="member_id"
                autofocus
                prepend-icon="person"
                type="text"
                v-on:keyup.enter="login"
              />
              <v-text-field
                v-model="member_pw"
                label="암호"
                id="memer_pw"
                name="memer_pw"
                ref="member_pw"
                prepend-icon="lock"
                type="password"
                v-on:keyup.enter="login"
              />
              
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn color="primary" class="mr-4" @click="login">로그인</v-btn>
              <v-btn @click="formclear">초기화</v-btn>
            
            </v-card-actions>
          </form>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import ax from 'axios'
export const axios = ax

import { BaseCommon } from '@/assets/scripts/Common'


export default {
  
  data () {
    return {
      msg: '로그인페이지',
      member_id: '',
      member_pw: '',
      drawer: false,
      type: 'error',
      value: false,
      loginmessage: '로그인에 성공하였습니다.',
      messagedata: '',
      isShowBar: false
    }
  },
  mounted () {
    this.$store.watch(() => {
      BaseCommon.SettingInfo.setIsShowBar(false)
    })
  },
  beforeCreate () {},
  methods: {
    formclear: function () {
      this.member_id = ''
      this.member_pw = ''
    },
    checkLogin () {
      console.log(this.member_id)
      if (this.member_id === '') {
        this.type = 'warning'
        this.value = true
        this.loginmessage = '아이디를를 입력하세요'
        this.$refs.member_id.focus()
        this.$refs.member_id.select()
        return false
      }
      if (this.member_pw === '') {
        this.type = 'warning'
        this.value = true
        this.loginmessage = '암호를 입력하세요'
        this.$refs.member_pw.focus()
        this.$refs.member_id.select()
        return false
      }
      this.type = 'warning'
      this.value = false
      return true
    },
    login () {
      if (!this.checkLogin()) return
      BaseCommon.restful
        .Call('/member/logindo', {
          member_id: this.member_id,
          member_pw: this.member_pw
        })
        .then(res => {
          // eslint-disable-next-line no-debugger

          if (res === null || res.member === undefined || res.member === null) {
            this.value = true
            this.loginmessage = '로그인정보가 잘못되었습니다. \n다시 입력하세요'
            this.type = 'warning'
            BaseCommon.MemberInfo.setMember(null)
          } else {
            this.loginmessage =
              res.member.member_name + '님이 로그인에 성공하였습니다.'
            this.type = 'success'
            this.value = true
            BaseCommon.MemberInfo.setMember(res.member)

            this.$router.push('/')
          }
        })
    }
  }
}
</script>
<style lang="scss">
@import '@/assets/styles/Common.scss';
html {
  html {
    overflow-y: none !important;
  }
}
</style>
