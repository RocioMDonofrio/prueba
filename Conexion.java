/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
    import java.sql.Connection;
    import javax.swing.JOptionPane;
    import java.sql.DriverManager;

public class Conexion {
    String ip="localhost";
    String puerto="3306";
    String usuario = "root";
    String pass = "cfp403.lujan";
    String bd="verduleria";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    Connection con = null;

public Connection conectar() {
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(cadena,usuario,pass);
        JOptionPane.showMessageDialog(null,"Se conectó correctamente a la base de datos");
    } catch (Exception e){
        JOptionPane.showMessageDialog(null,"No se conectó a la base de datos, error: "+e.getMessage());
    }
    return con;

}






}
