package com.ts.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ts.dao.CustomerDAO;
import com.ts.dto.Customer;
import com.ts.dao.ProfessionalDAO;
import com.ts.dao.SubServicesDAO;
import com.ts.dto.Professional;
import com.ts.dto.SubServices;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//System.out.println("Hey");
		String action = request.getParameter("action");
		PrintWriter out=response.getWriter();
		
		if(action.equalsIgnoreCase("uLogin")) {
			//int ssId = Integer.parseInt(request.getParameter("s"));
			String userName=request.getParameter("uname");
			String password=request.getParameter("upwd");
			
			HttpSession session=request.getSession();
			session.setAttribute("loggedUser", userName);
			session.setAttribute("userPassword", password);
			response.setContentType("text/html");
			
			CustomerDAO customerDao = new CustomerDAO();
			Customer customer=customerDao.getCustomer(userName, password);
			System.out.println("Inside servlet:"+customer);
			session.setAttribute("customer", customer);
			out.println("<html>");
			if(customer !=null){
				//String ssName = request.getParameter("ssName");
				int ssId = Integer.parseInt(request.getParameter("s"));
				String date = request.getParameter("date");
				String time = request.getParameter("time");
				//System.out.println(time);
				//System.out.println(date);
				session.setAttribute("date",date );
				session.setAttribute("time", time);
				java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-mm-dd");
				java.util.Date d = null;
				try {
					d = sdf.parse(date); 
				}
				catch(ParseException e) {
					e.printStackTrace();
				}
				
				SubServicesDAO ssDao = new SubServicesDAO();
				SubServices ss= ssDao.getSubService(ssId);
				session.setAttribute("ssname", ss.getSubServiceName());
				
				ProfessionalDAO pDao = new ProfessionalDAO();
				Professional pro = pDao.getProfessional(ss.getServiceId());
				pDao.updateNOS(pro);
				System.out.println(pro);
				
				if(pro != null) {
					//response.sendRedirect("Summary.jsp?ssName=");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Summary.jsp");
					request.setAttribute("proDetails", pro);
					dispatcher.forward(request, response);
				}	
			}else{
			//out.println("<body bgcolor=yellow text=red> Invalid credentials.!</body>");
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Inavalid Credentials');");
				out.println("location = 'index.html'");
				out.println("</script>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");
		}

		if(action.equalsIgnoreCase("uRegister")) {

			String custName=request.getParameter("custName");
			long cPhone=Long.parseLong(request.getParameter("cPhone"));
			String cEmail=request.getParameter("cEmail");
			String cUserName=request.getParameter("cUserName");
			String cPassword=request.getParameter("cPassword");
			String cAddress=request.getParameter("cAddress");
			
			Customer customer=new Customer();
			customer.setCustomerName(custName);
			customer.setPhone(cPhone);
			customer.setEmail(cEmail);
			customer.setUserName(cUserName);
			customer.setPassword(cPassword);
			customer.setAddress(cAddress);
			
			HttpSession session=request.getSession();
			System.out.println(customer);
			CustomerDAO customerDAO=new CustomerDAO();
			if(customerDAO.add(customer)!=0){
				CustomerDAO cdao=new CustomerDAO();
				Customer cust=cdao.getCustomer(cUserName, cPassword);
				System.out.println("Inside servlet"+customer);
				session.setAttribute("customer", cust);
				out.println("<html>");
				int ssId = Integer.parseInt(request.getParameter("s"));
				System.out.println("Hey");
				String date = request.getParameter("date");
				String time = request.getParameter("time");
			
				session.setAttribute("date",date );
				session.setAttribute("time", time);
			
				SubServicesDAO ssDao = new SubServicesDAO();
				SubServices ss= ssDao.getSubService(ssId);
				session.setAttribute("ssname", ss.getSubServiceName());
				
				ProfessionalDAO pDao = new ProfessionalDAO();
				Professional pro = pDao.getProfessional(ss.getServiceId());
				pDao.updateNOS(pro);
				System.out.println(pro);
				
			
				if(pro != null) {
					//response.sendRedirect("Summary.jsp?ssName=");
					RequestDispatcher dispatcher=request.getRequestDispatcher("Summary.jsp");
					request.setAttribute("proDetails", pro);
					dispatcher.forward(request, response);
				}	
			
			}else{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong! Please try again!');");
				out.println("location = 'index.html'");
				out.println("</script>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("./index.html");
				dispatcher.include(request, response);
			}
			
		}
		if(action.equalsIgnoreCase("pLogin")) {
			String pUserName=request.getParameter("pname");
			String pPassword=request.getParameter("ppwd");
			
			HttpSession session=request.getSession();
			session.setAttribute("loggedPro", pUserName);
			session.setAttribute("proPassword", pPassword);
			
			response.setContentType("text/html");
			
			ProfessionalDAO pdao = new ProfessionalDAO();
			Professional pro =pdao.getProfessionalLogin(pUserName,pPassword);
			System.out.println("Inside servlet:"+pro);
			session.setAttribute("pro", pro);
			session.setAttribute("sid", pro.getProSId());
			out.println("<html>");
			if(pro !=null){
				RequestDispatcher dispatcher=request.getRequestDispatcher("proProfile.jsp");	
				dispatcher.forward(request, response);			
			}else{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Inavalid Credentials');");
				out.println("location = 'index.html'");
				out.println("</script>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("index.html");
				dispatcher.include(request, response);		
			}
			out.println("</html>");	
			
		}
		if(action.equalsIgnoreCase("pRegister")) {
			String proName=request.getParameter("proName");
			long pPhone=Long.parseLong(request.getParameter("pPhone"));
			String pEmail=request.getParameter("pEmail");
			String pUserName=request.getParameter("pUserName");
			String pPassword=request.getParameter("pPassword");
			int sId = Integer.parseInt(request.getParameter("Services"));
			
			//ServicesDAO sDao = new ServicesDAO();
			//int sId = sDao.getServiceId(sName);
			System.out.println(sId);
			Professional pro=new Professional();
			pro.setProName(proName);
			pro.setProPhone(pPhone);
			pro.setProEmail(pEmail);
			pro.setProUserName(pUserName);
			pro.setProPassword(pPassword);
			pro.setProSId(sId);
			
			System.out.println(pro);
			ProfessionalDAO pDao=new ProfessionalDAO();
			
			if(pDao.add(pro)!=0){
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Registration Successful!');");
				out.println("location = 'index.html'");
				out.println("</script>");
			//response.getWriter().println("<h1>Registration Success</h1>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("./index.html");
				dispatcher.include(request, response);
			}else{
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Something went wrong! Please try again!');");
				out.println("location = 'index.html'");
				out.println("</script>");
				RequestDispatcher dispatcher=request.getRequestDispatcher("./index.html");
				dispatcher.include(request, response);
			}
				
		}
		if(action.equalsIgnoreCase("logout")) {
			HttpSession session=request.getSession(false);
			if(session != null)
			    session.invalidate();
			request.getRequestDispatcher("/index.html").forward(request,response);
		}
		
	}
	



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
