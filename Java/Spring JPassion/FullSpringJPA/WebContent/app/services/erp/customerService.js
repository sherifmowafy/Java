(function(){
	'use strict';
	angular.module('erp.services.module').service('customerService', ['$resource', customerService]);
		
	function customerService($resource){
		this.getById = function(id){
			return $resource('spring/customers/:id.json').get({ id : id } ).$promise;
		};
		
		this.getAll = function(page){
			return $resource('spring/customers.json?page=:page').get({ page : page } ).$promise;
		};
		
		this.save = function(customer){
			return $resource('spring/customers.json').save(null, customer).$promise;
		}
		
		this.update = function(customer){
			return $resource('spring/customers.json', null, { update : { method:'PUT' } } ).update(null, customer).$promise;
		}
		
		this.remove = function(id){
			return $resource('spring/customers/:id.json').remove( { id: id } ).$promise;
		}
		
	}
	
	
})();