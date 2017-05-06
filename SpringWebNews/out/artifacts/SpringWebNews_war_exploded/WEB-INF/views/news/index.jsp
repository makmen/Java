<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${allNews}" var="news">
<div class="ambitios_p4">
    <div class="ambitios_wrapper ambitios_p2">
        <h3 class="ambitios_uppercase ambitios_p5">${news.title}</h3>
        <div class="ambitios_date">${news.registed}</div>
    </div>
    <p>${news.text} ... </p>
    <div class="ambitios_wrapper">
        <a href="/news/viewone/${news.id}" class="ambitios_button_small_rev ambitios_fleft">Читать</a>
    </div>
</div>
</c:forEach>

<c:if test="${allNews.size()==0}">
    <div class="mess-top">
        <div class="fbok">
            <div class="info">Нет данных</div>
        </div>
    </div>
</c:if>"
<div class="ambitios_pagination">
    <c:forEach begin="1" end="${totalPages}" var="i">
        <a class="<c:if test="${page==i}">currentpagging</c:if>" href="/news/?p=${i}">${i}</a>
    </c:forEach>
</div>

