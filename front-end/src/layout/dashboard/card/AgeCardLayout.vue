<template>
  <v-card class="dashboard-card-class rounded-xl">
    <v-card-text class="text-center">
      <h2>{{ cardTitle }}</h2>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  name: "AgeCustomerLayout",
  props: {
    cardTitle: {
      type: String,
    }
  }
}
</script>

<style scoped>

</style>