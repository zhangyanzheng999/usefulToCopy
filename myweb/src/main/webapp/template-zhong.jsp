<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css"/>
    <link rel="stylesheet" href="${APP_PATH}/his/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js"></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>中医处方模板</title>
</head>
<body>
<div>
    <div class="page-container form-label col-xs-4" style="display: inline-block">
        <div style="background:whitesmoke">
            <font color="#6495ed"> 中药处方模板:</font>
            <button class="btn" style="background: whitesmoke;margin-left: 230px;border: none;color: cornflowerblue"
                    type="button" id="addZhongTemplate"> 新建模板
            </button>
        </div>
        <form class="form form-horizontal">
            <div class="row cl">
                <label class="form-label col-xs-2 ">名称：</label>
                <div class="formControls col-xs-4">
                    <input type="text" class="input-text" value="" placeholder="输入模板名称" id="TemplateName">
                </div>
                <label class="form-label col-xs-2 ">范围：</label>
                <div class="formControls col-xs-4">
                    <select class="select" id="range">
                        <option value="1"> 全院</option>
                        <option value="2"> 科室</option>
                        <option value="3"> 个人</option>
                    </select>
                </div>
            </div>
            <div class="row  cl">
                <div class="formControls col-xs-2">
                    <button class="btn" type="button" id="findTemplate" style="background: cornflowerblue;color: white">
                        查询
                    </button>
                </div>
            </div>
            <div class="row cl" style="margin-left: 20px">
                <table id="templateTable">
                    <thead>
                    <tr>
                        <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">
                            模板名称
                        </th>
                        <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px ">
                            创建时间
                        </th>
                        <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">
                            范围
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <%--这里动态生成--%>
                    </tbody>
                </table>
            </div>
        </form>
    </div>
    <div class="page-container form-label col-xs-8" style="display: inline-block;margin-top: 30px">
        <form class="form form-horizontal">
            <div style="background:whitesmoke">
                <font color="#6495ed">操作:</font>
                <button style="color: cornflowerblue;margin-left:200px;background: whitesmoke;border: none" class="btn"
                        type="button" id="addMed">增加药品
                </button>
                <button style="color: cornflowerblue;margin-left: 50px;background: whitesmoke;border: none" class="btn"
                        type="button" id="deleteMed">删除药品
                </button>
                <button style="color: cornflowerblue;margin-left: 50px;background: whitesmoke;border: none" class="btn"
                        type="button" id="modifyZhongTemplate">修改模板
                </button>
                <button style="color: cornflowerblue;margin-left: 50px;background: whitesmoke;border: none" class="btn"
                        type="button" id="deleteZhongTemplate">删除模板
                </button>
            </div>
            <div class="row cl col-xs-12">
                <div style="background: lightsteelblue">
                    <center style="color: cornflowerblue"> 模板明细:</center>
                </div>
            </div>
            <div class="row cl" style="text-align: center;margin-top: 60px;">
                <label class="form-label col-xs-2">模板名称</label>
                <div class="formControls col-xs-3">
                    <input type="text" class="input-text" id="formtemplateName">
                </div>
                <label class="form-label col-xs-2">模板范围</label>
                <div class="formControls col-xs-2">
                    <select class="select" id="templateRange">
                        <option value="1"> 全院</option>
                        <option value="2"> 科室</option>
                        <option value="3"> 个人</option>
                    </select>
                </div>
            </div>
        </form>
        <div class="row cl" style="margin-top: 30px">

            <table id="jianYanTable" style="margin-left: 20px">
                <thead>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">
                    <input type="checkbox" id="zhong-select">
                </th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">药品名称</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">规格</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">单位</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">用法</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">用量</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">频次</th>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="${APP_PATH}/his/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript">


</script>
</body>
</html>