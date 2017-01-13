(function(){
	'use strict'
	angular.module('app').controller('CustomerListController', ['customerService', customerController]);

	function customerController(customerService){
		var vm = this;
		vm.msg = 'Hello List World';
		
		customerService.getAll(4).then(
				function successCallback(response) {
					console.log("Getting all customers paging...");
					console.log(response.customers);
				}, function errorCallback(error) {
					console.log(error);
				});
		
		customerService.remove(16).then(
				function successCallback(response){
					console.log("Removing customer ...");
					console.log(response);
				}, function errorCallback(error){
					console.log(error);
				});
	}

}());