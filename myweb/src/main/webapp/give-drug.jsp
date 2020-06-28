<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%pageContext.setAttribute("APP_PATH", request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="Bookmark" href="/favicon.ico">
    <link rel="Shortcut Icon" href="/favicon.ico"/>
    <!--[if lt IE 9]>
    <script type="text/javascript" src="lib/html5shiv.js"></script>
    <script type="text/javascript" src="lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin"/>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css"/>
    <title>发药</title>
</head>
<body>
<article class="page-container">
    <form action="" method="post" class="form form-horizontal" id="form-give-drugs">
        <div class="row cl">
            <label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <input type="text" class="input-text" value="" placeholder="" id="medrecord_code">
                <span class="c-red"></span>
            </div>

            <label class="form-label col-xs-1 col-sm-1">日期：</label>
            <div class="formControls col-xs-2 col-sm-2">
                <input type="text" class="input-text Wdate" value="" onfocus="WdatePicker()" placeholder=""
                       id="open_drug_date">
                <span class="help-block"></span>
            </div>

            <div class="formControls col-xs-2 col-sm-2">
                <input class="btn btn-primary radius" type="button" id="find" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;">
            </div>
        </div>
        <div class="mt-20">
            <p>药品信息</p>
            <table class="table table-border table-bordered table-bg table-hover table-sort table-responsive"
                   style="width:1100px;" id="drug-table">
                <thead>
                <tr>
                    <th style="width:50px;"><input type="checkbox" id="check_all" name="check_all"></th>
                    <th style="width:100px;">药品名称</th>
                    <th style="width:50px;">单价</th>
                    <th style="width:50px;">数量</th>
                    <th style="width:50px;">药品状态</th>
                    <th style="width:50px;">开立医生</th>
                    <th style="width:100px;">处方名称</th>
                    <th style="width:100px;">开立时间</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="row cl">
                <div class="formControls col-xs-2 col-sm-2">
                    <input class="btn btn-primary radius" type="button" id="give_drug" value="发药">
                </div>
            </div>
        </div>
    </form>
</article>


<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script>
<!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH}/his/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript">
    var itemname, itemprice, itemnum;
    var regnum
    var mednum, state;
    $("#find").click(function () {
        load_list();
    });

    function load_list() {
        var medrecord_code = window.document.getElementById("medrecord_code").value;
        var open_date = window.document.getElementById("open_drug_date").value;
        $("#medrecord_code").next("span").empty();
        $("#drug-table tbody").empty();
        if (medrecord_code.length > 0) {
            $.ajax({
                url: "${APP_PATH}/load_allpre",
                type: "GET",
                async: false,//进行异步处理
                data: {medrecord_code: medrecord_code, open_date: open_date},
                dataType: "json",
                success: function (result) {
                    if (result.extend.prelist != "") {
                        //	console.log(result.extend.prelist);
                        $.each(result.extend.prelist, function (index, item) {
                            var preID = item.preId;
                            regnum = item.registerId;
                            var doctorId = item.doctorId;
                            var prename = item.preName;
                            var predate = item.preOpenTime;
                            load_detailpre(preID, prename, doctorId, predate);


                        });
                    } else {
                        $("#medrecord_code").next("span").text("病历号不存在或日期不正确！请重新输入");

                    }
                },
                error: function (result) {

                    return false;
                }


            });
        } else {
            window.alert("请输入病历号！");
        }
    }

    //利用药品id把药品名字、价格显示
    function load_drug(drugID) {
        $.ajax({
            url: "${APP_PATH}/load_drug",
            type: "GET",
            async: false,//进行异步处理
            data: "drugID=" + drugID,
            dataType: "json",
            success: function (result) {
                if (result.extend.druglist != "") {

                    itemname = $("<td></td>").append(result.extend.druglist[0].drugsName);
                    itemname = itemname.attr("drug_id", drugID);
                    itemprice = $("<td></td>").append(result.extend.druglist[0].drugsPrice);


                    return true;
                }
            },
            error: function (result) {
                console.log("失败");
            }


        });
    }

    //加载
    function load_detailpre(preID, prename, doctorId, predate) {
        $.ajax({
            url: "${APP_PATH}/load_detailpre",
            type: "GET",
            //	async:false,
            data: "preID=" + preID,
            dataType: "json",
            success: function (result) {
                if (result.extend.detailprelist != "") {
                    $.each(result.extend.detailprelist, function (index, item) {
                        var opentimenow = $("<td></td>").append(predate);//根据全局变量给表格赋值
                        var drugID = item.drugsId;
                        var checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item'/>").attr("detailid", item.detialpreId);
                        //doctorID = $("<td></td>").append(doctorId);
                        var preName = $("<td></td>").append(prename);
                        load_drug(drugID);
                        turn_to_name(doctorId);
                        itemnum = $("<td></td>").append(item.drugsNum);
                        state = item.detailpreState;
                        if (state == 0) {
                            state = $("<td></td>").append("已开立");
                        } else if (state == 1) {
                            state = $("<td></td>").append("已收费");
                        } else if (state == 2) {
                            state = $("<td></td>").append("已退费");
                        } else {
                            state = $("<td></td>").append("已发药");
                        }
                        state = state.attr("state_id", item.detailpreState);
                        $("<tr></tr>").append(checkBoxTd).append(itemname).append(itemprice).append(
                            itemnum).append(state).append(doctorID)
                            .append(preName).append(opentimenow).appendTo("#drug-table tbody");
                    });
                }
            },
            error: function (result) {

                console.log("失败");
            }


        });
    }

    //完成发药功能
    $("#give_drug").click(function () {
        var ctn = false;
        $.each($(".check_item:checked"), function () {
            if ($(this).parents("tr").find("td:eq(1)").text().length > 0) {
                ctn = true;
                return;
            }
        });
        if (!ctn) {
            window.alert("请选择要发的药");
            return;
        }
        var flag = true;
        $.each($(".check_item:checked"), function () {
            var itemstate = $(this).parents("tr").find("td:eq(4)").attr("state_id");
            if (parseInt(itemstate) != 1) {
                window.alert("有项目未交费或已发药！");
                flag = false;
                return false;
            }
        });
        if (flag) {
            $.each($(".check_item:checked"), function () {
                var detailid = $(this).parents("tr").find("td:eq(0)").attr("detailid");
                $.ajax({
                    url: "${APP_PATH}/done_open_drug",
                    type: "GET",
                    data: {detailid: detailid},
                    dataType: "json",
                    success: function (result) {

                        return false;
                    }
                });

            });
            load_list();
            window.alert("发药成功！");
        }
    });

    //根据医生id获取医生姓名
    function turn_to_name(doctorId) {
        $.ajax({
            url: "${APP_PATH}/load_docname",
            type: "GET",
            async: false,//进行异步处理
            data: "doctorId=" + doctorId,
            dataType: "json",
            success: function (result) {
                if (result.extend.doclist != "") {
                    doctorID = $("<td></td>").append(result.extend.doclist[0].userRealname);
                    doctorID = doctorID.attr("doc_id", doctorId);
                    return false;
                }
            },
            error: function (result) {
                console.log("失败");
            }


        });
    }

    //完成全选/全不选功能
    $("#check_all").click(function () {
        var is_All_Check = $(this).prop("checked");
        $(".check_item").prop("checked", is_All_Check);
    });
</script>
</body>
</html>