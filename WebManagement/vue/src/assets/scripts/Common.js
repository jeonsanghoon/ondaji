import axios from 'axios';
import store from '@/store/store';

/** 공통함수 */
export const BaseCommon = {
    /** restful */
    restful: {
        /** 호출함수 */
        Call: async (url, objParam = null, method = 'post') => {
            store.dispatch('baseStore/setIsLoading', true);
            let rtn;
            try {
                let res;
                method === 'post' ? (res = await axios.post(url, objParam)) : (res = await axios.get(url, objParam));
                rtn = await res.data;
            } catch (e) {
                console.log(e);
            } finally {
                store.dispatch('baseStore/setIsLoading', false);
            }
            return rtn;
        }
    },
    /** 로그인정보 */
    MemberInfo: {
        /** 로그인 정보 가져오기 */
        getMember: () => {
            let user = store.getters['baseStore/getMemberInfo'];
            user = user === undefined ? null : user;
            return user;
        },
        /** 로그인정보 셋팅하기 */
        setMember: member => {
            store.dispatch('baseStore/setMemberInfo', member);
        }
    },
    /** 셋팅정보 */
    SettingInfo: {
        /** 레이아웃 상단 하단 바정보 가져오기 */
        getIsShowBar: () => store.getters['baseStore/getIsShowBar'],
        /** 레이아웃 상단 하단 바정보 셋팅하기  */
        setIsShowBar: bTrue => store.dispatch('baseStore/setIsShowBar', bTrue)
    },
    /**
     * url 이동
     */
    HostInfo: {
        redirect: url => {
            this.$router.push(url);
        }
    },
    /**
     * 폼정보
     */
    FormInfo: {
      /**
       * input 정보
       */
        input: {
          /**
           * input focus
           */
            focus: refName => {
                try {
                    // eslint-disable-next-line no-debugger
                    debugger;
                    this.$refs[refName].focus();
                    this.$refs[refName].select();
                } catch (e) {
                    console.log(e);
                }
            }
        },filedownload(filename)
        {
          BaseCommon.HostInfo.redirect("/download/" +filename);
        }
    }
};
