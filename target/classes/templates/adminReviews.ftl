<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <br>
    <br>
    <div class="centered">
        <h2>Управление отзывами</h2>
    </div>
    <br>
    <br>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Заголовок</th>
                <th>Отзыв</th>
                <th>Звезд</th>
                <th>Закреплен</th>
                <th>Комментарий организации</th>
                <th>Действия</th>
            </tr>
        </thead>
        <tbody>
            <#list reviews as review>
                <tr>
                    <td>${review.id}</td>
                    <td>${review.header}</td>
                    <td>${review.text}</td>
                    <td>${review.stars}</td>
                    <td>${review.pinned?string("Да", "Нет")}</td>
                    <td>
                        <form method="post" action="/add-response">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <div class="form-group">
                                <textarea name="response" class="form-control" rows="2">${review.answer!}</textarea>
                            </div>
                            <input type="hidden" name="reviewId" value="${review.id}">
                            <button type="submit" class="btn btn-primary">Сохранить</button>
                        </form>
                    </td>
                    <td>
                        <#if review.pinned>
                            <a href="/unpin-review/${review.id}" class="btn btn-warning">Открепить</a>
                        <#else>
                            <a href="/pin-review/${review.id}" class="btn btn-success">Закрепить</a>
                        </#if>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</div>
</@c.page>
