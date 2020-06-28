<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
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
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <!--/meta 作为公共模版分离出去-->
    <title>病历首页</title>
    <style type="text/css">
        .tabBar {border-bottom:1px solid white}
        .tabBar span {border:2px solid whitesmoke;background-color: whitesmoke;cursor: pointer;display: inline-block;float: left;
            font-weight: normal;height: 30px;line-height: 30px;padding: 0 18px}
        .tabBar span.current{background-color: white;color: cornflowerblue;border-bottom-style:none}
        .tabCon {display: none}
    </style>
</head>
<body>
<div class="page-container">
    <form class="form form-horizontal" id="form-article-add">
        <div id="tab-system" class="HuiTab">
            <div class="tabBar cl">
                <span>病历首页</span>
                <span>检查申请*</span>
                <span>检验申请*</span>
                <span>处置申请*</span>
                <span>成药处方</span>
                <span>草药处方*&nbsp;&nbsp;&nbsp;</span>
            </div>
            <div class="tabCon">
                <p></p>
                <div style="background-color:whitesmoke;">
                    <center> <a href="javascript:save();"><font color="cornflowerblue">暂存</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:thesubmit();"><font color="cornflowerblue">提交</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:clear();"> <font color="cornflowerblue">清空所有</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refresh();"> <font color="cornflowerblue">刷新</font></a></center>
                </div>
                <font color="cornflowerblue" style="background:aliceblue;">&nbsp;&nbsp;病史内容:&nbsp;&nbsp;</font>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">主诉：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="zs" name="zs">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">现病史：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="xbs" name="xbs">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">现病治疗情况：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="xbzlqk" name="xbzlqk">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">既往史：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="jws" name="jws">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">过敏史：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="gms" name="gms">
                    </div>
                </div>
                <div class="row cl">
                    <label class="form-label col-xs-4 col-sm-2">体格检查：</label>
                    <div class="formControls col-xs-8 col-sm-9">
                        <input type="text"  class="input-text" value="" id="tgjc" name="tgjc">
                    </div>
                </div>
                <p></p>
                <font color="cornflowerblue" style="background:aliceblue;">&nbsp;&nbsp;评估/诊断:&nbsp;&nbsp;</font>
                <div  class="va-t"  style="border:1px Gainsboro solid;">
                    <p></p>
                    <p>&nbsp;&nbsp;西医诊断:
                        <a href="javascript:add_xiyi_zhenduan();"><font color="cornflowerblue" style="float:right;">&nbsp;&nbsp;&nbsp;增加&nbsp;&nbsp;&nbsp;&nbsp;</font></a>
                        <a href="javascript:del_xiyi_zhenduan();"><font color="red" style="float:right;">删除</font></a></p>
                    <table id="Wtable"   style="margin-bottom:20px;" >
                        <thead>
                        <tr >
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-top-style:solid;">&nbsp; </th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;"><input type="checkbox" onchange="" id="xi_select" name="xi_select" value=""></th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">ICD编码</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">名称</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">发病时间</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-top-style:solid;">&nbsp; </th>
                        </tr>
                        </thead>
                        <tbody ></tbody>
                    </table>
                </div>
                <p></p>
                <div  class="va-t"  style="border:1px Gainsboro solid;">
                    <p></p>
                    <p>&nbsp;&nbsp;中医诊断:
                        <a href="javascript:add_zhongyi_zhenduan();"><font color="cornflowerblue" style="float:right;">&nbsp;&nbsp;&nbsp;增加&nbsp;&nbsp;&nbsp;&nbsp;</font></a>
                        <a href="javascript:del_zhongyi_zhenduan();"><font color="red" style="float:right;">删除</font></a></p>
                    <table id="Ctable"   style="margin-bottom:20px;" >
                        <thead>
                        <tr >
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-top-style:solid;">&nbsp; </th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;"><input type="checkbox" id="zhong_select" name="zhong_select" value=""></th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">ICD编码</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">名称</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">发病时间</th>
                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-top-style:solid;">&nbsp; </th>
                        </tr>
                        </thead>
                        <tbody >
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="tabCon">
                <p></p>
                <div style="background-color:aliceblue;">
                    <center><a id='add'><font color="cornflowerblue">新增项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a id='delete'><font color="cornflowerblue">删除项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a  href='javascript:clearProject()'> <font color="cornflowerblue">开立项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:waste();"> <font color="cornflowerblue">作废项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:combination();"> <font color="cornflowerblue">存为组套</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refresh();"> <font color="cornflowerblue">刷新</font></a></center>
                </div>
                <p></p>
                <table >
                    <tr>
                        <td class="va-t" >
                            <div class="page-container" style="border:1px Gainsboro solid;">
                                <div  class="HuiTab">
                                    <a href="javascript:checked_total_money();"> <font color="cornflowerblue" style="background:aliceblue;">本项目金额合计：</font></a>
                                    <font color="orange" style="background:yellow;"><span id="checked_total_money"></span></font>
                                    <p></p>
                                    <table id="tableAA" >
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">
                                                <input type="checkbox" onchange="checkAll()" id="checkall" name="checkall" value=""></th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">申请名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">项目名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行科室</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行状态</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">单价&nbsp;&nbsp;</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">检查结果</th>
                                        </tr>
                                        <tbody id="checkMessage">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                        <td width="250" class="va-t" >
                            <div class="page-container" style="border:1px Gainsboro solid;">
                                <div  class="HuiTab">
                                    <font color="cornflowerblue" style="background:aliceblue;">常用模板：</font>
                                    <p></p>
                                    <table id="tableC"  >
                                        <thead>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">小儿感冒</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">腱消炎</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <a href="javascript:use();"><font color="cornflowerblue">使用</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="javascript:detail();"><font color="cornflowerblue">详细</font></a>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">肩周炎</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">骨外伤</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>

                    </tr>
                </table>


            </div>
            <!-- 检验处置-->
            <div class="tabCon">
                <p></p>
                <div style="background-color:aliceblue;">
                    <center><a id='add1'><font color="cornflowerblue">新增项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a id='delete1'><font color="cornflowerblue">删除项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a  href='javascript:clearProject1()'> <font color="cornflowerblue">开立项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:waste1();"> <font color="cornflowerblue">作废项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:combination1();"> <font color="cornflowerblue">存为组套</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refresh()1;"> <font color="cornflowerblue">刷新</font></a></center>
                </div>
                <p></p>
                <table >
                    <tr>
                        <td class="va-t" >
                            <div class="page-container" style="border:1px Gainsboro solid;">
                                <div  class="HuiTab">
                                    <a href="javascript:checked_total_money1();"> <font color="cornflowerblue" style="background:aliceblue;">本项目金额合计：</font></a>
                                    <font color="orange" style="background:yellow;"><span id="checked_total_money1"></span></font>
                                    <p></p>
                                    <table id="tableE" >
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">
                                                <input type="checkbox" onchange="checkAll1()" id="checkall1" name="checkall1" value=""></th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">申请名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">项目名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行科室</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行状态</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">单价&nbsp;&nbsp;</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">检查结果</th>
                                        </tr>
                                        <tbody id="checkMessage1">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>
                        <td width="250" class="va-t" >
                            <div class="page-container" style="border:1px Gainsboro solid;">
                                <div  class="HuiTab">
                                    <font color="cornflowerblue" style="background:aliceblue;">常用模板：</font>
                                    <p></p>
                                    <table id="tableF">
                                        <thead>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">操作</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">病毒性感冒</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">糖尿病</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <a href="javascript:use1();"><font color="cornflowerblue">使用</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <a href="javascript:detail1();"><font color="cornflowerblue">详细</font></a>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">白血病</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">肿瘤</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">
                                                <font color="cornflowerblue">使用</font>&nbsp;&nbsp;&nbsp;&nbsp;
                                                <font color="cornflowerblue">详细</font>
                                            </th>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
            <!--  处置申请 -->
            <div class="tabCon">
                <p></p>
                <div style="background-color:aliceblue;">
                    <center><a id='add2'><font color="cornflowerblue">新增项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a id='delete2'><font color="cornflowerblue">删除项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a  href='javascript:clearProject2()'> <font color="cornflowerblue">开立项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:waste2();"> <font color="cornflowerblue">作废项目</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:combination2();"> <font color="cornflowerblue">存为组套</font></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refresh2();"> <font color="cornflowerblue">刷新</font></a></center>
                </div>
                <p></p>
                <table >
                    <tr>
                        <td class="va-t" >
                            <div class="page-container" style="border:1px Gainsboro solid;">
                                <div  class="HuiTab">
                                    <a href="javascript:checked_total_money2();"> <font color="cornflowerblue" style="background:aliceblue;">本项目金额合计：</font></a>
                                    <font color="orange" style="background:yellow;"><span id="checked_total_money2"></span></font>
                                    <p></p>
                                    <table id="tableG" >
                                        <tr >
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">
                                                <input type="checkbox" onchange="checkAll2()" id="checkall2" name="checkall2" value=""></th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">申请名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">项目名称</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行科室</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">执行状态</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">单价&nbsp;&nbsp;</th>
                                            <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">检查结果</th>
                                        </tr>
                                        <tbody id="checkMessage2">

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </td>


                    </tr>
                </table>
            </div>

            <div class="tabCon">
                <p></p>
                <font color="cornflowerblue" style="background:aliceblue;">&nbsp;&nbsp;门诊诊断:&nbsp;</font><font style="background:whitesmoke;">&nbsp;
                <span id="done_zhenduan"></span>&nbsp;&nbsp;</font>
                <div style="background-color:aliceblue;">
                    <a href="javascript:del_drug();"><font color="green" style="float:right;">&nbsp;&nbsp;&nbsp;&nbsp;删药&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></a>
                    <a href="javascript:add_drug();"><font color="green" style="float:right;">增药</font>	</a>
                    <center><a href="javascript:add_mould();"><font color="cornflowerblue">增方</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:del_mould();"><font color="cornflowerblue">删方</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:open_mould();"><font color="cornflowerblue">开立</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:give_up();"><font color="cornflowerblue">作废</font></a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:refresh();"><font color="cornflowerblue">刷新</font></a></center>
                </div>
                <div >
                    <div class="formControls col-xs-3 col-sm-3">
                        <div class="page-container" style="border:1px Gainsboro solid;">
                            <div  class="HuiTab">
                                <span style="background-color:whitesmoke;">&nbsp;门诊处方：&nbsp;</span>
                                <table id="tableA"  >
                                    <thead>
                                    <tr >
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">
                                            <input type="checkbox" id="mould_select" name="mould_select" value=""></th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">名称</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">状态</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <p></p>
                    </div>
                    <div class="formControls col-xs-8 col-sm-8">
                        <div class="page-container" >
                            <div  class="HuiTab">
                                <a href="javascript:total_money();"> <font color="cornflowerblue" style="background:aliceblue;">本处方金额合计：</font></a>
                                <font color="orange" style="background:yellow;"><span id="total_money"></span></font>
                                <table id="tableB"  >
                                    <thead>
                                    <tr >
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">
                                            <input type="checkbox" onchange="" id="drug_select" name="drug_select" value=""></th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">药品名称</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">规格</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">单价</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">用法</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">用量</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">频次</th>
                                        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">数量</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <iframe ID="testIframe" Name="testIframe" width=100%  height=600px frameborder="0" SRC="mould.jsp"></iframe>
            </div>
            <div class="tabCon">
            </div>

        </div>
    </form>
</div>
<!-- 增加药品 -->
<div id="modal-demo" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">搜索药品</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="open_drug" placeholder="请输入药品关键字" name="open_drug">
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-3 col-sm-3">
    						<span class="select-box">
    						<select id="all_drug" name="all_drug" class="select" ></select>
    						</span>
                    </div>
                </div>
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text"  class="input-text" value="" id="yong_fa" placeholder="请输入药用法" name="open_drug">
                </div>
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="yong_liang" placeholder="请输入用量" name="open_drug">
                </div>
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="pin_ci" placeholder="请输入频次" name="open_drug">
                </div>
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="shu_liang" placeholder="请输入数量" name="open_drug">
                </div>
            </div>

            <div class="modal-body">
                <button class="btn btn-primary" id="use_this_drug" type="submit">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 西医诊断 -->
<div id="xiyi_zhenduan" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">西医诊断</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="xiyi_disease" placeholder="请输入疾病名字" name="xiyi_disease">
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-4 col-sm-4">
    				<span class="select-box">
    				<select id="all_xiyi_disease" name="all_xiyi_disease" class="select" ></select>
    				</span>
                    </div>
                </div>
            </div>
            <div class="row cl">
                <label class="col-sm-3 control-label" style="left:30px;"><span class="c-red">*</span>发病日期：</label>
                <div class="formControls col-xs-4 col-sm-4">
                    <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' })" placeholder="" id="has_disease_date" >
                    <span class="help-block"></span>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_this_xiyi_disease" type="button">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 中医诊断 -->
<div id="zhongyi_zhenduan" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">中医诊断</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="zhongyi_disease" placeholder="请输入疾病名字" name="zhongyi_disease">
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-4 col-sm-4">
    				<span class="select-box">
    				<select id="all_zhongyi_disease" name="all_zhongyi_disease" class="select" ></select>
    				</span>
                    </div>
                </div>
            </div>
            <div class="row cl">
                <label class="col-sm-3 control-label" style="left:30px;"><span class="c-red">*</span>发病日期：</label>
                <div class="formControls col-xs-4 col-sm-4">
                    <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' })" placeholder="" id="has_zhong_disease_date" >
                    <span class="help-block"></span>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_this_zhongyi_disease" type="submit">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 新增处方 -->
<div id="add_this_mould" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">新增处方</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <label class="col-sm-3 col-xs-3 control-label" style="left:70px;"><span class="c-red">*</span>处方名称：</label>
                <div class="formControls col-xs-4 col-sm-4">
                    <input type="text" class="input-text" value="" id="open_mould_name" placeholder="请输入处方名字" name="open_mould_name">
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary"  id="add_this_new_mould" type="submit">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<!--模态框-->
<div class="modal fade" id="collectfeeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel" align="center">新增项目</h4>
            </div>
            <div class="modal-body">

                <div class="row cl">
                    <label class="form-label col-xs-3 col-sm-3">申请名称：</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" placeholder="" id="patient_name" name="patient_name" >
                    </div>
                    <label class="form-label col-xs-3 col-sm-3">检查项目：</label>
                    <div class="formControls col-xs-3 col-sm-3">
				<span class="select-box"><select class="select" name="payway" id="payway">
						<option value="大抢救">大抢救</option>
						<option value="小抢救">小抢救</option>
						<option value="洗胃">洗胃</option>
						<option value="中心吸氧">中心吸氧</option>
						<option value="验血">验血</option>
						<option value="验尿">验尿</option>
						<option value="CT检测">CT检测</option>
				</select></span>
                    </div>
                </div>


            </div>
            <div class="modal-footer"  align="center" >
                <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
                <button type="button" class="btn btn-danger radius" id="project_add">添加</button>
            </div>
        </div>
    </div>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/his/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript">
    var flag1=true;
    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });
        $("#tab-system").Huitab({
            index:0
        });
    });
    //完成全选/全不选功能
    $(document).on('click','#xi_select',function(){
        var is_All_Check = $(this).prop("checked");
        $(".check_item").prop("checked", is_All_Check);
    });

    $(document).on('click','#zhong_select',function(){
        var is_All_Check = $(this).prop("checked");
        $(".check_item1").prop("checked", is_All_Check);
    });

    $(document).on('click','#drug_select',function(){
        var is_All_Check = $(this).prop("checked");
        $(".check_item2").prop("checked", is_All_Check);
    });
    $(document).on('click','#mould_select',function(){
        var is_All_Check = $(this).prop("checked");
        $(".check_item3").prop("checked", is_All_Check);
    });
    $(document).on('click','#check_select',function(){
        var is_All_Check = $(this).prop("checked");
        $(".check_item4").prop("checked", is_All_Check);
    });
    function del_project(){
        $.each($(".check_item4:checked"), function() {
            $(this).parent().parent().remove();//进行删除某一行
        });
    }
    var sign=[0,0,0,0,0,0];  //0：暂存  1：已开立  2：作废
    //改为开立状态
    function changen(i) {
        $.ajax({
            async: false,
            success: function() {
                sign[i] = 1;
            }
        })
    }
    //改为作废状态
    function changen1(i) {
        $.ajax({
            async: false,
            success: function() {
                sign[i] = 2;
            }
        })
    }
    function use(){

        row = document.getElementById("tableAA").insertRow();
        if(row!=null){
            cell=row.insertCell();
            cell.innerHTML= "<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'><input name=chk_1 type=checkbox  id='1' value='1'/></th>";
            cell=row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>模板：腱消炎</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>酵固醇测定</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>检验科</th>";
            cell=row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>暂存</th>";
            cell = row.insertCell();
            cell.innerHTML=50;
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>查看详细</th>";
        }
        row = document.getElementById("tableAA").insertRow();
        if(row!=null){
            cell=row.insertCell();
            cell.innerHTML= "<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'><input name=chk_1 type=checkbox  id='1' value='1'/></th>";
            cell=row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>模板：腱消炎</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>X浆肾素活性测定</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>检验科</th>";
            cell=row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>暂存</th>";
            cell = row.insertCell();
            cell.innerHTML=80;
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>查看详细</th>";
        }

    }

    function clearProject(){
        jstab=document.getElementById("tableAA");
        for (var k = 1; k <= jstab.rows.length; k++) {
            row = jstab.rows[k]; //迭代当前行
            cell = row.cells[0]; //复选框所在的单元格
            chk = cell.getElementsByTagName("input")[0]; //为单元格中第几个INPUT元素
            if (chk.checked) {//如果选中
                var td = row.cells[4];
                if(sign[k]==0){
                    td.innerHTML = '已开立';
                    changen(k);
                }else{
                    alert("当前状态不可开立！")
                }
            }
        }

    }

    $("#delete").click(function() {
        $("input[name='chk_1']:checked").each(function() { // 遍历选中的checkbox
            n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
            if(sign[n]!=1){
                $("table#tableAA").find("tr:eq("+n+")").remove();
            }else{
                alert("当前状态不可删除！")
            }

        });
    });

    function detail(){
        alert("项目名称：酵固醇检测   执行科室：检验科  单价：50 \n项目名称：X浆肾素活性测定   执行科室：检验科  单价：80")
    }
    function checkAll() {
        var father=document.getElementById('checkall'); //获取到父亲复选框（控制全选的id
        var son=document.getElementsByName('chk_1'); //获取儿子复选框名称name
        if(father.checked==true){//因为获得的是数组，所以要循环 为每一个checked赋值
            for(var i=0;i<son.length;i++){
                son[i].checked=true;
            }
        }else{
            for(var j=0;j<son.length;j++){
                son[j].checked=false;
            }
        }
    }

    function waste(){
        jstab=document.getElementById("tableAA");
        for (var k = 1; k <= jstab.rows.length; k++) {
            row = jstab.rows[k]; //迭代当前行
            cell = row.cells[0]; //复选框所在的单元格
            chk = cell.getElementsByTagName("input")[0]; //为单元格中第几个INPUT元素
            if (chk.checked) {//如果选中
                var td = row.cells[4];
                if(sign[k]==1){
                    td.innerHTML = '作废';
                    changen1(k);
                }else{
                    alert("当前状态不可作废！")
                }
            }
        }
    }

    //动态生成的按钮,使用事件委托的方式，将指定的事件绑定在document上
    $("#add").click(function() {

        $("#collectfeeModal").modal("show");

    })
    $("#project_add").click(function(){
        var pro=document.getElementById('patient_name').value;
        var chec=document.getElementById("payway").value;
        row = document.getElementById("tableAA").insertRow();
        if(row!=null){
            cell=row.insertCell();
            cell.innerHTML= "<input name=chk_1 type=checkbox  id='1' value='1'/>";
            cell=row.insertCell();
            cell.innerHTML=pro;
            cell = row.insertCell();
            cell.innerHTML=chec;
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>检验科</th>";
            cell=row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>暂存</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>"+50+"</th>";
            cell = row.insertCell();
            cell.innerHTML="<th height='35px' style='border-width:1px;border-color:Gainsboro;border-bottom-style:solid;'>查看详细</th>";
        }
        $("#collectfeeModal").modal("hide");
    })
    function combination(){
        jstab=document.getElementById("tableAA");
        for (var k = 1; k <= jstab.rows.length; k++) {
            row = jstab.rows[k]; //迭代当前行
            cell = row.cells[0]; //复选框所在的单元格
            chk = cell.getElementsByTagName("input")[0]; //为单元格中第几个INPUT元素
            if (chk.checked &&sign[k]!=2) {//如果选中且状态不是已作废
                var pro = row.cells[1];
                row = document.getElementById("tableC").insertRow();
                cell=row.insertCell();
                cell.innerHTML=pro.innerHTML;
                cell=row.insertCell();
                cell.innerHTML="<font color='cornflowerblue'>使用</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='cornflowerblue'>详细</font>";
            }
        }
    }
    //增加西医诊断
    function add_xiyi_zhenduan(){
        var Ccount = $("#Ctable tbody").find("tr").length;
        if(Ccount==0){
            $("#xiyi_disease").val("");
            $("#has_disease_date").val("");
            $("#all_xiyi_disease").empty();
            $("#xiyi_zhenduan").modal("show");
        }else{
            window.alert("中西医真能选择一个！");
        }
    }
    $("#xiyi_disease").change(function(){
        var disease_name=window.document.getElementById("xiyi_disease").value;
        if(disease_name.length>0){
            $.ajax({
                url:"${APP_PATH}/load_xiyi_disease",
                type:"GET",
                //async:false,
                data:"disease_name="+disease_name,
                dataType: "json",
                success:function(result){
                    $("#all_xiyi_disease").empty();
                    $.each(result.extend.dislist,function(){
                        var optionEle=$("<option></option>").append(this.diseaseName).attr("value",this.diseaseId);
                        optionEle.appendTo("#all_xiyi_disease");
                    });
                    return false;
                },
                error:function(result){

                }
            });
        }
    });

    $("#add_this_xiyi_disease").click(function(){

        var disease_id=window.document.getElementById("all_xiyi_disease").value;
        var fabing_date=window.document.getElementById("has_disease_date").value;
        if(disease_id.length>0&&fabing_date.length>0){
            $.ajax({
                url:"${APP_PATH}/load_detail_xiyi_disease",
                type:"GET",
                //async:false,
                data:"disease_id="+disease_id,
                dataType: "json",
                success:function(result){
                    $.each(result.extend.dislist,function(){
                        var Kong = $("<td></td>").append("");
                        var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item'/>");
                        var disease_name=$("<td></td>").append(this.diseaseName).attr("xi_dise",this.diseaseId);
                        var disease_ICD=$("<td></td>").append(this.diseaseIcd);
                        var has_date=$("<td></td>").append(fabing_date);
                        $("<tr></tr>").append(Kong).append(checkBoxTd).append(disease_ICD).append(
                            disease_name).append(has_date).appendTo("#Wtable tbody");
                    });
                    $("#xiyi_zhenduan").modal("hide");
                    return false;
                },
                error:function(result){

                }
            });
        }else{
            window.alert("请完善信息！");
        }

    });

    //删除对应的疾病
    function del_xiyi_zhenduan(){
        $.each($(".check_item:checked"), function() {
            $(this).parent().parent().remove();//进行删除某一行
        });
    }
    //增加中医诊断
    function add_zhongyi_zhenduan(){
        var Wcount = $("#Wtable tbody").find("tr").length;
        if(Wcount==0){
            $("#zhongyi_disease").val("");
            $("#has_zhong_disease_date").val("");
            $("#all_zhongyi_disease").empty();
            $("#zhongyi_zhenduan").modal("show");
        }else{
            window.alert("中西医只能选择一个！");
        }
    }
    $("#zhongyi_disease").change(function(){
        var disease_name=window.document.getElementById("zhongyi_disease").value;
        if(disease_name.length>0){
            $.ajax({
                url:"${APP_PATH}/load_xiyi_disease",
                type:"GET",
                //async:false,
                data:"disease_name="+disease_name,
                dataType: "json",
                success:function(result){
                    $("#all_xiyi_disease").empty();
                    $.each(result.extend.dislist,function(){
                        var optionEle=$("<option></option>").append(this.diseaseName).attr("value",this.diseaseId);
                        optionEle.appendTo("#all_zhongyi_disease");
                    });
                    return false;
                },
                error:function(result){

                }
            });
        }
    });
    $("#add_this_zhongyi_disease").click(function(){

        var disease_id=window.document.getElementById("all_zhongyi_disease").value;
        var fabing_date=window.document.getElementById("has_zhong_disease_date").value;
        if(disease_id.length>0&&fabing_date.length>0){
            $.ajax({
                url:"${APP_PATH}/load_detail_xiyi_disease",
                type:"GET",
                //async:false,
                data:"disease_id="+disease_id,
                dataType: "json",
                success:function(result){
                    $.each(result.extend.dislist,function(){
                        var Kong = $("<td></td>").append("");
                        var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item1'/>");
                        var disease_name=$("<td></td>").append(this.diseaseName).attr("zhong_dise",this.diseaseId);
                        var disease_ICD=$("<td></td>").append(this.diseaseIcd);
                        var has_date=$("<td></td>").append(fabing_date);
                        $("<tr></tr>").append(Kong).append(checkBoxTd).append(disease_ICD).append(
                            disease_name).append(has_date).appendTo("#Ctable tbody");
                    });
                    $("#zhongyi_zhenduan").modal("hide");
                    return false;
                },
                error:function(result){

                }
            });
        }else{
            window.alert("请完善信息！");
        }

    });
    //删除诊断
    function del_zhongyi_zhenduan(){
        $.each($(".check_item1:checked"), function() {
            $(this).parent().parent().remove();//进行删除某一行
        });
    }
    //使表格可编辑
    $(document).on('dblclick','#tableB td',function(){
        /* 1.先拿到这个td原来的值，然后将这个td变成一个input:text,并且原来的值不动 */
        var tdVal = $(this).text();
        var oInput = $("<input type='text' value='"+tdVal+"'/>");
        $(this).html(oInput);
        oInput.focus();
        /* 2.失去焦点，这个td变为原来的text，value为修改过后的value */
        oInput.blur(function(){
            oInput.parent().html(oInput.val());
        });
    });
    //计算总共金额
    function total_money(){
        var totalmoney=0;
        $("#tableB tr").each(function(){
            var drugprice=$(this).find("td:eq(3)").text();
            var drugnum=$(this).find("td:eq(7)").text();
            if(parseFloat(drugnum)>0){
                totalmoney=totalmoney+parseFloat(drugprice)*parseFloat(drugnum);
            }
        });
        $("#total_money").html(totalmoney+"元");
    }
    //计算总共金额
    function checked_total_money(){
        var totalmoney=0;
        $("#tableAA tr").each(function(){
            var drugprice=$(this).find("td:eq(5)").text();
            if(parseFloat(drugprice)>0){
                totalmoney=totalmoney+parseFloat(drugprice);
            }

        });
        $("#checked_total_money").html(totalmoney+"元");
    }





    //增药
    function add_drug(){
        var ctn=true;
        $.each($(".check_item3:checked"), function() {
            if($(this).parents("tr").find("td:eq(2)").attr("pre_state")==2){
                window.alert("已开立的不能修改");
                ctn=false;
                return false;
            }
        });
        if(!ctn) return;

        var mould_id=parent.$("#pre_id").val();
        if(mould_id.length>0){
            var count = $("#tableB tbody").find("tr").length;
            $("#open_drug").val("");
            $("#yong_fa").val("");
            $("#yong_liang").val("");
            $("#pin_ci").val("");
            $("#shu_liang").val("");
            $("#all_drug").empty();
            if(count<5){
                $("#modal-demo").modal("show");
            }else{
                window.alert("药品超过五种！请新增处方");
            }
        }else{
            window.alert("请选择处方");
        }
    }
    //在增药时把药品存进数据库
    function add_drug_todb(){
        var pre_id=parent.$("#pre_id").val();
        var drug_id=$("#tableB").find('tr:last-child').find("td").eq(1).attr("drug_id");
        /* if(typeof(drug_id)=='undefined') drug_id= $("#testIframe").contents().find("#drug_id").val();
        console.log(typeof(drug_id)); */
        var yong_fa=$("#tableB").find('tr:last-child').find("td").eq(4).text();
        var yong_liang=$("#tableB").find('tr:last-child').find("td").eq(5).text();
        var pin_ci=$("#tableB").find('tr:last-child').find("td").eq(6).text();
        var num=$("#tableB").find('tr:last-child').find("td").eq(7).text();
        if($.trim(num) == $.trim("请双击编辑")){
            num=1;
        }
        if(pre_id.length>0){
            $.ajax({
                url:"${APP_PATH}/add_drug_todb",
                type:"GET",
                //async:false,
                data:{pre_id:pre_id,drug_id:drug_id,yong_fa:yong_fa,yong_liang:yong_liang,pin_ci:pin_ci,num:num},
                dataType: "json",
                success:function(result){
                    $("#tableB").find('tr:last-child').find("td").eq(1).attr("detail_id",result.extend.detail_id);
                },error:function(result){

                }
            });
        }else{
            window.alert("请选择处方");
        }

    }
    //删除药品
    function del_drug(){
        //删除对应的药品
        var ctn=true;
        $.each($(".check_item3:checked"), function() {
            if($(this).parents("tr").find("td:eq(2)").attr("pre_state")==2){
                window.alert("已开立的不能修改");
                ctn=false;
                return;
            }
        });
        if(!ctn) return;
        var flag=false;
        $.each($(".check_item2:checked"), function() {
            if($(this).parents("tr").find("td:eq(1)").text().length>0){
                flag=true;
                return false;
            }
        });


        if(flag){
            $.each($(".check_item2:checked"), function() {
                var detail_id=$(this).parents("tr").find("td").eq(1).attr("detail_id");
                //console.log(detail_id);
                del_opende_detail_fromdb(detail_id);
                $(this).parent().parent().remove();//进行删除某一行

            });
        }else{
            window.alert("请选择药品");
        }
    }
    function del_opende_detail_fromdb(detail_id){
        $.ajax({
            url:"${APP_PATH}/del_opende_detail_fromdb",
            type:"GET",
            //async:false,
            data:{detail_id:detail_id},
            dataType: "json",
            success:function(result){

            },
            error:function(result){

            }
        });
    }
    //显示每个处方的药品
    $(document).on('click','#tableA tr',function(){
        var mould_id=$(this).find("td").eq(1).attr("mould_id");
        parent.$("#pre_id").val(mould_id);
        parent.load_detail_pre(mould_id);
    });


    //把处方存到数据库
    function store_pre(){
        var pre_name=$("#tableA").find('tr:last-child').find('td').eq(1).text();
        var state=$("#tableA").find('tr:last-child').find('td').eq(2).text();
        var regnum=parent.$("#reg_id").val();
        var medrecord_code=parent.$("#med_code").val();
        var doctor_id=parent.parent.$("#login_doctor").html();
        doctor_id=parseInt(doctor_id);
        $.ajax({
            url:"${APP_PATH}/store_pre",
            type:"GET",
            //async:false,
            data:{regnum:regnum,medrecord_code:medrecord_code,doctor_id:doctor_id,pre_name:pre_name,state:state},
            dataType: "json",
            success:function(result){
                parent.$("#pre_id").val(result.extend.mould_id);
                $("#tableA").find('tr:last-child').find('td').eq(1).attr("mould_id",result.extend.mould_id);
                console.log(result.extend.mould_id);
                console.log($("#tableA").find('tr:last-child').find('td').eq(1).attr("mould_id"));
                return true;
            },error:function(result){

            }
        });
    }

    //开立处方
    function open_mould(){
        var flag=true;
        var count=$(".check_item3:checked").length;
        if(count>0){
            $.each($(".check_item3:checked"), function() {
                if($(this).parents("tr").find("td:eq(2)").attr("pre_state")!=1){
                    flag=false;
                    return;
                }
            });
        }else{
            window.alert("请选择处方");
            return;
        }
        if(flag){
            $.each($(".check_item3:checked"), function() {
                if($(this).parents("tr").find("td").eq(1).text().length>0){
                    var pre_id=$(this).parents("tr").find("td").eq(1).attr("mould_id");
                    open_pre(pre_id);
                    open_detail_pre(pre_id);
                }
            });

            parent.load_pre();
            window.alert("开立成功");
        }else{
            window.alert("开立或者作废的不能再开立");
        }
    }
    function open_pre(pre_id){
        $.ajax({
            url:"${APP_PATH}/open_pre",
            type:"GET",
            //async:false,
            data:{pre_id:pre_id},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){

            }
        });
    }
    function open_detail_pre(pre_id){
        $.ajax({
            url:"${APP_PATH}/open_detail_pre",
            type:"GET",
            //async:false,
            data:{pre_id:pre_id},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){

            }
        });
    }
    //增加处方
    function add_mould(){
        var regnum=parent.$("#reg_id").val();
        if(regnum.length>0){
            $("#open_mould_name").val("");
            $("#add_this_mould").modal("show");
        }else{
            window.alert("请选择患者");
        }
    }
    //把新处方名字写进表格
    $("#add_this_new_mould").click(function(){
        var mouldname=$("#open_mould_name").val();
        var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item3'/>");
        var mould_name=$("<td></td>").append(mouldname);
        var state=$("<td></td>").append("暂存").attr("pre_state",1);
        $("<tr></tr>").append(checkBoxTd).append(mould_name).append(state).appendTo("#tableA tbody");
        store_pre();
        $("#add_this_mould").modal("hide");
    });





    //删除处方
    function del_mould(){
        var ctn=true;
        $.each($(".check_item3:checked"), function() {
            if($(this).parents("tr").find("td:eq(2)").attr("pre_state")==2){
                window.alert("已开立的不能修改");
                ctn=false;
                return;
            }
        });
        if(!ctn) return;
        var flag=false;
        $.each($(".check_item3:checked"), function() {
            if($(this).parents("tr").find("td:eq(1)").text().length>0){
                flag=true;
                return false;
            }
        });
        if(flag){
            $.each($(".check_item3:checked"), function() {
                //var mould_id=parent.$("#pre_id").val();
                if($(this).parents("tr").find("td:eq(1)").text().length>0){
                    var mould_id=$(this).parents("tr").find("td").eq(1).attr("mould_id");
                    //console.log(mould_id);
                    del_mould_fromdb(mould_id);
                    del_detail_fromdb(mould_id);
                }

            });
            parent.$("#pre_id").val("");
            window.alert("删除成功");
            parent.load_pre();
        }else{
            window.alert("请选处方");
        }
    }




    //删除处方
    function del_mould_fromdb(mould_id){
        $.ajax({
            url:"${APP_PATH}/del_mould_fromdb",
            type:"GET",
            //async:false,
            data:{mould_id:mould_id},
            dataType: "json",
            success:function(result){
                return true;
            },error:function(result){

            }
        });
    }
    //删除该处方所有处方明细
    function del_detail_fromdb(mould_id){
        $.ajax({
            url:"${APP_PATH}/del_detail_fromdb",
            type:"GET",
            //async:false,
            data:{mould_id:mould_id},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){

            }
        });
    }
    //作废
    function give_up(){

        var flag=true;
        $.each($(".check_item3:checked"), function() {
            if($(this).parents("tr").find("td:eq(2)").attr("pre_state")==1){
                flag=false;
                return;
            }
        });

        if(flag){
            $("#tableB tbody").empty();
            $.each($(".check_item3:checked"), function() {
                var pre_id=$(this).parents("tr").find("td:eq(1)").attr("mould_id");
                give_up_pre(pre_id);
                give_up_detailpre(pre_id);
            });
        }else{
            window.alert("含有暂存的不能作废");
            return;
        }
        window.alert("作废成功");
        parent.load_pre();
    }
    function give_up_pre(pre_id){
        $.ajax({
            url:"${APP_PATH}/give_up_pre",
            type:"GET",
            //async:false,
            data:{pre_id:pre_id},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){

            }
        });
    }
    function give_up_detailpre(pre_id){
        $.ajax({
            url:"${APP_PATH}/give_up_detailpre",
            type:"GET",
            //async:false,
            data:{pre_id:pre_id},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){

            }
        });
    }

    //刷新
    function refresh(){
        window.location.reload();
    }
    //清除
    function clear(){
        $("#form-article-add").find("input,textarea").each(function(){
            this.value ="";
        });
    }
    //加载药品下拉框
    $("#open_drug").change(function(){
        var drug_name=window.document.getElementById("open_drug").value;
        if(drug_name.length>0){
            $.ajax({
                url:"${APP_PATH}/load_allopen_drug",
                type:"GET",
                //async:false,
                data:"drug_name="+drug_name,
                dataType: "json",
                success:function(result){
                    $("#all_drug").empty();
                    $.each(result.extend.druglist,function(){
                        var optionEle=$("<option></option>").append(this.drugsName).attr("value",this.drugsId);
                        optionEle.appendTo("#all_drug");
                    });
                    return false;
                },
                error:function(result){

                }
            });
        }
    })
    //选择药品后
    $("#use_this_drug").click(function(){

        var drugID=window.document.getElementById("all_drug").value;
        if(drugID.length>0){
            load_drug(drugID);
        }else{
            window.alert("请输入药品信息");
        }
    });
    //利用药品id把药品名字、价格显示
    function load_drug(drugID){
        $.ajax({
            url:"${APP_PATH}/load_drug",
            type:"GET",
            async:false,//进行异步处理
            data:"drugID="+drugID,
            dataType: "json",
            success:function(result){
                if(result.extend.druglist!=""){
                    var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item2'/>");
                    var	itemname = $("<td></td>").append(result.extend.druglist[0].drugsName);
                    itemname=itemname.attr("drug_id",drugID);
                    var	itemprice =$("<td></td>").append( result.extend.druglist[0].drugsPrice);
                    var	itemformat =$("<td></td>").append( result.extend.druglist[0].drugsFormat);
                    var row4=$("<td></td>").append($("#yong_fa").val());
                    var row5=$("<td></td>").append($("#yong_liang").val());
                    var row6=$("<td></td>").append($("#pin_ci").val());
                    var row7=$("<td></td>").append($("#shu_liang").val());
                    if($("#yong_fa").val().length>0&$("#yong_liang").val().length>0&$("#pin_ci").val().length>0&$("#shu_liang").val().length>0){
                        $("<tr></tr>").append(checkBoxTd).append(itemname).append(itemformat).append(
                            itemprice).append(row4).append(row5).append(row6).append(row7).appendTo("#tableB tbody");
                        add_drug_todb();
                        $("#modal-demo").modal("hide");
                    }else{
                        window.alert("请完善信息");
                    }
                    return true;
                }
            },
            error:function(result){
                console.log("失败");
            }

        });
    }
    //暂存方法
    function save(){
        //var patient=parent.$("#baseInformation").html();//得到病人的信息
        var regnum=parent.$("#reg_id").val();
        var medrecord_code=parent.$("#med_code").val();
        save_med(regnum,medrecord_code,1);
        del_diag(regnum,medrecord_code);
        if(flag1){
            get_all_dise(1);
        }
    }
    //提交
    function thesubmit(){
        var regnum=parent.$("#reg_id").val();
        var medrecord_code=parent.$("#med_code").val();
        save_med(regnum,medrecord_code,2);
        del_diag(regnum,medrecord_code);
        if(flag1){
            get_all_dise(2);
        }
    }
    function save_med(regnum,medrecord_code,state){
        var zs=$("#zs").val();
        var xbs=$("#xbs").val();
        var xbzlqk=$("#xbzlqk").val();
        var jws=$("#jws").val();
        var gms=$("#gms").val();
        var tgjc=$("#tgjc").val();
        if(regnum.length>0){
            if(zs.length>0&xbs.length>0&xbzlqk.length>0&jws.length>0&gms.length>0&tgjc.length>0){
                $.ajax({
                    url:"${APP_PATH}/save_med",
                    type:"GET",
                    //async:false,//进行异步处理
                    data:{regnum:regnum,medrecord_code:medrecord_code,zs:zs,xbs:xbs,xbzlqk:xbzlqk,jws:jws,gms:gms,tgjc:tgjc,state:state},
                    dataType: "json",
                    success:function(result){
                        if(result.code==100){
                            flag1=true;
                            window.alert("success");
                        }
                        else{
                            flag1=false;
                            window.alert("已经开立的不能修改");
                        }
                    },error:function(result){

                    }
                });
            }else{
                window.alert("请完善病历信息");
            }
        }else{
            window.alert("请选择病人");
        }
    }
    function get_all_dise(state){
        var regnum=parent.$("#reg_id").val();
        var medrecord_code=parent.$("#med_code").val();
        $("#Wtable tr").each(function(){
            var dise_id=$(this).find("td").eq(3).attr("xi_dise");
            var fabing_date=$(this).find("td").eq(4).text();
            if(typeof(dise_id)!="undefined"){
                save_diag(regnum,medrecord_code,state,1,dise_id,fabing_date);
            }
        });
        $("#Ctable tr").each(function(){
            var dise_id=$(this).find("td").eq(3).attr("zhong_dise");
            var fabing_date=$(this).find("td").eq(4).text();
            if(typeof(dise_id)!="undefined"){
                save_diag(regnum,medrecord_code,state,2,dise_id,fabing_date);
            }
        });
    }
    //保存到疾病表
    function save_diag(regnum,medrecord_code,state,zhongxi,dise_id,fabing_date){
        var doctor_id=parent.parent.$("#login_doctor").html();
        doctor_id=parseInt(doctor_id);
        $.ajax({
            url:"${APP_PATH}/save_diag",
            type:"GET",
            async:false,//进行异步处理
            data:{regnum:regnum,medrecord_code:medrecord_code,state:state,doctor_id:doctor_id,dise_id:dise_id,fabing_date:fabing_date,zhongxi:zhongxi},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){
            }
        });

    }
    //删除之前暂存的疾病
    function del_diag(regnum,medrecord_code){
        $.ajax({
            url:"${APP_PATH}/del_diag",
            type:"GET",
            //async:false,//进行异步处理
            data:{regnum:regnum,medrecord_code:medrecord_code},
            dataType: "json",
            success:function(result){
                return false;
            },error:function(result){
            }
});
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
