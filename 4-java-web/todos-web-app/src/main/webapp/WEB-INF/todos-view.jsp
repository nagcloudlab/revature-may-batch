<%@ page import="java.util.List" %>
<%@ page import="com.example.entity.Todo" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>todos-view</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
</head>
<body class="container">

<div class="display-1">todos-web</div>
<hr/>

<div class="row">
    <div class="col-offset-4 col-4">
        <form action="todos" method="post">
           <div class="d-flex">
               <input autofocus class="form-control" name="title" placeholder="Whats needs to be done?"/>
               <button class="btn btn-primary">Add</button>
           </div>
        </form>
    </div>
</div>

<br/>

<table class="table table-striped">
    <%

        List<Todo> todos = (List<Todo>) request.getAttribute("todos");
        for (Todo todo : todos) {
    %>
    <tr>
        <td><%=todo.getId()%>
        </td>
        <td><%=todo.getTitle()%>
        </td>
        <td><%=todo.isCompleted()%>
        </td>
        <td><%=todo.getType()%>
        </td>
        <td><a href="delete-todo?id=<%=todo.getId()%>">delete</a></td>
    </tr>

    <%
        }
    %>

</table>

</body>
</html>