<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="Java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
    <div>
        <h2>Круг</h2>
        <form name="radius" action="circle" method="post">
            <div>
                <span>Радиус</span>
                <input name="radius" type="text" value="${outAttribute.get("radius")}">
            </div>
            <div>
                <input type="submit" value="Send">
            </div>
        </form>
        <c:choose>
            <c:when test="${outErrors.size()!=0}">
                <div>
                    <c:forEach items="${outErrors}" var="item">
                        <p>${item}</p>
                    </c:forEach>
                </div>
            </c:when>
            <c:otherwise>
                <div>
                    <span>Площадь круга</span>
                    <input name="result" type="text" value="${outAttribute.get("result")}">
                </div>
            </c:otherwise>
        </c:choose>
    </div>
    <hr />
</body>
</html>