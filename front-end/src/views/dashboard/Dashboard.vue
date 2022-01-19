<template>
  <v-app class="small-card-row-margin">
    <!--      <ProgressCircular :loading="loading" :top="40" />-->

    <v-flex>
      <v-row xs12>
        <v-col md="12">
          <h2>Dashboard</h2>
        </v-col>
        <v-col md="12" style="margin-top:-15px; margin-bottom:-10px;">
          <h4 style="color:grey;">일주일 간 연령별 회원수</h4>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="3">
          <small-card-layout
              card-title="20대"
              today-cnt="12"
              :chart-series="twentySeries"
              :chart-line-options="twentyLineOptions"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="30대"
              today-cnt="12"
              :chart-series="thirtySeries"
              :chart-line-options="thirtyLineOptions"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="40대"
              today-cnt="12"
              :chart-series="fortySeries"
              :chart-line-options="fortyLineOptions"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="50대"
              today-cnt="12"
              :chart-series="fiftySeries"
              :chart-line-options="fiftyLineOptions"
          ></small-card-layout>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="12">
          <daily-purchase-price-layout
              card-title="당일 등급별 구매금액"
              today-cnt="12"
          ></daily-purchase-price-layout>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="12">
          <daily-customer-grade-card-layout
              card-title="당일 회원 등급별 회원수"
              today-cnt="12"
          ></daily-customer-grade-card-layout>
        </v-col>
        <!--        <v-col md="12">
                  <realtime-age-card-layout
                      card-title="연령대 별 구매 현황"
                      today-cnt="12"
                      :chart-data="twentySeries"
                  ></realtime-age-card-layout>
                </v-col>-->
      </v-row>
    </v-flex>
  </v-app>
</template>

<script>
import SmallCardLayout from "@/layout/dashboard/card/SmallCardLayout"
import DailyCustomerGradeCardLayout from "@/layout/dashboard/card/DailyCustomerGradeCardLayout"
import DailyPurchasePriceLayout from "@/layout/dashboard/card/DailyPurchasePriceLayout"
/*import RealtimeAgeCardLayout from "@/layout/dashboard/card/RealtimeAgeCardLayout";*/
import SockJs from "sockjs-client"
import Stomp from "webstomp-client"

import {mapState} from "vuex"
import Vue from 'vue'

export default {
  name: "Dashboard",
  components: {
    SmallCardLayout,
    DailyCustomerGradeCardLayout,
    DailyPurchasePriceLayout/*,
    RealtimeAgeCardLayout*/
  },
  mounted() {

    let socketJs = new SockJs(process.env.VUE_APP_DASHBOARD_REQUEST_URL + '/ws'), stompClient = Stomp.over(socketJs);
    let isStompClient = typeof (this.$stompClient) === undefined ? null : this.$stompClient;

    if (isStompClient === undefined || isStompClient === null || !isStompClient.connected) {
      stompClient.connect(
          {id: 'dashboardDatas', host: 'dashboardDatas'},
          frame => {
            Vue.prototype.$stompClient = stompClient;

            this.$store.dispatch("dashboard/getDashboardDatas", stompClient);

            frame;
          }
      )
    } else {
      this.$store.dispatch("dashboard/getDashboardDatas", stompClient);
    }

    setInterval(() => {
      let socketJs = new SockJs(process.env.VUE_APP_DASHBOARD_REQUEST_URL + '/ws'), stompClient = Stomp.over(socketJs);
      let isStompClient = typeof (this.$stompClient) === undefined ? null : this.$stompClient;

      if (isStompClient === undefined || isStompClient === null || !isStompClient.connected) {
        stompClient.connect(
            {id: 'dashboardData', host: 'dashboardData'},
            frame => {
              Vue.prototype.$stompClient = stompClient;

              this.$store.dispatch("dashboard/getDashboardDatas", stompClient);

              frame;
            }
        )
      }

    }, 1000 * 10)
  },
  computed: {
    ...mapState({
      twentySeries: state => state.dashboard.twentySeries,
      twentyLineOptions: state => state.dashboard.twentyLineOptions,
      thirtySeries: state => state.dashboard.thirtySeries,
      thirtyLineOptions: state => state.dashboard.thirtyLineOptions,
      fortySeries: state => state.dashboard.fortySeries,
      fortyLineOptions: state => state.dashboard.fortyLineOptions,
      fiftySeries: state => state.dashboard.fiftySeries,
      fiftyLineOptions: state => state.dashboard.fiftyLineOptions,
    }),
  }
};
</script>

<style>
.small-card-row-margin {
  padding-left: 6%;
  padding-top: 2%;
  padding-right: 6%;
}
</style>