<#import "parts/common.ftl" as c>
<@c.page>
<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/products" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by tag ">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list products as product>
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
</div>
<#else>
No products
</#list>
</div>
</@c.page>