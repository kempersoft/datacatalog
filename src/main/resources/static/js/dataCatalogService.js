'use strict';

/* Controllers */


var dataCatalogService = angular.module('dataCatalogService', ['ngResource']);

dataCatalogService.factory('DataCatalogService', ['$resource', function ($resource) {
    return $resource('org/kempersoft/api/datacatalog', {}, {
        getDataCatalog: {
            method: 'GET',
            isArray: false
        },
        getDatasource: {
            method: 'GET',
            url: 'org/kempersoft/api/datacatalog/:datasourceId',
            isArray: false
        }

    });
}]);
			

