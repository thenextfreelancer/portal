(function () {
    'use strict';
 
    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                controller: 'LoginController',
                templateUrl: 'app/login/home.view.html',
                controllerAs: 'vmh'
            })
            .when('/register', {
                controller: 'RegisterController',
                templateUrl: 'app/register/register.view.html',
                controllerAs: 'vmr'
            })
            .when('/dashboard', {
                controller: 'ProfileController',
                templateUrl: 'app/dashboard/partials/dashboardTalent.html',
                controllerAs: 'pc'
            })
            .otherwise({ redirectTo: '/' });
    }
 
  
    
    function run($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in and trying to access a restricted page
           // var restrictedPage = $.inArray($location.path(), ['/register']) === -1;
           // var loggedIn = $rootScope.globals.currentUser;
            //if (restrictedPage && !loggedIn) {
             //   $location.path('/');
            //}
        });
    }
 
    config.$inject = ['$routeProvider', '$locationProvider'];
    run.$inject = ['$rootScope', '$location', '$cookieStore', '$http'];
    
    angular
    .module('myApp', ['ngRoute', 'ngCookies'])
    .config(config)
    .run(run);
    
})();