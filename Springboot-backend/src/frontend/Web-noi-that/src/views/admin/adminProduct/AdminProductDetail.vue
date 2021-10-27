<template>
<div class="h-popup" v-if="isShow">
    <popup @closePopup="closePopup" :width="600" :height="500">
        <template slot="header">
            <div class="h-titlte">
                {{ titlleMode }}
            </div>
        </template>
        <template slot="content">
            <div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Danh mục sản phẩm'" placeholder="Danh mục sản phẩm" v-model="product.productCategoryId" />
                    </div>
                </div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Tên sản phẩm'" placeholder="Tên sản phẩm" v-model="product.productName" />
                    </div>
                </div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Kích thước'" placeholder="Kích thước" v-model="product.productDimensions" />
                    </div>
                    <div class="h-col h-flex">
                        <Input :title="'Nguyên liệu'" placeholder="Nguyên liệu" v-model="product.productMaterial " />
                    </div>
                </div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Nhà sản xuất'" placeholder="Nhà sản xuất" v-model="product.productManufacturer " />
                    </div>
                    <div class="h-col h-flex">
                        <Input :title="'Màu sắc'" placeholder="Màu sắc" v-model="product.ProductColor" />
                    </div>
                </div>
                <div class="h-row h-display-flex h-mg-t10">
                    <div class="h-col h-flex">
                        <Input :title="'Giá gốc'" placeholder="Giá gốc" v-model=" product.productOriginalPrice" />
                    </div>
                    <div class="h-col h-flex">
                        <Input :title="'Giá sale'" placeholder="Giá sale" v-model="product.productSalePrice" />
                    </div>
                </div>
                <div class="h-row h-display-flex">
                    <div class="h-col h-flex">
                        <Textarea :title="'Mô tả ngắn'" placeholder="Mô tả ngắn" v-model=" product.poductDescriptionShort" />
                        </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <Textarea :title="'Mô tả'"
               placeholder="Mô tả" 
                v-model="product.productDescription"
                />
            </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <Input :title="'Đánh giá'"
               placeholder="Đánh giá"
                v-model="product.productEvaluate"
                 />
            </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <InputFile :title="'Ảnh sản phẩm'" ref="inputFile" :name="product.productImage"/>
            </div>
          </div>
        </div>
      </template>
      <template slot="footer">
        <div style="width: 100%">
          <div class="h-display-flex jus-end">
            <div class="h-button h-btn-cancel h-mr-15" @click="closePopup">
              Hủy bỏ
            </div>
            <div class="h-button h-btn-save" @click="saveProduct">Lưu</div>
          </div>
        </div>
      </template>
    </popup>
  </div>
</template>

<script>
import {
    mapActions
} from "vuex";
import {
    ModuleProduct
} from "@/store/module-const";
import Popup from "@/views/components/popup/Popup";
import Input from "@/views/components/input/Input";
import Textarea from "@/views/components/textarea/Textarea";
import InputFile from "@/views/components/inputFile/InputFile";
import commonFunc from '@/common/common';
export default {
    components: {
        Popup,
        Input,
        Textarea,
        InputFile,
    },
    name: "AdminProductDetail",
    props: {
        isShow: {
            typeof: Boolean,
            default: false,
        },
        product: {
            typeof: Object,
            default: null,
        },

        mode: {
            typeof: String,
            default: "add",
        },
    },
    data() {

        return {

        };
    },
    computed: {
        titlleMode() {
            const me = this;
            if (me.mode == 0) {
                return me.$t("i18nProduct.addProduct");
            }
            if (me.mode == 1) {
                return me.$t("i18nProduct.editProduct");
            }
            return "";
        },
    },
    methods: {
        ...mapActions(ModuleProduct, [
            "addProductAsync",
            "editProductAsync",
        ]),
        async loadData() {
            const me = this;
            await me.$emit("loadData");
        },
        async saveProduct() {
            const me = this;
            if(me.$refs.inputFile.fileName){
                  me.product.productImage = "";
            }
            me.product.productImage = commonFunc.convertImgSaveDB(me.$refs.inputFile.fileName);
            // Thêm
            if (me.mode == "add") {
                await me.addProductAsync(me.product);
            }
            // Sửa
            else if (me.mode == "edit") {
                await me.editProductAsync(me.product);
            }
            me.loadData();
            me.closePopup();
        },
        closePopup() {
            const me = this;
            me.$emit("closePopup");
        },
    },
};
</script>

<style scoped>
.h-popup {}

.h-titlte {
    font-weight: bold;
    font-size: 18px;
}

.h-row {
    margin-bottom: 10px;
}
</style>
