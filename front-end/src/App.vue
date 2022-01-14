<template>
  <v-fade-transition mode="out-in">
    <router-view class="default-background" />
  </v-fade-transition>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    //
  }),
};
</script>
