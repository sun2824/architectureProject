<template>
  <v-card class="grade-card-class rounded-xl">
    <v-card-text class="text-center">
      <h2>{{ cardTitle }}</h2>
    </v-card-text>
    <apexchart class="small-chart-margin"
               v-if="isGradeDataMounted"
               type="polarArea"
               width="100%" height="80%" :options="options" :series="series"></apexchart>
  </v-card>
</template>

<script>
import apexchart from 'vue-apexcharts'
export default {
  name: "AgeCustomerLayout",
  props: {
    cardTitle: {
      type: String,
    }
  },
  components:{
    apexchart
  },
  data() {
    return {
      options: {
        legend: {
          show: true
        },
        dataLabels: {
          enabled: true
        },
        labels: [
            'Bronze','Silver','Gold','Platinum', 'Diamond'
        ]
      },
      series : [12,42,21,26,12]
    }
  },
  computed : {
    isGradeDataMounted: {
      get(){
        return this.$store.getters['dashboard/getIsGradeDataMounted'];
      }
    }
  }
}
</script>

<style>
.grade-card-class{
  height: 400px;
}
</style>