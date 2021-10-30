/*
 * It is a servlet file which is linked to registration JSP file and validates the input. takes the input from user.
 */

package uidai;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

/**
 * Servlet implementation class UserResult
 */
@WebServlet("/UserResult")
public class UserResult extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// It accepts the request from the client and stores the input in required variables.
		String aadharNo = request.getParameter("aadharNo");
		String hNo = request.getParameter("hNo");
		String street = request.getParameter("street");
		String area = request.getParameter("area");
		String landmark = request.getParameter("landmark");
		String town = request.getParameter("town");
		String subDistrict = request.getParameter("subDistrict");
		String district = request.getParameter("district");
		String state = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		
		// Regex to check if aadhar number and pincode contains only digits
        String regex = "[0-9]+";

        Pattern p = Pattern.compile(regex);
  
        // Find match between given string and regular expression using Pattern.matcher()
        Matcher aadh = p.matcher(aadharNo);
        Matcher pinc = p.matcher(pincode);
        
        boolean aadharDigit = aadh.matches(); //returns true only if aadhar number contains all digits
        boolean pinDigit = pinc.matches(); //returns true only if pincode contains all digits
        
        //Sets the content type as HTML
        response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		if (aadharDigit && pinDigit)   //This loop is only executed if aadhar number and pincode contains only digits
		{
		
			//Stores the user input
			UserInput use = new UserInput(aadharNo,hNo,street, area, landmark, town, subDistrict, district, state, pincode);
			
			UserDatabase database = new UserDatabase();

			try 
			{
				if (database.getConnection() != null) //This loop is only executed if connection is established properly
				{
					database.insertAndFormatting(use);  //Inserts and formats the data

					String fadd = database.selectAddress(use.getAadharNo());  //Returns formatted address
					
					if(fadd!=null)    //Prints the formatted address alongwith aadhar number
					{
						
						out.println("<html>"
								+"<head>"
								+"<style>"
								+ "div {"
								+ "  background-color: #F8F8FF;"
								+ "  width: 1100px;"
								+ "  height: 450px;"
								+ "  border: 10px solid 	#191970;"
								+ "  padding: 50px;"
								+ "  margin-left: 20px;"
								+ "  margin-right: 20px;"
								+ "  margin-top: 20px;"
								+ "  margin-bottom: 20px;"
								+ "}"
								+ "</style>"
								+"<title>"
								+"Address"
								+"</title>"
								+"</head>"
								+"<body>"
								+"<div>"
								+"<br><p><center><font size = 1600px; color = #8B4513><b><u> FORMATTED ADDRESS </u></b></font></center></p>"
								+"<br><br><p><center><font size = 30px><b>Aadhar number: </b>"+use.getAadharNo()+"</font></center></p>"
								+"<p><center><font size = 30px><b>Addresss: </b>"+fadd+"</font></center></p>"
								+"<br><br><p><center><font size =150px; color = #000000> Thank you!!</font></center></p>"
								+"</div>"
								+"</body>"
								+"</html>");
						
					} 
					
					else      // It is printed if finalAddress value is not found
					{	
						out.println("<html>"
								+ "<head>"
								+ "<style>"
								+ "h1{color: red}"
								+ "</style>"
								+ "</head>"
								+"<body>"
								+"<h1>Error!! Final Address Not Found!</h1>"
								+"</body>"
								+"</html");
					}
				}
			}
			
			catch (Exception e) {
		
				out.println("<html>"
						+ "<head>"
						+ "<style>"
						+ "h1{color: red}"
						+ "</style>"
						+ "</head>"
						+"<body>"
						+"<h1>Connection not established!!</h1>"
						+"</body>"
						+"</html");	  
			}
		}
		else if (aadharDigit == false)  //It is executed when aadhar number contains one or more alphabet/ special character
		{
		        out.println("<html>"
				+"<head>"
				+"<style>"
				+ "div {"
				+ "  background-color: #F8F8FF;"
				+ "  width: 600px;"
				+ "  height: 150px;"
				+ "  border: 10px solid 	#191970;"
				+ "  padding: 50px;"
				+ "  margin-left: 300px;"
				+ "  margin-right: 20px;"
				+ "  margin-top: 150px;"
				+ "  margin-bottom: 20px;"
				+ "}"
				+ "</style>"
				+"<title>"
				+"Address"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<div>"				
				+"<br><p><center><font size = 2000px; color = #8B4513><b> Incorrect Aadhar number!! </b></font></center></p>"	 
				+"</div>"
				+"</body>"
				+"</html>");
		}
			
		else if(pinDigit==false)  //It is executed when pincode contains one or more alphabet/ special character
		{
		    out.println("<html>"
				+"<head>"
				+"<style>"
				+ "div {"
				+ "  background-color: #F8F8FF;"
				+ "  width: 600px;"
				+ "  height: 150px;"
				+ "  border: 10px solid 	#191970;"
				+ "  padding: 50px;"
				+ "  margin-left: 300px;"
				+ "  margin-right: 20px;"
				+ "  margin-top: 150px;"
				+ "  margin-bottom: 20px;"
				+ "}"
				+ "</style>"
				+"<title>"
				+"Address"
				+"</title>"
				+"</head>"
				+"<body>"
				+"<div>"				
				+"<br><p><center><font size = 2000px; color = #8B4513><b> Incorrect Pincode!! </b></font></center></p>"	 
				+"</div>"
				+"</body>"
				+"</html>");
		}
	}
	 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}