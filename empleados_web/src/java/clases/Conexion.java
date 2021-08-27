/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
        
/**
 *
 * @author JLME
 */
public class Conexion {
    public Connection conexionBD;
    private final String sgdb="mysql";//sqlserver,mysql,oracle
    private final String servidor="localhost";
    private final String puerto=":3306";
    private final String bd="db_empleados_2019";//nombre de la base de datos
    private final String urlConexion="jdbc:"+sgdb+"://"+servidor+puerto+"/"+bd;
    
    private final String usuario="root";
    private final String contra="";
    private final String jdbc="com.mysql.jdbc.Driver";
    
    public void abrirConexion(){
        try{
            Class.forName(jdbc);
            conexionBD=DriverManager.getConnection(urlConexion,usuario,contra);
          // JOptionPane.showMessageDialog(null,"EXITO!!","Conexion Exitosa"
          //  ,JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            //JOptionPane.showMessageDialog(null,ex.getMessage(),"Error en la conexion"
            //,JOptionPane.ERROR_MESSAGE);
        }
    }
    public void cerrarConexion(){
         try{
           conexionBD.close();
        }catch(Exception ex){
           System.out.println("Error"+ex.getMessage());
        }
    }
    
    
}
