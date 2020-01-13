import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/member/about',
    name: 'about1',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'
    
    )
  },
  {
    path: '/member/login',
    name: '로그인',
    
    component: () => import(/* webpackChunkName: "about" */ '../views/home/login.vue' )
  },
  {
    path: '/temp/temp01',
    name: '템플릿',
    
    component: () => import(/* webpackChunkName: "about" */ '../views/temp/templeate01.vue' )
    

  }
]

const router = new VueRouter({
  mode: 'history',
  routes
})

export default router
