(function () {
    'use strict';
 
   
    function RegisterController(UserService, $location, $rootScope, FlashService) {
        var vm = this;
        var date = new Date();
        var day = date.getDate();
        var monthIndex = date.getMonth()+1;
        var year = date.getFullYear();
        var currentDate = day+"/"+monthIndex+"/"+year;
        vm.register = register;
        function register() {
            vm.dataLoading = true;
            vm.newuser.role = 1;
            vm.newuser.creationDate=currentDate;
            vm.newuser.modifiedDate =currentDate;
            vm.newuser.state = "0";
            vm.newuser.authorizationToken = null;
            vm.newuser.userName = vm.newuser.email;
            
            UserService.Create(vm.newuser)
                .then(function (response) {
                    if (response.success) {
                        FlashService.Success('Registration successful', true);
                        $location.path('/');
                    } else {
                        FlashService.Error(response.message);
                        vm.dataLoading = false;
                    }
                });
        }
    }
    
    RegisterController.$inject = ['UserService', '$location', '$rootScope', 'FlashService'];
    
    angular
    .module('myApp')
    .controller('RegisterController', RegisterController);

 
})();