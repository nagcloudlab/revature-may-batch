<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.Todo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>todos management</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body class="container">

<div class="display-1">todos management</div>
<hr/>

<ul class="nav">
    <li class="nav-item">
        <a class="nav-link active" href="todos">View Todos</a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="new-todo.html">New Todo</a>
    </li>
</ul>

<hr/>

<table class="table table-striped">
    <%
        List<Todo> todos = (List<Todo>) request.getAttribute("all-todos");
        for (Todo todo : todos) {
    %>
    <tr>
        <td><%=todo.getTitle()%>
        </td>
        <td><%=todo.isCompleted()%>
        </td>
        <td><%=todo.getType().toString()%>
        </td>
        <td>
            <a href="delete-todo?id=<%=todo.getId()%>" style="cursor: pointer"><i class="fa fa-trash"></i></a>
        </td>
    </tr>
    <%
        }
    %>

</table>

<hr/>
</body>
</html>