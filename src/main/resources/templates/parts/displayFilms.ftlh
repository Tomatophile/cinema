<#macro cards max>
    <style>
        .card
        {
            border:1px solid #F8F8FF;
        }
        .img-gradient:after {
            content: '';
            position: absolute;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            display: inline-block;
            background: -webkit-linear-gradient(top, rgba(0, 0, 0, 0) 0%, rgba(1, 1, 1, 1) 100%);

        }
    </style>
    <div class="container">
        <div class="row justify-content-md-center">
            <#assign count = 0>
            <#list films as film>
                <div class="col-md-auto mb-2">
                    <div class="card bg-dark text-white text-end" style="width: 16rem;">
                        <img src="${film.getImgUrl()}" class="card-img-top" alt="${film.getName()}">
                        <div class="mask img-gradient"></div>
                        <div class="card-img-overlay d-flex flex-column">
                            <div class="text-start">
                            <span class="badge <#if film.getRating() gte 7>bg-success<#else>bg-secondary</#if>" style="width: 30px; height: 20px;">${film.getRating()}</span>
                            </div>
                            <div class="mt-auto">
                                <h5 class="card-title">${film.getName()}</h5>
                                <p class="card-text">
                                ${film.getStringYear()}
                                    <#assign genreCount = 0>
                                    <#list film.getGenres() as genre>
                                        , ${genre.getName()}
                                        <#assign genreCount = genreCount+1>
                                        <#if genreCount = 2><#break></#if>
                                    </#list>
                                 </p>
                                <a href="/films/${film.getId()}" class="btn btn-outline-secondary btn-sm">Подробнее</a>
                            </div>
                        </div>
                    </div>
                </div>
                <#assign count = count + 1>
                <#if count = max><#break></#if>
                <#else>
                    <div class="card bg-dark text-white text-end" style="width: 16rem;">
                        <img src="..." class="card-img-top" alt="Empty">
                        <div class="mask img-gradient"></div>
                        <div class="card-img-overlay d-flex flex-column">
                            <div class="mt-auto">
                                <h5 class="card-title">Empty</h5>
                                <p class="card-text">
                                    Empty
                                </p>
                            </div>
                        </div>
                    </div>
            </#list>
        </div>
    </div>
</#macro>