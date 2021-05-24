<#import "parts/common.ftlh" as c>
<#import "parts/form.ftlh" as form>

<@c.html>
    <div class="container-fluid text-white">
    <form method="post" action="/profile/card/new">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <div class="mb-3">
            <label for="number" class="form-label">Номер карты</label>
            <input type="text" class="form-control" id="number" name="number" minlength="16" maxlength="16">
        </div>
        <div class="mb-3">
            <label for="owner" class="form-label">Держатель карты</label>
            <input type="text" class="form-control" id="owner" name="owner">
        </div>
        <div class="mb-3">
            <label for="endDate" class="form-label">Действительна до</label>
            <input type="date" class="form-control" id="endDate" name="endDate">
        </div>
        <button type="submit" class="btn btn-success">Добавить</button>
    </form>
    </div>
</@c.html>