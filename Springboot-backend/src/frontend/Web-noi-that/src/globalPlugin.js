import Vue from 'vue';

import commonFuc from '@/common/common.js'

// const install = Vue => {
//     Vue.prototype.$he.CommonFunc = commonFuc;
//     Vue.mixin({
//         mounted(){
//             const me = this;
//             if(me.$el && !me.$el.getVueInstance){
//                 me.$el.getVueInstance = function(){
//                     return me;
//                 }
//             }
//         },
//     });
// };
// install(Vue);
// export default install;
Vue.prototype.$h.CommonFunc = commonFuc;