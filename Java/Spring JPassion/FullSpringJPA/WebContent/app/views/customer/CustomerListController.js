(function(){
	'use strict'
	angular.module('app').controller('CustomerListController', ['customerService', customerController]);
	
	function customerController(customerService){
		var vm = this;
		vm.msg = 'Hello List World';
		
		customerService.getCustomer(1).then(function successCallback(response) {
		    console.log(response);
		  }, function errorCallback(response) {
			  console.log(response);
		  });
	}
	
}());