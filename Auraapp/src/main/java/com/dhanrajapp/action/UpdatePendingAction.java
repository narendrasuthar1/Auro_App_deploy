package com.dhanrajapp.action;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.json.JSONObject;

import com.dhanrajapp.bean.PendingTaskBean;
import com.dhanrajapp.db.PendingDao;
import com.dhanrajapp.util.Utility;

public class UpdatePendingAction extends Action{
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		PendingTaskBean PendingTaskBean= new PendingTaskBean();
		
		String id=request.getParameter("id"); 
		String name=request.getParameter("name");
		String value=request.getParameter("value");
		System.out.println(name+" "+id+" "+value);
		//System.out.println("Delete Task ID:"+deltask);
		//String query="update table set "+colmn+"="+value+" where id="+id;
		int id1=Integer.parseInt(id);
		 PendingDao dao=new PendingDao(); 
		 int id2=dao.updatePending(name, value, id1);
		 System.out.println(id2);
		
		 JSONObject jsonData = new JSONObject();
		  PrintWriter out;
		  out = response.getWriter();
		  response.setContentType("text/plain");
		  jsonData.put("calculateAmount","done" );
		  out.println(jsonData.toString());
			
		  out.flush();
		 
		
		 // id="";name="";value=""; deltask="";
		 
		return mapping.findForward("success");
	}
}
