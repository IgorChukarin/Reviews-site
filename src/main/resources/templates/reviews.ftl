<#import "parts/common.ftl" as c>

<@c.page>
<br>
<div class="centered">
    <h2>Отзывы наших клиентов</h2>
</div>
<br>
<div class="container">
    <div class="row">
        <#list reviews as review>
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${review.header}</h5>
                        <p class="card-text">${review.text}</p>
                        <div>

                        </div>
                        <p class="card-text"><small class="text-muted">username</small></p>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<br>
</@c.page>