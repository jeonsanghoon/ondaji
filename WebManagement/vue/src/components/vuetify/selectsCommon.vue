<template>
    <div>
        <v-select
            item-text="name"
            item-value="sub_code"
            :items="itemlist"
            v-model="defaultSelected"
            :label="options.label"
            :value="options.value"
            dense
            
        ></v-select>
    </div>
</template>

<script>
import { BaseCommon } from '@/assets/scripts/Common'

export default {
    props:['options'],
    data: () => ({
         defaultSelected: {
            sub_code: null,
            name: "-선택-"
        }
        
        ,itemlist:[{sub_code:null,name:"-선택-",bSelect:true}]
      
    }),
    created() {
        // eslint-disable-next-line no-debugger
        debugger;
        this.defaultSelected.sub_code = this.$options.propsData.options.value;
        BaseCommon.restful
        .Call('/common/getSelectItemList',this.$options.propsData.options)
        .then(res => {
          // eslint-disable-next-line no-debugger
          debugger;
            this.itemlist = res;
        })

    },
    beforeMount:()=> {
        
    },
}
</script>