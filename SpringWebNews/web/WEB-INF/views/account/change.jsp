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

    <form name="change" action="" method="post">

        <div class="fb">
            <div class="description">Старый пароль:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.containsKey('oldpassword')}"> err</c:if>" name="oldpassword" type="password" value="">
                <c:if test="${errors.containsKey('oldpassword')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.get('oldpassword')}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Пароль:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.containsKey('password')}"> err</c:if>" name="password" type="password" value="">
                <c:if test="${errors.containsKey('password')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.get('password')}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Повторить пароль:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.containsKey('repassword')}"> err</c:if>" name="repassword" type="password" value="">
                <c:if test="${errors.containsKey('repassword')}">
                    <div class="error">
                        <div class="msg">
                            ${errors.get('repassword')}
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
