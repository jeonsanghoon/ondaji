import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    beforeRouteEnter :(to, from, next) =>{
      console.log("beforeRouteEnter");
      console.log(to);
      console.log(from);
      console.log(next);
      this.$store.dispatch('baseStore/setIsShowBar',true);
    },
    component: Home
  },
  {
    path: '/member/about',
    name: 'about1'
    ,
    beforeRouteEnter :(to, from, next) =>{
      console.log(to);
      console.log(from);
      console.log(next);
      console.log("beforeRouteEnter");
      this.$store.dispatch('baseStore/setIsShowBar',false);
    },
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'
  
    )
  },
  {
    path: '/member/login',
    name: '로그인' ,
    beforeRouteEnter :(to, from, next)=>{
      console.log(to);
      console.log(from);
      console.log(next);
      this.$store.dispatch('baseStore/setIsShowBar',false);
    },
    component: () => import(/* webpackChunkName: "about" */ '../views/member/login.vue' )
  },
  {
    path: '/temp/temp01',
    name: '템플릿',
    component: () => import(/* webpackChunkName: "about" */ '../views/temp/templeate01.vue' )
  }
  ,
  {
    path: '/temp/temp02',
    name: '템플릿',
    component: () => import(/* webpackChunkName: "about" */ '../views/temp/temp02.vue' )
  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
