<template>
  <v-card class="grade-cost-card-class rounded-xl">
    <v-card-text class="text-center">
      <h2>{{ cardTitle }}</h2>
    </v-card-text>
    <apexchart class="small-chart-margin"
               v-if="isGradeCostDataMounted"
               type="bar"
               width="94%" height="80%" :options="options" :series="series"></apexchart>
  </v-card>
</template>

<script>
import apexchart from 'vue-apexcharts'

export default {
  name: "GenderCardLayout",
  props: {
    cardTitle: {
      type: String
    }
  },
  components:{
    apexchart
  },
  computed:{
    isGradeCostDataMounted:{
      get(){
        return this.$store.getters['dashboard/getIsGradeCostDataMounted'];
      }
    }
  },
  data(){
    return{
      options: {
        chart: {
          type: 'bar',
          stacked: true,
          stackType: '100%'
        },
        stroke: {
          width: 1,
          colors: ['#fff']
        },
        xaxis: {
          categories: ['Bronze', 'Silver', 'Gold', 'Platinum', 'Diamond'],
        },
        fill: {
          opacity: 1

        },
        legend: {
          position: 'top',
          horizontalAlign: 'left',
          offsetX: 40
        }
      },
      series: [{
        name: '100~200만원',
        data: [44, 55, 41, 37, 22]
      }, {
        name: '200만원~300만원',
        data: [53, 32, 33, 52, 13]
      }, {
        name: '300~500만원',
        data: [12, 17, 11, 9, 15]
      }, {
        name: '500~700만원',
        data: [9, 7, 5, 8, 6]
      }, {
        name: '1000만원 이상',
        data: [25, 12, 19, 32, 80]
      }]
    }
  }
}
</script>

<style>
.grade-cost-card-class{
  height: 600px;
}
</style>