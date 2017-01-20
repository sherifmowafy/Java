(function(){
	'use strict'
	angular.module('app').controller('CustomerAddController', ['customerService', '$stateParams', '$state', customerController]);

	function customerController(customerService, $stateParams, $state){
		var vm = this;
		var customerId = $stateParams.customerId;
		customerId = (typeof(customerId) == "undefined") ? 0: customerId;
		vm.customer = {};


		if(customerId == 0){
			vm.label = "Add Customer";
		}else{
			vm.label = "Edit Customer";
			customerService.getById(customerId).then(
					function successCallback(response) {
						console.log("Getting customer 1 ...");
						console.log(response.customer);
						vm.customer = response.customer;
					}, function errorCallback(error) {
						console.log(error);
					});

		}

		vm.save = function (){
			if(customerId == 0){
			customerService.save(vm.customer).then(
					function successCallback(response){
						console.log("Saving customer ...");
						console.log(response.customer);
						$state.go('customerDetails',{customerId:response.customer.id})
					}, function errorCallback(error){
						console.log(error);
					});
			}else{
				customerService.update(vm.customer).then(
						function successCallback(response){
							console.log("Saving customer ...");
							console.log(response.customer);
							$state.go('customerDetails',{customerId:response.customer.id})
						}, function errorCallback(error){
							console.log(error);
						});
			}
		};



	}

}());