<!DOCTYPE html>
<html>
<head>
    <title>StatDate</title>
</head>
<body>
<div style="font-size: 12px; color: green; font-family: Arial,serif">[statistic.ftlh] :: started</div><hr>

<form action="/statistic/create/" method="post" style="font-size: 14px; font-family: Arial,serif">
    <input type="text" name="timeNewPost" style="width: 123px; text-align: center" placeholder="dd.mm.yyyy hh:mm">
    <input type="submit" value="ADD"><br>
    <input type="number" name="tab_1" style="width: 33px; text-align: center" placeholder="tab_1">
    <input type="number" name="tab_2" style="width: 33px; text-align: center" placeholder="tab_2">
    <input type="number" name="tab_3" style="width: 33px; text-align: center" placeholder="tab_3">
    <input type="number" name="tab_4" style="width: 33px; text-align: center" placeholder="tab_4"><br>
    <input type="number" name="tab_5" style="width: 33px; text-align: center" placeholder="tab_5">
    <input type="number" name="tab_6" style="width: 33px; text-align: center" placeholder="tab_6">
    <input type="number" name="tab_7" style="width: 33px; text-align: center" placeholder="tab_7">
    <input type="number" name="tab_8" style="width: 33px; text-align: center" placeholder="tab_8">
</form><hr>

<#list getStatisticList as staticData>
    [${staticData.timeNewPost}]
    <a href="/statistic/${staticData.id}">::${staticData.id}::</a>
    ${staticData.tab_1}
    ${staticData.tab_2}
    ${staticData.tab_3}
    ${staticData.tab_4}
    ${staticData.tab_5}
    ${staticData.tab_6}
    ${staticData.tab_7}
    ${staticData.tab_8}<br>
</#list><hr>


</body>
</html>