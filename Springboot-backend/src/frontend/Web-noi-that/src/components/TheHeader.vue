<template>
    <div id="#header" class="h-header">
        <div class="header__top">
            <div class="container">
                <div class="row">
                    <div class="col-lg-2 col-5 d-flex pt-2">
                         <a href="" class="d-block smooth logo_desktop pt-2">
                        <img src="../assets/content/images/logo2.png" alt="" class="img-fluid">
                        </a>
                    </div>
                    <div class="col-lg-8 col-6 align-self-center pt-1">
                        <form action="" method="" class="form_search">
                            <input type="" name="" class="" :placeholder="i18n.Search">
                            <button type="submit"><img src="../assets/content/images/search.svg" :alt="i18n.Search"></button>
                        </form>
                    </div>
                    
                    <div class="col-lg-2 col-1 align-self-center d-lg-flex justify-content-end align-items-center pt-1">
                        <div class="d-flex pe-lg-4">
                            <ul>
                                <li><router-link to="/login" title="">{{ i18n.Login }}</router-link></li>
                                <li><router-link to="/register" title="">{{ i18n.Register }}</router-link></li>
                            </ul>
                        </div>
                        <div class="top_cart">
                            <router-link to="/cart" title="" class="cart__icon" data-count="12">
                                <img src="../assets/content/images/cart.svg" :alt="i18n.Cart">
                            </router-link>
                            <div class="cart__current">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="header__middle">
            <div class="container">
                <div class="middle_menu menu__mobile">
                    <ul>
                        <li><a href="" title="">{{ i18n.Home }}</a></li>
                        <li><router-link to="/about" title="">{{ i18n.Introduce }}</router-link></li>
                        <li><router-link to="/category">{{ i18n.Furniture}}</router-link></li>
                        <li><router-link to="/project" title="">{{ i18n.Project }}</router-link></li>
                        <li><router-link to="/news" title="">{{ i18n.News }}</router-link></li>
                        <li><router-link to="recruiment" title="">{{ i18n.Recruitment }}</router-link></li>
                        <li><router-link to="/contact" title="">{{ i18n.Contact }}</router-link></li>
                    </ul>
                </div>
            </div>
            <div class="web_lang menu__mobile d-lg-none">
                <ul>
                    <li><a href="">Ngôn ngữ</a>
                        <ul>
                            <li><a href="">Ngôn ngữ</a></li>
                            <li><a href="">Ngôn ngữ</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>

</div>
</template>

<script>
import dataFake from '@/enum/header/dataFake';
import {
    mapActions
} from 'vuex';
import {ModuleTranslate} from '@/store/module-const';
export default {
    data(){
        return{
            menus : dataFake.menus,
            routers : dataFake.routers,
            respone : {},
            i18n : {...this.$t('i18nHeader')}
        }
    },
    created(){
        const me = this;
        me.readFileAsString();
    },
    methods: {
        ...mapActions(ModuleTranslate,['translateLanguage']),
        async handleChange(value) {
            const me = this;
            let res = await me.translateLanguage({language : value, text: JSON.stringify(this.$t('i18nHeader'))});
            me.i18n = {...JSON.parse(res.text[0])};
        },
        handleBlur() {
            console.log('blur');
        },
        handleFocus() {
            console.log('focus');
        },
        filterOption(input, option){
            return (
                option.componentOptions.children[0].text.toLowerCase().indexOf(input.toLowerCase()) >= 0
            );
        },
        readFileAsString(){
            console.log(this.$t('i18nHeader') );
        }
    },
}
</script>

<style  scoped>
.h-header{
    position: sticky;
    top: 0px;
    background: #e2f0e9;
    z-index: 10000;
}
</style>
