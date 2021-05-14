 <#include "security.ftlh">
 <#import "form.ftlh" as form>
    <style>
        .navbar
        {
            border-bottom:3px solid darkblue;
        }
    </style>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container-lg">
            <a class="navbar-brand" href="/">Cinema</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/films?sort=new">Новинки</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/films?sort=rating">Лучшее</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="/films">Все фильмы</a>
                    </li>
                </ul>
                <form class="d-flex" action="/films" method="get">
                    <input class="form-control me-2" type="search" placeholder="Поиск" name="contains">
                    <button class="btn btn-sm btn-outline-secondary" type="submit">Поиск</button>
                </form>
                <i>br</i>
                <br>
                <#if known>
                    <a class="btn btn-outline-warning" href="/profile" role="button">${user.getNickname()}</a>
                    <i>b</i>
                    <@form.logout/>
                <#else>
                    <a class="btn btn-outline-success" href="/login" role="button">Войти</a>
                </#if>
            </div>
        </div>
    </nav>