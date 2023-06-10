/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BoorowAbook;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author AUBIN
 */
public class main {
    //Connection  con;
    //PreparedStatement pst;
    
    static String Date(){
        Calendar cal=new GregorianCalendar();
        int month=cal.get(Calendar.MONTH);
        int year=cal.get(Calendar.YEAR);
        int day=cal.get(Calendar.DAY_OF_MONTH);
        String date=year+"/"+(month+1)+"/"+day;
        return date;
    }
    static String time(){
        Calendar cal=new GregorianCalendar();
        int sec=cal.get(Calendar.SECOND);
        int min=cal.get(Calendar.MINUTE);
        int hour=cal.get(Calendar.HOUR);
        String time= hour+":"+min+ ":"+sec;
        return time;
    }
    static String Ad_id(){
        String id = null;
        int i=0;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookissue","root","");
           PreparedStatement pst=con.prepareStatement("SELECT MAX(num) AS num FROM administrator");
           //JOptionPane.showMessageDialog(null,"connected");
           ResultSet rs=pst.executeQuery();
           if(rs.next())
           i=rs.getInt("num");
           //i=Integer.parseInt(id);
           id="ADM"+(i+1);
           //JOptionPane.showMessageDialog(null,"hello "+i+" and "+id);
           return id;
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error here "+e.getMessage());
        }
        //JOptionPane.showmessageDialog();
        return id;
    }
    
    static String std_id(){
        String id = null;
        int i=0;
        try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookissue","root","");
           PreparedStatement pst=con.prepareStatement("SELECT MAX(num) AS num FROM std_account");
           ResultSet rs=pst.executeQuery();
           
           if(rs.next())
          // id=rs.getString("num");
           i=rs.getInt("num");
           id="STD"+(i+1);
           return id;
           
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error here "+e.getMessage());
        }
        //JOptionPane.showmessageDialog();
        return id;
    }
}
