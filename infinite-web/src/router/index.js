import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import CosplayWeb from '@/components/CosplayWeb'

import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.use(Router);
Vue.use(ElementUI);
Vue.use(VueAxios,axios);

axios.defaults.baseURL="http://localhost:7000";

export default new Router({
  routes: [
    {path: '/', name: 'CosplayWeb', component: CosplayWeb}
  ]
})
