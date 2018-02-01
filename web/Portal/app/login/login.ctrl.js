(function () {
    'use strict';
 
    function LoginController($window, $location, AuthenticationService, FlashService) {
        var vm = this;
 
        vm.login = login;
 
        (function initController() {
            // reset login status
            AuthenticationService.ClearCredentials();
        })();
 
        function login() {
            vm.dataLoading = true;
            AuthenticationService.Login(vm.username, vm.password, function (response) {
            	response = JSON.parse(response);
                if (response.success) {
                    AuthenticationService.SetCredentials(vm.username, vm.password);
                    $window.location.href='#/dashboard?type=con';
                } else {
                    FlashService.Error(response.message);
                    vm.dataLoading = false;
                }
            });
        };
    }
    
    LoginController.$inject = ['$window','$location', 'AuthenticationService', 'FlashService'];
    
    angular
    .module('myApp')
    .controller('LoginController', LoginController);
})();