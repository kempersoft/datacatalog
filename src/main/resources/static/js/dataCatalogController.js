'use strict';

/* Controllers */

var dataCatalogController = angular.module('dataCatalogController', []);


dataCatalogController.controller('DataCatalogController', ['$scope', '$location', 'DataCatalogService',
    function ($scope, $location, DataCatalogService) {


        $scope.getDataCatalog = function () {
            DataCatalogService.getDataCatalog().$promise.then(function (data) {
                $scope.dataCatalog = data;
                $scope.detailspane.details = 'None';
                $scope.detailspane.datasource = null;
            });
        };

        $scope.changeDatasource = function (datasourceId) {
            DataCatalogService.getDatasource({datasourceId: datasourceId}).$promise.then(function (data) {
                $scope.detailspane.details = 'Datasource';
                $scope.detailspane.datasource = data;
            });
        };


        $scope.getDataCatalog();


    }]);



