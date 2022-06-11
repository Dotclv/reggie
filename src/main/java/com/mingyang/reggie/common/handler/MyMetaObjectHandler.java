package com.mingyang.reggie.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.mingyang.reggie.common.constant.EntityConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("createTime", new Date(), metaObject);
		this.setFieldValByName("updateTime", new Date(), metaObject);
		this.setFieldValByName("createUser", getEmpId(), metaObject);
		this.setFieldValByName("updateUser", getEmpId(), metaObject);
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("updateTime", new Date(), metaObject);
		this.setFieldValByName("updateUser", getEmpId(), metaObject);
	}

	public static Long getEmpId() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		Long empId = (Long) request.getSession().getAttribute(EntityConstant.USER_LOGIN_SESSION_KEY);
		return empId;
	}
}
