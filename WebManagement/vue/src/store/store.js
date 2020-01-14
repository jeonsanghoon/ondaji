/* store.js */
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 기본 저장소
const baseStore = {
    namespaced: true,
    state: {
        isShowBar : true,
        isLoading : false,
        memberInfo:  null
    },
    getters: {
          getIsShowBar:(state)=> state.isShowBar
        , getIsLoading:(state)=> state.isLoading
        , getMemberInfo:(state)=> state.memberInfo
    },
    mutations: {
          setIsShowBar : (state, bTrue) => state.isShowBar = bTrue
        , setIsLoading : (state, bTrue) => state.isLoading = bTrue
        , setMemberInfo: (state, member)=> state.memberInfo = member
    },
    actions : {
         setIsShowBar  : ({commit}, bTrue) => commit('setIsShowBar',bTrue)
        ,setIsLoading  : ({commit}, bTrue) => commit('setIsLoading',bTrue)
        ,setMemberInfo : ({commit}, member) =>commit('setMemberInfo',member)
    }
}

export default  new Vuex.Store({
    modules : {
        baseStore : baseStore
    }
});
