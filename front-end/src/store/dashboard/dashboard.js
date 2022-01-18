const initialState = () => ({
    isSmallCardMounted: true,
    isGradeDataMounted: true,
    isRealtimeAgeMounted: true,
    isGradeCostDataMounted: true,
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
        getIsRealtimeAgeMounted: state => state.isRealtimeAgeMounted,
        getIsGradeDataMounted: state => state.isGradeDataMounted,
        getIsGradeCostDataMounted: state => state.isGradeCostDataMounted
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
        test({commit}, payload) {
            console.log('test');
            commit('updateState', payload);
        },
        selectMenu({commit}, payload) {
            commit('updateState', payload);
        },
        getDashboardDatas({commit}, payload) {
            let stompClient = payload;
            stompClient.subscribe('/topic/dashboardDatas',
                res => {
                    let data = JSON.parse(res.body);

                    let payload = {};

                    payload.pageUrl = '/dashboard';

                    console.log(data);

                    commit;
                }
            );
        }
    }
}