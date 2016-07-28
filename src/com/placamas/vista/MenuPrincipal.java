package com.placamas.vista;

import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JTree;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.placamas.beans.OpcionBean; 
import com.placamas.biblioteca.FrmTableros;
import com.placamas.biblioteca.FrmTapacantos;
import com.placamas.biblioteca.FrmRanuras;
import com.placamas.biblioteca.FrmBisagrado;
import com.placamas.biblioteca.FrmPuerta_Corre;
import com.placamas.controlador.UsuarioControlador;
import com.placamas.seguridad.FrmControlUsuarios;
import com.placamas.seguridad.FrmCambiar;
import com.placamas.listado.FrmMantenimientoLP;
import com.placamas.listado.FrmListado_Pieza;

import java.awt.Font;
import java.awt.Color;


public class MenuPrincipal extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	JPanel contenedor;
	JMenuBar menuBar;
    ClosableTabbedPane tabbedPane;
	
	
	private JMenu  mMenu01	  	 = new JMenu("Listado de Piezas");
	private JMenu  mMenu02	  	 = new JMenu("Materiales y Servicios");
	private JMenu  mMenu03	  	 = new JMenu("Par\u00E1metros");
	private JMenu  mMenu04	  	 = new JMenu("Usuarios");
	private JMenu  mMenu05	  	 = new JMenu("Ayuda");
	
    ////////////////////////////////////////////////////////////////////////
	                 /* ITEMS DEL MENU LISTA DE PIEZAS*/
	////////////////////////////////////////////////////////////////////////
	
	public JMenuItem mItem01    = new JMenuItem("Nueva LP");
	public JMenuItem mItem02    = new JMenuItem("Listado de LP'S & Seguimiento");
	public JMenuItem mItem03    = new JMenuItem("Seguimiento");
	
    ////////////////////////////////////////////////////////////////////////
                     /* ITEMS DEL MENU ADMINISTRACI�N*/
    ////////////////////////////////////////////////////////////////////////

	public JMenuItem mItem04    = new JMenuItem("Tableros");
	public JMenuItem mItem05    = new JMenuItem("Tapacantos");
	public JMenuItem mItem06    = new JMenuItem("Ranuras");
	public JMenuItem mItem07    = new JMenuItem("Bisagrados");
	public JMenuItem mItem08    = new JMenuItem("Puertas Corredizas");
	
	 ////////////////////////////////////////////////////////////////////////
                     /* ITEMS DEL MENU PAR�METROS*/
    ////////////////////////////////////////////////////////////////////////
	
	public JMenuItem mItem09    = new JMenuItem("Marcas");
	public JMenuItem mItem10    = new JMenuItem("Material");
	public JMenuItem mItem11    = new JMenuItem("Texturas");
	public JMenuItem mItem12    = new JMenuItem("Colores");
	public JMenuItem mItem13    = new JMenuItem("Medidas");
	public JMenuItem mItem14    = new JMenuItem("Locales");
	public JMenuItem mItem15    = new JMenuItem("Ruta de Archivos");
	public JMenuItem mItem16    = new JMenuItem("Reglas de Sistema");
	
	////////////////////////////////////////////////////////////////////////
					/* ITEMS DEL MENU USUARIOS*/
	////////////////////////////////////////////////////////////////////////
	
	public JMenuItem mItem17    = new JMenuItem("Gesti�n de Usuarios");
	public JMenuItem mItem18    = new JMenuItem("Control de Usuarios");
	public JMenuItem mItem19    = new JMenuItem("Cambiar Contrase�a");


	////////////////////////////////////////////////////////////////////////
					/* ITEMS DEL MENU LISTADO*/
    ////////////////////////////////////////////////////////////////////////
	
	
	
	private List<JMenuItem> listaItemMenus = new ArrayList<>();
	private List<JMenu> listaMenus = new ArrayList<>();
	
	//Biblioteca
		private FrmTableros FrmTableros=new FrmTableros();
		private FrmTapacantos FrmTapacantos=new FrmTapacantos();
		private FrmRanuras FrmRanuras = new FrmRanuras();
		private FrmBisagrado FrmBisagrado = new FrmBisagrado();
		private FrmPuerta_Corre FrmPuerta_Corre= new FrmPuerta_Corre();
	//1 Se crean los formularios
		private FrmListado_Pieza FrmListado_Pieza = new FrmListado_Pieza();
		private FrmMantenimientoLP FrmMantenimientoLP = new FrmMantenimientoLP(); 
		private FrmLocales FrmLocales = new FrmLocales(); 
		private FrmMarcas FrmMarcas = new FrmMarcas(); 
		private FrmColores FrmColores = new FrmColores();
		private FrmTextura FrmTextura = new FrmTextura();
		private FrmMaterial FrmMaterial = new FrmMaterial(); 
		private FrmMedidas FrmMedidas = new FrmMedidas();
		private FrmRutas FrmRutas = new FrmRutas();
		private FrmReglas FrmReglas = new FrmReglas();
		
	    //*FORMULARIOS DE USUARIOS
		
		private FrmControlUsuarios FrmControlUsuarios = new FrmControlUsuarios();
		private FrmCambiar FrmCambiar = new FrmCambiar();

		
		private UsuarioControlador model = new UsuarioControlador();
		
	//BARRA DE HERRAMIENTAS
    	
    private final JButton btnNuevoPrincipal = new JButton("");
    private final JButton btnConfiguracionPrincipal = new JButton("");
    private final JButton btnReportesPrincipal = new JButton("");
    
    
    public MenuPrincipal() {
    	
		tabbedPane = new ClosableTabbedPane();
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBorder(new LineBorder(new Color(153, 180, 209), 0));
		tabbedPane.setBackground(SystemColor.inactiveCaption);
	    tabbedPane.setBounds(219, 11, 968, 783);
    	
    	
		menuBar = new JMenuBar();
		
		menuBar.setForeground(Color.BLACK);
		mItem01.setFont(new Font("Segoe UI", Font.PLAIN, 12));
	    
	    
    	contenedor = new JPanel();
    	contenedor.setLayout(new BorderLayout());
    	
    	
    	contenedor.setBorder(new LineBorder(SystemColor.activeCaption));
    	contenedor.setBounds(10, 23, 655, 480);
    	
    	
		JToolBar toolBar = new JToolBar();
		contenedor.add(toolBar, BorderLayout.NORTH);
		toolBar.setBounds(0, 0, 735, 39);
		
		btnNuevoPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNuevoPrincipal.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/toolbaricons/1466129630_edit2.png")));
		toolBar.add(btnNuevoPrincipal);		
		
		btnConfiguracionPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 11));	
		btnConfiguracionPrincipal.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/toolbaricons/1466129636_Working_Tools_2.png")));
		toolBar.add(btnConfiguracionPrincipal);
		
		btnReportesPrincipal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnReportesPrincipal.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/toolbaricons/1466129655_BarChart.png")));
		toolBar.add(btnReportesPrincipal);
		
		//----------------------------------------------------------------
		
		contenedor.add(tabbedPane,BorderLayout.CENTER);
        
		DefaultMutableTreeNode listar = new DefaultMutableTreeNode("Listar Piezas                                ");
		DefaultTreeModel modelo = new DefaultTreeModel(listar);			
		
		JTree tree=new JTree(modelo); 
		tree.setBorder(new LineBorder(SystemColor.activeCaption));
		contenedor.add(tree,BorderLayout.WEST);
		
		//carpetas contenedoras
				DefaultMutableTreeNode padre= new DefaultMutableTreeNode("padre");
				DefaultMutableTreeNode tio = new DefaultMutableTreeNode("tio");
				modelo.insertNodeInto(padre, listar, 0);
				modelo.insertNodeInto(tio, listar, 1);
				
					//Sub de Padre
					DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("hijo");
					DefaultMutableTreeNode hija = new DefaultMutableTreeNode("hija");
					modelo.insertNodeInto(hijo, padre, 0);
					modelo.insertNodeInto(hija, padre, 1);
			
		//LISTAMOS EN SUBMENU			
					listaMenus.add(mMenu01);
					listaMenus.add(mMenu02);
					listaMenus.add(mMenu03);
					listaMenus.add(mMenu04);
					
		//LISTAMOS LAS VISTAS(PESTA�AS) SEGUN EL MENU QUE TENEMOS
				
					listaItemMenus.add(mItem01);
					listaItemMenus.add(mItem02);
					listaItemMenus.add(mItem03);
					listaItemMenus.add(mItem04);
					listaItemMenus.add(mItem05);
					listaItemMenus.add(mItem06);
					listaItemMenus.add(mItem07);
					listaItemMenus.add(mItem08);
					listaItemMenus.add(mItem09);
					listaItemMenus.add(mItem10);
					listaItemMenus.add(mItem11);
					listaItemMenus.add(mItem12);
					listaItemMenus.add(mItem13);
					listaItemMenus.add(mItem14);
					listaItemMenus.add(mItem15);
					listaItemMenus.add(mItem16);
					listaItemMenus.add(mItem17);
					listaItemMenus.add(mItem18);
					listaItemMenus.add(mItem19);
									
		
					
		//VOLVEMOS INVISIBLES LAS VISTAS PARA PODER DARLES LOS ACCESOS
					
					mItem01.setVisible(false);
					mItem02.setVisible(false);
					mItem03.setVisible(false);
					mItem04.setVisible(false);
					mItem05.setVisible(false);
					mItem06.setVisible(false);
					mItem07.setVisible(false);
					mItem08.setVisible(false);
					mItem09.setVisible(false);
					mItem10.setVisible(false);
					mItem11.setVisible(false);
					mItem12.setVisible(false);
					mItem13.setVisible(false);
					mItem14.setVisible(false);
					mItem15.setVisible(false);
					mItem16.setVisible(false);
					mItem17.setVisible(false);
					mItem19.setVisible(false);
					

					mMenu01.setVisible(false);
					mMenu02.setVisible(false);
					mMenu03.setVisible(false);
					mMenu04.setVisible(false);

					
		//Listener de los MenuItem
		mItem01.addActionListener(this);
		mItem01.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem02.addActionListener(this);
		mItem02.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem03.addActionListener(this);
		mItem03.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem04.addActionListener(this);
		mItem04.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem05.addActionListener(this);
		mItem05.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem06.addActionListener(this);
		mItem06.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem07.addActionListener(this);
		mItem07.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem08.addActionListener(this);
		mItem08.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem09.addActionListener(this);
		mItem09.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem10.addActionListener(this);
		mItem10.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem11.addActionListener(this);
		mItem11.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem12.addActionListener(this);
		mItem12.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem13.addActionListener(this);
		mItem13.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem14.addActionListener(this);
		mItem14.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem15.addActionListener(this);
		mItem15.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem16.addActionListener(this);
		mItem16.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem17.addActionListener(this);
		mItem17.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem18.addActionListener(this);
		mItem18.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mItem19.addActionListener(this);
		mItem19.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			
		//-----------------------------------------------------------
		
		
		mItem01.setActionCommand("mItem01");
		mItem02.setActionCommand("mItem02");
		mItem03.setActionCommand("mItem03");
		mItem04.setActionCommand("mItem04");
		mItem05.setActionCommand("mItem05");
		mItem06.setActionCommand("mItem06");
		mItem07.setActionCommand("mItem07");
		mItem08.setActionCommand("mItem08");
		mItem09.setActionCommand("mItem09");
		mItem10.setActionCommand("mItem10");
		mItem11.setActionCommand("mItem11");
		mItem12.setActionCommand("mItem12");
		mItem13.setActionCommand("mItem13");
		mItem14.setActionCommand("mItem14");
		mItem15.setActionCommand("mItem15");
		mItem16.setActionCommand("mItem16");
		mItem17.setActionCommand("mItem17");
		mItem18.setActionCommand("mItem18");
		mItem19.setActionCommand("mItem19");
		
		
		
		
		//Barra de MENU
		mMenu01.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mMenu01);
		mMenu02.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mMenu02);
		mMenu03.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mMenu03);
		mMenu04.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mMenu04);
		mMenu05.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mMenu05);
		
		mMenu01.add(mItem01);
		mMenu01.add(mItem02);
		mMenu01.add(mItem03);
		mMenu02.add(mItem04);
		mMenu02.add(mItem05);
		mMenu02.add(mItem06);
		mMenu02.add(mItem07);
		mMenu02.add(mItem08);
		mMenu03.add(mItem09);
		mMenu03.add(mItem10);
		mMenu03.add(mItem11);
		mMenu03.add(mItem12);
		mMenu03.add(mItem13);
		mMenu03.add(mItem14);
		mMenu03.add(mItem15);
		mMenu03.add(mItem16);
		mMenu04.add(mItem17);
		mMenu04.add(mItem18);
		mMenu04.add(mItem19);
	
}

    public void actionPerformed(ActionEvent e) {
      	
		//LISTADO//	
		if(e.getSource()==mItem01){
			FrmMantenimientoLP.mantenimiento.setVisible(true);
			tabbedPane.add( FrmMantenimientoLP.mantenimiento, "Listado de Piezas  ");
		}
		
		//RESUMEN//		
		if(e.getSource()==mItem02){
			FrmListado_Pieza.listado.setVisible(true);
			tabbedPane.add( FrmListado_Pieza.listado, "Listado de LP'S & Seguimiento  ");
		}
		
		//SEGUIMIENTO//	
		if(e.getSource()==mItem03){
			JOptionPane.showMessageDialog(null, "Ventana Aun no creada");
			
		}
		
		//TABLEROS//
		if(e.getSource()==mItem04){
			FrmTableros.tablero.setVisible(true);
			tabbedPane.add( FrmTableros.tablero, "Tableros  ");

		}
		
		//TAPACANTOS//
		if(e.getSource()==mItem05){
			FrmTapacantos.tapacanto.setVisible(true);
			tabbedPane.add( FrmTapacantos.tapacanto, "Tapacantos  ");		
		}
		
		//RANURAS//
		if(e.getSource()==mItem06){
			FrmRanuras.ranura.setVisible(true);
			tabbedPane.add( FrmRanuras.ranura, "Ranuras  ");
		}
		
		//BISAGRADOS//
		if(e.getSource()==mItem07){
			FrmBisagrado.bisagrado.setVisible(true);
			tabbedPane.add( FrmBisagrado.bisagrado, "Bisagrados  ");

		}
		
		//PUERTAS CORREDIZAS//
		if(e.getSource()==mItem08){
			FrmPuerta_Corre.puerta.setVisible(true);
			tabbedPane.add( FrmPuerta_Corre.puerta, "Puertas Corredizas  ");

		}
		
		//MARCAS//
		if(e.getActionCommand() =="mItem09"){
			FrmMarcas.setVisible(true);
			tabbedPane.add(FrmMarcas.marcas, "Marcas    ");
			FrmMarcas.tbMarcas.requestFocus();
			FrmMarcas.tbMarcas.changeSelection(0,1,true, true);
			FrmMarcas.toFront();
		}
		
		//MATERIAL//
		if(e.getSource()==mItem10){
			tabbedPane.add(FrmMaterial.material, "Materiales    ");
			FrmMaterial.setVisible(true);

		}
		
		//TEXTURAS//
		if(e.getSource()==mItem11){
			tabbedPane.add(FrmTextura.textura, "Texturas    ");	
			FrmTextura.setVisible(true);
			FrmTextura.tbTextura.requestFocus();
			FrmTextura.tbTextura.changeSelection(0,0,true, true);
			
		}
		
		//COLORES//
		if(e.getSource()==mItem12){
			tabbedPane.add(FrmColores.colores, "Colores    ");
			FrmColores.setVisible(true);
			FrmColores.tbColores.requestFocus();
			FrmColores.tbColores.changeSelection(0,0,true, true);
		}
		
		//MEDIDAS//
		if(e.getSource()==mItem13){
			tabbedPane.add(FrmMedidas.medidas, "Medidas    ");
			FrmMedidas.setVisible(true);
			FrmMedidas.tbMedidas.requestFocus();
			FrmMedidas.tbMedidas.changeSelection(0,0,true, true);
			
		}
		
		//LOCALES//
		if(e.getSource()==mItem14){
			tabbedPane.add(FrmLocales.locales, "Locales    ");
			FrmLocales.setVisible(true);
			FrmLocales.tbLocales.requestFocus();
			FrmLocales.tbLocales.changeSelection(0,0,true, true);
			
		}
		
		//RUTA DE ARCHIVOS//
		if(e.getSource()==mItem15){
			tabbedPane.add(FrmRutas.rutas, "Ruta de Archivos    ");
			FrmRutas.setVisible(true);

		}
		
		//REGLAS DEL SISTEMA//
		if(e.getSource()==mItem16){
			tabbedPane.add(FrmReglas.reglas, "Reglas de Sistema    ");
			FrmRutas.setVisible(true);
			

		}
		
		//GESTION DE USUARIOS//
		if(e.getSource()==mItem17){
			
		
		}
		//CONTROL DE USUARIOS//
		if(e.getSource()==mItem18){
			FrmControlUsuarios.setVisible(true);
			tabbedPane.add(FrmControlUsuarios.control, "Control de Usuarios    ");	
		
		}
		
		//CAMBIAR CONTRASE�A//
		if(e.getSource()==mItem19){
			FrmCambiar.setVisible(true);
			tabbedPane.add(FrmCambiar.usuario, "Cambiar Contase�a    ");

		}
		
		
	}

	public void muestraOpciones(){

		//Mostrar los items
		List<OpcionBean> data = model.obtieneOpciones(FrmLogin.idUsuario);
		for (OpcionBean aux : data) {
			for (JMenuItem aux2 : listaItemMenus) {
				if(aux.getDescripcion().equalsIgnoreCase(aux2.getText())){
						aux2.setVisible(true);
						break;
				}
			}
			
		}
		
		//muestra los menus
		for (JMenu aux : listaMenus) {
			verificaMenu(aux);
		}
	}
	
	
	public void verificaMenu(JMenu aux){
		for (int i = 0; i < aux.getItemCount(); i++) {
			if(aux.getItem(i).isVisible()){
				aux.setVisible(true);
				break;
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent evento) {
		// TODO Auto-generated method stub
		
	}
	
	
	}
