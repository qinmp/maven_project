package com.filter;

import java.io.Serializable;
import java.sql.Timestamp;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import com.util.DateUtil;

/**
 * @Description:
 * @Copyright: 深圳法大大网络科技有限公司 (c)2016
 * @Created Date : 2016-3-7
 * @author jcf
 * @vesion 2.0
 */
@Component
public class EntityInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 7319416231145791577L;

	private static final String CREATE_TIME = "createTime";// "创建时间"属性名称
	private static final String MODIFY_TIME = "lastModifyTime";// "修改时间"属性名称

	// 保存数据时回调此方法
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		Timestamp createTime = DateUtil.getNowTimestampSqlServer();
		for (int i = 0; i < propertyNames.length; i++) {
			if (CREATE_TIME.equals(propertyNames[i]) || MODIFY_TIME.equals(propertyNames[i])) {
				state[i] = createTime;
			}
		}
		return true;
	}

	// 更新数据时回调此方法
	@Override
	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		Timestamp updateTime = DateUtil.getNowTimestampSqlServer();
		for (int i = 0; i < propertyNames.length; i++) {
			if (MODIFY_TIME.equals(propertyNames[i])) {
				currentState[i] = updateTime;
			}
		}
		return true;
	}

}
