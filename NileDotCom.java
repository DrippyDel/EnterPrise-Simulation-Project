/* Name: Delali Ekpeh
Course: CNT 4714 – Spring 2024
Assignment title: Project 1 – An Event-driven Enterprise Simulation
Date: Sunday January 28, 2024
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File; 
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

public class NileDotCom implements ActionListener
{

    //class constants
                                        //pixels
    private static final int WINDOW_WIDTH = 500; 
                                        //pixels
    private static final int WINDOW_HEIGHT = 600; 
                                        //characters
    private static final int FIELD_WIDTH = 20; 
                                        //characters
    private static final int FIELD_WIDTH2 = 40; 
                                        //characters
    private static final int AREA_WIDTH = 40; 

    private static final FlowLayout LAYOUT_STYLE = new FlowLayout();

    private static final String LEGEND = " ";

      public static int item = 1;
      public int totalItems = 0;
      public int itemsTotal = 0;
      public String shoppingCart = "\tYour Current Shopping Cart With " + totalItems + " Item(s)";
      String response1 = "";
      String response2 = "";
      String[] cartShopping = new String[6];
      double price = 0;
      int quantity = 0;
      int discount = 0;
      double discoutPrice = 0;
      double total = 0;
      DecimalFormat df = new DecimalFormat("#.##");
      DateFormat dateFormat = new SimpleDateFormat(" DD /YYYY / HH:MM:SS");
      TimeZone etTimeZone = TimeZone.getTimeZone("America/New_York");
      DateFormat idFormat = new SimpleDateFormat("MMDDYYYYHHMMSS");
      Calendar cal = Calendar.getInstance();
      Date date = new Date();
                                  
    // Instance variables
    // Window for GUI
    private JFrame window = new JFrame("Nile.com - Spring 2024");
    private JFrame window2 = new JFrame("Nile.com - Current Shopping Cart Status");
    private JFrame window3 = new JFrame("Nile.com - FINAL INVOICE");

    //legend
    private JTextArea legendArea = new JTextArea(LEGEND, 2, AREA_WIDTH);

    private JTextArea spaceArea = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea2 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea3 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea4 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea5 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea6 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea7 = new JTextArea(LEGEND, 2, AREA_WIDTH);
    private JTextArea spaceArea8 = new JTextArea(LEGEND, 2, AREA_WIDTH);


    private JTextArea legendArea2 = new JTextArea(shoppingCart, 2, AREA_WIDTH);

    private JTextArea legendArea3 = new JTextArea("User Controls", 2, AREA_WIDTH);

    // User entry area for item id
    private JLabel item1Tag = new JLabel("Enter Item ID for item #" + item + ":");
    private JTextField item1Text = new JTextField(FIELD_WIDTH);

    // User entry area for item quantity 
    private JLabel item2Tag = new JLabel("Enter Quantity for item #" + item + ":");
    private JTextField item2Text = new JTextField(FIELD_WIDTH);

    // Area for item detail
    private JLabel detailsTag = new JLabel("Details for item #1:");
    private JTextField detailsText = new JTextField(35);

    // Area for final invoice 
    private JLabel dateTag = new JLabel("");
    private JLabel numberLineTag = new JLabel("");
    private JLabel legendTag = new JLabel("Item# / ID / Title / Price / Qty / Disc% / Subtotal:");
    private JLabel shoppingCartTag = new JLabel("");
    private JLabel shoppingCartTag2 = new JLabel("");
    private JLabel shoppingCartTag3 = new JLabel("");
    private JLabel shoppingCartTag4 = new JLabel("");
    private JLabel shoppingCartTag5 = new JLabel("");
    private JLabel totalTag = new JLabel("");
    private JLabel taxTag = new JLabel("Tax Rate:  %6");
    private JLabel totalTaxTag = new JLabel("");
    private JLabel finalTotalTag = new JLabel("");
    private JLabel goodbyeTag = new JLabel("Thanks for shopping at Nile.com!");


     // Area for total cost
    private JLabel subtotalTag = new JLabel("Current Subtotal for " + totalItems + " item(s)");
    private JTextField subtotalText = new JTextField(FIELD_WIDTH);

    // Area for shopping cart
    private JTextField cartText = new JTextField(" ", FIELD_WIDTH2);
    private JTextField cartText2 = new JTextField(" ", FIELD_WIDTH2);
    private JTextField cartText3 = new JTextField(" ", FIELD_WIDTH2);
    private JTextField cartText4 = new JTextField(" ", FIELD_WIDTH2);
    private JTextField cartText5 = new JTextField(" ", FIELD_WIDTH2);
    private JLabel cart = new JLabel("");
    private JLabel cart2 = new JLabel("");
    private JLabel cart3 = new JLabel("");
    private JLabel cart4 = new JLabel("");
    private JLabel cart5 = new JLabel("");
    
    // Buttons
    private JButton quitButton = new JButton("Quit");
    private JButton findButton = new JButton("Find Item #" + item);
    private JButton addButton = new JButton("Add Item #" + item + " To Cart");
    private JButton viewButton = new JButton("View Cart");
    private JButton checkoutButton = new JButton("Check Out");
    private JButton emptyButton = new JButton("Empty Cart - Start A New Order");
    private JButton okayButton = new JButton("Okay");

    // Error Dialog boxes
    JFrame error = new JFrame("Nile Dot Com - ERROR");


    public NileDotCom()
    {
        //configure GUI
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
        window2.setSize(500, 230);
        window3.setSize(475,625);

        legendArea.setEditable(false);
        legendArea.setLineWrap(true);
        legendArea.setWrapStyleWord(true);
        legendArea.setBackground(window.getBackground());

        spaceArea.setEditable(false);
        spaceArea.setBackground(window.getBackground());

        spaceArea2.setEditable(false);
        spaceArea2.setBackground(window.getBackground());

        spaceArea3.setEditable(false);
        spaceArea3.setBackground(window.getBackground());
        
        spaceArea4.setEditable(false);
        spaceArea4.setBackground(window.getBackground());
        
        spaceArea5.setEditable(false);
        spaceArea5.setBackground(window.getBackground());

        spaceArea6.setEditable(false);
        spaceArea6.setBackground(window.getBackground());

        spaceArea7.setEditable(false);
        spaceArea7.setBackground(window.getBackground());

        spaceArea8.setEditable(false);
        spaceArea8.setBackground(window.getBackground());

        legendArea2.setEditable(false);
        legendArea2.setLineWrap(true);
        legendArea2.setWrapStyleWord(true);
        legendArea2.setBackground(window.getBackground());

        legendArea3.setEditable(false);
        legendArea3.setLineWrap(true);
        legendArea3.setWrapStyleWord(true);
        legendArea3.setBackground(window.getBackground());

        detailsText.setEditable(false);
        subtotalText.setEditable(false);
        cartText.setEditable(false);
        cartText2.setEditable(false);
        cartText3.setEditable(false);
        cartText4.setEditable(false);
        cartText5.setEditable(false);
        // subtotalText.setBackground(Color.WHITE);

        //register event listener
        quitButton.setBackground(Color.RED);
        quitButton.setOpaque(true);
        quitButton.addActionListener(this);
        quitButton.setPreferredSize(new Dimension(200,20));
        
        findButton.setOpaque(true);
        findButton.addActionListener(this);
        findButton.setPreferredSize(new Dimension(200,20));

        addButton.setOpaque(true);
        addButton.addActionListener(this);
        addButton.setPreferredSize(new Dimension(200,20));
        addButton.setEnabled(false);

        viewButton.setOpaque(true);
        viewButton.addActionListener(this);
        viewButton.setPreferredSize(new Dimension(200,20));
        viewButton.setEnabled(false);

        checkoutButton.setOpaque(true);
        checkoutButton.addActionListener(this);
        checkoutButton.setPreferredSize(new Dimension(200,20));
        checkoutButton.setEnabled(false);

        emptyButton.setOpaque(true);
        emptyButton.addActionListener(this);
        emptyButton.setPreferredSize(new Dimension(250,20));


        //add components to the container
        Container c = window.getContentPane();
        c.setLayout(LAYOUT_STYLE);

        c.add(legendArea);
        c.add(item1Tag);
        c.add(item1Text);
        c.add(item2Tag);
        c.add(item2Text);
        c.add(detailsTag);
        c.add(detailsText);
        c.add(subtotalTag);
        c.add(subtotalText);
        c.add(spaceArea);

        c.add(legendArea2);
        c.add(cartText);
        c.add(cartText2);
        c.add(cartText3);
        c.add(cartText4);
        c.add(cartText5);
        c.add(spaceArea2);

        c.add(legendArea3);

        c.add(findButton);
        c.add(addButton);
        c.add(viewButton);
        c.add(checkoutButton);
        c.add(emptyButton);
        c.add(quitButton);

        //display GUI
        window.show();

        okayButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
             // Close the second window when the button is clicked
             window2.dispose();
             window3.dispose();
         }
     });
    }

    public void actionPerformed(ActionEvent e) 
    {
 
        if (e.getSource()==quitButton)
         {
            System.out.println("Prgram would now quit.");
            System.exit(0);
         }
       else if (e.getSource()== findButton)
         {
            response1 = item1Text.getText();
            response2 = item2Text.getText();


            if(response1.equals("")|| response2.equals("")) 
            {
               JOptionPane.showMessageDialog(error, "Please enter Item ID and the Quantity you would like ",
               "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
               System.out.println("Finding Item");
               price = readPrice(response1);
               quantity = readQuantity(response1);
               response1 = readFile(response1);

   
               if(response1.length() < 8)
               {
                  JOptionPane.showMessageDialog(error,"Item ID "+ response1 + " not in file",
                  "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                  item1Tag.setText("Enter Item ID for item #" + item + ":");
                  item1Text.setText("");
   
                  item2Tag.setText("Enter Quantity for item #" + item + ":");
                  item2Text.setText("");
               }
               else if(Double.parseDouble(response2) > 0 && quantity == 0)
               {
                  JOptionPane.showMessageDialog(error,"Sorry... that item is out of stock, Please try another item",
                  "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                  item1Tag.setText("Enter Item ID for item #" + item + ":");
                  item1Text.setText("");
   
                  item2Tag.setText("Enter Quantity for item #" + item + ":");
                  item2Text.setText("");
               }
               else if(Double.parseDouble(response2) > quantity)
               {
                  JOptionPane.showMessageDialog(error,"Insufficient stock. Only " + quantity + " on hand. Please reduce the Quantity.",
                  "Nile Dot Com - ERROR", JOptionPane.ERROR_MESSAGE);
                  item1Tag.setText("Enter Item ID for item #" + item + ":");
                  item1Text.setText("");
   
                  item2Tag.setText("Enter Quantity for item #" + item + ":");
                  item2Text.setText("");
               }
               else
               {
                  double priceNew = price * Double.parseDouble(response2);
               if(Integer.parseInt(response2) >= 1 && Integer.parseInt(response2) <= 4)
                  {
                     discount = 0;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));

                  }
                  else if(Integer.parseInt(response2) >= 5 && Integer.parseInt(response2) <= 9)
                  {
                     discount = 10;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }
                  else if(Integer.parseInt(response2) >= 10 && Integer.parseInt(response2) <= 14)
                  {
                     discount = 15;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }
                  else if(Integer.parseInt(response2) >= 15)
                  {
                     discount = 20;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }
                  itemsTotal++;
                  detailsTag.setText("Details for item #" + itemsTotal + ":");
                  detailsText.setText(response1 + " " + "$" + price + " " + response2 + " " + "%" + discount+ " " + "$" + df.format(discoutPrice));
                  findButton.setEnabled(false);

                  addButton.setEnabled(true);

               }
            }
         }
      else if (e.getSource()== addButton)
         {
            response1 = item1Text.getText();
            response2 = item2Text.getText();
            price = readPrice(response1);
            response1 = readFile(response1);
      
            if(response1.length() < 8 || price == 0)
            {
               System.out.println("Can't find item");
            }
            else
            {
               double priceNew = price * Double.parseDouble(response2);
               //total = priceNew + total;
               if(Integer.parseInt(response2) >= 1 && Integer.parseInt(response2) <= 4)
                  {
                     discount = 0;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));

                  }
                  else if(Integer.parseInt(response2) >= 5 && Integer.parseInt(response2) <= 9)
                  {
                     discount = 10;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }
                  else if(Integer.parseInt(response2) >= 10 && Integer.parseInt(response2) <= 14)
                  {
                     discount = 15;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }
                  else if(Integer.parseInt(response2) >= 15)
                  {
                     discount = 20;
                     discoutPrice = priceNew - (priceNew *(discount/100.0f));
                  }

               System.out.println("Adding Item");
               updateCart(response1 + " " + "Price Ea. $" + price + " " + "Qty: " + response2 + " " + "Total: " + " " + "$" + df.format(discoutPrice));
               total = discoutPrice + total;
               subtotalText.setText("$" + df.format(total));

               // Updates text boxes and shopping cart
               item++;
               totalItems++;

               item1Tag.setText("Enter Item ID for item #" + item + ":");
               item1Text.setText("");

               item2Tag.setText("Enter Quantity for item #" + item + ":");
               item2Text.setText("");

               subtotalTag.setText("Current Subtotal for " + totalItems + " item(s)");

               legendArea2.setText("\tYour Current Shopping Cart With " + totalItems + " Item(s)");
               cartShopping[totalItems] =  response1 + " " + "$" + price + " " + response2 + " " + "%" + discount+ " " + "$" + df.format(discoutPrice);

               findButton.setEnabled(true);
               findButton.setText("Find Item #" + item);
               viewButton.setEnabled(true);
               checkoutButton.setEnabled(true);
               addButton.setEnabled(false);
               addButton.setText("Add Item #" + item + " To Cart");

               if(item == 6)
               {
                  addButton.setText("Add Item");
                  addButton.setEnabled(false);

                  findButton.setText("Find Item");
                  findButton.setEnabled(false);

               }
               
            }
         }
      else if (e.getSource()== viewButton)
         {
            System.out.println("Viewing Item");

            Container a = window2.getContentPane();
            a.setLayout(LAYOUT_STYLE);
            a.add(cart);
            a.add(cart2);
            a.add(cart3);
            a.add(cart4);
            a.add(cart5);

            for(int i = 0; i <= totalItems; i++)
               {
            
                  if(i == 1)
                  {
                     cart.setText("1: " + cartShopping[i]);
                     a.add(cart);
                     a.add(cart2);
                     a.add(cart3);
                     a.add(cart4);
                     a.add(cart5);
                     a.add(legendArea);
                     a.add(okayButton);
                  }
                  else if(i == 2)
                  {
                     cart2.setText("2: " + cartShopping[i]);
                   
                  }
                  else if(i == 3)
                  {
                     cart3.setText("3: " + cartShopping[i]);
                   
                  }
                  else if(i == 4)
                  {
                     cart4.setText("4: " + cartShopping[i]);
                   
                  }
                  else if(i == 5)
                  {
                     cart5.setText("5: " + cartShopping[i]);
                     
                  }
               }
            window2.show();   
          } 
         else if (e.getSource()== checkoutButton)
         {
            System.out.println("Checking Out");

            Container b = window3.getContentPane();
            b.setLayout(LAYOUT_STYLE);
            b.add(dateTag);
            b.add(spaceArea8);
      
            b.add(numberLineTag);
            b.add(spaceArea3);

            b.add(legendTag);
            b.add(legendArea);

            b.add(shoppingCartTag);
            b.add(shoppingCartTag2);
            b.add(shoppingCartTag3);
            b.add(shoppingCartTag4);
            b.add(shoppingCartTag5);
            b.add(spaceArea);

           

            b.add(totalTag);
            b.add(spaceArea4);

            b.add(taxTag);
            b.add(spaceArea5);

            b.add(totalTaxTag);
            b.add(spaceArea7);

            b.add(finalTotalTag);
            b.add(spaceArea6);

            b.add(goodbyeTag);
            b.add(spaceArea2);
            b.add(okayButton);

            dateTag.setText("Date: " + new SimpleDateFormat("MMM").format(cal.getTime()) + dateFormat.format(date));
            numberLineTag.setText("Number of line items: " + totalItems);

            for(int i = 0; i <= totalItems; i++)
               {
            
                  if(i == 1)
                  {
                     shoppingCartTag.setText("1: " + cartShopping[i]);
                  }
                  else if(i == 2)
                  {
                     shoppingCartTag2.setText("2: " + cartShopping[i]);
                   
                  }
                  else if(i == 3)
                  {
                     shoppingCartTag3.setText("3: " + cartShopping[i]);
                   
                  }
                  else if(i == 4)
                  {
                     shoppingCartTag4.setText("4: " + cartShopping[i]);
                   
                  }
                  else if(i == 5)
                  {
                     shoppingCartTag5.setText("5: " + cartShopping[i]);
                     
                  }
               }
                  totalTag.setText("Order Subtotal: $" + df.format(total));

                  totalTaxTag.setText("Tax amount: $" + df.format(total * .06));

                  finalTotalTag.setText("ORDER TOTAL: $" + df.format(total + total * .06 ));

                  item1Text.setEditable(false);
                  item2Text.setEditable(false);

                  findButton.setEnabled(false);
                  addButton.setEnabled(false);
                  checkoutButton.setEnabled(false);

            

            window3.show();
            transaction(idFormat.format(date),dateFormat.format(date));
         }
         else if (e.getSource()== emptyButton)
         {
            System.out.println("Empting Cart");
            item = 1;
            totalItems = 0;
            itemsTotal = 0;
            price = 0;
            quantity = 0;
            discount = 0;
            discoutPrice = 0;
            total = 0;

            item1Text.setText("");
            item1Text.setEditable(true);
            item1Tag.setText("Enter Item Id for item #" + item +":");

            item2Text.setText("");
            item2Text.setEditable(true);
            item2Tag.setText("Enter Quantity for item #" + item +":");

            detailsText.setText("");
            detailsTag.setText("Details for item #"+ item +":");

            subtotalText.setText("");
            subtotalTag.setText("Current Subtotal for " + totalItems + " items(s)");

            legendArea2.setText(shoppingCart);

            cartText.setText("");
            cartText2.setText("");
            cartText3.setText("");
            cartText4.setText("");
            cartText5.setText("");

            findButton.setText("Find Item #" + item);
            findButton.setEnabled(true);

            addButton.setText("Add Item #" + item + " To Cart");
            viewButton.setEnabled(false);
            checkoutButton.setEnabled(false);
            cart.setText("");
            cart2.setText("");
            cart3.setText("");
            cart4.setText("");
            cart5.setText("");

         }
    }

    public static String readFile(String item)
    {
      item = item + ",";
      try {
         File myObj = new File("inventory.csv");
         Scanner myReader = new Scanner(myObj);
         
         while (myReader.hasNextLine()) 
         {
            String data = myReader.nextLine();
            
            // Splits the line into words
            String[] words = data.split("\\s+"); 
            if(words[0].equals(item))
            {
               for(int i = 1; i < words.length; i++)
               {
                  if(words[i].equals("true,") || words[i].equals("false,"))
                  {
                     i = words.length + 1;
                     break;
                  }
                  
                  item = item + " " + words[i];
                  
               }
               System.out.println(item);
              // System.out.println(words[0] + " " + words[1]);
            }
            
         }
         myReader.close();
       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }
       return item;
    }

    public static double readPrice(String item)
    {
      item = item + ",";
      double itemPrice = 0;

      try {
         File myObj = new File("inventory.csv");
         Scanner myReader = new Scanner(myObj);
         
         while (myReader.hasNextLine()) 
         {
            String data = myReader.nextLine();
            
            // Splits the line into words
            String[] words = data.split("\\s+"); 
            if(words[0].equals(item))
            {
               try {
                  // Attempt to parse the last word as an integer
                  itemPrice = Double.parseDouble(words[words.length - 1].trim());
              } catch (NumberFormatException e) {
                  System.out.println("Invalid price format for item: " + itemPrice);
              }
            }
            
         }
         myReader.close();
       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

       return itemPrice;
    }

    public static int readQuantity(String item)
    {
      item = item + ",";
      int quantity = 0;

      try {
         File myObj = new File("inventory.csv");
         Scanner myReader = new Scanner(myObj);
         
         while (myReader.hasNextLine()) 
         {
            String data = myReader.nextLine();
            
            // Splits the line into words
            String[] words = data.split("\\s+"); 
            if(words[0].equals(item))
            {
               try {
                  quantity = Integer.parseInt(words[words.length - 2].trim().substring(0,words[words.length - 2].length()-1));
                 // System.out.println(quantity);
              } catch (NumberFormatException e) {
                  System.out.println("Invalid price format for item: " + quantity);
              }
            }
            
         }
         myReader.close();
       } catch (FileNotFoundException e) {
         System.out.println("An error occurred.");
         e.printStackTrace();
       }

       return quantity;
    }

    public void transaction(String date, String actualDate)
    {
      try {
         // FileWriter fileWriter = new FileWriter("transaction.csv");
         File log = new File("transaction.csv");
         PrintWriter printWriter = new PrintWriter(new FileWriter(log,true));
      

         for(int i = 0; i <= totalItems; i++)
         {
            if(i == 1)
                  {
                     printWriter.print(date + ", " + cartShopping[i] + ", " +  new SimpleDateFormat("MMM").format(cal.getTime()) + " "+  actualDate + "\n");
                  }
                  else if(i == 2)
                  {
                     printWriter.print(date + ", " + cartShopping[i] + ", " +  new SimpleDateFormat("MMM").format(cal.getTime()) + " "+  actualDate + "\n");
                   
                  }
                  else if(i == 3)
                  {
                     printWriter.print(date + ", " + cartShopping[i] + ", " +  new SimpleDateFormat("MMM").format(cal.getTime()) + " "+  actualDate + "\n");
                   
                  }
                  else if(i == 4)
                  {
                     printWriter.print(date + ", " + cartShopping[i] + ", " +  new SimpleDateFormat("MMM").format(cal.getTime()) + " "+  actualDate + "\n");
                   
                  }
                  else if(i == 5)
                  {
                     printWriter.print(date + ", " + cartShopping[i] + ", " +  new SimpleDateFormat("MMM").format(cal.getTime()) + " "+  actualDate + "\n");
                  }
         }
         printWriter.print("\n");

         printWriter.close();
      } catch (Exception e) {
         // TODO: handle exception
      }
    }


    public void updateCart(String text)
    {
      if(item == 1)
      {
         cartText.setText("SKU: " + text);
      }
      else if(item == 2)
      {
         cartText2.setText("SKU: " + text);
      }
      else if(item == 3)
      {
         cartText3.setText("SKU: " + text);
      }
      else if(item == 4)
      {
         cartText4.setText("SKU: " + text);
      }
      else if(item == 5)
      {
         cartText5.setText("SKU: " + text);
      }

    }

    public static String theMonth(int month)
    {
      String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
      return monthNames[month];
    }

    public static void main(String [] args)
    {
        System.out.println("Loading.....Nile.com");
        NileDotCom gui = new NileDotCom();
    }
}