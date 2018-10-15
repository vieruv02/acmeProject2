/**
 * Created by vladvieru on 10/12/18.
 */
var inventoryApp = angular.module("inventoryApp", []);

inventoryApp.controller("inventoryCtrl", function($scope, $http){

    //function to refresh the inventory
    $scope.refreshInventory = function(){
        //wire with get function in "InventoryController" class - we get inventory data in JSON format, if success it will be stored in "data"
        $http.get('/acmeProject2/rest/inventory/' + $scope.inventoryId).success(function (data){
            $scope.inventory=data;
        });
    };

    //delete function
    $scope.clearInventory = function(){
        $http.delete('/acmeProject2/rest/inventory/' + $scope.inventoryId).success($scope.refreshInventory());
    };


    $scope.initInventoryId = function(inventoryId){
        $scope.inventoryId = inventoryId;
        $scope.refreshInventory(inventoryId);
    };

    $scope.addToInventory = function(productId){
        $http.put('/acmeProject2/rest/inventory/add/'+productId).success(function(){
            //$scope.refreshInventory($http.get('/acmeProject2/rest/inventory/inventoryId'));
            alert("Product successfully added to the inventory!");
        });
    };

    $scope.removeFromInventory = function(productId){
        $http.put('/acmeProject2/rest/inventory/remove/' + productId).success(function (data){
            $scope.refreshInventory();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal=0;

        for(var i=0; i<$scope.inventory.inventoryItems.length; i++){
            grandTotal+=$scope.inventory.inventoryItems[i].totalPrice;
        }
        return grandTotal;
    };
});