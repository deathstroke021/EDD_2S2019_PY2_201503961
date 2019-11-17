package pruebaventanas;

import avl.ArbolAVL;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PruebaVentanas extends Application {
    
    ArrayList<String> carpetas = new ArrayList<String>();
    ArrayList<String> archivos = new ArrayList<String>();
    
    String usuario = "Fernando";
    
    //String partn1, partn2,partn3;
    Stack stack = new Stack(100);

    private Stage stagePrincipal;
    private AnchorPane rootPane;

    @Override
    public void start(Stage stagePrincipal) throws Exception {
        this.stagePrincipal = stagePrincipal;
        mostrarVentanaPrincipal();

    }

    /*
     * cargamos la ventana principal
     */
    public void mostrarVentanaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("VentanaPrincipal.fxml"));
            rootPane=(AnchorPane) loader.load();
            Scene scene = new Scene(rootPane);
            stagePrincipal.setTitle("Ventana Principal");
            stagePrincipal.setScene(scene);
            VentanaPrincipalController controller = loader.getController();
            controller.setProgramaPrincipal(this);
            stagePrincipal.show();
        } catch (IOException e) {
        }
    }

    public void mostrarVentanaSecundaria() {
        try {
            /*FXMLLoader loader = new FXMLLoader(PruebaVentanas.class.getResource("VentanaDos.fxml"));
            AnchorPane ventanaDos = (AnchorPane) loader.load();
            Stage ventana = new Stage();
            ventana.setTitle("Venta Dos");
            ventana.initOwner(stagePrincipal);
            Scene scene = new Scene(ventanaDos);
            ventana.setScene(scene);
            VentanaDosController controller = loader.getController();
            controller.setStagePrincipal(ventana);
            ventana.show();*/
            
            //Mostrar treeview 4 y eventos del arbol
            
            Stage ventana = new Stage();
            
            // Create the TreeViewHelper
		TreeViewHelper helper = new TreeViewHelper();
		// Get the Products
		ArrayList<TreeItem> products = helper.getProducts();

		// Make the TreeView editable
		treeView.setEditable(true);
		// Set a cell factory to use TextFieldTreeCell
		treeView.setCellFactory(TextFieldTreeCell.forTreeView());
		// Select the root node
		treeView.getSelectionModel().selectFirst();
		// Create the root node and adds event handler to it
		TreeItem rootItem = new TreeItem("/");
		// Add children to the root
		rootItem.getChildren().addAll(products); //crear padre
		// Set the Root Node
		treeView.setRoot(rootItem);
                
                
                //Modificar nodos
		// Set editing related event handlers (OnEditStart)
		treeView.setOnEditStart(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editStart(event);
			}
		});

		// Set editing related event handlers (OnEditCommit)
		treeView.setOnEditCommit(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editCommit(event);
			}
		});

		// Set editing related event handlers (OnEditCancel)
		treeView.setOnEditCancel(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editCancel(event);
			}
		});

		// Set tree modification related event handlers (branchExpandedEvent)
		rootItem.addEventHandler(TreeItem.<String>branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				branchExpended(event);
			}
		});

		// Set tree modification related event handlers (branchCollapsedEvent)
		rootItem.addEventHandler(TreeItem.<String>branchCollapsedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				branchCollapsed(event);
			}
		});

		// Set tree modification related event handlers (childrenModificationEvent)
		rootItem.addEventHandler(TreeItem.<String>childrenModificationEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				childrenModification(event);
			}
		});

		// Create the VBox
		VBox rightPane = getRightPane();

		// Create the HBox
		HBox root = new HBox();
		// Set the horizontal space between each child in the HBox
		root.setSpacing(20);
		// Add the TreeView to the HBox
		root.getChildren().addAll(treeView,rightPane);

		// Create the Scene
		Scene scene = new Scene(root,600,500);
		// Add the Scene to the Stage
		ventana.setScene(scene);
		// Set the Title for the Scene
		ventana.setTitle("EDD Drive");
		// Display the stage
		ventana.show();

        } catch (Exception e) {
        }
    }
    
    //Ejecucion edddrive

    public static void main(String[] args) { // Muestra el login
        launch(args);
        
       
    }
    
    // Construccion del treeview numero 4
    
    
    	// Create the TreeView
	private final TreeView<String> treeView = new TreeView<>();
	// Create the TextArea
        // Consola
	private final TextArea textArea = new TextArea();
	// Create the TextField
	private TextField textField = new TextField();

	/*public static void main(String[] args)
	{
		Application.launch(args);
	}*/

	/*@Override
	public void start(Stage stage)
	{
		// Create the TreeViewHelper
		TreeViewHelper helper = new TreeViewHelper();
		// Get the Products
		ArrayList<TreeItem> products = helper.getProducts();

		// Make the TreeView editable
		treeView.setEditable(true);
		// Set a cell factory to use TextFieldTreeCell
		treeView.setCellFactory(TextFieldTreeCell.forTreeView());
		// Select the root node
		treeView.getSelectionModel().selectFirst();
		// Create the root node and adds event handler to it
		TreeItem rootItem = new TreeItem("Vehicles");
		// Add children to the root
		rootItem.getChildren().addAll(products);
		// Set the Root Node
		treeView.setRoot(rootItem);

		// Set editing related event handlers (OnEditStart)
		treeView.setOnEditStart(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editStart(event);
			}
		});

		// Set editing related event handlers (OnEditCommit)
		treeView.setOnEditCommit(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editCommit(event);
			}
		});

		// Set editing related event handlers (OnEditCancel)
		treeView.setOnEditCancel(new EventHandler<TreeView.EditEvent<String>>()
		{
			@Override
			public void handle(TreeView.EditEvent<String> event)
			{
				editCancel(event);
			}
		});

		// Set tree modification related event handlers (branchExpandedEvent)
		rootItem.addEventHandler(TreeItem.<String>branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				branchExpended(event);
			}
		});

		// Set tree modification related event handlers (branchCollapsedEvent)
		rootItem.addEventHandler(TreeItem.<String>branchCollapsedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				branchCollapsed(event);
			}
		});

		// Set tree modification related event handlers (childrenModificationEvent)
		rootItem.addEventHandler(TreeItem.<String>childrenModificationEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeItem.TreeModificationEvent<String> event)
			{
				childrenModification(event);
			}
		});

		// Create the VBox
		VBox rightPane = getRightPane();

		// Create the HBox
		HBox root = new HBox();
		// Set the horizontal space between each child in the HBox
		root.setSpacing(20);
		// Add the TreeView to the HBox
		root.getChildren().addAll(treeView,rightPane);

		// Create the Scene
		Scene scene = new Scene(root,600,500);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title for the Scene
		stage.setTitle("TreeView Example 4");
		// Display the stage
		stage.show();
	}*/

	// This method creates a VBox and it´s components and returns it to the calling Method
        // Acomodar componentes
	private VBox getRightPane()
	{
		// Create the addItemBtn and its corresponding Event Handler
                // Boton añadir Items
		Button addItemBtn = new Button("Crear carpeta");
		addItemBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				addItem(textField.getText()); //Añade items
			}
		});
                
                Button addItemBtn2 = new Button("Crear archivo");
		addItemBtn2.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
                            
                                String string = textField.getText();
                                String[] parts = string.split(",");
                                String part1 = parts[0];
                                String part2 = parts[1];


				addItem2(part1, part2); //Añade items
			}
		});
                
                //Mostrar arreglo Opcional
                Button mBtn = new Button("Mostrar");
		mBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				mostrar();
			}
		});
                
                //Generar reporte AVL
                Button avlBtn = new Button("Reporte AVL");
		avlBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				reporteavl();
			}
		});
                
                //Generar bitacora
                Button bitBtn = new Button("Historial");
		bitBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				reportestack();
			}
		});


		// Create the removeItemBtn and its corresponding Event Handler
                //Boton eliminar items
		Button removeItemBtn = new Button("Eliminar");
		removeItemBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				removeItem();
			}
		});
                
                Button csvarBtn = new Button("Cargar archivos");
		csvarBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				csv();
			}
		});

		// Set the preferred number of text rows
		textArea.setPrefRowCount(15);
		// Set the preferred number of text columns
		textArea.setPrefColumnCount(25);

		// Create the HBox
		HBox hbox = new HBox();
		// Add Children to the HBox
		hbox.getChildren().addAll(new Label("Nombre:"), textField, addItemBtn);
                
                HBox hbox2 = new HBox();
		// Add Children to the HBox
		hbox2.getChildren().addAll(addItemBtn2,removeItemBtn,csvarBtn);
                
                HBox hbox3 = new HBox();
		// Add Children to the HBox
		hbox3.getChildren().addAll(avlBtn,bitBtn,mBtn);

		// Create the VBox
		VBox vbox = new VBox();
		// Add children to the VBox
		vbox.getChildren().addAll(new Label("Ingresar nombre de carpeta o archivo: archivo.ext,contenido"),new Label("Para cargar csv ingresar nombre del archivo"),hbox,hbox2,new Label("Reportes:"),hbox3, new Label("Consola:"), textArea);
				
		// Set the vertical space between each child in the VBox
		vbox.setSpacing(10);

		return vbox;
	}


	// Helper Method for Adding an Item
        // Agregar Item
	private void addItem(String value)
	{
		if (value == null || value.trim().equals(""))
		{
			this.writeMessage("Debe ingresar un nombre.");
			return;
		}

		TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();
                

		if (parent == null)
		{
			this.writeMessage("Seleccione un nodo.");
			return;
		}

		// Check for duplicate
                // Verificar repetidos
		for(TreeItem<String> child : parent.getChildren())
		{
			if (child.getValue().equals(value))
			{
				this.writeMessage(value + " ya existe en la carpeta " + parent.getValue());
				return;
			}
		}

		TreeItem<String> newItem = new TreeItem<String>(value);
		parent.getChildren().add(newItem);
                
                
                //Anadir padre e hijo
                String registro = usuario + ","+ newItem.getParent().getValue() + "," +newItem.getValue();
                carpetas.add(registro);

		if (!parent.isExpanded()) //Expande treeview
		{
			parent.setExpanded(true);
		}
                
                //opcional
                parent = newItem;
                TreeItem<String> inf = new TreeItem<String>("");
		parent.getChildren().add(inf);
	}
        
        private void addItem2(String value, String value2)
	{
		if (value == null || value.trim().equals(""))
		{
			this.writeMessage("Debe ingresar un nombre.");
			return;
		}

		TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();
                

		if (parent == null)
		{
			this.writeMessage("Seleccione un nodo.");
			return;
		}

		// Check for duplicate
                // Verificar repetidos
		for(TreeItem<String> child : parent.getChildren())
		{
                    //String vacio = "";
			if (child.getValue().equals(value))
			{
				this.writeMessage(value + " ya existe en la carpeta " + parent.getValue());
				return;
			}
                        
                        //Opcional
                        /*else if(child.getValue().equals(vacio))
			{
				parent.getChildren().remove(vacio);
			}*/
		}
                
 
		TreeItem<String> newItem = new TreeItem<String>(value);
                //parent.getChildren().remove("");
		parent.getChildren().add(newItem);
                
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                
                //Anadir padre e hijo
                String registro = usuario + ","+ newItem.getParent().getValue() + "," +newItem.getValue() + "," + value2 + "," + timestamp;
                archivos.add(registro);

		if (!parent.isExpanded()) 
		{
			parent.setExpanded(true);
		}
                      
                
	}
        
        private void csv(){
            
            TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();
                

		if (parent == null)
		{
			this.writeMessage("Seleccione un nodo.");
			return;
		}
                
                    String csvFile = textField.getText();
                    BufferedReader br = null;
                    String line = "";
                    //Se define separador ","
                    String cvsSplitBy = ",";
                    try {
                            br = new BufferedReader(new FileReader(csvFile));
                            while ((line = br.readLine()) != null) {
                                String[] datos = line.split(cvsSplitBy);
                                String sinComillas = datos[1].replace("\"", "");
                                
                                //Imprime datos.
                                 System.out.println(datos[0] + ", " + sinComillas);
                                 
                     if(!datos[0].equals("Archivo") && !sinComillas.equals("Contenido")){
                         
                
                TreeItem<String> newItem = new TreeItem<String>(datos[0]);
                //parent.getChildren().remove("");
		parent.getChildren().add(newItem);
 
		
                
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                
                //Anadir padre e hijo
                String registro = usuario + ","+ newItem.getParent().getValue() + "," +newItem.getValue() + "," + sinComillas + "," + timestamp;
                archivos.add(registro);
                
                if (!parent.isExpanded()) 
		{
			parent.setExpanded(true);
		}
                     }
    }
                            
                            //Excepciones
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
} finally {
    if (br != null) {
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
           
        } //FIN METODO CSV UN PUTO DESASTRE
        
        private void mostrar(){
             System.out.println("Carpetas");
            Iterator<String> nombreIterator = carpetas.iterator();
            while(nombreIterator.hasNext()){
                String elemento = nombreIterator.next();
                System.out.print(elemento+"\n");
	
                
            }
            
            System.out.println("Archivos");
            Iterator<String> nombreIterator2 = archivos.iterator();
            while(nombreIterator2.hasNext()){
                String elemento = nombreIterator2.next();
                System.out.print(elemento+"\n");
	
                
            }
            


        }
        
        private void reporteavl(){
            
            TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();
                

		if (parent == null)
		{
			this.writeMessage("Seleccione un nodo.");
			return;
		}
                
                System.out.println("Usuario:" + usuario);
                System.out.println("Carpeta: " + parent.getValue());
                
                /*for(int x=0;x<archivos.size();x++) {
                    
                    String string = archivos.get(x);
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                String part2 = parts[1];
                                String part3 = parts[2];
                                String part4 = parts[3];
                                String part5 = parts[4];
                                
                                if(part1 == usuario && part2 == parent.getValue()){
                                    
                                    System.out.println(archivos.get(x));
                                    
                                }
                                

                }*/
                ArbolAVL arbol_texto=new ArbolAVL();
        //Llenamos con información el árbol
        /*arbol_texto.insertar("Juan");
        arbol_texto.insertar("Pedro");
        arbol_texto.insertar("María");
        arbol_texto.insertar("Roberto");
        arbol_texto.insertar("Teodoro");
        arbol_texto.insertar("Manuel");
        arbol_texto.insertar("Diego");
        arbol_texto.insertar("Alejandro");
        arbol_texto.insertar("Margarita");
        arbol_texto.insertar("Luis");
        arbol_texto.insertar("Hernán");
        arbol_texto.insertar("Jaime");
        arbol_texto.insertar("Ana");
        arbol_texto.insertar("Francisco");
        arbol_texto.insertar("Andrea");*/
  
                
                Object[] array = archivos.toArray();
                
                for(int i=0;i<array.length;i++){
                    
                    System.out.println(array[i].toString());
                    
                    String string = array[i].toString();
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                //System.out.println(part1);
                                String part2 = parts[1];
                                //System.out.println(part2);
                                String part3 = parts[2];
                                //System.out.println(part3);
                                String part4 = parts[3];
                                //System.out.println(part4);
                                String part5 = parts[4];
                                //System.out.println(part5);
                                
                                //System.out.println(usuario);
                                //System.out.println(parent.getValue());
                                
                                if(part1.equals(usuario) && part2.equals(parent.getValue())){
                                    
                                    System.out.println("Existe archivo");
                                    
                                    arbol_texto.insertar(part3,part4,part5,part1);
      
                                    
                                }
                                else{
                                    System.out.println("No Existe archivo");
                                }
                    
                }
                
        //Graficamos el árbol generando la imagen arbol_texto.jpg
        arbol_texto.graficar("arbol_texto.jpg");
        //Imprimimos el contenido del árbol ordenado
        arbol_texto.inorden();
        
        //Runtime.getRuntime().exec(new String[]{"cmd", "/c","start chrome http://goo.gl/EsomR0"});
        navegadoravlrep();
        
        }
        
        public void reportestack(){
            
                /*stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);*/

                stack.dot();
                
                navegadorstackrep();
                
            
        }

	// Helper Method for Removing an Item
        //Eliminar Item
	private void removeItem()
	{
		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

		if (item == null)
		{
			this.writeMessage("Seleccione un nodo.");
			return;
		}

		TreeItem<String> parent = item.getParent();
		if (parent == null )
		{
			this.writeMessage("No se puede remover la raiz.");
		}
		else
		{
                    
                    Object[] array = archivos.toArray();
                
                for(int i=0;i<array.length;i++){
                    
                    //System.out.println(array[i].toString());
                    
                    String string = array[i].toString();
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                //System.out.println(part1);
                                String part2 = parts[1];
                                //System.out.println(part2);
                                String part3 = parts[2];
                                //System.out.println(part3);
                                String part4 = parts[3];
                                //System.out.println(part4);
                                String part5 = parts[4];
                                //System.out.println(part5);
                                
                                //System.out.println(usuario);
                                //System.out.println(parent.getValue());
                                
                                if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(item.getValue())){
                                    
                                    System.out.println("Existe archivo");
                                    
                                    Iterator<String> nombreIterator = archivos.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3+","+part4+","+part5);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3+","+part4+","+part5))
                                            nombreIterator.remove();
                                        }// Eliminamos el Elemento que hemos obtenido del Iterator
                 
                                    
                                }
                                
                                else if(part1.equals(usuario) && part2.equals(item.getValue())){
                                    
                                    System.out.println("Existe carpeta");
                                    
                                    Iterator<String> nombreIterator = archivos.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3+","+part4+","+part5);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3+","+part4+","+part5))
                                            nombreIterator.remove();
                                        }
                                    Iterator<String> nombreIterator2 = carpetas.iterator();
                                    while(nombreIterator2.hasNext()){
                                        String elemento = nombreIterator2.next();
                                        System.out.println(usuario+","+item.getParent().getValue()+","+item.getValue());
                                        
                                        if(elemento.equals(usuario+","+item.getParent().getValue()+","+item.getValue()))
                                            nombreIterator2.remove();
                                        }
                                    
                                    
                                }
                                else{
                                    System.out.println("No Existe archivo");
                                }
                    
                }
		
                                    Object[] array2 = carpetas.toArray();
                
                for(int i=0;i<array2.length;i++){
                    
                    //System.out.println(array[i].toString());
                    
                    String string = array2[i].toString();
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                //System.out.println(part1);
                                String part2 = parts[1];
                                //System.out.println(part2);
                                String part3 = parts[2];
                                //System.out.println(part3);
                                
                                //System.out.println(usuario);
                                //System.out.println(parent.getValue());
                                
                                if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(item.getValue())){
                                    
                                    System.out.println("Existe carpeta");
                                    
                                    Iterator<String> nombreIterator = carpetas.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3))
                                            nombreIterator.remove();
                                        }// Eliminamos el Elemento que hemos obtenido del Iterator
                 
                                    
                                }
                                
                                
                                else{
                                    System.out.println("No Existe carpeta");
                                }
                    
                }
                
                parent.getChildren().remove(item);
		}
                
                
                
                
	     
	}
        
        

	// Helper Methods for the Event Handlers
        // Informacion de la consola
	private void branchExpended(TreeItem.TreeModificationEvent<String> event)
	{
		String nodeValue = event.getSource().getValue().toString();
		this.writeMessage("Node " + nodeValue + " expanded.");
	}

	private void branchCollapsed(TreeItem.TreeModificationEvent<String> event)
	{
		String nodeValue = event.getSource().getValue().toString();
		this.writeMessage("Node " + nodeValue + " collapsed.");
	}

	private void childrenModification(TreeItem.TreeModificationEvent<String> event)
	{
		if (event.wasAdded())
		{
			for(TreeItem<String> item : event.getAddedChildren())
			{
				
                                
                                if(item.getValue() != ""){
                                    
                                    
                                    this.writeMessage("Node " + item.getValue() + " has been added.");
                                    //this.writeMessage("Ruta: ");
                                    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                    
                                    String com= "El nodo" + item.getValue() + " a sido creado."+ " Timestamp:" + timestamp + " Usuario:" + usuario;
                                    stack.push(com);
                                    

                                }
                                
                                
			}
                        
                        
                        //getParent()
		}

		if (event.wasRemoved())
		{
			for(TreeItem<String> item : event.getRemovedChildren())
			{
				this.writeMessage("Node " + item.getValue() + " has been removed.");
                                
                                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                    
                                    String com= "El nodo" + item.getValue() + " a sido eliminado."+ " Timestamp:" + timestamp + " Usuario:" + usuario;
                                    stack.push(com);
			}
		}
	}

	private void editStart(TreeView.EditEvent<String> event)
	{
		this.writeMessage("Started editing: " + event.getTreeItem() );
	}

	private void editCommit(TreeView.EditEvent<String> event)
	{
		this.writeMessage(event.getTreeItem() + " changed." +
				" old = " + event.getOldValue() +
				", new = " + event.getNewValue());
                
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                    
                                    String com= "El nodo" + event.getTreeItem().getValue() + "a sido modificado."+ " Timestamp:" + timestamp + " Usuario:" + usuario;
                                    stack.push(com);
                                    
                TreeItem<String> parent = event.getTreeItem().getParent();
                
                Object[] array = archivos.toArray();
                
                for(int i=0;i<array.length;i++){
                    
                    
                    //System.out.println(array[i].toString());
                    
                    String string = array[i].toString();
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                //System.out.println(part1);
                                String part2 = parts[1];
                                //System.out.println(part2);
                                String part3 = parts[2];
                                //System.out.println(part3);
                                String part4 = parts[3];
                                //System.out.println(part4);
                                String part5 = parts[4];
                                //System.out.println(part5);
                                
                                //System.out.println(usuario);
                                //System.out.println(parent.getValue());
                                
                                if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(event.getOldValue())){
                                    
                                    System.out.println("Existe archivo");
                                    
                                    if(!event.getNewValue().equals("")){
                                        Iterator<String> nombreIterator = archivos.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3+","+part4+","+part5);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3+","+part4+","+part5)){
                                            //nombreIterator.remove();
                                            int count = 0;
                                            for(int k=0;k<array.length;k++){
                                            
                                            if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(event.getNewValue())){
                                                count++;
                                            }
                                            }
                                            
                                            if(count == 0){
                                            archivos.set(i,part1+","+part2+","+event.getNewValue()+","+part4+","+part5);
                                            }
                                            else{
                                                this.writeMessage("No se ha modificado,ya existe archivo con ese nombre");
                                            }
                                        
                                        }
                
                                        }// Eliminamos el Elemento que hemos obtenido del Iterator
                                        
                                    }
                                    
                                    else{
                                        this.writeMessage("No se ha modificado,no puede dejar vacio el nombre del archivo");
                                    }
                                    
                                    
                 
                                    
                                }
                                
                                
                                else if(part1.equals(usuario) && part2.equals(event.getOldValue())){
                                    
                                    System.out.println("Existe carpeta");
                                    if(!event.getNewValue().equals("")){
                                        Iterator<String> nombreIterator = archivos.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3+","+part4+","+part5);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3+","+part4+","+part5)){
                                            //nombreIterator.remove();
                                            int count = 0;
                                            for(int k=0;k<array.length;k++){
                                            
                                            if(part1.equals(usuario) && part2.equals(event.getNewValue())){
                                                count++;
                                            }
                                            }
                                            
                                            if(count == 0){
                                            archivos.set(i,part1+","+event.getNewValue()+","+part3+","+part4+","+part5);
                                            }
                                            else{
                                                this.writeMessage("No se ha modificado,ya existe carpeta con ese nombre");
                                            }
                                            
                                            
                                        }
                                            
                                        }
                                   /* Iterator<String> nombreIterator2 = carpetas.iterator();
                                    int j = 0;
                                    while(nombreIterator2.hasNext()){
                                        String elemento = nombreIterator2.next();
                                        System.out.println(usuario+","+parent.getValue()+","+event.getOldValue());
                                        
                                        if(elemento.equals(usuario+","+parent.getValue()+","+event.getOldValue())){
                                            //nombreIterator2.remove();
                                            carpetas.set(j,part1+","+parent.getValue()+","+event.getNewValue());}
                                        j++;
                                        }*/
                                        
                                    }
                                    
                                    /*else{
                                        this.writeMessage("No se puede dejar vacio el nombre de carpeta");
                                    }*/
                                    
                       
                                }
                                else{
                                    System.out.println("No Existe archivo");
                                }
                    
                }
                
                Object[] array2 = carpetas.toArray();
                
                for(int i=0;i<array2.length;i++){
                    
                    //System.out.println(array[i].toString());
                    
                    String string = array2[i].toString();
                    String[] parts = string.split(",");
                                String part1 = parts[0];
                                //System.out.println(part1);
                                String part2 = parts[1];
                                //System.out.println(part2);
                                String part3 = parts[2];
                                //System.out.println(part3);
                                
                                //System.out.println(usuario);
                                //System.out.println(parent.getValue());
                                
                                if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(event.getOldValue())){
                                    
                                    System.out.println("Existe carpeta");
                                    
                                    if(!event.getNewValue().equals("")){
                                    Iterator<String> nombreIterator = carpetas.iterator();
                                    while(nombreIterator.hasNext()){
                                        String elemento = nombreIterator.next();
                                        System.out.println(part1+","+part2+","+part3);
                                        
                                        if(elemento.equals(part1+","+part2+","+part3)){
                                            
                                            int count = 0;
                                            for(int k=0;k<array2.length;k++){
                                            
                                            if(part1.equals(usuario) && part2.equals(parent.getValue()) && part3.equals(event.getNewValue())){
                                                count++;
                                            }
                                            }
                                            
                                            if(count == 0){
                                            carpetas.set(i,part1+","+part2+","+event.getNewValue());
                                            }
                                            else{
                                                this.writeMessage("No se ha modificado,ya existe carpeta con ese nombre");
                                            }
                                            //partn1 = part1;
                                            //partn2 = part2;
                                            //partn3 = event.getNewValue();
                                            
                                        
                                            //nombreIterator.remove();
                                        }
                                            
                                        }// Eliminamos el Elemento que hemos obtenido del Iterator
                                    }
                                    else{
                                        this.writeMessage("No se puede dejar vacio el nombre de carpeta");
                                    }
                                    
                 
                                    
                                }
                                
                                
                                else{
                                    System.out.println("No Existe carpeta");
                                }
                    //String registro = partn1 + ","+ partn2 + "," + partn3;
                    //carpetas.add(registro);
                }
	}

	private void editCancel(TreeView.EditEvent<String> e)
	{
		this.writeMessage("Cancelled editing: " + e.getTreeItem() );
	}

	// Method for Logging
	private void writeMessage(String msg)
	{
		this.textArea.appendText(msg + "\n");
	}
        
        
        private void navegadoravlrep(){
            Runtime myRuntime = Runtime.getRuntime();
            
            
            try{
                myRuntime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.EXE file:///C:/Users/Fernando%20Armira/Downloads/Git/EDD_2S2019_PY2_201503961/PruebaVentanas/arbol_texto.jpg");
                
            }
            catch(Exception ex){
                ex.printStackTrace();
                
            }



        }
        
        private void navegadorstackrep(){
            Runtime myRuntime = Runtime.getRuntime();
            
            
            try{
                myRuntime.exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.EXE file:///C:/Users/Fernando%20Armira/Downloads/Git/EDD_2S2019_PY2_201503961/PruebaVentanas/stack.jpg");
                
            }
            catch(Exception ex){
                ex.printStackTrace();
                
            }



        }
        
        
        
        
        
}