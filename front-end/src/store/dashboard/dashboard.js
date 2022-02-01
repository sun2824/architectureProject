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

function weeklyCustomerCnt(commit, data) {

    let twentyLabel = Array();
    let twentyDatas = Array();

    data['20'].forEach(item => {
        Object.keys(item).forEach(key => {
            twentyLabel.push(key);
            twentyDatas.push(item[key]);
        });
    });

    let twentyLineOptions = {
        chart: {
            id: '',
            group: 'sparklines',
            type: 'line',
            sparkline: {
                enabled: true
            },
            animations: {
                enabled: true,
                easing: 'linear',
                dynamicAnimation: {
                    speed: 1000
                }
            }
        },
        stroke: {
            curve: 'smooth'
        },
        fill: {
            opacity: 1,
        },
        xaxis: {
            categories:
            twentyLabel
        }
    };

    let twentySeries = [{
        name: "회원 수",
        data: twentyDatas
    }];

    let thirtyLabel = Array();
    let thirtyDatas = Array();

    data['30'].forEach(item => {
        Object.keys(item).forEach(key => {
            thirtyLabel.push(key);
            thirtyDatas.push(item[key])
        });
    });

    let thirtyLineOptions = {
        chart: {
            id: '',
            group: 'sparklines',
            type: 'line',
            sparkline: {
                enabled: true
            },
            animations: {
                enabled: true,
                easing: 'linear',
                dynamicAnimation: {
                    speed: 1000
                }
            }
        },
        stroke: {
            curve: 'smooth'
        },
        fill: {
            opacity: 1,
        },
        xaxis: {
            categories:
            thirtyLabel
        }
    };

    let thirtySeries = [{
        name: "회원 수",
        data: thirtyDatas
    }];

    let fortyLabel = Array();
    let fortyDatas = Array();

    data['40'].forEach(item => {
        Object.keys(item).forEach(key => {
            fortyLabel.push(key);
            fortyDatas.push(item[key])
        });
    });


    let fortyLineOptions = {
        chart: {
            id: '',
            group: 'sparklines',
            type: 'line',
            sparkline: {
                enabled: true
            },
            animations: {
                enabled: true,
                easing: 'linear',
                dynamicAnimation: {
                    speed: 1000
                }
            }
        },
        stroke: {
            curve: 'smooth'
        },
        fill: {
            opacity: 1,
        },
        xaxis: {
            categories:
            fortyLabel
        }
    };

    let fortySeries = [{
        name: "회원 수",
        data: fortyDatas
    }];

    let fiftyLabel = Array();
    let fiftyDatas = Array();

    data['50'].forEach(item => {
        Object.keys(item).forEach(key => {
            fiftyLabel.push(key);
            fiftyDatas.push(item[key])
        });
    });

    let fiftyLineOptions = {
        chart: {
            id: '',
            group: 'sparklines',
            type: 'line',
            sparkline: {
                enabled: true
            },
            animations: {
                enabled: true,
                easing: 'linear',
                dynamicAnimation: {
                    speed: 1000
                }
            }
        },
        stroke: {
            curve: 'smooth'
        },
        fill: {
            opacity: 1,
        },
        xaxis: {
            categories:
            fiftyLabel
        }
    };

    let fiftySeries = [{
        name: "회원 수",
        data: fiftyDatas
    }];

    commit('updateState', {
        twentySeries: twentySeries,
        twentyLineOptions: twentyLineOptions,
        thirtyLineOptions: thirtyLineOptions,
        thirtySeries: thirtySeries,
        fortySeries: fortySeries,
        fortyLineOptions: fortyLineOptions,
        fiftySeries: fiftySeries,
        fiftyLineOptions: fiftyLineOptions,
    })
}

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
        async getDashboardDatas({commit}, payload) {
            let stompClient = payload;

            console.log('getDashboardDatas')

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