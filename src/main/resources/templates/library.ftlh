<#import "parts/common.ftlh" as c>

<@c.html>
    <div>
        <form action="/films" method="get">
            <p>
                <input type="text" name="contains"  placeholder="Поиск" <#if contains??>value="${contains}"</#if>>

                <label for="genre">Жанр</label>
                <select name="selectedGenre" id="genre">
                    <option <#if !selectedGenre??>selected</#if>>--</option>
                    <#list genres as genre>
                        <option <#if selectedGenre?? && selectedGenre=='${genre.getName()}'>selected</#if> value="${genre.getName()}">${genre.getName()}</option>
                    </#list>
                </select>
            </p>
            <p>
                <label for="sort">Сортировать</label>
                <select name="sort" id="sort">
                    <option <#if !sort??>selected</#if>>--</option>
                    <option <#if sort?? && sort=='new'>selected</#if> value="new">Новее</option>
                    <option <#if sort?? && sort=='rating'>selected</#if> value="rating">Выше рейтинг</option>
                    <option <#if sort?? && sort=='abc'>selected</#if> value="abc">По алфавиту</option>
                </select>
            </p>
            <p><input type="submit" value="Поиск"></p>
        </form>
    </div>
    <table border="1">
        <tr>
            <th>Жанр</th>
            <th>Название</th>
            <th>Год выхода</th>
            <th>Рейтинг</th>
        </tr>
        <#list films as film>
            <tr>
                <td><#list film.getGenres() as genre>${genre.getName()}</#list></td>
                <td><a href="/films/${film.getId()}">${film.getName()}</a></td>
                <td>${film.getYear()}</td>
                <td>${film.getRating()}</td>
            </tr>
        <#else>
            <tr>
                <td>--</td>
                <td>No films</td>
                <td>--</td>
                <td>--</td>
            </tr>
        </#list>
    </table>
    <br>
    <br>
    <a href="/">Home</a>
</@c.html>