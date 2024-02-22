<!DOCTYPE html>
<html>
<head>
    <title>StatDate</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div style="font-size: 12px; color: green; font-family: Arial,serif">[statistic.ftlh] :: started</div>
<hr>

<form action="/" method="get">
    <input type="number" name="circulation" style="width: 33px; text-align: center" placeholder="circulation"><input type="submit" value="Поиск"><br>
</form>

<#--<form action="/statistic/create/" method="post" style="font-size: 14px; font-family: Arial,serif">-->
<#--    <input type="text" name="timeNewPost" style="width: 123px; text-align: center" placeholder="dd.mm.yyyy hh:mm">-->
<#--    <input type="submit" value="ADD"><br>-->
<#--    <input type="number" name="tab_1" style="width: 33px; text-align: center" placeholder="tab_1">-->
<#--    <input type="number" name="tab_2" style="width: 33px; text-align: center" placeholder="tab_2">-->
<#--    <input type="number" name="tab_3" style="width: 33px; text-align: center" placeholder="tab_3">-->
<#--    <input type="number" name="tab_4" style="width: 33px; text-align: center" placeholder="tab_4"><br>-->
<#--    <input type="number" name="tab_5" style="width: 33px; text-align: center" placeholder="tab_5">-->
<#--    <input type="number" name="tab_6" style="width: 33px; text-align: center" placeholder="tab_6">-->
<#--    <input type="number" name="tab_7" style="width: 33px; text-align: center" placeholder="tab_7">-->
<#--    <input type="number" name="tab_8" style="width: 33px; text-align: center" placeholder="tab_8">-->
<#--</form>-->

<form action="/" method="post" style="font-size: 14px; font-family: Arial,serif">
    <input type="submit" value="GetNewStatisticData"><br>
</form>
<hr>

<table class="table">
    <thead>
    <tr style="font-size: 14px; font-family: Arial,serif">
        статистические данные
    </tr>
    <tr>
        <th>Дата</th>
        <th>Тираж</th>
        <th colspan="8">Выпавшие числа</th>
        <th>Банк</th>
    </tr>
    </thead>
    <tbody>
    <#list getStatisticList as data>
        <tr>
            <td>[${data.date}]</td>
            <td><a href="/statistic/${data.circulation}">${data.circulation}</a></td>
            <td>${data.tab_1}</td>
            <td>${data.tab_2}</td>
            <td>${data.tab_3}</td>
            <td>${data.tab_4}</td>
            <td>${data.tab_5}</td>
            <td>${data.tab_6}</td>
            <td>${data.tab_7}</td>
            <td>${data.tab_8}</td>
            <td>${data.bank}</td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>