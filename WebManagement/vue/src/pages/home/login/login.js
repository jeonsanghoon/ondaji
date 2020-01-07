
import Vue from 'vue'
import App from './login.vue'
import vuetify from "@/plugins/vuetify"


Vue.config.productionTip = false
Vue.config.devtools = true;
new Vue({
  vuetify,
  render: h => h(App),
}).$mount('#app')
