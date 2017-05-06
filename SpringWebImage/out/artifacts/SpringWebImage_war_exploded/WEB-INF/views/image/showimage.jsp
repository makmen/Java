<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:forEach items="${listArray}" var="item">
    <div class="ambitios_wrapper ambitios_p4">
        <div class="ambitios_col3 ambitios_alpha">
            <div class="ambitios_wrapper ambitios_p2">
                <a href="#" class="ambitios_picture ambitios_fleft  ambitios_lightbox_image" >
                    <img src="${item[0]}" alt="" width="282px" height="160px" />
                </a>
            </div>
            <h3 class="ambitios_uppercase">2x Home page layouts</h3>
        </div>
        <div class="ambitios_col3">
            <div class="ambitios_wrapper ambitios_p2">
                <a href="#" class="ambitios_picture ambitios_fleft  ambitios_lightbox_image" >
                    <img src="${item[1]}" alt="" width="282px" height="160px" />
                </a>
            </div>
            <h3 class="ambitios_uppercase">Ajax Contact form</h3>
        </div>
        <div class="ambitios_col3 ambitios_omega">
            <div class="ambitios_wrapper ambitios_p2">
                <a href="#" class="ambitios_picture ambitios_fleft  ambitios_lightbox_image" >
                    <img src="${item[2]}" alt="" width="282px" height="160px" />
                </a>
            </div>
            <h3 class="ambitios_uppercase">3x portfolio layouts.</h3>
        </div>
    </div>
</c:forEach>
