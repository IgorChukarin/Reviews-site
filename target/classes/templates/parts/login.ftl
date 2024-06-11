<#include "security.ftl">
<#macro login path isRegisterForm>
<form action="${path}" method="post" style="margin-bottom: 420px">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Имя пользователя :</label>
        <div class="col-sm-6">
            <input type="text" name="username" class="form-control" placeholder="имя пользователя"/>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Пароль :</label>
        <div class="col-sm-6">
            <input type="password" name="password" class="form-control" placeholder="пароль" />
        </div>
    </div>
    <#if isRegisterForm>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">E-mail :</label>
        <div class="col-sm-6">
            <input type="email" name="email" class="form-control" placeholder="example@mail.ru" />
        </div>
    </div>
    </#if>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <#if !isRegisterForm><a href="/registration">Зарегистрироваться</a>  или  </#if>
    <button class="btn btn-primary" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
</form>
</#macro>

<#macro logout>
<#if !isAuthorised>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="submit">Войти</button>
</form>
</#if>

<#if isAuthorised>
<a href="/user/userPage/${user.id}">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button class="btn btn-primary" type="">${name}</button>
</a>
</#if>
</#macro>