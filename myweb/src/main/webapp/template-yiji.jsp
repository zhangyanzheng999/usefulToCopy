<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>医技模板管理</title>
</head>
<body>
<div>
    <div class="page-container form-label col-xs-4" style="display: inline-block">
        <div style="background:whitesmoke">
            <font color="#6495ed"> 医技模板:</font>
            <button class="btn" style="background: whitesmoke;margin-left: 250px;border: none;color: cornflowerblue"
                    type="button" id="addYijiTemplate"> 新建模板
            </button>
        </div>
        <form class="form form-horizontal">
            <div class="row cl">
                <label class="form-label col-xs-2 ">名称：</label>
                <div class="formControls col-xs-4">
                    <input type="text" class="input-text" value="" placeholder="输入模板名称" id="TemplateName">
                    <span class="c-red"></span>
                </div>
                <label class="form-label col-xs-2 ">范围：</label>
                <div class="formControls col-xs-4">
                    <select class="select" id="range">
                        <option value="0"> 全院</option>
                        <option value="1"> 科室</option>
                        <option value="2"> 个人</option>
                    </select>
                </div>
            </div>
            <div class="row  cl">
                <label class="form-label col-xs-2 ">记录类型：</label>
                <div class="formControls col-xs-4">
                    <select class="select" id="jilu-type">
                        <option value="0"> 所有</option>
                        <option value="1"> 检查</option>
                        <option value="2"> 检验</option>
                    </select>
                </div>
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
                        <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">
                            类型
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
        <form class="form form-horizontal" id="templateDetail">
            <div style="background:whitesmoke">
                <font color="#6495ed">操作:</font>
                <button style="color: cornflowerblue;margin-left: 520px;background: whitesmoke;border: none" class="btn"
                        type="button" id="modifyYijiTemplate">修改模板
                </button>
                <button style="color: cornflowerblue;margin-left: 100px;background: whitesmoke;border: none" class="btn"
                        type="button" id="deleteYijiTemplate">删除模板
                </button>
            </div>
            <div class="row cl col-xs-12">
                <div style="background: lightsteelblue">
                    <center style="color: cornflowerblue"> 模板明细:</center>
                </div>
            </div>
            <div class="row cl" style="text-align: center;margin-top: 60px;margin-left: 120px">
                <label class="form-label col-xs-2">模板名称</label>
                <div class="formControls col-xs-6">
                    <input type="text" class="input-text" id="formtemplateName">
                </div>
            </div>
            <div class="row cl" style="text-align: center;margin-top: 30px;margin-left: 120px">
                <label class="form-label col-xs-2">创建时间</label>
                <div class="formControls col-xs-3">
                    <input type="text" class="input-text" id="formtemplateCreatTime" readonly>
                </div>
            </div>
            <div class="row cl" style="text-align: center;margin-top: 30px;margin-left: 120px">
                <label class="form-label col-xs-2">模板范围</label>
                <div class="formControls col-xs-4">
                    <select class="select" id="templateRange">
                        <option value="0"> 全院</option>
                        <option value="1"> 科室</option>
                        <option value="2"> 个人</option>
                    </select>
                </div>
            </div>
            <div class="row cl" style="text-align: center;margin-top: 30px;margin-left: 120px">
                <label class="form-label col-xs-2">记录类型</label>
                <div class="formControls col-xs-4">
                    <select class="select" id="templateType">
                        <option value="1"> 检查</option>
                        <option value="2"> 检验</option>
                    </select>
                </div>
            </div>
        </form>

        <button class="btn" type="button" id="addJianyan"
                style="background: cornflowerblue;color: white;margin-top: 60px;height: 45px;width: 130px"> 增加检验项目
        </button>

        <div class="row cl" style="margin-top: 30px">

            <table id="jianYanTable" style="margin-left: 20px">
                <thead>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">项目编码</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">项目名称</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">项目规格</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">检查部位</th>
                <th style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;font-size: 15px">操作</th>
                </thead>
                <tbody>
                </tbody>
            </table>

        </div>
    </div>
</div>

<!-- 增加新的检验项目 -->
<div id="add_new_item" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">增加检验项目</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="formControls col-xs-3 col-sm-3">
                    <input type="text" class="input-text" value="" id="add_item_name" placeholder="请输入检验名字"
                    >
                </div>
                <div class="row cl">
                    <div class="formControls col-xs-4 col-sm-4">
    				<span class="select-box">
    				<select id="all_item" class="select"></select>
    				</span>
                    </div>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_new_item_btn" type="submit">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
        </div>
    </div>
</div>
<!-- 增加新的医技模板 -->
<div id="add_new_template" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">增加医技模板</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="row cl">
                    <label class="form-label col-xs-2">模板名称</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_template_name" placeholder="请输入模板名字">
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">模板范围</label>
                    <div class="formControls col-xs-4">
                        <select class="select" id="addtemplateRange">
                            <option value="0"> 全院</option>
                            <option value="1"> 科室</option>
                            <option value="2"> 个人</option>
                        </select>
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">记录类型</label>
                    <div class="formControls col-xs-4">
                        <select class="select" id="addtemplateType">
                            <option value="1"> 检查</option>
                            <option value="2"> 检验</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_new_template_btn" type="submit">确定</button>
                <button class="btn" data-dismiss="modal" aria-hidden="true" style="margin-left: 50px">关闭</button>
            </div>
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
    /**
     * 查询
     */
    $("#findTemplate").click(function () {
        var templateName = window.document.getElementById("TemplateName").value
        var templateRange = window.document.getElementById("range").value
        var templateType = window.document.getElementById("jilu-type").value
        //
        find_template_yiji(templateName, templateRange, templateType)
    })

    //封装成一个方法
    function find_template_yiji(templateName, templateRange, templateType) {
        $("#TemplateName").next("span").empty();
        $("#templateTable tbody").empty()

        $.ajax({
            url: "${APP_PATH}/find_template_yiji",
            type: "GET",
            //async:false,
            data: {templateName: templateName, templateRange: templateRange, templateType: templateType},
            dataType: "json",
            success: function (result) {
                $.each(result.extend.templateList, function () {
                    var templatename = $("<td></td>").append(this.templatename).attr("templateID", this.templateid)
                    var templatecreateTime = $("<td></td>").append(this.templatecreatetime)
                    var range;
                    if (this.templaterange == 0) range = "全院";
                    else if (this.templaterange == 1) range = "科室";
                    else range = "个人";
                    var templaterange = $("<td></td>").append(range).attr("RangeID", this.templaterange)
                    var templatetype = $("<td></td>").append(this.templatetype == 1 ? "检查" : "检验").attr("TypeID", this.templatetype)
                    $("<tr></tr>").append(templatename).append(templatecreateTime).append(templaterange).append(templatetype).appendTo("#templateTable tbody")
                })
            }
        })
    }

    $(document).on('click', '#templateTable tr', function () {
        $('#jianYanTable tbody').empty()
        var templateName = $(this).find("td").eq(0).html()
        var templateID = $(this).find("td").eq(0).attr("templateID")
        var templateCreateTime = $(this).find("td").eq(1).html()
        var templateRange = $(this).find("td").eq(2).attr("RangeID")
        var templateType = $(this).find("td").eq(3).attr("TypeID")

        $('#formtemplateName').val(templateName)
        $('#formtemplateName').attr("templateID", templateID)
        $('#formtemplateCreatTime').val(templateCreateTime)
        $('#templateRange').val(templateRange)
        $('#templateType').val(templateType)
        //加载医技模板的详细模块
        load_detail_template_yiji(templateID)
    })

    //加载医技模板的详细模块
    function load_detail_template_yiji(templateID) {
        if (templateID.toString().length > 0 && templateID.toString() != null) {
            $("#jianYanTable tbody").empty()
            $.ajax({
                url: "${APP_PATH}/load_detail_template_yiji",
                type: "GET",
                async: false,
                data: {templateID: templateID},
                dataType: "json",
                success: function (result) {
                    $.each(result.extend.detailList, function () {
                        load_detail_item(this.itemCode)
                    })
                }
            })
        }
    }

    //加载医技项目的详细信息
    function load_detail_item(itemCode) {
        $.ajax({
            url: "${APP_PATH}/load_detail_item",
            type: "GET",
            async: false,
            data: {itemCode: itemCode},
            dataType: "json",
            success: function (result) {
                $.each(result.extend.detailList, function () {
                    var itemcode = $("<td></td>").append(this.itemCode).attr("itemId", this.itemId)
                    var itemname = $("<td></td>").append(this.itemName)
                    var itemformat = $("<td></td>").append(this.itemFormat)
                    var itemBuwei = $("<td></td>").append(this.itemName)
                    var delBtn = $("<button></button>").addClass(
                        "btn btn-danger btn-sm delete_btn").append(
                        $("<span></span>")
                            .addClass("glyphicon glyphicon-trash")).append(
                        "删除");
                    //为删除按钮添加属性表示id
                    delBtn.attr({"type": "button"});//防止删除自动刷新界面
                    delBtn.attr("itemCode", this.itemCode);
                    $("<tr></tr>").append(itemcode).append(itemname).append(itemformat).append(itemBuwei).append(delBtn).appendTo("#jianYanTable tbody");
                })
            }
        })
    }

    //删除操作
    $(document).on('click', ".delete_btn", function () {
        var templateID = $('#formtemplateName').attr("templateID")
        //项目编号
        var itemCode = $(this).attr("itemCode")
        console.log(itemCode)
        $.ajax({
            url: "${APP_PATH}/delete_template_item",
            type: "POST",
            data: {itemCode: itemCode, templateID: templateID},
            dataType: "json",
            success: function () {
                //重新加载
                load_detail_template_yiji(templateID)
            }
        })
    })

    //增加检验项目
    $("#addJianyan").click(function () {
        var templateID = $('#formtemplateName').attr("templateID")
        //清空模态框
        $("#add_item_name").val("")
        $("#all_item").empty()
        if (templateID > 0) {
            $("#add_new_item").modal("show")
        } else {
            alert("请选择模板！！！")
        }
    })
    $(document).on("change", "#add_item_name", function () {
        var itemName = window.document.getElementById("add_item_name").value;
        $.ajax({
            url: "${APP_PATH}/load_like_item",
            type: "GET",
            data: {itemName: itemName},
            dataType: "json",
            success: function (result) {
                $.each(result.extend.list, function () {
                    var optionEle = $("<option></option>").append(this.itemName).attr("itemId", this.itemId).attr("itemCode", this.itemCode).attr("itemFormat", this.itemFormat);
                    optionEle.appendTo("#all_item");
                })
            }
        })
    })

    //增加新的检验项目
    $("#add_new_item_btn").click(function () {
        var templateID = $('#formtemplateName').attr("templateID")
        var itemCode = $("#all_item option:selected").attr("itemCode")
        if (templateID > 0 && typeof (itemCode) != "undefined" && itemCode.length > 0) {
            $.ajax({
                url: "${APP_PATH}/add_new_item",
                type: "POST",
                data: {templateID: templateID, itemCode: itemCode},
                dataType: "json",
                success: function (result) {
                    //重新加载
                    $("#add_new_item").modal("hide")
                    load_detail_template_yiji(templateID)
                }
            })
        } else {
            alert("请完善信息！！！！")
        }
    })

    //新建模板
    $("#addYijiTemplate").click(function () {
        $("#add_new_template").modal("show")
        //数据清空 重置
        $("#add_template_name").val("")
        $("#addtemplateRange").val("0")
        $("#addtemplateType").val("1")
    })

    $("#add_new_template_btn").click(function () {
        var templateName = $("#add_template_name").val()
        if (templateName.toString().trim().length == 0) {
            alert("请输入模板名称！！！！！")
        } else {
            var templateRange = $("#addtemplateRange option:selected").attr("value")
            var templateType = $("#addtemplateType option:selected").attr("value")
            $.ajax({
                url: "${APP_PATH}/add_new_template",
                type: "POST",
                data: {templateName: templateName, templateRange: templateRange, templateType: templateType},
                dataType: "json",
                success: function (result) {
                    //模态框隐藏
                    $("#add_new_template").modal("hide")
                    //空白就是全部查出来
                    find_template_yiji("", 0, 0)
                    window.alert("新建成功!")
                }
            })
        }
    })
    //删除模板
    $("#deleteYijiTemplate").click(function () {
        var templateID = $('#formtemplateName').attr("templateID")
        if (typeof (templateID) != "undefined" && templateID > 0) {
            delete_template(templateID)
            delete_detail_item(templateID)
        } else {
            alert("请选择模板！！！")
        }

    })

    //删除模板
    function delete_template(templateID) {
        $.ajax({
            url: "${APP_PATH}/delete_template",
            type: "POST",
            data: {templateID: templateID},
            dataType: "json",
            success: function (result) {
                find_template_yiji("", 0, 0)
                //清空已经存在的数据
                $('#formtemplateName').val("")
                $('#formtemplateCreatTime').val("")
                $('#templateRange').val(0)
                $('#templateType').val(1)
                alert("删除成功！！！！")
            }
        })
    }

    //删除详细模板
    function delete_detail_item(templateID) {
        $.ajax({
            url: "${APP_PATH}/delete_detail_template",
            type: "POST",
            data: {templateID: templateID},
            dataType: "json",
            success: function (result) {
                $("#jianYanTable tbody").empty()
            }
        })
    }

    //修改模板
    $("#modifyYijiTemplate").click(function () {
        var templateID = $('#formtemplateName').attr("templateID")
        var templateName = $("#formtemplateName").val()
        var templateRange = $("#templateRange option:selected").val()
        var templateType = $("#templateType option:selected").val()
        if (typeof templateName != "undefined" && templateName.length > 0) {
            $.ajax({
                url: "${APP_PATH}/modify_template",
                type: "POST",
                data: {
                    templateID: templateID,
                    templateName: templateName,
                    templateRange: templateRange,
                    templateType: templateType
                },
                dataType: "json",
                success: function (result) {
                    alert("修改成功!!!!")
                    find_template_yiji("", 0, 0)
                }
            })

        } else {
            alert("请完善信息！！！")
        }

    })
</script>
</body>
</html>