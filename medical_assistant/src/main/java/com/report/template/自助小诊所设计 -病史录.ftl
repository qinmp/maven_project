
<html>
<head>
	<base href="<%=basePath%>">
	<title>医疗小助手</title>
	<style type="text/css">
		body{text-align:center} 
		.basicInfo{text-align:left;}
		.mainSuit{text-align:left;}
		.presentIlliness{text-align:left;}
		.pastHistory{text-align:left;}
		.personHistory{text-align:left;}
		.marryHistory{text-align:left;}
		.familyHistory{text-align:left;}
		.menstrualHistory{text-align:left;}
		.birthHistory{text-align:left;}
		a{text-decoration:none;font-size:12px;}
		.txt{width:320px;border:1px solid #000;margin:0 auto;text-align:left;}
		.forgetpwdclass{font-size:12px;}
		.tips{font-size:9px;}
	</style>
</head>
<body>
<h4 class="headClass">病史录</h4>
<div class="basicInfo">
	<#if basicInfo??>
		<span >编号:${basicInfo.serialNo}</span><br>
		<span >记录时间:${basicInfo.createTime}</span><br>
		<span >姓名:${basicInfo.name}</span><br>
		<span >真实出生日期:${basicInfo.realBirthDay}</span><br>
		<span >年龄:${basicInfo.age}</span><br>
		<#if basicInfo.sex == 0>
			<span >性别:男</span><br>
		</#if>
		<#if basicInfo.sex == 1>
			<span >性别:女</span><br>
		</#if>
		<span >籍贯:${basicInfo.nativePlace}</span><br>
		<span >现居住地:${basicInfo.presentResidence}</span><br>
	</#if>
</div>
<br>
<div class="mainSuit">
	<span >主诉:</span><br>
	<#if mainSuits??>
		<#list mainSuits as model>
			<span >呈${model.mainSuitContent}于${model.attackTime}发病.</span><br>
		</#list>
	</#if>
</div>
<br>
<div class="presentIlliness">
	<#if presentIllnessModel??>
		<span >现病史:</span><br>
		<#if presentIllnessModel.fever??>
			<span>发热:</span><br>
			最低体温:<span>${presentIllnessModel.fever.lowestDegree}</span>摄氏度（℃）<br>
			最高体温:<span>${presentIllnessModel.fever.highestDegree}</span>摄氏度（℃）<br>
		</#if>
		
		<#if presentIllnessModel.cough??>
			<span>咳嗽:</span><br>
			呈<span style="color:red">${presentIllnessModel.cough.presentToUserStr}</span>咳嗽<span>${presentIllnessModel.cough.days}</span>天<br>
		</#if>
		
		<#if presentIllnessModel.tExpectoration??>
			<span>咳痰</span><br>
			咳痰颜色:<span>${presentIllnessModel.tExpectoration.colorFacet}</span><br>
		</#if>
		
		<#if presentIllnessModel.tVomit??>
			<span>呕吐</span><br>
			呕吐类型:<span>${presentIllnessModel.tVomit.vomitFacet}</span>
		</#if>
		
		<#if presentIllnessModel.tDiarrhea??>
			<span>腹泻</span><br>
			<#if presentIllnessModel.tDiarrhea.diarrheaFacet??>
				腹泻定义为:<span style="color:red">${presentIllnessModel.tDiarrhea.diarrheaFacet}</span><br>
			</#if>
			<#if presentIllnessModel.tDiarrhea.eachDayTime??>
				每日次数:<span>${presentIllnessModel.tDiarrhea.eachDayTime } 次/天。</span><br>
			</#if>
		</#if>
		
		<#if presentIllnessModel.tAstriction??>
			<span>便秘</span><br>
			便秘症状定义为:<span style="color:red">${presentIllnessModel.tAstriction.astrictionFacet}</span><br>
		</#if>
		
		<#if presentIllnessModel.tHematochezia??>
			<span>便血</span><br>
			颜色:<span >${presentIllnessModel.tHematochezia.hematocheziaFacet }</span><br>
			温馨提示:<span style="color:red">${presentIllnessModel.tHematochezia.noticeStr }</span><br>
		</#if>
		
		<#if presentIllnessModel.tFat??>
			<span>肥胖</span><br>
			<span>BMI值为:${presentIllnessModel.tFat.bmi }</span><br>
			肥胖症状定义为:<span style="color:red">${presentIllnessModel.tFat.fatFacet }</span><br>
			温馨提示:<span>${presentIllnessModel.tFat.noticeStr }</span><br>
		</#if>

		<#if presentIllnessModel.tMarasmus??>
			<span>消瘦</span><br>
			<span>BMI值为:${presentIllnessModel.tMarasmus.bmi }</span><br>
			消瘦症状定义为:<span style="color:red">${presentIllnessModel.tMarasmus.marasmusFacet }</span><br>
			温馨提示:<span>${presentIllnessModel.tMarasmus.noticeStr }</span><br>
			体重减轻量定义为:<span  style="color:red">${presentIllnessModel.tMarasmus.weightDownFacet }</span><br>
			温馨提示:<span>${presentIllnessModel.tMarasmus.weightDownnoticeStr }</span><br>
		</#if>

		<#if presentIllnessModel.tDizzy??>
			<span>头晕</span><br>
			<span>${presentIllnessModel.tDizzy.dizzyFacet }</span><br>
		</#if>
		
		<#if presentIllnessModel.tAbnormalskin??>
			<span>皮肤出现异常</span><br>
			<span>${presentIllnessModel.tAbnormalskin.abnormalSkinFacet }</span>
			<#if presentIllnessModel.tAbnormalskin.limbsTrunk != 0>
				<span>,${presentIllnessModel.tAbnormalskin.limbsTrunkFacet}</span>
			</#if>
		</#if>
		
		<#if presentIllnessModel.tOliguresis??>
			<span>少尿</span><br>
			<span>一日（24小时）尿量</span><span>${presentIllnessModel.tOliguresis.updSymptom }</span>毫升<br>
			<#if presentIllnessModel.tOliguresis.updSymptom lt 400>
				<span>症状定义为少尿</span>
			</#if>
		</#if>
		
		<#if presentIllnessModel.tOtherUpdSymptom??>
			<span>其他尿量相关症状</span><br>
			<span>${presentIllnessModel.tOtherUpdSymptom.updSymptomFacet }</span><br>
			<#if presentIllnessModel.tOtherUpdSymptom.updSymptom == 2 >
				一日（24小时）尿量<span>${presentIllnessModel.tOtherUpdSymptom.diuresisUpd } </span> 毫升<br>
			</#if>
			<#if presentIllnessModel.tOtherUpdSymptom.updSymptom == 3  >
				一日（24小时）尿量<span>${presentIllnessModel.tOtherUpdSymptom.anuriaUpd } </span> 毫升<br>
			</#if>
		</#if>

		<#if presentIllnessModel.tMicturition??>
			<span>排尿相关症状</span><br>
			<span>${presentIllnessModel.tMicturition.micturitionSymptomFacet }</span><br>
		</#if>
		
		<#if presentIllnessModel.tPain??>
			<span>疼痛</span><br>
			<span>${presentIllnessModel.tPain.painTypeFacet}</span><br>
			<#if presentIllnessModel.tPain.painType == 6  >
				腹痛持续时间:<span>${presentIllnessModel.tPain.painContinueTime}</span>天<br>
				持续性还是间歇性:<span>${presentIllnessModel.tPain.painContinuousOrIntermittentTypeFacet }</span><br>
				<#if presentIllnessModel.tPain.painContinuousOrIntermittentType == 2>
					与进食的关系如何:<span >${presentIllnessModel.tPain.relationshipBetweenEatingAndEatingTypeFacet}</span><br>
					疼痛的性质:<span >${presentIllnessModel.tPain.painPropertyTypeFacet}</span>
				</#if>
			</#if>
		</#if>

		<#if presentIllnessModel.tHaematemesis??>
			<span>呕血</span><br>
		</#if>

		<#if presentIllnessModel.tHemoptysis??>
			<span>咯血</span><br>
		</#if>

		<#if presentIllnessModel.tDyspnea??>
			<span>呼吸困难</span><br>
		</#if>

		<#if presentIllnessModel.tPalpitation??>
			<span>心悸</span><br>
		</#if>
		
		<#if presentIllnessModel.tEdema??>
			<span>水肿</span><br>
		</#if>
		
		<#if presentIllnessModel.ticAndConvulsion??>
			<span>抽搐与惊厥</span><br>
		</#if>

		<#if presentIllnessModel.tConsciousnessDisorder??>
			<span>意识障碍</span><br>
		</#if>

		<#if presentIllnessModel.tAffectiveSymptoms??>
			<span>情感症状</span><br>
		</#if>
		
		<#if presentIllnessModel.tNotAllAbove??>
			<span>其他问题</span><br>
			<span>${presentIllnessModel.tNotAllAbove.otherStr }</span>
		</#if>
		<span>无&nbsp</span><span>${notIncludePresents }等其他不适.</span>
		<#if otherSymptomModel??>
			<span>自发病以来，精神${otherSymptomModel.mindFacet}，食欲${otherSymptomModel.appetiteFacet}，睡眠${otherSymptomModel.sleepFacet}，
				大小便同上诉，体重变化${otherSymptomModel.weightChangeFacet}。</span>
		</#if>
	</#if>
</div>
<br>
<#if pastHistoryModel??>
	<div class="pastHistory">
		<span >既往史：</span><br>
		<span>食物药物过敏史:${pastHistoryModel.tAllergicHistory.allergicHistoryFacet}</span><br>
		<span>手术史:${pastHistoryModel.tOperationHistory.operationHistoryFacet}</span><br>
		<span>输血史:${pastHistoryModel.tBloodTransfusion.bloodTransfusionFacet}</span><br>
		<span>传染病史:${pastHistoryModel.tInfectionHistory.hepatitisBFacet}。${pastHistoryModel.tInfectionHistory.tuberculosisFacet}。</span><br>
		<span>病史回顾:${pastHistoryModel.tMedicalHistoryReview.notYetBeenCuredFacet};${pastHistoryModel.tMedicalHistoryReview.drugsTakenFacet};</span><br>
	</div>
</#if>
<br>
<#if personHistoryModel??>
	<div class="personHistory">
		<span >个人史:</span>
		<#if personHistoryModel.smokingType == 1 >
			<span>否认吸烟史;</span>
		</#if> 
		<#if personHistoryModel.smokingType == 2 >
			已戒烟<span>${personHistoryModel.notSmokingYear}</span> 年，曾经吸烟<span>${personHistoryModel.hasSmokingYear }</span>年，当时平均每天<span>${personHistoryModel.howManyCigaretteEachDay }</span>支.;
		</#if>
		<#if personHistoryModel.smokingType == 3 >
			仍然吸烟，吸烟<span>${personHistoryModel.hasSmokingYear}</span> 年，当时平均每天<span>${personHistoryModel.howManyCigaretteEachDay }</span>支.;
		</#if>
		<#if personHistoryModel.drinkType == 1 >
			<span>否认酗酒史;</span>
		</#if> 
		<#if personHistoryModel.drinkType == 2 >
			已戒酒<span>${personHistoryModel.notDrinkYear}</span> 年，曾经喝<span>${personHistoryModel.alcoholTypeFacet }</span>酒<span>${personHistoryModel.hasDrinkYear} </span>年，平均每天喝<span>${personHistoryModel.howManyDrinkEachDay }</span>两.;
		</#if> 
		<#if personHistoryModel.drinkType == 3 >
			依然喝酒，喝<span>${personHistoryModel.alcoholTypeFacet }</span>酒<span>${personHistoryModel.hasDrinkYear }</span>年，平均每天喝<span>${personHistoryModel.howManyDrinkEachDay }</span>两.;
		</#if> 
		<#if personHistoryModel.hasLifeEpidemicArea == 1 >
			否认疫地疫区生活史;
		</#if>
		<#if personHistoryModel.hasLifeEpidemicArea == 2 >
			有到过<span>${personHistoryModel.epidemicAreaPlace }</span>等地生活;
		</#if>
	</div>
</#if>
<#if marryHistoryModel??>
	<div class="marryHistory">
		<span>${marryHistoryModel.marryTypeFacet }</span>
	</div>
</#if>
<#if familyHistoryModel??>
	<div class="familyHistory">
		<#if familyHistoryModel.similarDisease == 1 >
			<span>否认家族中类似疾病;</span>
		</#if>
		<#if familyHistoryModel.similarDisease == 2 >
			<span>两系三代家族中有${familyHistoryModel.similarDiseaseName}。</span>
		</#if>
		<#if familyHistoryModel.hereditaryDisease == 1 >
			<span>否认家族遗传性疾病;</span>
		</#if>
		<#if familyHistoryModel.hereditaryDisease == 2 >
			<span>两系三代家族中有${familyHistoryModel.hereditaryDiseaseName}。</span>
		</#if>
	</div>
</#if>

<#if menstrualHistoryModel??>
	<div class="menstrualHistory">
		末次月经时间：<span>${menstrualHistoryModel.lastMenstrualPeriodFormat }。</span>第一次来月经的年龄:<span>${menstrualHistoryModel.firstMenstrualAge }</span>岁。
		一次月经总共来:<span>${menstrualHistoryModel.howManyDayMenstrual }</span>天。两次月经间隔:<span>${menstrualHistoryModel.twoMenstrualIntervals }</span>天。
	</div>
</#if>

<#if birthHistoryModel??>
	<div class="birthHistory">
		怀孕过：<span>${birthHistoryModel.howManyTimesPregnant }</span> 次。分娩过:<span>${birthHistoryModel.howManyTimesDelivered }</span> 次.
	</div>
</#if>

</body>
</html>
