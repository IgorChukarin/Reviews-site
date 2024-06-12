<#include "security.ftl">
<#import "login.ftl" as l>

<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light pl-0 pr-0">
        <a class="navbar-brand" href="/">СитиСтрой</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" style="width: 950px">
                <li class="nav-item">
                    <a class="nav-link" href="/">Главная</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">Контакты</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/">О нас</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/reviews">Отзывы</a>
                </li>
                <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/reviews">Администратор</a>
                </li>
                </#if>
            </ul>
            <@l.logout />
        </div>
    </nav>
</div>