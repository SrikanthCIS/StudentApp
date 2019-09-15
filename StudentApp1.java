package basicjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
 class StudentApp1 
{
 public static void main(String[] args)
 {
	Scanner sc = new Scanner(System.in);
	while(true)
	{
		System.out.println("Enter the choice:\n1.Insert.\t2.Update.\t3.Delete.\t4.Select.\t5.SelectAll");
		int ch = sc.nextInt();
		switch(ch)
		{
		case 1:
			System.out.println("Enter sid:");
			int sid = sc.nextInt();
			System.out.println("Enter sname:");
			String sname = sc.next();
			System.out.println("Enter sperc:");
			double sperc = sc.nextDouble();
			Insert( sid, sname, sperc);
			break;
			
		case 2:
			System.out.println("Enter sid:");
			 sid = sc.nextInt();
			System.out.println("Enter sname:");
			 sname = sc.next();
			System.out.println("Enter sperc:");
			 sperc = sc.nextDouble();
			 Update ( sid, sname, sperc);
			break;
						
		case 3:
			System.out.println("Enter sid:");
			 sid = sc.nextInt();
					 Delete ( sid);
			break;	
			
		case 4:
			System.out.println("Enter sid:");
			 sid = sc.nextInt();
			 Select ( sid);
			break;	
			
		case 5:
			SelectAll();
			break;
		}
	}
 }
 
 private static void Insert(int sid,String sname,double sperc)

 {
	 Connection conn = null;
	   Statement stmt = null;
	   
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root","tiger") ;
		stmt =conn.createStatement();
		String Insertquery ="insert into student values("+sid+",'"+sname+"',"+sperc+")";
		int noRowAffected = stmt.executeUpdate(Insertquery);
		
		if(noRowAffected>=1)
		{
			System.out.println(noRowAffected+" rows inserted successfully");
		}
		else
		{
			System.out.println("enter valid data:");
		}
		   
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	   finally
	   {
		   try {
			if(conn!=null)
			   {
			  	 conn.close();
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
	  try {
		if(stmt!=null)
		  {
			  stmt.close();
		  }
	} catch (SQLException e)
	  {
		e.printStackTrace();
	}

 }
 private static void Update(int sid,String sname,double sperc)
 {
	 Connection conn = null;
     Statement stmt = null;
    
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root","tiger");
					stmt=conn.createStatement();
					
					String Updatequery ="update student set sname = '"+sname+"',sperc="+sperc+"where sid >= "+sid;
					int noRowAffected = stmt.executeUpdate(Updatequery);
					
					if(noRowAffected>=1)
					{
						System.out.println(noRowAffected+" rows updated successfully");
					}
					else
					{
						System.out.println("enter valid data:");
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
				finally
				   {
					   try {
						if(conn!=null)
						   {
						  	 conn.close();
						   }
					} catch (SQLException e) {
						e.printStackTrace();
					}
				   }
				  try {
					if(stmt!=null)
					  {
						  stmt.close();
					  }
				} catch (SQLException e)
				  {
					e.printStackTrace();
				}

			 }
 private static void Delete(int sid)	
 {
	 Connection conn = null;
	 Statement stmt = null;
	 
	 try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root","tiger") ;
			stmt =conn.createStatement();
			
			String deletequery = "delete from student where sid >= "+sid;
			int noRowAffected = stmt.executeUpdate(deletequery);
			if(noRowAffected>=1)
			{
				System.out.println(noRowAffected+" rows deleted successfully");
			}
			else
			{
				System.out.println("enter valid data:");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	 finally
	   {
		   try {
			if(conn!=null)
			   {
			  	 conn.close();
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   }
	  try {
		if(stmt!=null)
		  {
			  stmt.close();
		  }
	} catch (SQLException e)
	  {
		e.printStackTrace();
	}
 }
 private static void Select(int sid)
 {
	 Connection conn = null;
	 Statement stmt = null;
	 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root","tiger");
			stmt=conn.createStatement();
			
			String Selectquery = "select * from student where sid ="+sid;
			ResultSet rs = stmt.executeQuery(Selectquery);
			  
			if (rs.next())
			{
				         sid = rs.getInt(1);
				String sname = rs.getString(2);
				double sperc = rs.getDouble(3);
				System.out.println(sid+"\t"+sname+"\t"+sperc);
			}
			else
			{
				System.out.println("Enter valid student id:");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		   {
			   try {
				if(conn!=null)
				   {
				  	 conn.close();
				   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   }
		  try {
			if(stmt!=null)
			  {
				  stmt.close();
			  }
		} catch (SQLException e)
		  {
			e.printStackTrace();
		}
 }
 private static void SelectAll()
 {
	 Connection conn = null;
	 Statement stmt = null;
	 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/srikanth","root","tiger");
			stmt=conn.createStatement();
			
			String SelectAllquery = "select * from student";
			ResultSet rs = stmt.executeQuery(SelectAllquery);
			  
			if (rs.next())
			{
				 int   sid = rs.getInt(1);
				String sname = rs.getString(2);
				double sperc = rs.getDouble(3);
				System.out.println(sid+"\t"+sname+"\t"+sperc);
			}
			else
			{
				System.out.println("Enter valid student id:");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally
		   {
			   try {
				if(conn!=null)
				   {
				  	 conn.close();
				   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		   }
		  try {
			if(stmt!=null)
			  {
				  stmt.close();
			  }
		} catch (SQLException e)
		  {
			e.printStackTrace();
		}
 }
}
	
 


