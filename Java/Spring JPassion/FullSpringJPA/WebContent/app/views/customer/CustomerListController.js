(function(){
	'use strict'
	angular.module('app').controller('CustomerListController', ['customerService', '$stateParams', customerController]);

	function customerController(customerService, $stateParams){
		var vm = this;
		var page = $stateParams.page  ;
		console.log("page = " + page);
		customerService.getAll(page).then(
				function successCallback(response) {
					console.log("Getting all customers paging...");
					console.log(response.customers);
					vm.customers = response.customers;
				}, function errorCallback(error) {
					console.log(error);
				});
		vm.removeCustomer = function(customer){
			customerService.remove(customer.id).then(
					function successCallback(response){
						console.log(response);
						vm.customers.splice(vm.customers.indexOf(customer), 1);
					}, function errorCallback(error){
						console.log(error);
					});
		}






	}

}());