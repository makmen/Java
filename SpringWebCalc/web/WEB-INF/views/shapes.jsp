<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="Java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Title</title>
</head>
<body>
    <div>Площадь фигуры</div>
    <div>
        <h2>Выбирете фигуру</h2>
        <form name="shapes" action="shape" method="post">
            <div>
                <input id="circle" name="shape" type="radio" value="1" checked />
                <label for="circle">Круг</label>
            </div>
            <div>
                <input id="rectangle" name="shape" type="radio" value="2" />
                <label for="rectangle">Прямоугольник</label>
            </div>
            <div>
                <input id="square" name="shape" type="radio" value="3" />
                <label for="square">Квадрат</label>
            </div>
            <div>
                <input id="triangle" name="shape" type="radio" value="4" />
                <label for="triangle">Треугольник</label>
            </div>
            <br />
            <div>
                <input type="submit" value="Send">
            </div>
        </form>
    </div>
    <hr />
</body>
</html>