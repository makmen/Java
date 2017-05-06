<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="article">
  <h2><span>Contact</span></h2><div class="clr"></div>
  <p>You can find more of my free template designs at my website. For premium commercial designs, you can check out DreamTemplate.com.</p>
</div>

<div class="article">
    <h2><span>Send us</span> mail</h2><div class="clr"></div>

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

    <form:form method="post" modelAttribute="contact" action="">
        <ol>
            <li>
                <label for="name">Name (required)</label>
                <form:input path="name" cssClass="required" id="name"></form:input>
            </li>
            <li>
                <label for="email">Email Address (required)</label>
                <form:input path="email" cssClass="required"></form:input>
            </li>
            <li>
                <label for="message">Your Message</label>
                <form:textarea path="message" cssClass="required" rows="5" cols="10"></form:textarea>
            </li>
            <li>
                <input type="image" name="imageField" src="<c:url value="/resources/images/submit.gif" />" class="send" />
                <div class="clr"></div>
            </li>
        </ol>
    </form:form>

</div>