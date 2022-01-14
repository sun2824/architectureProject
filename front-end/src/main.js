import Vue from 'vue'
import App from './App.vue'
import router from './routes'
import store from './store'
import Vuetify from "vuetify";
import vuetify from './plugins/vuetify'

Vue.use(Vuetify)
Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  store,
  vuetify
}).$mount('#app')

