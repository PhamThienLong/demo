var app = angular.module("DetailManagement", []);

// Controller Part
app.controller("DetailController", function($scope, $http) {

    $scope.details = [];
    $scope.det = {
        boo: "",
        quantity: "",
        price: "",
        bil: ""
    };

    // Now load the data from server
    _refreshDetailData();

    // HTTP POST/PUT methods for add/edit detail
    // Call: http://localhost:1999/detail
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.det.id == -1) {
            method = "POST";
            url = '/detail';
        } else {
            method = "PUT";
            url = '/detail';
        }
        var r = angular.toJson($scope.det);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.det),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addDetail = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete detail by Id
    // Call: http://localhost:1999/detail/{detId}
    $scope.delete = function(det) {
        $http({
            method: 'DELETE',
            url: '/detail/' + det.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(det) {
        $scope.det.id = det.id;
        $scope.det.boo = det.boo;
        $scope.det.quantity = det.quantity;
        $scope.det.price = det.price;
        $scope.det.bil = det.bil;

    };

    // Private Method
    // HTTP GET- get all details collection
    // Call: http://localhost:1999/detail
    function _refreshDetailData() {
        $http({
            method: 'GET',
            url: '/details'
        }).then(
            function(res) { // success
                $scope.details = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshDetailData();
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
        $scope.det.id = -1;
        $scope.det.boo = "";
        $scope.det.quantity = "";
        $scope.det.price = "";
        $scope.det.bil = "";
    };
});