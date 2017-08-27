//保存基本信息
$('#savePresentIllness').click(function(){
	var serialNo     = $('#serialNo').text();
	//发热最低温度，限定为double型
	var lowDegree         = $('#lowDegree').val();
	if($('#feverCheckbox').is(':checked')) {
		if(isNaN(lowDegree) || lowDegree==''){
			alert("最低温度请输入数字");
			return;
		}
		if(lowDegree == 0){
			alert("请输入正常体温");
			return;
		}
	 }else {
		 lowDegree = '0';
	 }
	
	//发热最高温度，限定为double型
	var hightDegree         = $('#hightDegree').val();
	if($('#feverCheckbox').is(':checked')) {
		if(isNaN(hightDegree) || hightDegree==''){
			alert("最高温度请输入数字");
			return;
		}
		if(hightDegree == 0){
			alert("请输入正常体温");
			return;
		}
	 }else {
		 hightDegree = '0';
	 }

	//咳嗽开始时间
	var coughStartTime = $('#coughStartTime').val();
	if($('#coughCheckbox').is(':checked')) {
		if(!timeIsRight(coughStartTime)){
			return;
		}
	 }else {
		 coughStartTime = '';
	 }
	//咳痰颜色
	var expectorationSelect  = $("#expectorationSelect").find("option:selected").val();
	if($('#expectorationCheckbox').is(':checked')) {
		if(expectorationSelect==0){
			alert("请选择咳痰颜色");
			return;
		}
	 }else {
		 expectorationSelect = 0;
	 }
	
	//呕吐
	var vomitSelect      = $("#vomitSelect").find("option:selected").val();
	if($('#vomitCheckbox').is(':checked')) {
		if(vomitSelect == 0){
			alert("请选择呕吐类型");
			return;
		}
	 }else {
		 vomitSelect = 0;
	 }
	
	//腹泻
	var diarrheaSelect          = $("#diarrheaSelect").find("option:selected").val();
	//腹泻开始时间
	var diarrheaContinueTime = $("#diarrheaContinueTime").val();
	//每日3次（含）以下
	var diarrheaNotMoreThan3Times = $("#diarrheaNotMoreThan3Times").val();
	if($('#diarrheaCheckbox').is(':checked')) {
		if(diarrheaSelect == 0){
			alert("请选择腹泻类型");
			return;
		}
		//每日腹泻次数三次以上
		if(diarrheaSelect == 1){
			diarrheaNotMoreThan3Times = '0';
			if(!timeIsRight(diarrheaContinueTime)){
				return;
			}
			//每日腹泻次数三次以下
		}else if(diarrheaSelect == 2){
			diarrheaContinueTime = '';
			if(isNaN(diarrheaNotMoreThan3Times) || diarrheaNotMoreThan3Times==''){
				alert("每日腹泻次数请输入数字");
				return;
			}
			if(diarrheaNotMoreThan3Times > 3 ){
				alert("每日腹泻次数不能超过三次");
				return;
			}
			if(diarrheaNotMoreThan3Times == 0 ){
				alert("每日腹泻次数不能零次");
				return;
			}
		}
	 }else {
		 diarrheaSelect = 0;
		 diarrheaContinueTime = '';
		 diarrheaNotMoreThan3Times = '0';
	 }
	
	
	//便秘时间类型
	var astrictionSelect = $("#astrictionSelect").val();
	//便秘每周次数 ， 少于3次 或者 达到三次
	var isMoreThanThreeTimesSelect = $("#isMoreThanThreeTimesSelect").val();
	if($('#astrictionCheckbox').is(':checked')) {
		if(astrictionSelect == 0){
			alert("请选择便秘时间");
			return;
		}
		if(astrictionSelect == 2){
			if(isMoreThanThreeTimesSelect == 0){
				alert("请选择每周排便次数");
				return;
			}
		}

	}else {
		astrictionSelect = 0;
		isMoreThanThreeTimesSelect = 0;
	}
	
	//便血颜色
	var hematocheziaSelect = $("#hematocheziaSelect").find("option:selected").val();
	if($('#hematocheziaCheckbox').is(':checked')) {
		if(hematocheziaSelect == 0){
			alert("请选择便血颜色");
			return;
		}
	}else {
		hematocheziaSelect = 0;
	}
	
	
	//肥胖，当前体重
	var fatCurrentWeight = $("#fatCurrentWeight").val();
	//当前身高
	var fatHight = $("#fatHight").val();
	//体质量指数BMI
	var fatWeightBMI = $("#fatWeightBMI").val();
	if($('#fatCheckbox').is(':checked')) {
		if(isNaN(fatCurrentWeight)|| fatCurrentWeight == ''){
			alert("当前体重,请填写数字");
			return;
		}
		if(isNaN(fatHight)|| fatHight == ''){
			alert("当前身高,请填写数字");
			return;
		}
		if(fatHight >= 2.5){
			alert("身高不能大于2.5米");
			return;
		}
		if(isNaN(fatWeightBMI)|| fatWeightBMI == ''){
			alert("请计算体质量指数BMI");
			return;
		}
	}else {
		fatCurrentWeight = 0;
		fatHight = 0;
		fatWeightBMI = 0;
	}

	//消瘦，当前体重
	var marasmusCurrentWeight = $("#marasmusCurrentWeight").val();
	//当前身高
	var marasmusHight = $("#marasmusHight").val();
	//体质量指数BMI
	var marasmusWeightBMI = $("#marasmusWeightBMI").val();
	//半年内体重减轻
	var marasmusWeightDown = $("#marasmusWeightDown").val();
	if($('#marasmusCheckbox').is(':checked')) {
		if(isNaN(marasmusCurrentWeight)|| marasmusCurrentWeight == ''){
			alert("当前体重,请填写数字");
			return;
		}
		if(isNaN(marasmusHight)|| marasmusHight == ''){
			alert("当前身高,请填写数字");
			return;
		}
		if(isNaN(marasmusWeightBMI)|| marasmusWeightBMI == ''){
			alert("请计算体质量指数BMI");
			return;
		}
		if(isNaN(marasmusWeightDown)|| marasmusWeightDown == ''){
			alert("半年内减轻体重量,请填写数字");
			return;
		}
	}else {
		marasmusCurrentWeight = 0;
		marasmusHight = 0;
		marasmusWeightBMI = 0;
		marasmusWeightDown = 0;
	}
	
	//头晕 类型
	var dizzyType = $("#dizzySelect").find("option:selected").val();
	if($('#dizzyCheckbox').is(':checked')) {
		if(dizzyType == 0){
			alert("请选择头晕类型");
			return;
		}
	} else {
		dizzyType = 0;
	}
	
	//皮肤异常类型
	var abnormalSkinType = $("#abnormalSkinSelect").find("option:selected").val();
	//四肢躯干 皮肤异常类型
	var limbsTrunkType = $("#limbsTrunkSelect").find("option:selected").val();
	//其他皮肤症状
	var limbsTrunkOtherInput = $("#limbsTrunkOtherInput").val();
	if($('#abnormalSkinCheckbox').is(':checked')) {
		if(abnormalSkinType == 0){
			alert("请选择皮肤异常类型");
			return;
		}
		//如果是四肢躯干
		if(abnormalSkinType == 6){
			if(limbsTrunkType == 0){
				alert("请选择四肢躯干皮肤异常类型");
				return;
			}
			if(limbsTrunkType == 3){
				if(limbsTrunkOtherInput == ''){
					alert("请填写四肢躯干其他异常类型");
					return;
				}
			}else{
				limbsTrunkOtherInput = '';
			}
		} else {
			limbsTrunkType = 0;
			limbsTrunkOtherInput = '';
		}

	} else {
		abnormalSkinType = 0;
		limbsTrunkType = 0;
		limbsTrunkOtherInput = '';
	}
	
	//少尿，一日尿量，整型，毫升
	var UPDInput = $("#UPDInput").val();
	if($('#oliguresisCheckbox').is(':checked')) {
		//判断浮点数正则
		if(isNaN(UPDInput) || UPDInput == ''){
			alert("尿量只能输入数字");
			return;
		}
		if(UPDInput == 0){
			alert('不能输入0尿量');
			return;
		}
		if(UPDInput.indexOf(".")!=-1){
			alert('请输入整数');
			return;
		}
	} else {
		UPDInput = '0';
	}
	
	//其他尿量相关症状类型
	var otherUPDSymptomType = $("#otherUPDSymptomSelect").find("option:selected").val();
	//多尿一日尿量 整型，毫升
	var otherUPDDiuresisInput = $("#otherUPDDiuresisInput").val();
	//少尿一日尿量 整型，毫升
	var otherUPDAnuriaInput = $("#otherUPDAnuriaInput").val();
	if($('#otherUPDSymptomCheckbox').is(':checked')) {
		if(otherUPDSymptomType == 0){
			alert("请选择其他尿量相关症状类型");
			return;
		}
		if(otherUPDSymptomType == 2){
			otherUPDAnuriaInput = '0';
			if(isNaN(otherUPDDiuresisInput) || otherUPDDiuresisInput == ''){
				alert("请填写多尿尿量");
				return;
			}
		} else if(otherUPDSymptomType == 3){
			otherUPDDiuresisInput = '0';
			if(isNaN(otherUPDAnuriaInput) || otherUPDAnuriaInput == ''){
				alert("请填写少尿尿量");
				return;
			}
		} else {
			otherUPDDiuresisInput = '0';
			otherUPDAnuriaInput = '0';
		}
		if(otherUPDDiuresisInput.indexOf(".")!=-1){
			alert('多尿尿量请输入整数');
			return;
		}
		if(otherUPDAnuriaInput.indexOf(".")!=-1){
			alert('少尿尿量请输入整数');
			return;
		}
	} else {
		otherUPDSymptomType = '0';
		otherUPDDiuresisInput = '0';
		otherUPDAnuriaInput = '0';
	}
	
	
	//排尿相关症状类型
	var micturitionRelatedSymptomsType = $("#micturitionRelatedSymptomsSelect").find("option:selected").val();
	if($('#micturitionRelatedSymptomsCheckbox').is(':checked')) {
		if(micturitionRelatedSymptomsType == 0){
			alert("请选择排尿相关症状类型");
			return;
		}
	} else {
		micturitionRelatedSymptomsType = 0;
	}
	
	//疼痛相关类型
	var painType = $("#painSelect").find("option:selected").val();
	//持续时间，小时
	var painContinueTime = $("#painContinueTime").val();
	//持续性，还是间歇性类型
	var continuousOrIntermittentType = $("#continuousOrIntermittentSelect").find("option:selected").val();
	//与进食的关系如何
	var relationshipBetweenEatingAndEatingType = $("#relationshipBetweenEatingAndEatingSelect").find("option:selected").val();
	//疼痛的性质类型
	var painPropertyType = $("#painPropertySelect").find("option:selected").val();

	if($('#painCheckbox').is(':checked')) {
		if(painType == 0){
			alert("请选择疼痛相关类型");
			return;
		}
		//腹痛
		if(painType == 6){
			if(!timeIsRight(painContinueTime)){
				painContinueTime = '';
				continuousOrIntermittentType = 0;
				relationshipBetweenEatingAndEatingType = 0;
				painPropertyType = 0;
				return ;
			} else {
				if(continuousOrIntermittentType == 0){
					alert("请选择持续性还是间歇性");
					return;
				} else {
					//间歇性
					if(continuousOrIntermittentType == 2){
						if(relationshipBetweenEatingAndEatingType == 0){
							alert("请选择与进食的关系");
							return;
						}
						if(painPropertyType == 0){
							alert("请选择疼痛的性质");
							return;
						}
					} else{
						relationshipBetweenEatingAndEatingType = 0;
						painPropertyType = 0;
					}
				}
			}
			
			
		} else{
			painContinueTime = '';
			continuousOrIntermittentType = 0;
			relationshipBetweenEatingAndEatingType = 0;
			relationshipBetweenEatingAndEatingType = 0;
			painPropertyType = 0;
		}
	} else {
		painType = 0;
		painContinueTime = '';
		continuousOrIntermittentType = 0;
		relationshipBetweenEatingAndEatingType = 0;
		relationshipBetweenEatingAndEatingType = 0;
		painPropertyType = 0;
		
	}

	//呕血
	var haematemesis = 0;
	if($('#haematemesisCheckbox').is(':checked')) {
		haematemesis = 1;
	} else {
		haematemesis = 0;
	}
	//咯血
	var hemoptysis = 0;
	if($('#hemoptysisCheckbox').is(':checked')) {
		hemoptysis = 1;
	} else {
		hemoptysis = 0;
	}
	
	//呼吸困难
	var dyspnea = 0;
	if($('#DyspneaCheckbox').is(':checked')) {
		dyspnea = 1;
	} else {
		dyspnea = 0;
	}
	//心悸
	var palpitation = 0;
	if($('#palpitationCheckbox').is(':checked')) {
		palpitation = 1;
	} else {
		palpitation = 0;
	}
	//水肿
	var edema = 0;
	if($('#edemaCheckbox').is(':checked')) {
		edema = 1;
	} else {
		edema = 0;
	}
	//抽搐与惊厥
	var ticAndConvulsion = 0;
	if($('#ticAndConvulsionCheckbox').is(':checked')) {
		ticAndConvulsion = 1;
	} else {
		ticAndConvulsion = 0;
	}
	//意识障碍
	var consciousnessDisorder = 0;
	if($('#consciousnessDisorderCheckbox').is(':checked')) {
		consciousnessDisorder = 1;
	} else {
		consciousnessDisorder = 0;
	}
	//情感症状
	var affectiveSymptoms = 0;
	if($('#affectiveSymptomsCheckbox').is(':checked')) {
		affectiveSymptoms = 1;
	} else {
		affectiveSymptoms = 0;
	}
	//以上都不是
	var notAllAbove = 0;
	var other_problem = '';
	if($('#notAllAboveCheckbox').is(':checked')) {
		notAllAbove = 1;
		other_problem = $('#notAllAbove').val();
	} else {
		notAllAbove = 0;
		other_problem = '';
	}
	
	//1.$.ajax带json数据的异步请求
	var aj = $.ajax( {  
	    url:'user/savePresentIllness.action',// 跳转到 action
	    data:{  
	    		//序列号
	    		serialNo: serialNo,
	    		//发烧最/低高温度
	    		hightDegree : hightDegree,  
	    		lowDegree : lowDegree,
	    		//咳嗽开始时间
	    		coughStartTime : coughStartTime,  
	    		//咳痰
	    		expectoration : expectorationSelect,  
	    		//呕吐
	    		vomit : vomitSelect, 
	    		//腹泻 类型
	    		diarrheaType : diarrheaSelect,
	    		//腹泻持续时间
	    		diarrheaContinueTime : diarrheaContinueTime,
	    		//每天三次以下，一天几次
	    		times:diarrheaNotMoreThan3Times,
	    		//便秘类型
	    		astrictionType: astrictionSelect,
	    		//便秘每周次数类型
	    		astrictionTimesOfWeekType: isMoreThanThreeTimesSelect,
	    		//便血颜色
	    		hematocheziaType: hematocheziaSelect,
	    		//肥胖，当前体重
	    		fatCurrentWeight: fatCurrentWeight,
	    		//身高
	    		fatHight: fatHight,
	    		//体重BMI
	    		fatWeightBMI: fatWeightBMI,
	    		//消瘦，当前体重
	    		marasmusCurrentWeight: marasmusCurrentWeight ,
	    		//身高
	    		marasmusHight: marasmusHight,
	    		//体重BMI
	    		marasmusWeightBMI: marasmusWeightBMI,
	    		//半年内体重减轻多少千克
	    		marasmusWeightDown: marasmusWeightDown,
	    		//头晕
	    		dizzyType: dizzyType,
	    		//皮肤出现异常类型
	    		abnormalSkinType: abnormalSkinType,
	    		//皮肤出现异常, 四肢躯干皮肤异常类型
	    		limbsTrunkAbnormalSkinType: limbsTrunkType,
	    		//其他皮肤异常
	    		otherAbnormalSkin: limbsTrunkOtherInput,
	    		//少尿
	    		oliguresis: UPDInput,
	    		//其他尿量症状类型
	    		otherUPDSymptomType: otherUPDSymptomType,
	    		//多尿尿量
	    		otherUPDDiuresis: otherUPDDiuresisInput,
	    		//少尿尿量
	    		otherUPDAnuria: otherUPDAnuriaInput,
	    		//排尿相关症状类型
	    		micturitionRelatedSymptomsType: micturitionRelatedSymptomsType,
	    		//疼痛类型
	    		painType: painType,
	    		//腹痛持续时间
	    		painContinueTime: painContinueTime,
	    		//持续性还是间歇性类型
	    		continuousOrIntermittentType:continuousOrIntermittentType,
	    		//与进食关系如何类型
	    		relationshipBetweenEatingAndEatingType: relationshipBetweenEatingAndEatingType,
	    		//疼痛性质类型
	    		painPropertyType: painPropertyType,
	    		//呕血
	    		haematemesis: haematemesis,
    			//咯血
    			hemoptysis: hemoptysis,

    			//呼吸困难
    			dyspnea: dyspnea,

    			//心悸
    			palpitation: palpitation,

    			//水肿
    			edema: edema,

    			//抽搐与惊厥
    			ticAndConvulsion: ticAndConvulsion,

    			//意识障碍
    			consciousnessDisorder: consciousnessDisorder,

    			//情感症状
    			affectiveSymptoms: affectiveSymptoms,

    			//以上都不是
    			notAllAbove: notAllAbove,
    			other_problem: other_problem,
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
//消瘦BMI计算
$('#marasmusWeightBMIBtn').click(function(){
	//消瘦，当前体重
	var marasmusCurrentWeight = $("#marasmusCurrentWeight").val();
	if(isNaN(marasmusCurrentWeight) || marasmusCurrentWeight == ''){
		alert('请输入正确体重');
		return;
	}
	//当前身高
	var marasmusHight = $("#marasmusHight").val();
	if(isNaN(marasmusHight) || marasmusHight == ''){
		alert('请输入正确身高');
		return;
	}
	
	var bmi = marasmusCurrentWeight/(marasmusHight*marasmusHight);
	$('#marasmusWeightBMI').val(bmi.toFixed(2));
});
//肥胖BMI计算
$('#fatWeightBMIBtn').click(function(){
	//肥胖，当前体重
	var fatCurrentWeight = $("#fatCurrentWeight").val();
	if(isNaN(fatCurrentWeight) || fatCurrentWeight == ''){
		alert('请输入正确体重');
		return;
	}
	//当前身高
	var fatHight = $("#fatHight").val();
	if(isNaN(fatHight) || fatHight == ''){
		alert('请输入正确身高');
		return;
	}
	var bmi = fatCurrentWeight/(fatHight*fatHight);
	$('#fatWeightBMI').val(bmi.toFixed(2));
});
