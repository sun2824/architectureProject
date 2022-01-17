const initialState = () => ({
    isSmallCardMounted: true,
    isRealtimeAgeMounted: true,
    twentyChartData: [],
    thirtyChartData: [],
    fortyChartData: [],
    fiftyChartData: [],
})

export default {
    namespaced: true,
    state: initialState,
    getters: {
        getIsSmallCardMounted: state => state.isSmallCardMounted,
        getIsRealtimeAgeMounted: state => state.isRealtimeAgeMounted
    },
    mutations: {
        updateState(state, payload) {
            // key 배열로 반환됨
            Object.keys(payload).forEach(key => {
                state[key] = payload[key]
            })
        }
    },
    actions: {
        test({commit}, payload){
            console.log('test');
            commit('updateState', payload);
        },
        selectMenu({commit}, payload){
            commit('updateState', payload);
        }
    }
}