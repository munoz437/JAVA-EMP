
package clases;

import javax.swing.table.DefaultTableModel;//TABLA
import javax.swing.JOptionPane;//MENSAJE

import java.sql.ResultSet;//SQL
import java.sql.PreparedStatement;//PARAMETROS SQL

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author JLME
 */
public class Estudiante extends Persona {
    private String Carne;
    private int id_estudiante;
    //DefaultTableModel tblModelo;
    
    private Conexion cls_conectar;
    PreparedStatement parametro;
    

    public String getCarne() {
        return Carne;
    }

    public void setCarne(String Carne) {
        this.Carne = Carne;
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
    }
    
    
    public DefaultTableModel llenarEstudiante(){
      DefaultTableModel tblModelo= new DefaultTableModel();
           try
            {
                    cls_conectar = new Conexion();
                    cls_conectar.abrirConexion();

                    String query;
                    query=  "select e.id_empleado as id,e.nombres,e.apellidos,e.direccion, " +
                    "e.telefono,p.puesto as puestos,e.DPI, e.fecha_nacimiento,e.fecha_ingreso_registro,p.id_puesto from empleados as e inner join puestos as p " +
                    "on e.id_puesto=p.id_puesto ORDER BY id_empleado ASC; ";
           

                     ResultSet consulta =  cls_conectar.conexionBD.createStatement().executeQuery(query);

                     String encabezado [] = {"id","Carne","Nombre","Apellido","Direccion","Telefono","Correo","TipoSangre","FechaNacimiento","idTipoSangre"};

                     tblModelo.setColumnIdentifiers(encabezado);

                     String datos[]= new String[10];      
                             while (consulta.next())
                             {  
                               datos[0] = consulta.getString("id");
                               datos[1] = consulta.getString("nombres");
                               datos[2] = consulta.getString("apellidos");
                               datos[3] = consulta.getString("direccion");
                               datos[4] = consulta.getString("telefono");
                               datos[5] = consulta.getString("puestos");
                               datos[6] = consulta.getString("DPI");
                               datos[7] = consulta.getString("fecha_nacimiento");
                               datos[8] = consulta.getString("fecha_ingreso_registro");
                               datos[9] = consulta.getString("id_puesto");
                               tblModelo.addRow(datos);
                             }
                            cls_conectar.cerrarConexion();
                            return  tblModelo;

                                   
                 }
                 
            catch(Exception ex)
            {
                  cls_conectar.cerrarConexion();
                    System.out.println(ex.getMessage());
                    return  tblModelo;
            }
      }
 
  
    
    
    
    public List<List<String>> combo_tipo_sangre(){
        List<List<String>> lista= new ArrayList<List<String>>();
        lista.add(new ArrayList<String>());
         lista.add(new ArrayList<String>());
        try{
            cls_conectar = new Conexion();
            cls_conectar.abrirConexion();        
            //DefaultComboBoxModel comboModelo = new DefaultComboBoxModel();
            String query="SELECT id_puesto,puesto FROM puestos;";
            ResultSet consulta =cls_conectar.conexionBD.createStatement().executeQuery(query);
            lista.get(0).add("0");
            lista.get(1).add("<< Elija >>");
             while (consulta.next()){
             //comboModelo.addElement(consulta.getString("id_tipo_sangre")+") " +consulta.getString("tipo_sangre"));
                lista.get(0).add(consulta.getString("id_puesto"));
                lista.get(1).add(consulta.getString("puesto"));
             }
             cls_conectar.cerrarConexion();
             //combo.setModel(comboModelo);
        }catch(Exception ex){
            
              System.out.println(ex.getMessage()); 
              lista.get(0).add("0");
              lista.get(1).add("<< Elija >>");
        }
        return lista;
    }
    
    public int insertar(){
        
    try{ 
            cls_conectar = new Conexion();
            cls_conectar.abrirConexion();        
            String query ="INSERT INTO empleados(nombres,apellidos,direccion,telefono,id_puesto,DPI,fecha_nacimiento,fecha_ingreso_registro) " +
                     "VALUES (?,?,?,?,?,?,?,?);";
            parametro =(PreparedStatement) 
                    cls_conectar.conexionBD.
                            prepareStatement(query);
            
            parametro.setString(1, getNombres());
            parametro.setString(2, getApellidos());
            parametro.setString(3, getDireccion());
            parametro.setString(4, getTelefono());
            parametro.setInt(5, getId_tipoSangre());
            parametro.setString(6, getCarne());
            parametro.setString(7, getFecha_nacimiento());
            parametro.setString(8, getCorreo());
            int executar = parametro.executeUpdate();
            
            cls_conectar.cerrarConexion();
            return executar;
            //JOptionPane.showMessageDialog(null,"Se han Ingresado:" + 
            // Integer.toString(executar),"Mensaje",JOptionPane.INFORMATION_MESSAGE);
                                 
    }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
             return 0;       
        }
   }
      
    public void eliminar(){
        //int confirmar=JOptionPane.showConfirmDialog(null,"¿DESEA ELIMINAR ESTE REGISRO?");
           // if(confirmar==JOptionPane.OK_OPTION){
                try{ 
                    cls_conectar = new Conexion();
                    cls_conectar.abrirConexion();        
                    String query ="DELETE FROM `empleados`"+
                                  " WHERE id_empleado=?";
                    parametro =(PreparedStatement) 
                    cls_conectar.conexionBD.prepareStatement(query);
                   
                    parametro.setInt(1,getId_estudiante());//PASA EL ID
                    
                    int executar = parametro.executeUpdate();
                    cls_conectar.cerrarConexion();
                    //JOptionPane.showMessageDialog(null,"REGISTRO ELIMINADO");
                }catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                     
                }

           // }
        
    }
    public void modificar(){
        //int confirmar=JOptionPane.showConfirmDialog(null,"¿DESEA MODIFICAR ESTE REGISRO?");
            //if(confirmar==JOptionPane.OK_OPTION){
                try{ 
                    cls_conectar = new Conexion();
                    cls_conectar.abrirConexion();        
                    String query ="UPDATE empleados SET nombres=?,apellidos=?,direccion=?,telefono=?,id_puesto=?,DPI=?,fecha_nacimiento=?,fecha_ingreso_registro=? WHERE id_empleado=?;";
                    parametro =(PreparedStatement) 
                    cls_conectar.conexionBD.prepareStatement(query);
                   
                    
                   
                    
                    parametro.setString(1, getNombres());
                    parametro.setString(2, getApellidos());
                    parametro.setString(3, getDireccion());
                    parametro.setString(4, getTelefono());
                    parametro.setInt(5, getId_tipoSangre());
                    parametro.setString(6, getCarne());
                    parametro.setString(7, getFecha_nacimiento());
                    parametro.setString(8, getCorreo());
                    parametro.setInt(9,getId_estudiante());
                    
                    
                    
                    int executar = parametro.executeUpdate();
                    cls_conectar.cerrarConexion();
                   
                }catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                     
                }
           // }
    }
    public void buscar(){
        try{ 
                    cls_conectar = new Conexion();
                    cls_conectar.abrirConexion();        
                    String query;
                   query="Select estudiantes.id_estudiantes as id, estudiantes.carne, estudiantes.nombres, estudiantes.apellidos, estudiantes.direccion, estudiantes.telefono, estudiantes.correo,"+
                            "tipos_sangre.tipo_sangre ,estudiantes.fecha_nacimiento as FechaNacimiento,tipos_sangre.id_tipo_sangre FROM Estudiantes INNER JOIN Tipos_sangre ON Estudiantes.id_tipo_sangre = tipos_sangre.id_tipo_sangre order by Estudiantes.id_estudiantes asc;";

                     parametro =(PreparedStatement) 
                    cls_conectar.conexionBD.prepareStatement(query);
                   
                    
                    parametro.setString(1, getCarne());
                    parametro.setString(2, getNombres());
                    parametro.setString(3, getApellidos());
                    parametro.setString(4, getDireccion());
                    parametro.setString(5, getTelefono());
                    parametro.setString(6, getCorreo());
                    parametro.setInt(7, getId_tipoSangre());
                    parametro.setString(8, getFecha_nacimiento());
                    parametro.setInt(9,getId_estudiante());
                    
                    
                    int executar = parametro.executeUpdate();
                    cls_conectar.cerrarConexion();
                   
                }catch(Exception ex){
                    System.out.println("Error"+ex.getMessage());
                     
                }
        
    }
    
}

   

