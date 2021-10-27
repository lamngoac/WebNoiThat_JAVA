<template>
<div class="container p-5 h-content-table-admin">
    <div class="row">
        <div class="col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Danh sách user</h3>
                        </div>
                        <div style="width:300px;">
                            <Input v-model="params.Filter" placeholder="Tìm kiếm" @keyup="filterData"/>
                        </div>
                        <div class="col col-xs-6 text-right" style="justify-content: flex-end; display: flex">
                            <div class="btn btn-sm btn-add h-display-flex" @click="addUser">
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
                                <th class="min-w-200px">Tài khoản</th>
                                <th class="min-w-200px">Họ tên</th>
                                <th class="min-w-200px">Địa chỉ</th>
                                <th class="min-w-200px">Số điện thoại</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(user, index) in users" :key="index">
                                <td align="center" class="btn_click">
                                    <a class="btn btn-default" @click="editUser(user.userId)"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger" @click="deleteUser(user.userId)"><em class="fa fa-trash"></em></a>
                                </td>
                                <td class="hidden-xs">
                                    {{ params.PageSize * (params.PageIndex - 1) + index + 1 }}
                                </td>
                                <td>{{ user.userName }}</td>
                                <td>{{ user.fullName }}</td>
                                <td>{{ user.address }}</td>
                                <td>{{ user.phoneNumber }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="h-pagination">
                    <Pagination ref="pagination" @getData="getDataUser" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'tài khoản'" />
                </div>
            </div>
        </div>
    </div>
    <UserDetail :isShow="isShow" @closePopup="setStatePopup(false)" @showPopup="setStatePopup(true)" :user="user" :mode="mode" @loadData="getDataUser" />
</div>
</template>

<script>
import Pagination from "../../components/pagination/Pagination.vue";
import {
    mapActions
} from "vuex";
import {
    ModuleUser
} from "@/store/module-const";

import {
    User
} from "@/common/models/models";
import UserDetail from "./AdminUserDetail.vue";
import Input from '@/views/components/input/Input';
import _ from 'lodash'
export default {
    components: {
        Pagination,
        UserDetail,
        Input
    },
    created() {
        const me = this;
        me.getDataUser();
    },
    data() {
        return {
            users: [],
            params: {
                PageIndex: 1,
                PageSize: 10,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
            },
            isShow: false,
            user: User(),

            mode: "add",
        };
    },
    methods: {
        ...mapActions(ModuleUser, [
            "getUsersPagging",
            "getUserById",
            "deleteUserAsync",
        ]),
        async getDataUser() {
            const me = this;
            if (me.$refs.pagination) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getUsersPagging(me.params);
            if (res) {
                me.users = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.users = [];
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
        async addUser() {
            const me = this;
            me.showPopup();
            me.mode = "add";
        },
        async editUser(id) {
            const me = this;
            // Lấy user theo id
            me.user = await me.getUserById(id);
            // Show popup
            me.isShow = true;
            me.mode = "edit";
        },
        async deleteUser(id) {
            const me = this;
            // if(me.users.length == 1 && me.users){
            //     me.params.PageIndex -= 1;
            // }
            me.params.PageIndex -= 1;
            //Xóa user theo Id
            await me.deleteUserAsync(id);
            if (me.users && me.users.length == 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD - 1;
            } else if (me.users && me.users.length > 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getUsersPagging(me.params);
            if (res) {
                me.users = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.users = [];
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
            me.user = User();
        },
        filterData: _.debounce(function () {
          this.getDataUser();
        }, 500),
    },
};
</script>

<style scoped>
@import "../../../assets/content/css/common/tableAdmin.css";
</style>
