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
        <section class="m-1" style="font-size: 20px;">
            <span>${product.name}</span>
        </section>
        <section class="m-1" style="font-size: 20px;">
            <span>${product.cost} ₽</span>
        </section>
    </a>
</div>
<#else>
No products
</#list>
</div>
</@c.page>