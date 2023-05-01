<#include "security.ftl">
<#import "login.ftl" as l>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light pl-0">
        <a class="navbar-brand" href="/">E-shop</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
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
                <li class="nav-item">
                    <a class="nav-link" href="/favourites/${user.id}">Favourites</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/cart/${user.id}">Cart</a>
                </li>
                </#if>
                <#if !isAuthorised>
                    <a class="nav-link" href="/cart">Cart</a>
                </#if>

            </ul>
            <div class="navbar-text mr-3">${name}</div>
            <@l.logout />
        </div>
    </nav>
</div>