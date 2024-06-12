<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<br>
<br>
<div class="centered">
    <h2>Регистрация</h2>
</div>
<br>
<br>
${message?ifExists}
<@l.login "/registration" true/>
</@c.page>