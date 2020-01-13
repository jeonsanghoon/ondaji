import Vue from 'vue'
import App from './templeate01.vue'
import vuetify from './node_modules/@/plugins/vuetify';

Vue.config.productionTip = false
Vue.config.devtools = true;
new Vue({
  vuetify,
  render: h => h(App),
}).$mount('#app')
