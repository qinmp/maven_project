//家庭史
$('#familyHistorySelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1 == 2){
		$('#FamilyHistoryDIV').show();
	} else{
		$('#FamilyHistoryDIV').hide();
		$('#hasSimilarIllnessInput').val('');
	}
});
$('#familyHistory2Select').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1 == 2){
		$('#FamilyHistory2DIV').show();
	} else {
		$('#FamilyHistory2DIV').hide();
		$('#hasHeredityIllnessInput').val('');
	}
});


//保存家庭史
$('#saveFamilyHistoryModel').click(function(){
	
	var similarDiseaseType = $("#familyHistorySelect").find("option:selected").val();
	var similarDiseaseName = $('#hasSimilarIllnessInput').val();
	if(similarDiseaseType == 0){
		alert("请选择两系三代家族中是否有类似的疾病");
		return;
	} else if(similarDiseaseType == 1){
		similarDiseaseName = "";
	} else if(similarDiseaseType == 2){
		if(similarDiseaseName == ""){
			alert("请填写类似疾病名称");
			return;
		}
	}	
	
	var hereditaryDisease = $("#familyHistory2Select").find("option:selected").val();
	var hereditaryDiseaseName = $('#hasHeredityIllnessInput').val();
	if(hereditaryDisease == 0){
		alert("请选择两系三代家族中是否有其他遗传性疾病");
		return;
	} else if(hereditaryDisease == 1){
		hereditaryDiseaseName = "";
	} else if(hereditaryDisease == 2){
		if(hereditaryDiseaseName == ""){
			alert("请填写遗传病名称");
			return;
		}
	}
	
	var serialNo     = $('#serialNo').text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/saveFamilyHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		similarDiseaseType: similarDiseaseType ,
    		similarDiseaseName: similarDiseaseName ,
    		hereditaryDisease: hereditaryDisease ,
    		hereditaryDiseaseName: hereditaryDiseaseName
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

//删除家族史
$('#deleteFamilyHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deleteFamilyHistory.action',// 跳转到 action  
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