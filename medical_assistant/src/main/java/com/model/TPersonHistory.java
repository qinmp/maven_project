package com.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_person_history")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) 
public class TPersonHistory  extends BaseModel  {
	private static final long serialVersionUID = -6773945432898884853L;
	private Long id;
	private String serialNo;
	private Timestamp createTime;
	private Integer smokingType;
	private Integer notSmokingYear;
	private Integer hasSmokingYear;
	private Integer howManyCigaretteEachDay;
	private Integer drinkType;
	private Integer notDrinkYear;
	private Integer alcoholType;
	private Integer hasDrinkYear;
	private Integer howManyDrinkEachDay;
	//是否在疫区生活过；
	private Integer hasLifeEpidemicArea;
	private String epidemicAreaPlace;
	private String alcoholTypeFacet;
	
	@Transient
	public String getAlcoholTypeFacet(){
		if(null != this.alcoholType){
			if(this.alcoholType == 1){
				alcoholTypeFacet = "啤";
				return alcoholTypeFacet;
			} else if(this.alcoholType == 2){
				alcoholTypeFacet = "黄";
				return alcoholTypeFacet;
			}else if(this.alcoholType == 3){
				alcoholTypeFacet = "白";
				return alcoholTypeFacet;
			}else{
				return "";
			}
		}else{
			return "";
		}
	}
	
	public void setAlcoholTypeFacet(String alcoholTypeFacet) {
		this.alcoholTypeFacet = alcoholTypeFacet;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "serial_no")
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	@Column(name = "smoking_type")
	public Integer getSmokingType() {
		return smokingType;
	}
	public void setSmokingType(Integer smokingType) {
		this.smokingType = smokingType;
	}
	
	@Column(name = "not_smoking_year")
	public Integer getNotSmokingYear() {
		return notSmokingYear;
	}
	public void setNotSmokingYear(Integer notSmokingYear) {
		this.notSmokingYear = notSmokingYear;
	}
	
	@Column(name = "has_smoking_year")
	public Integer getHasSmokingYear() {
		return hasSmokingYear;
	}
	public void setHasSmokingYear(Integer hasSmokingYear) {
		this.hasSmokingYear = hasSmokingYear;
	}
	
	@Column(name = "how_many_cigarette_each_day")
	public Integer getHowManyCigaretteEachDay() {
		return howManyCigaretteEachDay;
	}
	public void setHowManyCigaretteEachDay(Integer howManyCigaretteEachDay) {
		this.howManyCigaretteEachDay = howManyCigaretteEachDay;
	}
	
	@Column(name = "drink_type")
	public Integer getDrinkType() {
		return drinkType;
	}
	public void setDrinkType(Integer drinkType) {
		this.drinkType = drinkType;
	}
	
	@Column(name = "not_drink_year")
	public Integer getNotDrinkYear() {
		return notDrinkYear;
	}
	public void setNotDrinkYear(Integer notDrinkYear) {
		this.notDrinkYear = notDrinkYear;
	}
	
	@Column(name = "alcohol_type")
	public Integer getAlcoholType() {
		return alcoholType;
	}
	public void setAlcoholType(Integer alcoholType) {
		this.alcoholType = alcoholType;
	}
	
	@Column(name = "has_drink_year")
	public Integer getHasDrinkYear() {
		return hasDrinkYear;
	}
	public void setHasDrinkYear(Integer hasDrinkYear) {
		this.hasDrinkYear = hasDrinkYear;
	}
	
	@Column(name = "how_many_drink_each_day")
	public Integer getHowManyDrinkEachDay() {
		return howManyDrinkEachDay;
	}
	public void setHowManyDrinkEachDay(Integer howManyDrinkEachDay) {
		this.howManyDrinkEachDay = howManyDrinkEachDay;
	}
	
	@Column(name = "has_life_epidemic_area")
	public Integer getHasLifeEpidemicArea() {
		return hasLifeEpidemicArea;
	}
	public void setHasLifeEpidemicArea(Integer hasLifeEpidemicArea) {
		this.hasLifeEpidemicArea = hasLifeEpidemicArea;
	}
	
	@Column(name = "epidemic_area_place")
	public String getEpidemicAreaPlace() {
		return epidemicAreaPlace;
	}
	public void setEpidemicAreaPlace(String epidemicAreaPlace) {
		this.epidemicAreaPlace = epidemicAreaPlace;
	}
	
}
