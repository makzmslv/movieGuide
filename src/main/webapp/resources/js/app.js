'use strict';
//Declare app level module which depends on filters, and services
var pricesApp = angular.module('movieGuide', [ 'ngRoute', 'movieGuideControllers', 'movieGuideServices' ]);

pricesApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/list', {
		templateUrl : 'resources/html/list.html',
		controller : 'MovieController'
	}).when('/add', {
        templateUrl: 'resources/html/add.html',
        controller: 'addController'
      }).when('/showDetails', {
          templateUrl: 'resources/html/showDetails.html',
          controller: 'ShowDetailsController'
        }).when('/scan', {
            templateUrl: 'resources/html/scan.html',
            controller: 'ScanController'
          }).when('/getDetails', {
              templateUrl: 'resources/html/getDetails.html',
              controller: 'GetDetailsController'
            });

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
