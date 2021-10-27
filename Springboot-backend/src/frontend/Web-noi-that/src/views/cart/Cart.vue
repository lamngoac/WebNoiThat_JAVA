<template>
<div>
    <section class="section_breacrumb">
        <div class="container">
            <ul class="breadcrumb clearfix" itemscope="" itemtype="http://schema.org/BreadcrumbList">
                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                    <a itemprop="item" href="">
                        <span itemprop="name">Trang chủ</span>
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
        <span class="title_cards">Giỏ hàng của bạn</span>
        <span class="card_d">( 3 sản phẩm) </span>
        <div class="tables-alls tables-prds__carts mb-lg-4 mb-3">
            <table class=" table">
                <thead>
                    <tr>
                        <th> <input type="checkbox" class="checks-box"> </th>
                        <th> Tên sản phẩm</th>
                        <th> Giá </th>
                        <th> Số lượng </th>
                        <th> Thành tiền </th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="index in 3" :key="index" class="tr">
                        <td>
                            <input type="checkbox" class="checks-box">
                            <div class="img-prds__img ">
                                <a href="#" title="" class="d-block">
                                    <img :src="require('@/assets/content/images/project'+(index+1) +'.jpg')" alt="" class="img-fluid" />
                                </a>
                            </div>
                        </td>
                        <td>

                            <div class="items-prds__carts">
                                <div class="intros-prds__carts">
                                    <h3> <a href="#" class="names-prds__carts titles-md__alls fs-16s" title=""> Ghế đọc sách GĐS001 </a>
                                    </h3>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="main-price-cart price-cart"> <strong class="price d-block main-price" data-price="0">3.650.00đ</strong> </p>
                        </td>
                        <td>
                            <div class="product-many">
                                <div class="quanty form-group">
                                    <div class="inputNumberMinus value-button down-btns" value="Decrease Value">−</div>
                                    <input type="number" name="qty" class="qty number" id="number" value="1" min="0" max="100">
                                    <div class="inputNumberPlus value-button up-btns" value="Increase Value">+</div>
                                </div>
                            </div>
                        </td>
                        <td>
                            <p class="main-price-cart price-cart"> <strong class="price prices d-block subtotal">3.650.00đ</strong> </p>
                        </td>
                        <td>
                            <p class="_tech5s_cart_delete_cart delete-carts__items"> <i class="fa fa-trash-o" aria-hidden="true"></i> </p>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div class="item">
            <div class="row">
                <div class="col-lg-6 ">
                    <div class="btn-all d-flex">
                        <a href="#" class=" btn-default btn-set bt-img"> Tiếp tục mua hàng <img src="../../assets/content/images/arrow-right.svg" alt="Xem thêm" class=""> </a>
                        <a href="#" class="  btn-default btn-set btl-mr"> <img src="../../assets/content/images/update.svg" alt="Xem thêm" class=" ml-2"> Cập nhật giỏ hàng </a>
                    </div>

                    <p class="item-name">Ghi chú đơn hàng</p>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>

                </div>
                <div class="col-lg-6">
                    <div class="box-card ">
                        <p class=" item_total"> Tổng giỏ hàng </p>
                        <p class=" item_arena"> Số lượng <span class=""> 1 </span></p>
                        <p class=" item_arena"> Tổng tiền: <span class="price"> 360.000Đ</span> </p>
                        <a href="#" class=" btn-default  btn-set"> Tiến hành thanh toán <img src="../../assets/content/images/arrow-right_black.svg" alt="Xem thêm" class="ms-2"> </a>
                    </div>
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
