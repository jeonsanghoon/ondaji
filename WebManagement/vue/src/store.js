/* store.js */
import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default  new Vuex.Store({
state: {
    isShowBar: true
},
getters: {
    getIsShowBar(state){
    return state.isShowBar;
}
},
mutations: {
  
    setIsShowBar(state){
        return state.isShowBar;
    }
},
actions : {
        setIsShowBar2(context) {
            
            return context.commit('setIsShowBar');
        }
    }
});
