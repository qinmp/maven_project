//吸烟史
$('#smokingSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==2){
		$('#personHistoryNotSmokingDIV').show();
		$('#personHistoryStillSmokingDIV').hide();
		$('#stillSmokingYearInput').val('');
		$('#everageSmoking2Input').val('');
	} else if(p1==3){
		$('#personHistoryStillSmokingDIV').show();
		$('#personHistoryNotSmokingDIV').hide();
		$('#notSmokingYearInput').val('');
		$('#hasSmokingYearInput').val('');
		$('#everageSmokingInput').val('');
	} else{
		$('#personHistoryStillSmokingDIV').hide();
		$('#personHistoryNotSmokingDIV').hide();
		$('#notSmokingYearInput').val('');
		$('#hasSmokingYearInput').val('');
		$('#everageSmokingInput').val('');
		$('#stillSmokingYearInput').val('');
		$('#everageSmoking2Input').val('');
	}
});

//喝酒史
$('#drinkSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==2){
		$('#personHistoryNotDrinkDIV').show();
		$('#personHistoryStillDrinkDIV').hide();
    	$("#drinkType2Select ").get(0).selectedIndex=0;
    	$('#stillDrinkYearInput').val('');
    	$('#everageDrink2Input').val('');
	} else if(p1==3){
		$('#personHistoryNotDrinkDIV').hide();
		$('#personHistoryStillDrinkDIV').show();
    	$("#drinkTypeSelect ").get(0).selectedIndex=0;
    	$('#hasDrinkYearInput').val('');
    	$('#everageDrinkInput').val('');
	} else{
		$('#personHistoryStillDrinkDIV').hide();
		$('#personHistoryNotDrinkDIV').hide();
    	$("#drinkTypeSelect ").get(0).selectedIndex=0;
    	$('#hasDrinkYearInput').val('');
    	$('#everageDrinkInput').val('');
    	$("#drinkType2Select ").get(0).selectedIndex=0;
    	$('#stillDrinkYearInput').val('');
    	$('#everageDrink2Input').val('');
	}
});

//曾到过疫地疫区生活吗
$('#epidemicAreaPlaceSelect').change(function(){
	var p1=$(this).children('option:selected').val();//这就是selected的值
	if(p1==2){
		$('#epidemicAreaPlaceDIV').show();
	} else {
		$('#epidemicAreaPlaceDIV').hide();
		$('#epidemicAreaPlaceInput').val('');
	}
});

//保存个人史
$('#savePersonHistoryModel').click(function(){
	//是否吸烟
	var notSmokingYear = 0;
	var hasSmokingYear = 0;
	var howManyCigaretteEachDay = 0;
	var smokingType = $("#smokingSelect").find("option:selected").val();
	if(smokingType == 0){
		alert("请选择是否吸烟");
		return;
	} else if(smokingType == 1){
		
	} else if(smokingType == 2){
		notSmokingYear = $("#notSmokingYearInput").val();
		hasSmokingYear = $('#hasSmokingYearInput').val();
		howManyCigaretteEachDay = $('#everageSmokingInput').val();
	} else if(smokingType == 3){
		hasSmokingYear = $('#stillSmokingYearInput').val();
		howManyCigaretteEachDay = $('#everageSmoking2Input').val();
	}
	//是否喝酒
	var notDrinkYear = 0;
	var alcoholType = 0;
	var hasDrinkYear = 0;
	var howManyDrinkEachDay = 0;
	var drinkType = $("#drinkSelect").find("option:selected").val();
	if(drinkType == 0){
		alert("请选择是否喝酒");
		return;
	} else if(drinkType == 1){
		
	} else if(drinkType == 2){
		notDrinkYear = $('#notDrinkYearInput').val();
		alcoholType = $('#drinkTypeSelect').find("option:selected").val();
		if(alcoholType == 0){
			alert("请选择喝酒类型");
			return;			
		}
		hasDrinkYear = $('#hasDrinkYearInput').val();
		howManyDrinkEachDay = $('#everageDrinkInput').val();
	} else if(drinkType == 3){
		alcoholType = $('#drinkType2Select').find("option:selected").val();
		if(alcoholType == 0){
			alert("请选择喝酒类型");
			return;			
		}
		hasDrinkYear = $('#stillDrinkYearInput').val();
		howManyDrinkEachDay = $('#everageDrink2Input').val();
	}
	//曾到过疫地疫区生活吗?
	var hasLifeEpidemicArea = $('#epidemicAreaPlaceSelect').find("option:selected").val();
	if(hasLifeEpidemicArea == 0){
		alert("请选择是否到疫区生活过");
		return;
	}
	var epidemicAreaPlace = $('#epidemicAreaPlaceInput').val();
	if(hasLifeEpidemicArea == 2){
		if(epidemicAreaPlace == ''){
			alert("请填写疫区地址");
			return;		
		}
	}
	
	var serialNo     = $('#serialNo').text();
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( { 
		url:'user/savePersonHistory.action',// 跳转到 action
	    data:{  
    		//序列号
    		serialNo: serialNo,
    		smokingType: smokingType ,  
    		notSmokingYear: notSmokingYear , 
    		hasSmokingYear: hasSmokingYear , 
    		howManyCigaretteEachDay: howManyCigaretteEachDay , 
    		drinkType: drinkType , 
    		notDrinkYear: notDrinkYear , 
    		alcoholType: alcoholType , 
    		hasDrinkYear: hasDrinkYear , 
    		howManyDrinkEachDay: howManyDrinkEachDay , 
    		hasLifeEpidemicArea : hasLifeEpidemicArea  , 
    		epidemicAreaPlace: epidemicAreaPlace 
	    },  
	    type:'post',  
	    cache:false,  
	    dataType:'json',
	    success:function(data) {  
	        if(data.isSuccess ){  
	            // view("修改成功！");  
	            alert("保存成功！");  
	            window.location.href='user/index.html#personHistoryHead';
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

//删除个人史
$('#deletePersonHistoryModel').click(function(){
		var serialNo1     = $('#serialNo').text();
	    if(!confirm("是否删除")){
	       return;
	    }
		//1.$.ajax带json数据的异步请求
		var aj = $.ajax( {
		    url:'user/deletePersonHistory.action',// 跳转到 action  
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
		            window.location.href='user/index.html#personHistoryHead';
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