
$(function(){
	
    var firstTimeMenstrualAgeSelect=$("#firstTimeMenstrualAgeSelect");
    var menstrualDaySelect=$("#menstrualDaySelect");
    var twoMenstrualIntervalSelect=$("#twoMenstrualIntervalSelect");
    for(var i=0;i<=30;i++){
    	if(i == 0){
            var $temp=$("<option value=\"" + i + "\">"+ "-----请选择-----" +"</option>");
            firstTimeMenstrualAgeSelect.append($temp);
    	}else{
    		var $temp=$("<option value=\"" + i + "\">" + i + "</option>");
    		firstTimeMenstrualAgeSelect.append($temp);
    	}
    }
    for(var i=0;i<=30;i++){
    	if(i == 0){
            var $temp=$("<option value=\"" + i + "\">"+ "-----请选择-----" +"</option>");
            menstrualDaySelect.append($temp);
    	}else{
    		var $temp=$("<option value=\"" + i + "\">" + i + "</option>");
    		menstrualDaySelect.append($temp);
    	}
    }
    for(var i=0;i<=30;i++){
    	if(i == 0){
            var $temp=$("<option value=\"" + i + "\">"+ "-----请选择-----" +"</option>");
            twoMenstrualIntervalSelect.append($temp);
    	}else{
    		var $temp=$("<option value=\"" + i + "\">" + i + "</option>");
    		twoMenstrualIntervalSelect.append($temp);
    	}
    }
});
//保存月经史
$('#saveMenstrualHistoryModel').click(function(){
	
	var firstMenstrualAge = $("#firstTimeMenstrualAgeSelect").find("option:selected").val();
	var howManyDayMenstrual = $("#menstrualDaySelect").find("option:selected").val();
	var twoMenstrualIntervals = $("#twoMenstrualIntervalSelect").find("option:selected").val();
	var lastMenstrualPeriod = $('#recentlyMenstrualDay').val();
	if(!timeIsRight2(lastMenstrualPeriod)){
		return;
	}
	if(firstMenstrualAge == 0){
		alert("请选择第一次来月经的年龄");
		return;
	}
	if(howManyDayMenstrual == 0){
		alert("请选择月经总共来天数");
		return;
	}
	if(twoMenstrualIntervals == 0){
		alert("请选择两次月经间隔");
		return;
	}
	var serialNo     = $('#serialNo').text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/saveMenstrualHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		lastMenstrualPeriod: lastMenstrualPeriod ,
    		firstMenstrualAge: firstMenstrualAge ,
    		howManyDayMenstrual: howManyDayMenstrual ,
    		twoMenstrualIntervals: twoMenstrualIntervals
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


//删除月经史
$('#deleteMenstrualHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deleteMenstrualHistory.action',// 跳转到 action  
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