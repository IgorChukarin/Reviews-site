<#import "parts/common.ftl" as c>
<@c.page>
<div class="centered">
    <h2>Ваш отзыв</h2>
</div>
<form method="post" action="/leave-review">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <div class="form-group">
        <label for="exampleFormControlInput1">Заголовок</label>
        <input name="header" type="text" class="form-control" id="exampleFormControlInput1">
    </div>
    <div class="form-group">
        <label for="exampleFormControlTextarea1">Отзыв</label>
        <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
    </div>
    <label for="checkBox">Оценка</label>
    <div id="checkBox">
        <div class="form-check form-check-inline">
            <input name="stars" class="form-check-input" type="radio" id="inlineRadio1" value="1">
            <label class="form-check-label" for="inlineRadio1">1</label>
        </div>
        <div class="form-check form-check-inline">
            <input name="stars" class="form-check-input" type="radio" id="inlineRadio1" value="2">
            <label class="form-check-label" for="inlineRadio1">2</label>
        </div>
        <div class="form-check form-check-inline">
            <input name="stars" class="form-check-input" type="radio" id="inlineRadio1" value="3">
            <label class="form-check-label" for="inlineRadio1">3</label>
        </div>
        <div class="form-check form-check-inline">
            <input name="stars" class="form-check-input" type="radio" id="inlineRadio1" value="4">
            <label class="form-check-label" for="inlineRadio1">4</label>
        </div>
        <div class="form-check form-check-inline">
            <input name="stars" class="form-check-input" type="radio" id="inlineRadio1" value="5">
            <label class="form-check-label" for="inlineRadio1">5</label>
        </div>
    </div>
    <br>
    <button type="submit" class="btn btn-warning">Оставить отзыв</button>
    <br>
    <br>
    <br>
    <br>
</form>
</@c.page>