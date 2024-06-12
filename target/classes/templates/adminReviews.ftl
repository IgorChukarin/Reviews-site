<#import "parts/common.ftl" as c>
<@c.page>
<div class="container">
    <h2>Управление отзывами</h2>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Заголовок</th>
                <th>Отзыв</th>
                <th>Закреплен</th>
                <th>Действия</th>
            </tr>
        </thead>
        <tbody>
            <#list reviews as review>
                <tr>
                    <td>${review.id}</td>
                    <td>${review.header}</td>
                    <td>${review.text}</td>
                    <td>${review.pinned?string("Да", "Нет")}</td>
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
