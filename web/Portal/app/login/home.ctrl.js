(function () {
    'use strict';
 
    function HomeController($scope, $http, $location) {
   	
    	$scope.newuser = {};
	   	$scope.login = function(form) {
	   		
	   		$location.url('/dashboardAdmin');
	   	};
	   	
	   	$scope.register = function(form) {
	   	  	
	   		var f=form.registerForm;
	   		
	   		if(f.username.$invalid){
	   			return;
	   		}
	   		else if(f.useremail.$invalid){
	   			return;
	   		}
	   		else if(f.form-password.$invalid){
	   			return;
	   		}
	   		else if(f.form-repassword.$invalid){
	   			return;
	   		}
	   		
	   		 $http({
	   		      method  : 'POST',
	   		      url     : '/AgencyPortal/rest/users',
	   		      data    : $scope.newuser, //forms user object
	   		      headers : {'Content-Type': 'application/json'} 
	   		     })
	   		      .success(function(data) {
	   		        if (data.errors) {
	   		          // Showing errors.
	   		          $scope.errorName = data.errors.name;
	   		          $scope.errorUserName = data.errors.username;
	   		          $scope.errorEmail = data.errors.email;
	   		        } else {
	   		          $scope.message = data.message;
	   		        }
	   		        $location.url('/dashboardTalent');
	   		      });
	   	  	
	   	}; 
   }
    
    HomeController.$inject = ['$scope', '$http', '$location'];
    
    angular
    .module('myApp')
    .controller('HomeController', HomeController);

})();
