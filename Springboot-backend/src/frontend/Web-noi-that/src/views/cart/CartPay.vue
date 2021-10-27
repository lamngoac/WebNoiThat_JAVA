<template>
    <div>
   <section class="section_breacrumb">
      <div class="container">
         <ul class="breadcrumb clearfix" itemscope="" itemtype="http://schema.org/BreadcrumbList">
            <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
               <a itemprop="item" href="">
               <span itemprop="name">Home</span>
               </a>
               <meta itemprop="position" content="1">
            </li>
            <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
               <a itemprop="item" href="">
               <span itemprop="name">Giỏ hàng</span>
               </a>
               <meta itemprop="position" content="2">
            </li>
         </ul>
      </div>
   </section>
   <section class="cards container">
      <div class="row">
         <div class="col-lg-6">
         <span class="title_cards title-address ">Đỉa chỉ nhận hàng</span>
        <from class=" from ">  
            <p  class="item__name ">Họ và tên</p>
            <input type="text" class="form-control mb-set"  placeholder="Nhập tên của ban *">
            <p  class="item__name ">Số điện thoại</p>
            <input type="text" class="form-control mb-set"  placeholder="Nhập số điện thoại *">
            <p  class="item__name ">Địa chỉ cụ thể</p>
            <input type="text" class="form-control mb-set"  placeholder="Số nhà 19, ngõ 68 Lễ Hữu Phước, ...">
            <p  class="item__name ">Ghi chú</p>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder="Ghi chú"></textarea>
        </from> 
        
        <div class="box-card box-oder  ">
                   <p class=" item_total item_arena item_boder" > Tổng tiền <span class= "price_d" > 15.000.000đ</span></p>
                   <p class=" item_arena item_boder"> Phí vận chuyển  <span class=""> Đang cập nhật </span></p>
                   <p class=" item_arena item_boder"> Tổng giá trị thanh toán <span class= "price" > 15.000.000đ</span> </p>
        </div>
        <a href="#" class="btn-oder btn-confirm" title=""> Xác nhận đặt hàng </a>
        <a href="#" class="btn-oder btn-cancel" title=""> Hủy</a>


         </div>
         <div class="col-lg-6 set-table mt-3 mt-lg-0">
            <span class="title_cards title_cards_set">Đơn hàng của bạn</span> 
            <div class="tables-alls tables-prds__carts ">
               <table class=" table">
                  <thead>
                     <tr>
                        <th>
                           <!--<input type="checkbox" class="checks-box"> -->  
                        </th>
                        <th> Sản phẩm</th>
                        <th> Số lượng </th>
                        <th> Giá </th>
                        <th> </th>
                     </tr>
                  </thead>
                  <tbody>
                     <tr v-for="index in 3" :key="index" class="tr">
                        <td>
                           <div class="img-prds__img ">
                              <a href="#" title="" class="d-block">
                              <img :src="require('@/assets/content/images/project'+(index+1) +'.jpg')" alt="" class="img-fluid" />
                              </a> 
                           </div>
                        </td>
                        <td>
                           <div class="items-prds__carts">
                              <div class="intros-prds__carts">
                                 <h3> <a href= "#" class="names-prds__carts titles-md__alls fs-16s" title=""> Ghế đọc sách GĐS001 </a> 
                                 </h3>
                              </div>
                           </div>
                        </td>
                        <td>
                           <p class="main-price-cart price-cart"> <strong class="price d-block main-price" data-price="0">X1</strong> </p>
                        </td>
                        <td>
                           <p class="main-price-cart price-cart"> <strong class="price prices d-block subtotal">3.650.00đ</strong> </p>
                        </td>
                     </tr>
                  </tbody>
               </table>
            </div>
         </div>
      </div>
   </section>
    </div>
</template>

<script>
    export default {
        
    }
</script>

<style lang="scss" scoped>

</style>