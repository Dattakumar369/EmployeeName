<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Forgot Password</title>
</head>
<body>
    <h2>Forgot Password</h2>
    <%-- Display error message if email not found --%>
    <c:if test="${param.error == 'email_not_found'}">
        <p>Email not found. Please enter a valid email address.</p>
    </c:if>
    <form action="Email" method="post">
        <label>Email:</label>
        <input type="email" name="email" required>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
