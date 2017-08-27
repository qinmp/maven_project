package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bean.BasicInfoReqBean;
import com.bean.BirthHistoryReqBean;
import com.bean.FamilyHistoryReqBean;
import com.bean.MainSuitReqBean;
import com.bean.MenstrualHistoryReqBean;
import com.bean.OtherSymptomReqBean;
import com.bean.PastHistoryReqBean;
import com.bean.PersonHistoryReqBean;
import com.bean.PresentIllnessReqBean;
import com.exception.MyException;
import com.model.Account;
import com.service.BasicInfoService;
import com.service.MainSuitService;
import com.service.PastHistoryService;
import com.service.PresentIllnessService;
import com.service.TBirthHistoryService;
import com.service.TFamilyHistoryService;
import com.service.TMarryHistoryService;
import com.service.TMenstrualHistoryService;
import com.service.TOtherSymptomsService;
import com.service.TPersonHistoryService;
import com.util.session.SessionUtil;
import com.util.vo.ServiceResult;

@Controller("accountController")
@Scope("prototype")
@RequestMapping(value = "/user/")
public class AccountController extends BaseController {
	
	@Autowired
	private BasicInfoService basicInfoService;
	
	@Autowired
	private MainSuitService mainSuitService;
	
	@Autowired
	private PresentIllnessService presentIllnessService;
	
	@Autowired
	private TOtherSymptomsService tOtherSymptomsService;
	
	@Autowired
	private PastHistoryService pastHistoryService;
	
	@Autowired
	private TPersonHistoryService personHistoryService;
	
	@Autowired
	private TMarryHistoryService tMarryHistoryService;
	
	@Autowired
	private TFamilyHistoryService tFamilyHistoryService;
	
	@Autowired
	private TMenstrualHistoryService tMenstrualHistoryService;
	
	@Autowired
	private TBirthHistoryService tBirthHistoryService;
	
	
	@RequestMapping(value = "/deleteBasicInfo.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteBasicInfo(@ModelAttribute("req") BasicInfoReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			basicInfoService.deleteBasicInfo(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteMainSuit.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteMainSuit(@ModelAttribute("req") MainSuitReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			mainSuitService.deleteMainSuit(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveBasicInfo.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveBasicInfo(@ModelAttribute("req") BasicInfoReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			basicInfoService.saveBasicInfo(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveMainSuit.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveMainSuitInfo(@ModelAttribute("req") MainSuitReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			mainSuitService.saveMainSuit(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/savePresentIllness.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String savePresentIllness(@ModelAttribute("req") PresentIllnessReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			presentIllnessService.savePresentIllness(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/getPresentIllness.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getPresentIllness(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			presentIllnessService.getPresentIllness(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deletePresentIllness.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deletePresentIllness(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			presentIllnessService.deletePresentIllnessBySerialNo(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	
	@RequestMapping(value = "/saveOtherSymptom.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveOtherSymptom(@ModelAttribute("req") OtherSymptomReqBean bean, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tOtherSymptomsService.saveOtherSymptom(bean, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/getOtherSymptom.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getOtherSymptom(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tOtherSymptomsService.getOtherSymptom(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteOtherSymptom.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteOtherSymptom(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tOtherSymptomsService.deleteOtherSymptom(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/savePastHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String savePastHistory(@ModelAttribute("req")PastHistoryReqBean bean1, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			pastHistoryService.savePastHistory(bean1, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}

	@RequestMapping(value = "/getPastHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getPastHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			pastHistoryService.getPastHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deletePastHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deletePastHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			pastHistoryService.deletePastHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/savePersonHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String savePersonHistory(@ModelAttribute("req")PersonHistoryReqBean bean2, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			personHistoryService.savePersonHistory(bean2, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	@RequestMapping(value = "/getPersonHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getPersonHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			personHistoryService.getPersonHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deletePersonHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deletePersonHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			personHistoryService.deletePersonHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveMarryHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveMarryHistory(Integer marryType, String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMarryHistoryService.saveMarryHistory(marryType, serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	@RequestMapping(value = "/getMarryHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getMarryHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMarryHistoryService.getMarryHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteMarryHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteMarryHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMarryHistoryService.deleteMarryHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveFamilyHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveFamilyHistory(@ModelAttribute("req")FamilyHistoryReqBean bean3, String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tFamilyHistoryService.saveFamilyHistory(bean3, serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	@RequestMapping(value = "/getFamilyHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getFamilyHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tFamilyHistoryService.getFamilyHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteFamilyHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteFamilyHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tFamilyHistoryService.deleteFimalyHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveMenstrualHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveMenstrualHistory(@ModelAttribute("req")MenstrualHistoryReqBean bean4, String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMenstrualHistoryService.saveMenstrualHistory(bean4, serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	@RequestMapping(value = "/getMenstrualHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getMenstrualHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMenstrualHistoryService.getMenstrualHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteMenstrualHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteMenstrualHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tMenstrualHistoryService.deleteMenstrualHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/saveBirthHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String saveBirthHistory(@ModelAttribute("req")BirthHistoryReqBean bean5, String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "保存失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tBirthHistoryService.saveBirthHistory(bean5, serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	@RequestMapping(value = "/getBirthHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.GET)
	@ResponseBody
	String getBirthHistory(@ModelAttribute("req") String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "获取失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tBirthHistoryService.getBirthHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
	@RequestMapping(value = "/deleteBirthHistory.action", produces="application/json;charset=utf-8", method = RequestMethod.POST)
	@ResponseBody
	String deleteBirthHistory(String serialNo, HttpServletRequest request){
		ServiceResult result = new ServiceResult(false, "删除失败");
		try {
			Long accountId = (Long)SessionUtil.getSession(request, Account.LOGIN_ACCOUNT_ID);
			tBirthHistoryService.deleteBirthHistory(serialNo, result, accountId);
			return result.toJSON();
		} catch (MyException e) {
			// TODO: handle exception
			result.setIsSuccess(false);
			result.setMessage(e.getMessage());
			return result.toJSON();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.setIsSuccess(false);
			result.setMessage("系统发生异常，请稍后重试.");
			result.setMessage("系统发生异常，请稍后重试.");
			return result.toJSON();
		}
	}
	
}
