<%-- 
    Document   : Home
    Created on : Feb 4, 2018, 10:19:15 PM
    Author     : Admin
--%>

<%@page import="entity.Contact"%>
<%@page import="entity.Cake"%>
<%@page import="java.util.Vector"%>
<%@page import="entity.ShareContent"%>
<%@page import="entity.HomeContent"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HomeContent homeContent = new HomeContent();
    Vector<ShareContent> vecShareContent = new Vector<ShareContent>();
    Vector<Cake> vecCake = new Vector();
    Contact contact = new Contact();
    contact = (Contact) request.getAttribute("Contact");
    vecCake = (Vector<Cake>) request.getAttribute("Cake");
    homeContent = (HomeContent) request.getAttribute("HomeContent");
    vecShareContent = (Vector<ShareContent>) request.getAttribute("ShareContent");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/Home.css">
        <title>JSP Page</title>
    </head>
    <body>
        
 <div id="main-container">
      <%@include file="header.html" %>
            <!-- Content -->
            <div id="content">
                 
                <!-- Left -->
                <div id="left-content">
                    <div id="left-first-content">
                        <div id="left-first-content-img">
                            <img src="<%=homeContent.getUrlImage()%>">
                        </div>

                        <div id="first-content">
                            <div id="first-content-title">
                                <%=homeContent.getTitle()%>
                            </div>
                            <div id="first-content-main">
                                <%=homeContent.getContent()%>
                            </div>
                        </div>
                    </div>


                    <% if (!vecCake.isEmpty()) {%>
                    <div id="cake-list">
                        <%  for (Cake x : vecCake) {%>
                        <div class="cake">
                            <div class="cake-img">
                                <a href="CakeDetail?id=<%=x.getId()%>"><img src="<%=x.getUrlImage()%>"></a>
                            </div>
                            <div class="cake-title">
                                <a href="CakeDetail?id=<%=x.getId()%>"><%=x.getTitle()%></a>
                            </div>
                            <div class="cake-description">
                                <%=x.getShort_description()%>
                            </div>
                        </div>
                        <% } %>
                    </div>
                    <% }%>


                    <div id="contact">
                        <div id="contact-title">
                            Visit my cafe
                        </div>
                        <div id="contact-description">
                            <%=contact.getDescription()%>
                        </div>
                        <div>
                            <div id="contact-address">
                                <%=contact.getAddress()%> <br>Phone: <%=contact.getTel()%>
                            </div>
                        </div>
                    </div>

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
                <div id="right-content">
                    <div class="right-box">
                        <div class="right-box-title">
                            <b>Share this page</b>
                        </div>
                        <div class="right-box-content">
                            <ul>
                                <% for (ShareContent x : vecShareContent) {%>
                                <li><a href="" >Share on <%=x.getHost()%></a></li>    
                                        <% }%>
                            </ul>
                        </div>
                    </div>

                </div>




            </div>
            <!-- Footer  -->
            <%@include file="footer.html" %>
</div   >
    </body>
</html>
