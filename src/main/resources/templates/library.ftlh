<#import "parts/common.ftlh" as c>
<#import "parts/form.ftlh" as form>
<#import "parts/displayFilms.ftlh" as disp>

<@c.html>
    <div class="container mb-3">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <@form.filter/>
            </div>
            <div class="col"></div>
        </div>
    </div>
    <@disp.cards 0/>
</@c.html>