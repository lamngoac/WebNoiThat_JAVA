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
                        <Input :title="'Tên danh mục sản phẩm'" placeholder="Tên danh mục sản phẩm" v-model="productCategory.productCategoryName" />
                    </div>
                </div>
                <div class="h-row h-display-flex">
                    <div class="h-col h-flex">
                        <Textarea :title="'Mô tả'" placeholder="Mô tả" v-model="productCategory.productCategoryDescription" />
                        </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <InputFile :title="'Ảnh danh mục sản phẩm'" ref="inputFile" :name="productCategory.productCategoryImage"/>
            </div>
          </div>
          <div class="h-row h-display-flex">
            <div class="h-col h-flex">
              <Input
                :title="'Hiển thị ở trang chủ'"
                placeholder="Hiển thị ở trang chủ"
                v-model="productCategory.productCategoryHome"
              />
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
            <div class="h-button h-btn-save" @click="saveProductCategory">
              Lưu
            </div>
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
    ModuleProductCategory
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
    name: "AdminProductCategoryDetail",
    props: {
        isShow: {
            typeof: Boolean,
            default: false,
        },
        productCategory: {
            typeof: Object,
            default: null,
        },

        mode: {
            typeof: String,
            default: "add",
        },
    },
    data() {
        return {};
    },
    computed: {
        titlleMode() {
            const me = this;
            if (me.mode == 0) {
                return me.$t("i18nProductCategory.addProductCategory");
            }
            if (me.mode == 1) {
                return me.$t("i18nProductCategory.editProductCategory");
            }
            return "";
        },
    },
    methods: {
        ...mapActions(ModuleProductCategory, [
            "addProductCategoryAsync",
            "editProductCategoryAsync",
        ]),

        insertProductCategory(params) {
            const me = this;

            me.addProductCategory(params);
        },
        async loadData() {
            const me = this;
            await me.$emit("loadData");
        },
        async saveProductCategory() {
            const me = this;
            if (me.$refs.inputFile.fileName) {
                me.productCategory.productCategoryImage = "";
            }
            me.productCategory.productCategoryImage = commonFunc.convertImgSaveDB(me.$refs.inputFile.fileName);
            // Thêm
            if (me.mode == "add") {
                await me.addProductCategoryAsync(me.productCategory);
            }
            // Sửa
            else if (me.mode == "edit") {
                await me.editProductCategoryAsync(me.productCategory);
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
