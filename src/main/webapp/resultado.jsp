<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro Exitoso</title>
</head>
<body>
    <h2>Datos Registrados</h2>
    <p>Nombre: <%= request.getAttribute("nombre") %></p>
    <p>Email: <%= request.getAttribute("email") %></p>
</body>
</html>

