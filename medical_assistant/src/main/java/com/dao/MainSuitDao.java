package com.dao;

import java.util.List;

import com.model.MainSuit;

public interface MainSuitDao extends BaseDao<MainSuit, Long>  {

	List<MainSuit> getMainSuitBySerialNo(String serialNoStr);

}
