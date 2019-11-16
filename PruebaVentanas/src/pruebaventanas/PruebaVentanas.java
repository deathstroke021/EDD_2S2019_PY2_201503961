package pruebaventanas;

import java.io.IOException;
import java.util.ArrayList;
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
		ventana.setScene(scene);
		// Set the Title for the Scene
		ventana.setTitle("TreeView Example 4");
		// Display the stage
		ventana.show();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    
    	// Create the TreeView
	private final TreeView<String> treeView = new TreeView<>();
	// Create the TextArea
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
	private VBox getRightPane()
	{
		// Create the addItemBtn and its corresponding Event Handler
		Button addItemBtn = new Button("Add new Item");
		addItemBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				addItem(textField.getText());
			}
		});

		// Create the removeItemBtn and its corresponding Event Handler
		Button removeItemBtn = new Button("Remove Selected Item");
		removeItemBtn.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				removeItem();
			}
		});

		// Set the preferred number of text rows
		textArea.setPrefRowCount(15);
		// Set the preferred number of text columns
		textArea.setPrefColumnCount(25);

		// Create the HBox
		HBox hbox = new HBox();
		// Add Children to the HBox
		hbox.getChildren().addAll(new Label("Item:"), textField, addItemBtn);

		// Create the VBox
		VBox vbox = new VBox();
		// Add children to the VBox
		vbox.getChildren().addAll(new Label("Select an item to add to or remove."),hbox,removeItemBtn,
				new Label("Message Log:"), textArea);
		// Set the vertical space between each child in the VBox
		vbox.setSpacing(10);

		return vbox;
	}


	// Helper Method for Adding an Item
	private void addItem(String value)
	{
		if (value == null || value.trim().equals(""))
		{
			this.writeMessage("Item cannot be empty.");
			return;
		}

		TreeItem<String> parent = treeView.getSelectionModel().getSelectedItem();

		if (parent == null)
		{
			this.writeMessage("Select a node to add this item to.");
			return;
		}

		// Check for duplicate
		for(TreeItem<String> child : parent.getChildren())
		{
			if (child.getValue().equals(value))
			{
				this.writeMessage(value + " already exists under " + parent.getValue());
				return;
			}
		}

		TreeItem<String> newItem = new TreeItem<String>(value);
		parent.getChildren().add(newItem);

		if (!parent.isExpanded())
		{
			parent.setExpanded(true);
		}
	}

	// Helper Method for Removing an Item
	private void removeItem()
	{
		TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();

		if (item == null)
		{
			this.writeMessage("Select a node to remove.");
			return;
		}

		TreeItem<String> parent = item.getParent();
		if (parent == null )
		{
			this.writeMessage("Cannot remove the root node.");
		}
		else
		{
			parent.getChildren().remove(item);
		}
	}

	// Helper Methods for the Event Handlers
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
				this.writeMessage("Node " + item.getValue() + " has been added.");
			}
		}

		if (event.wasRemoved())
		{
			for(TreeItem<String> item : event.getRemovedChildren())
			{
				this.writeMessage("Node " + item.getValue() + " has been removed.");
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
}