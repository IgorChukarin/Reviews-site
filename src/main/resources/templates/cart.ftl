<#import "parts/common.ftl" as c>

<@c.page>
<div class="cart">
  <#list products as product>
  <section class="cart2">
    <a href="/products/${product.id}">
          <div class="card" style="margin-left: 0px; margin-right: 0px">
            <#if product.filename??>
            <img src="/img/${product.filename}" class="card-img-top">
          </#if>
            <div style="flex-direction: column">

                <span>${product.name}</span>
                <hr style="border-width: 0px">
                <b>${product.cost}₽</b>

            </div>
          </div>
    </a>
  </section>
  <#else>
  No products
</#list>
</div>
</div>
<div style="margin-left: 160px">
    <h1>Итог: ${totalCost}</h1>
</div>
<div style="margin-left: 160px">
    <input type="submit" value="Оплатить">
</div>
</@c.page>