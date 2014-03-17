
var movieGuideControllers = angular.module('movieGuideControllers', ['ngResource']);

movieGuideControllers.controller('MovieController', ['$scope','$http','$location', 'Movie', 'shareData',function($scope, $http, $location, Movie, shareData)
 {
	 $scope.movies = Movie.query();
	 //$scope.movie = Movie.get({},{'movieName' : "Inception"});
	 $scope.showDetails = function(index)
	 {
		 shareData.setData($scope.movies[index]);
		 $location.url("/showDetails");
	 };

	 $scope.getDetails = function(index)
	 {
		 shareData.setData($scope.movies[index]);
		 $location.url("/getDetails");
	 };

 }]);

movieGuideControllers.controller('ShowDetailsController', ['$scope', 'shareData',function($scope, shareData)
{
	$scope.movie = shareData.getData();
	$scope.additionalInfo = $scope.movie.additional_Info;
 }]);

movieGuideControllers.controller('GetDetailsController', ['$scope', '$location', 'Movie', 'AdditionalInfo', 'shareData',function($scope, $location, Movie, AdditionalInfo, shareData)
{
	$scope.movie = shareData.getData();
	$scope.getInfo = function(movieName)
	{
		$scope.additionalInfo = AdditionalInfo.get({},{'movieName': movieName});
	};

	$scope.add = function()
	{
		var additionalInf = {};
	   	additionalInf.director = $scope.additionalInfo.director;
	   	additionalInf.genre = $scope.additionalInfo.genre;
	   	additionalInf.runtime = $scope.additionalInfo.runtime;
	   	additionalInf.plot = $scope.additionalInfo.plot;
	   	additionalInf.year = $scope.additionalInfo.year;
	   	additionalInf.imdbRating = $scope.additionalInfo.imdbRating;
	   	AdditionalInfo.save(additionalInf,function(data){
	   		var movi = {};
		   	movi = $scope.movie;
		   	movi.additional_Info = data;
		   	$scope.test  = $scope.additionalInfo.movieName;
		   	movi.name  = $scope.additionalInfo.movieName;
		   	Movie.save(movi,function(data){
		   		shareData.setData(data);
		   	    $location.url("/showDetails");
		   	});
	   	});

	};
}]);


movieGuideControllers.controller('ScanController', ['$scope','$location','$http', 'Movie', 'Search',function($scope, $location, $http, Movie, Search)
{
	$scope.test = "/home/makarandh/Videos";
	$scope.scan = function(path)
	 {
		var directoryPath = {};
		directoryPath = path;
		$http.post('search', directoryPath).success(function(data){
			$scope.movies = data;
			if($scope.movies.length == 0)
			{
				 alert("No new movies detected");
			}

		 }).error(function(data, status, headers, config) {
	         alert("Something went wrong !! Request was not successful");
		 });
	 };

	 $scope.add = function()
	 {
		 angular.forEach($scope.movies,function(value,index){
			 var movie = {};
			 movie.name = value.name;
			 movie.path = value.path;
			 movie.nameInSystem = value.nameInSystem;
			 Movie.save(movie,function(data){
			 	});
         });
		 alert("New Movies have been added to the Database");
		 $location.url("/list");
	 };
    }]);


//Movie.save(movi,function(data){
//	 alert("here");
//	 $scope.movie = data;
//});
