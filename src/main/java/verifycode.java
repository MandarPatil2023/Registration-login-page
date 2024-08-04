
import java.io.IOException;

import java.io.PrintWriter;
import java.sql.*;

/*
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/

import jakarta.servlet.*;
import jakarta.servlet.http.*;


//@WebServlet("/ln")
public class verifycode extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException, IOException
	{
		
		String un=req.getParameter("un");
		String ps=req.getParameter("ps");
			int userps=Integer.parseInt(ps);
		
		Connection con= null;
		PreparedStatement pstmt= null;
		ResultSet rs=null;
		
		PrintWriter out = res.getWriter();
		
		
		
		String qry="select * from jspiders.registration where firstname=?";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loaded driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=j2ee&password=root");
			System.out.println("Established connection");
			
			pstmt=con.prepareStatement(qry);
			
			pstmt.setString(1,un);
			
			rs=pstmt.executeQuery();
			
			
				if(rs.next())
				{
					String username=rs.getString(1);
					int password=rs.getInt(4);
				
				
					if(un.equalsIgnoreCase(username) && userps==password)
					{
						System.out.println("welcome page");
						RequestDispatcher rd = req.getRequestDispatcher("welcomepage.jsp");
						rd.forward(req, res);
					
					}
					
					else 
					{   
						res.setContentType("text/html");
						out.print("<h3 style ='color:red; Text-Align:center'>Email id & password didnt matched </h3>");
						
						
						System.out.println("login page");
						RequestDispatcher rd = req.getRequestDispatcher("loginpage.jsp");
						rd.include(req, res);
						
					}
				
				}
			
			
				else 
				{
					RequestDispatcher rd = req.getRequestDispatcher("loginpage.jsp");
					rd.forward(req, res);
				
				}
			
			
			
		}
		catch(ClassNotFoundException |SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			
			if(rs!=null)
			{
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				}
				catch(SQLException e) 
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
				catch(SQLException e) 
				{
					e.printStackTrace();
			    }
			}
		}
	}
}
