<template>
<div class="container p-5 h-content-table-admin">
    <div class="row">
        <div class="col-md-offset-1">
            <div class="panel panel-default panel-table">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col col-xs-6">
                            <h3 class="panel-title">Danh sách sản phẩm</h3>
                        </div>
                        <div style="width:300px;">
                          <Input v-model="params.Filter" placeholder="Tìm kiếm" @keyup="filterData"/>
                        </div>
                        <div class="col col-xs-6 text-right" style="justify-content: flex-end; display: flex">
                            <div type="button" class="btn btn-sm btn-add h-display-flex" @click="addProduct">
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
                                <th>Danh mục sản phẩm</th>
                                <th>Tên sản phẩm</th>
                                <th>Kích thước</th>
                                <th>Nguyên liệu</th>
                                <th>Nhà sản xuất</th>
                                <th>Màu sắc</th>
                                <th>Giá gốc</th>
                                <th>Giá sale</th>
                                <th>Mô tả ngắn</th>
                                <th>Mô tả</th>
                                <th>Đánh giá</th>
                                <th>Link ảnh</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(product, index) in products" :key="index">
                                <td align="center" class="btn_click">
                                    <a class="btn btn-default" @click="editProduct(product.productId)"><em class="fa fa-pencil"></em></a>
                                    <a class="btn btn-danger" @click="deleteProduct(product.productId)"><em class="fa fa-trash"></em></a>
                                </td>
                                <td class="hidden-xs">
                                    {{ params.PageSize * (params.PageIndex - 1) + index + 1 }}
                                </td>
                                <td>{{ product.productCategoryId }}</td>
                                <td>{{ product.productName }}</td>
                                <td>{{ product.productDimensions }}</td>
                                <td>{{ product.productMaterial }}</td>
                                <td>{{ product.productManufacturer }}</td>
                                <td>{{ product.ProductColor }}</td>
                                <td>{{ product.productOriginalPrice }}</td>
                                <td>{{ product.productSalePrice }}</td>
                                <td>{{ product.poductDescriptionShort }}</td>
                                <td>{{ product.productDescription }}</td>
                                <td>{{ product.productEvaluate }}</td>
                                <td>{{ product.productImage }}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="h-pagination">
                    <Pagination ref="pagination" @getData="getData" :totalRecord="params.TotalRecord" :pageSize="params.PageSize" :totalPages="params.TotalPages" :pageIndex="params.PageIndex" :filter="params.Filter" :textTotal="'san pham'" />
                </div>
            </div>
        </div>
    </div>
    <AdminProductDetail :isShow="isShow" @closePopup="setStatePopup(false)" @showPopup="setStatePopup(true)" :product="product" :mode="mode" @loadData="getData" />
</div>
</template>

<script>
import Pagination from "../../components/pagination/Pagination.vue";
import {
    mapActions
} from "vuex";
import {
    ModuleProduct
} from "@/store/module-const";
import AdminProductDetail from "./AdminProductDetail.vue";
import {
    Product
} from "@/common/models/models";

import Input from '@/views/components/input/Input';
import _ from 'lodash';
export default {
    components: {
        Pagination,
        AdminProductDetail,
        Input
    },
    created() {
        const me = this;
        me.getData();
    },
    data() {
        return {
            products: [],
            params: {
                PageIndex: 1,
                PageSize: 10,
                TotalRecord: 0,
                TotalPages: 0,
                Filter: "",
                Sort: "",
                CategoryId: "",
                Price: 0
            },
            isShow: false,
            product: Product(),

            mode: "add",
        };
    },
    methods: {
        ...mapActions(ModuleProduct, [
            "getProductsPagging",
            "getProductById",
            "deleteProductAsync",
        ]),
        async getData() {
            const me = this;
            if(me.$refs.pagination){
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getProductsPagging(me.params);
            if (res) {
                me.products = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.products = [];
                me.params = {
                    PageIndex: 1,
                    PageSize: 10,
                    TotalRecord: 0,
                    TotalPages: 0,
                    Sort: "",
                    CategoryId: "",
                    Price: 0,
                    Filter: me.params.Filter,
                };
            }
        },

        async addProduct() {
            const me = this;
            me.showPopup();
            me.mode = "add";
        },
        // bịp vl vcl

        async editProduct(id) {
            const me = this;
            // Lấy Product theo id
            me.product = await me.getProductById(id);

            // Show popup
            me.showPopup();
            me.mode = "edit";
        },
        async deleteProduct(id) {
            const me = this;
            me.params.PageIndex -= 1;

            await me.deleteProductAsync(id);
            if (me.products && me.products.length == 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD - 1;
            } else if (me.products && me.products.length > 1) {
                me.params.PageIndex = me.$refs.pagination.pageIndexD;
            }
            let res = await me.getProductsPagging1(me.params);
            if (res) {
                me.products = [...res.data];
                me.params.PageIndex = res.pageIndex;
                me.params.PageSize = res.pageSize;
                me.params.TotalRecord = res.totalRecord;
                me.params.TotalPages = res.totalPages;
            }
            if (!res) {
                me.products = [];
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
            me.product = Product();
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
