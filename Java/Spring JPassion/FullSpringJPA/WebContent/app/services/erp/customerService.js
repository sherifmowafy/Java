(function(){
	'use strict';
	angular.module('erp.services.module').service('customerService', ['$resource', 'appConfig', customerService]);
		
	function customerService($resource, appConfig){
		var baseUrl = appConfig.baseUrl;
		this.getById = function(id){
			return $resource(baseUrl + '/customers/:id.json', null, { get : { method:"GET", headers : { Authentication: "TOOKEN"} } }).get({ id : id } ).$promise;
		};
		
		this.getAll = function(page){
			return $resource(baseUrl + '/customers.json?page=:page', null, { get : { method:"GET", headers : { Authentication: "TOOKEN"} } } ).get({ page : page } ).$promise;
		};
		
		this.save = function(customer){
			return $resource(baseUrl + '/customers.json').save(null, customer).$promise;
		}
		
		this.update = function(customer){
			return $resource(baseUrl + '/customers.json', null, { update : { method:'PUT' } } ).update(null, customer).$promise;
		}
		
		this.remove = function(id){
			return $resource(baseUrl + '/customers/:id.json').remove( { id: id } ).$promise;
		}
		
	}
	
	
})();