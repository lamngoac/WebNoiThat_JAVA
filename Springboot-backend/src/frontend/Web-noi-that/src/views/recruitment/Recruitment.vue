<template>
<div>
    <!-- <section class="section_breacrumb">
        <div class="container">
            <ul class="breadcrumb clearfix" itemscope="" itemtype="http://schema.org/BreadcrumbList">
                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                    <a itemprop="item" href="https://thekey2.tech5s.net/">
                        <span itemprop="name">Trang chủ</span>
                    </a>
                    <meta itemprop="position" content="1">
                </li>
                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                    <a itemprop="item" href="https://thekey2.tech5s.net/videos">
                        <span itemprop="name">Tuyển dụng</span>
                    </a>
                    <meta itemprop="position" content="2">
                </li>
            </ul>
        </div>
    </section> -->
    <section class="section recru container">
        <div class="section__title text-center text-uppercase wow fadeInUp">việc làm tốt nhất</div>
        <div class="row gx-md-3 gy-md-3 gy-2 recru__list">
            <div v-for="(recruitment,index) in recruitments" :key="index" class="col-12 col-md-6">
                <div class="recru__item wow fadeInUp" data-wow-delay="<?php echo $i*0.3; ?>s" data-wow-duration="1s">
                    <div class="row">
                        <div class="col-xxl-4 col-xl-5">
                            <a href="" class="_img-link d-block mb-xl-0 mb-sm-2 mb-1" title="">
                                <img src="../../assets/content/images/recruitment.jpg" alt="" class="_main-img img-fluid">
                            </a>
                        </div>
                        <div class="col-xxl-8 col-xl-7">
                            <div class="recru__item__time mb-1">
                                <img src="../../assets/content/images/clock.svg" alt="" class="_img _icon img-fluid">
                                <span class="_time">{{recruitment.createdDate | moment("DD/MM/YYYY")}}</span>
                            </div>
                            <a href="" class="recru__item__title d-block mb-2" title="">{{ recruitment.recruitmentTitle }}</a>
                            <div class="recure__item__short mb-lg-3 mb-2">
                                {{ recruitment.recruitmentContent }}
                            </div>
                            <a href="" class="recru__item__more d-inline-block" title="">Xem thêm</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="pagination justify-content-center mt-lg-4 pt-lg-3 mt-3">
            <strong>1</strong>
            <a href="">2</a><a href="">3</a><a href="">4</a>
        </div>
    </section>
</div>
</template>

<script>
import {mapActions} from 'vuex';
import {ModuleRecruitment} from '@/store/module-const';
export default {
    data(){
        return{
            recruitments : [],
        }
    },
    created(){
        const me = this;
        me.loadData();
    },
    computed:{
    },
    methods:{
        ...mapActions(ModuleRecruitment,['getRecruitments']),
        async loadData(){
            const me = this;
            let res = await me.getRecruitments();
            if(res){
                me.recruitments = [...res];
            }
        },
        async getData(){
           
        }
    }
}
</script>

<style lang="scss" scoped>

</style>
