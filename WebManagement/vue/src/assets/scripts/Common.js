import axios from 'axios';

import store from '@/store/store'

export let BaseCommon = {
  isShowBar: true,
  loading:false,
  restful : {
    Call:async (url,objParam =null,method="post" )=> { 
      store.dispatch('baseStore/setIsLoading',true);
      let rtn;
      try{
         let res;
         (method==="post")?(res = await axios.post(url, objParam)):res = await axios.get(url, objParam);
          rtn = await res.data;
       }catch(e){
          console.log(e);
       }finally{
          store.dispatch('baseStore/setIsLoading',false);
       }
       return rtn;
    }
  },
  getData:()=>{
    return "test";

  }
};