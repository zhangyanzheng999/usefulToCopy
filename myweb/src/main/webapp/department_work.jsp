<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="/favicon.ico" >
    <link rel="Shortcut Icon" href="/favicon.ico" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="${APP_PATH}/his/static/finance/echarts.js"></script>
    <script type="text/javascript" src="${APP_PATH}/his/static/finance/jquery.min.js"></script></head>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>门诊科室工作量统计</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <style>
        #Bar
        {
            position: absolute;
            left:7%;
            bottom: -60px;
        }
        #Pie
        {
            position: absolute;
            left:40%;
            bottom: -20px;
        }
        #Line
        {
            position: absolute;
            left:70%;
            bottom: -60px;
        }
    </style>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="department_work">

        <div class="row cl">
            <label class="form-label col-xs-1 col-sm-2">统计时间从</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder="选择起始日期" id="startdate" name="startdate">
                </div>

            <label class="form-label col-xs-1 col-sm-1">到</label>
                <div class="formControls col-xs-2 col-sm-2">
                    <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder="选择终止日期" id="enddate" name="enddate">
                </div>
            <div class="formControls col-xs-2 col-sm-2">
                <button class="btn btn-primary radius" type="button" id="search1" onclick="searchByTime()">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
            </div>
        </div>
        <br>
        <h3 align="center"><u>门诊科室工作量统计 </u></h3>

        <div class="row cl">
                <div style="position:absolute; width:1200px; height:170px;z-index:1;left:100px;top:150px;">
                    <table class="table table-border table-bg" id="department-table">
                        <thead>
                        <tr>
                            <th style="width:100px;">编号</th>
                            <th style="width:100px;">科室名称</th>
                            <th style="width:100px;">挂号</th>
                            <th style="width:100px;">诊疗</th>
                            <th style="width:100px;">检验</th>
                            <th style="width:100px;">超声</th>
                            <th style="width:100px;">放射</th>
                            <th style="width:100px;">MRI</th>
                            <th style="width:100px;">CT</th>
                            <th style="width:100px;">西药</th>
                            <th style="width:100px;">处置</th>
                            <th style="width:100px;">麻醉</th>
                        </tr>
                        </thead>
                        <tr>
                            <td style="width:100px;">K01</td>
                            <td style="width:100px;">全科门诊</td>
                            <td style="width:100px;">24</td>
                            <td style="width:100px;">5</td>
                            <td style="width:100px;">6</td>
                            <td style="width:100px;">4</td>
                            <td style="width:100px;">7</td>
                            <td style="width:100px;">2</td>
                            <td style="width:100px;">3</td>
                            <td style="width:100px;">1</td>
                            <td style="width:100px;">0</td>
                            <td style="width:100px;">2</td>
                        </tr>
                        <tr>
                            <td style="width:100px;">K02</td>
                            <td style="width:100px;">内科</td>
                            <td style="width:100px;">32</td>
                            <td style="width:100px;">5</td>
                            <td style="width:100px;">6</td>
                            <td style="width:100px;">4</td>
                            <td style="width:100px;">7</td>
                            <td style="width:100px;">2</td>
                            <td style="width:100px;">3</td>
                            <td style="width:100px;">1</td>
                            <td style="width:100px;">0</td>
                            <td style="width:100px;">2</td>
                        </tr>
                        <tr>
                            <td style="width:100px;">K03</td>
                            <td style="width:100px;">妇产科</td>
                            <td style="width:100px;">3</td>
                            <td style="width:100px;">5</td>
                            <td style="width:100px;">6</td>
                            <td style="width:100px;">4</td>
                            <td style="width:100px;">7</td>
                            <td style="width:100px;">2</td>
                            <td style="width:100px;">3</td>
                            <td style="width:100px;">1</td>
                            <td style="width:100px;">0</td>
                            <td style="width:100px;">2</td>
                        </tr>
                        <tr>
                            <td style="width:100px;">K04</td>
                            <td style="width:100px;">心血管内科</td>
                            <td style="width:100px;">2</td>
                            <td style="width:100px;">5</td>
                            <td style="width:100px;">6</td>
                            <td style="width:100px;">4</td>
                            <td style="width:100px;">7</td>
                            <td style="width:100px;">2</td>
                            <td style="width:100px;">3</td>
                            <td style="width:100px;">1</td>
                            <td style="width:100px;">0</td>
                            <td style="width:100px;">2</td>
                        </tr>
                        <tr>
                            <td style="width:100px;">SUM</td>
                            <td style="width:100px;">合计</td>
                            <td style="width:100px;">106</td>
                            <td style="width:100px;">30</td>
                            <td style="width:100px;">36</td>
                            <td style="width:100px;">24</td>
                            <td style="width:100px;">42</td>
                            <td style="width:100px;">12</td>
                            <td style="width:100px;">18</td>
                            <td style="width:100px;">6</td>
                            <td style="width:100px;">0</td>
                            <td style="width:100px;">12</td>
                        </tr>
                        <tbody>
                        </tbody>
                    </table>
            </div>
        </div>



        <div class="row cl">
            <div id="Bar" style="width: 350px;height:260px;"></div>
            <div id="Pie" style="width: 350px;height:200px;"></div>
            <div id="Line" style="width: 350px;height:260px;"></div>
        </div>



    </form>
</article>
<!--_footer 作为公共模版分离出去-->
<%-- <script type="text/javascript" src="${APP_PATH}/his/lib/jquery/1.9.1/jquery.min.js"></script> --%>
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/his/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/messages_zh.js"></script>

<%-- 财务管理模块--%>
<script type="text/javascript" src="${APP_PATH}/his/static/finance/department_work.js"></script>
</body>
</html>