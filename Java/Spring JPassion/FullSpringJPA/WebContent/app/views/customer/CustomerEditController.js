(function(){
	'use strict'
	angular.module('app').controller('CustomerEditController', ['$stateParams', customerController]);
	
	function customerController($stateParams){
		var vm = this;
		vm.msg = 'Hello Edit World, Custtomer ID = ' +  $stateParams.customerId;
		
		
		customerService.getById(1).then(
				function successCallback(response) {
					console.log("Getting customer 1 ...");
					console.log(response.customer);
				}, function errorCallback(error) {
					console.log(error);
				});

		customerService.update({id:13, name:"AngularJS updated"}).then(
				function successCallback(response){
					console.log("Updating customer ...");
					console.log(response.customer);
				}, function errorCallback(){
					console.log(error);
				});
		
		
		
	}
	
}());