<template>
  <v-card class="realtime-age-card-class rounded-xl">
    <v-flex>
      <v-card-text class="text-center">
        <h2 class="card-small-title-class">{{ cardTitle }}</h2>
      </v-card-text>
      <apexchart class="small-chart-margin"
                 v-if="isRealtimeAgeMounted"
                 type="area"
                 :width="width" height="400px" :options="lineOptions" :series="series"></apexchart>
    </v-flex>
  </v-card>
</template>

<script>
import apexchart from "vue-apexcharts";

export default {
  name: "RealtimeAgeCardLayout",
  props: {
    cardTitle: {
      type: String
    },
    todayCnt: {
      type: String
    }
  },
  components: {
    apexchart
  },
  data() {
    return {
      width: '100%',
      lineOptions: {
        chart: {
          id: '',
          group: 'lines',
          type: 'area',
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
        series: [
          {
            name: "Running",
            data: [1, 2]
          },
          {
            name: "Waiting",
            data: [1, 2]
          }
        ],
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
          name: "Running",
          data: [1, 25, 12, 5, 12]
        },
        {
          name: "Waiting",
          data: [1, 2, 6, 3, 1]
        }
      ],
    }
  },
  computed: {
    isRealtimeAgeMounted: {
      get() {
        return this.$store.getters['dashboard/getIsRealtimeAgeMounted']
      }
    }
  }
}
</script>

<style>

</style>