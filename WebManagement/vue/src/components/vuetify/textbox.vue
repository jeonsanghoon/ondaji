<template>
    <div>
    <v-text-field
            autofocus
            type="text"
            ref="value"
            :rules="rules.required"
            v-bind:color="options.color"
            v-bind:prepend-icon="options.icon"
            v-bind:label="options.label"
            v-bind:id="options.id"
            v-bind:name="options.id"
            v-bind:value="value"
            v-on:input="$emit('input', $event.target.value)"
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