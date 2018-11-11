<%-- 
    Document   : Home
    Created on : Feb 4, 2018, 10:19:15 PM
    Author     : Admin
--%>

<%@page import="Model.CafeProductModel"%>

<%@page import="java.util.Vector"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   
      Vector<CafeProductModel> vecProduct = (Vector<CafeProductModel>) request.getAttribute("Product");
   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="CSS/style.css">
        <link rel="stylesheet" type="text/css" href="CSS/header.css">
        <title>JSP Page</title>
    </head>
    <body>
        
 <div id="main-container">
      <%@include file="header.html" %>
            <!-- Content -->
            <div id="content">
                 
                <!-- Left -->
                <div id="left-content">
                     <%@include file="introduce.html" %>


                    <% if (!vecProduct.isEmpty()) {%>
                    <div id="cake-list">
                        <%  for (CafeProductModel x : vecProduct) {%>
                        <div class="cake">
                            <div class="cake-img">
                                  <a href="ProductDetail?id=<%=x.getProductID()%>"><img src="<%=x.getProductImage()%>"></a>
                            </div>
                            <div class="cake-title">
                                  <a href="ProductDetail?id=<%=x.getProductID()%>"><%=x.getProductName()%></a>
                            </div>
                            <div class="cake-description">
                                <%=x.getProductShortDescription()%>
                            </div>
                        </div>
                        <% } %>
                    </div>
                    <% }%>


                    

                    <div id="signature">
                        <div id="sign-title">
                            Kind regards
                        </div>
                        <div id="sign">
                            Maria Bagnarelli
                        </div>
                    </div>


                </div>

                <!-- Right -->
                


            </div>
            <%@include file="footer.jsp" %>
          
</div   >
    </body>
</html>
