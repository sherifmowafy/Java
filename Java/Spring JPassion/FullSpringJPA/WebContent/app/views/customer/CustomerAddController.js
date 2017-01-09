(function(){
	'use strict'
	angular.module('app').controller('CustomerAddController', [customerController]);
	
	function customerController(){
		var vm = this;
		vm.msg = 'Hello Add World';
	}
	
}());