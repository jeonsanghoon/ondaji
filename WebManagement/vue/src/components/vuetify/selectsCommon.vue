<template>
    <div>
        <v-select
            item-text="name"
            item-value="code"
            :items="itemlist"
            v-model="defaultSelected"
            label="Standard"
            dense
        ></v-select>
    </div>
</template>
<script>
import { BaseCommon } from '@/assets/scripts/Common'

export default {
    props:['Cond'],
    data: () => ({
         defaultSelected: {
            code: "",
            name: "-선택-"
        }
        
        ,itemlist:[{code:"",name:"-선택-",bSelect:true}]
      
    }),
    created() {
        // eslint-disable-next-line no-debugger
        debugger;
       
        BaseCommon.restful
        .Call('/common/getSelectItemList',this.$options.propsData.Cond)
        .then(res => {
          // eslint-disable-next-line no-debugger
            this.itemlist = res;
        })

    },
    beforeMount:()=> {
        
    },
}
</script>