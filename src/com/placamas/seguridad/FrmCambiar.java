package com.placamas.seguridad;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.vista.FrmLogin;
import com.placamas.beans.UsuarioBean;
import com.placamas.componentes.JComboBoxBD;
import com.placamas.componentes.JComboBoxBD1;
import com.placamas.controlador.UsuarioControlador;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;



public class FrmCambiar extends JInternalFrame implements ActionListener{


	UsuarioControlador obj=new UsuarioControlador();
	DefaultTableModel modelo=new DefaultTableModel();
	boolean estado=false;
	ResourceBundle rb = ResourceBundle.getBundle("database_sql");
	private JTextField txtPassAct;
	private JTextField txtPassNew;
	private JButton btnGuardar;
	JComboBoxBD1 pregunta;
	public JPanel usuario;
	JSeparator separator;
	private JTextField txtPassNew1;
	private JTextField txtResp;
	private String newc;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambiar frame = new FrmCambiar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCambiar() {
		
		usuario = new JPanel();
		
		usuario.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Cambio de Contrase\u00F1a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 121, 1113, 495);
		usuario.add(panel);
		panel.setLayout(null);
		
		JLabel lblPassActual = new JLabel("Ingresar Contraseña Actual:");
		lblPassActual.setBounds(80, 59, 175, 19);
		panel.add(lblPassActual);
		lblPassActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPassAct = new JTextField();
		txtPassAct.setBounds(304, 57, 128, 19);
		panel.add(txtPassAct);
		txtPassAct.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPassAct.setColumns(10);
		
		JLabel lblNuevaCont = new JLabel("Ingresar Nueva Contaseña:");
		lblNuevaCont.setBounds(80, 91, 175, 15);
		panel.add(lblNuevaCont);
		lblNuevaCont.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPassNew = new JTextField();
		txtPassNew.setBounds(304, 89, 128, 19);
		panel.add(txtPassNew);
		txtPassNew.setColumns(10);
		
		JLabel lblRepetaLaContrasea = new JLabel("Repeta la Contraseña:");
		lblRepetaLaContrasea.setBounds(80, 125, 137, 15);
		panel.add(lblRepetaLaContrasea);
		lblRepetaLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPassNew1 = new JTextField();
		txtPassNew1.setBounds(304, 123, 128, 19);
		panel.add(txtPassNew1);
		txtPassNew1.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPassNew1.setColumns(10);
		
		separator = new JSeparator();
		separator.setBounds(31, 166, 480, 14);
		panel.add(separator);
		
		JLabel lblCampoOpcional = new JLabel("Campo Opcional(Cambiar Pregunta)");
		lblCampoOpcional.setBounds(80, 180, 219, 15);
		panel.add(lblCampoOpcional);
		lblCampoOpcional.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		pregunta = new JComboBoxBD1(rb.getString("SQL_COMBO_PREGUNTA"));
		pregunta.setBounds(80, 206, 332, 20);
		panel.add(pregunta);
		
		JLabel lblDeseaCambiarLa = new JLabel("Desea cambiar su respuesta:");
		lblDeseaCambiarLa.setBounds(80, 246, 194, 15);
		panel.add(lblDeseaCambiarLa);
		lblDeseaCambiarLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtResp = new JTextField();
		txtResp.setBounds(302, 244, 128, 19);
		panel.add(txtResp);
		txtResp.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtResp.setColumns(10);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 135, 30);
		usuario.add(toolBar);
		
		btnGuardar = new JButton("");
		btnGuardar.setIcon(new ImageIcon(FrmCambiar.class.getResource("/Iconos_PlacaMas/_Save.png")));
		toolBar.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent e) {
		

		String clave=txtPassAct.getText();
		String clavelog = FrmLogin.txtClave.getText();
		
		String resp=txtResp.getText();
		String pass1=txtPassNew1.getText();
		String pass=txtPassNew.getText();
		
		String log=FrmLogin.txtLogin.getText();
		
		
		clave=clave.replaceAll(" ", "");
		pass=pass.replaceAll(" ", "");
		pass1=pass1.replaceAll(" ", "");
		resp=resp.replaceAll(" ", "");
        
        	
        if(clave.length()==0 || pass1.length()==0 || pass.length()==0 || resp.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }  
        else
        	if(txtPassAct.getText().equals(FrmLogin.txtClave.getText()) && txtPassNew.getText().equals(txtPassNew1.getText())){
        	estado=true;
		        if(estado==true){ 	
				
		        	UsuarioBean bean =  obj.cambiarContraseña(pass,pregunta.getSelectedItem().toString(),txtResp.getText(), log );
		        	if(bean!= null){
					mensaje("Cambio de contraseña");
					}
		        	
	        	  }
	        	}
        	
         else{
		        	mensaje("campos incorrectos");
		        }
      }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub     
	}
}

	