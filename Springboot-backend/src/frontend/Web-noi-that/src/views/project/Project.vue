<template>
<div>
    <section class="item-project container">
        <div class="row">
            <div v-for="(project,index) in projects" :key="index" class="col-12 col-lg-6 wow fadeInUp" :data-wow-delay="`${index*0.3}`+'s'" data-wow-duration="1s">

                <div thumbsSlider="" class="swiper-container mySwiper slide-projec-one mt-set">
                    <div class="swiper-wrapper">
                        <div v-for="index1 in 4" :key="index1" class="swiper-slide">
                            <img :src=" require('@/assets/content/images/project'+index1+'.jpg')" />
                        </div>
                    </div>
                </div>
                <p class="project-name">{{ project.projectTitle }}</p>
                <p class="project_adress"> <img src="../../assets/content/images/6.svg" alt="">Thị trấn Tam Đảo, Huyện Tam Đảo, Vĩnh Phúc </p>
                <p class="project_adress">{{ project.projectContent }}</p>
            </div>
        </div>
        <div class="h-pagination">
            <Pagination ref="pagination" @getData="getData" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'dự án'" />
        </div>
    </section>
</div>
</template>

<script>
import Pagination from "@/views/components/pagination/Pagination";
import {
    mapActions
} from 'vuex';
import {ModuleProject} from '@/store/module-const';
export default {
    components:{
        Pagination
    },
    created(){
        const me = this;
        me.getData();
    },
    data(){
        return{
            projects : [],
            params: {
                PageIndex: 1,
                PageSize: 4,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
            },
        }
    },
    methods:{
        ...mapActions(ModuleProject,['getProjectsPagging']),
        async getData(){
            const me = this;
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getProjectsPagging(me.params);
            if (res) {
                me.projects = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.projects = [];
                me.params = {
                    PageIndex: 1,
                    PageSize: 10,
                    TotalRecord: 0,
                    TotalPages: 0,
                    Filter: me.params.Filter,
                };
            }
        }
    }
}
</script>

<style lang="scss" scoped>

</style>
