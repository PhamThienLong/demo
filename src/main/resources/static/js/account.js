var app = angular.module("AccountManagement", []);

// Controller Part
app.controller("AccountController", function ($scope, $http) {

    $scope.accounts = [];
    $scope.acc = {
        name: "",
        phone: "",
        position: ""
    };

    // Now load the data from server
    _refreshAccountData();

    // HTTP POST/PUT methods for add/edit account
    // Call: http://localhost:1999/account
    $scope.submit = function () {

        var method = "";
        var url = "";

        if ($scope.acc.id == -1) {
            method = "POST";
            url = '/account';
        } else {
            method = "PUT";
            url = '/account';
        }
        var r = angular.toJson($scope.acc);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.acc),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addAccount = function () {
        _clearFormData();
    }

    // HTTP DELETE- delete account by Id
    // Call: http://localhost:1999/account/{accId}
    $scope.delete = function (acc) {
        $http({
            method: 'DELETE',
            url: '/account/' + acc.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function (acc) {
        $scope.acc.id = acc.id;
        $scope.acc.name = acc.name;
        $scope.acc.phone = acc.phone;
        $scope.acc.position = acc.position;

    };

    // Private Method
    // HTTP GET- get all accounts collection
    // Call: http://localhost:1999/account
    function _refreshAccountData() {
        $http({
            method: 'GET',
            url: '/accounts'
        }).then(
            function (res) { // success
                $scope.accounts = res.data;
            },
            function (res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshAccountData();
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
        $scope.acc.id = -1;
        $scope.acc.name = "";
        $scope.acc.phone = "";
        $scope.acc.position = "";
    };
});