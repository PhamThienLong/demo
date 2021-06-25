var app = angular.module("BillManagement", []);

// Controller Part
app.controller("BillController", function($scope, $http) {

    $scope.bills = [];
    $scope.bil = {
        emp: "",
        use: "",
        date: ""
    };

    // Now load the data from server
    _refreshBillData();

    // HTTP POST/PUT methods for add/edit bill
    // Call: http://localhost:1999/bill
    $scope.submit = function() {

        var method = "";
        var url = "";

        if ($scope.bil.id == -1) {
            method = "POST";
            url = '/bill';
        } else {
            method = "PUT";
            url = '/bill';
        }
        var r = angular.toJson($scope.bil);
        $http({
            method: method,
            url: url,
            data: JSON.stringify($scope.bil),
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(_success, _error);
    };

    $scope.addBill = function() {
        _clearFormData();
    }

    // HTTP DELETE- delete bill by Id
    // Call: http://localhost:1999/bill/{bilId}
    $scope.delete = function(bil) {
        $http({
            method: 'DELETE',
            url: '/bill/' + bil.id
        }).then(_success, _error);
    };

    // In case of edit
    $scope.edit = function(bil) {
        $scope.bil.id = bil.id;
        $scope.bil.emp = bil.emp;
        $scope.bil.use = bil.use;
        $scope.bil.date = bil.date;
    };

    // Private Method
    // HTTP GET- get all bill collection
    // Call: http://localhost:1999/bill
    function _refreshBillData() {
        $http({
            method: 'GET',
            url: '/bills'
        }).then(
            function(res) { // success
                $scope.bills = res.data;
            },
            function(res) { // error
                console.log("Error: " + res.status + " : " + res.data);
            }
        );
    }

    function _success(res) {
        _refreshBillData();
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
        $scope.bil.id = -1;
        $scope.bil.emp = "";
        $scope.bil.use = "";
        $scope.bil.date = "";
    };
});