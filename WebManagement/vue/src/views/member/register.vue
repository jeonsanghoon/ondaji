<template>
  <div class="memberRegister">
    <h1>This is an member Register page</h1>
  </div>
</template>
<script>
export default {
  name: 'memberRegister'
  ,	mounted() {
			this.$store.watch(()=>{
        this.$store.dispatch('baseStore/setIsShowBar',true);
			})
		}
}
</script>