
function User(){
    let user = {
        "userId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "userName" : "",
        "password" : "",
        "fullName" : "",
        "phoneNumber" : "",
        "address" : ""
    }
    return user;
}

function Recruitment(){
    let recruitment = {
        "recruitmentId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "recruitmentContent" : "",
        "recruitmentTitle" : "",
        "linkImage" : ""
    };
    return recruitment;
}
function Project(){
    let project = {
        "projectId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "projectContent" : "",
        "projectTitle" : "",
        "linkImage" : ""
    };
    return project;
}
function ProductCategory(){
    let productCategory = {
        "productCategoryId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "productCategoryName" : "",
        "productCategoryDescription" : "",
        "productCategoryImage" : ""
    };
    return productCategory;
}
function Product(){
    let product = {
        "productId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "productCategoryId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "productName" : "",
        "productDimensions" : "",
        "productMaterial" : "",
        "productManufacturer" : "",
        "ProductColor" : "",
        "productOriginalPrice" : "",
        "productSalePrice" : "",
        "poductDescriptionShort" : "",
        "productDescription" : "",
        "productEvaluate" : "",
        "productImage" : ""
    };
    return product;
}
function OrderDetail1(){
    let orderDetail = {
        "orderId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "productId" : "1253c55e-11ef-47d2-939c-f8af2ab5b43e",
        "amount" : ""
    };
    return orderDetail;
}
function Order(){
    let order = {
        "userId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "orderId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e"
      
    };
    return order;
}
function News(){
    let news = {
        "newsId" : "1253c55e-11ef-47d2-939c-f8af2ab5b47e",
        "newsTitle" : "",
        "newsContent" : "",
        "linkImage" : "",
        "newsHot" : "",
        "newsProduct" : "",
        "newSale" : "",
        "newsEvent" : ""
    };
    return news;
}
export {User,Recruitment,Project,ProductCategory,Product,OrderDetail1,Order,News}