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
              <Input :title="'Mã đơn hàng'"
               placeholder="Mã đơn hàng"
                 v-model="orderDetail.orderId"
                />
            </div>
          </div>
           <div class="h-row h-display-flex h-mg-t10">
            <div class="h-col h-flex">
              <Input :title="'Mã sản phẩm'"
               placeholder="Mã sản phẩm"
                 v-model="orderDetail.productId" />
            </div>
          </div>
           <div class="h-row h-display-flex h-mg-t10">
            <div class="h-col h-flex">
              <Input :title="'Số lượng'"
               placeholder="Số lượng"
                v-model="orderDetail.amount" />
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
            <div class="h-button h-btn-save" @click="saveOrderDetail">Lưu</div>
          </div>
        </div>
      </template>
    </popup>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import { ModuleOrderDetail } from "@/store/module-const";
import Popup from "@/views/components/popup/Popup";
import Input from "@/views/components/input/Input";


export default {
  components: {
    Popup,
    Input,
  },
  name: "OrderDetail",
  props: {
    isShow: {
      typeof: Boolean,
      default: false,
    },
    orderDetail: {
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
        return me.$t("i18nOrderDetail.addOrderDetail");
      }
      if (me.mode == 1) {
        return me.$t("i18nOrderDetail.editOrderDetail");
      }
      return "";
    },
  },
  methods: {
     ...mapActions(ModuleOrderDetail, [
      "addOrderDetailAsync",
      "editOrderDetailAsync",
    ]),

    insertOrderDetail(params) {
      const me = this;

      me.addOrderDetail(params);
    },
    async loadData() {
      const me = this;
      await me.$emit("loadData");
    },
    async saveOrderDetail() {
      const me = this;
      // Thêm
      if (me.mode == "add") {
        // đối  tượng này làm gì có dữ liệu đâu
        // idol lấy tên cũng sai đcu
        console.log(1);
        await me.addOrderDetailAsync(me.orderDetail);
      }
      // Sửa
      else if (me.mode == "edit") {
        console.log(1);
        me.editOrderDetailAsync(me.orderDetail);
      }
      me.loadData();
      me.closePopup();
    },

    clickSaveOrderDetail() {
      const me = this;
      me.saveOrderDetail(() => {
        me.$emit("loadData");
        // me.closePopup();
      });
    },
    closePopup() {
      const me = this;
      me.$emit("closePopup");
    },
  },
};
</script>

<style scoped>
.h-popup {
}
.h-titlte {
  font-weight: bold;
  font-size: 18px;
}
.h-row {
  margin-bottom: 10px;
}
</style>