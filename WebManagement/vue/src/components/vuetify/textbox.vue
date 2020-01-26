<template>
    <div>
    <v-text-field
            autofocus
            type="text"
            ref="value"
            :rules="rules.required"
            v-bind:color="value.color"
            v-bind:prepend-icon="value.icon"
            v-bind:label="value.label"
            v-bind:id="value.id"
            v-bind:name="value.id"
            v-bind:value="value.value"
            v-on:input="$emit('input', $event.target.value)"
          ></v-text-field>
    </div>
</template>

<script>
export default {
  props:['value'],
  data: () => ({
    rules: {
          required: [val => (val || '').length > 0 || '필수입력입니다.']
        }
  })
}
</script>