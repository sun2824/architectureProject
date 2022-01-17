<template>
  <v-list
      dense
      nav
  >
    <v-list-group
        v-for="item in items"
        :key="item.title"
        v-model="selectedItem"
        color="sideBar"
    >
      <v-icon slot="prependIcon" color="white">{{ item.icon }}</v-icon>
        <template v-slot:activator>
          <v-list-item-content>
            <v-list-item-title class="v-list-item-title-color">{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </template>
      <template v-for="(child, index) in item.subItems">
        <sub-menu-list :key="`child-${index}`" :item="child" />
      </template>
    </v-list-group>
  </v-list>
</template>

<script>
import { mapState } from "vuex";
import SubMenuList from '@/layout/base/sideBar/SubMenuList'

export default {

  name: "MenuList",
  components: {SubMenuList},
  data() {
    return {
      selectedItem: {},
      items: [
        {
          title: 'Dashboard',
          icon: 'mdi-view-dashboard',
          subItems: [
            {
              icon: 'mdi-view-dashboard',
              title: 'Dashboard',
              to: '/dashboard'
            }
          ]
        }
      ],
    }
  },
  computed: {
    ...mapState({
      selectedMenu: state => state.base.selectedMenu
    })
  },
  selectedMenu: {
    get(){
      return this.$store.getters['base/getSelectedMenu'];
    },
    set(value){
      let payload = {
        selectedMenu : value
      }
      return this.$store.dispatch("base/selectMenu", payload);
    }
  }
}
</script>

<style>
.v-list-item-title-color{
  color: white;
}
.v-list__group__header__prepend-icon .v-icon {
  color: red;
}
</style>