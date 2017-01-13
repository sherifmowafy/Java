(function(){
	'use strict'
	angular.module('app').controller('CustomerAddController', ['customerService', customerController]);
	
	function customerController(customerService){
		var vm = this;
		vm.msg = 'Hello Add World';
		
		customerService.save({name:"AngularJS"}).then(
				function successCallback(response){
					console.log("Saving customer ...");
					console.log(response.customer);
				}, function errorCallback(){
					console.log(error);
				});
	}
	
}());