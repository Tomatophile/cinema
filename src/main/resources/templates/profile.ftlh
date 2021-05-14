<#import "parts/common.ftlh" as c>

<@c.html>
    Id: ${user.getId()} <br>
    Name : ${user.getNickname()}<br>
    Email: ${user.getEmail()}<br>
    Birthday: ${user.getBirthday()}<br>
    Gender: ${user.getGender()}<br>
</@c.html>