'use strict';

/* Controllers */

var appController = angular.module('appController', []);

appController.controller('AppController', ['$scope',
    function ($scope) {
        // set some initial state...
        $scope.detailspane = {};
        $scope.detailspane.details = 'None';
    }
]);



