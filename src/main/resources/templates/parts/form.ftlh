<#macro login path>
    <div class="container-sm text-white">
        <form action="${path}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="mb-3">
                <label for="nickname" class="form-label">Имя пользователя</label>
                <input type="text" class="form-control" id="nickname" name="username">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Пароль</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <button type="submit" class="btn btn-success">Войти</button>
            <a class="btn btn-outline-secondary" href="/registration" role="button">Зарегистрироваться</a>
        </form>
    </div>
</#macro>

<#macro reg path>
    <div class="container-sm text-white">
        <form action="${path}" method="post">
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" class="form-control" id="email" name="email">
            </div>
            <div class="mb-3">
                <label for="nickname" class="form-label">Имя пользователя</label>
                <input type="text" class="form-control" id="nickname" name="nickname">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Пароль</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="mb-3">
                <label for="birthday" class="form-label">Пароль</label>
                <input type="date" class="form-control" id="birthday" name="birthday">
            </div>
            <div class="mb-3">
                <select class="form-select" name="gender">
                    <option selected disabled>Пол</option>
                    <option value="u">Не указано</option>
                    <option value="m">Мужчина</option>
                    <option value="f">Женщина</option>
                    <option value="b">Другое</option>
                </select>
            </div>
            <button type="submit" class="btn btn-success">Зарегистрироваться</button>
            <a class="btn btn-outline-primary" href="/login" role="button">Войти</a>
        </form>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-outline-danger">Выход</button>
    </form>
</#macro>

<#macro filter>
    <div class="container text-white">
        <form action="/films" method="get">
            <div class="row g-3">
                <div class="col">
                    Выбрать жанр:
                    <select name="selectedGenre" id="genre" style="width: 200px">
                        <option <#if !selectedGenre??>selected</#if>>--</option>
                        <#list genres as genre>
                            <option <#if selectedGenre?? && selectedGenre=='${genre.getName()}'>selected</#if>
                                    value="${genre.getName()}">${genre.getName()}</option>
                        </#list>
                    </select>
                </div>
                <div class="col">
                    Сортировать:
                    <select name="sort" id="sort">
                        <option <#if !sort??>selected</#if>>--</option>
                        <option <#if sort?? && sort=='new'>selected</#if> value="new">Новее</option>
                        <option <#if sort?? && sort=='rating'>selected</#if> value="rating">Выше рейтинг</option>
                        <option <#if sort?? && sort=='abc'>selected</#if> value="abc">По алфавиту</option>
                    </select>
                </div>
                <div class="col">
                    <input type="text" id="contains" name="contains" placeholder="Поиск" style="width: 200px"
                           <#if contains??>value="${contains}"</#if>>
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-outline-primary btn-sm">Поиск</button>
                </div>
            </div>
        </form>
    </div>
</#macro>
