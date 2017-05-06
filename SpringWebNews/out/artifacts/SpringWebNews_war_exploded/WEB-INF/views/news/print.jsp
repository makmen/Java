<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    table tr {
        vertical-align: top;
        font-family: Arial,Tahoma,Verdana;
        font-size: 16px;
    }

    td.right {
        background: #ececec;
        font-weight: bold;
        text-align: left;
    }
    td.center {
        background: #fff;
        font-weight: bold;
        text-align: center;
    }

    td {
        padding: 10px 15px;
        border: 1px solid #ececec;
    }
</style>

<table cellpadding="0" cellspacing="0" width="100%">
    <tr>
        <td class="center" colspan="2">Версия для печати</td>
    </tr>
    <tr>
        <td class="right" width="25%">Название новости</td>
        <td>${news.title}</td>
    </tr>
    <tr>
        <td class="right">Содержание</td>
        <td>${news.text}</td>
    </tr>
    <tr>
        <td class="right">Дата создания</td>
        <td>${news.registed}</td>
    </tr>
    <tr>
        <td class="right">Дата редактирования</td>
        <td>${news.updated}</td>
    </tr>
</table>
<script type="text/javascript">
    document.onload = window.print();
</script>
