'use strict';

/* Services */

var movieGuideServices = angular.module('movieGuideServices', ['ngResource']);

movieGuideServices.factory('Movie', ['$resource',
                                   function($resource)
                                   {
                                     return $resource('movies/:movieName', {movieName: "@movieName" }, {
                                    	 "update": {method: "PUT"}
                                     });
                                   }
								   ]);