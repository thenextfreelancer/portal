(function () {
    'use strict';
 
    function jobsController($scope, $http, $location) {
    	$scope.jobs = [{"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"},
    		             {"job" :"Front End Engineer","submitted" : "1","active" : "1","hired" : "1","client" :"Genpact"}];
    	
    		$scope.clients = [{"client" :"Genpact","jobs" :"8","submitted" : "102","active" : "1","hired" : "1"},
    			             {"client" :"Samsung","jobs" :"12","submitted" : "86","active" : "1","hired" : "1"}];
	}
    
    jobsController.$inject = ['$scope', '$http', '$location'];
    
    angular
    .module('myApp')
    .controller('jobsController', jobsController);

})();
