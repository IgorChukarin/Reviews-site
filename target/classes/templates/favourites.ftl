<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
<div class="card-columns">
    <#list products as product>
    <a href="/products/${product.id}">
        <div class="card my-3">
            <#if product.filename??>
            <img src="/img/${product.filename}" class="card-img-top">
        </#if>
        <div class="m-2">
            <span>${product.name}</span>
        </div>
        <div class="m-2">
            <b>${product.cost} ₽</b>
        </div>
    </a>
</div>
<#else>
No products
</#list>
</div>
</@c.page>