<template>
<div class="container p-5 h-content-table-admin">
    <div class="row">
        <div class="col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Danh sách tin tuyển dụng</h3>
                        </div>
                        <div style="width:300px;">
                            <Input v-model="params.Filter" placeholder="Tìm kiếm" @keyup="filterData"/>
                        </div>
                        <div class="col col-xs-6 text-right" style="justify-content: flex-end; display: flex">
                            <div class="btn btn-sm btn-add h-display-flex" @click="addRecruitment">
                                <div>Thêm mới</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <table class="h-table">
                        <thead class="h-th-table">
                            <tr>
                                <th class="fix h-text-center width-100px">
                                    <em class="fa fa-cog"></em>
                                </th>
                                <th class="hidden-xs">STT</th>
                                <th class="min-w-200px">Tiêu đề tin tuyển dụng</th>
                                <th class="min-w-200px">Nội dung tin tuyển dụng</th>
                                <th>Link ảnh</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(recruitment, index) in recruitments" :key="index">
                                <td align="center" class="btn_click">
                                    <a class="btn btn-default" @click="editRecruitment(recruitment.recruitmentId)"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger" @click="deleteRecruitment(recruitment.recruitmentId)"><em class="fa fa-trash"></em></a>
                                </td>
                                <td class="hidden-xs">
                                    {{ params.PageSize * (params.PageIndex - 1) + index + 1 }}
                                </td>
                                <td>{{ recruitment.recruitmentTitle }}</td>
                                <td>{{ recruitment.recruitmentContent }}</td>
                                <td>{{ recruitment.linkImage }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="h-pagination">
                    <Pagination ref="pagination" @getData="getData" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'tuyen dung'" />
                </div>
            </div>
        </div>
    </div>
    <RecruitmentDetail :isShow="isShow" @closePopup="setStatePopup(false)" @showPopup="setStatePopup(true)" :recruitment="recruitment" :mode="mode" @loadData="getData" />
</div>
</template>

<script>
import Pagination from "../../components/pagination/Pagination.vue";
import {
    mapActions
} from "vuex";
import {
    ModuleRecruitment
} from "@/store/module-const";

import {
    Recruitment
} from "@/common/models/models";
import RecruitmentDetail from "./RecruitmentDetail.vue";
import Input from '@/views/components/input/Input';
import _ from 'lodash';
export default {
    components: {
        Pagination,
        RecruitmentDetail,
        Input
    },
    created() {
        const me = this;
        me.getData();
    },
    data() {
        return {
            recruitments: [],
            params: {
                PageIndex: 1,
                PageSize: 10,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
            },
            isShow: false,
            recruitment: Recruitment(),

            mode: "add",
        };
    },
    methods: {
        ...mapActions(ModuleRecruitment, [
            "getRecruitmentsPagging",
            "getRecruitmentById",
            "deleteRecruitmentAsync",
        ]),
        async getData() {
            const me = this;
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getRecruitmentsPagging(me.params);
            if (res) {
                me.recruitments = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.recruitments = [];
                me.params = {
                    PageIndex: 1,
                    PageSize: 10,
                    TotalRecord: 0,
                    TotalPages: 0,
                    Filter: me.params.Filter,
                };
            }

        },

        /**
         * Hàm sử lí click button thêm mới
         */
        async addRecruitment() {
            const me = this;
            me.showPopup();
            me.mode = "add";
        },
        // bịp vl vcl

        async editRecruitment(id) {
            const me = this;
            // Lấy Recruitment theo id

            me.recruitment = await me.getRecruitmentById(id);

            // Show popup
            me.showPopup();
            me.mode = "edit";
        },
        async deleteRecruitment(id) {
            const me = this;

            me.params.PageIndex -= 1;

            await me.deleteRecruitmentAsync(id);
            if (me.recruitments && me.recruitments.length == 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD - 1;
            } else if (me.recruitments && me.recruitments.length > 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getRecruitmentsPagging(me.params);
            if (res) {
                me.recruitments = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.recruitments = [];
                me.params = {
                    PageIndex: 1,
                    PageSize: 10,
                    TotalRecord: 0,
                    TotalPages: 0,
                    Filter: me.params.Filter,
                };
            }
        },
        showPopup() {
            const me = this;
            me.isShow = true;
        },
        setStatePopup(show) {
            const me = this;
            me.isShow = show;
            if (!show) {
                me.resetData();
            }
        },
        resetData() {
            const me = this;
            me.recruitment = Recruitment();
        },

        filterData: _.debounce(function () {
          this.getData();
        }, 500),
    },
};
</script>

<style scoped>
@import "../../../assets/content/css/common/tableAdmin.css";
</style>
