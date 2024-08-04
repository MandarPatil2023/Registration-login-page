import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
*/

import jakarta.servlet.*;
import jakarta.servlet.http.*;


//@WebServlet("/regform")
public class regcode extends  HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException
	{
		//RequestDispatcher rd = req.getRequestDispatcher("loginpage.jsp");
		//rd.forward(req, resp);
		
		String email=req.getParameter("em");
		String p=req.getParameter("ps");
		int password=Integer.parseInt(p);
		
		String firstname=req.getParameter("fn");
		String lastname=req.getParameter("ln");
		String gender=req.getParameter("gender");
		String country=req.getParameter("country");
	
		Connection con=null;
		PreparedStatement pstmt=null;
		String qry="insert into jspiders.registration values(?,?,?,?,?,?)";
		
		try 
		{
			
			
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=j2ee&password=root");
			pstmt=con.prepareStatement(qry);
			
			pstmt.setString(1,firstname);
			pstmt.setString(2,lastname);
			pstmt.setString(3,email);
			pstmt.setInt(4,password);
			pstmt.setString(5,gender);
			pstmt.setString(6,country);
			
			pstmt.executeUpdate();
			
			System.out.print("Data entered");
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();	
		}
		finally

		{
			if(pstmt!=null)
			{

				try 
				{
					pstmt.close();
				}
				catch (SQLException e) 
				{

					e.printStackTrace();
				}
			}

			if(con!=null)
			{
				try 
				{

					con.close();

				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
}


















