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

movieGuideServices.factory('AdditionalInfo', ['$resource',
                                     function($resource)
                                     {
                                       return $resource('additionalInfo/:movieName', {movieName: "@movieName" }, {
                                      	 "update": {method: "PUT"}
                                       });
                                     }
  								   ]);

movieGuideServices.factory('Search', ['$resource',
                                     function($resource)
                                     {
                                       return $resource('search', {}, {
                                      	 "update": {method: "PUT"}
                                       });
                                     }
  								   ]);


movieGuideServices.factory('shareData', [
                                     function()
                                     {
                                    	 var dataToShare = null;

                                    	 return {
                                             getData: function () {
                                                 return dataToShare;
                                             },
                                             setData: function(value) {
                                            	 dataToShare = value;
                                             }
                                    	 };
                                     }
  								   ]);