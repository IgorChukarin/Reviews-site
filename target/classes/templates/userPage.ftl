<#import "parts/common.ftl" as c>

<@c.page>
${userName}
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">log out</button>
</form>
</@c.page>