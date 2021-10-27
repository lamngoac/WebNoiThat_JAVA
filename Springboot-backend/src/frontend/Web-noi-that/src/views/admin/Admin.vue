<template>
<div>
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark h-navbar-top">
       
        <form class="
          d-none d-md-inline-block
          form-inline
          ms-auto
          me-0 me-md-3
          my-2 my-md-0
        ">
        </form>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav" >
                        <div class="sb-sidenav-menu-heading" style="color:yellow">Danh sách các bảng</div>
                        <router-link to="/admin" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý tin tức
                        </router-link>
                        <router-link to="/adminProject" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý dự án
                        </router-link>
                        <router-link to="/adminRecruitment" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý tuyển dụng
                        </router-link>
                        <router-link to="/adminProduct" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý sản phẩm
                        </router-link>
                        <router-link to="/adminProductCategory" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý danh mục sản phẩm
                        </router-link>
                        <router-link to="/adminOder" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý đơn hàng
                        </router-link>
                        <router-link to="/adminOderDetail" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý chi tiết đơn hàng
                        </router-link>
                         <router-link to="/adminUsers" class="nav-link" style="color:yellow">
                            <div class="sb-nav-link-icon"><i class="fa fa-table"></i></div>
                            Quản lý tài khoản
                        </router-link>
                    </div>
                </div>
            </nav>
        </div>
        <router-view></router-view>
    </div>
</div>
</template>

<script>
export default {};
</script>

<style scoped>
#layoutSidenav_nav {
    max-height: calc(100vh - 56px);
    min-height: calc(100vh - 56px);
}


</style>
