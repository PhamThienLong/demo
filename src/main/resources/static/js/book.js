var app = angular.module("BookManagement", []);

// Controller Part
app.controller("BookController", function($scope, $http) {

    $scope.books = [];
    $scope.boo = {
        name: "",
        aut: "",
        gen: "",
        pub: "",
        pro: "",
        year: ""
    };

    // Now load the data from server
    _refreshBookData();

    // HTTP POST/PUT methods for add/edit book
    // Call: http://localhost:1999/book
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.boo.id == -1) {
            method = "POST";
            url = '/book';
        } else {
            method = "PUT";
            url = '/book';
        }
        var r = angular.toJson($scope.boo);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.boo),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addBook = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete book by Id
    // Call: http://localhost:1999/book/{booId}
    $scope.delete = function(boo) {
        $http({
            method: 'DELETE',
            url: '/book/' + boo.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(boo) {
        $scope.boo.id = boo.id;
        $scope.boo.name = boo.name;
        $scope.boo.aut = boo.aut;
        $scope.boo.gen = boo.gen;
        $scope.boo.pub = boo.pub;
        $scope.boo.pro = boo.pro;
        $scope.boo.year = boo.year;

    };

    // Private Method
    // HTTP GET- get all book collection
    // Call: http://localhost:1999/book
    function _refreshBookData() {
        $http({
            method: 'GET',
            url: '/books'
        }).then(
            function(res) { // success
                $scope.books = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshBookData();
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
        $scope.boo.id = -1;
        $scope.boo.name = "";
        $scope.boo.aut = "";
        $scope.boo.gen = "";
        $scope.boo.pub = "";
        $scope.boo.pro = "";
        $scope.boo.year = "";
    };
});