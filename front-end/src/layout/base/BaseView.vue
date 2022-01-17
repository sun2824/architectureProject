<template>
  <v-main>
      <v-fade-transition mode="out-in">
        <router-view/>
      </v-fade-transition>
  </v-main>
</template>

<script>
export default {
  name: "BaseView"
}
</script>

<style>
.v-main {
  padding-top: 45px !important;
  padding-left: 145px !important;
  padding-right: 1% !important;
}
</style>