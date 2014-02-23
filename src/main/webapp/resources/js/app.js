'use strict';

var pricesApp = angular.module('movieGuide', [ 'ngRoute', 'movieGuideControllers', 'movieGuideServices' ]);

// Declare app level module which depends on filters, and services
pricesApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/movies', {
		templateUrl : 'resources/html/search.html',
		controller : 'MovieController'
	}).when('/add', {
        templateUrl: 'resources/html/add.html',
        controller: 'addController'
      });

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
