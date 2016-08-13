(function(){

    var app = angular.module('myApp', []);

    app.controller('TechnologiesController', function($scope, $http) {
        $http.get('/technologies').success(function(data){
            $scope.technologies = data;
        });
    });

    app.controller('PagesController', function($scope, $http) {
        $http.get('/pages').success(function(data){
            $scope.pages = data;
        });
    });

}());
