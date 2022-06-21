<%@ page import="com.example.entity.User" %>
<%@ page import="com.example.entity.Role" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>simple-web-app</title>
    <link rel="stylesheet" href="http://localhost:8181/simple-web-app/bootstrap/css/bootstrap.css">
</head>

<body class="container">

<%
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setDateHeader("Expires", -1);
%>

<div class="display-1">simple-web-app</div>
<hr/>

<div class="d-flex justify-content-between">
    <%
        User user = (User) session.getAttribute("user");
    %>
    <span>Welcome : <%=user.getName()%> </span>
    <a href="logout">Logout</a>
    <hr/>
</div>
<hr/>
<%
    for (Role role : user.getRoles()) {
%>
<span><%=role.getRole()%></span>
<%
    }
%>

<hr/>

</body>
</html>
