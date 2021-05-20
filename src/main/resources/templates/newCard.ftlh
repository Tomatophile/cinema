<#import "parts/common.ftlh" as c>
<#import "parts/form.ftlh" as form>

<@c.html>

    <form method="post" action="/profile/card/new">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="text" name="number">
        <input type="text" name="owner">
        <input type="date" name="endDate">
        <input type="submit">
    </form>
</@c.html>