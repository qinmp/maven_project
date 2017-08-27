
//食物药物过敏史
$('#drugAllergySelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==1){
		$('#hasDrugAllergyDIV').show();
	} else {
		$('#hasDrugAllergyDIV').hide();
		$('#DrugAllergyMedicineName').val('');
	}
});

//手术史
$('#operationHistorySelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==1){
		$('#hasOperationHistoryDIV').show();
	} else {
		$('#hasOperationHistoryDIV').hide();
		$('#operationName').val('');
    	var date = new Date();
    	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
    	$("#operationTime").val(dateString);
	}
});

//输血史
$('#transfusionHistorySelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==1){
		$('#hasTransfusionHistoryDIV').show();
	} else {
		$('#hasTransfusionHistoryDIV').hide();
		$('#transfusionOperationName').val('');
    	var date = new Date();
    	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
    	$("#transfusionTime").val(dateString);
	}
});

//病史回顾
//尚未治愈的疾病
$('#untreatedDiseaseHistorySelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==1){
		$('#hasUntreatedDiseaseHistoryDIV').show();
	} else {
		$('#hasUntreatedDiseaseHistoryDIV').hide();
		$('#untreatedDiseaseName').val('');
    	var date = new Date();
    	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
    	$("#untreatedDiseaseTime").val(dateString);
	}
});

//正在服用的药物
$('#hasDrugsBeingUsedSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==1){
		$('#hasDrugsBeingUsedDIV').show();
	} else {
		$('#hasDrugsBeingUsedDIV').hide();
		$('#drugsBeingUsedName').val('');
    	var date = new Date();
    	var dateString = date.getFullYear()+"/"+(date.getMonth()+1)+"/"+date.getDate();
    	$("#drugsBeingUsedTime").val(dateString);
	}
});


//保存既往史
$('#savePastHistoryModel').click(function(){
	//过敏药物
	var drugAllergyType = $("#drugAllergySelect").find("option:selected").val();
	var drugName = $("#DrugAllergyMedicineName").val();
	if(drugAllergyType==0){
		alert('请选择是否有药物过敏');
		return;
	}
	if(drugAllergyType==1){
		if(drugName==''){
			alert('	请填写过敏药物名称');
			return;
		}
	}
	//手术历史
	var operationHistoryType = $("#operationHistorySelect").find("option:selected").val();
	var operationName = $("#operationName").val();
	var operationTime = $("#operationTime").val();
	if(operationHistoryType==0){
		alert('请选择是否有过手术史');
		return;
	}
	if(operationHistoryType==1){
		if(!timeIsRight(operationTime)){
			return;
		}
		if(operationName==''){
			alert('	请填写手术名称');
			return;
		}
	} 
	//输血历史
	var transfusionHistoryType = $('#transfusionHistorySelect').find("option:selected").val();
	var transfusionTime = $("#transfusionTime").val();
	var transfusionOperationName = $("#transfusionOperationName").val();
	if(transfusionHistoryType==0){
		alert('请选择是否有过输血历史');
		return;
	}
	if(transfusionHistoryType==1){
		if(!timeIsRight(transfusionTime)){
			return;
		}
		if(transfusionOperationName==''){
			alert('	请填写手术名称');
			return;
		}
	}
	
	//传染病史
	//乙肝病史
	var hepatitisBHistoryType = $('#hepatitisBHistorySelect').find("option:selected").val();
	if(hepatitisBHistoryType==0){
		alert('请选择是否有过乙肝病史');
		return;
	}
	//结核病史
	var tuberculosisHistoryType = $('#tuberculosisHistorySelect').find("option:selected").val();
	if(tuberculosisHistoryType==0){
		alert('请选择是否有过结核病史');
		return;
	}
	
	//尚未治愈的疾病
	var untreatedDiseaseHistoryType = $('#untreatedDiseaseHistorySelect').find("option:selected").val();
	var untreatedDiseaseTime = $('#untreatedDiseaseTime').val();
	var untreatedDiseaseName = $('#untreatedDiseaseName').val();
	if(untreatedDiseaseHistoryType == 0){
		alert('请选择是否有尚未治愈的疾病');
		return;
	}
	if(untreatedDiseaseHistoryType == 1){
		if(!timeIsRight(untreatedDiseaseTime)){
			return;
		}
		if(untreatedDiseaseName==''){
			alert('	请填写未治愈的疾病名称');
			return;
		}
	}
	
	//正在服用药物
	var hasDrugsBeingUsedType = $('#hasDrugsBeingUsedSelect').find("option:selected").val();
	var drugsBeingUsedTime = $('#drugsBeingUsedTime').val();
	var drugsBeingUsedName = $('#drugsBeingUsedName').val();
	if(hasDrugsBeingUsedType == 0){
		alert('请选择是否有正在服用的药物');
		return;
	}
	if(hasDrugsBeingUsedType == 1){
		if(!timeIsRight(drugsBeingUsedTime)){
			return;
		}
		if(drugsBeingUsedName==''){
			alert('	请填写正在服用药物名称');
			return;
		}
	}
	
	
	var serialNo     = $('#serialNo').text();
	
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/savePastHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		//过敏药物
    		drugAllergyType: drugAllergyType,
    		drugName: drugName,
    		
    		//手术历史
    		operationHistoryType: operationHistoryType,
    		operationTime: operationTime, 
    		operationName: operationName,
    		
    		//输血历史
    		transfusionHistoryType: transfusionHistoryType, 
    		transfusionTime: transfusionTime,
    		transfusionOperationName: transfusionOperationName,
    		

    		//乙肝病史
    		hepatitisBHistoryType: hepatitisBHistoryType,
    		//结核病史
    		tuberculosisHistoryType: tuberculosisHistoryType,
    		
    		//尚未治愈的疾病
    		untreatedDiseaseHistoryType:untreatedDiseaseHistoryType,
    		untreatedDiseaseTime: untreatedDiseaseTime,
    		untreatedDiseaseName: untreatedDiseaseName,
    		
    		//正在服用药物
    		hasDrugsBeingUsedType: hasDrugsBeingUsedType,
    		drugsBeingUsedTime: drugsBeingUsedTime,
    		drugsBeingUsedName: drugsBeingUsedName
    		
    		
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


//删除既往史
$('#deletePastHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deletePastHistory.action',// 跳转到 action  
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

