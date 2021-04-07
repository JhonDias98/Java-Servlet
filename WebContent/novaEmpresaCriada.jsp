<%
//scriptlet
String nomeEmpresa = (String)request.getAttribute("empresa");
System.out.println(nomeEmpresa);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empresa Criada</title>
</head>
<body>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body>
</html>