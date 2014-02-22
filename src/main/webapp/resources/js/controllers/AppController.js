'use strict';

var searchController = function($scope, $http) {
	$scope.fetchCurrencyList = function() {
		$http.get('currencies').success(function(currencyList) {
			$scope.currencies = currencyList;
		});
	};
	$scope.search = function(searchString, latitude, longitude) {
		var radius = 1;
		$http.get(
				'search/' + latitude + '/' + longitude + '/' + radius + '/'
						+ searchString).success(function(searchList) {
			$scope.searchList = searchList;
			$scope.products = $scope.searchList.products;
			if (searchList.searchTerm == null) {
				$scope.showMessage = true;
			} else {
				$scope.showMessage = false;
			}
		});
		
	};
	$scope.showMessage = false;
	//$scope.fetchCurrencyList();
	
	angular.extend($scope, {
		center: {
			latitude: 18, // initial map center latitude
			longitude: 76, // initial map center longitude
		},
		markers: [], // an array of markers,
		zoom: 8, // the zoom level
		clickedLatitudeProperty: null,	
		clickedLongitudeProperty: null,
		
	});
};