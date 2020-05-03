/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1_sistema_sismico;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Allison
 */
public final class panelInicio extends javax.swing.JPanel {
    
    SimpleDateFormat fecha;
    SimpleDateFormat hora;
    int lenLista = 0;
    DefaultTableModel modelo;
    Registro_sismos listaG = Registro_Singleton.getRegistro_Singleton();
    /**
     * Creates new form panelInicio
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     */
    public panelInicio() throws IOException, FileNotFoundException, ParseException {
       
        initComponents();
        fecha = new SimpleDateFormat("dd/MM/yyyy");
        hora = new SimpleDateFormat("HH:mm:ss");
        modelo = new DefaultTableModel();
        modelo = (DefaultTableModel) tabla.getModel();
        llenarCombo();
        listaG.lista.clear();
        lenLista = listaG.cargar().size();
        llenarJTable();
        
        
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtHora = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        panelInformacion = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtProfundidad = new javax.swing.JTextField();
        cbxOrigen = new javax.swing.JComboBox<>();
        txtDetalle = new javax.swing.JTextField();
        txtMagnitud = new javax.swing.JTextField();
        txtLatitud = new javax.swing.JTextField();
        txtLongitud = new javax.swing.JTextField();
        cbxProvincia = new javax.swing.JComboBox<>();
        txtDescripcion = new javax.swing.JTextField();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txthora = new javax.swing.JTextField();

        setMaximumSize(getMaximumSize());

        txtHora.setBackground(new java.awt.Color(204, 255, 204));
        txtHora.setMaximumSize(new java.awt.Dimension(1500, 900));

        tabla.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Hora", "Profundidad", "Magnitud", "Origen", "Detalle", "Latitud", "Longitud", "Descripcion"
            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        panelInformacion.setBackground(new java.awt.Color(204, 255, 204));
        panelInformacion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Información del sismo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Arial Black", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel1.setText("Fecha ");

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel2.setText("Hora");

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel3.setText("Profundidad");

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel4.setText("Origen");

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel5.setText("Detalle");

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel6.setText("Magnitud");

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel7.setText("Latitud");

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel8.setText("Longitud");

        jLabel9.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel9.setText("Provincia");

        jLabel10.setFont(new java.awt.Font("Arial Black", 0, 15)); // NOI18N
        jLabel10.setText("Descripcion Detallada");

        txtFecha.setText("24/02/2020");
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        txtProfundidad.setText("4");

        cbxOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOrigenActionPerformed(evt);
            }
        });

        txtDetalle.setText("Detalle");

        txtMagnitud.setText("7");

        txtLatitud.setText("9");
        txtLatitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLatitudActionPerformed(evt);
            }
        });

        txtLongitud.setText("4");
        txtLongitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLongitudActionPerformed(evt);
            }
        });

        cbxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
            }
        });

        txtDescripcion.setText("Descripcion Detallada");
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(255, 51, 0));
        btnModificar.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(255, 51, 0));
        btnAgregar.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txthora.setText("02:02:08");
        txthora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelInformacionLayout = new javax.swing.GroupLayout(panelInformacion);
        panelInformacion.setLayout(panelInformacionLayout);
        panelInformacionLayout.setHorizontalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(btnAgregar))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)))
                .addGap(77, 77, 77)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha)
                    .addComponent(txtProfundidad)
                    .addComponent(txtDetalle)
                    .addComponent(txtLongitud)
                    .addComponent(txtLatitud)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(cbxProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbxOrigen, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMagnitud)
                    .addComponent(txthora))
                .addContainerGap(84, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformacionLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnModificar)
                .addGap(147, 147, 147))
        );
        panelInformacionLayout.setVerticalGroup(
            panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformacionLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtProfundidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMagnitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLatitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(42, 42, 42)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(40, 40, 40)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(39, 39, 39)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(49, 49, 49)
                .addGroup(panelInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnAgregar))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout txtHoraLayout = new javax.swing.GroupLayout(txtHora);
        txtHora.setLayout(txtHoraLayout);
        txtHoraLayout.setHorizontalGroup(
            txtHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtHoraLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );
        txtHoraLayout.setVerticalGroup(
            txtHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtHoraLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(txtHoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(95, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    public void llenarCombo(){
        /*
        Funcion: Llenar los ComboBox con la informacion en formato string
        Entradas: Ninguna
        Salidas: Ninguna
        */
        cbxProvincia.removeAllItems();
        cbxOrigen.removeAllItems();
        for(Provincia provincia: Provincia.values()) {
            cbxProvincia.addItem(provincia.toString());
        }
        for(TipoOrigen tipo: TipoOrigen.values()) {
            cbxOrigen.addItem(tipo.toString());
        }
        
    }
    
    public void llenarJTable() throws IOException, FileNotFoundException, ParseException{
        /*
        Funcion: Llena el Jtable con la informacion del excel
        Entradas: Ninguna
        Salidas: Ninguna
        */
        
        JOptionPane.showMessageDialog(null,"LLENAR_JTABLE: "+lenLista);
   
        for (int i = 0; i < lenLista; i++){
            modelo.addRow(new Object[]{fecha.format(listaG.lista.get(i).getFecha()), hora.format(listaG.lista.get(i).getHora()), String.valueOf(listaG.lista.get(i).getProfundidad()),listaG.lista.get(i).getOrigen().toString(), listaG.lista.get(i).getDetalle(), String.valueOf(listaG.lista.get(i).getMagnitud()), String.valueOf(listaG.lista.get(i).getLatitud()),String.valueOf(listaG.lista.get(i).getLongitud()),listaG.lista.get(i).getProvincia().toString()+", "+ listaG.lista.get(i).getDescripcion_detallada()});
            tabla.setModel(modelo);
        }

    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
            /*
            Funcion: Al presionar este boton se toman los datos de los campos de texto
            Entradas: Ninguna
            Salidas: Ninguna
            */
        try { 
            
            if (validarCamposNoVacios()){
                nuevoSismo();
            }else{
                System.out.println("No se pudo agregar porque algun dato es incorrecto");
            }
            
            
            
        } catch (ParseException ex) {
            Logger.getLogger(panelInicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed
    public void nuevoSismo(){
        
        String origen="";
        String provincia="";
            
            
        for (TipoOrigen value : TipoOrigen.values()) {
            if (cbxOrigen.getSelectedItem().toString().equals(value.toString())) {
                origen = value.name();
                break;
             }
         }
            
        for (Provincia value2 : Provincia.values()) {
           if (cbxProvincia.getSelectedItem().toString().equals(value2.toString())) {
                provincia = value2.name();
                break;
            }
        }
            
        try {
                
            Sismo nuevoSismo = new Sismo(fecha.parse(txtFecha.getText()), hora.parse(txthora.getText()),Float.parseFloat(txtProfundidad.getText()), TipoOrigen.valueOf(origen) ,txtDetalle.getText(),Float.parseFloat(txtMagnitud.getText()), Float.parseFloat(txtLatitud.getText()),Float.parseFloat(txtLongitud.getText()),Provincia.valueOf(provincia), txtDescripcion.getText());
            listaG.crearExcel(nuevoSismo); //Hace referncia a la unica Registro_Singleton (crea registro unico)
            modelo.addRow(new Object[]{fecha.format(nuevoSismo.getFecha()), hora.format(nuevoSismo.getHora()), String.valueOf(nuevoSismo.getProfundidad()),nuevoSismo.getOrigen().toString(), nuevoSismo.getDetalle(), String.valueOf(nuevoSismo.getMagnitud()), String.valueOf(nuevoSismo.getLatitud()),String.valueOf(nuevoSismo.getLongitud()), nuevoSismo.getProvincia().toString()+", "+ nuevoSismo.getDescripcion_detallada()});
            tabla.setModel(modelo);
                
                
        } catch (ParseException | IOException ex) {
            Logger.getLogger(panelInicio.class.getName()).log(Level.SEVERE, null, ex); 
        }
            
            
            
        txtFecha.setText(null);
        txthora.setText(null);
        txtProfundidad.setText(null);
        cbxOrigen.setSelectedIndex(0);
        txtDetalle.setText(null);
        txtMagnitud.setText(null);
        txtLatitud.setText(null);
        txtLongitud.setText(null);
        cbxProvincia.setSelectedIndex(0);
        txtDescripcion.setText(null);
            
    
    }
    public boolean validarFecha() {
        /* 
        Funciones: Validar que la fecha sea una fecha valida en el calendario
        Entradas: Ninguna
        Salidas: Ninguna
        */
        try{
            fecha.setLenient(false);
            fecha.parse(txtFecha.getText());
            //System.out.println(fecha);

            return true;
        }
        catch(ParseException e){
            return false;
        }
        
 
    }
    
    
    public boolean validarHora() {
        /* 
        Funciones: Validar que la hora sea  valida 
        Entradas: Ninguna
        Salidas: Ninguna
        */
        try{
            hora.setLenient(false);
            hora.parse(txthora.getText());
            //System.out.println(fecha)
            return true;
        }
        catch(ParseException e){
            return false;
        }
        
 
    }
    
    
   public boolean validarCamposNoVacios() throws ParseException{
        
       boolean bool = true;
        if ("".equals(txtFecha.getText())){
            txtFecha.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            bool = false;
        }
        
        if("".equals(txthora.getText())){
            txthora.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            bool = false;
        }
            
        if ("".equals(txtProfundidad.getText())){
            txtProfundidad.setBorder(BorderFactory.createLineBorder(Color.RED,2));
             bool = false;
        }
                
        if ("".equals(txtDetalle.getText())){
            txtDetalle.setBorder(BorderFactory.createLineBorder(Color.RED,2));
             bool = false;
        }
                  
        if ("".equals(txtMagnitud.getText())){
            txtMagnitud.setBorder(BorderFactory.createLineBorder(Color.RED,2));
             bool = false;
        }
                        
        if ("".equals(txtLatitud.getText())){
            txtLatitud.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            bool = false;
        }
                        
        if ("".equals(txtLongitud.getText())){
            txtLongitud.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            bool = false;
        }
                                
        if("".equals(txtDescripcion.getText())){
            txtDescripcion.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            bool = false;
        }
                                   
        if (bool){
            return validarContenidoCampos();
        }
        else{
            JOptionPane.showMessageDialog(null,"Debe completar todos los espacios");
            return false;
        }
       
                       

    }
   public boolean validarContenidoCampos(){
       
       boolean bool = true;
       
        if(txtFecha.getText().matches("\\d{1,2}/\\d{1,2}/\\d{4}")){
            if (validarFecha() == false){
                JOptionPane.showMessageDialog(null,"Fecha inválida");
                bool = false;
        }}
        else{
            JOptionPane.showMessageDialog(null,"Debe poner la fecha en formato dd/mm/aaaa");
            bool = false;
        }
        
        if(txthora.getText().matches("\\d{2}:\\d{2}:\\d{2}")){
            if (validarHora() == false){
                JOptionPane.showMessageDialog(null,"Hora inválida");
                bool = false;
        }}
        else{
            JOptionPane.showMessageDialog(null,"Debe poner la hora en formato hh:mm:ss");
            bool = false;
        }
       
        if (txtProfundidad.getText().matches("[0-9]*") == false || txtMagnitud.getText().matches("[0-9]*") == false || 
            txtLatitud.getText().matches("[0-9]*") == false || txtLongitud.getText().matches("[0-9]*") == false){
            
            JOptionPane.showMessageDialog(null, "Solo se permite introducir valores numéricos");
            bool = false;
    }
        
       
       return bool;
}
    
    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void txtLongitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLongitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLongitudActionPerformed

    private void txtLatitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLatitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLatitudActionPerformed

    private void cbxOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxOrigenActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here
        JOptionPane.showMessageDialog(null,"CLICK");
    }//GEN-LAST:event_tablaMouseClicked

    private void txthoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthoraActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxOrigen;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelInformacion;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDetalle;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JPanel txtHora;
    private javax.swing.JTextField txtLatitud;
    private javax.swing.JTextField txtLongitud;
    private javax.swing.JTextField txtMagnitud;
    private javax.swing.JTextField txtProfundidad;
    private javax.swing.JTextField txthora;
    // End of variables declaration//GEN-END:variables

    private void or(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
