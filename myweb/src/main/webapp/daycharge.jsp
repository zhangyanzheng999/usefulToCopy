<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%pageContext.setAttribute("APP_PATH",request.getContextPath());%>
<!DOCTYPE html>
<html>
<style>
/*页面居中*/
        .first {
            width: 49%;
            float:left;
           length:
        }
        .second {
            width: 49%;
            float:right;        
        }





#popLayer {
	display: none;
	background-color: #B3B3B3;
	position: absolute;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	z-index: 10;
	-moz-opacity: 0.8;
	opacity: .80;
	filter: alpha(opacity = 80); /* 只支持IE6、7、8、9 */
}

#popBox {
	display: none;
	background-color: #FFFFFF;
	z-index: 11;
	width: 960px;
	height: 540px;
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
	margin: auto;
}

#popBox .close {
	text-align: right;
	margin-right: 5px;
	background-color: #F8F8F8;
}

/*关闭按钮*/
#popBox .close a {
	text-decoration: none;
	color: #2D2C3B;
}
</style>


<style type="text/css">
/* CSS样式制作 */  
 *{padding:0px; margin:0px;}
  a{ text-decoration:none; color:black;}
  a:hover{text-decoration:none; color:#336699;}
   #tab{ padding:5px;height:150px;margin:20px;}
   #tab ul{list-style:none; display:;height:30px;line-height:30px;
        border-bottom:2px #C88 solid;}
   #tab ul li{background:#FFF;cursor:pointer;float:left;
    list-style:none height:29px; line-height:29px;padding:0px 10px;
    margin:0px 10px; border:1px solid #BBB; border-bottom:2px solid #C88;}
   #tab ul li.on{border-top:2px solid gray; border-bottom:2px solid #FFF;}
   #tab div{line-height:24px;border-top:none;  
            padding:1px; border:1px solid #336699;padding:10px;}
   .hide{display:none;}
</style>



    

<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="Bookmark" href="/favicon.ico">
<link rel="Shortcut Icon" href="/favicon.ico" />

<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/his/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/his/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/his/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/his/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css"
	href="${APP_PATH}/his/static/h-ui.admin/css/style.css" />
<script type="text/javascript" src="${APP_PATH}/his/lib/jquery/1.9.1/jquery.js"></script>
<script type="text/javascript"
	src="${APP_PATH}/his/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript"
	src="${APP_PATH}/his/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${APP_PATH}/his/lib/laypage/1.2/laypage.js"></script>

<script type="text/javascript">
    // JS实现选项卡切换
    window.onload = function(){
    var myTab = document.getElementById("tab");    //整个div
    var myUl = myTab.getElementsByTagName("ul")[0];//一个节点
    var myLi = myUl.getElementsByTagName("li");    //数组
    var myDiv = myTab.getElementsByTagName("div"); //数组

    for(var i = 0; i<myLi.length;i++){
        myLi[i].index = i;
        myLi[i].onclick = function(){
            for(var j = 0; j < myLi.length; j++){
                myLi[j].className="off";
                myDiv[j].className = "hide";
            }
            this.className = "on";
            myDiv[this.index].className = "show";
        }
      }
    }
    </script>
   
<title>门诊日结</title>


</head>



<body>



 <div class="panel panel-default first">
    <div class="panel-header">日结列表</div>
 
 
    	<div id = "tab">
        <ul>
        <li class="on">未日结</li>
        <li class="off">历史日结</li>
        </ul>
        
        <div id="firstPage" class="on">

		
   			 
       			 <form>
          			  <input type="text" placeholder="请输入姓名或编号" >
          			  <button type="submit"></button>
       			 </form>
   			 
   
        
        
            <table
			class="table table-border table-bordered table-bg table-hover table-sort table-responsive"
			id="tbMain">
			<thead>
				<tr class="text-c">
					<th width="50">工作编号</th>
					<th width="50">职员名称</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>Z01</td>
					<td>张量</td>
				</tr>
				<tr class="text-c">
					<td>Z02</td>
					<td>徐东升</td>
				</tr>
									
			</tbody>			
		</table>          
    	</div>
        
        
        
        </div>
        	<br/>	<br/>	<br/>

 </div>

  

		<div class="second panel panel-default">
	
		<div class="panel-header">发票列表</div>
			<table
				class="table table-border table-bordered table-bg table-hover table-sort table-responsive panel-body">
				<thead>
					<tr class="text-c">
						<th width="25"><input type="checkbox" name="" value=""></th>
						<th width="200">发票编号</th>
						<th width="80">时间</th>
						<th width="80">总金额（元）</th>
					
					</tr>
				</thead>
				<tbody>
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""></td>
						<td>202005070001</td>
						<td>2019-6-11 11:11:42</td>
						<td>182.4</td>
					</tr>
					<tr class="text-c">
						<td><input type="checkbox" value="" name=""></td>
						<td>202005070002</td>
						<td>2019-6-11 12：23：33</td>
						<td>34</td>
					</tr>
				</tbody>
			</table>
			<br/>
			<br/>
			<div style="text-align:right">
				<input class="btn btn-primary radius" type="button" onclick="popToBox()" name="popBox" 
				value="&nbsp;&nbsp;日结&nbsp;&nbsp;">
			</div>
		<br/>
		<br/>
		<br/>
		<table
			class="table table-border table-bordered table-bg table-hover table-sort table-responsive"
			id="tbMain">
			<thead>
				<tr class="text-c">
					<th width="50">挂号费</th>
					<th width="50">药费</th>
					<th width="50">材料费</th>
					<th width="50">检查费</th>
					<th width="50">处置费</th>
					<th width="50">总计</th>
					<th width="50">明细</th>
				</tr>
			</thead>
			<tbody>
					<tr class="text-c">
						<td>50.00</td>
						<td>20.00</td>
						<td>5.50</td>
						<td>100.00</td>
						<td>0</td>
						<td>200.00</td>
						<td>
							<input class="btn btn-primary radius" type="button"
							onclick="popToBox()" name="popBox" value="&nbsp;&nbsp;显示明细&nbsp;&nbsp;">
						</td>
					</tr>
					
				</tbody>
			
		</table>
			<br/>
			<br/>
	</div>



	
</head>



</body>
</html>