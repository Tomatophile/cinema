<#import "parts/common.ftlh" as c>

<@c.html>
<strong>${film.getName()}</strong>
    <br>
    Year: ${film.getYear()}
    <br>
    Genre: ${film.getGenre()}
    <br>
    Rating: ${film.getRating()}
    <br>
    <br>
    <a href="/films">Library</a>
</@c.html>