<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<div>
    <h1>${product.name}</h1>
    <img src="/img/${product.filename}" width="300px">
</div>

<form method="post" action="interactWithFavourites">
    <div class="form-group">
        <input type="hidden" name="product" value=${product.id}>
        <#if isAuthorised>
        <input type="hidden" name="user" value=${user.id}>
        </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <input type="submit" value="${message?ifExists}">
    </div>
</form>

<form method="post" action="addToCart">
    <div class="form-group">
        <input type="hidden" name="product" value=${product.id}>
        <#if isAuthorised>
        <input type="hidden" name="user" value=${user.id}>
        </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <input type="submit" width="300px" value="Добавить в корзину"/>
    </div>
</form>

<form method="post" action="deleteFromCart">
    <div class="form-group">
        <input type="hidden" name="product" value=${product.id}>
        <#if isAuthorised>
        <input type="hidden" name="user" value=${user.id}>
    </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <input type="submit" width="300px" value="Удалить из корзины"/>
    </div>
</form>

<h1>${product.cost}</h1>

</@c.page>