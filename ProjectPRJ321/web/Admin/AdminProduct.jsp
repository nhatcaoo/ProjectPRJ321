

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="Admin.css">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="../CSS/Admin.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>${test}</h1>
        <jsp:include page="SideNav.jsp"></jsp:include>
        <jsp:useBean id="product" class="bean.ProductBean"></jsp:useBean>
        <jsp:setProperty name="product" property="*"></jsp:setProperty>
        <c:if test="${not empty param.action &&param.action=='delete'}">
            ${product.deleteProduct()}
        </c:if>
            <!--Load Data-->
            <div class="main">
                <h1 style="text-align: left; padding-bottom: 20px">View Product</h1>
                <table border="1 solid black" style="table-layout: fixed" >
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Price</th>
                        <th>short description</th>
                         <th>full description</th>
                        <th>Image Name</th>
                     
                        <th colspan="2"></th>
                    </tr>
                <c:forEach var="k" items="${product.selectAllProduct()}">
                    <tr>
                        <td>${k.productID}</td>
                        <td>${k.productName}</td>
                        <td>${k.productPrice}</td>
                        <td><div class="crop">${k.productShortDescription}</div></td>
                          <td><div class="crop">${k.productFullDescription}</div></td>
                        
                        <td>${k.productImage}</td>
                      
                        <td>
                            <c:url var="updateProduct" value="UpdateProduct.jsp">
                                <c:param name="pid" value="${k.productID}"></c:param>
                                <c:param name="pname" value="${k.productName}"></c:param>
                                <c:param name="price" value="${k.productPrice}"></c:param>
                                 <c:param name="shortDesc" value="${k.productShortDescription}"></c:param>
                                  <c:param name="fullDesc" value="${k.productFullDescription}"></c:param>
                                <c:param name="imageName" value="${k.productImage}"></c:param>
                                
                               
                            </c:url>
                            <a href="${updateProduct}">Update</a>
                        </td>
                        <td>
                            <c:url var="delete" value="AdminProduct.jsp">
                                <c:param name="action" value="delete"></c:param>
                                <c:param name="pid" value="${k.productID}"></c:param>
                            </c:url>
                            <a href="${delete}">Delete </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <br>
            <a href="InsertProduct.jsp"> <input type="submit" value="Insert"/></a>
        </div>


    </body>
</html>
