var app = angular.module("geektic", ['ngRoute']);

app.controller('MainCtrl', function($scope, $http) {
	$scope.alimenterComboInterets = function()
	{
		$http.get('/geek/interetsListe').success(function(interets) {
            $scope.interets = interets;
            $scope.interet = interets[0];
        });
	}
	
	$scope.alimenterComboInterets();
	
	$scope.trouverGeeks = function()
    {
		if ($scope.sexe == "" || $scope.sexe == null)
			{
				alert("Vous avez oubliez de selectionner un sexe !!!!!");
				return;
			}
		else {
			$http.get('/geek/' + $scope.sexe + '/' + $scope.interet.unIdInteret).success(function(geeks) {
	            $scope.geeks = geeks;
	        });
		}
    };    
});

app.controller('GeekCtrl', function($scope, $http, $routeParams) {
	$http.get('/geek/' + $routeParams.id).success(function(geek) {
        $scope.geek = geek;
    });	
});
app.config(function($routeProvider){
	  $routeProvider
	    .when('/', {
	      templateUrl: 'view/main.html',
	      controller: 'MainCtrl'
	    })
	    .when('/geek/:id', {
		      templateUrl: 'view/geek.html',
		      controller: 'GeekCtrl'
		    })
	    .otherwise('/');
	});
