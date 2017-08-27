package com.bean;

import com.model.TAllergicHistory;
import com.model.TBloodTransfusion;
import com.model.TInfectionHistory;
import com.model.TMedicalHistoryReview;
import com.model.TOperationHistory;

public class PastHistoryRespBean {
	
	private String serialNo;
	
	//过敏史
	private TAllergicHistory tAllergicHistory;
	
	//保存手术史
	private TOperationHistory tOperationHistory;
	
	//保存输血史
	private TBloodTransfusion tBloodTransfusion;
	
	//保存传染病史
	private TInfectionHistory tInfectionHistory;
	
	//保存病史回顾
	private TMedicalHistoryReview tMedicalHistoryReview;

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public TAllergicHistory gettAllergicHistory() {
		return tAllergicHistory;
	}

	public void settAllergicHistory(TAllergicHistory tAllergicHistory) {
		this.tAllergicHistory = tAllergicHistory;
	}

	public TOperationHistory gettOperationHistory() {
		return tOperationHistory;
	}

	public void settOperationHistory(TOperationHistory tOperationHistory) {
		this.tOperationHistory = tOperationHistory;
	}

	public TBloodTransfusion gettBloodTransfusion() {
		return tBloodTransfusion;
	}

	public void settBloodTransfusion(TBloodTransfusion tBloodTransfusion) {
		this.tBloodTransfusion = tBloodTransfusion;
	}

	public TInfectionHistory gettInfectionHistory() {
		return tInfectionHistory;
	}

	public void settInfectionHistory(TInfectionHistory tInfectionHistory) {
		this.tInfectionHistory = tInfectionHistory;
	}

	public TMedicalHistoryReview gettMedicalHistoryReview() {
		return tMedicalHistoryReview;
	}

	public void settMedicalHistoryReview(TMedicalHistoryReview tMedicalHistoryReview) {
		this.tMedicalHistoryReview = tMedicalHistoryReview;
	}
	
}
