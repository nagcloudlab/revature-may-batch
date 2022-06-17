<%@ page import="com.example.entity.Product" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body class="container">

<div class="display-1">PM</div>
<hr/>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
           <%
               List<Product> products= (List<Product>) request.getAttribute("all-products");
               for(Product product:products){
           %>
            <tr>
                <td><%=product.getId()%></td>
                <td><%=product.getName()%></td>
                <td><%=product.getPrice()%></td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>

</body>
</html>
