
//最近半年体重改变
$('#leastHalfYearWeightChangeSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值 
	if(p1==2){
		$('#leastHalfYearWeightChangeDIV').show();
	} else {
		$('#leastHalfYearWeightChangeDIV').hide();
		$('#leastHalfYearWeightChangeInput').val('');
	}
});


//保存其他症状信息
$('#saveOtherSymptom').click(function(){
	var howTheMind = $("#mindSelect").find("option:selected").val();
	if(howTheMind==0){
		alert("请选择精神如何");
		return;
	}
	var howTheAppetite = $("#appetiteSelect").find("option:selected").val();
	if(howTheAppetite==0){
		alert("请选择食欲如何");
		return;
	}
	var howTheSleep = $("#sleepSelect").find("option:selected").val();
	if(howTheSleep==0){
		alert("请选择睡眠如何");
		return;
	}
	var leastHalfYearWeightChangeType = $("#leastHalfYearWeightChangeSelect").find("option:selected").val();
	if(leastHalfYearWeightChangeType==0){
		alert("请选择最近半年来体重变化如何");
		return;
	}
	var leastHalfYearWeightDown = 0.0;
	if(leastHalfYearWeightChangeType == 2){
		leastHalfYearWeightDown = $("#leastHalfYearWeightChangeInput").val();
		if(isNaN(leastHalfYearWeightDown)){
			alert("体重只能输入数字");
			return;
		}
	}
	var serialNo     = $('#serialNo').text();
	
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/saveOtherSymptom.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		//精神
    		howTheMind: howTheMind,
    		//食欲
    		howTheAppetite: howTheAppetite,
    		//睡眠
    		howTheSleep: howTheSleep,
    		//体重
    		leastHalfYearWeightChangeType: leastHalfYearWeightChangeType, 
    		//减轻量
    		weightDown: leastHalfYearWeightDown
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            alert("保存成功！");  
	            window.location.href='user/index.html#otherSymptomHead';
	            window.location.reload();
	        }else{  
	        	alert(data.message);  
	        	if(data.position=="sessionOut"){
	        		window.location.href='user/index.html';
	        	}
	        }  
	     },  
	     error : function() {  
	          alert("异常！");  
	     }  
	});
	
});


//删除其他症状信息
$('#deleteOtherSymptom').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deleteOtherSymptom.action',// 跳转到 action  
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
		            window.location.href='user/index.html#otherSymptomHead';
		            window.location.reload();
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

