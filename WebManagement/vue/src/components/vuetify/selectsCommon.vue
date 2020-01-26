<template>
    <div>
        <v-select
            item-text="name"
            item-value="code"
            :items="value.items"
            v-model="defaultSelected"
            label="Standard"
            dense
        ></v-select>
    </div>
</template>
<script>
import { BaseCommon } from '@/assets/scripts/Common'

export default {
    props:['value'],
    data: () => ({
         defaultSelected: {
            code: "",
            name: "-선택-"
        }
        ,propsData : this.value
        ,itemlist:[{code:"",name:"-선택-",bSelect:true}]
    }),
    created:()=> {
        BaseCommon.restful
        .Call('/common/getCommonList',   this.propsData.Cond)
        .then(res => {
          // eslint-disable-next-line no-debugger
            this.itemlist = res.data;
        })

    },
    beforeMount:()=> {
        
    },
}
</script>