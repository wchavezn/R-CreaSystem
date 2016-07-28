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
		//textura.addMouseListener((MouseListener) this);
		usuario.setLayout(null);
		/*
		setTitle("Textura");
		setClosable(true);
		setBounds(100, 100, 577, 511);
		getContentPane().setLayout(null);*/
		
		JLabel lblPassActual = new JLabel("Ingresar Contrase�a Actual:");
		lblPassActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassActual.setBounds(52, 48, 175, 19);
		usuario.add(lblPassActual);
		
		txtPassAct = new JTextField();
		txtPassAct.setBounds(276, 46, 128, 19);
		txtPassAct.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		usuario.add(txtPassAct);
		txtPassAct.setColumns(10);
		
		JLabel lblNuevaCont = new JLabel("Ingresar Nueva Contase�a:");
		lblNuevaCont.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNuevaCont.setBounds(52, 78, 175, 15);
		usuario.add(lblNuevaCont);
		
		txtPassNew = new JTextField();
		txtPassNew.setBounds(276, 76, 128, 19);
		usuario.add(txtPassNew);
		txtPassNew.setColumns(10);
		
		JLabel lblRepetaLaContrasea = new JLabel("Repeta la Contrase�a:");
		lblRepetaLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepetaLaContrasea.setBounds(52, 108, 137, 15);
		usuario.add(lblRepetaLaContrasea);
		
		txtPassNew1 = new JTextField();
		txtPassNew1.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPassNew1.setColumns(10);
		txtPassNew1.setBounds(276, 106, 128, 19);
		usuario.add(txtPassNew1);
		
		separator = new JSeparator();
		separator.setBounds(10, 140, 480, 14);
		usuario.add(separator);
		
		JLabel lblCampoOpcional = new JLabel("Campo Opcional(Cambiar Pregunta)");
		lblCampoOpcional.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCampoOpcional.setBounds(52, 146, 219, 15);
		usuario.add(lblCampoOpcional);
		
		txtPalabClave = new JTextField();
		txtPalabClave.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPalabClave.setColumns(10);
		txtPalabClave.setBounds(276, 202, 128, 19);
		usuario.add(txtPalabClave);
		
		JLabel lblDeseaCambiarLa = new JLabel("Desea cambiar su respuesta:");
		lblDeseaCambiarLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeseaCambiarLa.setBounds(52, 204, 194, 15);
		usuario.add(lblDeseaCambiarLa);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(97, 254, 89, 23);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		usuario.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(250, 254, 89, 23);
		usuario.add(btnCancelar);
		
		pregunta = new JComboBoxBD(rb.getString("SQL_COMBO_PREGUNTA"));
		pregunta.setBounds(62, 171, 332, 20);
		usuario.add(pregunta);
		
		
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
			
	        	UsuarioBean bean =  obj.cambiarContrase�a(pass, log );
	        	if(bean!= null){
				mensaje("Cambio de contrase�a");
				}
        	  }
	        }
      }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub     
	}
}

	