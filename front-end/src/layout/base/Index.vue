<template>
  <v-app>
    <app-bar></app-bar>
    <side-bar class="elevation-10"></side-bar>
    <v-main id="mainBody">
      <BaseView />
    </v-main>
  </v-app>
</template>

<script>
import AppBar from "@/layout/base/topBar/AppBar";
import SideBar from "@/layout/base/sideBar/Drawer";
import BaseView from "@/layout/base/BaseView";

export default {
  name: "Index",
  components: {
    AppBar,
    SideBar,
    BaseView
  }
}
</script>

<style scoped>

</style>