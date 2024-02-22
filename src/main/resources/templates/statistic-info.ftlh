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
        <td>[${getStatisticByCirculation.date}]</td>
        <td>${getStatisticByCirculation.circulation}</td>
        <td>${getStatisticByCirculation.tab_1}</td>
        <td>${getStatisticByCirculation.tab_2}</td>
        <td>${getStatisticByCirculation.tab_3}</td>
        <td>${getStatisticByCirculation.tab_4}</td>
        <td>${getStatisticByCirculation.tab_5}</td>
        <td>${getStatisticByCirculation.tab_6}</td>
        <td>${getStatisticByCirculation.tab_7}</td>
        <td>${getStatisticByCirculation.tab_8}</td>
    </tr>
    </tbody>
</table>
</body>
</html>