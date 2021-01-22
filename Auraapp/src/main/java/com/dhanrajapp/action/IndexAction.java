package com.dhanrajapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.dhanrajapp.db.LicenseDao;
import com.dhanrajapp.form.LicenseForm;
import com.dhanrajapp.util.Utility;

public class IndexAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		LicenseDao dao=new LicenseDao();
		
		HttpSession httpSession=request.getSession();
		
		String licenseTaken=(String)httpSession.getAttribute("licenseTaken");
		
		if(Utility.stringIsNullOrEmpty(licenseTaken)) {
			String expiryDate=dao.getLicenseDetails();
			
			if(Utility.stringIsNullOrEmpty(expiryDate)) {
				return mapping.findForward("license");
			}

			httpSession.setAttribute("staff",Utility.noOfStaff);
			expiryDate=Utility.convertDate(expiryDate, "yyyyMMdd", "dd/MM/yyyy");
			httpSession.setAttribute("expiryDate", expiryDate);
		}
		
		
			
		return mapping.findForward("login");
	}
	
}
