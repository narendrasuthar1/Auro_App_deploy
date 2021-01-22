package com.dhanrajapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhanrajapp.bean.LicenseBean;
import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.db.LicenseDao;
import com.dhanrajapp.form.LicenseForm;
import com.dhanrajapp.util.Utility;

public class LicenseAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		LicenseForm license=(LicenseForm) form;
		HttpSession httpSession=request.getSession();
		String regDate=Utility.convertDate(license.getRegdate(), "dd/MM/yyyy", "yyyyMMdd");
		String expDate=Utility.convertDate(license.getExpdate(), "dd/MM/yyyy", "yyyyMMdd");
		
		if(Utility.stringIsNullOrEmpty(regDate) || Utility.stringIsNullOrEmpty(expDate)) {
			mapping.findForward("error");
		}
		LicenseBean licenseBean=new LicenseBean(license.getName(), license.getAddress(), license.getMobile(), license.getEmail(),""+Utility.noOfStaff, regDate, expDate);
		
		LicenseDao dao=new LicenseDao();
		long id=dao.saveBean(licenseBean);
		
		if(id>0) {
			LoginBean bean=null;
			
			bean=new LoginBean("admin", "admin", "1","Y",id);
			int adminId=dao.saveLoginBean(bean);
			if(adminId<=0) {
				System.out.println("Exception occured on saving the bean for admin");
				return mapping.findForward("error");
			}
			
			String userName="user";
			
			for(int i=1;i<=Utility.noOfStaff-1;i++)
			{
				int temp=i+1;
				bean=new LoginBean(userName+""+i, userName+""+i, ""+temp,"N",id);
				
				int loginId=dao.saveLoginBean(bean);
				if(loginId<=0) {
					System.out.println("Exception occured on saving the bean for iteration "+i);
					return mapping.findForward("error");
				}
			}
			
			httpSession.setAttribute("licenseNo", id);
			return mapping.findForward("success");
		}
		
		return mapping.findForward("error");
	}

}
