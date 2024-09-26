/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Producto;
import model.ProductoDao;
import view.Pantalla;


    


public class ProductoControlador implements ActionListener, MouseListener, KeyListener {
    private Producto producto;
    private ProductoDao productoDao;
    private Pantalla panta;

    DefaultTableModel model = new DefaultTableModel();

    public ProductoControlador(Producto producto, ProductoDao productoDao, Pantalla panta) {
        this.producto = producto;
        this.productoDao = productoDao;
        this.panta = panta;
        
        //Botón de registrar producto
        this.panta.btn_agregar.addActionListener(this);
        //Botón de modificar producto
        this.panta.btn_modificar.addActionListener(this);
        //Botón de borrar producto
        this.panta.btn_borrar.addActionListener(this);
        //Botón de limpiar
        this.panta.btn_limpiar.addActionListener(this);
        
        //Listado de producto
        this.panta.tb_productotabla.addMouseListener(this);
              
        listarProductos(); 
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == panta.btn_agregar){
            //verifica si el campo está vacío
            if(panta.text_nombre.getText().equals("")){
                JOptionPane.showMessageDialog(null, "El campo nombre es obligatorio");
            }else{
                //Realiza el agregado
                producto.setNombre(panta.text_nombre.getText());
                producto.setDetalle(panta.text_detalle.getText());
                producto.setFechaCompra(panta.text_fdcompra.getText());
                producto.setPrecioCompra(Double.parseDouble(panta.text_pdcompra.getText()));
                producto.setPrecioVenta(Double.parseDouble(panta.text_pdventa.getText()));
                producto.setStock(Integer.parseInt(panta.text_stock.getText()));
                if(productoDao.agregarProducto(producto)){
                    limpiarTabla();
                    limpiarCampos();
                    listarProductos();
                    JOptionPane.showMessageDialog(null, "Se agregó el producto");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el producto");
                }
            }
        }else if(e.getSource() == panta.btn_modificar){
            //verifica si el campo está vacío
            if(panta.text_id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            }else{
                //Realiza la modificación
                producto.setId(Integer.parseInt(panta.text_id.getText()));
                producto.setNombre(panta.text_nombre.getText());
                producto.setDetalle(panta.text_detalle.getText());
                producto.setFechaCompra(panta.text_fdcompra.getText());
                producto.setPrecioCompra(Double.parseDouble(panta.text_pdcompra.getText()));
                producto.setPrecioVenta(Double.parseDouble(panta.text_pdventa.getText()));
                producto.setStock(Integer.parseInt(panta.text_stock.getText()));
                if(productoDao.modificarProducto(producto)){
                    limpiarTabla();
                    limpiarCampos();
                    listarProductos();
                    JOptionPane.showMessageDialog(null, "Se modificó el producto");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al modificar el producto");
                }
            }
        }else if(e.getSource() == panta.btn_borrar){
            //verifica si el campo está vacío
            if(panta.text_id.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un registro");
            }else{
                //Realiza el borrado
                int id = Integer.parseInt(panta.text_id.getText());
                if(productoDao.borrarProducto(id)){
                    limpiarTabla();
                    limpiarCampos();
                    listarProductos();
                    JOptionPane.showMessageDialog(null, "Se eliminó el producto");
                }else{
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al eliminar el producto");
                }
            }
        }else if(e.getSource() == panta.btn_limpiar){
                limpiarTabla();
                limpiarCampos();
                listarProductos();    
                panta.btn_agregar.setEnabled(true);
        }    
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource() == panta.tb_productotabla){
            int row = panta.tb_productotabla.rowAtPoint(e.getPoint());
            panta.text_id.setText(panta.tb_productotabla.getValueAt(row,0).toString());
            panta.text_nombre.setText(panta.tb_productotabla.getValueAt(row,1).toString());
            panta.text_detalle.setText(panta.tb_productotabla.getValueAt(row,2).toString());
            panta.text_fdcompra.setText(panta.tb_productotabla.getValueAt(row,3).toString());
            panta.text_pdcompra.setText(panta.tb_productotabla.getValueAt(row,4).toString());
            panta.text_pdventa.setText(panta.tb_productotabla.getValueAt(row,5).toString());
            panta.text_stock.setText(panta.tb_productotabla.getValueAt(row,6).toString());
            //Deshabilitar
            panta.btn_agregar.setEnabled(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //Listar todos los productos
    public void listarProductos(){
        List<Producto> list = productoDao.listarProducto();
        model = (DefaultTableModel) panta.tb_productotabla.getModel();
        Object[] row = new Object[7];
        limpiarTabla();
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getNombre();
            row[2] = list.get(i).getDetalle();
            row[3] = list.get(i).getFechaCompra();
            row[4] = list.get(i).getPrecioCompra();
            row[5] = list.get(i).getPrecioVenta();
            row[6] = list.get(i).getStock();
            model.addRow(row);
        }
    }


    //Limpiar la tabla
    public void limpiarTabla(){
        for (int i = 0; i < model.getRowCount(); i++){
            model.removeRow(i);
            i = i - 1;
        }
    }
    //Limpiar los campos
    public void limpiarCampos(){
        panta.text_id.setText("");
        panta.text_nombre.setText("");
        panta.text_detalle.setText("");
        panta.text_fdcompra.setText("");
        panta.text_pdcompra.setText("");
        panta.text_pdventa.setText("");
        panta.text_stock.setText("");
    }
    
}

