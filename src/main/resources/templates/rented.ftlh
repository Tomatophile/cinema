<#import "parts/common.ftlh" as c>

<@c.html>
    <#list rentedFilms as film>
        ${film.getFilm().getName()}
        ${film.getQuality()}
        ${film.getEndDate()}
        <br>
    </#list>
</@c.html>