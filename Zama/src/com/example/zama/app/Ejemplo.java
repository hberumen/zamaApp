package com.example.zama.app;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window;

public class Ejemplo extends CustomComponent {


	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private VerticalLayout mainLayout;
	@AutoGenerated
	private Panel panel_1;
	@AutoGenerated
	private VerticalLayout verticalLayout_2;
	@AutoGenerated
	private Table tblCrud;
	@AutoGenerated
	private Button btnAgregar;
	private static final long serialVersionUID = 2538247688254545470L;
	
	
	public Ejemplo() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
		init();
	}
	
	
	private void init(){
		btnAgregar.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 6394222656168788973L;
			@Override
			public void buttonClick(ClickEvent event) {
				btnAgregarAction();
			}
		});
		
		tblCrud.setSelectable(true);
		tblCrud.setNullSelectionAllowed(true);
		tblCrud.addContainerProperty("Nombre", String.class, null);
		tblCrud.addContainerProperty("Edad", String.class, null);
		tblCrud.setPageLength(5);
		
	}

	protected void btnAgregarAction() {
		
		final Window ventana = new Window();
		ventana.setModal(true);
		ventana.center();
		ventana.setHeight("50%");
		
		FormLayout fl = new FormLayout();
		fl.setWidth("50%");
		
		final TextField txtNombre = new TextField("Nombre");
		final TextField txtEdad = new TextField("Edad");
		Button btnSalir = new Button("Salir");
		btnSalir.addClickListener(new Button.ClickListener() {
			private static final long serialVersionUID = 4112060529940927753L;
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().removeWindow(ventana);
			}
		});
		
		fl.addComponent(txtNombre);
		fl.addComponent(txtEdad);
		fl.addComponent(btnSalir);
		
		ventana.setContent(fl);
		ventana.addCloseListener(new Window.CloseListener() {
			private static final long serialVersionUID = 3326042192744066443L;
			@Override
			public void windowClose(CloseEvent e) {
				
				tblCrud.addItem(new Object[]{txtNombre.getValue().toString(), txtEdad.getValue().toString()},new Integer(1));
			}
		});
		
		UI.getCurrent().addWindow(ventana);
	
		
		
		
	}


	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("-1px");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("-1px");
		
		// panel_1
		panel_1 = buildPanel_1();
		mainLayout.addComponent(panel_1);
		mainLayout.setComponentAlignment(panel_1, new Alignment(20));
		
		return mainLayout;
	}

	@AutoGenerated
	private Panel buildPanel_1() {
		// common part: create layout
		panel_1 = new Panel();
		panel_1.setCaption("CRUD");
		panel_1.setImmediate(false);
		panel_1.setWidth("90.0%");
		panel_1.setHeight("-1px");
		
		// verticalLayout_2
		verticalLayout_2 = buildVerticalLayout_2();
		panel_1.setContent(verticalLayout_2);
		
		return panel_1;
	}

	@AutoGenerated
	private VerticalLayout buildVerticalLayout_2() {
		// common part: create layout
		verticalLayout_2 = new VerticalLayout();
		verticalLayout_2.setImmediate(false);
		verticalLayout_2.setWidth("100.0%");
		verticalLayout_2.setHeight("100.0%");
		verticalLayout_2.setMargin(false);
		
		// btnAgregar
		btnAgregar = new Button();
		btnAgregar.setCaption("Agregar");
		btnAgregar.setImmediate(false);
		btnAgregar.setWidth("-1px");
		btnAgregar.setHeight("-1px");
		verticalLayout_2.addComponent(btnAgregar);
		
		// tblCrud
		tblCrud = new Table();
		tblCrud.setImmediate(false);
		tblCrud.setWidth("100.0%");
		tblCrud.setHeight("-1px");
		verticalLayout_2.addComponent(tblCrud);
		
		return verticalLayout_2;
	}

}
