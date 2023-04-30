<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<h1>${product.name}</h1>
<img src="/img/${product.filename}" width="300px">
<div></div>
<form method="post" action="addToFavourites">
    <div class="form-group">
        <input type="hidden" name="product" value=${product.id}>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <input type="submit" width="300px" value="Добавить в избранное"/>
    </div>
</form>
<h1>${product.cost}</h1>
<h1>${user.getUsername()}</h1>
</@c.page>