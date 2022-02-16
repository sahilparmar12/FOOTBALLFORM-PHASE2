package footballform.controller;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import footballform.dao.footballDAO;
import footballform.model.User;
@WebServlet("/add")
public class MainServlet extends HttpServlet 
{ 
	private static final long serialVersionUID = 1L;
	private footballDAO dao = new footballDAO();
			
		public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {
			System.out.println("in doPost for data insertion");		
			String uname =req.getParameter("uname");
			try {
				if(dao.Testuser(uname)) {
					JSONArray array = new JSONArray();
					JSONObject record = new JSONObject();
					record.put("value","Username alread exist try with other username");
					array.add(record);
					res.setContentType("application/json");
					 //response.getWriter().write(array.toString());
					 ServletOutputStream out = res.getOutputStream();
					 //String response = gson.toJson(postRes);
					 out.write(array.toString().getBytes());
					 out.flush();
					 out.close();
				}else {
			
			String fname =req.getParameter("fname");
			String lname =req.getParameter("lname");
			String code =req.getParameter("code");
			String phone =req.getParameter("pno");
			String email =req.getParameter("email");
			String age =req.getParameter("age");
			String team =req.getParameter("desiredteam");
			String posi="";
			String position[] = req.getParameterValues("pos");
			if(position!= null) {
				System.out.println("positions are");
				for(String pos : position) {
					posi+=pos+",";
				}
			}
			String address =req.getParameter("address");
			String pin =req.getParameter("pin");
			String country =req.getParameter("country");
			String state =req.getParameter("state");
			String city =req.getParameter("city");
			
			User user = new User();
			user.setUname(uname);
			user.setFname(fname);
			user.setLname(lname);
			user.setCode(code);
			user.setPhone(phone);
			user.setEmail(email);
			user.setAge(age);
			user.setTeam(team);
			user.setPosition(posi);
			user.setAddress(address);
			user.setPin(pin);
			user.setCountry(country);
			user.setState(state);
			user.setCity(city);
			
			
		try {
				dao.submitData(user);
				res.sendRedirect("footballform.html");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			} 
			}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
	}
	
	


