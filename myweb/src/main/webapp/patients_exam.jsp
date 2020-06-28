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
<title>患者检验</title>
</head>
<body>
<article class="page-container">
	<form action="" method="post" class="form form-horizontal" id="back_register_form">
	<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1">患者信息查询</label>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1"><span class="c-red">*</span>病历号：</label>
			<div class="formControls col-xs-2 col-sm-2">
				<input type="text" class="input-text" value="" placeholder="" id="key" name="key" onkeydown="onSearch(this)">
				<span class="c-red"></span>
			</div>
			<div class="formControls col-xs-2 col-sm-2">
				<input class="btn btn-primary radius" type="button" id="med_find" value="&nbsp;&nbsp;搜索&nbsp;&nbsp;">
			</div>
		</div>
		<div class="row cl">
			<label class="form-label col-xs-1 col-sm-1" style="left:90px;">  患者挂号信息</label>
		</div>

			<div class="row cl">
				<div style="position:absolute; width:1300px; height:200px;z-index:1;left:110px;top:150px;">
					<table class="table table-border table-bg" id="reg-table">
						<thead>
							<tr>
								<th style="width:100px;">病历号</th>
								<th style="width:100px;">姓名</th>
								<th style="width:200px;">身份证号</th>
								<th style="width:150px;">挂号日期</th>
								<th style="width:150px;">看诊科室</th>
								<th style="width:150px;">门诊医生</th>
								<th style="width:100px;">开立项目</th>
								<th style="width:200px;">操作</th>
								<th style="width:100px;">结果录入</th>
								<th style="width:100px;">图片上传</th>
							</tr>
						</thead>
						<tbody>
						    <tr>
                              <td>001</td>
                              <td>张三</td>
                              <td>211342199658438026</td>
                              <td>2020/5/9</td>
                              <td>心脑血管科</td>
                              <td>甄沉</td>
                              <td>胃镜</td>
                              <td>
                                  <input type="button"  value="执行确认" class="btn btn-danger" id="btn btn-danger" onclick="sub()" />
                                  <input class="btn btn-primary radius" type="button" id="med_find" value="取消" onclick="cancel()" />
                              </td>
                              <td>
                                  <input type="button" name="" value="录入" class="btn btn-danger" onclick="disp_prompt()" />
                              </td>
                              <td>
                                  <input type="file" size="5" name="picaddress" onChange="javascript:FileChange(this.value);">
                                  <br><IMG id=uploadimage height=0 width=0 src=""  onload="javascript:DrawImage(this);" >
                              </td>
                            </tr>
                            <tr>
                              <td>002</td>
                              <td>李四</td>
                              <td>222222222222222</td>
                              <td>2020/5/9</td>
                              <td>心脑血管科</td>
                              <td>甄沉</td>
                              <td>肠镜</td>
                              <td>
                                  <input type="button"  value="执行确认" class="btn btn-danger" id="btn btn-danger" onclick="sub()" />
                                  <input class="btn btn-primary radius" type="button" id="med_find" value="取消" onclick="cancel()" />
                              </td>
                              <td>
                                  <input type="button" name="" value="录入" class="btn btn-danger" onclick="disp_prompt()" />
                              </td>
                              <td>
                                  <input type="file" size="5" name="picaddress" onChange="javascript:FileChange(this.value);">
                                  <br><IMG id=uploadimage height=0 width=0 src=""  onload="javascript:DrawImage(this);" >
                              </td>
                            </tr>
                            <tr>
                              <td>096</td>
                              <td>商敬</td>
                              <td>456765679087695123</td>
                              <td>2020/5/9</td>
                              <td>心脑血管科</td>
                              <td>吴欢</td>
                              <td>脑部CT</td>
                              <td>
                                  <input type="button"  value="执行确认" class="btn btn-danger" id="btn btn-danger" onclick="sub()" />
                                  <input class="btn btn-primary radius" type="button" id="med_find" value="取消" onclick="cancel()" />
                              </td>
                              <td>
                                  <input type="button" name="" value="录入" class="btn btn-danger" onclick="disp_prompt()" />
                              </td>
                              <td>
                                  <input type="file" size="5" name="picaddress" onChange="javascript:FileChange(this.value);">
                                  <br><IMG id=uploadimage height=0 width=0 src=""  onload="javascript:DrawImage(this);" >
                              </td>
                            </tr>
                            <tr>
                              <td>066</td>
                              <td>赵小红</td>
                              <td>256456199658273042</td>
                              <td>2020/5/11</td>
                              <td>骨科</td>
                              <td>甄沉</td>
                              <td>CT</td>
                              <td>
                                  <input type="button"  value="执行确认" class="btn btn-danger" id="btn btn-danger" onclick="sub()" />
                                  <input class="btn btn-primary radius" type="button" id="med_find" value="取消" onclick="cancel()" />
                              </td>
                              <td>
                                  <input type="button" name="" value="录入" class="btn btn-danger" onclick="disp_prompt()" />
                              </td>
                              <td>
                                  <input type="file" size="5" name="picaddress" onChange="javascript:FileChange(this.value);">
                                  <br><IMG id=uploadimage height=0 width=0 src=""  onload="javascript:DrawImage(this);" >
                              </td>
                            </tr>
						</tbody>
					</table>
				</div>
			</div>
</form>
</article>

<!--_footer 作为公共模版分离出去-->
<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript">
//搜索查询
function onSearch(obj){//js函数开始
  setTimeout(function(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
    var storeId = document.getElementById('reg-table');//获取table的id标识
    var rowsLength = storeId.rows.length;//表格总共有多少行
    var key = obj.value;//获取输入框的值
    var searchCol = 0;//要搜索的哪一列，这里是第一列，从0开始数起
    for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
      var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
      if(searchText.match(key)){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
        storeId.rows[i].style.display='';//显示行操作，
      }else{
        storeId.rows[i].style.display='none';//隐藏行操作
      }
    }
  },200);//200为延时时间
}
function DrawImage(ImgD){
   var preW = 300;
   var preH = 400 ;
   var image=new Image();
   image.src=ImgD.src;
   if(image.width>0 && image.height>0){
    flag=true;
        if(image.width/image.height>= preW/preH){
             if(image.width>preW){
                 ImgD.width=preW;
                 ImgD.height=(image.height*preW)/image.width;
             }else{
                 ImgD.width=image.width;
                 ImgD.height=image.height;
         }
         ImgD.alt=image.width+"×"+image.height;
         }
        else{
             if(image.height>preH){
                 ImgD.height=preH;
                 ImgD.width=(image.width*preH)/image.height;
                 }else{
                     ImgD.width=image.width;
                     ImgD.height=image.height;
                 }
                 ImgD.alt=image.width+"×"+image.height;
                 }
            }
       }
function FileChange(Value){
    flag=false;
    document.getElementById("uploadimage").width=10;
    document.getElementById("uploadimage").height=10;
    document.getElementById("uploadimage").alt="";
    document.getElementById("uploadimage").src=Value;

}
function disp_prompt(){
    var name=prompt("请输入检验结果","");
    if (name!=null && name!="") {
        alert("你输入的是" + name);
    }
}

function sub(){
	alert("确认执行？");
}
function cancel(){
	alert("确认取消？");
}
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>