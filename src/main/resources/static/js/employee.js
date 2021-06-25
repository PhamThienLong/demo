var app = angular.module("EmployeeManagement", []);

// Controller Part
app.controller("EmployeeController", function($scope, $http) {

    $scope.employees = [];
    $scope.emp = {
        name: "",
        birthday: "",
        phone: ""
    };

    // Now load the data from server
    _refreshEmployeeData();

    // HTTP POST/PUT methods for add/edit employee
    // Call: http://localhost:1999/employee
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.emp.id == -1) {
            method = "POST";
            url = '/employee';
        } else {
            method = "PUT";
            url = '/employee';
        }
        var r = angular.toJson($scope.emp);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.emp),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addEmployee = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete employee by Id
    // Call: http://localhost:1999/employee/{empId}
    $scope.delete = function(emp) {
        $http({
            method: 'DELETE',
            url: '/employee/' + emp.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(emp) {
        $scope.emp.id = emp.id;
        $scope.emp.name = emp.name;
        $scope.emp.birthday = emp.birthday;
        $scope.emp.phone = emp.phone;

    };

    // Private Method
    // HTTP GET- get all employees collection
    // Call: http://localhost:1999/employee
    function _refreshEmployeeData() {
        $http({
            method: 'GET',
            url: '/employees'
        }).then(
            function(res) { // success
                $scope.employees = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshEmployeeData();
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
        $scope.emp.id = -1;
        $scope.emp.name = "";
        $scope.emp.birthday = "";
        $scope.emp.phone = "";
    };
});