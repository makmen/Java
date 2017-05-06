<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${success!=null}">
    <div class="mess-top">
        <div class="fbok">
            <div class="success">${mess}</div>
        </div>
    </div>
    <br />
</c:if>

    <div class="ambitios_textarea ambitios_p2 field">
        <label>Загрузить файл</label>
    </div>

<form method="POST" enctype="multipart/form-data" action="/upload">

    <div class="ambitios_textarea ambitios_p2 field">
        <input type="file" name="file">
    </div>

    <c:if test="${error!=null}">
        <div class="mess-top">
            <div class="error">
                <div class="msg">${error}</div>
            </div>
        </div>
    </c:if>

    <div class="buttons-wrapper">
        <div class="ambitios_wrapper ambitios_p2">
            <div class="ambitios_button_contact">
                <input type="submit" value="Upload">
            </div>
        </div>
    </div>

</form>
<p>
    Additional footer advert area. This is something your client can't miss. You can add text images, tweets or news here. But of course you can hide this area, If you want, and make footer smaller. Lorem ipsum dolor sit amet, consectetur adipi- scing elit. Vivamus condimentum, massa eu accumsan pellentesque, felis metus imperdiet est, aliquam
</p>
<p>
    Additional footer advert area. This is something your client can't miss. You can add text images, tweets or news here. But of course you can hide this area, If you want, and make footer smaller. Lorem ipsum dolor sit amet, consectetur adipi- scing elit. Vivamus condimentum, massa eu accumsan pellentesque, felis metus imperdiet est, aliquam
</p>
<p>
    Additional footer advert area. This is something your client can't miss. You can add text images, tweets or news here. But of course you can hide this area, If you want, and make footer smaller. Lorem ipsum dolor sit amet, consectetur adipi- scing elit. Vivamus condimentum, massa eu accumsan pellentesque, felis metus imperdiet est, aliquam
</p>