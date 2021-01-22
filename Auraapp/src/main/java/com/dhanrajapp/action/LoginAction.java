package com.dhanrajapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.db.LoginDao;
import com.dhanrajapp.form.LoginForm;
import com.dhanrajapp.util.Utility;

public class LoginAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LoginForm loginForm=(LoginForm) form;
		
		String id = loginForm.getStaffId();
		String pass=loginForm.getPassword();
		String license=loginForm.getLicenseNo();
		
		LoginDao dao=new LoginDao();
		
		Object[] admin=dao.getLoginDetails(id,pass,license);
		
		
		if(null == admin) {
			return mapping.findForward("error");
		}
		LoginBean bean=new LoginBean();
		
		bean.setAdmin((String)admin[0]);
		bean.setStaffid(id);
		bean.setPassword(pass);
		bean.setLicense(Long.parseLong(""+admin[1]));
		
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("adminrequest", bean);
		
		if("Y".equalsIgnoreCase((String)admin[0]))
		{
			return mapping.findForward("adminpage");
		}
		else {
			return mapping.findForward("userpage");
		}
		
		
	}

}
