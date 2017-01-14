(function(){
	'use strict';
	angular.module('app').controller('CustomerDetailsController', ['customerService', '$stateParams', customerDetailsController]);
	
	function customerDetailsController(customerService, $stateParams){
		
		var vm = this;
		var customerId = $stateParams.customerId;
		
		
		customerService.getById(customerId).then(
				function successCallback(response) {
					console.log("Getting customer 1 ...");
					vm.customer = response.customer;
					
				}, function errorCallback(error) {
					console.log(error);
				});
		
	}
	
	
})();