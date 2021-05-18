<#import "parts/common.ftlh" as c>

<@c.html>
    <#list boughtFilms as film>
        ${film.getFilm().getName()}
        ${film.getQuality()}
        <br>
    </#list>
</@c.html>