package com.dhanrajapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.manager.util.SessionUtils;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.db.LoginDao;
import com.dhanrajapp.form.AdminForm;
import com.dhanrajapp.util.HibernateUtil;

public class UpdateUsersAction extends Action{
	private static Logger logger=Logger.getLogger(LoginDao.class);
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ActionMessages actionMessages = new ActionMessages();
		 
		
		System.out.println(request.getParameter("staffid12"));
		
		String result=request.getParameter("staffid12");
		
		String[] changeValues= result.split(",");
		LoginDao dao=new LoginDao();
		for (String string : changeValues) {
			String []values=string.split("#");
			int id=Integer.parseInt(""+values[0]);
			String sene=values[1];
			String staffId=values[2];
			String pass=values[3];
			int rowsAffected=dao.updateUser(staffId, pass, sene, id);
			if(rowsAffected<=0) {
				actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("Error Occured while updating data"));
				addErrors(request, actionMessages);
				return mapping.findForward("error");
			}
		}
		
		if(isCancelled(request)) {
			actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("You Have pressed Back button"));
			addErrors(request, actionMessages);	
			return mapping.findForward("back");
		}
		
		actionMessages.add("org.apache.struts.action.GLOBAL_MESSAGE", new ActionMessage("Data Updated Successfully"));
		addErrors(request, actionMessages);
		
		return mapping.findForward("success");
	}
}
