var app = angular.module("geektic", ['ngRoute']);

app.controller('HelloCtrl', function($scope, $http) {
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
				alert("Vous avez oubliez de selectionner un sex !!!!!");
				return;
			}
		else {
			$http.get('/geek/' + $scope.sexe + '/' + $scope.interet.unIdInteret).success(function(geeks) {
	            $scope.geeks = geeks;
	        });
		}
    };    
});