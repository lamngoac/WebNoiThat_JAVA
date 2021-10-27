import Vue from 'vue';
import router from '@/router/router.js';
import store from '@/store/store';
import i18n from '@/i18n/i18n-config.js'
class CommonFunc{
    async getPopupIntanceAsync(popupItems,intance, propData = {} ) {
        if(typeof intance == 'function'){
            intance = await intance();
            intance = intance.default;
        }
        let formPopup = {};
        formPopup[intance.name] = popupItems[intance.name];
        if(!formPopup[intance.name]){
            let form = Vue.extend(intance);
            popupItems[intance.name] = new form({
                router,
                i18n,
                store,
                propsData : propData
            });
            popupItems[intance.name].$mount();
            popupItems[intance.name].$once('hook:beforeDestroy',()=>{
                popupItems[intance.name] = null;
            });
        }
        return popupItems[intance.name];
    }

    convertImgSaveDB(img){
        img = img.toString();
        if(img){
            let res = img.split('\\');
            if(res){
                img = res.at(res.length-1);
                return img;
            }
        }
        return "";
    }

    async getBase64FromImage(file){
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);
            reader.onerror = error => reject(error);

        })
    }
}

export default new CommonFunc();