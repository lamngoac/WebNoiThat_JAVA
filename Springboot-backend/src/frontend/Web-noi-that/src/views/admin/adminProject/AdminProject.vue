<template>
<div class="container p-5 h-content-table-admin">
    <div class="row">
        <div class="col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading h-row-header">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Danh sách dự án</h3>
                        </div>
                        <div style="width:300px;">
                          <Input v-model="params.Filter" placeholder="Tìm kiếm" @keyup="filterData"/>
                        </div>
                        <div class="col col-xs-6 text-right" style="justify-content: flex-end; display: flex">
                            <div type="button" class="btn btn-sm btn-add h-display-flex" @click="addProject">
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
                                <th class="hidden-xs min-w-200px">Mã số</th>
                                <th class="min-w-200px">Tiêu đề dự án</th>
                                <th class="min-w-200px">Nội dung dự án</th>
                                <th class="min-w-200px">Link ảnh</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(project, index) in projects" :key="index">
                                <td align="center" class="btn_click">
                                    <a class="btn btn-default" @click="editProject(project.projectId)"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger" @click="deleteProject(project.projectId)"><em class="fa fa-trash"></em></a>
                                </td>
                                <td class="hidden-xs">
                                    {{ params.PageSize * (params.PageIndex - 1) + index + 1 }}
                                </td>
                                <td>{{ project.projectTitle }}</td>
                                <td>{{ project.projectContent }}</td>
                                <td>{{ project.linkImage }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="h-pagination">
                    <Pagination ref="pagination" @getData="getData" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'du an'" />
                </div>
            </div>
        </div>
    </div>
    <AdminProjectDetail :isShow="isShow" @closePopup="setStatePopup(false)" @showPopup="setStatePopup(true)" :project="project" :mode="mode" @loadData="getData" />
</div>
</template>

<script>
import Pagination from "../../components/pagination/Pagination.vue";
import {
    mapActions
} from "vuex";
import {
    ModuleProject
} from "@/store/module-const";
import AdminProjectDetail from "./AdminProjectDetail.vue";
import {
    Project
} from "@/common/models/models";
import Input from '@/views/components/input/Input';
import _ from 'lodash';
export default {
    components: {
        Pagination,
        AdminProjectDetail,
        Input
    },
    created() {
        const me = this;
        me.getData();
    },
    data() {
        return {
            projects: [],
            params: {
                PageIndex: 1,
                PageSize: 10,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
            },
            isShow: false,
            project: Project(),

            mode: "add",
        };
    },
    methods: {
        ...mapActions(ModuleProject, [
            "getProjectsPagging",
            "getProjectById",
            "deleteProjectAsync",
        ]),
        async getData() {
            const me = this;
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getProjectsPagging(me.params);
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
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
        },

        /**
         * Hàm sử lí click button thêm mới
         */
        async addProject() {
            const me = this;
            me.showPopup();
            me.mode = "add";
        },

        async editProject(id) {
            const me = this;
            // Lấy project theo id

            me.project = await me.getProjectById(id);

            // Show popup
            me.showPopup();
            me.mode = "edit";
        },
        async deleteProject(id) {
            const me = this;

            me.params.PageIndex -= 1;

            await me.deleteProjectAsync(id);
            if (me.projects && me.projects.length == 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD - 1;
            } else if (me.projects && me.projects.length > 1) {
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
            me.project = Project();
        },

        /**
         * Hàm sử lí việc lọc data tìm kiếm
         */
        filterData: _.debounce(function () {
            const me = this;
            me.getData();
        }, 500),
    },
};
</script>

<style scoped>
@import "../../../assets/content/css/common/tableAdmin.css";
</style>
