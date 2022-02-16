
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import footballform.dao.footballDAO;
import footballform.model.User;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import footballform.model.User;
 
@WebServlet("/jdata")
public class fetchjsondata extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private footballDAO dao = new footballDAO();
        
    public fetchjsondata() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("in retrival json servlet doget");
		String username = request.getParameter("uname");
		System.out.println(username);
		try {
			User u = (User) dao.fetchData(username);
			
			if(u!= null) {
				
				JSONArray array = new JSONArray();
				JSONObject record = new JSONObject();
				record.put("value","true");
				record.put("uname",u.getUname());
				record.put("fname",u.getFname());
				record.put("lname",u.getLname());
				record.put("code",u.getCode());
				record.put("phone",u.getPhone());
				record.put("email",u.getEmail());
				record.put("age",u.getAge());
				record.put("team",u.getTeam());
				record.put("position",u.getPosition());
				record.put("address",u.getAddress());
				record.put("pin",u.getPin());
				record.put("country",u.getCountry());
				record.put("state",u.getState());
				record.put("city",u.getCity());
				array.add(record);
				 response.setContentType("application/json");
				 //response.getWriter().write(array.toString());
				 ServletOutputStream out = response.getOutputStream();
				 //String response = gson.toJson(postRes);
				 out.write(array.toString().getBytes());
				 out.flush();
				 out.close();
				 
				 System.out.println("done");
				 
			}
			else {
				JSONArray array = new JSONArray();
				JSONObject record = new JSONObject();
				record.put("value","false");
				array.add(record);
				response.setContentType("application/json");
				 //response.getWriter().write(array.toString());
				 ServletOutputStream out = response.getOutputStream();
				 //String response = gson.toJson(postRes);
				 out.write(array.toString().getBytes());
				 out.flush();
				 out.close();
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
		
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
        System.out.println("in post fetch"); 
        System.out.println(request.getParameter("uname"));
    }
}