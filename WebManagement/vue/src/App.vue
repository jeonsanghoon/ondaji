<template>
  <v-app id="app">
    <v-dialog v-model="loading" fullscreen>
      <v-container
        fluid
        fill-height
        style="background-color: rgba(255, 255, 255, 0.5);"
      >
        <v-layout justify-center align-center>
          <v-progress-circular indeterminate color="primary">
          </v-progress-circular>
        </v-layout>
      </v-container>
    </v-dialog>
    <mainmenu />
    <v-content>
      <v-container fill-height>
        <v-row align="start" justify="start">
          <v-col class="text-center overflow-y-auto">
            <router-view />
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <v-footer color="indigo" app v-if="isShowBar">
      <span class="white--text">&copy; 2019</span>
    </v-footer>
  </v-app>
</template>
<style lang="scss">
@import '@/assets/styles/index.scss';
/* Remove in 1.2 */
.v-datatable thead th.column.sortable i {
  vertical-align:unset;
}
</style>
<script>
import mainmenu from '@/components/mainmenu'
import { BaseCommon } from '@/assets/scripts/Common'


export default {
  components: {
    mainmenu
  },
  data: () => ({
    loading: false,
    isShowBar: true
  }),
  beforecreated () {
    BaseCommon.restful.Call('/member/getmyinfo').then(res => {
      // eslint-disable-next-line no-debugger
      if (!(res === null || res === ''))
        this.$store.dispatch('baseStore/setMemberInfo', null)
      else this.$store.dispatch('baseStore/setMemberInfo', res)
    })
  },
  mounted () {
    this.$store.watch(() => {
      this.loading = this.$store.getters['baseStore/getIsLoading']
      this.isShowBar = this.$store.getters['baseStore/getIsShowBar']
    })
  },
  method: () => ({}),
  computed: {}
}
</script>

<style lang="scss">
@import '@/assets/styles/Common.scss';
</style>
