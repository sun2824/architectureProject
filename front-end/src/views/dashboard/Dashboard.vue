<template>
  <v-app class="small-card-row-margin">
      <!--      <ProgressCircular :loading="loading" :top="40" />-->

      <v-row  xs12>
        <v-col md="3">
          <small-card-layout
            card-title="20대"
            today-cnt="12"
            :chart-data="twentyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="20대"
              today-cnt="12"
              :chart-data="thirtyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="20대"
              today-cnt="12"
              :chart-data="fortyChartData"
          ></small-card-layout>
        </v-col>
        <v-col md="3">
          <small-card-layout
              card-title="20대"
              today-cnt="12"
              :chart-data="fiftyChartData"
          ></small-card-layout>
        </v-col>
      </v-row>
  </v-app>
</template>

<script>
import SmallCardLayout from "@/layout/dashboard/card/smallCardLayout"
import {mapState} from "vuex"

export default {
  name: "Dashboard",
  components: {
    SmallCardLayout
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