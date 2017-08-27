
var symptom=[
		"-----请选择-----",
		"-----发热-----",
		"-----咳嗽-----",
		"-----咳痰-----",
		"-----呕吐-----",
		"-----腹泻-----",
		"-----便秘-----",
		"-----便血-----",
		"-----肥胖-----",
		"-----消瘦-----",
		"-----头晕-----",
		"-----皮肤出现异常-----",
		"-----少尿-----",
		"-----其他尿量相关症状-----",
		"-----排尿相关症状-----",
		"-----疼痛-----",
		"-----呕血-----",
		"-----咯血-----",
		"-----呼吸困难-----",
		"-----心悸-----",
		"-----水肿-----",
		"-----抽搐与惊厥-----",
		"-----意识障碍-----",
		"-----情感症状-----",
		"-----以上都不是-----"
		];
$(function(){
    initMainSuitSelect();
    
});
function initMainSuitSelect(){
    var pro=$("#mainSuitSelect");
    for(var i=0;i<symptom.length;i++){
        var $temp=$("<option value=\""+ i +"\">"+symptom[i]+"</option>");
        pro.append($temp);
    }
    var pro2=$("#mainSuit2Select");
    for(var i=0;i<symptom.length;i++){
        var $temp=$("<option value=\""+ i +"\">"+symptom[i]+"</option>");
        pro2.append($temp);
    }
}
//保存基本信息
$('#saveBasicInfoBtn').click(function(){
	var serialNo     = $('#serialNo').text();
	var name         = $('#name').val();
	var realBirthDay = $('#realBirthDay').val();
	var age          = $('#ageValue').text();
	var ageText      = $('#ageText').text();
	var sex          = $('#sex').val();
	var nativePlace  = $("#province").find("option:selected").text() + '-' + 
		$("#city").find("option:selected").text() + '-' + $("#districtAndCounty").find("option:selected").text();
	var presentResidence = $("#province2").find("option:selected").text() + '-' + 
		$("#city2").find("option:selected").text() + '-' + $("#districtAndCounty2").find("option:selected").text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/saveBasicInfo.action',// 跳转到 action  
	    data:{  
	    		 serialNo : serialNo,  
	    		 name : name,  
	    		 realBirthDay : realBirthDay,  
	    		 age : age,  
	    		 ageText : ageText,
	    		 sex : sex,
	    		 nativePlace : nativePlace,
	    		 presentResidence : presentResidence
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("保存成功！");  
	            window.location.href='user/index.html';
	        }else{  
	        	alert(data.message); 
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          // view("异常！");  
	          alert("异常！");  
	     }  
	});
	
});

function timeIsRight(time){
	if(time == "" || time == undefined || time == null){
		alert("请选择发病日期时间");
		return false;
	}
	var now = new Date();
	var date = new Date(time);
	// 调用日期差方法，求得参数日期与系统时间相差的天数
	var diff = now.diff(date);
	if(diff < 0){
		alert("发病日期时间不能超过今天");
		return false;
	}
	return true;
}

function timeIsRight2(time){
	if(time == "" || time == undefined || time == null){
		alert("请选择月经日期时间");
		return false;
	}
	var now = new Date();
	var date = new Date(time);
	// 调用日期差方法，求得参数日期与系统时间相差的天数
	var diff = now.diff(date);
	if(diff < 0){
		alert("月经日期时间不能超过今天");
		return false;
	}
	return true;
}

//保存主诉
$('#saveMainSuit').click(function(){
	var serialNo     = $('#serialNo').text();
	var mainSuit  = $("#mainSuitSelect").find("option:selected").text();
	var mainSuitValue  = $("#mainSuitSelect").find("option:selected").val();
	var diseaseTime = $('#diseaseTime').val();
	if(mainSuitValue == 0){
		alert("请选择症状");
		return;
	}
	if(!timeIsRight(diseaseTime)){
		return;
	}
	var mainSuit2  = $("#mainSuit2Select").find("option:selected").text();
	var mainSuitValue2  = $("#mainSuit2Select").find("option:selected").val();
	var diseaseTime2 = $('#diseaseTime2').val();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/saveMainSuit.action',// 跳转到 action  
	    data:{  
	    	    serialNo : serialNo,  
	    	    mainSuitContent : mainSuit,  
	    	    mainSuitValue : mainSuitValue,  
	    	    attackTime : diseaseTime,  
	    	    
	    	    mainSuitContent2 : mainSuit2,
	    	    mainSuitValue2 : mainSuitValue2,
	    	    attackTime2 : diseaseTime2,
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("保存成功！");  
	            window.location.href='user/index.html';
	        }else{  
	        	alert(data.message);  
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          // view("异常！");  
	          alert("异常！");  
	     }  
	});
	
});

$('#deleteBasicInfo').click(function(){
	var serialNo     = $('#serialNo').text();
    if(!confirm("是否删除")){
       return;
    }
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/deleteBasicInfo.action',// 跳转到 action  
	    data:{  
	    	serialNo : serialNo  
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("删除成功！");  
	            window.location.href='user/index.html';
	        }else{  
	        	alert(data.message);  
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          // view("异常！");  
	          alert("异常！");  
	     }  
	});
});
$('#deleteMainSuit').click(function(){
	var serialNo     = $('#serialNo').text();
    if(!confirm("是否删除")){
       return;
    }
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/deleteMainSuit.action',// 跳转到 action  
	    data:{  
	    	serialNo : serialNo  
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("删除成功！");  
	            window.location.href='user/index.html';
	        }else{  
	        	alert(data.message); 
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          // view("异常！");  
	          alert("异常！");  
	     }  
	});
});

//删除现状
$('#deletePresentIllness').click(function(){
	var serialNo1     = $('#serialNo').text();
    if(!confirm("是否删除")){
       return;
    }
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/deletePresentIllness.action',// 跳转到 action  
	    data:{  
	    	serialNo : serialNo1
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("删除成功！");  
	            window.location.href='user/index.html';
	        }else{  
	        	alert(data.message); 
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          // view("异常！");  
	          alert("异常！");  
	     }  
	});
	
});

//添加主诉
$('#btn_addMainSuit').click(function(){
    if($("#mainSuitLI2").css("display")=="none"){
    	$('#mainSuitLI2').show();
    	var date = new Date();
    	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
    	$("#diseaseTime2").val(dateString);
    	$("#mainSuit2Select ").get(0).selectedIndex=0;
    }else{
    	alert("最多添加两个主诉");
    }
});
//发热
$('#feverCheckbox').click(function(){
	if($('#feverCheckbox').is(':checked')) {
		$('#hightDegreeDIV').show();
	}else{
		$('#hightDegreeDIV').hide();
		$('#hightDegree').val('');
		$('#lowDegree').val('');
	}
	
});
//咳嗽
$('#coughCheckbox').click(function(){
	if($('#coughCheckbox').is(':checked')) {
		$('#coughDIV').show();
	}else{
		$('#coughDIV').hide();
		setTimeEmpty("coughStartTime");
	}
	
});

//咳痰
$('#expectorationCheckbox').click(function(){
	if($('#expectorationCheckbox').is(':checked')) {
		$('#expectorationDIV').show();
	}else{
		$('#expectorationDIV').hide();
		$('#expectorationSelect').get(0).selectedIndex=0;
	}
	
});

//呕吐
$('#vomitCheckbox').click(function(){
	if($('#vomitCheckbox').is(':checked')) {
		$('#vomitDIV').show();
	}else{
		$('#vomitDIV').hide();
		$('#vomitSelect').get(0).selectedIndex=0;
	}
	
});
//腹泻
$('#diarrheaCheckbox').click(function(){
	if($('#diarrheaCheckbox').is(':checked')) {
		$('#diarrheaDIV').show();
		
	}else{
		$('#diarrheaDIV').hide();
    	$("#diarrheaSelect ").get(0).selectedIndex=0;
		$('#diarrheaContinueTimeDIV').hide();
		$('#diarrheaNotMoreThan3TimesDIV').hide();
	}
	
});
//腹泻
$('#diarrheaSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 0){
		$('#diarrheaContinueTimeDIV').hide();
		$('#diarrheaNotMoreThan3TimesDIV').hide();
	} else if(p1 == 1){
		$('#diarrheaContinueTimeDIV').show();
		$('#diarrheaNotMoreThan3TimesDIV').hide();
	} else if(p1 == 2){
		$('#diarrheaContinueTimeDIV').hide();
		$('#diarrheaNotMoreThan3TimesDIV').show();
	}
});

//便秘
$('#astrictionCheckbox').click(function(){
	if($('#astrictionCheckbox').is(':checked')) {
		$('#astrictionDIV').show();
	}else{
		$('#astrictionDIV').hide();
		$("#astrictionSelect ").get(0).selectedIndex=0;
		$('#continueMoreThanHalfYearDiv').hide();
		$("#isMoreThanThreeTimesSelect ").get(0).selectedIndex=0;
	}
	
});
//便秘
$('#astrictionSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 0){
		$('#continueMoreThanHalfYearDiv').hide();
		$("#isMoreThanThreeTimesSelect ").get(0).selectedIndex=0;
		
	} else if(p1 == 1){
		$('#continueMoreThanHalfYearDiv').hide();
		$("#isMoreThanThreeTimesSelect ").get(0).selectedIndex=0;
	} else if(p1 == 2){
		$('#continueMoreThanHalfYearDiv').show();
	}
});

//便血
$('#hematocheziaCheckbox').click(function(){
	if($('#hematocheziaCheckbox').is(':checked')) {
		$('#hematocheziaDIV').show();
	}else{
		$('#hematocheziaDIV').hide();
		$("#hematocheziaSelect ").get(0).selectedIndex=0;
	}
	
});

//肥胖
$('#fatCheckbox').click(function(){
	if($('#fatCheckbox').is(':checked')) {
		$('#fatDIV').show();
	}else{
		$('#fatDIV').hide();
		$('#fatCurrentWeight').val('');
		$('#fatHight').val('');
		$('#fatWeightBMI').val('');
	}
	
});

//消瘦
$('#marasmusCheckbox').click(function(){
	if($('#marasmusCheckbox').is(':checked')) {
		$('#marasmusDIV').show();
	}else{
		$('#marasmusDIV').hide();
		$('#marasmusCurrentWeight').val('');
		$('#marasmusHight').val('');
		$('#marasmusWeightBMI').val('');
		$('#marasmusWeightDown').val('');
	}
	
});

//头晕
$('#dizzyCheckbox').click(function(){
	if($('#dizzyCheckbox').is(':checked')) {
		$('#dizzyDIV').show();
	}else{
		$('#dizzyDIV').hide();
		$('#dizzySelect').get(0).selectedIndex=0;
	}
	
});

//皮肤出现异常
$('#abnormalSkinCheckbox').click(function(){
	if($('#abnormalSkinCheckbox').is(':checked')) {
		$('#abnormalSkinDIV').show();
	}else{
		$('#abnormalSkinDIV').hide();
		$('#abnormalSkinSelect').get(0).selectedIndex=0;
		$('#limbsTrunkDIV').hide();
		$('#limbsTrunkSelect').get(0).selectedIndex=0;
		$('#limbsTrunkOtherDIV').hide();
		$('#limbsTrunkOtherInput').val("");
	}
});

//皮肤出现异常
$('#abnormalSkinSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 6){
		$('#limbsTrunkDIV').show();
	}else {
		$('#limbsTrunkDIV').hide();
		$('#limbsTrunkSelect').get(0).selectedIndex=0;
		$('#limbsTrunkOtherInput').val("");
	}
	
});

//皮肤出现异常，四肢皮肤异常
$('#limbsTrunkSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 3){
		$('#limbsTrunkOtherDIV').show();
	}else {
		$('#limbsTrunkOtherDIV').hide();
		$('#limbsTrunkOtherInput').val("");
	}
	
});

//少尿
$('#oliguresisCheckbox').click(function(){
	if($('#oliguresisCheckbox').is(':checked')) {
		$('#oliguresisDIV').show();
	}else{
		$('#oliguresisDIV').hide();
		$('#UPDInput').val('');
	}
	
});
//其他尿量相关症状
$('#otherUPDSymptomCheckbox').click(function(){
	if($('#otherUPDSymptomCheckbox').is(':checked')) {
		$('#otherUPDSymptomDIV').show();
	}else{
		$('#otherUPDSymptomDIV').hide();
		$('#otherUPDDiuresisDIV').hide();
		$('#otherUPDAnuriaDIV').hide();
		$('#otherUPDDiuresisInput').val('');
		$('#otherUPDAnuriaInput').val('');
		$('#otherUPDSymptomSelect').get(0).selectedIndex=0;
	}
	
});
//其他尿量相关症状select
$('#otherUPDSymptomSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 2){
		$('#otherUPDDiuresisDIV').show();
		$('#otherUPDAnuriaDIV').hide();
		$('#otherUPDAnuriaInput').val('');
	}else if(p1 == 3){
		$('#otherUPDAnuriaDIV').show();
		$('#otherUPDDiuresisDIV').hide();
		$('#otherUPDDiuresisInput').val('');
	} else {
		$('#otherUPDDiuresisDIV').hide();
		$('#otherUPDAnuriaDIV').hide();
		$('#otherUPDAnuriaInput').val('');
		$('#otherUPDDiuresisInput').val('');
	}
});

//排尿相关症状
$('#micturitionRelatedSymptomsCheckbox').click(function(){
	if($('#micturitionRelatedSymptomsCheckbox').is(':checked')) {
		$('#micturitionRelatedSymptomsDIV').show();
	}else{
		$('#micturitionRelatedSymptomsDIV').hide();
		$('#micturitionRelatedSymptomsSelect').get(0).selectedIndex=0;
	}
});

//疼痛
$('#painCheckbox').click(function(){
	if($('#painCheckbox').is(':checked')) {
		$('#painDIV').show();
	}else{
		$('#painDIV').hide();
		$('#painContinueTimeDIV').hide();
		$('#painContinueTime').val("");
		$('#continuousOrIntermittentSelect').get(0).selectedIndex=0;
		$('#relationshipBetweenEatingAndEatingSelect').get(0).selectedIndex=0;
		$('#painPropertySelect').get(0).selectedIndex=0;
		$('#painSelect').get(0).selectedIndex=0;
	}
});
//疼痛
$('#painSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1 == 6){
		$('#painContinueTimeDIV').show();
		
	} else {
		$('#painContinueTimeDIV').hide();
		$('#painContinueTime').val('');
		$('#continuousOrIntermittentSelect').get(0).selectedIndex=0;
		$('#relationshipBetweenEatingAndEatingSelect').get(0).selectedIndex=0;
		$('#painPropertySelect').get(0).selectedIndex=0;
	}
});

//持续性还是间歇性 
$('#continuousOrIntermittentSelect').click(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1==2){
		$('#continuousOrIntermittentDIV').show();
	} else {
		$('#continuousOrIntermittentDIV').hide();
		$('#relationshipBetweenEatingAndEatingSelect').get(0).selectedIndex=0;
		$('#painPropertySelect').get(0).selectedIndex=0;
	}
});

$('#notAllAboveCheckbox').click(function(){
	
	if($('#notAllAboveCheckbox').is(':checked')) {
		$('#notAllAboveDIV').show();
	} else {
		$('#notAllAboveDIV').hide();
		$('#notAllAbove').val('');
	}
});


function setTimeEmpty(elementName){
	var date = new Date();
	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
	var elementId = "#" + elementName;
	$(elementId).val(dateString);
}

$('#btnMainSuitDelete').click(function(){
    	$('#mainSuitLI2').hide();
    	setTimeEmpty("diseaseTime2");
    	$("#mainSuit2Select ").get(0).selectedIndex=0;
});
$('#btnSureBirthDay').click(function(){
		var birthDay = $("#realBirthDay").val();
		if(birthDay == "" || birthDay == undefined || birthDay == null){
			$("#ageValue").text("");
			$("#ageText").text("");
			alert("请选择出生日期时间");
			return ;
		}
		var now = new Date();
		var date = new Date(birthDay);
		// 调用日期差方法，求得参数日期与系统时间相差的天数
		var diff = now.diff(date);
		if(diff < 0){
			$("#ageValue").text("");
			alert("出生日期时间不能超过今天");
			return ;
		}
		if(diff < 24){
			$("#ageValue").text(parseInt(diff));
			$("#ageText").text("小时");
		}else if(diff < (24 * 7)){
			var date = diff / 24;
			$("#ageValue").text(parseInt(date));
			$("#ageText").text("天");
		}else if(diff < (24 * 30)){
			var date = diff / (24 * 7);
			$("#ageValue").text(date.toFixed(1));
			$("#ageText").text("周");
		}else if(diff < (24 * 365)){
			var date = diff / (24 * 30);
			$("#ageValue").text(date.toFixed(1));
			$("#ageText").text("月");
		}else {
			var date = diff / (24 * 365);
			$("#ageValue").text(date.toFixed(1));
			$("#ageText").text("年");
		}
});
Date.prototype.diff = function(date){
	  return (this.getTime() - date.getTime())/(60 * 60 * 1000);
	}
