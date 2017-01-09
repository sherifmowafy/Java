(function(){
	'use strict'
	angular.module('app').controller('CustomerEditController', ['$stateParams', customerController]);
	
	function customerController($stateParams){
		var vm = this;
		vm.msg = 'Hello Edit World, Custtomer ID = ' +  $stateParams.customerId;
	}
	
}());