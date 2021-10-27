import Vue from 'vue';
import App from './App.vue';
import router from './router/router.js';
import store from '@/store/store';
import moment from 'vue-moment';
import vue2Swiper from 'vue2-swiper';
import Antd from 'ant-design-vue';
import 'ant-design-vue/dist/antd.css';
import i18n from './i18n/i18n-config.js'
import  filters  from './filter/filter';

// register plugin components
// import './globalPlugin';

Vue.config.productionTip = false;

Vue.use(vue2Swiper);
Vue.use(Antd);
Vue.use(moment);

new Vue({
  router,
  store,
  i18n,
  filters,
  render: h => h(App),
}).$mount('#app')
