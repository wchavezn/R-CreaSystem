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
	private JButton btnCancelar;
	JComboBoxBD pregunta;
	public JPanel usuario;
	JSeparator separator;
	private JTextField txtPassNew1;
	private JTextField txtPalabClave;
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
		
		pregunta = new JComboBoxBD(rb.getString("SQL_COMBO_PREGUNTA"));
		pregunta.setBounds(80, 206, 332, 20);
		panel.add(pregunta);
		
		JLabel lblDeseaCambiarLa = new JLabel("Desea cambiar su respuesta:");
		lblDeseaCambiarLa.setBounds(80, 246, 194, 15);
		panel.add(lblDeseaCambiarLa);
		lblDeseaCambiarLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtPalabClave = new JTextField();
		txtPalabClave.setBounds(302, 244, 128, 19);
		panel.add(txtPalabClave);
		txtPalabClave.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPalabClave.setColumns(10);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(287, 318, 89, 23);
		panel.add(btnCancelar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(134, 318, 89, 23);
		panel.add(btnGuardar);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent e) {
		

		String clave=txtPassAct.getText();
		String clavelog = FrmLogin.txtClave.getText();
		
		String pass1=txtPassNew1.getText();
		String pass=txtPassNew.getText();
		
		String log=FrmLogin.txtLogin.getText();
		
		
		clave=clave.replaceAll(" ", "");
       
        
        if(clave.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        	if(txtPassAct.getText().equals(FrmLogin.txtClave.getText()) || txtPassNew.getText().equals(txtPassNew1.getText())){
        	estado=true;
	        if(estado==true){ 	
			
	        	UsuarioBean bean =  obj.cambiarContraseña(pass, log );
	        	if(bean!= null){
				mensaje("Cambio de contraseña");
				}
        	  }
	        }
      }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub     
	}
}

	