/// <reference path="angular.js" />

(function () {
    'use strict'

   var app = angular.module('app', [

        //Angular modules
        'ui.router'

        //Custom modules
        , 'common.services'
        , 'userResourceMock'
        //3rd-party modules

   ]);

   app.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

       $urlRouterProvider.otherwise('/');

       $stateProvider.state('home', {
           url: '/',
           templateUrl: '/views/home/homeView.html',
       }).state('userList', {
           url: '/products',
           templateUrl: '/views/user/userListView.html',
           controller: 'UserListController as vm'

       }).state("userEdit", {
           url: '/users/edit/:userId',
           templateUrl: '/views/user/userEditView.html',
           controller: 'UserEditController as vm'
       });

   }]);

   app.controller("appController",  function ($rootScope) {
       console.log('run...');
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