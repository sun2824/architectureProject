<template>
  <v-card class="dashboard-card-class rounded-xl">
    <v-card-text >
      <h4 class="card-small-title-class">{{ cardTitle }}</h4>
    </v-card-text>
    <v-card-actions style="margin-top: -16px; margin-left:8px;">
      <h3 class="card-small-title-class">{{ todayCnt }}건</h3>
    </v-card-actions>
    <apexchart class="small-chart-margin"
        v-if="isSmallCardMounted"
        type="line"
        :width="width" height="54%" :options="lineOptions" :series="series"></apexchart>
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
    }
  },
  data(){
    return {
      width: '95%',
      lineOptions : {
        chart: {
          id: '',
          group: 'sparklines',
          type: 'area',
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
          categories: [
            "01 Jan",
            "02 Jan",
            "03 Jan",
            "04 Jan",
            "05 Jan",
            "06 Jan",
            "07 Jan"
          ]
        }
      },
      series: [
        {
          name: "Series 1",
          data: [45, 52, 38, 45, 19, 23, 2]
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
  height: 180px;
  border-radius: 10px;
  background-color: #FFFFFF;
  box-shadow: 0px 3px 1px -2px rgb(0 0 0 / 20%), 0px 2px 2px 0px rgb(0 0 0 / 14%), 0px 1px 5px 0px rgb(0 0 0 / 12%);
}

.small-chart-margin{
  margin-left:10px;
}

</style>