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

    <form name="anketa" action="" method="post">

        <div class="fb">
            <div class="description">Имя:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('lastname')}"> err</c:if>" name="name" type="text" value="${anketa.name}">
                <c:if test="${errors.hasFieldErrors('name')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('name').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Фамилия:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('lastname')}"> err</c:if>" name="surname" type="text" value="${anketa.surname}">
                <c:if test="${errors.hasFieldErrors('surname')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('surname').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Отчество:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('lastname')}"> err</c:if>" name="lastname" type="text" value="${anketa.lastname}">
                <c:if test="${errors.hasFieldErrors('lastname')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('lastname').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">E-mail:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('email')}"> err</c:if>" name="email" type="text" value="${anketa.email}">
                <c:if test="${errors.hasFieldErrors('email')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('email').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Phone:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('phone')}"> err</c:if>" name="phone" type="text" value="${anketa.phone}">
                <c:if test="${errors.hasFieldErrors('phone')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('phone').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Age:</div>
            <div class="date">
                <select name="age">
                    <c:forEach items="${ages}" var="item">
                        <option value="${item}" <c:if test="${anketa.age == item}"> selected="selected" </c:if> > ${item} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Страна:</div>
            <div class="date">
                <select name="country">
                    <c:forEach items="${counties}" var="item">
                        <option value="${item}" <c:if test="${anketa.country == item}"> selected="selected" </c:if> > ${item} </option>
                    </c:forEach>
                </select>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Логин:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('login')}"> err</c:if>" name="login" type="text" value="${anketa.login}">
                <c:if test="${errors.hasFieldErrors('login')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('login').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Пароль:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('password')}"> err</c:if>" name="password" type="password" value="${anketa.password}">
                <c:if test="${errors.hasFieldErrors('password')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('password').getCode()}
                        </div>
                    </div>
                </c:if>
            </div>
            <div class="cb"></div>
        </div>

        <div class="fb">
            <div class="description">Повторить пароль:</div>
            <div class="date">
                <input class="w100<c:if test="${errors.hasFieldErrors('repassword')}"> err</c:if>" name="repassword" type="password" value="${anketa.repassword}">
                <c:if test="${errors.hasFieldErrors('repassword')}">
                    <div class="error">
                        <div class="msg">
                                ${errors.getFieldError('repassword').getCode()}
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
