<#import "parts/common.ftlh" as c>
<#import "parts/displayFilms.ftlh" as disp>

<@c.html>
    <h2 align="center" style="color: #F8F8FF; margin-bottom: 20px">Рекомендуем к просмотру</h2>
    <@disp.cards 8/>
</@c.html>