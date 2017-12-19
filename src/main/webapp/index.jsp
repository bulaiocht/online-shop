<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@taglib uri='http://java.sun.com/jsp/jstl/fmt' prefix='fmt' %>
<!DOCTYPE html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Test servlet</title>
</head>
<html>
  <body>
  <%@include file="META-INF/views/_header.jsp"%>
  <form action="/test" method="post">
    <input type="text" name="username">
    <input type="submit" value="Submit">
  </form>
  <br/>
  <a href="/test">See all users</a>
  <%@include file="META-INF/views/_footer.jsp"%>
  </body>
</html>