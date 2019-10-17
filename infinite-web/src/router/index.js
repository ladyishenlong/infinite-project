import Vue from 'vue'
import Router from 'vue-router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'

import NewsWeb from "@/components/NewsWeb";
import HomeWeb from "@/components/HomeWeb";
import CosplayWeb from '@/components/CosplayWeb'


Vue.use(Router);
Vue.use(ElementUI);
Vue.use(VueAxios,axios);

axios.defaults.baseURL="http://localhost:7000";

export default new Router({
  routes: [
    {path: '/', name: 'HomeWeb', component: HomeWeb},
    {path: '/newsWeb', name: 'NewsWeb', component: NewsWeb},
    {path: '/cosplayWeb', name: 'CosplayWeb', component: CosplayWeb}
  ]
})
