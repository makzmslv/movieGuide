'use strict';

var addController = function($scope, $http) {
	var currencyEntity = {};
	$scope.add = function(productName, price, unitName, latitude, longitude) {
		$http.get('currencies/' + latitude + '/' + longitude).success(
				function(currency) {
					currencyEntity =  currency.currencyName;
					var priceRecord = {};
					var location = [ longitude, latitude ];
					priceRecord.productName = productName;
					priceRecord.unit = unitName;
					priceRecord.currency = currencyEntity;
					priceRecord.price = price;
					priceRecord.location = location;

					$http.post('priceRecords', priceRecord).success(function(priceRecord) {
						$scope.priceRecord = priceRecord;
						if (priceRecord.productName == null) {
							$scope.showMessage = true;
						} else {
							$scope.showMessage = false;
							$scope.productName = "";
							$scope.unitName = "";
							$scope.price = "";
						}
					});
				});
	};
	
	$scope.showMessage = false;

	angular.extend($scope, {
		center : {
			latitude : 18, // initial map center latitude
			longitude : 76, // initial map center longitude
		},
		markers : [], // an array of markers,
		zoom : 8, // the zoom level
		clickedLatitudeProperty : null,
		clickedLongitudeProperty : null,

	});
};