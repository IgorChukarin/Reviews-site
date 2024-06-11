<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div class="mb-1"><h5>Регистрация</h5></div>
<br>
${message?ifExists}
<@l.login "/registration" true/>
</@c.page>