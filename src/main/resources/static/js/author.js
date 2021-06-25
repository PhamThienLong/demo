var app = angular.module("AuthorManagement", []);

// Controller Part
app.controller("AuthorController", function($scope, $http) {

    $scope.authors = [];
    $scope.aut = {
        name: "",
        note: ""
    };

    // Now load the data from server
    _refreshAuthorData();

    // HTTP POST/PUT methods for add/edit author
    // Call: http://localhost:1999/author
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.aut.id == -1) {
            method = "POST";
            url = '/author';
        } else {
            method = "PUT";
            url = '/author';
        }
        var r = angular.toJson($scope.aut);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.aut),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addAuthor = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete author by Id
    // Call: http://localhost:1999/author/{autId}
    $scope.delete = function(aut) {
        $http({
            method: 'DELETE',
            url: '/author/' + aut.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(aut) {
        $scope.aut.id = aut.id;
        $scope.aut.name = aut.name;
        $scope.aut.note = aut.note;

    };
$scope.search = function (aut) {
    $scope.aut.id = aut.id;
    $scope.aut.name = aut.name;
    $scope.aut.note = aut.note;
}
    // Private Method
    // HTTP GET- get all author collection
    // Call: http://localhost:1999/author
    function _refreshAuthorData() {
        $http({
            method: 'GET',
            url: '/authors'
        }).then(
            function(res) { // success
                $scope.authors = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshAuthorData();
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
        $scope.aut.id = -1;
        $scope.aut.name = "";
        $scope.aut.note = "";
    };
});