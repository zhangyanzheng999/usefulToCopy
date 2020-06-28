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
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<link rel="stylesheet" href="${APP_PATH}/his/lib/zTree/v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>处方模板</title>
<style type="text/css">
.tabBar {border-bottom: 1px solid Gainsboro}
.tabBar span {border:1px solid Gainsboro;background-color: white;cursor: pointer;display: inline-block;float: left;
font-weight: normal;height: 30px;line-height: 30px;padding: 0 15px}
.tabBar span.current{background-color: white;color: cornflowerblue}
.tabCon {display: none}
</style>
</head>
<body>
<div id="tab-system" class="HuiTab">
	<div class="tabBar cl">
		<span>处方模版</span>
	    <span>常用药品*</span>
		<span>建议方案*</span>
		<span>历史处方*</span>
	</div>
	<div class="tabCon">
	<p></p>	
         <table >
            <tr>
            <td width="250" class="va-t" >
                <div class="page-container" style="border:1px Gainsboro solid;">
                <div  class="HuiTab">
                <p>名称：
                    <input type="text" name="name" id="mould_name" placeholder=" " style="width:110px" class="input-text">
	                <button  class="btn btn-primary radius" id="find_mould" type="button">查询</button>
	            </p>   
                <table id="tableC"  >
		        <thead>
				    <tr >
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">模板名称</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;">范围</th>
				    </tr>
			    </thead>
		        <tbody>        
		        </tbody>
	            </table>
	            </div>
	            </div>
	        </td>            
	        <td class="va-t" >
	            <div class="page-container" style="border:1px Gainsboro solid;">
                <div  class="HuiTab">
                <p>模板明细:<span id="use_mould_name"></span><a href="javascript:use_this_mould();"><font color="cornflowerblue" style="float:right;">使用该模板&nbsp;</font></a><p>   
                <table id="tableD" >
		        <thead>
	    	        <tr >
				        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">药品名称</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">规格</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">单价</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">用法</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">用量</th>
					    <th height="35px" style="border-width:1px;border-color:Gainsboro;border-bottom-style:solid;border-top-style:solid;">频次</th>
				        <th height="35px" style="border-width:1px;border-color:Gainsboro;border-top-style:solid;">&nbsp; </th>
				    </tr>
			    </thead>
		        <tbody>	        
		        </tbody>
	            </table>
	            </div>
	            </div> 
            </td>
            </tr>
            </table>  	
	</div>		
	<div class="tabCon"></div>
	<div class="tabCon"></div>
	<div class="tabCon"></div>
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
var itemname,itemprice,itemformat;
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
$("#find_mould").click(function(){
	load_mould();
});

function load_mould(){
	$("#tableC tbody").empty();
	var mouldname=window.document.getElementById("mould_name").value
	$.ajax({
		url:"${APP_PATH}/load_mould",
		type:"GET",
		//async:false,
		data:"mouldname="+mouldname,
		dataType: "json",
		success:function(result){
			if(result.extend.mouldlist!=""){				
				$.each(result.extend.mouldlist,function(index,item){	
					var mould_name=$("<td></td>").append(item.readyMouldName);
						mould_name=mould_name.attr("mould_id",item.readyMouldId);
					var state=item.useRange;
					if(parseInt(state)==1){
						state=$("<td></td>").append("个人");
					}else if(parseInt(state)==2){
						state=$("<td></td>").append("科室");						
					}else{
						state=$("<td></td>").append("全院");	
					}
					state=state.attr("Range_id",item.useRange);
					$("<tr></tr>").append(mould_name).append(state).appendTo("#tableC tbody");
				}); 
				
				
			}
		},
		error:function(result){
			console.log(result);
		}
	})	
}
//使用这个模板
function use_this_mould(){
	load_to_A();
	setTimeout(function(){
		load_to_B();
		},300);

}

function load_to_A(){
	var mouldname=$("#use_mould_name").html();
	var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item3'/>");
	var mould_name=$("<td></td>").append(mouldname);
	var state=$("<td></td>").append("暂存").attr("pre_state",1);
	$("<tr></tr>").append(checkBoxTd).append(mould_name).append(state).appendTo(parent.$("#tableA tbody"));
	parent.store_pre();

}
function load_to_B(){
	var tableB=parent.$("#tableB");
	parent.$("#tableB tbody").empty();	
	$("#tableD tr").each(function(){
		var checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item2'/>")
		var row1=$("<td></td>").append($(this).find("td:eq(0)").text()).attr("drug_id",$(this).find("td:eq(0)").attr("drug_id"));
		var row2=$("<td></td>").append($(this).find("td:eq(1)").text());
		var row3=$("<td></td>").append($(this).find("td:eq(2)").text());
		var row4=$("<td></td>").append($(this).find("td:eq(3)").text());
		var row5=$("<td></td>").append($(this).find("td:eq(4)").text());
		var row6=$("<td></td>").append($(this).find("td:eq(5)").text());
		var row7=$("<td></td>").append("请双击编辑");
		if($(this).find("td:eq(0)").text().length>0){
		$("<tr></tr>").append(checkBoxTd).append(row1).append(row2).append(row3)
		.append(row4).append(row5).append(row6).append(row7).appendTo(parent.$("#tableB tbody"));
		parent.add_drug_todb();
		}
	});
}
//显示到开药
$(document).on('click','#tableC tr',function(){
	$("#tableD tbody").empty();
		var mould_name=$(this).find("td").eq(0).html(); 
	   var mould_id=$(this).find("td").eq( 0 ).attr("mould_id");
	   $("#use_mould_name").html(mould_name).addClass("c-red").attr("mould_id",mould_id);
	 	$.ajax({
			url:"${APP_PATH}/load_detailmould",
			type:"GET",
			data:"mould_id="+mould_id,
			dataType: "json",
			success:function(result){	
				if(result.extend.dmouldlist!=""){
					 $.each(result.extend.dmouldlist,function(index,item){						 	
						 	var drugID=item.drugId;
							var how_use = $("<td></td>").append(item.howUse);
							var how_many_use = $("<td></td>").append(item.howMuchUse);
							var how_ofen_use = $("<td></td>").append(item.howOfenUse);	
							load_drug(drugID);
						$("<tr></tr>").append(itemname).append(itemformat).append(itemprice).append(
								how_use).append(how_many_use).append(how_ofen_use).appendTo("#tableD tbody");
					}); 
					 
				}
						
				},
				error:function(result){
					console.log("失败");
				}									
		});
	   
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
					itemname = $("<td></td>").append(result.extend.druglist[0].drugsName);
					itemname=itemname.attr("drug_id",drugID);
					itemprice =$("<td></td>").append( result.extend.druglist[0].drugsPrice);
					itemformat =$("<td></td>").append( result.extend.druglist[0].drugsFormat);
					return true;
				}
				},
				error:function(result){
					console.log("失败");
				}
				
		 
	});
}
</script>
</body>
</html>