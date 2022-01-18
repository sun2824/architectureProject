<template>
  <v-fade-transition mode="out-in">
    <router-view class="default-background" />
  </v-fade-transition>
</template>

<script>
import '@mdi/font/css/materialdesignicons.css'

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>

<style>

</style>
