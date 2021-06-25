var app = angular.module("UserManagement", []);

// Controller Part
app.controller("UserController", function ($scope, $http) {

    $scope.users = [];
    $scope.use = {
        name: "",
        address: "",
        phone: ""
    };

    // Now load the data from server
    _refreshUserData();

    // HTTP POST/PUT methods for add/edit user
    // Call: http://localhost:1999/user
    $scope.submit = function () {

        var method = "";
        var url = "";

        if ($scope.use.id == -1) {
            method = "POST";
            url = '/user';
        } else {
            method = "PUT";
            url = '/user';
        }
        var r = angular.toJson($scope.use);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.use),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addUser = function () {
        _clearFormData();
    }

    // HTTP DELETE- delete user by Id
    // Call: http://localhost:1999/user/{useId}
    $scope.delete = function (use) {
        $http({
            method: 'DELETE',
            url: '/user/' + use.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function (use) {
        $scope.use.id = use.id;
        $scope.use.name = use.name;
        $scope.use.address = use.address;
        $scope.use.phone = use.phone;
    };

    // Private Method
    // HTTP GET- get all user collection
    // Call: http://localhost:1999/user
    function _refreshUserData() {
        $http({
            method: 'GET',
            url: '/users'
        }).then(
            function (res) { // success
                $scope.users = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshUserData();
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
        $scope.use.id = -1;
        $scope.use.name = "";
        $scope.use.address = "";
        $scope.use.phone = "";
    };
});