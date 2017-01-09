(function(){
	'use strict';
	angular.module('erp.services.module').service('customerService', ['$http', customerService]);
		
	function customerService($http){
		var service = this;
		service.getCustomer = function(id){
			return $http({
				  method: 'GET',
				  url: 'spring/customer/' + id
				});
		}
	}
	
	
})();