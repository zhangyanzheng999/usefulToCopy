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
<title>门诊医生工作量统计</title>
<meta name="keywords" content="">
<meta name="description" content="">

<style>
    .top{
        position:absolute;
        width:350px;
        height:230px;
        z-index:1;
        left:15%;
        bottom:-5px
    }
    #Line2
    {
        width: 330px;
        height:280px;
        position: absolute;
        left:62%;
        bottom: -60px;
    }
    table.Top-table {
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
        border-width: 1px;
        border-color: #a9c6c9;
        border-collapse: collapse;
    }
    table.Top-table th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    table.Top-tabl td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #a9c6c9;
    }
    .oddrowcolor{
        background-color:#d4e3e5;
    }
    .evenrowcolor{
        background-color:#c3dde0;
    }
</style>
</head>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="doctor_work">
        <div class="row cl">
            <label class="form-label col-xs-1 col-sm-2">统计时间从</label>
            <div class="formControls col-xs-2 col-sm-2">
                <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder="选择起始日期" id="startdate" name="startdate">
            </div>

            <label class="form-label col-xs-1 col-sm-1">到</label>
            <div class="formControls col-xs-2 col-sm-2">
                <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder="选择终止日期" id="enddate" name="enddate">
            </div>
            <label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>选填</label>
            <div class="formControls col-xs-2 col-sm-2" >
                <input type="text" class="input-text" value="" placeholder="请输入科室名或编号" id="name_id" name="name_id">
            </div>
            <div class="formControls col-xs-2 col-sm-2" style="text-indent:5em">
                <button class="btn btn-primary radius" type="submit" id="search2" value="">&nbsp;&nbsp;查询&nbsp;&nbsp;</button>
            </div>
        </div>
        <br>
        <h3 align="center"><u>门诊医生工作量统计 </u></h3>

        <div class="row cl">
            <div style="position:absolute; width:1200px; height:170px;z-index:1;left:100px;top:150px;">
                <table class="table table-border table-bg" id="doctor-table">
                    <thead>
                    <tr>
                        <th style="width:100px;">编号</th>
                        <th style="width:100px;">医生姓名</th>
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
                    <tr>
                        <th style="width:100px;">Y01</th>
                        <th style="width:100px;">周安南</th>
                        <th style="width:100px;">24</th>
                        <th style="width:100px;">5</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">4</th>
                        <th style="width:100px;">7</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">1</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">2</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">Y02</th>
                        <th style="width:100px;">张静</th>
                        <th style="width:100px;">32</th>
                        <th style="width:100px;">5</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">4</th>
                        <th style="width:100px;">7</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">1</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">2</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">Y03</th>
                        <th style="width:100px;">何一楠</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">5</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">4</th>
                        <th style="width:100px;">7</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">1</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">2</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">Y04</th>
                        <th style="width:100px;">王美丽</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">5</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">4</th>
                        <th style="width:100px;">7</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">1</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">2</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">Y05</th>
                        <th style="width:100px;">刘守武</th>
                        <th style="width:100px;">42</th>
                        <th style="width:100px;">5</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">4</th>
                        <th style="width:100px;">7</th>
                        <th style="width:100px;">2</th>
                        <th style="width:100px;">3</th>
                        <th style="width:100px;">1</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">2</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">SUM</th>
                        <th style="width:100px;">合计</th>
                        <th style="width:100px;">106</th>
                        <th style="width:100px;">30</th>
                        <th style="width:100px;">36</th>
                        <th style="width:100px;">24</th>
                        <th style="width:100px;">42</th>
                        <th style="width:100px;">12</th>
                        <th style="width:100px;">18</th>
                        <th style="width:100px;">6</th>
                        <th style="width:100px;">0</th>
                        <th style="width:100px;">12</th>
                    </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="row cl">
            <div class="top">
                <table class="Top-table" border="3" id="Top-table">
                    <h4 align="center">工作量排名Top4</h4>
                    <thead>
                    <tr>
                        <th style="width:100px;">排名</th>
                        <th style="width:100px;">姓名</th>
                        <th style="width:100px;">接诊人次</th>
                    </tr>
                    </thead>
                    <tr>
                        <th style="width:100px;">No1</th>
                        <th style="width:100px;">刘守武</th>
                        <th style="width:100px;">42</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">No2</th>
                        <th style="width:100px;">张静</th>
                        <th style="width:100px;">32</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">No3</th>
                        <th style="width:100px;">周安南</th>
                        <th style="width:100px;">24</th>
                    </tr>
                    <tr>
                        <th style="width:100px;">No4</th>
                        <th style="width:100px;">何一楠</th>
                        <th style="width:100px;">3</th>
                    </tr>
                </table>
            </div>
        </div>

        <div id="Line2"></div>

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
<script type="text/javascript" src="${APP_PATH}/his/static/finance/doctor_work.js"></script>
<script type="text/javascript">
    function altRows(id){
        if(document.getElementsByTagName){

            var table = document.getElementById(id);
            var rows = table.getElementsByTagName("tr");

            for(i = 0; i < rows.length; i++){
                if(i % 2 == 0){
                    rows[i].className = "evenrowcolor";
                }else{
                    rows[i].className = "oddrowcolor";
                }
            }
        }
    }

    window.onload=function(){
            altRows('Top-table');
        }
</script>
</body>
</html>