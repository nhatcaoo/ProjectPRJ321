<%-- 
    Document   : AboutMyCake
    Created on : Feb 24, 2018, 5:08:54 PM
    Author     : Admin
--%>


<%@page import="Model.CafeProductModel"%>
<%@page import="java.util.Vector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
     Vector<CafeProductModel> vecProduct = (Vector<CafeProductModel>) request.getAttribute("Product");
    
    int numberOfPage = (Integer) request.getAttribute("NumberOfPage");
    int currentPage = (Integer) request.getAttribute("Page");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/Product.css">
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="main-container">
              <%@include file="header.html" %>
            <!-- Nav bar -->
            <!-- Content -->
            <div id="content">
                <!-- Left -->
                <div id="left-content">
                    <div id="left-first-content">
                        <div id="title-first-content">
                            <b>List of cake</b>
                        </div>

                        <% int count = 0;
                            for (CafeProductModel x : vecProduct) {%>
                        <div class="<%=(count == 0) ? "cake-first" : "cake"%>">
                            <div class="cake-img">
                                <a href="ProductDetail?id=<%=x.getProductID()%>"><img src="<%=x.getProductImage()%>"></a>
                                
                            </div>
                            <div class="cake-content">
                                <div class="cake-title">
                                    <a href="ProductDetail?id=<%=x.getProductID()%>"><%=x.getProductName()%></a>
                                </div>
                                <div class="cake-description">
                                    <%=x.getProductShortDescription()%>
                                </div>
                            </div>
                        </div>
                        <%count++;
                            }%>

                    </div>
                    <div id="paging">

                        <% for (int i = 0; i < numberOfPage; i++) {%>
                        <a <%=(currentPage == (i + 1) ? "" : "href=\"ProductController?page=" + (i + 1) + "\"")%>
                            <%=(currentPage == (i + 1) ? "class=\"current-page\"" : "")%>><%=(i + 1)%></a>
                        <%} %>
                    </div>

                </div>

            </div>
            <!-- Footer  -->
              <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
