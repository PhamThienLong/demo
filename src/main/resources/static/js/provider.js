var app = angular.module("ProviderManagement", []);

// Controller Part
app.controller("ProviderController", function($scope, $http) {

    $scope.providers = [];
    $scope.pro = {
        name: "",
        address: "",
        phone: ""
    };

    // Now load the data from server
    _refreshProviderData();

    // HTTP POST/PUT methods for add/edit provider
    // Call: http://localhost:1999/provider
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.pro.id == -1) {
            method = "POST";
            url = '/provider';
        } else {
            method = "PUT";
            url = '/provider';
        }
        var r = angular.toJson($scope.pro);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.pro),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addProvider = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete provider by Id
    // Call: http://localhost:1999/provider/{proId}
    $scope.delete = function(pro) {
        $http({
            method: 'DELETE',
            url: '/provider/' + pro.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(pro) {
        $scope.pro.id = pro.id;
        $scope.pro.name = pro.name;
        $scope.pro.address = pro.address;
        $scope.pro.phone = pro.phone;


    };

    // Private Method
    // HTTP GET- get all providers collection
    // Call: http://localhost:1999/provider
    function _refreshProviderData() {
        $http({
            method: 'GET',
            url: '/providers'
        }).then(
            function(res) { // success
                $scope.providers = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshProviderData();
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
        $scope.pro.id = -1;
        $scope.pro.name = "";
        $scope.pro.address = "";
        $scope.pro.phone = "";
    };
});