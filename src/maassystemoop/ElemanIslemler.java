/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maassystemoop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user1
 */
public class ElemanIslemler {
    Connection con;
	PreparedStatement ps;
	String sql;
	
	public void save(Eleman elemann) {
		
		 try {
		    con =  ElemanDb.getConnection();
	            sql = "INSERT INTO eleman(ElemanName,maas,tel) VALUES (?,?,?)";
	            ps = con.prepareStatement(sql);
	            ps.setString(1, elemann.getEmpname());
	            ps.setInt(2, elemann.getSalary());
	            ps.setInt(3, elemann.getPhone());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Saved!");
	        } catch (Exception e) {
	            
	            JOptionPane.showMessageDialog(null, "Error");
	        }

	}


	public void update(Eleman elemann) {
	   try 
             {  
             Connection con = ElemanDb.getConnection();
             String sql = "UPDATE eleman SET ElemanName=?,maas=?,tel=? WHERE id=?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1, elemann.getEmpname());
	     ps.setInt(2, elemann.getSalary());
	     ps.setInt(3, elemann.getPhone());
             ps.setInt(4, elemann.getId());
             ps.executeUpdate();

        
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
		
		
	}

	
	public void delete(Eleman elemann) {
		 try {
	           
	            Connection con = ElemanDb.getConnection();
	            String sql = "delete from eleman  WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);  
	            ps.setInt(1, elemann.getId());
	            ps.executeUpdate();
	            JOptionPane.showMessageDialog(null, "Sildi!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Hata");
	        }
		
	}


	public Eleman get(int id) {
		
		 Eleman st = new Eleman();
	        try {
	            Connection con = ElemanDb.getConnection();
	            String sql = "SELECT * FROM eleman WHERE id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                
	                 st.setId(rs.getInt("id"));
	                st.setEmpname(rs.getString("ElemanName"));
	                st.setSalary(rs.getInt("maas"));
	                st.setPhone(rs.getInt("tel"));

	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Hata");
	        }
	        return st;
	}

	
	public List<Eleman> list() 
        {	
            List<Eleman> list = new ArrayList<Eleman>();
        try
        {
            Connection con = ElemanDb.getConnection();
            String sql = "SELECT * FROM eleman ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
            	Eleman st = new Eleman();
                st.setId(rs.getInt("id"));
                st.setEmpname(rs.getString("ElemanName"));
	        st.setSalary(rs.getInt("maas"));
	        st.setPhone(rs.getInt("tel"));
                list.add(st);
            } 
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hata");
        }
        return list;
	}
    
}
