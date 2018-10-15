<!--below we add stuff to refer to header.jsp-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
    <div class="container" style="margin-top: 20px;">
        <div class="page-header">
            <h1>Add Product</h1>
            <p class="lead">Fill the below information to add a product:</p>
        </div>

        <!--spring form action (enctype="multipart/form-data" is for image upload)-->
        <form:form action="${pageContext.request.contextPath}/admin/product/addProduct" method="post"
                   commandName="product" enctype="multipart/form-data">

        <div class="form-group">
            <!--form:errors will show an error if Name field will not be filled -->
            <label for="name">Name</label> <form:errors path="productName" cssStyle="color:red"/>
            <form:input path="productName" id="name" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="cameras"/>Cameras</label>

            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="dooraccesscontrols"/>Door Access Controls</label>

            <label class="checkbox-inline"><form:radiobutton path="productCategory" id="category"
                                                             value="servers"/>Servers</label>
        </div>


        <div class="form-group">
            <label for="description">Description</label>
            <form:textarea path="productDescription" id="description" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="price">Price</label> <form:errors path="productPrice" cssStyle="color:red"/>
            <form:input path="productPrice" id="price" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="condition">Condition</label>
            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="new"/>New</label>

            <label class="checkbox-inline"><form:radiobutton path="productCondition" id="condition"
                                                             value="used"/>Used</label>
        </div>


        <div class="form-group">
            <label for="status">Status</label>
            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="active"/>Active</label>

            <label class="checkbox-inline"><form:radiobutton path="productStatus" id="status"
                                                             value="inactive"/>Inactive</label>
        </div>


        <div class="form-group">
            <label for="unitInStock">Unit In Stock</label> <form:errors path="unitInStock" cssStyle="color:red"/>
            <form:input path="unitInStock" id="unitInStock" class="form-Control"/>
        </div>

        <div class="form-group">
            <label for="manufacturer">Manufacturer</label>
            <form:input path="productManufacturer" id="manufacturer" class="form-Control"/>
        </div>

        <div class="form-group">
            <label class="control-label" for="productImage">Upload Picture</label>
            <form:input path="productImage" id="productImage" type="file" class="form:input-large"/>
        </div>

        <br />
        <br />
        <input type="submit" value="submit" class="btn btn-default">
        <a href="<c:url value="/admin/productInventory"/>" class="btn btn-default">Cancel</a>

        </form:form>



        <%@include file="/WEB-INF/views/template/footer.jsp"%>
