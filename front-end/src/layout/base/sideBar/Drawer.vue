<template>
  <v-navigation-drawer
      class="sidebar-class sideBar"
      app
      light
      left>
    <menu-list>

    </menu-list>
  </v-navigation-drawer>
</template>

<script>
import MenuList from "@/layout/base/sideBar/MenuList";
export default {
  name: "Drawer",
  components:{
    MenuList
  }
}
</script>

<style>
.sidebar-class{
  height: 100vh !important;
  top: 65px !important;
  width: 260px !important;
  z-index: 6;
}
</style>