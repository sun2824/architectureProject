import AuthLayout from '~/layout/auth/Index'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '~/views/Home'
import Login from '~/views/auth/Login'

Vue.use(VueRouter)

function homeChildren() {
    return [
        {
            name: "대시보드",
            path: "dashboard"
        }
    ];
}

function authChildren(){
    return [
        {
            path: "login",
            component: Login,
            alias: "/login"
        }
    ]
}

const router = new VueRouter({
    mode: "history",
    routes: [
        {
            name: 'home',
            path: '/',
            component: Home,
            children: homeChildren()
        },
        {
            name: 'auth',
            path: '/auth',
            component: AuthLayout,
            children: authChildren()
        }
    ]
})

export default router