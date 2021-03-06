﻿
(function(){
	'use strict';
	$(function(){
		$('#logout').click(function(e){
			e.preventDefault();
			$('#logoutForm').submit();
		});
	});
}());


(function () {
    'use strict'

   var app = angular.module('app', [

        //Angular modules
        'ui.router',

        //Custom modules
	   'erp.services.module'
        //3rd-party modules

   ]);
   
   app.constant('appConfig', {
	   'baseUrl' : 'http://localhost:8080/FullSpringJPA'
   });

   app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

       $urlRouterProvider.otherwise('/');

       $stateProvider.state('home', {
           url: '/',
           templateUrl: 'app/views/home/home.html',
       }).state('customersList', {
           url: '/customers?page',
           templateUrl: 'app/views/customer/customerList.html',
           controller: 'CustomerListController as vm'
       }).state('customerDetails', {
           url: '/customers/:customerId',
           templateUrl: 'app/views/customer/customerDetails.html',
           controller: 'CustomerDetailsController as vm'
       }).state("customerAdd", {
           url: '/customer/add',
           templateUrl: 'app/views/customer/customerAdd.html',
           controller: 'CustomerAddController as vm'
       }).state("customerEdit", {
           url: '/customer/:customerId/edit',
           templateUrl: 'app/views/customer/customerAdd.html',
           controller: 'CustomerAddController as vm'
       });

   }]);

   app.controller("appController",  function ($rootScope) {
       console.log('run run ruuuuun...');
       $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
           $rootScope.preloader = true;
           console.log('state change start');
       });

        $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams) {
            $rootScope.preloader = false;
            console.log('state change Success');
        });
   });

}());