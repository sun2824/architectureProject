const initialState = () => ({
    token: null,
    refToken: null,

    decodeTokenTime: null,  // 토큰 만료되는 시간 저장
    decodeRefTokenTime: null, // 리프레쉬 토큰 만료되는 시간 저장

    tokenExpTime: null,  // 토큰 타이머
    refTokenExpTime: null, // 리프레쉬 타이머

    tokenInterval: "", // 토큰 인터벌-타이머 초기화를 위한 객체
    tokenRefInterval: "", // 리프레쉬 토큰 인터벌-타이머 초기화를 위한 객체

    isTokenCheck: false, // 토큰 체크 유무
    tokenCheckInterval: "", // 토큰 유효성(1분?) 체크 인터벌 객체

    selectedMenu: {},

    showAlert: true,
})

export default {
    namespaced: true,
    state: initialState,
    getters: {
        getShowAlert: state => state.showAlert,
        getSelectedMenu: state => state.selectedMenu
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