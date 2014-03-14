
var movieGuideControllers = angular.module('movieGuideControllers', []);

movieGuideControllers.controller('MovieController', ['$scope','$location', 'Movie',function($scope, $location, Movie)
 {
	$scope.hello = "hello";
	 $scope.movies = Movie.query();

	 $scope.showDetails = function(index)
	 {
		 $location.url("/showDetails");
	 };
 }]);



