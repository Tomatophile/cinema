<#import "parts/common.ftlh" as c>

<@c.html>
    <div class="container text-white">
        <br>
        <br>
        <p><b>${user.getNickname()}</b></p>
        <p>${user.getEmail()}</p>
        <p>${user.getBirthday()}</p>
        <a class="btn btn-light text-dark btn-sm" href="/profile/own/bought" role="button">Купленные</a>
        <a class="btn btn-light text-dark btn-sm" href="/profile/own/rented" role="button">Арендованные</a>
    </div>
</@c.html>