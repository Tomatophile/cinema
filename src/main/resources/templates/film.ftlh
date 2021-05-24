<#import "parts/common.ftlh" as c>

<#include "parts/security.ftlh">

<@c.html>
    <div class="container-fluid">
        <img src="${film.getImgUrl()}" class="img-thumbnail ms-4 mt-2" alt="${film.getName()}"
             width="600" height="900" align="left" vspace="10" hspace="10">
    </div>
    <div class="container text-white">
        <br>
        <br>
        <p><b>${film.getName()}</b></p>
        <p>${film.getStringYear()}</p>
        <p>${film.getCountry()}</p>
        <p>Возрастное ограничение: ${film.getAgeLimit()}+</p>
        <p><i>${film.getDescription()}</i></p>
    </div>
    <#if known>
        <#if user.getAge() gte film.getAgeLimit()>
            <#if bought>
            <#else>
                <a class="btn btn-light text-dark btn-sm" href="/films/${film.getId()}/buy"
                   role="button">Купить: ${film.getBuyPrice()}р</a>
                <#if rented>
                <#else>
                    <a class="btn btn-light text-dark btn-sm" href="/films/${film.getId()}/rent" role="button">Арендовать: ${film.getRentPrice()}
                        р</a>
                </#if>
            </#if>
        <#else>
            Возрастное ограничение: ${film.getAgeLimit()}+
        </#if>
    <#else>
        <a class="btn btn-light text-dark btn-sm" href="/login" role="button">Купить: ${film.getBuyPrice()}р</a>
        <a class="btn btn-light text-dark btn-sm" href="/login" role="button">Арендовать: ${film.getRentPrice()}р</a>
    </#if>
</@c.html>