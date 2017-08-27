<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/inc.jsp" %>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" id="viewport" name="viewport">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
<link rel="Shortcut Icon" href="statics/images/favicon.ico" type="image/x-icon">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<title>医疗小助手</title>
	<link rel="stylesheet" href="webs/css/index.css">
	<link rel="stylesheet" href="webs/css/pikaday.css">
	<script src="webs/js/plugins/pikaday.js"></script>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
</head>
<body page='pro'>

<!-- banner -->
<c:if test="${ not empty basicInfo }">
	<div class="genReportBtnDIV">
		<a class="logoutA" href="user/download.html">生成报告</a>
		<span>&nbsp&nbsp</span>
		<a class="logoutA" href="user/logout.html">退出登录</a>
	</div>
</c:if>
<c:if test="${ empty basicInfo }">
	<div class="logoutBtnDIV">
		<a class="logoutA" href="user/logout.html">退出登录</a>
		<br>
	</div>
</c:if>
<h3  align="center">基本信息</h3>
<form method="post" id="basicInfoForm">
<div class="probox">
	<ul>
		
		<c:if test="${ not empty basicInfo }">
				<li>
					<dt>编号：</dt>
					<dt><label id="serialNo" name="serialNo">${basicInfo.serialNo }</label></dt>
				</li>
				<li>
					<dt>姓名：</dt>
					<dt><label name="name" id="name" >${basicInfo.name }</label></dt>
				</li>
				<li>
					<dt>真实出生日期：</dt>
					<dt><label name="realBirthDay1" id="realBirthDay1" ><fmt:formatDate pattern="yyyy-MM-dd" value="${basicInfo.realBirthDay }"/></label></dt>
				</li>
				<li>
					<dt>年龄：</dt>
					<dt><label name="ageValue" id="ageValue">${basicInfo.age}</label></dt>
				</li>
				<li>
					<dt>性别：</dt>
					<dt><label name="sex" id="sex">${basicInfo.sexContent}</label></dt>
				</li>
				<li>
					<dt>籍贯：</dt>
					<dt><lable>${basicInfo.nativePlace}</lable></dt>
				</li>
				<li>
					<dt>现居住地：</dt>
					<dt>
				       <lable>${basicInfo.presentResidence}</lable>
					</dt>
				</li>
		</c:if>
		<c:if test="${empty basicInfo }">
			<li>
				<dt>编号：</dt>
				<dt><label id="serialNo" name="serialNo">${serialNo }</label></dt>
			</li>
			<li>
				<dt>姓名：</dt>
				<dt><input type="text" name="name" id="name" ></dt>
			</li>
			<li>
				<dt>真实出生日期：</dt>
				<dt><input type="text"  name="realBirthDay" id="realBirthDay" ><input type="button" value="确定" name="btnSureBirthDay" id="btnSureBirthDay"></dt>
			</li>
			<li>
				<dt>年龄：</dt>
				<dt><label name="ageValue" id="ageValue">&nbsp</label><label name="ageText" id="ageText">&nbsp</label></dt>
			</li>
			<li>
				<dt>性别：</dt>
				<dt>
					<select name="sex" id="sex">
						<option value="0"> 男 </option>
						<option value="1"> 女 </option>
					</select>
				</dt>
			</li>
			<li>
				<dt>籍贯：</dt>
				<dt>
			        <div class="jiGuangInfo">
			            <select name="province" id="province">
			                <option value="">省份</option>
			            </select>
			            <select name="city" id="city">
			                <option value="">地级市</option>
			            </select>
			            <select name="districtAndCounty" id="districtAndCounty">
			                <option value="">市、县级市</option>
			            </select>
			        </div>
				</dt>
			</li>
			<li>
				<dt>现居住地：</dt>
				<dt>
			        <div class="nowHomeInfo">
			            <select name="province2" id="province2">
			                <option value="">省份</option>
			            </select>
			            <select name="city2" id="city2">
			                <option value="">地级市</option>
			            </select>
			            <select name="districtAndCounty2" id="districtAndCounty2">
			                <option value="">市、县级市</option>
			            </select>
			        </div>
				</dt>
			</li>
		</c:if>
		
	</ul>
</div>
</form>
<div class="saveAndDeleteBtn">
	<br>
	<c:if test="${ not empty basicInfo }">
		<input type="button" class="deletebtn" id="deleteBasicInfo" value="删除基本信息">
	</c:if>
	<c:if test="${empty basicInfo }">
		<input type="button" class="savebtn" id="saveBasicInfoBtn" value="保存基本信息">	
	</c:if>
</div>
<br>
<h3  align="center">主诉</h3>
<br>
<form method="post" id="mainSuitForm">
<div class="probox">
	<ul class="mainSuitUL" name="mainSuitUL" id="mainSuitUL">
		<c:if test="${ not empty mainSuits }">
			<c:forEach items="${mainSuits}" var="item">  
				<li>
					<dt>主诉:</dt>
					<dt>
						<div>
							<label>${item.mainSuitContent}</label>于  <label><fmt:formatDate pattern="yyyy-MM-dd" value="${item.attackTime}"/></label> 发病.
						</div>
					</dt>
				</li>
			</c:forEach>
		</c:if>
		<c:if test="${ empty mainSuits }">
			<li>
					<dt>添加主诉</dt>
					<dt><input type="button" id="btn_addMainSuit" value="添加主诉"></dt>
				</li>
				<li>
					<dt>主诉:</dt>
					<dt>
						<div class="mainSuit">
							<select id="mainSuitSelect" name="mainSuitSelect">
							</select>于  <input  type="text" name="diseaseTime" id="diseaseTime" ></input> 发病.
						</div>
					</dt>
				</li>
				
				<li id="mainSuitLI2" name="mainSuitLI2" style="display:none;">
					<dt>主诉:</dt>
					<dt>
						<div class="mainSuit2">
							<select id="mainSuit2Select" name="mainSuit2Select">
							</select>于 <input  type="text"  name="diseaseTime2" id="diseaseTime2"></input> 发病.<input type="button" value="删除" id="btnMainSuitDelete" name="btnMainSuitDelete">
						</div>
					</dt>
				</li>
		</c:if>
	</ul>
</div>
</form>
<div class="saveAndDeleteBtn">
	<br>
	<c:if test="${ not empty mainSuits }">
		<input type="button" class="deletebtn"  id="deleteMainSuit" value="删除主诉">
	</c:if>
	<c:if test="${ empty mainSuits }">
		<input type="button"  class="savebtn" id="saveMainSuit" value="保存主诉">
	</c:if>
</div>
<br>
<h3  align="center">现病史</h3>
<br>

<c:if test="${ empty presentIllnessModel }">
	<form method="post" id="presentIllnessForm">
		<div class="probox">
		<ul class="presentIllnessUL" name="presentIllnessUL" id="presentIllnessUL">
			<li>
				<span>发热</span>
				<span><input type="checkbox" id="feverCheckbox"></span><br>
				<div  style="display:none;" id="hightDegreeDIV" name="hightDegreeDIV">
					最低体温<input type="text" id="lowDegree" name="lowDegree"></input>摄氏度（℃）<br>
					最高体温<input type="text" id="hightDegree" name="hightDegree"></input>摄氏度（℃）
				</div>
			</li>
			<li>
				<span>咳嗽</span>
				<span><input type="checkbox" id="coughCheckbox"></span>
				<div style="display:none;" id="coughDIV" name="coughDIV">
					起病时间<input  type="text"  id="coughStartTime" name="coughStartTime"></input>
				</div>
			</li>
			<li>
				<span>咳痰</span>
				<span><input type="checkbox" id="expectorationCheckbox"></span>
				<div  style="display:none;" id="expectorationDIV" name="expectorationDIV">
					<select id="expectorationSelect" name="expectorationSelect">
						<option value="0">-----请选择-----	</option>
						<option value="1">-----黄痰-----	</option>
						<option value="2">-----白痰-----	</option>
						<option value="3">-----带血痰-----	</option>
					</select>
				</div>
			</li>
			<li>
				<span>呕吐</span>
				<span><input type="checkbox" id="vomitCheckbox"></span>
				<div   style="display:none;" id="vomitDIV" name="vomitDIV">
					<select  id="vomitSelect" name="vomitSelect">
						<option value="0">-----请选择-----	</option>
						<option value="1">-----晕车/船后呕吐-----	</option>
						<option value="2">-----其他类型呕吐-----	</option>
					</select>
				</div>
			</li>
			<li>
				<span>腹泻</span>
				<span><input type="checkbox" id="diarrheaCheckbox"></span>
				<div   style="display:none;" id="diarrheaDIV" name="diarrheaDIV">
					<select id="diarrheaSelect" name="diarrheaSelect">
						<option value="0">-----请选择-----	</option>
						<option value="1">-----每日3次以上-----	</option>
						<option value="2">-----每日3次（含）以下-----	</option>
					</select>
				</div>
				<div style="display:none;" id="diarrheaContinueTimeDIV" name="diarrheaContinueTimeDIV">
					腹泻开始时间<input  type="text"  id="diarrheaContinueTime" name="diarrheaContinueTime"></input>
				</div>
				<div style="display:none;" id="diarrheaNotMoreThan3TimesDIV" name="diarrheaNotMoreThan3TimesDIV">
					每日3次（含）以下，<input type="text" id="diarrheaNotMoreThan3Times" name="diarrheaNotMoreThan3Times"></input>次/天。
				</div>
			</li>
			<li>
				<span>便秘</span>
				<span><input type="checkbox" id="astrictionCheckbox"></span>
				<div   style="display:none;" id="astrictionDIV" name="astrictionDIV">
					<div>
						<select id="astrictionSelect" name="astrictionSelect">
							<option value="0">-----请选择-----	</option>
							<option value="1">-----持续时间未达到半年-----	</option>
							<option value="2">-----持续时间达到半年（含）-----	</option>
						</select>
					</div>
					<div   style="display:none;" id="continueMoreThanHalfYearDiv" name="continueMoreThanHalfYearDiv">
						<select id="isMoreThanThreeTimesSelect" name="isMoreThanThreeTimesSelect">
							<option value="0">-----请选择-----	</option>
							<option value="1">-----排便次数每周少于3次-----	</option>
							<option value="2">-----排便次数每周达到3次-----	</option>
						</select>
					</div>
				</div>
			</li>
			<li>
				<span>便血</span>
				<span><input type="checkbox" id="hematocheziaCheckbox"></span>
				<div   style="display:none;" id="hematocheziaDIV" name="hematocheziaDIV">
					<span>颜色</span>
					<select id="hematocheziaSelect" name="hematocheziaSelect">
						<option value="0">-----请选择-----	</option>
						<option value="1">-----暗红色-----	</option>
						<option value="2">-----鲜红色-----	</option>
					</select>
				</div>
			</li>
			<li>
				<span>肥胖</span>
				<span><input type="checkbox" id="fatCheckbox"></span>
				<div style="display:none;" id="fatDIV" name="fatDIV">
					<span>目前体重:</span>
					<input type='text' id="fatCurrentWeight" name="fatCurrentWeight">(kg)[>0.0kg]<br>
					<span>身高:</span>
					<input type='text' id="fatHight" name="fatHight">(m)[<2.5m]<br>
					<span>体质量指数BMI:</span>
					<input type='text' id="fatWeightBMI" name="fatWeightBMI" readOnly="true"></dt><input type="button" value="计算" id="fatWeightBMIBtn" name="fatWeightBMIBtn">
				</div>
			</li>
			<li>
				<span>消瘦</span>
				<span><input type="checkbox" id="marasmusCheckbox"></span>
				<div style="display:none;" id="marasmusDIV" name="marasmusDIV">
					<span>目前体重:</span>
					<input type='text' id="marasmusCurrentWeight" name="marasmusCurrentWeight">(kg)[>0.0kg]<br>
					<span>身高:</span>
					<input type='text' id="marasmusHight" name="marasmusHight">(m)[<2.5m]<br>
					<span>体质量指数BMI:</span>
					<input type='text' id="marasmusWeightBMI" name="marasmusWeightBMI" readOnly="true"></dt><input type="button" value="计算" id="marasmusWeightBMIBtn" name="marasmusWeightBMIBtn"><br>
					<span>半年内体重减轻:</span>
					<input type='text' id="marasmusWeightDown" name="marasmusWeightDown">(kg)[>0.0kg]<br>
				</div>
			</li>
			<li>
				<span>头晕</span>
				<span><input type="checkbox" id="dizzyCheckbox"></span>
				<div style="display:none;" id="dizzyDIV" name="dizzyDIV">
					<select id="dizzySelect" name="dizzySelect">
						<option value="0">-----请选择-----	</option>
						<option value="1">-----晕车/晕船-----	</option>
						<option value="2">-----晕厥-----	</option>
						<option value="3">-----眩晕-----	</option>
					</select>
					头晕开始时间<input  type="text" class="datepicker"  id="dizzyContinueTime" name="dizzyContinueTime"></input>
				</div>
			</li>
			<li>
				<span>皮肤出现异常</span>
				<span><input type="checkbox" id="abnormalSkinCheckbox"></span>
				<div style="display:none;" id="abnormalSkinDIV" name="abnormalSkinDIV">
					<select id="abnormalSkinSelect" name="abnormalSkinSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----面部-----</option>
						<option value="2">-----颈部、腋下-----</option>
						<option value="3">-----会阴部-----</option>
						<option value="4">-----头皮-----</option>
						<option value="5">-----手足部-----</option>
						<option value="6">-----四肢躯干-----</option>
					</select>
				</div>
				<div  style="display:none;" id="limbsTrunkDIV" name="limbsTrunkDIV">
					<select id="limbsTrunkSelect" name="limbsTrunkSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----湿疹-----</option>
						<option value="2">-----过敏-----</option>
						<option value="3">-----其他-----</option>
					</select>
				</div>
				<div  style="display:none;" id="limbsTrunkOtherDIV" name="limbsTrunkOtherDIV">
					<span>其他:</span><input type="text" id="limbsTrunkOtherInput", name="limbsTrunkOtherInput">
				</div>
				
			</li>
			<li>
				<span>少尿</span>
				<span><input type="checkbox" id="oliguresisCheckbox"></span>
				<div   style="display:none;" id="oliguresisDIV" name="oliguresisDIV">
					<span>一日（24小时）尿量</span><input type="text" id="UPDInput" name="UPDInput">毫升
				</div>
			</li>
			<li>
				<span>其他尿量相关症状</span>
				<span><input type="checkbox" id="otherUPDSymptomCheckbox"></span>
				<div   style="display:none;" id="otherUPDSymptomDIV" name="otherUPDSymptomDIV">
					<select id="otherUPDSymptomSelect" name="otherUPDSymptomSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----尿频尿急尿痛-----</option>
						<option value="2">-----多尿-----</option>
						<option value="3">-----无尿-----</option>
					</select>
				</div>
				<div style="display:none;" id="otherUPDDiuresisDIV" name="otherUPDDiuresisDIV">
					一日（24小时）尿量<input type='text' id="otherUPDDiuresisInput" name="otherUPDDiuresisInput"> 毫升
				</div>
				<div  style="display:none;" id="otherUPDAnuriaDIV" name="otherUPDAnuriaDIV">
					一日（24小时）尿量<input type='text' id="otherUPDAnuriaInput" name="otherUPDAnuriaInput"> 毫升
				</div>
			</li>
	
			<li>
				<span>排尿相关症状</span>
				<span><input type="checkbox" id="micturitionRelatedSymptomsCheckbox"></span>
				<div   style="display:none;" id="micturitionRelatedSymptomsDIV" name="micturitionRelatedSymptomsDIV">
					<select id="micturitionRelatedSymptomsSelect" name="micturitionRelatedSymptomsSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----尿失禁-----</option>
						<option value="2">-----排尿困难-----</option>
					</select>
				</div>
			</li>
			
			<li>
				<span>疼痛</span>
				<span><input type="checkbox" id="painCheckbox"></span>
				<div   style="display:none;" id="painDIV" name="painDIV">
					<select id="painSelect" name="painSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----头痛-----</option>
						<option value="2">-----牙痛-----</option>
						<option value="3">-----腰背痛-----</option>
						<option value="4">-----关节痛-----</option>
						<option value="5">-----痛经-----</option>
						<option value="6">-----腹痛-----</option>
					</select>
				</div>
				<div style="display:none;" id="painContinueTimeDIV" name="painContinueTimeDIV">
					疼痛开始时间:<input  type="text" class="datepicker"  id="painContinueTime" name="painContinueTime"></input><br>
					持续性还是间歇性:
					<select id="continuousOrIntermittentSelect" name="continuousOrIntermittentSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----持续性-----</option>
						<option value="2">-----间歇性-----</option>
					</select>
					<br>
					<div style="display:none;"  id="continuousOrIntermittentDIV" name="continuousOrIntermittentDIV">
						与进食的关系如何:
						<select id="relationshipBetweenEatingAndEatingSelect" name="relationshipBetweenEatingAndEatingSelect">
							<option value="0">-----请选择-----</option>
							<option value="1">-----腹痛进食后发生-----</option>
							<option value="2">-----腹痛进食后减轻-----</option>
							<option value="3">-----腹痛与进食无关-----</option>
						</select>
						<br>
						疼痛的性质:
						<select id="painPropertySelect" name="painPropertySelect">
							<option value="0">-----请选择-----</option>
							<option value="1">-----痉挛性疼痛-----</option>
							<option value="2">-----可以忍受的隐痛-----</option>
						</select>
					</div>
				</div>
			</li>

			<li>
				<span>呕血</span>
				<span><input type="checkbox" id="haematemesisCheckbox"></span>
			</li>
			<li>
				<span>咯血</span>
				<span><input type="checkbox" id="hemoptysisCheckbox"></span>
			</li>
			<li>
				<span>呼吸困难</span>
				<span><input type="checkbox" id="DyspneaCheckbox"></span>
			</li>
			<li>
				<span>心悸</span>
				<span><input type="checkbox" id="palpitationCheckbox"></span>
			</li>
			<li>
				<span>水肿</span>
				<span><input type="checkbox" id="edemaCheckbox"></span>
			</li>
			<li>
				<span>抽搐与惊厥</span>
				<span><input type="checkbox" id="ticAndConvulsionCheckbox"></span>
			</li>
			<li>
				<span>意识障碍</span>
				<span><input type="checkbox" id="consciousnessDisorderCheckbox"></span>
			</li>
			<li>
				<span>情感症状</span>
				<span><input type="checkbox" id="affectiveSymptomsCheckbox"></span>
			</li>
			<li>
				<span>以上都不是</span>
				<span><input type="checkbox" id="notAllAboveCheckbox"></span><br>
				<div style="display:none;"  id="notAllAboveDIV" name="notAllAboveDIV">
					具体描述（不超过20个字）:<input type="text" name = "notAllAbove" id="notAllAbove"></input>
				</div>
			</li>
		</ul>
		</div>
	</form>

</c:if>
<c:if test="${not empty presentIllnessModel }">
	<div class="probox">
		<ul class="presentIllnessResultUL" name="presentIllnessResultUL" id="presentIllnessResultUL">		
			<c:if test="${not empty presentIllnessModel.fever }">
				<li>
					<span>发热</span><br>
					<div  >
						最低体温<label>${presentIllnessModel.fever.lowestDegree}</label>摄氏度（℃）<br>
						最高体温<label>${presentIllnessModel.fever.highestDegree}</label>摄氏度（℃）
					</div>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.cough }">
				<li>
					<span>咳嗽</span><br>
					<div >
						持续时间:<label>${presentIllnessModel.cough.days}</label>天<br>
						定义为:<label style="color:red">${presentIllnessModel.cough.presentToUserStr}</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tExpectoration }">
				<li>
					<span>咳痰</span><br>
					<div >
						咳痰颜色:<label>${presentIllnessModel.tExpectoration.colorFacet}</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tVomit }">
				<li>
					<span>呕吐</span>
					<div >
						呕吐类型:<label>${presentIllnessModel.tVomit.vomitFacet}</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tDiarrhea }">
				<li>
					<span>腹泻</span>
					<c:if test="${not empty presentIllnessModel.tDiarrhea.diarrheaContinusTime }">
						<div >
							腹泻定义为:<label style="color:red">${presentIllnessModel.tDiarrhea.diarrheaFacet}</label>
						</div>
					</c:if>
					<c:if test="${not empty presentIllnessModel.tDiarrhea.eachDayTime }">
						<div >
							每日次数:<label>${presentIllnessModel.tDiarrhea.eachDayTime } 次/天。</label>
						</div>
					</c:if>

				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tAstriction }">
				<li>
					<span>便秘</span>
					<div >
						便秘症状定义为:<label style="color:red">${presentIllnessModel.tAstriction.astrictionFacet }</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tHematochezia }">
				<li>
					<span>便血</span>
					<div  >
						<span>颜色</span>
						<label >${presentIllnessModel.tHematochezia.hematocheziaFacet }</label><br>
						<label style="color:red">${presentIllnessModel.tHematochezia.noticeStr }</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tFat }">
				<li>
					<span>肥胖</span>
					<div >
						<span>BMI值为:${presentIllnessModel.tFat.bmi }</span><br>
						肥胖症状定义为:<label style="color:red">${presentIllnessModel.tFat.fatFacet }</label><br>
						<label>${presentIllnessModel.tFat.noticeStr }</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tMarasmus }">
				<li>
					<span>消瘦</span><br>
						<span>BMI值为:${presentIllnessModel.tMarasmus.bmi }</span><br>
						消瘦症状定义为:<label style="color:red">${presentIllnessModel.tMarasmus.marasmusFacet } </label><br>
						<label style="color:red">${presentIllnessModel.tMarasmus.noticeStr }</label><br>
						体重减轻量定义为:<label  style="color:red">${presentIllnessModel.tMarasmus.weightDownFacet }</label><br>
						<label style="color:red">${presentIllnessModel.tMarasmus.weightDownnoticeStr }<label >
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tDizzy }">
				<li>
					<span>头晕</span>
					<div >
						<label>${presentIllnessModel.tDizzy.dizzyFacet }</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tAbnormalskin }">
				<li>
					<span>皮肤出现异常</span>
						<label>${presentIllnessModel.tAbnormalskin.abnormalSkinFacet }</label>
						<c:if test="${presentIllnessModel.tAbnormalskin.limbsTrunk != 0}">
							<label>,${presentIllnessModel.tAbnormalskin.limbsTrunkFacet}</label>
						</c:if>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tOliguresis }">
				<li>
					<span>少尿</span>
					<div >
						<span>一日（24小时）尿量</span><label>${presentIllnessModel.tOliguresis.updSymptom }</label>毫升<br>
						<c :if test="${presentIllnessModel.tOliguresis.updSymptom < 400 }">
							<label>症状定义为少尿</label>
						</c>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tOtherUpdSymptom }">
				<li>
					<span>其他尿量相关症状</span>
					<div >
						<label>${presentIllnessModel.tOtherUpdSymptom.updSymptomFacet }</label>
					</div>
					<c:if test="${presentIllnessModel.tOtherUpdSymptom.updSymptom == 2 }">
						<div >
							一日（24小时）尿量<label>${presentIllnessModel.tOtherUpdSymptom.diuresisUpd } </label> 毫升
						</div>
					</c:if>
					<c:if test="${presentIllnessModel.tOtherUpdSymptom.updSymptom == 3 }">
						<div >
							一日（24小时）尿量<label>${presentIllnessModel.tOtherUpdSymptom.anuriaUpd }</label> 毫升
						</div>
					</c:if>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tMicturition }">
				<li>
					<span>排尿相关症状</span>
					<div >
						<label>${presentIllnessModel.tMicturition.micturitionSymptomFacet}</label>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tPain }">
				<li>
					<span>疼痛:</span>
					<div >
						<label>${presentIllnessModel.tPain.painTypeFacet}</label>
					</div>
					<div >
						<c:if test="${presentIllnessModel.tPain.painType == 6}">
							腹痛持续时间:<label>${presentIllnessModel.tPain.painContinueTime}</label>天<br>
							持续性还是间歇性:<label>${presentIllnessModel.tPain.painContinuousOrIntermittentTypeFacet }</label><br>
							<c:if test="${presentIllnessModel.tPain.painContinuousOrIntermittentType == 2}">
								<div >
									与进食的关系如何:<label >${presentIllnessModel.tPain.relationshipBetweenEatingAndEatingTypeFacet}</label><br>
									疼痛的性质:<label >${presentIllnessModel.tPain.painPropertyTypeFacet}</label>
								</div>
							</c:if>
						</c:if>
					</div>
				</li>
			</c:if>
			
			<c:if test="${not empty presentIllnessModel.tHaematemesis }">
				<li>
					<label>呕血</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tHemoptysis }">
				<li>
					<label>咯血</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tDyspnea }">
				<li>
					<label>呼吸困难</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tPalpitation }">
				<li>
					<label>心悸</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tEdema }">
				<li>
					<label>水肿</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.ticAndConvulsion }">
				<li>
					<label>抽搐与惊厥</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tConsciousnessDisorder }">
				<li>
					<label>意识障碍</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tAffectiveSymptoms }">
				<li>
					<label>情感症状</label>
				</li>
			</c:if>
			<c:if test="${not empty presentIllnessModel.tNotAllAbove }">
				<li>
					<label>其他问题</label><br>
					<label>${presentIllnessModel.tNotAllAbove.otherStr }</label>
				</li>
			</c:if>
		</ul>
	</div>
</c:if>
<div class="saveAndDeleteBtn">
	<c:if test="${ not empty presentIllnessModel }">
		<input type="button" class="deletebtn"  id="deletePresentIllness" value="删除现病史">
	</c:if>
	<c:if test="${ empty presentIllnessModel }">
		<input type="button" class="savebtn"  id="savePresentIllness" value="保存现病史">
	</c:if>
</div>
<br>
<h3  align="center">自有上诉病况以来,以下情况怎么样</h3>
<br>
	<c:if test="${ empty otherSymptomModel }">
		<form method="post" id="otherSymptomForm">
			<div class="probox">
				<ul class="otherSymptomUL" name="otherSymptomUL" id="otherSymptomUL">
					<li>
						<span>精神如何？</span>
						<div>
							<select id="mindSelect" name="mindSelect">
							    <option value="0">-----请选择-----</option>
								<option value="1">-----一般-----	</option>
								<option value="2"> -----差-----	</option>
							</select>
						</div>
					</li>
					<li>
						<span>食欲如何？</span>
						<div>
							<select id="appetiteSelect" name="appetiteSelect">
							    <option value="0">-----请选择-----</option>
								<option value="1">-----一般-----	</option>
								<option value="2"> -----差-----	</option>
							</select>
						</div>
					</li>
					<li>
						<span>睡眠如何？</span>
						<div>
							<select id="sleepSelect" name="sleepSelect">
							    <option value="0">-----请选择-----</option>
								<option value="1">-----一般-----	</option>
								<option value="2"> -----差-----	</option>
							</select>
						</div>
					</li>
					<li>
						<span>最近半年来体重变化如何？</span>
						<div>
							<select id="leastHalfYearWeightChangeSelect" name="leastHalfYearWeightChangeSelect">
								<option value="0">-----请选择-----</option>
								<option value="1">-----无明显变化-----	</option>
								<option value="2"> -----其他-----	</option>
							</select>
						</div>
						<div  style="display:none;" id="leastHalfYearWeightChangeDIV" name="leastHalfYearWeightChangeDIV">
							体重半年内减轻<input type="text" id="leastHalfYearWeightChangeInput" name="leastHalfYearWeightChangeInput">(kg)
						</div>
					</li>
				</ul>
			</div>
		</form>
	</c:if>
	
	<c:if test="${ not empty otherSymptomModel }">
			<div class="probox">
				<ul class="otherSymptomUL" name="otherSymptomUL" id="otherSymptomUL">
					<li>
						<span>精神如何？</span>
						<div>
							<c:if test="${otherSymptomModel.howTheMind == 1 }">
								<label>一般</label>
							</c:if>
							<c:if test="${otherSymptomModel.howTheMind == 2 }">
								<label>差</label>
							</c:if>
						</div>
					</li>
					<li>
						<span>食欲如何？</span>
						<div>
							<c:if test="${otherSymptomModel.howTheAppetite == 1 }">
								<label>一般</label>
							</c:if>
							<c:if test="${otherSymptomModel.howTheAppetite == 2 }">
								<label>差</label>
							</c:if>
						</div>
					</li>
					<li>
						<span>睡眠如何？</span>
						<div>
							<c:if test="${otherSymptomModel.howTheSleep == 1 }">
								<label>一般</label>
							</c:if>
							<c:if test="${otherSymptomModel.howTheSleep == 2 }">
								<label>差</label>
							</c:if>
						</div>
					</li>
					<li>
						<span>最近半年来体重变化如何？</span>
						<div>
							<c:if test="${otherSymptomModel.leastHalfYearWeightChangeType == 1 }">
								<label>无明显变化</label>
							</c:if>
							<c:if test="${otherSymptomModel.leastHalfYearWeightChangeType == 2 }">
								<label>体重半年内减轻${otherSymptomModel.leastHalfYearWeightDown}(kg)</label>
							</c:if>
						</div>
					</li>
				</ul>
			</div>
	</c:if>


<div class="saveAndDeleteBtn">
	<c:if test="${ not empty otherSymptomModel }">
		<input type="button" class="deletebtn" id="deleteOtherSymptom" value="删除">
	</c:if>
	<c:if test="${ empty otherSymptomModel }">
		<input type="button" class="savebtn" id="saveOtherSymptom" value="保存">
	</c:if>
</div>
<br>
<h3  align="center">既往史</h3>
<br>

	<c:if test="${ empty pastHistoryModel }">	
		<div class="probox">
			<ul class="PastHistoryUL" name="pastHistoryUL" id="pastHistoryUL">
					<li>
						<span>食物药物过敏史:</span><br>
						<span>有过食物、药物过敏史吗？</span>
						<div>
							<select name="drugAllergySelect" id="drugAllergySelect">
							    <option value="0">-----请选择-----</option>
								<option value="1">-----有-----</option>
								<option value="2">-----没有-----</option>
							</select>
						</div>
						<div id="hasDrugAllergyDIV" name="hasDrugAllergyDIV" style="display:none;">
							<span>是什么过敏？(药物最好填写药物通用名)</span><input type="text" id="DrugAllergyMedicineName" name="DrugAllergyMedicineName">
						</div>
					</li>
					<li>
						<span>手术史:</span><br>
						<div>
							<select name="operationHistorySelect" id="operationHistorySelect">
								<option value="0">-----请选择-----</option>
								<option value="1">-----有-----</option>
								<option value="2">-----没有-----</option>
							</select>
						</div>
						<div id="hasOperationHistoryDIV" name="hasOperationHistoryDIV" style="display:none;">
							<input  type="text" class="datepicker"  id="operationTime" name="operationTime">做过<input type="text" id="operationName" name="operationName">手术
						</div>
					</li>
					<li>
						<span>输血史:</span><br>
						<div>
							<select name="transfusionHistorySelect" id="transfusionHistorySelect">
								<option value="0">-----请选择-----</option>
								<option value="1">-----有-----</option>
								<option value="2">-----没有-----</option>
							</select>
						</div>
						<div id="hasTransfusionHistoryDIV" name="hasTransfusionHistoryDIV" style="display:none;">
							<input  type="text" class="datepicker"  id="transfusionTime" name="transfusionTime">做过<input type="text" id="transfusionOperationName" name="transfusionOperationName">手术
						</div>
					</li>
					<li>
						<span>传染病史:</span><br>
						<div>
							<span>乙肝病史</span>	
								<select name="hepatitisBHistorySelect" id="hepatitisBHistorySelect">
									<option value="0">-----请选择-----</option>
									<option value="1">-----有-----</option>
									<option value="2">-----没有-----</option>
								</select><br>
							<span>结核</span>
								<select name="tuberculosisHistorySelect" id="tuberculosisHistorySelect">
									<option value="0">-----请选择-----</option>
									<option value="1">-----有-----</option>
									<option value="2">-----没有-----</option>
								</select>			
						</div>
					</li>
					<li>
						<span>病史回顾:</span><br>
						<span>目前有无已经诊断但尚未治愈的疾病?</span>	<br>
						<div>
							<select name="untreatedDiseaseHistorySelect" id="untreatedDiseaseHistorySelect">
								<option value="0">-----请选择-----</option>
								<option value="1">-----有-----</option>
								<option value="2">-----没有-----</option>
							</select>		
						</div>
						<div id="hasUntreatedDiseaseHistoryDIV" name="hasUntreatedDiseaseHistoryDIV" style="display:none;">
							<input  type="text" class="datepicker"  id="untreatedDiseaseTime" name="untreatedDiseaseTime">诊断出<input type="text" id="untreatedDiseaseName" name="untreatedDiseaseName">
						</div>
						<span>目前有无正在服用的药物?请填写药品说明书内的“通用名称”?</span><br>
						<div>
							<select name="hasDrugsBeingUsedSelect" id="hasDrugsBeingUsedSelect">
								<option value="0">-----请选择-----</option>
								<option value="1">-----有-----</option>
								<option value="2">-----没有-----</option>
							</select>
						</div>
						<div id="hasDrugsBeingUsedDIV" name="hasDrugsBeingUsedDIV" style="display:none;">
							<input  type="text" class="datepicker"  id="drugsBeingUsedTime" name="drugsBeingUsedTime">开始服用<input type="text" id="drugsBeingUsedName" name="drugsBeingUsedName">
						</div>
					</li>
			</ul>
		</div>
		
	</c:if>
	<c:if test="${ not empty pastHistoryModel }">
		<div class="probox">
			<ul class="PastHistoryUL" name="pastHistoryUL" id="pastHistoryUL">
				<c:if test="${ not empty pastHistoryModel.tAllergicHistory }">
					<li>
						<span>食物药物过敏史:</span><br>
						<span>有过食物、药物过敏史吗？</span>
						<c:if test="${ pastHistoryModel.tAllergicHistory.allergicType == 1}">
							<div>
								<label>有</label>
							</div>
						<span>是什么过敏？</span>
							<div>
								<label>${ pastHistoryModel.tAllergicHistory.allergicMedicineName}</label>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tAllergicHistory.allergicType == 2 }">
							<div>
								<label>没有</label>
							</div>
						</c:if>
					</li>
				</c:if>
				<c:if test="${ not empty pastHistoryModel.tOperationHistory }">
					<li>
						<span>手术史:</span><br>
						<span>有过手术史吗？</span>
						<c:if test="${ pastHistoryModel.tOperationHistory.operationType == 1 }">
							<div>
								<label>有，${pastHistoryModel.tOperationHistory.formatOperationTime}做过${pastHistoryModel.tOperationHistory.operationName }手术。</label>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tOperationHistory.operationType == 2 }">
							<div>
								<label>没有</label>
							</div>
						</c:if>
					</li>
				</c:if>
				<c:if test="${ not empty pastHistoryModel.tBloodTransfusion }">
					<li>
						<span>输血史:</span><br>
						<span>有过输血历史吗？</span>
						<c:if test="${ pastHistoryModel.tBloodTransfusion.bloodTransfusionType == 1 }">
							<div>
								<label>有，${pastHistoryModel.tBloodTransfusion.formatBloodTransfusionTime}做过${pastHistoryModel.tBloodTransfusion.operationName }手术。</label>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tBloodTransfusion.bloodTransfusionType == 2 }">
							<div>
								<label>没有</label>
							</div>
						</c:if>
					</li>
				</c:if>
				<c:if test="${ not empty pastHistoryModel.tInfectionHistory }">
					<li>
						<span>传染病史:</span><br>
						<span>有过乙肝病史吗？</span><br>
						<c:if test="${ pastHistoryModel.tInfectionHistory.hepatitisB == 1 }">
							<div>
								<label>有</label><br>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tInfectionHistory.hepatitisB == 2 }">
							<div>
								<label>没有</label><br>
							</div>
						</c:if>
						<span>有过结核病史吗？</span><br>
						<c:if test="${pastHistoryModel.tInfectionHistory.tuberculosis == 1 }">
							<div>
								<label>有</label><br>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tInfectionHistory.tuberculosis == 2 }">
							<div>
								<label>没有</label><br>
							</div>
						</c:if>
					</li>
				</c:if>
				
				<c:if test="${ not empty pastHistoryModel.tMedicalHistoryReview }">
					<li>
					  <span>病史回顾:</span><br>
					  <span>目前有无已经诊断但尚未治愈的疾病?</span><br>
						<c:if test="${ pastHistoryModel.tMedicalHistoryReview.notYetBeenCured == 1 }">
							<div>
								<label>有，${pastHistoryModel.tMedicalHistoryReview.formatHappendTime}诊断出的${pastHistoryModel.tMedicalHistoryReview.illnessName }等已经诊断但尚未治愈的疾病。</label><br>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tMedicalHistoryReview.notYetBeenCured == 2 }">
							<div>
								<label>没有</label><br>
							</div>
						</c:if>
						<span>目前有无正在服用的药物?</span><br>
						<c:if test="${ pastHistoryModel.tMedicalHistoryReview.drugsTaken == 1 }">
							<div>
								<label>有，${pastHistoryModel.tMedicalHistoryReview.formatDrugsTakenTime}开始服用的${pastHistoryModel.tMedicalHistoryReview.drugsName }等药物。</label><br>
							</div>
						</c:if>
						<c:if test="${ pastHistoryModel.tMedicalHistoryReview.drugsTaken == 2 }">
							<div>
								<label>没有</label><br>
							</div>
						</c:if>
					</li>
				
				</c:if>
			</ul>
		</div>
	</c:if>

<div class="saveAndDeleteBtn">
	<c:if test="${ not empty  pastHistoryModel }">
		<input type="button" class="deletebtn" id="deletePastHistoryModel" value="删除既往史">
	</c:if>
	<c:if test="${ empty pastHistoryModel }">
		<input type="button" class="savebtn" id="savePastHistoryModel" value="保存既往史">
	</c:if>
</div>
<br>
<h3  align="center">个人史</h3>
<br>

	<c:if test="${ empty personHistoryModel }">
		<div class="probox">
			<ul class="personHistoryUL" name="personHistoryUL" id="personHistoryUL">
				<li>
					<span>吸烟吗?</span><br>
					<select name="smokingSelect" id="smokingSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----从来不吸-----</option>
						<option value="2">-----现在已经戒烟-----</option>
						<option value="3">-----目前尚未戒烟-----</option>
					</select>
					<div id="personHistoryNotSmokingDIV" name="personHistoryNotSmokingDIV" style="display:none;">
						已戒烟<input type="text" id="notSmokingYearInput" name="notSmokingYearInput">年，曾经吸烟<input type="text" id="hasSmokingYearInput" name="hasSmokingYearInput">年，
						当时平均每天<input type="text" id="everageSmokingInput" name="everageSmokingInput">支
					</div>
					<div id="personHistoryStillSmokingDIV" name="personHistoryStillSmokingDIV" style="display:none;">
						仍然吸烟<input type="text" id="stillSmokingYearInput" name="stillSmokingYearInput">年,
						平均每天<input type="text" id="everageSmoking2Input" name="everageSmoking2Input">支
					</div>
				</li>
				
				<li>
					<span>喝酒吗?</span><br>
					<select name="drinkSelect" id="drinkSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----从来不喝-----</option>
						<option value="2">-----现在已经戒酒-----</option>
						<option value="3">-----目前尚未戒酒-----</option>
					</select>
					<div id="personHistoryNotDrinkDIV" name="personHistoryNotDrinkDIV" style="display:none;">
						已戒酒<input type="text" id="notDrinkYearInput" name="notDrinkYearInput">年，曾经喝
						<select name="drinkTypeSelect" id="drinkTypeSelect">
							<option value="0">-----请选择-----</option>
							<option value="1">-----啤-----</option>
							<option value="2">-----黄-----</option>
							<option value="3">-----白-----</option>
						</select>
						酒<input type="text" id="hasDrinkYearInput" name="hasDrinkYearInput">年，
						当时平均每天喝<input type="text" id="everageDrinkInput" name="everageDrinkInput">两
					</div>
					<div id="personHistoryStillDrinkDIV" name="personHistoryStillDrinkDIV" style="display:none;">
						喝
						<select name="drinkType2Select" id="drinkType2Select">
							<option value="0">-----请选择-----</option>
							<option value="1">-----啤-----</option>
							<option value="2">-----黄-----</option>
							<option value="3">-----白-----</option>
						</select>
						酒<input type="text" id="stillDrinkYearInput" name="stillDrinkYearInput">年,
						平均每天喝<input type="text" id="everageDrink2Input" name="everageDrink2Input">两
					</div>
				</li>
				
				<li>
					<span>曾到过疫地疫区生活吗?</span><br>
					<select name="epidemicAreaPlaceSelect" id="epidemicAreaPlaceSelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----没有-----</option>
						<option value="2">-----有-----</option>
					</select>
					<div id="epidemicAreaPlaceDIV" name="epidemicAreaPlaceDIV" style="display:none;">
						曾到过<input type="text" id="epidemicAreaPlaceInput" name="epidemicAreaPlaceInput">等地生活[任填]						
					</div>
				</li>
			</ul>
		</div>
	</c:if>

	<c:if test="${ not empty personHistoryModel }">
		<div class="probox">
			<ul class="personHistoryUL" name="personHistoryUL" id="personHistoryUL">
				<li>
					<span>吸烟吗?</span><br>
						<c:if test="${personHistoryModel.smokingType == 1 }">
							<label>否认吸烟史</label>
						</c:if> 
						<c:if test="${personHistoryModel.smokingType == 2 }">
							已戒烟<label>${personHistoryModel.notSmokingYear}</label> 年，曾经吸烟<label>${personHistoryModel.hasSmokingYear }</label>年，当时平均每天<label>${personHistoryModel.howManyCigaretteEachDay }</label>支.
						</c:if> 
						<c:if test="${personHistoryModel.smokingType == 3 }">
							仍然吸烟，吸烟<label>${personHistoryModel.hasSmokingYear}</label> 年，当时平均每天<label>${personHistoryModel.howManyCigaretteEachDay }</label>支.
						</c:if>
				</li>
				
				<li>
					<span>喝酒吗?</span><br>
						<c:if test="${personHistoryModel.drinkType == 1 }">
							<label>否认喝酒史</label>
						</c:if> 
						<c:if test="${personHistoryModel.drinkType == 2 }">
 							已戒酒<label>${personHistoryModel.notDrinkYear}</label> 年，曾经喝<label>${personHistoryModel.alcoholTypeFacet }</label>酒<label>${personHistoryModel.hasDrinkYear} </label>年，平均每天喝<label>${personHistoryModel.howManyDrinkEachDay }</label>两.
						</c:if> 
						<c:if test="${personHistoryModel.drinkType == 3 }">
							依然喝酒，喝<label>${personHistoryModel.alcoholTypeFacet }</label>酒<label>${personHistoryModel.hasDrinkYear }</label>年，平均每天喝<label>${personHistoryModel.howManyDrinkEachDay }</label>两.
						</c:if>
				</li>
				
				<li>
					<span>曾到过疫地疫区生活吗?</span><br>
					<c:if test="${personHistoryModel.hasLifeEpidemicArea == 1 }">
						<label>没有</label>
					</c:if> 
					<c:if test="${personHistoryModel.hasLifeEpidemicArea == 2 }">
						到过<label>${personHistoryModel.epidemicAreaPlace }</label>等地生活
					</c:if> 
				</li>
			</ul>
		</div>		
	</c:if>
<br>

<div class="saveAndDeleteBtn">
	<c:if test="${ not empty  personHistoryModel }">
		<input type="button" class="deletebtn" id="deletePersonHistoryModel" value="删除个人史">
	</c:if>
	<c:if test="${ empty personHistoryModel }">
		<input type="button" class="savebtn" id="savePersonHistoryModel" value="保存个人史">
	</c:if>
</div>
<br>
<h3  align="center">婚姻史</h3>

<br>
	
	<c:if test="${ empty marryHistoryModel }">
		<div class="probox">
			<ul class="MarryHistoryMarryUL" name="MarryHistoryMarryUL" id="MarryHistoryMarryUL">
				<li>
					<select name="marryHistorySelect" id="marryHistorySelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----已婚-----</option>
						<option value="2">-----未婚-----</option>
					</select>
				</li>
			</ul>
		</div>
	</c:if>

	<c:if test="${ not empty marryHistoryModel }">
		<div class="probox">
			<label>${marryHistoryModel.marryTypeFacet }</label>
		</div>
	</c:if>

<br>

<div class="saveAndDeleteBtn">
	<c:if test="${ not empty  marryHistoryModel }">
		<input type="button" class="deletebtn" id="deleteMarryHistoryModel" value="删除婚姻史">
	</c:if>
	<c:if test="${ empty marryHistoryModel }">
		<input type="button" class="savebtn" id="saveMarryHistoryModel" value="保存婚姻史">
	</c:if>
</div>
<br>
<h3  align="center">家族史</h3>

<br>
		<c:if test="${ empty familyHistoryModel }">
		<div class="probox">
			<ul class="FamilyHistoryUL" name="FamilyHistoryUL" id="FamilyHistoryUL">
				<span>两系三代家族中有类似的疾病吗？</span>
				<li>
					<select name="familyHistorySelect" id="familyHistorySelect">
						<option value="0">-----请选择-----</option>
						<option value="1">-----没有-----</option>
						<option value="2">-----有-----</option>
					</select>
					<div id="FamilyHistoryDIV" name="FamilyHistoryDIV" style="display:none;">
						有，<input type="text" id="hasSimilarIllnessInput" name="hasSimilarIllnessInput">[任填]
					</div>
				</li>
				
				<span>两系三代家族中有其他遗传性疾病吗？</span>
				<li>
					<select name="familyHistory2Select" id="familyHistory2Select">
						<option value="0">-----请选择-----</option>
						<option value="1">-----没有-----</option>
						<option value="2">-----有-----</option>
					</select>
					<div id="FamilyHistory2DIV" name="FamilyHistory2DIV" style="display:none;">
						有，<input type="text" id="hasHeredityIllnessInput" name="hasHeredityIllnessInput">[任填]
					</div>
				</li>
			</ul>
		</div>
	</c:if>

	<c:if test="${ not empty familyHistoryModel }">
		<div class="probox">
			<ul class="FamilyHistoryUL" name="FamilyHistoryUL" id="FamilyHistoryUL">
				<span>两系三代家族中有类似的疾病吗？</span>
				<div>
					<c:if test="${familyHistoryModel.similarDisease == 1}">
						否认家族中类似疾病
					</c:if>
					<c:if test="${familyHistoryModel.similarDisease == 2}">
						有, <label>${familyHistoryModel.similarDiseaseName }</label>
					</c:if>
				</div>
				
				<span>两系三代家族中有其他遗传性疾病吗？</span>
				<div>
					<c:if test="${familyHistoryModel.hereditaryDisease == 1}">
						否认家族遗传性疾病
					</c:if>
					<c:if test="${familyHistoryModel.hereditaryDisease == 2}">
						有, <label>${familyHistoryModel.hereditaryDiseaseName }</label>
					</c:if>
				</div>
			</ul>
		</div>
	</c:if>
<br>
<div class="saveAndDeleteBtn">
	<c:if test="${ not empty  familyHistoryModel }">
		<input type="button" class="deletebtn" id="deleteFamilyHistoryModel" value="删除家族史">
	</c:if>
	<c:if test="${ empty familyHistoryModel }">
		<input type="button" class="savebtn" id="saveFamilyHistoryModel" value="保存家族史">
	</c:if>
</div>
<br>
<c:if test="${ not empty basicInfo }">
	<c:if test="${ basicInfo.sex == 1 }">
		<h3  align="center">月经史</h3>
		<br>
			<c:if test="${ empty menstrualHistoryModel }">
				<div class="probox">
					<ul class="menstrualHistoryMarryUL" name="menstrualHistoryMarryUL" id="menstrualHistoryMarryUL">
						<li>
							<span>上一次月经第一天的日期是？</span><input  type="text" class="datepicker"  id="recentlyMenstrualDay" name="recentlyMenstrualDay"><br>
							<span>第一次来月经的年龄</span> 
							<select name="firstTimeMenstrualAgeSelect" id="firstTimeMenstrualAgeSelect">
								
							</select> 岁<br>
							<span>月经总共来</span>
							<select name="menstrualDaySelect" id="menstrualDaySelect">
								
							</select> 天<br>
							<span>两次月经间隔</span>
							<select name="twoMenstrualIntervalSelect" id="twoMenstrualIntervalSelect">
								
							</select> 天<br>
						</li>
					</ul>
				</div>
			</c:if>
		
			<c:if test="${ not empty menstrualHistoryModel }">
				<div class="probox">
					末次月经时间：<label>${menstrualHistoryModel.lastMenstrualPeriodFormat }</label><br>
					第一次来月经的年龄:<label>${menstrualHistoryModel.firstMenstrualAge }</label>岁<br>
					一次月经总共来:<label>${menstrualHistoryModel.howManyDayMenstrual }</label>天<br>
					两次月经间隔:<label>${menstrualHistoryModel.twoMenstrualIntervals }</label>天
				</div>
			</c:if>
		<br>
		<div class="saveAndDeleteBtn">
			<c:if test="${ not empty  menstrualHistoryModel }">
				<input type="button" class="deletebtn" id="deleteMenstrualHistoryModel" value="删除月经史">
			</c:if>
			<c:if test="${ empty menstrualHistoryModel }">
				<input type="button" class="savebtn" id="saveMenstrualHistoryModel" value="保存月经史">
			</c:if>
		</div>
		<br>
		<h3  align="center">生育史</h3>
		
		<br>
			<c:if test="${ empty birthHistoryModel }">
				<div class="probox">
					<ul class="birthHistoryMarryUL" name="birthHistoryMarryUL" id="birthHistoryMarryUL">
						<li>
							怀孕过<input type="text" id="pregnancyTime" name="pregnancyTime"> 次.<br>
							分娩过<input type="text" id="deliveryTime" name="deliveryTime"> 次.
						</li>
					</ul>
				</div>
			</c:if>
			
			<c:if test="${ not empty birthHistoryModel }">
				<div class="probox">
					怀孕过：<label>${birthHistoryModel.howManyTimesPregnant }</label> 次.<br>
					分娩过:<label>${birthHistoryModel.howManyTimesDelivered }</label> 次.
				</div>
			</c:if>
			
		<br>
		<div class="saveAndDeleteBtn">
			<c:if test="${ not empty  birthHistoryModel }">
				<input type="button" class="deletebtn" id="deleteBirthHistoryModel" value="删除生育史">
			</c:if>
			<c:if test="${ empty birthHistoryModel }">
				<input type="button" class="deletebtn" id="saveBirthHistoryModel" value="保存生育史">
			</c:if>
		</div>
		<br>
	</c:if>
</c:if>
<script type="text/javascript">
	
</script>
<script src="webs/js/index_startup.js"></script>
<script src="webs/js/index.js"></script>
<script src="webs/js/myFunction.js"></script>
<script src="webs/js/presentIllness.js"></script>
<script src="webs/js/otherSymptoms.js"></script>
<script src="webs/js/pastHistory.js"></script>

<script src="webs/js/personHistory.js"></script>
<script src="webs/js/menstrualHistory.js"></script>
<script src="webs/js/marryHistory.js"></script>
<script src="webs/js/familyHistory.js"></script>
<script src="webs/js/birthHistory.js"></script>

<li  align="center">
	<span>-------------end-------------</span>
</li>
</body>
</html>
