<template>
	<v-app id="app">
		<v-content>
			<v-container class="fill-height" fluid>
				<v-row align="center" justify="center">
					<v-col cols="12" sm="8" md="4">
						<v-alert :color="type" icon="check_circle" :value="value" v-if="type">
							{{loginmessage}}
						</v-alert>
						<v-card class="elevation-12">
							<v-toolbar color="primary" dark flat>
								<v-toolbar-title>로그인</v-toolbar-title>
								<v-spacer />
							</v-toolbar>
							<form action="/member/logindo" method="post">
								<v-card-text>
									<v-text-field v-model="member_id" label="Login" id="member_id" name="member_id" prepend-icon="person" type="text" />
									<v-text-field v-model="member_pw" id="memer_pw" label="Password" name="memer_pw" prepend-icon="lock" type="password" />
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
				<v-row align="center" justify="center">
					<v-col cols="12" sm="8" md="4">
							<v-textarea filled auto-grow label="리턴 데이터" rows="4" row-height="30" shaped v-model="messagedata"></v-textarea>
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

		beforeCreate() {
			this.drawer = false;

			axios.post('/member/getmyinfo').then(res => { 
				// eslint-disable-next-line no-debugger
				debugger;
				if (!(res === null || res.data === null)) {
					this.loginmessage = res.data.member_name + "님이 로그인 되어있습니다." 
					this.type = "success"
					this.value = true;
					this.messagedata = JSON.stringify(res.data);
					//this.$router.push('/') ;
				}
				else{
					this.messagedata="";
				}
					
			})
		},
		created() {

		},
		data() {
			return {
				msg: "로그인페이지"
				, member_id: ""
				, member_pw: ""
				, drawer: false
				, type: "error"
				, value: false
				, loginmessage: "로그인에 성공하였습니다."
				,messagedata:""
			}
		},
		methods: {
			formclear: function () {

				this.member_id = "";
				this.member_pw = "";
			}, login() {

				axios.post('/member/logindo', { member_id: this.member_id, member_pw: this.member_pw }).then(res => {
					// eslint-disable-next-line no-debugger
					debugger;
					if (res === null || res.data === null || res.data.member === undefined || res.data.member === null) {
						this.value = true;
						this.loginmessage = "로그인정보가 잘못되었습니다. \n다시 입력하세요"
						this.type = "warning"
						this.messagedata="";

					}
					else {
						this.loginmessage = res.data.member.member_name + "님이 로그인에 성공하였습니다."
						this.type = "success"
						this.value = true;

						this.messagedata = JSON.stringify(res.data);

						//this.$router.push('/') ;

					}

				})
			}
		}, compute: {

		}
	}
</script>
<style lang="scss">
	@import "@/assets/styles/Common.scss";
</style>
