'use strict';

var pricesApp = angular.module('movieGuide', [ 'ngRoute', 'movieGuideControllers', 'movieGuideServices' ]);

// Declare app level module which depends on filters, and services
pricesApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/list', {
		templateUrl : 'resources/html/list.html',
		controller : 'MovieController'
	}).when('/add', {
        templateUrl: 'resources/html/add.html',
        controller: 'addController'
      }).when('/showDetails', {
          templateUrl: 'resources/html/showDetails.html',
          controller: 'addController'
        });

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
