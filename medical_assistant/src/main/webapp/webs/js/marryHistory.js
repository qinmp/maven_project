
//保存婚姻史
$('#saveMarryHistoryModel').click(function(){
	var marryType = $("#marryHistorySelect").find("option:selected").val();
	if(marryType == 0){
		alert("请选择是否结过婚");
		return;
	}
	
	var serialNo     = $('#serialNo').text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/saveMarryHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		marryType: marryType 
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("保存成功！");  
	            window.location.href='user/index.html#marryHistoryHead';
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

//删除婚姻史
$('#deleteMarryHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deleteMarryHistory.action',// 跳转到 action  
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
		            window.location.href='user/index.html#marryHistoryHead';
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