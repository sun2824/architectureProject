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
              :chart-data="twentyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="30대"
              today-cnt="12"
              :chart-data="thirtyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="40대"
              today-cnt="12"
              :chart-data="fortyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="50대"
              today-cnt="12"
              :chart-data="fiftyChartData"
          ></small-card-layout>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="12">
          <gender-card-layout
              card-title="당일 등급별 구매금액"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></gender-card-layout>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="12">
          <age-card-layout
              card-title="당일 회원 등급별 회원수"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></age-card-layout>
        </v-col>
<!--        <v-col md="12">
          <realtime-age-card-layout
              card-title="연령대 별 구매 현황"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></realtime-age-card-layout>
        </v-col>-->
      </v-row>
    </v-flex>
  </v-app>
</template>

<script>
import SmallCardLayout from "@/layout/dashboard/card/SmallCardLayout"
import AgeCardLayout from "@/layout/dashboard/card/AgeCardLayout"
import GenderCardLayout from "@/layout/dashboard/card/GenderCardLayout"
/*import RealtimeAgeCardLayout from "@/layout/dashboard/card/RealtimeAgeCardLayout";*/
import SockJs from "sockjs-client"
import Stomp from "webstomp-client"

import {mapState} from "vuex"
import Vue from 'vue'

export default {
  name: "Dashboard",
  components: {
    SmallCardLayout,
    AgeCardLayout,
    GenderCardLayout/*,
    RealtimeAgeCardLayout*/
  },
  mounted() {

    setInterval( () => {
      let socketJs = new SockJs(process.env.DASHBOARD_REQUEST_URL+'/ws'), stompClient = Stomp.over(socketJs);
      let isStompClient = typeof(this.$stompClient) === undefined ? null : this.$stompClient;

      if(isStompClient === undefined || isStompClient === null || !isStompClient.connected){
        stompClient.connect(
            {id: 'dashboardData', host: 'dashboardData'},
            frame => {
              Vue.prototype.$stompClient = stompClient;

              this.$store.dispatch("/dashboard/getDashboardDatas", stompClient);

              frame;
            }
        )
      }

    }, 1000*10)
  },
  computed: {
    ...mapState({
      twentyChartData: state => state.dashboard.twentyChartData,
      thirtyChartData: state => state.dashboard.thirtyChartData,
      fortyChartData: state => state.dashboard.fortyChartData,
      fiftyChartData: state => state.dashboard.fiftyChartData,
    })
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