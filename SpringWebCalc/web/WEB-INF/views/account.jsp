<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Создание нового аккаунта</h1>
    <hr />
    <form:form action="/account" modelAttribute="accountform" method="post" >
        <div>
            <label for="nameInput">Полное имя: </label>
            <form:input path="fullName" id="nameInput" />
            <form:errors path="fullName" cssClass="error" />
        </div>
        <div>
            <label for="loginInput">Логин: </label>
            <form:input path="login" id="loginInput" />
            <form:errors path="login" cssClass="error" />
        </div>
        <div>
            <label for="passwordInput">Пароль: </label>
            <form:input path="password" id="passwordInput" />
            <form:errors path="password" cssClass="error" />
        </div>
        <div>
            <label for="ageInput">Возраст: </label>
            <form:input path="age" id="ageInput" />
            <form:errors path="age" cssClass="error" />
        </div>
        <div>
            <label for="emailInput">Email: </label>
            <form:input path="email" id="emailInput" />
            <form:errors path="email" cssClass="error" />
        </div>
        <div>
            <input type="submit" value="send">
        </div>
    </form:form>
</body>
</html>