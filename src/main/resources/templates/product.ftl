<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>

<section class="toyPageImg">

    <figure class="gallery__item gallery__item--1">
            <img src="/img/${product.filename}" class="gallery__img" alt="Image 1">
        </figure>
        <div class="toyPageText">
            <h1 style="padding: 0px">${product.name}</h1>
            <br>
            <h1 style="padding: 0px">Описание</h1>
            <br>
            <p style="display: inline-block; ">Крутая фигурка</p>
            </br>
            <br>
            <p style="display: inline-block; ">Высота: 28см</p>
            </br>
            <br>
            <p style="display: inline-block; ">Детализация</p>
            </br>
            <br>
            <p style="display: inline-block; ">Полностью подвижное бесшовное тело</p>
            </br>
            <br>
            <p style="display: inline-block; ">Материал: пластик</p>
            </br>
            <br>
            <p style="display: inline-block; "></p>
            </br>
        </div>
</section>

<form method="post" action="interactWithFavourites">
    <div class="form-group">
        <input type="hidden" name="product" value=${product.id}>
        <#if isAuthorised>
        <input type="hidden" name="user" value=${user.id}>
        </#if>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div>
        <input type="submit" value="${message?ifExists}" style="font-size: 25px">
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