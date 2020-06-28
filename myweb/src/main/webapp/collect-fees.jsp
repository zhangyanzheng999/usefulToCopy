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
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>收费</title>
</head>
<body>
<!-- 收费模态框 -->
<div class="modal fade" id="collectfeeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel" align="center">发票信息(交费)</h4>
      </div>
      <div class="modal-body">
       <div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">发票号(可修改)</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="bill_code" name="bill_code">
			</div>
			<label class="form-label col-xs-3 col-sm-3">病历号</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="med_code" name="med_code" readonly="readonly">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">患者姓名</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="patient_name" name="patient_name" readonly="readonly">
			</div>
			<label class="form-label col-xs-3 col-sm-3">支付方式</label>
			<div class="formControls col-xs-3 col-sm-3">
				<span class="select-box"><select class="select" name="payway" id="payway">
						<option value="51">现金</option>
						<option value="52">医保卡</option>
						<option value="53">银行卡</option>
						<option value="54">信用卡</option>
						<option value="55">微信</option>
						<option value="56">支付宝</option>
						<option value="57">云闪付</option>
						<option value="58">其他</option>
				</select></span>
			</div>
		</div>
       <div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">应收金额</label>
			<div class="form-label col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="need_pay" name="need_pay" readonly="readonly">
			</div>
			<label class="form-label col-xs-3 col-sm-3">实收金额</label>
			<div class="form-label col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="real_pay" name="real_pay">
				<span class="c-red"></span>
			</div>
		</div>
        <div class="row cl">
			<label class="form-label col-xs-3 col-sm-3">找零金额</label>
			<div class="formControls col-xs-3 col-sm-3">
				<input type="text" class="input-text" value="" placeholder="" id="odd_change" name="odd_change" readonly="readonly">
			</div>
		</div>
      </div>
      <div class="modal-footer"  align="center" >
        <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
        <button type="button" class="btn btn-danger radius" id="collect_fee">收费</button>
      </div>
    </div>
  </div>
</div>
<article class="page-container">
	<div>
   		<p>患者信息查询</p>
			<span class="c-red">*</span>病历号：
			<input type="text" class="input-text" style="width:100px" value="" placeholder="" id="medrecord_code" name="medrecord_code">
			<span class="c-red"></span>
			<button class="btn btn-success" type="button" id="med_find" >搜索</button>
	</div>
	<div>
		<p>患者信息确认</p>
		姓名：<input type="text" class="input-text"  style="width:100px" value="" placeholder="" id="patient_name1" name="patient_name1" readonly="readonly">
		身份证号：<input type="text" class="input-text"  style="width:200px" value="" placeholder="" id="patient_IDCard" name="patient_IDCard" readonly="readonly">
		家庭住址：<input type="text" class="input-text"  style="width:200px" value="" placeholder="" id="patient_Address" name="patient_Address" readonly="readonly">
			
	</div>
	<div class="mt-20">
		<p>患者消费信息</p>
			<table class="table table-border table-bordered table-bg table-hover table-sort table-responsive" style="width:1100px;" id="charge-table">
				<thead>
					<tr>
						<th style="width:50px;"><input type="checkbox" id="check_all"></th>
						<th style="width:150px;">病历号</th>
						<th style="width:150px;">姓名</th>
						<th style="width:150px;">项目名称</th>
						<th style="width:100px;">单价</th>
						<th style="width:50px;">数量</th>
						<th style="width:150px;">开立时间</th>
						<th style="width:100px;">状态</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			 <input class="btn btn-danger radius" type="submit" id="collect-fee-btn" value="收费结算"> 
	</div>
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
<script type="text/javascript">
//定义全局变量

	var regnum
	var billcode
	var mednum 
	var patientname 
	var patientName 
	var itemname
	var itemprice
	var itemnum 
	var state
	var doctorId

/* $("#collect-fee-btn").click(function(){
	$("#collectfeeModal").modal({
		backdrop:"static"
	});
}); */
//动态生成的按钮,使用事件委托的方式，将指定的事件绑定在document上
$(document).on('click','#collect-fee-btn',function(){
	getBillCode();//生成发票号码
	$("#real_pay").val("");
	$("#odd_change").val("");
	$("#real_pay").next("span").empty();
	$("#collectfeeModal").modal("show");
	var itemprice = 0;
	var itemnum =0;
	var totalprice=0;	
	$.each($(".check_item:checked"), function() {
		var state = $(this).parents("tr").find("td:eq(7)").text();
		//只有未收费的才计算进来
		if(state=="已开立"){
		//组装项目单价字符串
		itemprice = $(this).parents("tr").find("td:eq(4)").text() ;
		//组织项目数量字符串
		itemnum = $(this).parents("tr").find("td:eq(5)").text() ;	
		//totalprice +=itemprice*itemnum;
		totalprice +=Math.round(itemprice*itemnum*100)/100; //精确到小数点后2位
		
	}
	});
	$("#need_pay").val(totalprice);
	
})
$("#med_find").click(function(){
	var medrecord_code=window.document.getElementById("medrecord_code").value;
	$("#charge-table tbody").empty();
	$("#medrecord_code").next("span").empty();
	if(medrecord_code!=""){
	$.ajax({
		url:"${APP_PATH}/load_medrecord",
		type:"GET",
	//	async:false,
		data:"medrecord_code="+medrecord_code,
		dataType: "json",
		success:function(result){
			if(result.extend.reglist!=""){
					 var array=result.extend.reglist[0];//数组取第n个值的方法
					 regnum=array.registerId;//给regnum赋值，确保是最新挂号，取得正确挂号码
					 patientName=array.patientName;//给病人姓名赋值
					 
				 	$("#med_code").val(medrecord_code);
				 	$("#patient_name").val(array.patientName);
					 $("#patient_name1").val(array.patientName);
					 $("#patient_IDCard").val(array.patientIdcard);
					 $("#patient_Address").val(array.patientAddress);
					 load_charge();
					 return true;
			 }else{
				 $("#medrecord_code").next("span").text("病历号不存在！请重新输入");
				 $("#patient_name1").val("");
				 $("#patient_IDCard").val("");
				 $("#patient_Address").val("");
				 return false;
			 }
		},
		error:function(result){
			console.log("失败了啊");
		}
	});	
	
	}else{
		 $("#medrecord_code").next("span").text("请输入病历号！");
		 $("#med_code").val("");
		 $("#patient_name").val("");
		 $("#patient_name1").val("");
		 $("#patient_IDCard").val("");
		 $("#patient_Address").val("");
		 return false;
	}
	
	
});
	//计算找零
	$("#real_pay").change(function(){	
		var need_pay=window.document.getElementById("need_pay").value;
		var real_pay=window.document.getElementById("real_pay").value;
		$("#odd_change").val("");  
		$("#real_pay").next("span").empty();
		if(need_pay!=""&&parseFloat(need_pay)<=parseFloat(real_pay)){
			
			var odd_change
			odd_change=Math.round((real_pay-need_pay)*100)/100;
			$("#odd_change").val(odd_change);
			
		}else{
			
			 $("#real_pay").next("span").text("输入的金额有误，请重新输入");
		}		
	});
	
	 function load_charge(){
		var medrecord_code=window.document.getElementById("medrecord_code").value;
		$.ajax({
			url:"${APP_PATH}/load_pre",
			type:"GET",
			//async:false,
			data:"regnum="+regnum+"&medrecord_code="+medrecord_code,
			 dataType: "json",
			success:function(result){
			if(result.extend.prelist!=""){	
				//console.log(result.extend.prelist);
			$("#charge-table tbody").empty();//先清空
			$.each(result.extend.prelist,function(index,item){
						var preID=item.preId; //获得处方号	
						var opentime = item.preOpenTime;
						var doctorId = item.doctorId;						
						load_detailpre(preID,opentime);
			});
			}		
			},
			error:function(result){
				console.log("1");
				console.log("失败");
			}
			
			
		});		
	}
	 //根据药品id得到药品信息
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
					return true;
					}
					},
					error:function(result){
						console.log("失败");
					}			 
		});
	}
	//得到病人这个处方的处方明细
	function load_detailpre(preID,opentime){
		var medrecord_code=window.document.getElementById("medrecord_code").value;
		$.ajax({
			url:"${APP_PATH}/load_detailpre",
			type:"GET",
		//	async:false,
			data:"preID="+preID,
			 dataType: "json",
			 success:function(result){
					if(result.extend.detailprelist!=""){
						 $.each(result.extend.detailprelist,function(index,item){
												 
							 	var opentimenow = $("<td></td>").append(opentime);//根据全局变量给表格赋值							 	
							 	var drugID=item.drugsId;
							 	var checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item'/>").attr({detail_id:item.detialpreId,pre_id:preID});
								var mednum = $("<td></td>").append(medrecord_code);
								var patientname = $("<td></td>").append(patientName);						
								load_drug(drugID);		
								itemnum = $("<td></td>").append(item.drugsNum);								
								state=item.detailpreState;
							if(state==0){
							 	state = $("<td></td>").append("已开立");
							}else if(state==1){
								state = $("<td></td>").append("已收费");
							}else if(state==2){
								state = $("<td></td>").append("已退费");
							}else{
								state = $("<td></td>").append("已开药");
							}
							state=state.attr("state_id",item.detailpreState);
							$("<tr></tr>").append(checkBoxTd).append(mednum).append(patientname).append(
									itemname).append(itemprice).append(itemnum)
								.append(opentimenow).append(state).appendTo("#charge-table tbody");
						}); 
						
					}
					},
					error:function(result){
						
						console.log("失败");
					}
					
			 
		});
	} 
	/* //在表格末尾生成结算按钮
	function load_btn_cfree(){
		var Btn="<a data-toggle=\"modal\" href=\"remote.html\" data-target=\"#modal\">  <input class=\"btn btn-danger radius\" type=\"submit\" id=\"collect-fee-btn\" value=\"收费结算\">  </a>";
		$("<tr></tr>").append(Btn).appendTo("#charge-table tbody");
		
	} */
	//完成全选/全不选功能
	$("#check_all").click(function() {
		var is_All_Check = $(this).prop("checked");
		$(".check_item").prop("checked", is_All_Check);
	});
	//睡眠函数，以毫秒为单位
function sleep(n) {
    var start = new Date().getTime();
    while(true)  
    	if(new Date().getTime()-start > n) 
    		break;
    }
	//发票号码，先生成最大的
function getBillCode(){
	$.ajax({
		url:"${APP_PATH}/load_billcode",
		type:"GET",
		dataType: "json",
		success:function(result){
			$("#bill_code").val(result.extend.billcode);
			billcode=result.extend.billcode;
			return true;
		},error:function(result){
			console.log("失败了啊");
		}
	});	
}
	
	//完成收费功能
	$("#collect_fee").click(function(){
		if($("#real_pay").next("span").html().length===0){
		var	bill_code=window.document.getElementById("bill_code").value; 
		var	payway=window.document.getElementById("payway").value; 
		var	need_pay=window.document.getElementById("need_pay").value; 
		if(need_pay!=0){
		$.ajax({
			url:"${APP_PATH}/store_bill",
			type:"GET",
			data:{bill_code:bill_code,need_pay:need_pay,regnum:regnum,payway:payway},
			dataType: "json",
			success:function(result){
				if(result.code==100){
					window.alert("收费成功");
					 $('.modal').map(function () {
				         if (!$(this).is(":hidden")){
				             $(this).modal('hide');
				         }
				     });
					return true;
				}
		else{
			 window.alert("收费失败");
			 return false; 
		}
			},error:function(result){
				console.log("失败了啊");
			}
		});
		}else{
			 window.alert("没有收费项目");
			 return false; 
		}
		}else{
			 window.alert("请输入正确的金额");
			 return false; 
		}
	});
	//循环存进charge里
	$("#collect_fee").click(function(){
		if($("#real_pay").next("span").html().length===0){
		var	need_pay=window.document.getElementById("need_pay").value; 
		if(need_pay!=0){
		var medrecord_code=window.document.getElementById("medrecord_code").value;
		var	payway=window.document.getElementById("payway").value;
		var	bill_code=window.document.getElementById("bill_code").value; 
		$.each($(".check_item:checked"), function() {
			var itemname = $(this).parents("tr").find("td:eq(3)").text();	
			var itemprice = $(this).parents("tr").find("td:eq(4)").text() ;
			var itemnum = $(this).parents("tr").find("td:eq(5)").text() ;	
			var opentime = $(this).parents("tr").find("td:eq(6)").text();	
			var state = $(this).parents("tr").find("td:eq(7)").attr("state_id");	
			$.ajax({
				url:"${APP_PATH}/store_charge",
				type:"GET",
				data:{medrecord_code:medrecord_code,patientName:patientName,itemname:itemname,itemprice:itemprice,itemnum:itemnum,opentime:opentime,state:state,regnum:regnum,payway:payway,doctorId:doctorId,bill_code:bill_code},
				dataType: "json",
				success:function(result){
							
				}
		});
		
		
	});
		}
		}
	});
	//改变详细出访里的状态
	$("#collect_fee").click(function(){
		if($("#real_pay").next("span").html().length===0){
		var	need_pay=window.document.getElementById("need_pay").value; 
		if(need_pay!=0){
		$.each($(".check_item:checked"), function() {
			var itemid = $(this).parents("tr").find("td:eq(3)").attr("drug_id");//药品id
			var preID=$(this).parents("tr").find("td:eq(0)").attr("pre_id");
			$.ajax({
				url:"${APP_PATH}/change_detailstate",
				type:"GET",
				data:{itemid:itemid,preID:preID},
				dataType: "json",
				success:function(result){
				}
		});
		
		
	});
		load_charge();
		}
		}
	});

  

</script> 
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>