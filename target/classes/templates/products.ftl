<#import "parts/common.ftl" as c>
<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/products" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by name">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>


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