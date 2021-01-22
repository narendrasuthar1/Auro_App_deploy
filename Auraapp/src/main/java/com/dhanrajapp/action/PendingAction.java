package com.dhanrajapp.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.dhanrajapp.bean.LoginBean;
import com.dhanrajapp.bean.PendingTaskBean;
import com.dhanrajapp.db.LoginDao;
import com.dhanrajapp.db.PendingDao;
import com.dhanrajapp.form.AddPendingTaskForm;

public class PendingAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		  //AddPendingTaskForm pendingtask=(AddPendingTaskForm) form;
		/*
		 * System.out.println("Staff Id:"+pendingtask.getStaffId());
		 * System.out.println("Client Name:"+pendingtask.getClientName());
		 * System.out.println("Pending Task:"+pendingtask.getPendingText());
		 */
		 HttpSession session=request.getSession();
		 LoginBean bean=(LoginBean)session.getAttribute("adminrequest");
		 
		  AddPendingTaskForm addPendingTaskForm=(AddPendingTaskForm) form;
//		  String taskName=addPendingTaskForm.getSearchbar(); 
		  String taskName=request.getParameter("taskName");
		/*
		 * String id1=request.getParameter("id"); String
		 * name=request.getParameter("name"); String
		 * value=request.getParameter("value"); 
		 * System.out.println(id1+name+value);
		 */
		  
		  Date date=new Date();
		  SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yy");
		  String dt= dateFormat.format(date);
		  
		  taskName=taskName+" - "+dt;
		  
		  PendingTaskBean PendingTaskBean= new PendingTaskBean();
		  PendingTaskBean.setStatus("ACTIVE");
		  PendingTaskBean.setUrg("NO");
		  PendingTaskBean.setRemark(" ");
		  PendingTaskBean.setTask_status(" ");
		  PendingTaskBean.setStaffid(" ");
		  PendingTaskBean.setTask(taskName);
		  PendingTaskBean.setLicense(bean.getLicense());
		  PendingDao dao=new PendingDao();
		  int id=dao.saveBean(PendingTaskBean);
		  System.out.println(id);
		  
		/*
		 * JSONObject jsonData = new JSONObject(); PrintWriter out; out =
		 * response.getWriter(); response.setContentType("text/plain");
		 * jsonData.put("calculateAmount","done" ); out.println(jsonData.toString());
		 * 
		 * out.flush();
		 */
			
			return mapping.findForward("success");
		  
	}
	
}
