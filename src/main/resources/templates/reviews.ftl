<#import "parts/common.ftl" as c>

<@c.page>
<br>
<div class="centered">
    <h2>Отзывы наших клиентов</h2>
</div>
<br>
<div class="container">
<br>
<a href="/leave-review" class="btn btn-warning">Оставить отзыв</a>
<br>
<br>
    <div class="row">
        <#list pinnedReviews as pinnedReview>
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${pinnedReview.header}</h5>
                        <p class="card-text">${pinnedReview.text}</p>
                        <div class="rate readonly" data-rate="${pinnedReview.stars}">
                            <#-- Create star elements dynamically based on review.rating -->
                            <#assign stars = pinnedReview.stars?number>
                            <#list 1..stars?int as i>
                                <label>★</label>
                            </#list>
                            <#if (stars - stars?int) != 0>
                                <label>★</label>
                            </#if>
                        </div>
                        <p class="card-text"><small class="text-muted">${pinnedReview.user.username}</small></p>
                    </div>
                </div>
            </div>
        </#list>
        <#list otherReviews as review>
            <div class="col-md-6">
                <div class="card mb-4">
                    <div class="card-body">
                        <h5 class="card-title">${review.header}</h5>
                        <p class="card-text">${review.text}</p>
                        <div class="rate readonly" data-rate="${review.stars}">
                            <#-- Create star elements dynamically based on review.rating -->
                            <#assign stars = review.stars?number>
                            <#list 1..stars?int as i>
                                <label>★</label>
                            </#list>
                            <#if (stars - stars?int) != 0>
                                <label>★</label>
                            </#if>
                        </div>
                        <p class="card-text"><small class="text-muted">${review.user.username}</small></p>
                    </div>
                </div>
            </div>
        </#list>
    </div>
</div>
<br>
</@c.page>