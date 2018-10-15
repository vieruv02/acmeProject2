<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<body>

<div class="container-wrapper">
    <div class="container">
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1>Inventory</h1>
                    <p>All the selected products in your inventory</p>
                </div>
            </div>
        </section>

        <!--ng-app means wiring with angularJs module-->
        <section class="container" data-ng-app="inventoryApp">
            <!--initializing a inventory-->
            <div data-ng-controller="inventoryCtrl" data-ng-init="initInventoryId('${inventoryId}')">

                <div>
                    <!--it will be pulled to the left of screen-->
                    <a class="btn btn-danger pull-left" data-ng-click="clearInventory()"><span class="glyphicon glyphicon-remove-sign"></span>Clear Inventory</a>
                </div>

                <table class="table table-hover">
                    <tr>
                        <th>Product</th>
                        <th>Category</th>
                        <%--<th>Unit Price</th>--%>
                        <%--<th>Quantity</th>--%>
                        <%--<th>Price</th>--%>
                        <th>Description</th>
                        <th>Action</th>
                    </tr>
                    <!--refering to Inventory class that contains a list of inventoryItems-->
                    <!--here we are looping through each item in Inventory-->
                    <tr data-ng-repeat = "item in inventory.inventoryItems">
                        <td>{{item.product.productName}}</td>
                        <%--<td>{{item.product.productPrice}}</td>--%>
                        <%--<td>{{item.quantity}}</td>--%>
                        <%--<td>{{item.totalPrice}}</td>--%>
                        <td>{{item.product.productCategory}}</td>
                        <td>{{item.product.productDescription}}</td>
                        <td>
                            <!--Recently added-->
                            <a href="<spring:url value="/product/viewProduct/${productId}"/>">
                                <span class="glyphicon glyphicon-info-sign"></span></a>

                            <%--<a href="#" data-ng-click="removeFromInventory(item.product.productId)">--%>
                            <%--<span class="glyphicon glyphicon-remove"></span></a>--%>
                            <a href="#" class="label label-danger" data-ng-click="removeFromInventory(item.product.productId)">
                                <span class="glyphicon glyphicon-remove"></span>remove</a>
                            <!--Recently added-->
                            <a href="<spring:url value="/admin/product/editProduct/${product.productId}"/>">
                                <span class="glyphicon glyphicon-pencil"></span></a>
                        </td>
                    </tr>

                    <%--<tr>--%>
                        <%--<th></th>--%>
                        <%--<th></th>--%>
                        <%--<th>Grand Total</th>--%>
                        <%--<th>{{calGrandTotal()}}</th>--%>
                        <%--<th></th>--%>
                    <%--</tr>--%>
                </table>

                <a href="<spring:url value="/product/productList"/>" class="btn btn-default">Continue Shopping</a>
            </div>
        </section>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js" /> "></script>
<%@include file="/WEB-INF/views/template/footer.jsp"%>