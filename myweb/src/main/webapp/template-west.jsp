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
    <title>西医处方模板</title>
</head>
<body>
<div>
    <div class="page-container form-label col-xs-4" style="display: inline-block">
        <div style="background:whitesmoke">
            <font color="#6495ed"> 西药处方模板:</font>
            <button class="btn" style="background: whitesmoke;margin-left: 230px;border: none;color: cornflowerblue"
                    type="button" id="addWestTemplate"> 新建模板
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
                        type="button" id="modifyWestTemplate">修改模板
                </button>
                <button style="color: cornflowerblue;margin-left: 50px;background: whitesmoke;border: none" class="btn"
                        type="button" id="deleteWestTemplate">删除模板
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
                    <input type="checkbox" id="west-select">
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


<!-- 增加新的药品 -->
<div id="add_new_med" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">增加药品</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">药品名称</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_med_name" placeholder="请输入药品名称">
                    </div>

                    <div class="formControls col-xs-4 col-sm-4">
    				<span class="select-box">
    				    <select id="all_drug" class="select"></select>
    				</span>
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">用法</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_med_howUse" placeholder="请输入用法">
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">用量</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_med_howMuchUse" placeholder="请输入用量">
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">频次</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_med_howOfenUse" placeholder="请输入频次">
                    </div>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_new_med_btn" type="submit" style="margin-left: 100px">确定
                </button>
                <button class="btn" data-dismiss="modal" aria-hidden="true" style="margin-left: 50px">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- 增加新的模板 -->
<div id="add_new_west_mould" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog ">
        <div class="modal-content radius">
            <div class="modal-header">
                <h3 class="modal-title">新建模板</h3>
                <a class="close" data-dismiss="modal" aria-hidden="true" href="javascript:void();">×</a>
            </div>
            <div class="modal-body">
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">模板名称</label>
                    <div class="formControls col-xs-3 col-sm-3">
                        <input type="text" class="input-text" value="" id="add_mould_name" placeholder="请输入模板名称">
                    </div>
                </div>
                <div class="row cl" style="margin-top: 20px">
                    <label class="form-label col-xs-2">使用范围</label>
                    <div class="formControls col-xs-4">
                        <select class="select" id="addMouldRange">
                            <option value="1"> 全院</option>
                            <option value="2"> 科室</option>
                            <option value="3"> 个人</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="modal-body">
                <button class="btn btn-primary" id="add_new_mould_btn" type="submit" style="margin-left: 100px">确定
                </button>
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

    $("#findTemplate").click(function () {
        var templateName = $("#TemplateName").val()
        var templateRange = $("#range").val()
        find_west_mould(templateName, templateRange)

    })

    function find_west_mould(templateName, templateRange) {
        $("#templateTable tbody").empty()
        $.ajax({
            url: "${APP_PATH}/find_west_mould",
            type: "GET",
            data: {templateName: templateName, templateRange: templateRange},
            dataType: "json",
            success: function (result) {
                $.each(result.extend.list, function () {
                    var mouldName = $("<td></td>").append(this.readyMouldName).attr("readyMouldId", this.readyMouldId)
                    var createTime = $("<td></td>").append(this.creatTime)

                    var range;
                    if (this.useRange == 1) range = "全院"
                    else if (this.useRange == 2) range = "科室"
                    else range = "个人"

                    var useRange = $("<td></td>").append(range).attr("useRange", this.useRange)
                    $("<tr></tr>").append(mouldName).append(createTime).append(useRange).appendTo("#templateTable tbody")
                })
            }
        })
    }

    //单击表格加载信息
    $(document).on('click', "#templateTable tr", function () {
        var templateName = $(this).find("td").eq(0).html()
        var templateID = $(this).find("td").eq(0).attr("readyMouldId")
        var range = $(this).find("td").eq(2).attr("useRange")

        $("#formtemplateName").val(templateName)
        $("#formtemplateName").attr("templateID", templateID)
        $("#templateRange").val(range)

        load_detail_mould(templateID)
    })


    //加载模板药品详细信息
    function load_detail_mould(templateID) {
        $.ajax({
            url: "${APP_PATH}/load_detailmould",
            type: "GET",
            async: false,
            data: {mould_id: templateID},
            dataType: "json",
            success: function (result) {
                $("#jianYanTable tbody").empty()
                $.each(result.extend.dmouldlist, function () {
                    var checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item'/>");
                    var drugName
                    var drugFormat
                    var drugUnit
                    var howUse = $("<td></td>").append(this.howUse)
                    var howMuchUse = $("<td></td>").append(this.howMuchUse)
                    var howOfenUse = $("<td></td>").append(this.howOfenUse)

                    //为了传递多个结果就不拿出去了
                    $.ajax({
                        url: "${APP_PATH}/load_drug",
                        type: "GET",
                        async: false,//进行异步处理
                        data: {drugID: this.drugId},
                        dataType: "json",
                        success: function (result) {
                            if (result.extend.druglist != "") {
                                drugName = $("<td></td>").append(result.extend.druglist[0].drugsName).attr("drug_id", result.extend.druglist[0].drugsId)
                                drugFormat = $("<td></td>").append(result.extend.druglist[0].drugsFormat)
                                drugUnit = $("<td></td>").append(result.extend.druglist[0].drugsUnit)
                            }
                        }
                    })
                    $("<tr></tr>").append(checkBoxTd).append(drugName).append(drugFormat).append(drugUnit)
                        .append(howUse).append(howMuchUse).append(howOfenUse).appendTo("#jianYanTable tbody")

                })
            }
        })
    }

    //增加药品
    $("#addMed").click(function () {
        var templateID = $("#formtemplateName").attr("templateID")
        if (typeof templateID != "undefined" && templateID >= 0) {
            //先清空
            $("#add_med_name").val("")
            $("#add_med_howUse").val("")
            $("#add_med_howMuchUse").val("")
            $("#add_med_howOfenUse").val("")
            $("#all_drug").empty()
            //模态框
            $("#add_new_med").modal("show")
        } else {
            alert("请选择模板！！！！")
        }
    })
    //add_med_name 模糊查询
    $("#add_med_name").change(function () {
        $.ajax({
            url: "${APP_PATH}/load_allopen_drug",
            type: "GET",
            data: {drug_name: $(this).val()},
            dataType: "json",
            success: function (result) {
                $("#all_drug").empty()
                $.each(result.extend.druglist, function () {
                    var optionEle = $("<option></option>").append(this.drugsName).attr("drugsId", this.drugsId);
                    optionEle.appendTo("#all_drug");
                })
            }
        })
    })
    //add_new_med_btn按钮功能实现 添加药品
    $("#add_new_med_btn").click(function () {
        var mouldID = $("#formtemplateName").attr("templateID")
        var drugID = $("#all_drug option:selected").attr("drugsId")
        var howUse = $("#add_med_howUse").val()
        var howMuchUse = $("#add_med_howMuchUse").val()
        var howOfenUse = $("#add_med_howOfenUse").val()
        if (typeof drugID != "undefined" && howUse != "" && howMuchUse != "" && howOfenUse != "") {
            $.ajax({
                url: "${APP_PATH}/add_new_med_into_mould",
                type: "POST",
                data: {
                    mouldID: mouldID,
                    drugID: drugID,
                    howUse: howUse,
                    howMuchUse: howMuchUse,
                    howOfenUse: howOfenUse
                },
                dataType: "json",
                success: function (result) {
                    $("#add_new_med").modal("hide")
                    //重新加载药品
                    load_detail_mould(mouldID)
                    alert("添加成功！")
                }
            })
        } else {
            alert("请完善信息！！！")
        }
    })
    //删除
    $("#deleteMed").click(function () {
        var count = 0
        $.each($(".check_item:checked"), function () {
            count += 1;
        })
        if (count > 0) {
            //有选择药品
            var mouldID = $("#formtemplateName").attr("templateID")
            $.each($(".check_item:checked"), function () {
                var drugID = $(this).parents("tr").find("td:eq(1)").attr("drug_id")
                //进行删除
                delete_drug_inMould(mouldID, drugID)
            })
            //重新显示
            alert("删除成功！！！")
            load_detail_mould(mouldID)

        } else {
            alert("请选择要删除的药品！！！")
        }
    })

    //从数据库删除
    function delete_drug_inMould(mouldID, drugID) {
        $.ajax({
            url: "${APP_PATH}/delete_drug_inMould",
            type: "POST",
            async: false,
            data: {mouldID: mouldID, drugID: drugID},
            dataType: "json",
            success: function (result) {

            }
        })
    }

    //新建模板
    $("#addWestTemplate").click(function () {
        //清空
        $("#add_mould_name").val("")
        $("#addMouldRange").val(1)
        $("#add_new_west_mould").modal("show")
    })

    $("#add_new_mould_btn").click(function () {
        var mouldName = $("#add_mould_name").val()
        var mouldRange = $("#addMouldRange option:selected").val()
        var doctorID = parent.$("#login_doctor").html().toString().trim();
        if (typeof doctorID != "undefined" && doctorID.length > 0) {
            if (mouldName.toString().trim().length > 0) {
                $.ajax({
                    url: "${APP_PATH}/add_new_west_mould",
                    type: "POST",
                    data: {doctorID: doctorID, mouldName: mouldName, mouldRange: mouldRange},
                    dataType: "json",
                    success: function (result) {
                        $("#add_new_west_mould").modal("hide")
                        //""空值查询全部
                        find_west_mould("", 1)
                    }
                })
            } else {
                alert("请输入模板名称！！！！！")
            }
        } else {
            alert("请先登录！！！")
        }

    })


    //删除模板
    $("#deleteWestTemplate").click(function () {
        var mouldID = $("#formtemplateName").attr("templateID")
        if (typeof mouldID != "undefined") {
            deleteWestMould(mouldID)
            deleteDetailWestMould(mouldID)
        } else {
            alert("请选择模板！！！")
        }
    })

    //删除模板
    function deleteWestMould(mouldID) {
        $.ajax({
            url: "${APP_PATH}/delete_west_mould",
            type: "POST",
            data: {mouldID: mouldID},
            dataType: "json",
            success: function (result) {
                //""空值查询全部
                find_west_mould("", 1)
                //清空值
                $("#formtemplateName").val("")
                $("#templateRange").val(1)
                alert("删除成功！！！")
            }
        })
    }

    //删除模板中的详细信息
    function deleteDetailWestMould(mouldID) {
        $.ajax({
            url: "${APP_PATH}/delete_detail_west_mould",
            type: "POST",
            data: {mouldID: mouldID},
            dataType: "json",
            success: function (result) {
                //清空表格
                $("#jianYanTable tbody").empty()
            }
        })
    }


    //修改模板 ：改名字 改范围
    $("#modifyWestTemplate").click(function () {
        var mouldID = $("#formtemplateName").attr("templateID")
        if (typeof mouldID != "undefined") {
            var mouldName = $("#formtemplateName").val()
            if (mouldName.toString().trim().length > 0) {
                var mouldRange = $("#templateRange option:selected").val()
                modifyWestMould(mouldID, mouldName, mouldRange)
            } else {
                alert("请输入模板名字！！！！")
            }
        } else {
            alert("请选择模板！！！")
        }
    })

    function modifyWestMould(mouldID, mouldName, mouldRange) {
        $.ajax({
            url: "${APP_PATH}/modifyWestMould",
            type: "POST",
            data: {mouldID: mouldID, mouldName: mouldName, mouldRange: mouldRange},
            dataType: "json",
            success: function (result) {
                //""空值查询全部
                find_west_mould("", 1)
                alert("修改成功！！！")
            }
        })
    }
</script>
</body>
</html>