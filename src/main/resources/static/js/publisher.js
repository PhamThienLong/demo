var app = angular.module("PublisherManagement", []);

// Controller Part
app.controller("PublisherController", function($scope, $http) {

    $scope.publishers = [];
    $scope.pub = {
        name: "",
        address: "",
        email: ""
    };

    // Now load the data from server
    _refreshPublisherData();

    // HTTP POST/PUT methods for add/edit publisher
    // Call: http://localhost:1999/publisher
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.pub.id == -1) {
            method = "POST";
            url = '/publisher';
        } else {
            method = "PUT";
            url = '/publisher';
        }
        var r = angular.toJson($scope.pub);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.pub),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addPublisher = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete publisher by Id
    // Call: http://localhost:1999/publisher/{pubId}
    $scope.delete = function(pub) {
        $http({
            method: 'DELETE',
            url: '/publisher/' + pub.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(pub) {
        $scope.pub.id = pub.id;
        $scope.pub.name = pub.name;
        $scope.pub.address = pub.address;
        $scope.pub.email = pub.email;


    };

    // Private Method
    // HTTP GET- get all publishers collection
    // Call: http://localhost:1999/publisher
    function _refreshPublisherData() {
        $http({
            method: 'GET',
            url: '/publishers'
        }).then(
            function(res) { // success
                $scope.publishers = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshPublisherData();
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
        $scope.pub.id = -1;
        $scope.pub.name = "";
        $scope.pub.address = "";
        $scope.pub.email = "";
    };
});