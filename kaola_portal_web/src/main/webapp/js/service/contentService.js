app.service("contentService",function ($http) {
    //查询打广告为
    this.findByCategoryId=function (categoryId) {
        return $http.get("/content/findByCategoryId.do?categoryId="+categoryId);
    }
})