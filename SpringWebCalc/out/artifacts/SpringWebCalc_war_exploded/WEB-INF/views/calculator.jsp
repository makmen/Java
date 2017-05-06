<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>Калькулятор</h1>
    <hr />
    <form action="/calc" method="post" >
        <div>
            <label for="firstInput">Первое число: </label>
            <input type="text" id="firstInput" name="first" value="${outAttribute.get("first")}">
            <select name="operation">
                <option value="add" <c:if test="${outAttribute.get('operation') == 'add'}"> selected="selected" </c:if> > + </option>
                <option value="sub" <c:if test="${outAttribute.get('operation') == 'sub'}"> selected="selected" </c:if> > - </option>
                <option value="mul" <c:if test="${outAttribute.get('operation') == 'mul'}"> selected="selected" </c:if> > * </option>
                <option value="div" <c:if test="${outAttribute.get('operation') == 'div'}"> selected="selected" </c:if> > / </option>
            </select>
            <label for="secondInput">Второе число: </label>
            <input type="text" id="secondInput" name="second" value="${outAttribute.get("second")}">
            <input type="submit" value="Рассчет">
            <c:if test="${outAttribute.containsKey('result')}">
                <h4>Результат</h4>
                <p>${outAttribute.get('result')}</p>
            </c:if>
        </div>
        <c:if test="${outErrors.size()!=0}">
            <div>
                <c:forEach items="${outErrors}" var="item">
                    <p>${item}</p>
                </c:forEach>
            </div>
        </c:if>
    </form>
</body>
</html>