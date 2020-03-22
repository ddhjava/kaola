app.controller("contentController",function ($scope,$http,contentService) {

    //查询广告位展示
    $scope.contentList=[];

    $scope.findByCategoryId=function (categoryId) {
        contentService.findByCategoryId(categoryId).success(
            function (response) {
                $scope.contentList[categoryId]=response;
            }
        )
    }
})