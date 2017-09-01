//保存月经史
$('#saveBirthHistoryModel').click(function(){
	
	var pregnancyTime = $("#pregnancyTime").val();
	var deliveryTime = $("#deliveryTime").val();
	if(isNaN(pregnancyTime) || isNaN(deliveryTime)){
		alert("请填写数字");
		return;
	}
	if(pregnancyTime == ""){
		alert("请填写怀孕过次数");
		return;
	}
	if(deliveryTime == ""){
		alert("请填写分娩过次数");
		return;
	}
	var serialNo     = $('#serialNo').text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/saveBirthHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		howManyTimesPregnant: pregnancyTime ,
    		howManyTimesDelivered: deliveryTime 
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("保存成功！");  
	            window.location.href='user/index.html#birthHistoryHead';
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


//删除生育史
$('#deleteBirthHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deleteBirthHistory.action',// 跳转到 action  
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
		            window.location.href='user/index.html#birthHistoryHead';
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