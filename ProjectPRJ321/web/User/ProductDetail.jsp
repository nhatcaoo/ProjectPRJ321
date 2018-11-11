<%-- 
    Document   : AboutMyCake
    Created on : Feb 24, 2018, 5:08:54 PM
    Author     : Admin
--%>

<%@page import="Model.CafeProductModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    CafeProductModel product = new CafeProductModel();

    product = (CafeProductModel) request.getAttribute("Product");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/ProductDetail.css">
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main-container">
              <%@include file="header.html" %>
            
            <div id="content">
                <!-- Left -->
                <div id="left-content">
                    <div id="left-first-content">
                        <div id="cake-title">
                            <b><%=product.getProductName()%></b>
                        </div>
                        <div>
                            <div id="cake-image">
                                <img src="<%=product.getProductImage()%>">
                            </div>
                            <div id="cake-content">
                                <%=product.getProductFullDescription()%>
                            </div>
                            <div id="cake-price" style="color: blue">
                                <%=product.getProductPrice()%> VNĐ
                            </div>
                        </div>
                    </div>


                </div>            

            </div>
            <!-- Footer  -->
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
