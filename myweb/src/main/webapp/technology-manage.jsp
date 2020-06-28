<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>
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
<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<title>医技管理</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="technology_manage_form">
	<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">收费项目查询</label>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">项目名称：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="key" name="key" onkeydown="onSearch(this)">
				<span class="c-red"></span>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="button" id="med_find" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;">
			</div>
		</div>
			<div class="row cl">
				<div style="position:absolute; width:1100px; height:200px;z-index:1;left:130px;top:170px;">
					<table class="table table-hover table-bordered" id="mytable">
                        <thead>
                            <tr>
                                <th>选中</th>
                                <th>编号</th>
                                <th>收费项目名称</th>
                                <th>创建时间</th>
                                <th>所属科室</th>
                                <th>费用金额</th>
                                <th>操作</th>
                            </tr>
                            <tr>
                                <td><input type="checkbox" onclick="checkAll(this)"/></td>
                                <td colspan="6"><a href="javascript:;" class="btn btn-danger" role="button" onclick="delAll(this)">全部删除</a></td>
                            </tr>
                        </thead>
                        <tbody id="listTable">
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10086</td>
                                <td>CT</td>
                                <td>2016-09-09</td>
                                <td>放射科</td>
                                <td>90</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10087</td>
                                <td>B超</td>
                                <td>2019-08-04</td>
                                <td>放射科</td>
                                <td>40</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10088</td>
                                <td>心电图</td>
                                <td>2020-10-11</td>
                                <td>检验科</td>
                                <td>60</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10089</td>
                                <td>胃镜</td>
                                <td>2020-01-11</td>
                                <td>检验科</td>
                                <td>60</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10090</td>
                                <td>肠镜</td>
                                <td>2019-12-11</td>
                                <td>检验科</td>
                                <td>60</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10091</td>
                                <td>彩超</td>
                                <td>2020-11-11</td>
                                <td>放射科</td>
                                <td>60</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10092</td>
                                <td>验血</td>
                                <td>2017-12-11</td>
                                <td>检验科</td>
                                <td>30</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" name="item" /></td>
                                <td>10093</td>
                                <td>X线</td>
                                <td>2020-10-11</td>
                                <td>放射科</td>
                                <td>100</td>
                                <td>
                                    <input type="button" name="" value="删除" class="btn btn-danger" onclick="del(this)" />
                                    <input type="button" name="" value="修改" class="btn btn-danger" onclick="xiugai(this)" />
                                </td>
                            </tr>
                            <label>医技收费项目列表</label>
                        </tbody>
                    </table>
         				<!-- information of devide page -->
         			<div class="row">
         				<!-- 分页文字信息 -->
         				<div class="col-md-6" style="top:240px;" id="page-info-area"></div>
         				<!-- 分页条信息 -->
         				<div class="col-md-6" style="top:240px;" id="page_nav_area"></div>
         			</div>
                    <input class="btn btn-primary radius" type="submit" id="med_find" value="&nbsp;&nbsp;导入&nbsp;&nbsp;">
                    <input class="btn btn-primary radius" type="submit" id="med_find" value="&nbsp;&nbsp;导出&nbsp;&nbsp;">
				</div>
			</div>
</form>
<form id="info" method="post">
    <div style="position:absolute; width:1100px; height:100px;z-index:1;left:130px;top:140px;">
    编号：<input type="text" id="id">
    项目名称：<input type="text" id="name">
    创立时间：<input type="text" id="time">
    所属科室：<input type="text" id="dep">
    费用金额：<input type="text" id="money">
    <input class="btn btn-primary radius" type="button" id="btn1" value="添加项目">
    </div>
</form>
</article>

<!--_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
function onSearch(obj){//js函数开始
  setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
    var storeId = document.getElementById('mytable');//获取table的id标识
    var rowsLength = storeId.rows.length;//表格总共有多少行
    var key = obj.value;//获取输入框的值
    var searchCol = 2;//要搜索的哪一列，这里是第一列，从0开始数起
    for(var i=2;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
      var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
      if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
        storeId.rows[i].style.display='';//显示行操作，
      }else{
        storeId.rows[i].style.display='none';//隐藏行操作
      }
    }
  },200);//200为延时时间
}
    function del(obj){
            var oParentnode = obj.parentNode.parentNode;
            var olistTable = document.getElementById('listTable');
            olistTable.removeChild(oParentnode);
    }
    //全选
        function checkAll(c){
            var status = c.checked;
            var oItems = document.getElementsByName('item');
            for(var i=0;i<oItems.length;i++){
                oItems[i].checked=status;
            }
        }
        //delAll功能
        function delAll(){
            var olistTable = document.getElementById('listTable');
            var items = document.getElementsByName("item");
            for(var j=0;j<items.length;j++){
                if(items[j].checked)//如果item被选中
                {
                    var oParentnode = items[j].parentNode.parentNode;
                    olistTable.removeChild(oParentnode);
                    j--;
                }
            }
        }
 $(document).ready(function (){

    $("#btn1").click(function (){
        //创建tr节点
    var $tr=$("<tr></tr>");
       //遍历获取输入的内容
    var $td=$("<td><input type='checkbox' name='item' /></td>");
    $td.appendTo($tr);
     $("#info input:text").each(function (index,domEle){
      //添加td节点
       var $td=$("<td></td>");
        //将内容循环添加到创建好的TD中
    $td.append($(domEle).val());
    //将td添加到创建好的TR 中
    $td.appendTo($tr);
      });
      //创建TD--删除
    var $td=$("<td><input type='button' name='' value='删除' class='btn btn-danger' onclick='del(this)' /> <input type='button' name='' value='修改' class='btn btn-danger' onclick='xiugai(this)' /></td>");
      //将内容循环添加到创建好的TD中
        $td.appendTo($tr);
        $tr.appendTo("#mytable");
     });
    });
function xiugai(a){
             var trobj = a.parentNode.parentNode; //获得按钮所在行的行对象
             var tdobj = trobj.getElementsByTagName("td");
             for(var i =1;i<tdobj.length-1;i++){
                 //循环把每一个单元格变成input类型
                 tdobj[i].innerHTML ="<input onblur='submit(this)' type=\"input\" value='" +tdobj[i].innerText+ " '/>";
             }
         }
         //异步提交
         function submit(inputobj){
             $.ajax(
                     {
                         url: "technology-manage",
                         type: "post",
                         datatype:"json",
                         success: function (result) { //返回的结果自动放在resut里面了
                                if(result != null){
                                    inputobj.parentNode.innerText=inputobj.value;//去掉输入框并赋值给单元格
                                }
                         }
                     });
         }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>