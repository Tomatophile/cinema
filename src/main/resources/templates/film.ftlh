<#import "parts/common.ftlh" as c>

<@c.html>
    <div class="container-fluid">
            <img src="${film.getImgUrl()}" class="img-thumbnail ms-4 mt-2" alt="${film.getName()}" width="600"
                 height="900">

    </div>
</@c.html>