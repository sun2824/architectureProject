<template>
  <v-card class="dashboard-card-class rounded-xl">
    <v-card-text >
      <v-icon style="font-size:40px !important;" class="small-card-icon-class">
        mdi-human-male-female
      </v-icon>
    </v-card-text>
    <v-card-actions style="margin-top: -16px; margin-left:8px;">
      <h3 class="card-small-title-class">{{ cardTitle }}</h3>
    </v-card-actions>
    <apexchart class="small-chart-margin"
        v-if="isSmallCardMounted"
        type="line"
        :width="width" height="54%" :options="chartLineOptions" :series="chartSeries"></apexchart>
  </v-card>
</template>

<script>
import apexchart from 'vue-apexcharts'
export default {
  name: "smallCardLayout",
  props:{
    cardTitle: {
      type: String
    },
    todayCnt: {
      type: String
    },
    chartSeries: {
      type: Array
    },
    chartLineOptions: {
      type: Object
    }
  },
  data(){
    return {
      width: '95%',
      series: [
        {
          name: "회원 수",
          data: this.chartData
        }
      ],
    }
  },
  components:{
    apexchart
  },
  computed:{
      isSmallCardMounted : {
        get(){
          return this.$store.getters['dashboard/getIsSmallCardMounted']
        }
      }
  }
}
</script>

<style >
.dashboard-card-class{
  height: 240px;
  border-radius: 10px;
  background-color: #FFFFFF;
  box-shadow: 0px 3px 1px -2px rgb(0 0 0 / 20%), 0px 2px 2px 0px rgb(0 0 0 / 14%), 0px 1px 5px 0px rgb(0 0 0 / 12%);
}

.small-card-icon-class{
  size: 32px;
}

.small-chart-margin{
  margin-left:10px;
}

</style>