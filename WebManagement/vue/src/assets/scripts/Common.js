import ax from 'axios';
export const axios = ax
export default function (){
  
}
export const BaseCommon = {
  
  restful : {
    Call:async (url,objParam,method="post")=> { 
      
        console.log("call");
        console.log(new Date());

       console.log(method);
       try{
         console.log("프로그래스바 시작");
          let res;
         (method==="post")?(res = await axios.post(url, objParam)):res = await axios.get(url, objParam);
          let rtn = await res.data;
          console.log(res.data);
          console.log("프로그래스바 종료");
          return rtn;
       }catch(e){
         throw e;
       }
    }
  },
  getData:()=>{
    return "test";

  }
};