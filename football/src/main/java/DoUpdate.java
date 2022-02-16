import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import footballform.dao.footballDAO;
import footballform.model.User;
@WebServlet("/Doupdate")
public class DoUpdate extends HttpServlet {
	private footballDAO dao = new footballDAO();
	
	public void doPost (HttpServletRequest req , HttpServletResponse res) throws IOException, ServletException {	
		System.out.println("in DoUpdate for data updation");		
		String uname =req.getParameter("uname");
		String fname =req.getParameter("fname");
		String lname =req.getParameter("lname");
		String code =req.getParameter("code");
		String phone =req.getParameter("pno");
		String email =req.getParameter("email");
		System.out.println("Update "+email);
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
			dao.UpdateData(user);
			res.sendRedirect("footballform.html");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
