/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaventanas;

import java.util.ArrayList;
import javafx.scene.control.TreeItem;
 
public class TreeViewHelper 
{
    public TreeViewHelper()
    {
        
    }
     
    // This method creates an ArrayList of TreeItems (Products)
    public ArrayList<TreeItem> getProducts() //Carpetas del treeview (Deberia ser solo Root)
    {
        ArrayList<TreeItem> products = new ArrayList<TreeItem>();
         
        /*TreeItem cars = new TreeItem("Cars");
        cars.getChildren().addAll(getCars()); //crear padre
         
        TreeItem buses = new TreeItem("Buses");
        buses.getChildren().addAll(getBuses());
 
        TreeItem trucks = new TreeItem("Trucks");
        trucks.getChildren().addAll(getTrucks());
         
        TreeItem motorbikes = new TreeItem("Motorcycles");
        motorbikes.getChildren().addAll(getMotorcycles());
         
        products.add(cars);
        products.add(buses);
        products.add(trucks);
        products.add(motorbikes);*/
         
        return products;
    }
 
    // This method creates an ArrayList of TreeItems (Cars)
    // Archivos del treeview
    private ArrayList<TreeItem> getCars()
    {
        ArrayList<TreeItem> cars = new ArrayList<TreeItem>();
         
        /*TreeItem ferrari = new TreeItem("Ferrari"); // Creado por el usuario no por default
        TreeItem porsche = new TreeItem("Porsche");
        TreeItem ford = new TreeItem("Ford");
        TreeItem mercedes = new TreeItem("Mercedes");
         
        cars.add(ferrari);
        cars.add(porsche);
        cars.add(ford);
        cars.add(mercedes);*/
         
        return cars;        
    }
 
    // This method creates an ArrayList of TreeItems (Buses)
    // Lo mismo para los demas
    private ArrayList<TreeItem> getBuses()
    {
        ArrayList<TreeItem> buses = new ArrayList<TreeItem>();
         
        /*TreeItem gm = new TreeItem("GM");
        TreeItem vw = new TreeItem("VW");
        TreeItem man = new TreeItem("MAN");
        TreeItem volvo = new TreeItem("Volvo");
         
        buses.add(gm);
        buses.add(man);
        buses.add(volvo);
        buses.add(vw);*/
         
        return buses;       
    }
     
    // This method creates an ArrayList of TreeItems (Trucks)
    private ArrayList<TreeItem> getTrucks()
    {
        ArrayList<TreeItem> trucks = new ArrayList<TreeItem>();
         
        /*TreeItem scania = new TreeItem("Scania");
        TreeItem mercedes = new TreeItem("Mercedes");
        TreeItem gm = new TreeItem("GM");
        TreeItem ford = new TreeItem("Ford");
         
        trucks.add(mercedes);
        trucks.add(scania);
        trucks.add(gm);
        trucks.add(ford);*/
         
        return trucks;
    }
 
    // This method creates an ArrayList of TreeItems (Motorbikes)
    private ArrayList<TreeItem> getMotorcycles()
    {
        ArrayList<TreeItem> motorcycles = new ArrayList<TreeItem>();
         
        /*TreeItem harley = new TreeItem("Harley");
        TreeItem suzuki = new TreeItem("Suzuki");
        TreeItem ktm = new TreeItem("KTM");
        TreeItem honda = new TreeItem("Honda");
         
        motorcycles.add(harley);
        motorcycles.add(honda);
        motorcycles.add(ktm);
        motorcycles.add(suzuki);*/
         
        return motorcycles;
    }
}

