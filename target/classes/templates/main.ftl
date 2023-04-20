<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>
<div>
    <form method="post" enctype="multipart/form-data">
        <input type="text" name="name" placeholder="Введите имя товара" />
        <input type="text" name="cost" placeholder="Цена" />
        <input type="text" name="tag" placeholder="Тэг">
        <input type="file" name="file">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Добавить</button>
    </form>
</div>
<div>Список товаров</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter?ifExists}">
    <button type="submit">Найти</button>
</form>
<#list products as product>
<div>
    <b>${product.id}</b>
    <span>${product.name}</span>
    <i>${product.cost}</i>
    <i>${product.tag}</i>
    <div>
        <#if product.filename??>
            <img src="/img/${product.filename}">
        </#if>
    </div>
</div>
<#else>
No products
</#list>
</@c.page>