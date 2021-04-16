<#import "parts/common.ftlh" as c>

<@c.html>
    <form method="get" action="/films">
        <input type="text" name="contains"  placeholder="Поиск">
        <input type="submit" value="Поиск">
    </form>
    <br>
    <br>
    Рекомендованые:
    <br>
    <table border="1">
        <tr>
            <th>Жанр</th>
            <th>Название</th>
            <th>Год выхода</th>
            <th>Рейтинг</th>
        </tr>
        <#assign count = 0>
        <#list films as film>
            <tr>
                <td>${film.getGenre()}</td>
                <td><a href="/films/${film.getId()}">${film.getName()}</a></td>
                <td>${film.getYear()}</td>
                <td>${film.getRating()}</td>
            </tr>
            <#assign count = count + 1>
            <#if count = 5><#break></#if>
        <#else>
            <tr>
                <td>--</td>
                <td>No films</td>
                <td>--</td>
                <td>--</td>
            </tr>
        </#list>
    </table>
    <br>
    <a href="/films?sort=rating">More</a>
    <br>
    <br>
    <a href="/films">Library</a>
</@c.html>