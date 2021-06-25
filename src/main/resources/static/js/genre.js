var app = angular.module("GenreManagement", []);

// Controller Part
app.controller("GenreController", function($scope, $http) {

    $scope.genres = [];
    $scope.gen = {
        name: ""
    };

    // Now load the data from server
    _refreshGenreData();

    // HTTP POST/PUT methods for add/edit genre
    // Call: http://localhost:1999/genre
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.gen.id == -1) {
            method = "POST";
            url = '/genre';
        } else {
            method = "PUT";
            url = '/genre';
        }
        var r = angular.toJson($scope.gen);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.gen),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addGenre = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete genre by Id
    // Call: http://localhost:1999/genre/{genId}
    $scope.delete = function(gen) {
        $http({
            method: 'DELETE',
            url: '/genre/' + gen.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(gen) {
        $scope.gen.id = gen.id;
        $scope.gen.name = gen.name;
    };

    // Private Method
    // HTTP GET- get all genre collection
    // Call: http://localhost:1999/genre
    function _refreshGenreData() {
        $http({
            method: 'GET',
            url: '/genres'
        }).then(
            function(res) { // success
                $scope.genres = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshGenreData();
        _clearFormData();
    }

    function _error(res) {
        var data = res.data;
        var status = res.status;
        var header = res.header;
        var config = res.config;
        alert("Error: " + status + ":" + data);
    }

    // Clear the form
    function _clearFormData() {
        $scope.gen.id = -1;
        $scope.gen.name = "";

    };
});