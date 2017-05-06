<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="ambitios_p4">
    <c:choose>
        <c:when test="${news!=null}">
            <div class="ambitios_wrapper ambitios_p2">
                <h3 class="ambitios_uppercase ambitios_p5">${news.title}</h3>
                <div class="ambitios_date">
                    Registed: ${news.registed}
                    <br />
                    Updated: ${news.updated}
                    <div class="printlink">
                        <a href="#" id="auc-print">Версия для печати</a>
                    </div>
                    <div class="cb"></div>
                        <c:if test="${canEdit!=null}">
                            <div class="newsedit">
                                <a href="/news/edit/${news.id}">Редактировать</a>
                            </div>
                            <div class="cb"></div>
                        </c:if>
                </div>
                <br />
                    ${news.text}
            </div>
        </c:when>
        <c:otherwise>
            <div class="mess-top">
                <div class="fbok">
                    <div class="info">Нет данных</div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>

    <a href="/news">Вернуться к списку новостей</a>
</div>

<script type="text/javascript" language="javascript">
    function back() {
        history.go(-1);
    }

    $(function(){
        $('#auc-print').click(function(){
            prnt_wnd = window.open('/news/print/${news.id}', 'print_view', 'width=900, height=700,toolbar=0, scrollbars=yes');
            prnt_wnd.focus();
            return false;
        });
    });
</script>