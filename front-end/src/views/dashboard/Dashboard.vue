<template>
  <v-app class="small-card-row-margin">
      <!--      <ProgressCircular :loading="loading" :top="40" />-->

    <v-flex>
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
          <realtime-age-card-layout
              card-title="실시간 연령대별 회원수"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></realtime-age-card-layout>
        </v-col>
      </v-row>
      <v-row xs12>
        <v-col md="6">
          <age-card-layout
              card-title="연령대별 회원수"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></age-card-layout>
        </v-col>
        <v-col md="6">
          <gender-card-layout
              card-title="성별별 구매금액"
              today-cnt="12"
              :chart-data="twentyChartData"
          ></gender-card-layout>
        </v-col>
      </v-row>
    </v-flex>
  </v-app>
</template>

<script>
import SmallCardLayout from "@/layout/dashboard/card/SmallCardLayout"
import AgeCardLayout from "@/layout/dashboard/card/AgeCardLayout"
import GenderCardLayout from "@/layout/dashboard/card/GenderCardLayout"
import RealtimeAgeCardLayout from "@/layout/dashboard/card/RealtimeAgeCardLayout";

import {mapState} from "vuex"

export default {
  name: "Dashboard",
  components: {
    SmallCardLayout,
    AgeCardLayout,
    GenderCardLayout,
    RealtimeAgeCardLayout
  },
  mounted() {
  },
  computed:{
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
.small-card-row-margin{
  padding-left: 6%;
  padding-top: 4%;
  padding-right: 6%;
}
</style>