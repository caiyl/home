/**
 * 分页
 */
var totalPage = parseInt(0);// 总页数
var nowpage = parseInt(1);// 当前页码
var perpage = parseInt(10);// 每页现实记录数
var startnum = 0;// 当前开始记录
var contextPath = "localhost";
var url = contextPath + "/version/RMIServlet";
var jsonObj = {
	className : 'monitorService'
};

var dataObj = null;

var tem = [ {
	start : startnum,
	limit : perpage
} ];
var systemObj = {
	className : 'monitorService',
	methodName : 'queryByPage',
	params : lang.toJSONString(tem)
};


$(document).ready(function() {
	
	var user={"id":1,"name":"cai","password":"123","roleid":2};
	
	 $.ajax({   
	        type : 'POST',   
	        url : 'userList.do',    
	        data : user,   
	        dataType : 'json',
	                            //下面的success不执行，不知道为什么，怀疑spring3在转化返回值为json对象时格式不对。
	        success : function(data){ 
	        	console.log(data);  
	        	callback(data);
	           //alert("发送成功");   
	        },
	        error : function(data){
	        }  
	 });
	 
	 
	
	//loadData(0, 10);
});

// 根据服务名查询详细信息
function loadData(pageNo, pageSize) {
	
	var param = [ {
		"pageNo" : "",
		"pageSize" : ""
	} ];
	
	url = "getJson.do"
		
	var obj = {
		'appService' : 'appService',
		'statistics' : 'statistics',
		'param' : lang.toJSONString(param)
	};
		
	$.post(url, obj, function(data) {
		var dataObj = eval("(" + data + ")");
		console.log(data);
	});
	
//	 $.ajax({   
//	        type : 'POST',   
//	        contentType : 'application/json',   
//	        url : 'getJson.do',    
//	        data : "",   
//	        dataType : 'json',
//	                            //下面的success不执行，不知道为什么，怀疑spring3在转化返回值为json对象时格式不对。
//	        success : function(data){ 
//	           alert(data.message);  
//	           //alert("发送成功");   
//	        },
//	        error : function(data){
//	           alert(data.message);
//	        }  
//	 });

}

function statisticsApp() {
	var param = [ {
		"pageNo" : "",
		"pageSize" : ""
	} ];

	var obj = {
		className : 'appService',
		methodName : 'statistics',
		params : lang.toJSONString(param)
	};

	$.post(url, obj, function(data) {
		var dataObj = eval("(" + data + ")");
		$("#appCount").html(
				dataObj.result.ok.length + dataObj.result.warn.length);
		$("#appOkCount").html(dataObj.result.ok.length);
		$("#appWarnCount").html(dataObj.result.warn.length);
	});
}
function statisticsService() {
	var param = [ {
		"pageNo" : "",
		"pageSize" : ""
	} ];

	var obj = {
		className : 'serviceBeanService',
		methodName : 'statistics',
		params : lang.toJSONString(param)
	};

	$.post(url, obj, function(data) {
		var dataObj = eval("(" + data + ")");
		$("#serviceCount").html(
				dataObj.result.ok.length + dataObj.result.warn.length);
		$("#serviceOkCount").html(dataObj.result.ok.length);
		$("#serviceWarnCount").html(dataObj.result.warn.length);
	});
}

function statisticsProvider() {
	var param = [ {
		"pageNo" : "",
		"pageSize" : ""
	} ];

	var obj = {
		className : 'monitorService',
		methodName : 'statistics',
		params : lang.toJSONString(param)
	};

	$.post(url, obj, function(data) {
		var dataObj = eval("(" + data + ")");
		$("#providerCount").html(
				dataObj.result.ok.length + dataObj.result.warn.length);
		$("#providerOkCount").html(dataObj.result.ok.length);
		$("#providerWarnCount").html(dataObj.result.warn.length);
	});
}

// 根据返回结果组装table
function callback(data) {
	debugger
	dataObj = data;
	var renm = parseInt(dataObj.length);// 记录数
	setpage(perpage, renm, nowpage);
	// 删除表格中间数据部分
	// $("#providerTable tr:not(:first)").remove();
	$("#tabbody").empty();
	var app = "";
	for (var i = 0; i < dataObj.length; i++) {

		var inHtml = "<tr><td><input type=\"checkbox\" class=\"radio-width\" value=\""
				+ dataObj.id + "\"></td>"

		// 机器ip
		inHtml = inHtml + "<td>" + dataObj[i].id + "</td>";
		inHtml = inHtml + "<td>" + dataObj[i].name + "</td>";
		inHtml = inHtml + "<td>" + dataObj[i].password + "</td>";

		inHtml = inHtml + "</tr>";

		$('#tabbody').append(inHtml);
	}
};

/**
 * 新增应用
 */
function add() {
	var bts = {
		"保存" : function() {
			submit()
		},
		"取消" : function() {
			$("#add_dialog_div").dialog("close");
		}
	};
	$("#add_dialog_div").dialog({
		modal : true,
		maxHeight : 300,
		width : 500,
		title : "新增应用",
		close : function() {
		},
		buttons : bts
	});
	function submit() {

		var appName = $("#accessForm input[name='appName']").val();
		var hostName = $("#accessForm input[name='hostName']").val();

		var param = [ {
			"appName" : appName,
			"hostName" : hostName
		} ];

		var obj = {
			className : 'monitorService',
			methodName : 'add',
			params : lang.toJSONString(param)
		};

		$.post(url, obj, function(data) {
			$("#add_dialog_div").dialog("close");
			loadData(0, 10);
		});

	}
}

function removeApp() {
	var bts = {
		"确定" : function() {
			request()
		},
		"取消" : function() {
			$("#del_dialog_div").dialog("close");
		}
	};
	$("#del_dialog_div").dialog({
		modal : true,
		maxHeight : 300,
		width : 500,
		title : "删除应用",
		close : function() {
		},
		buttons : bts
	});
	function request() {

		var param = [ getIds() ];
		var obj = {
			className : 'monitorService',
			methodName : 'removeByIds',
			params : lang.toJSONString(param)
		};

		$.post(url, obj, function(data) {
			$("#del_dialog_div").dialog("close");
			loadData(0, 10);
		});

	}
}

/* 关闭对话框 */
function closeDialog() {
	$("#dialog_div").dialog("close");
}

function getIds() {
	var checkBoxs = $("#tabbody :checkbox");
	ids = new Array();
	for (var i = 0; i < checkBoxs.length; i++) {
		if (checkBoxs[i].checked) {
			ids.push(checkBoxs[i].value);
		}
	}
	return ids;
}

// 设置分页信息
function setpage(pageRow, totalRecord, nowPage) {
	var v1 = parseInt(totalRecord / pageRow);// 取整
	var v2 = totalRecord % pageRow;// 取余
	if (v2 > 0 || v1 == 0) {
		totalPage = v1 + 1;
	} else {
		totalPage = v1;
	}
	$("#totalnum").text(totalRecord);
	$("#nowpage").text(nowPage);
	$("#totalpage").text(totalPage);
	$("#pagebar").show();
	if (totalPage == 1 || totalPage == nowPage) {
		$("#nextpage").attr("disabled", "disabled");
		$("#lastpage").attr("disabled", "disabled");
	} else {
		$("#nextpage").removeAttr("disabled");
		$("#lastpage").removeAttr("disabled", "");
	}
	if (nowPage == 1) {
		$("#firstpage").attr("disabled", "disabled");
		$("#uppage").attr("disabled", "disabled");
	} else {
		$("#firstpage").removeAttr("disabled");
		$("#uppage").removeAttr("disabled", "");
	}
}

function go() {
	var pageNo = $("#page_no").val();
	var re = /^[1-9]+[0-9]*]*$/;
	if (!re.test(pageNo) || pageNo > totalPage) {
		alert("请输入正确的正整数：1~" + totalPage);
		$("#page_no").focus();
		return;
	}
	startnum = (pageNo - 1) * perpage;
	var searchname = $("#searchName").val();
	// systemObj.params =
	// lang.toJSONString([{name:searchname,start:startnum,limit:perpage,userOrg:selOrgId,option:getOptionVal(),isadmin:getIsAdmin(),userState:getUserStatus()}]);
	// showProgress();

	loadData(startnum, perpage);

	// loadData(url, systemObj);
	nowpage = pageNo;
}

// 下一页
function nextPage() {
	startnum = startnum + perpage;
	var searchname = $("#searchName").val();
	// systemObj.params =
	// lang.toJSONString([{name:searchname,start:startnum,limit:perpage,userOrg:selOrgId,option:getOptionVal(),isadmin:getIsAdmin(),userState:getUserStatus()}]);
	systemObj.params = lang.toJSONString(getQueryMap(searchname, startnum));
	// showProgress();
	// loadData(url, systemObj);
	loadData(startnum, perpage);
	nowpage = nowpage + 1;
}

// 上一页
function uppage() {
	startnum = startnum - perpage;
	var searchname = $("#searchName").val();
	// systemObj.params =
	// lang.toJSONString([{name:searchname,start:startnum,limit:perpage,userOrg:selOrgId,option:getOptionVal(),isadmin:getIsAdmin(),userState:getUserStatus()}]);
	systemObj.params = lang.toJSONString(getQueryMap(searchname, startnum));
	// showProgress();
	loadData(startnum, perpage);
	// loadData(url, systemObj);
	nowpage = nowpage - 1;
}

// 首页
function firstPage() {
	startnum = 0;
	var searchname = $("#searchName").val();
	// systemObj.params =
	// lang.toJSONString([{name:searchname,start:startnum,limit:perpage,userOrg:selOrgId,option:getOptionVal(),isadmin:getIsAdmin(),userState:getUserStatus()}]);
	systemObj.params = lang.toJSONString(getQueryMap(searchname, startnum));
	// showProgress();
	// loadData(url, systemObj);
	loadData(startnum, perpage);
	nowpage = 1;
}

function lastPage() {
	startnum = (totalPage - 1) * perpage;
	var searchname = $("#searchName").val();
	// systemObj.params =
	// lang.toJSONString([{name:searchname,start:startnum,limit:perpage,userOrg:selOrgId,option:getOptionVal(),isadmin:getIsAdmin(),userState:getUserStatus()}]);
	systemObj.params = lang.toJSONString(getQueryMap(searchname, startnum));
	// showProgress();
	// loadData(url, systemObj);
	loadData(startnum, perpage);
	nowpage = totalPage;
}

function getQueryMap(startnum) {
	return [ {
		start : startnum,
		limit : perpage
	} ];
}

/**
 * 更改每页显示记录数
 */
function changePerPage() {
	var pageSize = $("#pageSize").children('option:selected').val();
	perpage = parseInt(pageSize); // 每页显示记录条数;
	firstPage();
}
