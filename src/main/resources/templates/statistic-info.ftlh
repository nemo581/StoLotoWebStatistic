<!DOCTYPE html>
<html>
<head>
    <title>Statistic-info</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div style="font-size: 12px; color: green; font-family: Arial,serif">[statistic-info.ftlh] :: started</div>
<hr>

<table class="table">
    <thead>
    <tr style="font-size: 14px; font-family: Arial,serif">
        statistic-info.ftlh
    </tr>
    <tr>
        <th>Дата</th>
        <th>Тираж</th>
        <th colspan="8">Выпавшие числа</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>[${getStatisticById.timeNewPost}]</td>
        <td>${getStatisticById.id}</td>
        <td>${getStatisticById.tab_1}</td>
        <td>${getStatisticById.tab_2}</td>
        <td>${getStatisticById.tab_3}</td>
        <td>${getStatisticById.tab_4}</td>
        <td>${getStatisticById.tab_5}</td>
        <td>${getStatisticById.tab_6}</td>
        <td>${getStatisticById.tab_7}</td>
        <td>${getStatisticById.tab_8}</td>
    </tr>
    </tbody>
</table>
</body>
</html>