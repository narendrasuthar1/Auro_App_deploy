package com.dhanrajapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.db.LoginDao;
import com.dhanrajapp.form.AdminForm;

public class AdminAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession httpSession = request.getSession();
		LoginDao dao = new LoginDao();
		List<LoginBean> beans = dao.getLogin();
		httpSession.setAttribute("userList", beans);
		return mapping.findForward("listUsers");
	}

}
