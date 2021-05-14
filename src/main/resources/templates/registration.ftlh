<#import "parts/form.ftlh" as form>
<#import "parts/common.ftlh" as c>

<@c.html>
    <div class="container mt-5">
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <@form.reg "/registration"/>
                <div class="text-danger" align="center"><#if message??>${message}</#if></div>
            </div>
            <div class="col"></div>
        </div>
    </div>
</@c.html>