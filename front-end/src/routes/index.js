import AuthLayout from '~/layout/auth/Index'

import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '~/layout/base/Index'
import Login from '~/views/auth/Login'
import Dashboard from "~/views/dashboard/Dashboard";
import NotFound from '~/views/NotFound'

Vue.use(VueRouter)

function homeChildren() {
    return [
        {
            name: "대시보드",
            path: "dashboard",
            component: Dashboard
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
        },
        {
            path: '*',
            component: NotFound
        }
    ]
})

export default router