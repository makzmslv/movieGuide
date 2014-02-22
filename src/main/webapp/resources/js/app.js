'use strict';

var pricesApp = angular.module('pricesAngular', [ 'ngRoute', 'google-maps' ]);

// Declare app level module which depends on filters, and services
pricesApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/db', {
		templateUrl : 'resources/html/search.html',
		controller : 'searchController'
	}).when('/add', {
        templateUrl: 'resources/html/add.html',
        controller: 'addController'
      });

	$routeProvider.otherwise({
		redirectTo : '/'
	});
} ]);
