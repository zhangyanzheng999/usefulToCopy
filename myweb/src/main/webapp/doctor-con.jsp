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
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script> 
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
<title>医生看诊</title>
<style type="text/css">
.tabBar {border-bottom:1px solid white}
.tabBar span {border:2px solid whitesmoke;background-color: whitesmoke;cursor: pointer;display: inline-block;float: left;
font-weight: normal;height: 30px;line-height: 30px;padding: 0 15px}
.tabBar span.current{background-color: white;color: cornflowerblue;border-bottom-style:none}
.tabCon {display: none}
</style>
</head>
<body>
<nav class="breadcrumb">
患者选择：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a class="btn btn-success" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" ><i class="Hui-iconfont">&#xe68f;</i></a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a class="btn btn-success" style="line-height:1.6em;margin-top:3px" id="hideInformation">隐藏患者栏</a>
<span id="baseInformation"></span>
<input type="hidden" id="reg_id" name="reg_id" value="">
<input type="hidden" id="med_code" name="med_code" value="">
<input type="hidden" id="pre_id" name="pre_id" value="">
<a href="javascript:done_zhenduan();"><font color="blue" style="float:right;">诊毕&nbsp;&nbsp;</font></a>
</nav>
<table  >
<tr>
<td width="200" class="va-t" style="border:1px solid;border-bottom-style:none;border-color:Gainsboro;">
<div class="page-container">
    <div id="tab-system" class="HuiTab">
    <p >患者名：
    <input type="text" name="patientName" id="patientName" placeholder=" " style="width:64px" class="input-text">
	<button  class="btn btn-primary radius" id="find_patient" type="button"><i class="Hui-iconfont">&#xe665;</i></button>
	<input type="hidden" id="guahaoID" name="guahaoID" value="">
	</p>
	    <div class="tabBar cl">
		    <span>本人</span>
			<span>科室*&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		</div>
		<div class="tabCon">
		<p></p>
		    <div style="background:aliceblue;"><font color="cornflowerblue" >未诊患者</font></div>
            <table id="thetable1" >        
		        <thead>		
		        </thead>
		        <tbody>
		        </tbody>	        
	        </table>
	        <p></p>
            <div style="background:aliceblue;"><font color="cornflowerblue" >已诊患者</font></div>
            <table id="thetable2" >
		        <thead>		       
		</thead>
		        <tbody>
		       </tbody>
	        </table>	
		</div>		
		<div class="tabCon">
		<span id="doc_depart"></span>
		</div>
	</div>
</div>			
</td>
<td class="va-t">
	<iframe ID="testIframe" Name="testIframe" width=100%  height=600px frameborder="0" SRC="system-base.jsp">				
    </iframe>
</td>
</tr>
</table>
<!--_footer 作为公共模版分离出去-->
<%-- <script type="text/javascript" src="${APP_PATH}/his/lib/jquery/1.9.1/jquery.min.js"></script> --%>
<script type="text/javascript" src="${APP_PATH}/his/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<script type="text/javascript" src="${APP_PATH}/his/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script> 
<script type="text/javascript">
var login_doctorid = window.parent.document.getElementById("login_doctor");
var hideinfo
var disease_name,disease_ICD
var doc_depart
$(function(){
	$('.skin-minimal input').iCheck({
		checkboxClass: 'icheckbox-blue',
		radioClass: 'iradio-blue',
		increaseArea: '20%'
	});
	$("#tab-system").Huitab({
		index:0
	});
	load_patient();
});
function load_doc_depart(){
	$.ajax({
		url:"${APP_PATH}/load_doc_depart",
		type:"GET",
		data:"doc_depart="+doc_depart,
		dataType: "json",
		success:function(result){
			$("#doc_depart").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+result.extend.departlist[0].deptName);
		},error:function(result){
		}
	});
}
//给表格每一行绑定事件
$(document).on('click','#thetable1 tr,#thetable2 tr',function(){
	   var regnum=$(this).find("td").eq( 0 ).html();
	   var medrecord_code=$(this).find("td").eq( 1 ).html();
	   var patient_name=$(this).find("td").eq( 2 ).html();
	   $("#testIframe").contents().find("#Wtable tbody").empty();
	   $("#testIframe").contents().find("#Ctable tbody").empty();
		$("#reg_id").val(regnum);//用于存储
		$("#med_code").val(medrecord_code);
	   //$("#baseInformation").empty();
		$.ajax({
			url:"${APP_PATH}/doc_load_patient",
			type:"GET",
			data:"regnum="+regnum,
			dataType: "json",
			success:function(result){					
					var patient_sex=result.extend.reglist[0].patientSex;
					if(parseInt(patient_sex)==71){
						patient_sex="男";
					}else patient_sex="女";
					var patient_year=result.extend.reglist[0].patientYear;
					var paitent_show="患者姓名："+patient_name+","+"病历号:"+medrecord_code+","+"年龄:"+patient_year+","+"性别:"+patient_sex;	
					$("#baseInformation").html(paitent_show);
					hideinfo=paitent_show;
					load_patient_diag(regnum,medrecord_code);
					load_medrecord(regnum,medrecord_code);
					return true;		
				},
				error:function(result){
					console.log("失败");
				}							
			
		});
	   
});
//根据疾病id加载疾病信息
function load_detail_disease(disease_id,state){
	$.ajax({
		url:"${APP_PATH}/load_detail_xiyi_disease",
		type:"GET",
		async:false,
		data:"disease_id="+disease_id,
		 dataType: "json",
		success:function(result){
			 $.each(result.extend.dislist,function(){
				 if(parseInt(state)==1){
					 disease_name = $("<td></td>").append(this.diseaseName).attr("xi_dise",this.diseaseId);
				 }else{
					 disease_name = $("<td></td>").append(this.diseaseName).attr("zhong_dise",this.diseaseId); 
				 }				 
					 disease_ICD=$("<td></td>").append(this.diseaseIcd);
				}); 
			 return false;
		},
		error:function(result){
			
		}
	});	
}
//根据病历号和挂号号码加载病人的疾病信息
function load_patient_diag(regnum,medrecord_code){
	$.ajax({
		url:"${APP_PATH}/load_patient_diag",
		type:"GET",
		data:{regnum:regnum,medrecord_code:medrecord_code},
		dataType: "json",
		success:function(result){	
				if(result.extend.diaglist!=""){
					$.each(result.extend.diaglist,function(){
							var Wtable=$("#testIframe").contents().find("#Wtable tbody");
							var Ctable=$("#testIframe").contents().find("#Ctable tbody");
							var diagType=this.diagType;
							if(parseInt(diagType)==1){
								var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item'/>");
								var Kong = $("<td></td>").append("");							
								var disease_id=this.diseaseId;
								load_detail_disease(disease_id,1);			
								var has_date=$("<td></td>").append(this.onsetTime);
							$("<tr></tr>").append(Kong).append(checkBoxTd).append(disease_ICD).append(
									disease_name).append(has_date).appendTo(Wtable);
							}else if(parseInt(diagType)==2){
								var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item1'/>");
								var Kong = $("<td></td>").append("");							
								var disease_id=this.diseaseId;
								load_detail_disease(disease_id,2);			
								var has_date=$("<td></td>").append(this.onsetTime);
							$("<tr></tr>").append(Kong).append(checkBoxTd).append(disease_ICD).append(
									disease_name).append(has_date).appendTo(Ctable);
							}
							
					});  															
				}
				load_zhenduan();
				load_pre();
				
				//$("#testIframe")[0].contentWindow.load_pre(); 调用子页面方法
			},
			error:function(result){
				console.log("失败");
			}							
		
	});	
}
//加载诊断信息
function load_zhenduan(){
	var Wtable=$("#testIframe").contents().find("#Wtable tr");
	var Ctable=$("#testIframe").contents().find("#Ctable tr");
	var patient_info="【西医诊断】";
	var patient_info2="【中医诊断】";
	var xiyi=false;
	Wtable.each(function(){
		var dis_name=$(this).find("td").eq(3).html();
		if(typeof(dis_name)!="undefined"&&dis_name.length>0&&dis_name!="null"){
		 patient_info=patient_info+" "+dis_name+";";
		}
		xiyi=true;
	});
 	Ctable.each(function(){
		var dis_name=$(this).find("td").eq(3).text();
		if(typeof(dis_name)!="undefined"&&dis_name.length>0&&dis_name!="null"){
		 patient_info2=patient_info2+" "+dis_name+";";
		}
		
	}); 
	if(xiyi)
		$("#testIframe").contents().find("#done_zhenduan").html(patient_info);
	else
		$("#testIframe").contents().find("#done_zhenduan").html(patient_info2);
}
//加载已诊患者的病例信息
function load_medrecord(regnum,medrecord_code){
	$("#testIframe").contents().find("#zs").val("");
	$("#testIframe").contents().find("#xbs").val("");
	$("#testIframe").contents().find("#xbzlqk").val("");
	$("#testIframe").contents().find("#jws").val("");
	$("#testIframe").contents().find("#gms").val("");
	$("#testIframe").contents().find("#tgjc").val("");
	$.ajax({
	url:"${APP_PATH}/load_patient_med",
	type:"GET",
	data:{regnum:regnum,medrecord_code:medrecord_code},
	dataType: "json",
	success:function(result){
		if(result.extend.medlist!=""){
			
			$("#testIframe").contents().find("#zs").val(result.extend.medlist[0].chiefComplaint);
			$("#testIframe").contents().find("#xbs").val(result.extend.medlist[0].nowIllness);
			$("#testIframe").contents().find("#xbzlqk").val(result.extend.medlist[0].nowMedicalStatus);
			$("#testIframe").contents().find("#jws").val(result.extend.medlist[0].pastIllness);
			$("#testIframe").contents().find("#gms").val(result.extend.medlist[0].allergyHistory);
			$("#testIframe").contents().find("#tgjc").val(result.extend.medlist[0].physicalExamination);
					
		}
	},
	error:function(result){
		
	}
	});
}
//加载患者的处方
function load_pre(){
	var medrecord_code=$("#med_code").val();
	var regnum=$("#reg_id").val();
	var tableA=$("#testIframe").contents().find("#tableA tbody");
	var tableB=$("#testIframe").contents().find("#tableB tbody");
	$.ajax({
		url:"${APP_PATH}/load_pre",
		type:"GET",
		//async:false,
		data:{regnum:regnum,medrecord_code:medrecord_code},
		 dataType: "json",
		 success:function(result){
			 tableA.empty();
			 tableB.empty();
			if(result.extend.prelist!=""){
				 $.each(result.extend.prelist,function(){
						 var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item3'/>");
						var mould_name=$("<td></td>").append(this.preName).attr("mould_id",this.preId);
						if(this.preState==1){
							var state=$("<td></td>").append("暂存").attr("pre_state",this.preState);
						}else if(this.preState==2){
							var state=$("<td></td>").append("开立").attr("pre_state",this.preState);
						}else{
							var state=$("<td></td>").append("作废").attr("pre_state",this.preState);
						}
						$("<tr></tr>").append(checkBoxTd).append(mould_name).append(state).appendTo(tableA);
					}); 
				 $("#pre_id").val(result.extend.prelist[0].preId);
				 load_detail_pre(result.extend.prelist[0].preId);
			}
		 },error:function(result){
		
		 }
	});
}
//加载患者的详细处方
function load_detail_pre(preID){
	var tableB=$("#testIframe").contents().find("#tableB tbody");
	$.ajax({
		url:"${APP_PATH}/load_detailpre",
		type:"GET",
		//async:false,
		data:{preID:preID},
		 dataType: "json",
		success:function(result){
			tableB.empty();
				if(result.extend.detailprelist!=""){
					 $.each(result.extend.detailprelist,function(){
							 var  checkBoxTd = $("<td></td>").append("<input type='checkbox' class='check_item2'/>").attr("detail_id",this.detialpreId);
							 var drugID=this.drugsId;
							 var yongfa=$("<td></td>").append(this.yongFa);
							var yongliang=$("<td></td>").append(this.yongLiang);
							var pinci=$("<td></td>").append(this.pinLv);
							var number=$("<td></td>").append(this.drugsNum);
							load_drug(drugID);
							itemname.attr("detail_id",this.detialpreId);
							$("<tr></tr>").append(checkBoxTd).append(itemname).append(itemformat).append(itemprice)
							.append(yongfa).append(yongliang).append(pinci).append(number).appendTo(tableB);
						}); 
				}
		},
		error:function(result){
			
		}
		
		
	});
}
//加载医生的患者
function load_patient(){
	$("#thetable1 tbody").empty();//先清空
	$("#thetable2 tbody").empty();//先清空
	$.ajax({
		url:"${APP_PATH}/load_patientlist",
		type:"GET",
		//async:false,
		data:"login_doctorid="+login_doctorid.innerHTML,
		 dataType: "json",
		success:function(result){
			if(result.extend.patientlist!=""){
				doc_depart=result.extend.patientlist[0].registerDeptId;
				$.each(result.extend.patientlist,function(index,item){	
					var regnum=$("<td></td>").append(item.registerId);
					var medrecord_code=$("<td></td>").append(item.medrecordCode);
					var patient_name=$("<td></td>").append(item.patientName);
					var state=item.thisVisitState;
					if(parseInt(state)==3){
						$("<tr></tr>").append(regnum).append(medrecord_code).append(
								patient_name).appendTo("#thetable1 tbody");
					}else if(parseInt(state)==1){
						$("<tr></tr>").append(regnum).append(medrecord_code).append(
								patient_name).appendTo("#thetable2 tbody");
						
					}
		
				}); 
				load_doc_depart();
			}
		},
		error:function(result){
			
			console.log("失败");
		}	
	});	
}
//利用药品id把药品名字、价格显示
var	itemname,itemprice,itemformat;
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
//隐藏患者信息栏
$("#hideInformation").click(function(){
	if($(baseInformation).html()==''|| $(baseInformation).html()== null){
	
				$("#baseInformation").html(hideinfo);
	}else{
		$("#baseInformation").empty();
	}
});

//搜索患者
$(document).on('click','#find_patient',function(){
		var name=document.getElementById("patientName").value;
		if($.trim(name)!=""){
            $("table tr:not('#thetable1')").hide().filter(":contains('"+name+"')").show();
        }else{
            $("table tr:not('#thetable1')").css("background","#fff").show();
        }
	
});
//完成诊断
function done_zhenduan(){
	var regnum=$("#reg_id").val();
	var medrecord_code=$("#med_code").val();
	$("#testIframe").contents().find("#tableA tbody").empty();
	$("#testIframe").contents().find("#tableB tbody").empty();
	$("#testIframe")[0].contentWindow.clear();
	if(regnum.length>0){
	$.ajax({
		url:"${APP_PATH}/done_all_zhenduan",
		type:"GET",
		//async:false,
		data:{medrecord_code:medrecord_code,regnum:regnum},
		 dataType: "json",
		success:function(result){
			console.log(result.code);
			if(result.code==100){
				load_patient();
				window.alert("操作成功");
			}
			else{
				window.alert("请选择未诊患者");
			}
		},error:function(result){
			
			//window.alert("诊毕进入了error");
		}
	});
	}else{
		window.alert("请选择患者");
	}
	
}
</script>
</body>
</html>