import axios from 'axios';


export let BaseCommon = {
  isShowBar: true,
  loading:false,
  restful : {
    Call:async (url,objParam =null,method="post" )=> { 
      
      // eslint-disable-next-line no-debugger
      debugger;
        console.log("call");
        console.log(new Date());
     
       console.log(method);
       try{
         console.log("프로그래스바 시작");
        // eslint-disable-next-line no-debugger
        debugger;
          let res;
         (method==="post")?(res = await axios.post(url, objParam)):res = await axios.get(url, objParam);
          let rtn = await res.data;
          console.log(res.data);
        
          console.log("프로그래스바 종료");
          //this.loading = false;
          return rtn;
       }catch(e){
        //this.$root.isShowBar = false;
         throw e;
       }
    }
  },
  getData:()=>{
    return "test";

  }
};