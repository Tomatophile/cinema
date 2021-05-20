<#import "parts/common.ftlh" as c>

<#include "parts/security.ftlh">

<@c.html>
    <div class="container-fluid">
        <img src="${film.getImgUrl()}" class="img-thumbnail ms-4 mt-2" alt="${film.getName()}" width="600"
             height="900">
    </div>
    <#if known>
        <#if user.getAge() < film.getAgeLimit()>
            <a class="btn btn-light text-dark btn-sm" href="/films/${film.getId()}/buy" role="button">Купить</a>
            <a class="btn btn-light text-dark btn-sm" href="/films/${film.getId()}/rent" role="button">Арендовать</a>
        <#else>
            Возрастное ограничение ${film.getAgeLimit()}
        </#if>
    <#else>
        <a class="btn btn-light text-dark btn-sm" href="/login" role="button">Купить</a>
        <a class="btn btn-light text-dark btn-sm" href="/login" role="button">Арендовать</a>
    </#if>
</@c.html>