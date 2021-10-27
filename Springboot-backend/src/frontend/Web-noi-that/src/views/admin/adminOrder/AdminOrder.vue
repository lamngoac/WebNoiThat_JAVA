<template>
<div class="container p-5 h-content-table-admin">
    <div class="row">
        <div class="col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Danh sách đơn hàng</h3>
                        </div>
                        <div style="width:300px;">
                            <Input v-model="params.Filter" placeholder="Tìm kiếm" @keyup="filterData"/>
                        </div>
                        <div class="col col-xs-6 text-right" style="justify-content: flex-end; display: flex">
                            <div type="button" class="btn btn-sm btn-add h-display-flex" @click="addOrder">
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
                                <th class="hidden-xs">Số thứ tự</th>
                                <th>Mã tài khoản</th>
                                <th>Mã đơn hàng</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(order, index) in orders" :key="index">
                                <td align="center" class="btn_click">
                                    <a class="btn btn-default" @click="editOrder(order.orderId)"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger" @click="deleteOrder(order.orderId)"><em class="fa fa-trash"></em></a>
                                </td>
                                <td class="hidden-xs">
                                    {{ params.PageSize * (params.PageIndex - 1) + index + 1 }}
                                </td>
                                <td>{{ order.userId }}</td>
                                <td>{{ order.orderId }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="h-pagination">
                    <Pagination ref="pagination" @getData="getData" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'don hang'" />
                </div>
            </div>
        </div>
    </div>
    <AdminOrderD :isShow="isShow" @closePopup="setStatePopup(false)" @showPopup="setStatePopup(true)" :order="order" :mode="mode" @loadData="getData" />
</div>
</template>

<script>
import Pagination from "../../components/pagination/Pagination.vue";
import {
    mapActions
} from "vuex";
import {
    ModuleOrder
} from "@/store/module-const";
import AdminOrderD from "./AdminOrderD.vue";

import {
    Order
} from "@/common/models/models";
import Input from '@/views/components/input/Input';
import _ from 'lodash';
export default {
    components: {
        Pagination,
        AdminOrderD,
        Input
    },
    created() {
        const me = this;
        me.getData();
    },
    data() {
        return {
            orders: [],
            params: {
                PageIndex: 1,
                PageSize: 10,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
            },
            isShow: false,
            order: Order(),

            mode: "add",
        };
    },
    methods: {
        ...mapActions(ModuleOrder, [
            "getOrdersPagging",
            "getOrderById",
            "deleteOrderAsync",
        ]),
        async getData() {
            const me = this;
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getOrdersPagging(me.params);
            if (res) {
                me.orders = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.orders = [];
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
        async addOrder() {
            const me = this;
            me.showPopup();
            me.mode = "add";
        },
        // bịp vl vcl

        async editOrder(id) {
            const me = this;
            // Lấy Order theo id

            me.order = await me.getOrderById(id);

            // Show popup
            me.showPopup();
            me.mode = "edit";
        },
        async deleteOrder(id) {
            const me = this;

            me.params.PageIndex -= 1;

            await me.deleteOrderAsync(id);
            if (me.orders && me.orders.length == 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD - 1;
            } else if (me.Orders && me.Orders.length > 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getOrdersPagging(me.params);
            if (res) {
                me.orders = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.orders = [];
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
            me.order = Order();
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
