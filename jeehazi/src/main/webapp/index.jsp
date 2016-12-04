<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="personBean" class="hu.forest.jeehazi.TempPersonBean" scope="session"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Hello World!</h1>
Person name: ${personBean.name} <br/>
<form action="personServlet" method="get">
    <label>
        <input type="text" name="name" value="">
    </label>
    <input type="submit" value="Set"/>
</form>
</body>
</html>