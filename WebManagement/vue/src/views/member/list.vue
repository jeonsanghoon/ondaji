<template>
  <div class="memberlist">
    <h1>This is an memberlist page</h1>
  </div>
</template>
<script>
export default {
  name: 'memberlist'
  ,	mounted() {
			this.$store.watch(()=>{
        this.$store.dispatch('baseStore/setIsShowBar',true);
			})
		}
}
</script>