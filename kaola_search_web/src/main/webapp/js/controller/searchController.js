app.controller("searchController",function ($scope,$http,searchService) {
      
    $scope.search=function () {
        searchService.search($scope.searchMap).success(
            function (response) {
                $scope.resultMap=response;//搜索返回数据
            }
        )
    }
    
})