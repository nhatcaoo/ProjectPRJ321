<%-- 
    Document   : AdminUser
    Created on : Jun 10, 2018, 1:07:00 PM
    Author     : hieu bach
--%>

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
        
        <jsp:include page="SideNav.jsp"></jsp:include>
     <jsp:useBean id="user" class="bean.UserBean"></jsp:useBean>
        <jsp:setProperty name="user" property="*"></jsp:setProperty>
        <c:if test="${not empty param.action &&param.action=='delete'}">
            ${user.deleteUser()}
        </c:if>
        <!--Load Data-->
        <div class="main">
            <h1 style="text-align: left; padding-bottom: 20px">View User</h1>
            <table border="1 solid black" style="table-layout: fixed" >
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Url</th>
                                  
                </tr>
                <c:forEach var="s" items="${user.selectAll()}">
                    <tr>
                        <td>${s.useName}</td>
                        <td>${s.passWd}</td>
                        <td>${s.url}</td>
                        
                       
                    </tr>


                </c:forEach>

            </table>





        </div>


    </body>
</html>
