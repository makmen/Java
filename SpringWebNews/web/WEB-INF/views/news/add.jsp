<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="register">

    <c:if test="${success!=null}">
        <div class="mess-top">
            <div class="fbok">
                <div class="success">${success}</div>
            </div>
        </div>
    </c:if>

    <c:if test="${error!=null}">
        <div class="mess-top">
            <div class="error">
                <div class="msg">${error}</div>
            </div>
        </div>
    </c:if>

    <form name="news" action="${url}" method="post">

        <div class="fb">
            <div class="description">Название:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('title')}"> err</c:if>" name="title" type="text" value="${news.title}">
                <c:if test="${errors.hasFieldErrors('title')}">
                    <div class="error">
                        <div class="msg">
                            ${errors.getFieldError('title').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Содержание:</div>
            <div class="date">
                <textarea class="w100<c:if test="${errors.hasFieldErrors('text')}"> err</c:if>" id="text" name="text" type="text" rows="5" cols="10">${news.text}</textarea>
                <c:if test="${errors.hasFieldErrors('text')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('text').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="submit">
            <input type="submit" class="btn" value="Сохранить" />
        </div>

    </form>
</div>
