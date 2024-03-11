<!DOCTYPE html>
<html>
<head>
    <title>StatDate</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<div style="font-size: 12px; color: green; font-family: Arial,serif">[statistic.ftlh] :: started</div>
<hr>
<form action="/updateData" method="get">
    <input type="submit" value="Update"/>
</form>
<div class="container mtb-3">
    <div class="table-responsive">
        <table class=table>
            <thead>
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
                    <td>[${data.getDateByPage()}]</td>
                    <td><a href="/statistic/${data.getCirculationByPage()}">${data.getCirculationByPage()}</a></td>
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
    </div>
</div>
</body>
</html>