<template>
<div>
    <section class="section news --main-news">
        <div class="container">
            <ul class="nav nav-tabs news__tabs" id="myTab" role="tablist">
                <li class="nav-item" role="presentation">
                    <button class="nav-link active text-uppercase" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">tin sản phẩm
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link text-uppercase" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">khuyến mãi
                    </button>
                </li>
                <li class="nav-item" role="presentation">
                    <button class="nav-link text-uppercase" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button" role="tab" aria-controls="contact" aria-selected="false">sự kiện
                    </button>
                </li>
            </ul>
            <div class="tab-content news__tabs-content" id="myTabContent">
                <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                    <div class="row news__list gy-sm-3 gy-2">
                        <div class="col-12 col-sm-6 col-lg-4 wow fadeInUp" v-for="(data,index) in news" :key="index">
                            <div class="news__item">
                                <a class="news__item__img mb-lg-3 mb-sm-2 mb-1 d-block" href="" title="">
                                    <img src="../../assets/content/images/news__item-nor.jpg" alt="" class="_img img-fluid">
                                </a>
                                <div class="news__item__author mb-lg-3 mb-sm-2 mb-1">
                                    <span class="_posted-by">
                                        <img src="../../assets/content/images/profile.svg" alt="" class="_img img-fluid svg-icon">
                                        Admin
                                    </span>
                                    <span class="_date ms-lg-3 ms-md-2 ms-1">
                                        <img src="../../assets/content/images/clock.svg" alt="" class="_img img-fluid svg-icon">
                                        {{ _new.createdDate | moment("DD/MM/YYYY")}}
                                    </span>
                                </div>
                                <a href="" class="news__item__title  d-block mb-lg-3 mb-sm-2 mb-1">
                                    {{ data.newsTitle }}
                                </a>
                                <div class="news__item__content">
                                    {{ data.newsContent }}
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">...</div>
                <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">...</div>
            </div>
            <!-- <div class="pagination justify-content-center mt-lg-4 pt-lg-3 mt-3">
                <strong>1</strong>
                <a href="">2</a><a href="">3</a><a href="">4</a>
            </div> -->
        </div>
    </section>
</div>
</template>

<script>
import {
    mapActions
} from 'vuex';
import {ModuleNews} from '@/store/module-const';
export default {
    created(){
        const me = this;
        me.getData();
    },
    data(){
        return{
            news : []
        }
    },
    methods:{
        ...mapActions(ModuleNews,['getNews']),
        async getData(){
            const me = this;
            me.news = await me.getNews();
        }
    }
}
</script>

<style scoped>

</style>
