/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
     import java.sql.Connection;
     import java.sql.PreparedStatement;
     import java.sql.ResultSet;
     import java.sql.SQLException;
     import java.util.ArrayList;
     import java.util.List;
     import javax.swing.JOptionPane;




public class ProductoDao {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    

    public ProductoDao() {
    }
    
    
    public boolean agregarProducto(Producto producto){
    String query = "INSERT INTO producto (nombre,detalle,fecha_de_compra, precio_de_compra,precio_de_venta,stock) VALUES(?,?,?,?.?,?)";
    try {
        con = cn.conectar();
        pst = con.prepareStatement(query);
        pst.setString(1,producto.getNombre());
        pst.setString(2,producto.getDetalle());
        pst.setString(3,producto.getFechaCompra());
        pst.setDouble(4,producto.getPrecioCompra());
        pst.setDouble(5,producto.getPrecioVenta());
        pst.setInt(6,producto.getStock());
        pst.execute();
        return true;
    }catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error "+"al registrar el producto" + e);
            return false;
            }
    //modificar auto

    /**
     *
     * @param producto
     * @return
     */
    }
    public boolean modificarProducto(Producto producto){
        String query = "UPDATE producto SET nombre = ?, detalle =?,"+"fecha_de_compra =?,precio_de_compra =?,precio_de_venta =?,stock =?"+"WHERE id =?";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            pst.setString(1,producto.getNombre());
            pst.setString(2, producto.getDetalle());
            pst.setString(3, producto.getFechaCompra());
            pst.setDouble(4, producto.getPrecioCompra());
            pst.setDouble(5, producto.getPrecioVenta());
            pst.setInt(6, producto.getStock());
            pst.setInt(7, producto.getId());
            pst.execute();
            return true;
             } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Error al modificar el producto"+e);
                 return false;
             
                      }
    }
    
        //Borrar producto
        public boolean borrarProducto(int id){
            String query = "DELETE FROM producto WHERE id = "+ id;
            try{
                con = cn.conectar();
                pst = con.prepareStatement(query);
                pst.execute();
                return true;
                
            } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al borrar el producto" + e);
            return false;
        }
    }

    //Listar producto
    public List listarProducto(){
        List<Producto> list_productos = new ArrayList();
        String query = "SELECT * FROM producto ORDER BY nombre ASC";
        try {
            con = cn.conectar();
            pst = con.prepareStatement(query);
            rs = pst.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setDetalle(rs.getString("detalle"));
                producto.setFechaCompra(rs.getString("fecompra"));
                producto.setPrecioCompra(rs.getDouble("precompra"));
                producto.setPrecioVenta(rs.getDouble("preventa"));
                producto.setStock(rs.getInt("stock"));
                list_productos.add(producto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return list_productos;
    }    
    
} 

