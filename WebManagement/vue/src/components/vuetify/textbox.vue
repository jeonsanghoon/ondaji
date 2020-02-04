<template>
    <div>
    <v-text-field
            autofocus
            type="text"
            ref="value"
         
          ></v-text-field>
    </div>
</template>

<script>
export default {
  props:['options','value'],
  data: () => ({
    rules: {
          required: [val => (val || '').length > 0 || '필수입력입니다.']
        }
  })
}
</script>