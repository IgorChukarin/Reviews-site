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


<section class="card-columns">
    <#list products as product>
    <div>
        <a href="/products/${product.id}">
        <section class="card">
            <#if product.filename??>
            <img src="/img/${product.filename}" class="card-img-top">
            </#if>
        </section>
        <section class="m-2">
            <span>${product.name}</span>
        </section>
        <section class="m-2">
            <b>${product.cost} ₽</b>
        </section>
        </a>
    </div>
<#else>
No products
</#list>
</section>
</@c.page>