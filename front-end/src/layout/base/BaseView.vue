<template>
  <v-main class="default-background-color">
      <v-fade-transition mode="out-in">
        <router-view class="default-background-color"/>
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

.default-background-color{
  background-color:#f0f1fa !important;
}
</style>