<#include "security.ftl">
<#import "login.ftl" as l>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light pl-0 pr-0">
        <a class="navbar-brand" href="/">E-shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" style="width: 950px">
                <li class="nav-item">
                    <a class="nav-link" href="/products">Products</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/main">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user">User list</a>
                </li>
                </#if>
                <#if isAuthorised>
                <li class="nav-item" style="margin-left: auto; order: 2; display: flex">
                    <a class="nav-link" href="/favourites/${user.id}">Favourites</a>
                    <a class="nav-link" href="/cart/${user.id}">Cart</a>
                </li>
                </#if>
                <#if !isAuthorised>
                    <a class="nav-link" href="/cart">Cart</a>
                </#if>

            </ul>
            <@l.logout />
        </div>
    </nav>
</div>