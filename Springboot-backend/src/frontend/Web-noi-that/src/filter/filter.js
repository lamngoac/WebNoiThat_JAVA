import Vue from 'vue';
const formatMoney = Vue.filter('formatMoney', function (money) {
    return new Intl.NumberFormat().format(money).replaceAll(",",".");
  })
  
export default { formatMoney }

