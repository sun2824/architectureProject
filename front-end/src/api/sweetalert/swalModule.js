import swal from 'sweetalert'
import store from '~/store'

export default {
    errorAlert: message => {
        if (store.getters['base/getShowAlert']) {
            swal({
                icon: 'error',
                title: message,
                buttons: {
                    cancel: false,
                    confirm: false,
                },
                timer: 1000
            })
        } else {
            return "alert false"
        }
    },
    successAlert: message => {
        if (store.getters['base/getShowAlert']) {
            swal({
                icon: 'success',
                title: message,
                buttons: {
                    cancel: false,
                    confirm: false,
                },
                timer: 1000
            })
        } else {
            return "alert false"
        }
    },
    warningAlert: message => {
        if (store.getters['base/getShowAlert']) {
            swal({
                icon: 'warning',
                title: message,
                buttons: {
                    cancel: false,
                    confirm: false,
                },
                timer: 1000
            })
        } else {
            return "alert false"
        }
    },
    timerClkAlert: function ({ icon, title, text, type, timer }) {
        let fire = {};
        if (store.getters['base/getShowAlert']) {
            if (type) {
                // tpye : true 일 경우 [확인,취소] 버튼 사용 ]
                fire = swal({
                    icon,
                    title,
                    text,
                    buttons: {
                        cancel: "취소",
                        confirm: "확인",
                    },
                    closeOnClickOutside: false,
                    timer,
                })
            } else {
                // tpye : false 일 경우 [확인] 버튼 사용 ]
                fire = swal({
                    icon,
                    title,
                    text,
                    buttons: {
                        cancel: false,
                        confirm: "확인",
                    },
                    closeOnClickOutside: false,
                    timer,
                })
            }
            return fire
        } else {
            return "alert false"
        }
    },
    clkAlert: function ({ icon, title, text, type }) {
        let fire = {};
        if (type) {
            // tpye : true 일 경우 [확인,취소] 버튼 사용 ]
            fire = swal({
                icon,
                title,
                text,
                buttons: {
                    cancel: "취소",
                    confirm: "확인",
                },
            })
        } else {
            // tpye : false 일 경우 [확인] 버튼 사용 ]
            fire = swal({
                icon,
                title,
                text,
                buttons: {
                    cancel: false,
                    confirm: "확인",
                },
            })
        }
        return fire
    },
    nonClkAlert: ({ icon, title, text }) => {
        // icon : success , error 등..
        // title : 알림 메세지
        if (store.getters['base/getShowAlert']) {
            swal({
                icon,
                title,
                text,
                buttons: {
                    cancel: false,
                    confirm: false,
                },
                timer: 1000
            })
        } else {
            return "alert false"
        }
    },

}
