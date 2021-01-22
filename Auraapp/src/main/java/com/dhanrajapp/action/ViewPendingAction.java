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
import com.dhanrajapp.bean.PendingTaskBean;
import com.dhanrajapp.db.PendingDao;

public class ViewPendingAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession httpSession=request.getSession();
		PendingDao Dao=new PendingDao();
		HttpSession session=request.getSession();
		LoginBean bean=(LoginBean)session.getAttribute("adminrequest");
		List<PendingTaskBean> beans=Dao.getPending(""+bean.getLicense());
		httpSession.setAttribute("pendinglist", beans);
		
		return mapping.findForward("PendingTask");
	}

}
