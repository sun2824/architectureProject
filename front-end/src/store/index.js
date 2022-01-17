import Vue from 'vue'
import Vuex from 'vuex'
import createPersistedState from "vuex-persistedstate"

import base from './base'
import login from './auth/login'
import dashboard from "@/store/dashboard/dashboard"
import token from './auth/token'

Vue.use(Vuex)

const modules = {
    base,
    login,
    token,
    dashboard,
}

const store = new Vuex.Store({
    modules,
    plugins: [
        createPersistedState({
            paths: Object.keys(modules)
        })
    ],
})

export default store