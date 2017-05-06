<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="ambitios_uppercase">Контактная информация </h3>

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
<form name="contact" action="" method="post">
    <div id="register">
        <div id="contact_form">
            <div id="Note"></div>
            <div class="field ambitios_input_standat_height ambitios_p2">
                <label for="name">Имя</label>
                <input class="required<c:if test="${errors.hasFieldErrors('name')}"> err</c:if>" id="name" name="name" type="text" value="${contact.name}" >
            </div>
            <div class="field ambitios_input_standat_height ambitios_p2">
                <label for="email">Email</label>
                <input class="required email<c:if test="${errors.hasFieldErrors('email')}"> err</c:if>" id="email" name="email" type="text" value="${contact.email}" >
            </div>
            <div class="ambitios_textarea ambitios_p2 field">
                <label for="message">Сообщение</label>
                <textarea class="required<c:if test="${errors.hasFieldErrors('message')}"> err</c:if>" id="message" name="message" type="text" rows="5" cols="10">${contact.message}</textarea>
            </div>
            <div>
                <div class="buttons-wrapper">
                    <div class="ambitios_wrapper ambitios_p2">
                        <div class="ambitios_button_contact">
                            <input type="submit" value="Send" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
<div class="ambitios_wrapper">
    <div class="ambitios_fleft">
        <h3 class="ambitios_uppercase">Директор: Высоцкий Василий Семенович </h3>
        Phone: +375 29 615 14 12<br />
        Fax: 8017 125 32 64<br />
        Email: <a href="mailto:mail@vactt@mail.ru">vactt@mail.ru</a><br />
        Email: <a href="mailto:mail@vvs200362@list.ru">vvs200362@list.ru</a>
    </div>
</div>

<br />
<div class="ambitios_picture ambitios_p2">
    <script type="text/javascript" charset="utf-8" src="https://api-maps.yandex.ru/services/constructor/1.0/js/?sid=eG5OG_eatgnABSizBk2fviWWJi38Kdu4&width=100%&height=400&lang=ru_RU&sourceType=constructor"></script>
</div>