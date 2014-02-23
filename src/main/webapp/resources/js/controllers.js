
var movieGuideControllers = angular.module('movieGuideControllers', []);

movieGuideControllers.controller('MovieController', ['$scope', 'Movie',function($scope, Movie)
 {
	$scope.hello = "hello";
	 $scope.movies = Movie.query();
	 $scope.movie = Movie.get({},{'movieName' : 'Inception'});
 }]);



