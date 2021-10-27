<template>
<div>
    <section class="section_breacrumb">
        <div class="container">
            <ul class="breadcrumb clearfix" itemscope="" itemtype="http://schema.org/BreadcrumbList">
                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                    <a itemprop="item" href="https://thekey2.tech5s.net/">
                        <span itemprop="name">Trang chủ</span>
                    </a>
                    <meta itemprop="position" content="1">
                </li>
                <li itemprop="itemListElement" itemscope="" itemtype="http://schema.org/ListItem">
                    <a itemprop="item" href="https://thekey2.tech5s.net/videos">
                        <span itemprop="name">Nội thất gỗ</span>
                    </a>
                    <meta itemprop="position" content="2">
                </li>
            </ul>
        </div>
    </section>
    <section class="page_detail">
        <div class="container">
            <div class="row overflow-hidden">
                <div class="col-lg-7">
                    <div class="row mx-0">
                        <div class="col-lg-3 col-4 overflow-hidden wow fadeInLeft">
                            <div class="slide_product_thumb">
                                <div class="swiper-container">
                                    <div class="swiper-wrapper">
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb1.jpg" class="img-fluid">
                                        </div>
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb2.jpg" class="img-fluid">
                                        </div>
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb3.jpg" class="img-fluid">
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="col-lg-9 col-8 wow fadeInUp">
                            <div class="slide_product">
                                <div class="swiper-container">
                                    <div class="swiper-wrapper">
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb1.jpg" class="img-fluid">
                                        </div>
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb2.jpg" class="img-fluid">
                                        </div>
                                        <div class="swiper-slide">
                                            <img src="../../assets/content/images/img-thumb3.jpg" class="img-fluid">
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-5 mt-lg-0 mt-3 wow fadeInRight">
                    <h1 class="title_page mb-lg-3 pb-2 mb-3">Ghế đọc sách GĐS001</h1>
                    <div class="d-flex flex-wrap justifly-content-between infomation mb-lg-3 mb-2">
                        <div class="code">MSP: GĐS001</div>
                        <div class="_rating position-relative d-flex">
                            <div class="_star position-absolute top-0 start-0">
                                <span v-for="index1 in 4" :key="index1"><i class="fa fa-star" aria-hidden="true"></i></span>
                            </div>
                            <div class="_star-blank">
                                <span v-for="index2 in 5" :key="index2"><i class="fa fa-star-o" aria-hidden="true"></i></span>
                            </div>
                            <span class="ratting_point ms-2">4.8</span>
                        </div>
                        <div class="count_comment ">Bình luận: <span class="number">15</span></div>
                    </div>
                    <div class="box_specs">
                        <div class="recond_properties">
                            <span class="key">Kích thước: </span>
                            <span class="value">Tùy chọn</span>
                        </div>
                        <div class="recond_properties">
                            <span class="key">Chất liệu: </span>
                            <span class="value">Gỗ thông</span>
                        </div>
                        <div class="recond_properties">
                            <span class="key">Nhà sản xuất: </span>
                            <span class="value">Tasa-wood</span>
                        </div>
                        <div class="recond_properties d-flex">
                            <span class="key">Màu sắc:</span>
                            <div class="value">
                                <label for="color_1" data-toggle="tooltip" data-placement="top" title="" class="choose_color chose_color_click active" style="background: #6D79B8;color:#6D79B8;" data-original-title="Xanh Cobalt">
                                    <input type="radio" name="color" value="" data-id="">
                                    <span class="checked check_color_click"></span>
                                </label>
                                <label for="color_1" data-toggle="tooltip" data-placement="top" title="" class="choose_color chose_color_click" style="background: #9BD8D0;color:#9BD8D0;" data-original-title="Xanh Cobalt">
                                    <input type="radio" name="color" value="" data-id="">
                                    <span class="checked check_color_click"></span>
                                </label>
                                <label for="color_1" data-toggle="tooltip" data-placement="top" title="" class="choose_color chose_color_click" style="background: #FFE143;color:#FFE143;" data-original-title="Xanh Cobalt">
                                    <input type="radio" name="color" value="" data-id="">
                                    <span class="checked check_color_click"></span>
                                </label>
                            </div>
                        </div>
                        <div class="description">
                            <div class="s-content">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ligula ut eleifend tincidunt vulputate libero porta aenean nibh facilisis. Quisque libero neque eget donec eu orci.</p>
                            </div>
                        </div>
                        <div class="box_price">
                            <span class="price_stock">3.599.000đ</span>
                            <span class="price_sale">2.898.000đ</span>
                        </div>
                        <div class="box_action d-flex flex-wrap align-items-center">
                            <div class="box_qty">
                                <span class="title me-2 pe-1">Số lượng</span>
                                <div class="quanty change_qty" id="input_div">
                                    <button class="inputNumberMinus moins">
                                        <img src="../../assets/content/images/minus.svg" alt="Trừ">
                                    </button>
                                    <input type="number" name="qty" value="1" class="qty number text-center" id="number" min="1" max="100"> <button class="inputNumberPlus plus">
                                        <img src="../../assets/content/images/plus_.svg" alt="Cộng">
                                    </button>
                                </div>
                            </div>
                            <a href="" title="Thêm vào giỏ hàng" class="smooth d-inline-block add_cart">Thêm vào giỏ hàng</a>
                        </div>
                        <a href="" title="Đặt hàng ngay" class="btn_all smooth d-block">Đặt hàng ngay</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section_all section_details__content">
        <div class="container">
            <div class="row">
                <div class="col-lg-9 mb-lg-0 mb-3">
                    <div class="box__detail_content wow fadeInUp">
                        <ul class="nav nav-tabs" id="myTab" role="tablist">
                            <li class="nav-item" role="presentation">
                                <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button" role="tab" aria-controls="home" aria-selected="true">MÔ TẢ</button>
                            </li>
                            <li class="nav-item" role="presentation">
                                <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button" role="tab" aria-controls="profile" aria-selected="false">NHẬN XÉT & ĐÁNH GIÁ</button>
                            </li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                <div class="s-content">
                                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC,
                                        making it over 2000 years old. Richard McClintock, a
                                        Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.
                                        Contrary to popular belief, Lorem Ipsum is not simply random text.
                                        It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.
                                        Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.Contrary to popular belief, Lorem Ipsum is not simply random text.
                                        It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.
                                        Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.Contrary to p
                                    </p>
                                    <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur.Contrary to p</p>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-3 mb-lg-0 mb-3 wow fadeInUp">
                    <div class="selling-prod">
                        <p class="selling-prod__title pb-lg-3 pb-2 wow fadeInUp">TOP SẢN PHẨM BÁN CHẠY</p>
                        <div class="row row-cols-lg-1 row-cols-2 pb-lg-3 pb-2 gy-3">
                            <div v-for="index1 in 4" :key="index1" class="col selling-prod__item wow flipInX" :data-wow-delay="`${index1*0.1}`+'s'" data-wow-duration="1s">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <a href="" class="_img-link" title="">
                                            <img src="../../assets/content/images/selling_prd.jpg" alt="" class="_img img-fluid">
                                        </a>
                                    </div>
                                    <div class="col-sm-8">
                                        <a href="" class="_link d-block mb-sm-2 mb-1">Ghế khách sạn KS001</a>
                                        <div class="_rating position-relative mb-sm-2 mb-1">
                                            <div class="_star position-absolute top-0 start-0">
                                                <span v-for="index in 4" :key="index"><i class="fa fa-star" aria-hidden="true"></i></span>
                                            </div>
                                            <div class="_star-blank">
                                                <span v-for="index2 in 5" :key="index2"><i class="fa fa-star-o" aria-hidden="true"></i></span>
                                            </div>
                                        </div>
                                        <div class="_price">
                                            <span class="_regular-price fw-bold">22.000.000đ</span>
                                            <span class="_sale-price text-decoration-line-through">22.000.000đ</span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <a href="" class="_more text-lg-start text-center d-block">Xem tất cả sản phẩm
                            <!-- <img src="../../assets/content/images/long arrow.svg" alt="" class="_img svg-icon ms-lg-3 ms-2 img-fluid"/> -->
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="section sale-prd class_duplicate">
        <div class="container">
            <h2 class="section__title text-uppercase text-center wow fadeInUp">Sản phẩm cùng loại</h2>
            <div class="sale-prd__slider position-relative">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div v-for="index in 6" :key="index" class="swiper-slide sale-prd__item h-100 wow flipInX" :data-wow-delay="`${index*0.1}`+'s'" data-wow-duration="1s">
                            <a href="" class="_img-link d-block" title="">
                                <img src="../../assets/content/images/sale-prd.jpg" alt="" class="_img img-fluid">
                            </a>
                            <a href="" class="_link d-block mb-sm-2 mb-1 mt-lg-4 mt-md-3 mt-2" title="">Ghế đơn
                                phòng
                                khách SR001</a>
                            <div class="sale-prd__content d-flex justify-content-between align-items-center">
                                <div class="sale-prd__price-rating">
                                    <div class="_price mb-sm-2 mb-1">1.950.000đ</div>
                                    <div class="_rating position-relative mb-2">
                                        <div class="_star position-absolute top-0 start-0">
                                            <span v-for="index1 in 4" :key="index1"><i class="fa fa-star" aria-hidden="true"></i></span>
                                        </div>
                                        <div class="_star-blank">
                                            <span v-for="index2 in 5" :key="index2"><i class="fa fa-star-o" aria-hidden="true"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <a href="" class="_add-to-cart rounded-circle">
                                    <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <g clip-path="url(#clip0)">
                                            <path d="M8.25773 20.1397C8.7625 20.1397 9.17171 19.7305 9.17171 19.2257C9.17171 18.721 8.7625 18.3118 8.25773 18.3118C7.75295 18.3118 7.34375 18.721 7.34375 19.2257C7.34375 19.7305 7.75295 20.1397 8.25773 20.1397Z" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                            <path d="M18.3105 20.1397C18.8152 20.1397 19.2244 19.7305 19.2244 19.2257C19.2244 18.721 18.8152 18.3118 18.3105 18.3118C17.8057 18.3118 17.3965 18.721 17.3965 19.2257C17.3965 19.7305 17.8057 20.1397 18.3105 20.1397Z" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                            <path d="M0.947266 0.946289H4.60318L7.05264 13.1845C7.13622 13.6053 7.36514 13.9832 7.69932 14.2523C8.03351 14.5213 8.45167 14.6642 8.8806 14.656H17.7645C18.1934 14.6642 18.6116 14.5213 18.9457 14.2523C19.2799 13.9832 19.5088 13.6053 19.5924 13.1845L21.0548 5.51618H5.51716" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                        </g>
                                        <defs>
                                            <clipPath id="clip0">
                                                <rect width="21.9355" height="21.9355" fill="whitex" transform="translate(0.03125 0.0322266)" />
                                            </clipPath>
                                        </defs>
                                    </svg>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="--sale-prd swiper-button-next"></div>
                <div class="--sale-prd swiper-button-prev"></div>
            </div>
        </div>
    </section>
    <section class="section sale-prd bg_f5 slider_samesame class_duplicate">
        <div class="container">
            <h2 class="section__title text-uppercase text-center wow fadeInUp">Sản phẩm đã xem</h2>
            <div class="sale-prd__slider position-relative">
                <div class="swiper-container">
                    <div class="swiper-wrapper">
                        <div v-for="index in 6" :key="index" class="swiper-slide sale-prd__item h-100 wow flipInX" :data-wow-delay="`${index*0.1}`+'s'" data-wow-duration="1s">
                            <a href="" class="_img-link d-block" title="">
                                <img src="../../assets/content/images/sale-prd.jpg" alt="" class="_img img-fluid">
                            </a>
                            <a href="" class="_link d-block mb-sm-2 mb-1 mt-lg-4 mt-md-3 mt-2" title="">Ghế đơn
                                phòng
                                khách SR001</a>
                            <div class="sale-prd__content d-flex justify-content-between align-items-center">
                                <div class="sale-prd__price-rating">
                                    <div class="_price mb-sm-2 mb-1">1.950.000đ</div>
                                    <div class="_rating position-relative mb-2">
                                        <div class="_star position-absolute top-0 start-0">
                                            <span v-for="index1 in 4" :key="index1"><i class="fa fa-star" aria-hidden="true"></i></span>
                                        </div>
                                        <div class="_star-blank">
                                            <span v-for="index1 in 5" :key="index1"><i class="fa fa-star-o" aria-hidden="true"></i></span>
                                        </div>
                                    </div>
                                </div>
                                <a href="" class="_add-to-cart rounded-circle">
                                    <svg width="22" height="22" viewBox="0 0 22 22" fill="none" xmlns="http://www.w3.org/2000/svg">
                                        <g clip-path="url(#clip0)">
                                            <path d="M8.25773 20.1397C8.7625 20.1397 9.17171 19.7305 9.17171 19.2257C9.17171 18.721 8.7625 18.3118 8.25773 18.3118C7.75295 18.3118 7.34375 18.721 7.34375 19.2257C7.34375 19.7305 7.75295 20.1397 8.25773 20.1397Z" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                            <path d="M18.3105 20.1397C18.8152 20.1397 19.2244 19.7305 19.2244 19.2257C19.2244 18.721 18.8152 18.3118 18.3105 18.3118C17.8057 18.3118 17.3965 18.721 17.3965 19.2257C17.3965 19.7305 17.8057 20.1397 18.3105 20.1397Z" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                            <path d="M0.947266 0.946289H4.60318L7.05264 13.1845C7.13622 13.6053 7.36514 13.9832 7.69932 14.2523C8.03351 14.5213 8.45167 14.6642 8.8806 14.656H17.7645C18.1934 14.6642 18.6116 14.5213 18.9457 14.2523C19.2799 13.9832 19.5088 13.6053 19.5924 13.1845L21.0548 5.51618H5.51716" stroke="#FFCA08" stroke-width="1.3" stroke-linecap="round" stroke-linejoin="round" />
                                        </g>
                                        <defs>
                                            <clipPath id="clip0">
                                                <rect width="21.9355" height="21.9355" fill="whitex" transform="translate(0.03125 0.0322266)" />
                                            </clipPath>
                                        </defs>
                                    </svg>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="--sale-prd swiper-button-next"></div>
                <div class="--sale-prd swiper-button-prev"></div>
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
