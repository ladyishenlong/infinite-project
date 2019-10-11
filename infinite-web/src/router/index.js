import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Cosplay from '@/components/Cosplay'
import iView from 'iview';
import 'iview/dist/styles/iview.css';

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(Router);
Vue.use(iView);
Vue.use(VueAxios,axios);

// axios.defaults.baseURL="http://localhost:7000";

export default new Router({
  routes: [
    {path: '/', name: 'Cosplay', component: Cosplay}
  ]
})
