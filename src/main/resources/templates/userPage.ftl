<#import "parts/common.ftl" as c>

<@c.page>
<h4 class="my-2">Name: ${userName}</h4>
<br>
<form action="/logout" method="post" style="margin-top: 30px; margin-bottom: 400px">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Выйти</button>
</form>
</@c.page>