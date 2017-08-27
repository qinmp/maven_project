package com.bean;

import com.model.TAbnormalskin;
import com.model.TAffectiveSymptoms;
import com.model.TAstriction;
import com.model.TConsciousnessDisorder;
import com.model.TCough;
import com.model.TDiarrhea;
import com.model.TDizzy;
import com.model.TDyspnea;
import com.model.TEdema;
import com.model.TExpectoration;
import com.model.TFat;
import com.model.TFever;
import com.model.THaematemesis;
import com.model.THematochezia;
import com.model.THemoptysis;
import com.model.TMarasmus;
import com.model.TMicturition;
import com.model.TNotAllAbove;
import com.model.TOliguresis;
import com.model.TOtherUpdSymptom;
import com.model.TPain;
import com.model.TPalpitation;
import com.model.TTicAndConvulsion;
import com.model.TVomit;

public class PresentIllnessRespBean {

		//序列号
		private String serialNo;
		
		//发烧最高/低温度
		private TFever fever;
		
		//咳嗽开始时间
		private TCough cough;
		
		//咳痰
		private TExpectoration tExpectoration;
		
		//呕吐
		private TVomit tVomit;
		
		//腹泻 
		private TDiarrhea tDiarrhea;
		
		//便秘
		private TAstriction tAstriction;
		
		//便血颜色
		private THematochezia tHematochezia;
		
		//肥胖
		private TFat tFat;
		
		//消瘦
		private TMarasmus tMarasmus;
		
		//头晕
		private TDizzy tDizzy;
		
		//皮肤出现异常
		private TAbnormalskin tAbnormalskin;
		
		//少尿
		private TOliguresis tOliguresis;
		
		//其他尿量症状
		private TOtherUpdSymptom tOtherUpdSymptom;
		
		//排尿相关症状类型
		private TMicturition tMicturition;
		
		//疼痛类型
		private TPain tPain;
		
		//呕血
		private THaematemesis tHaematemesis;
		
		//咳血
		private THemoptysis tHemoptysis;
		
		//呼吸困难
		private TDyspnea tDyspnea;
		
		//心悸
		private TPalpitation tPalpitation;
		
		//水肿
		private TEdema tEdema;
		
		//抽搐与惊厥
		private TTicAndConvulsion ticAndConvulsion;
		
		//意识障碍
		private TConsciousnessDisorder tConsciousnessDisorder;
		
		//感情症状
		private TAffectiveSymptoms tAffectiveSymptoms;
		
		//以上都不是
		private TNotAllAbove tNotAllAbove;
		
		public TFever getFever() {
			return fever;
		}
		public void setFever(TFever fever) {
			this.fever = fever;
		}
		
		public TCough getCough() {
			return cough;
		}
		public void setCough(TCough cough) {
			this.cough = cough;
		}
		
		public TExpectoration gettExpectoration() {
			return tExpectoration;
		}
		public void settExpectoration(TExpectoration tExpectoration) {
			this.tExpectoration = tExpectoration;
		}
		
		public TVomit gettVomit() {
			return tVomit;
		}
		public void settVomit(TVomit tVomit) {
			this.tVomit = tVomit;
		}
		
		public TDiarrhea gettDiarrhea() {
			return tDiarrhea;
		}
		public void settDiarrhea(TDiarrhea tDiarrhea) {
			this.tDiarrhea = tDiarrhea;
		}
		
		public TAstriction gettAstriction() {
			return tAstriction;
		}
		public void settAstriction(TAstriction tAstriction) {
			this.tAstriction = tAstriction;
		}
		
		public THematochezia gettHematochezia() {
			return tHematochezia;
		}
		public void settHematochezia(THematochezia tHematochezia) {
			this.tHematochezia = tHematochezia;
		}
		
		public TFat gettFat() {
			return tFat;
		}
		public void settFat(TFat tFat) {
			this.tFat = tFat;
		}
		public TMarasmus gettMarasmus() {
			return tMarasmus;
		}
		public void settMarasmus(TMarasmus tMarasmus) {
			this.tMarasmus = tMarasmus;
		}
		
		public TDizzy gettDizzy() {
			return tDizzy;
		}
		public void settDizzy(TDizzy tDizzy) {
			this.tDizzy = tDizzy;
		}
		
		public TAbnormalskin gettAbnormalskin() {
			return tAbnormalskin;
		}
		public void settAbnormalskin(TAbnormalskin tAbnormalskin) {
			this.tAbnormalskin = tAbnormalskin;
		}

		public TOliguresis gettOliguresis() {
			return tOliguresis;
		}
		public void settOliguresis(TOliguresis tOliguresis) {
			this.tOliguresis = tOliguresis;
		}
		
		public TOtherUpdSymptom gettOtherUpdSymptom() {
			return tOtherUpdSymptom;
		}
		public void settOtherUpdSymptom(TOtherUpdSymptom tOtherUpdSymptom) {
			this.tOtherUpdSymptom = tOtherUpdSymptom;
		}
		
		public TMicturition gettMicturition() {
			return tMicturition;
		}
		public void settMicturition(TMicturition tMicturition) {
			this.tMicturition = tMicturition;
		}
		
		public TPain gettPain() {
			return tPain;
		}
		public void settPain(TPain tPain) {
			this.tPain = tPain;
		}
		public String getSerialNo() {
			return serialNo;
		}
		public void setSerialNo(String serialNo) {
			this.serialNo = serialNo;
		}
		public THaematemesis gettHaematemesis() {
			return tHaematemesis;
		}
		public void settHaematemesis(THaematemesis tHaematemesis) {
			this.tHaematemesis = tHaematemesis;
		}
		public THemoptysis gettHemoptysis() {
			return tHemoptysis;
		}
		public void settHemoptysis(THemoptysis tHemoptysis) {
			this.tHemoptysis = tHemoptysis;
		}
		public TDyspnea gettDyspnea() {
			return tDyspnea;
		}
		public void settDyspnea(TDyspnea tDyspnea) {
			this.tDyspnea = tDyspnea;
		}
		public TPalpitation gettPalpitation() {
			return tPalpitation;
		}
		public void settPalpitation(TPalpitation tPalpitation) {
			this.tPalpitation = tPalpitation;
		}
		public TEdema gettEdema() {
			return tEdema;
		}
		public void settEdema(TEdema tEdema) {
			this.tEdema = tEdema;
		}
		public TTicAndConvulsion getTicAndConvulsion() {
			return ticAndConvulsion;
		}
		public void setTicAndConvulsion(TTicAndConvulsion ticAndConvulsion) {
			this.ticAndConvulsion = ticAndConvulsion;
		}
		public TConsciousnessDisorder gettConsciousnessDisorder() {
			return tConsciousnessDisorder;
		}
		public void settConsciousnessDisorder(TConsciousnessDisorder tConsciousnessDisorder) {
			this.tConsciousnessDisorder = tConsciousnessDisorder;
		}
		public TAffectiveSymptoms gettAffectiveSymptoms() {
			return tAffectiveSymptoms;
		}
		public void settAffectiveSymptoms(TAffectiveSymptoms tAffectiveSymptoms) {
			this.tAffectiveSymptoms = tAffectiveSymptoms;
		}
		public TNotAllAbove gettNotAllAbove() {
			return tNotAllAbove;
		}
		public void settNotAllAbove(TNotAllAbove tNotAllAbove) {
			this.tNotAllAbove = tNotAllAbove;
		}
		
}
