package igoApp;
//4505530261138299

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class igo_TVM extends Application {

   
    private String passType;
	//private double passAmount;

    @Override
    public void start(Stage primaryStage) {
    
    	// Load the CSS file
    	//String css = getClass().getResource("style.css").toExternalForm();

    	// Set the CSS file to the scene
    	
 
     // Create an HBox for the language selection and set its alignment to top right
     HBox languageBox = new HBox(10);
     languageBox.setAlignment(Pos.BOTTOM_LEFT);
//      Label languageLabel = new Label("Choose Language:");
// languageLabel.setFont(Font.font("Arial", 16));
// languageLabel.setAlignment(Pos.TOP_LEFT);

// Text languageLabel = new Text(30.0, 80.0, "Select Language");
// //Setting the font
// Font fontl = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24);
// languageLabel.setFont(fontl);
// //Setting the color of the text
// languageLabel.setFill(Color.YELLOW);
// //Setting the width
// languageLabel.setStrokeWidth(2);
//Setting the stroke color
//languageLabel.setStroke(Color.BLUE);
     
     
     ComboBox<String> languageCombo = new ComboBox<>();
     
     
     languageCombo.getItems().addAll("English", "French");
     
     //languageCombo.setValue("English");
     languageCombo.setPromptText("Select Language");
        
    // Set the preferred width and height
    languageCombo.setPrefSize(150, 40);

    // Set the font to a larger size and bold
    languageCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

    // Set the border color and thickness
    languageCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
    
    
    

     languageBox.getChildren().addAll(languageCombo);
  
        // Create the two buttons
    Button rechargeButton = new Button("Recharge Metro Card");
    Button purchaseButton = new Button("Purchase Ticket");

     // Set the font size and style
     rechargeButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));
     purchaseButton.setFont(Font.font("Arial", FontWeight.BOLD, 20));

     // Set the background color
     rechargeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
     purchaseButton.setStyle("-fx-background-color: #008CBA; -fx-text-fill: white;");

     // Set the border
     rechargeButton.setStyle("-fx-border-color: #4CAF50; -fx-border-width: 6px; -fx-border-radius: 3px;");
     purchaseButton.setStyle("-fx-border-color: #0000FF; -fx-border-width: 6px; -fx-border-radius: 3px;");

     // Set the preferred size
     rechargeButton.setPrefSize(320, 75);
     purchaseButton.setPrefSize(320, 75);
     
     
       
        
       
        
        Text titleLabel = new Text(30.0, 80.0, "Welcome to Montreal STM");
        //Setting the font
        Font font = Font.font("Brush Script MT", FontWeight.BOLD, FontPosture.REGULAR, 84);
        titleLabel.setFont(font);
        //Setting the color of the text
        titleLabel.setFill(Color.YELLOW);
        //Setting the width
        titleLabel.setStrokeWidth(2);
        //Setting the stroke color
        titleLabel.setStroke(Color.BLUE);
        

//         Button restartButton = new Button("Restart");
        

// // Set the alignment of the restart button to the bottom right corner of the screen

// HBox bottomRightBox = new HBox(restartButton);
// bottomRightBox.setAlignment(Pos.BOTTOM_LEFT);
//         restartButton.setOnAction(e -> {
//             try {
//                 start(primaryStage);
//             } catch (Exception ex) {
//                 ex.printStackTrace();
//             }
//         });
        
        
      //  titleLabel.setAlignment(Pos.CENTER);
      ///  mainVBox.getChildren().add(titleLabel);
        // Create a VBox for the main window and add the buttons
        VBox mainVBox = new VBox(10);
        mainVBox.setAlignment(Pos.TOP_CENTER);
        mainVBox.setPadding(new Insets(20, 20, 20, 20));

        
        mainVBox.getChildren().addAll(titleLabel,languageBox, rechargeButton, purchaseButton);
        
        // Create an ImageView for the background image
        Image backgroundImage = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/mainScreen.png");

        BackgroundSize backgroundSize = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImageObj = new BackgroundImage(backgroundImage, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImageObj);
        mainVBox.setBackground(background);

        // Create a new scene with the mainVBox as the root and show the scene
        Scene mainScene = new Scene(mainVBox, 1200, 700);
       // mainScene.getStylesheets().add(css);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("igo TVM");
        primaryStage.show();
        
       // languageCombo.valueProperty().addListener((observable, oldValue, newValue) -> {
        //languageCombo.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {

        languageCombo.setOnAction(event -> {
        //     String languageSeleted = languageCombo.getValue();
           if (languageCombo.getValue().equals("English")) {
           // if (newValue.equals("English")) {
            rechargeButton.setText("Recharge Metro Card");
            purchaseButton.setText("Purchase Ticket");
            
    
    
            titleLabel.setText("Welcome to Montreal STM");


        // Set the action for each button
        rechargeButton.setOnAction(e -> {
            // Create a new VBox for the "Recharge Pass Type" window
            VBox rechargeVBox = new VBox(10);
            rechargeVBox.setAlignment(Pos.CENTER);
            rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

            // Create a label and combo box with the pass type options
//            Label passTypeLabel = new Label("Select Pass Type:");
//            passTypeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 42));
//            passTypeLabel.setTextFill(Color.rgb(255, 255, 51));
            
            Text passTypeLabel = new Text(30.0, 80.0, "Select Pass Type:");
            //Setting the font
            Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
            passTypeLabel.setFont(font1);
            //Setting the color of the text
            passTypeLabel.setFill(Color.YELLOW);
            //Setting the width
            passTypeLabel.setStrokeWidth(2);
            //Setting the stroke color
            passTypeLabel.setStroke(Color.DARKBLUE);
            
            
            ComboBox<String> passTypeCombo = new ComboBox<>();
            passTypeCombo.getItems().addAll(
                    "2 weeks - $ 35",
                    "1 month - $ 56",
                    "2 months - $ 98",
                    "3 months - $ 135"
            );
            passTypeCombo.setValue("2 weeks - $ 35");
            
         // Set the preferred width and height
            passTypeCombo.setPrefSize(220, 60);

            // Set the font to a larger size and bold
            passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

            // Set the border color and thickness
            passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
            
            // Create a button to confirm the pass type selection
            Button confirmPassTypeButton = new Button("Confirm");
            
            // Set the font size and style
            confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
           

            // Set the background color
            confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
          

            // Set the border
            confirmPassTypeButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
           

            // Set the preferred size
            confirmPassTypeButton.setPrefSize(120, 30);
           
            
            confirmPassTypeButton.setOnAction(e2 -> {
                this.passType = passTypeCombo.getValue();
               // this.passAmount = Double.parseDouble(passType.split(" ")[4]);
                
                System.out.println("Pass Type Selected: " + this.passType);
               // System.out.println("Pass amount: " + this.passAmount);
                // Create a new VBox for the "Payment Method" window
                VBox paymentVBox = new VBox(10);
                paymentVBox.setAlignment(Pos.CENTER);
                paymentVBox.setPadding(new Insets(20, 20, 20, 20));

                // Create a label and combo box with the payment method options
               // Label paymentLabel = new Label("Select Payment Method:");
                
                Text paymentLabel = new Text(30.0, 80.0, "Select Payment Method:");
                //Setting the font
                Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                paymentLabel.setFont(font2);
                //Setting the color of the text
                paymentLabel.setFill(Color.YELLOW);
                //Setting the width
                paymentLabel.setStrokeWidth(2);
                //Setting the stroke color
                paymentLabel.setStroke(Color.DARKBLUE);
                
               
                ComboBox<String> paymentCombo = new ComboBox<>();
                paymentCombo.getItems().addAll(
                        "Pay by Cash",
                        "Pay by Debit/Credit Card"
                );
                paymentCombo.setValue("Pay by Cash");

                // Set the preferred width and height
                paymentCombo.setPrefSize(220, 40);

                // Set the font to a larger size and bold
                paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

                // Set the border color and thickness
                paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
             // Create a button to confirm the payment method selection
                Button confirmPaymentButton = new Button("Confirm");
                // Set the font size and style
                confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
               

                // Set the background color
                confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
                confirmPaymentButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
                confirmPaymentButton.setPrefSize(120, 30);
                
                
                confirmPaymentButton.setOnAction(e3 -> {
                    String paymentMethod = paymentCombo.getValue();
                    System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

                    if (paymentMethod.equals("Pay by Cash")) {
                       // Some functionality for Pay by cash option
                        // Create a new VBox for the "Cash Payment" window
                        VBox cashVBox = new VBox(10);
                        cashVBox.setAlignment(Pos.CENTER);
                        cashVBox.setPadding(new Insets(20, 20, 20, 20));

                        // Create a label and text field for the cash amount input
                       // Label cashLabel = new Label("Enter Cash Amount:");
                        
                        Text cashLabel = new Text(30.0, 80.0, "Enter Cash Amount:");
                        //Setting the font
                        Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                        cashLabel.setFont(font3);
                        //Setting the color of the text
                        cashLabel.setFill(Color.YELLOW);
                        //Setting the width
                        cashLabel.setStrokeWidth(2);
                        //Setting the stroke color
                        cashLabel.setStroke(Color.DARKBLUE);
                        
                        
                        TextField cashField = new TextField();
                        cashField.setFont(Font.font("Arial", 20)); // set font size to 20
                        cashField.setMaxWidth(200); // set preferred width to 300 pixels
                        
                     // Create a button to confirm the cash amount
                        Button confirmCashButton = new Button("Confirm");
                        confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                        

                        // Set the background color
                        confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                      

                        // Set the border
                        confirmCashButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                       

                        // Set the preferred size
                        confirmCashButton.setPrefSize(120, 30);
                        
                        
                        confirmCashButton.setOnAction(e4 -> {
                            String cashAmount = cashField.getText();
                            System.out.println("Cash Amount Entered: " + cashAmount);

                          double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
                            double cash = Double.parseDouble(cashAmount);

                            if (cash >= passAmount) {
                                double balance = cash - passAmount;
                                String balanceMessage = String.format("Payment Successful!\nPlease collect your Card and balance amount: $%.2f", balance);
                               // Label balanceLabel = new Label(balanceMessage);
                                
                                Text balanceLabel = new Text(30.0, 80.0, balanceMessage);
                                //Setting the font
                                Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
                                balanceLabel.setFont(font4);
                                //Setting the color of the text
                                balanceLabel.setFill(Color.YELLOW);
                                //Setting the width
                                balanceLabel.setStrokeWidth(2);
                                //Setting the stroke color
                                balanceLabel.setStroke(Color.DARKBLUE);
                                
                                
                                
                               // balanceLabel.setFont(Font.font("Arial", 16));

                                
                             // Create a new VBox for the "Payment Success" window
                             VBox successVBox = new VBox(10);
                             successVBox.setAlignment(Pos.CENTER);
                             successVBox.setPadding(new Insets(20, 20, 20, 20));
                             successVBox.getChildren().add(balanceLabel);

                             // Create an OK button to navigate back to the original scene
                             Button okButton = new Button("OK");
                             
                             okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                             

                             // Set the background color
                             okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                           

                             // Set the border
                             okButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                            

                             // Set the preferred size
                             okButton.setPrefSize(120, 30);
                             
                             okButton.setOnAction(e5 -> {
                                 primaryStage.setScene(mainScene);
                             });

                             // Add the OK button to the successVBox
                             successVBox.getChildren().add(okButton);
                             
                             
                             // Create an ImageView for the background image
                             Image backgroundImageSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                             BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                             BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeSB);
                             Background backgroundSB = new Background(backgroundImageObjSB);
                             successVBox.setBackground(backgroundSB);
                             
                             // Create a new scene with the successVBox as the root and show the scene
                             Scene successScene = new Scene(successVBox, 1200, 700);
                             primaryStage.setScene(successScene);
                             


                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Entered amount is less. Please try again.");
                                alert.showAndWait();
                            }
                            //primaryStage.close();
                        });


                        // Add the label, text field, and confirm button to the cashVBox
                        cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);
                        // Create an ImageView for the background image
                        Image backgroundImageCB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                        BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                        BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCB);
                        Background backgroundCB = new Background(backgroundImageObjCB);
                        cashVBox.setBackground(backgroundCB);
                        
                        // Create a new scene with the cashVBox as the root and show the scene
                        Scene cashScene = new Scene(cashVBox, 1200, 700);
                        primaryStage.setScene(cashScene);

		 } else if(paymentMethod.equals("Pay by Debit/Credit Card")) {
                        // add functionality for "Pay by Debit/Credit Card option
// Create a new VBox for the "Card Details" window
			 VBox cardDetailsVBox = new VBox(10);
		        cardDetailsVBox.setAlignment(Pos.CENTER);
		        cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

		        // Create labels and text fields for card number and expiry date
		        //Label cardNumberLabel = new Label("Card Number:");
		        
		        Text cardNumberLabel = new Text(30.0, 80.0, "Card Number:");
                //Setting the font
                Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                cardNumberLabel.setFont(font5);
                //Setting the color of the text
                cardNumberLabel.setFill(Color.YELLOW);
                //Setting the width
                cardNumberLabel.setStrokeWidth(2);
                //Setting the stroke color
                cardNumberLabel.setStroke(Color.DARKBLUE);
		        
		     //   cardNumberLabel.setFont(Font.font("Arial", 16));
		        TextField cardNumberField = new TextField();
		        cardNumberField.setFont(Font.font("Arial", 20)); // set font size to 20
		        cardNumberField.setMaxWidth(500); // set preferred width to 300 pixels
		        cardNumberField.setPromptText("Enter card number");
                
		        //Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
		        
		        Text expiryDateLabel = new Text(30.0, 80.0, "Expiry Date (MM/YY):");
                //Setting the font
                Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                expiryDateLabel.setFont(font6);
                //Setting the color of the text
                expiryDateLabel.setFill(Color.YELLOW);
                //Setting the width
                expiryDateLabel.setStrokeWidth(2);
                //Setting the stroke color
                expiryDateLabel.setStroke(Color.DARKBLUE);
		      //  expiryDateLabel.setFont(Font.font("Arial", 16));
                
		        TextField expiryDateField = new TextField();
		        expiryDateField.setFont(Font.font("Arial", 20)); // set font size to 20
		        expiryDateField.setMaxWidth(500); // set preferred width to 300 pixels
		        expiryDateField.setPromptText("MM/YY");
		        
		       // Label cvvLabel = new Label("CVV");
		        Text cvvLabel = new Text(30.0, 80.0, "CVV:");
                //Setting the font
                Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                cvvLabel.setFont(font7);
                //Setting the color of the text
                cvvLabel.setFill(Color.YELLOW);
                //Setting the width
                cvvLabel.setStrokeWidth(2);
                //Setting the stroke color
                cvvLabel.setStroke(Color.DARKBLUE);
		        
		      //  cvvLabel.setFont(Font.font("Arial", 16));
		        TextField cvvField = new TextField();
		        cvvField.setFont(Font.font("Arial", 20)); // set font size to 20
		        cvvField.setMaxWidth(500); // set preferred width to 300 pixels
		        cvvField.setPromptText("Enter CVV");
		        // Create a button to confirm the card details
		        Button confirmCardDetailsButton = new Button("Confirm");
		        
		        confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                

                // Set the background color
		        confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
		        confirmCardDetailsButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
		        confirmCardDetailsButton.setPrefSize(120, 30);
                
		        confirmCardDetailsButton.setOnAction(e4 -> {
		            String cardNumber = cardNumberField.getText();
		            String expiryDate = expiryDateField.getText();
		            String cvv = cvvField.getText();
		            
		         // Validate expiry date
		            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
		            Date currentDate = new Date();
		            boolean validExpiryDate = true;
		            try {
		                Date expiryDateObj = dateFormat.parse(expiryDate);
		                if (expiryDateObj.before(currentDate)) {
		                    validExpiryDate = false;
		                }
		            } catch (ParseException ex) {
		                validExpiryDate = false;
		            }
		            
		         // Check for valid card number using Luhn algorithm
		            int sum = 0;
		            boolean alternate = false;
		            for (int i = cardNumber.length() - 1; i >= 0; i--) {
		                int n = Integer.parseInt(cardNumber.substring(i, i + 1));
		                if (alternate) {
		                    n *= 2;
		                    if (n > 9) {
		                        n = (n % 10) + 1;
		                    }
		                }
		                sum += n;
		                alternate = !alternate;
		            }
		            
		            // Validate card details
		            if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalid Card Details");
		                alert.setContentText("Please enter valid card details.");
		                alert.showAndWait();
		            } else if (!cardNumber.matches("^\\d{16}$")) {
		                // The card number must be a 16-digit number
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalid Card Number");
		                alert.setContentText("Please enter a valid 16-digit card number.");
		                alert.showAndWait();
		            }else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
		                // Check if the expiry date is a valid format
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalid Expiry date");
		                alert.setContentText("Please enter a valid Expiry Date.");
		                alert.showAndWait();
		            }
		            else if (!cvv.matches("^\\d{3}$")) {
		                // Check if the expiry date is a valid format
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalid CVV");
		                alert.setContentText("Please enter a valid CVV number.");
		                alert.showAndWait();
		            }else if (!validExpiryDate) {
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Expired Card");
		                alert.setContentText("The entered card has expired. Please use a valid card.");
		                alert.showAndWait();
		            }
		            
		            else if (sum % 10 != 0) {
		            	Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalid Card Number");
		                alert.setContentText("Please enter a valid card number.");
		                alert.showAndWait();
		            }
		            else {
		            	// Proceed with payment
		            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		            	alert.setTitle("Payment Confirmation");
		            	alert.setHeaderText("Payment Successful");

		            	// Set content text
		            	String contentText = "Payment by Debit/Credit card for " + this.passType + " is successful.\nThank you for using igo TVM.\n\nPlease select your receipt prefernce :";
		            	//Label contentLabel = new Label(contentText);
		            	
		            	 Text contentLabel = new Text(30.0, 80.0, contentText);
                         //Setting the font
                         Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
                         contentLabel.setFont(font4);
                         //Setting the color of the text
                         contentLabel.setFill(Color.YELLOW);
                         //Setting the width
                         contentLabel.setStrokeWidth(1);
                         //Setting the stroke color
                         contentLabel.setStroke(Color.DARKGREEN);

		            	// Create radio buttons for ticket receipt preference
                         RadioButton emailRadioButton = new RadioButton("Email Receipt");
                         emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
                         RadioButton paperRadioButton = new RadioButton("Paper-based Receipt");
                         paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
		            	
		            	
		            	
		            	ToggleGroup receiptToggleGroup = new ToggleGroup();
		            	emailRadioButton.setToggleGroup(receiptToggleGroup);
		            	paperRadioButton.setToggleGroup(receiptToggleGroup);

		            	// Create a text field for entering email address
		            	TextField emailTextField = new TextField();
		            	emailTextField.setFont(Font.font("Arial", 18)); // set font size to 20
		            	emailTextField.setMaxWidth(500); // set preferred width to 300 pixels
		            	emailTextField.setPromptText("Enter email address");

		            	
		            	// Create a button to confirm receipt preference
		            	Button confirmReceiptButton = new Button("Confirm");
		            	confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		                 

		                 // Set the background color
		            	confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
		               

		                 // Set the border
		            	confirmReceiptButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
		                

		                 // Set the preferred size
		            	confirmReceiptButton.setPrefSize(100, 20);
		            	
		            	confirmReceiptButton.setOnAction(e5 -> {
		            	    String receiptPreference = "";
		            	    if (emailRadioButton.isSelected()) {
		            	    	if (emailTextField.getText().isEmpty()) {
		            	            // Email address is required if email option is selected
		            	            Alert emailAlert = new Alert(Alert.AlertType.ERROR, "Please enter your email address.");
		            	            emailAlert.showAndWait();
		            	            return;
		            	        }
		            	        receiptPreference = "Email";
		            	        } else if (paperRadioButton.isSelected()) {
		            	        receiptPreference = "Paper-based ticket";
		            	    }
		            	    // TODO: Implement logic for sending receipt by email or printing paper-based ticket
		            	    // ...
		            	   //primaryStage.setScene(mainScene);
		            	});

		            	// Create a VBox to hold the content label, radio buttons, and confirm button
		            	VBox contentVBox = new VBox(10);
		            	contentVBox.setAlignment(Pos.CENTER);
		            	contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,emailTextField, confirmReceiptButton);
		            		
		            	emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());
		            	
		            	 // Create an ImageView for the background image
		                Image backgroundImageCSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

		                BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
		                BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCSB);
		                Background backgroundCSB = new Background(backgroundImageObjCSB);
		                contentVBox.setBackground(backgroundCSB);
		            	
		            	// Set the content of the alert box to the content VBox
		            	alert.getDialogPane().setContent(contentVBox);

		            	// Increase the size of the alert box
		            	alert.getDialogPane().setPrefSize(700, 400);

		            	// Show the alert box
		            	alert.showAndWait();

		            	// Set the scene back to the main scene
		            	primaryStage.setScene(mainScene);


		            }
        });

        // Add the labels, text fields, and confirm button to the cardDetailsVBox
        cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);

        
        // Create an ImageView for the background image
        Image backgroundImageCD = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/CD.png");

        BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCD);
        Background backgroundCD = new Background(backgroundImageObjCD);
        cardDetailsVBox.setBackground(backgroundCD);
        
        // Create a new scene with the cardDetailsVBox as the root and show the scene
        Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
        primaryStage.setScene(cardDetailsScene);
                    }
                });

              


                // Add the label, combo box, and confirm button to the paymentVBox
                paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
                // Create an ImageView for the background image
                Image backgroundImagePB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
                Background backgroundPB = new Background(backgroundImageObjPB);
                paymentVBox.setBackground(backgroundPB);
                
                // Create a new scene with the paymentVBox as the root and show the scene
                Scene paymentScene = new Scene(paymentVBox, 1200, 700);
                primaryStage.setScene(paymentScene);
            });

            // Add the label, combo box, and confirm button to the rechargeVBox
            rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);
            
            // Create an ImageView for the background image
            Image backgroundImageRB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/RB.png");

            BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
            BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
            Background backgroundRB = new Background(backgroundImageObjRB);
            rechargeVBox.setBackground(backgroundRB);
            
            // Create a new scene with the rechargeVBox as the root and show the scene
            Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
            primaryStage.setScene(rechargeScene);
            
        });

        purchaseButton.setOnAction(e -> {
            System.out.println("Purchase Ticket Selected");
            //TODO: Add purchase ticket functionality
            // Create a new VBox for the "Ticket Pass Type" window
            VBox rechargeVBox = new VBox(10);
            rechargeVBox.setAlignment(Pos.CENTER);
            rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

            // Create a label and combo box with the pass type options
            //Label passTypeLabel = new Label("Select Ticket Type:");
            
            Text passTypeLabel = new Text(30.0, 80.0, "Select Ticket Type:");
            Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
            passTypeLabel.setFont(font1);
            //Setting the color of the text
            passTypeLabel.setFill(Color.YELLOW);
            //Setting the width
            passTypeLabel.setStrokeWidth(2);
            //Setting the stroke color
            passTypeLabel.setStroke(Color.DARKBLUE);
            
           
            ComboBox<String> passTypeCombo = new ComboBox<>();
            passTypeCombo.getItems().addAll(
                    "1 trip - $ 3.5",
                    "2 trips - $ 6",
                    "1 Day - $ 11",
                    "1 Week - $ 25",
                    "Unlimited Weekend - $ 17"
            );
            passTypeCombo.setValue("1 trip - $ 3.5");
            // Set the preferred width and height
            passTypeCombo.setPrefSize(220, 60);

            // Set the font to a larger size and bold
            passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

            // Set the border color and thickness
            passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
            
           
            // Create a button to confirm the pass type selection
            Button confirmPassTypeButton = new Button("Confirm");
            
            // Set the font size and style
            confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
           

            // Set the background color
            confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
          

            // Set the border
            confirmPassTypeButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
           

            // Set the preferred size
            confirmPassTypeButton.setPrefSize(120, 30);
            
            confirmPassTypeButton.setOnAction(e2 -> {
                this.passType = passTypeCombo.getValue();
               // this.passAmount = Double.parseDouble(passType.split(" ")[4]);
                
                System.out.println("Ticket Type Selected: " + this.passType);
               // System.out.println("Pass amount: " + this.passAmount);
                // Create a new VBox for the "Payment Method" window
                VBox paymentVBox = new VBox(10);
                paymentVBox.setAlignment(Pos.CENTER);
                paymentVBox.setPadding(new Insets(20, 20, 20, 20));

                // Create a label and combo box with the payment method options
                Text paymentLabel = new Text(30.0, 80.0, "Select Payment Method:");
                //Setting the font
                Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                paymentLabel.setFont(font2);
                //Setting the color of the text
                paymentLabel.setFill(Color.YELLOW);
                //Setting the width
                paymentLabel.setStrokeWidth(2);
                //Setting the stroke color
                paymentLabel.setStroke(Color.DARKBLUE);
                
               
                ComboBox<String> paymentCombo = new ComboBox<>();
                paymentCombo.getItems().addAll(
                        "Pay by Cash",
                        "Pay by Debit/Credit Card"
                );
                paymentCombo.setValue("Pay by Cash");

                // Set the preferred width and height
                paymentCombo.setPrefSize(220, 40);

                // Set the font to a larger size and bold
                paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

                // Set the border color and thickness
                paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
             // Create a button to confirm the payment method selection
                Button confirmPaymentButton = new Button("Confirm");
                // Set the font size and style
                confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
               

                // Set the background color
                confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
                confirmPaymentButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
                confirmPaymentButton.setPrefSize(120, 30);
                
                
                confirmPaymentButton.setOnAction(e3 -> {
                    String paymentMethod = paymentCombo.getValue();
                    System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

                    if (paymentMethod.equals("Pay by Cash")) {
                       // Some functionality for Pay by cash option
                        // Create a new VBox for the "Cash Payment" window
                        VBox cashVBox = new VBox(10);
                        cashVBox.setAlignment(Pos.CENTER);
                        cashVBox.setPadding(new Insets(20, 20, 20, 20));

                        // Create a label and text field for the cash amount input
                       // Label cashLabel = new Label("Enter Cash Amount:");
                        
                        Text cashLabel = new Text(30.0, 80.0, "Enter Cash Amount:");
                        //Setting the font
                        Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 52);
                        cashLabel.setFont(font3);
                        //Setting the color of the text
                        cashLabel.setFill(Color.YELLOW);
                        //Setting the width
                        cashLabel.setStrokeWidth(2);
                        //Setting the stroke color
                        cashLabel.setStroke(Color.DARKBLUE);
                        
                        
                        TextField cashField = new TextField();
                        cashField.setFont(Font.font("Arial", 20)); // set font size to 20
                        cashField.setMaxWidth(200); // set preferred width to 300 pixels
                        
                     // Create a button to confirm the cash amount
                        Button confirmCashButton = new Button("Confirm");
                        confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                        

                        // Set the background color
                        confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                      

                        // Set the border
                        confirmCashButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                       

                        // Set the preferred size
                        confirmCashButton.setPrefSize(120, 30);
                        
                        
                        confirmCashButton.setOnAction(e4 -> {
                            String cashAmount = cashField.getText();
                            System.out.println("Cash Amount Entered: " + cashAmount);

                          double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
                            double cash = Double.parseDouble(cashAmount);

                            if (cash >= passAmount) {
                                double balance = cash - passAmount;
                                String balanceMessage = String.format("Payment Successful!\nPlease collect your ticket and balance amount: $%.2f", balance);
                               // Label balanceLabel = new Label(balanceMessage);
                                
                                Text balanceLabel = new Text(30.0, 80.0, balanceMessage);
                                //Setting the font
                                Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
                                balanceLabel.setFont(font4);
                                //Setting the color of the text
                                balanceLabel.setFill(Color.YELLOW);
                                //Setting the width
                                balanceLabel.setStrokeWidth(2);
                                //Setting the stroke color
                                balanceLabel.setStroke(Color.DARKBLUE);
                                
                                
                                
                               // balanceLabel.setFont(Font.font("Arial", 16));

                                
                             // Create a new VBox for the "Payment Success" window
                             VBox successVBox = new VBox(10);
                             successVBox.setAlignment(Pos.CENTER);
                             successVBox.setPadding(new Insets(20, 20, 20, 20));
                             successVBox.getChildren().add(balanceLabel);

                             // Create an OK button to navigate back to the original scene
                             Button okButton = new Button("OK");
                             
                             okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                             

                             // Set the background color
                             okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                           

                             // Set the border
                             okButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                            

                             // Set the preferred size
                             okButton.setPrefSize(120, 30);
                             
                             okButton.setOnAction(e5 -> {
                                 primaryStage.setScene(mainScene);
                             });
                                
                                // Add the OK button to the successVBox
                                successVBox.getChildren().add(okButton);
                                
                                // Create an ImageView for the background image
                                Image backgroundImageSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                                BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                                BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeSB);
                                Background backgroundSB = new Background(backgroundImageObjSB);
                                successVBox.setBackground(backgroundSB);
                                
                                // Create a new scene with the successVBox as the root and show the scene
                                Scene successScene = new Scene(successVBox, 1200, 700);
                                primaryStage.setScene(successScene);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Entered amount is less. Please try again.");
                                alert.showAndWait();
                            }
                            //primaryStage.close();
                        });


                        // Add the label, text field, and confirm button to the cashVBox
                        cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);
                        
                        // Create an ImageView for the background image
                        Image backgroundImageCB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                        BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                        BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCB);
                        Background backgroundCB = new Background(backgroundImageObjCB);
                        cashVBox.setBackground(backgroundCB);
                        
                        // Create a new scene with the cashVBox as the root and show the scene
                        Scene cashScene = new Scene(cashVBox, 1200, 700);
                        primaryStage.setScene(cashScene);
			} else if(paymentMethod.equals("Pay by Debit/Credit Card")) {
                // add functionality for "Pay by Debit/Credit Card option
//Create a new VBox for the "Card Details" window
	 VBox cardDetailsVBox = new VBox(10);
        cardDetailsVBox.setAlignment(Pos.CENTER);
        cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

        // Create labels and text fields for card number and expiry date
        //Label cardNumberLabel = new Label("Card Number:");
        
        Text cardNumberLabel = new Text(30.0, 80.0, "Card Number:");
        //Setting the font
        Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        cardNumberLabel.setFont(font5);
        //Setting the color of the text
        cardNumberLabel.setFill(Color.YELLOW);
        //Setting the width
        cardNumberLabel.setStrokeWidth(2);
        //Setting the stroke color
        cardNumberLabel.setStroke(Color.DARKBLUE);
        
     //   cardNumberLabel.setFont(Font.font("Arial", 16));
        TextField cardNumberField = new TextField();
        cardNumberField.setFont(Font.font("Arial", 20)); // set font size to 20
        cardNumberField.setMaxWidth(500); // set preferred width to 300 pixels
        cardNumberField.setPromptText("Enter card number");
        
        //Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
        
        Text expiryDateLabel = new Text(30.0, 80.0, "Expiry Date (MM/YY):");
        //Setting the font
        Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        expiryDateLabel.setFont(font6);
        //Setting the color of the text
        expiryDateLabel.setFill(Color.YELLOW);
        //Setting the width
        expiryDateLabel.setStrokeWidth(2);
        //Setting the stroke color
        expiryDateLabel.setStroke(Color.DARKBLUE);
      //  expiryDateLabel.setFont(Font.font("Arial", 16));
        
        TextField expiryDateField = new TextField();
        expiryDateField.setFont(Font.font("Arial", 20)); // set font size to 20
        expiryDateField.setMaxWidth(500); // set preferred width to 300 pixels
        expiryDateField.setPromptText("MM/YY");
        
       // Label cvvLabel = new Label("CVV");
        Text cvvLabel = new Text(30.0, 80.0, "CVV:");
        //Setting the font
        Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        cvvLabel.setFont(font7);
        //Setting the color of the text
        cvvLabel.setFill(Color.YELLOW);
        //Setting the width
        cvvLabel.setStrokeWidth(2);
        //Setting the stroke color
        cvvLabel.setStroke(Color.DARKBLUE);
        
      //  cvvLabel.setFont(Font.font("Arial", 16));
        TextField cvvField = new TextField();
        cvvField.setFont(Font.font("Arial", 20)); // set font size to 20
        cvvField.setMaxWidth(500); // set preferred width to 300 pixels
        cvvField.setPromptText("Enter CVV");
        // Create a button to confirm the card details
        Button confirmCardDetailsButton = new Button("Confirm");
        
        confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        

        // Set the background color
        confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
      

        // Set the border
        confirmCardDetailsButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
       

        // Set the preferred size
        confirmCardDetailsButton.setPrefSize(120, 30);
        
        confirmCardDetailsButton.setOnAction(e4 -> {
            String cardNumber = cardNumberField.getText();
            String expiryDate = expiryDateField.getText();
            String cvv = cvvField.getText();
            
         // Validate expiry date
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
            Date currentDate = new Date();
            boolean validExpiryDate = true;
            try {
                Date expiryDateObj = dateFormat.parse(expiryDate);
                if (expiryDateObj.before(currentDate)) {
                    validExpiryDate = false;
                }
            } catch (ParseException ex) {
                validExpiryDate = false;
            }
            
         // Check for valid card number using Luhn algorithm
            int sum = 0;
            boolean alternate = false;
            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(cardNumber.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
            
            // Validate card details
            if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Card Details");
                alert.setContentText("Please enter valid card details.");
                alert.showAndWait();
            } else if (!cardNumber.matches("^\\d{16}$")) {
                // The card number must be a 16-digit number
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Card Number");
                alert.setContentText("Please enter a valid 16-digit card number.");
                alert.showAndWait();
            }else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
                // Check if the expiry date is a valid format
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Expiry date");
                alert.setContentText("Please enter a valid Expiry Date.");
                alert.showAndWait();
            }
            else if (!cvv.matches("^\\d{3}$")) {
                // Check if the expiry date is a valid format
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid CVV");
                alert.setContentText("Please enter a valid CVV number.");
                alert.showAndWait();
            }else if (!validExpiryDate) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Expired Card");
                alert.setContentText("The entered card has expired. Please use a valid card.");
                alert.showAndWait();
            }
            
            else if (sum % 10 != 0) {
            	Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid Card Number");
                alert.setContentText("Please enter a valid card number.");
                alert.showAndWait();
            }
            else {
            	// Proceed with payment
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            	alert.setTitle("Payment Confirmation");
            	alert.setHeaderText("Payment Successful");

            	// Set content text
            	String contentText = "Payment by Debit/Credit card for " + this.passType + " is successful.\nThank you for using igo TVM.\n\nPlease select your receipt prefernce :";
            	//Label contentLabel = new Label(contentText);
            	
            	 Text contentLabel = new Text(30.0, 80.0, contentText);
                 //Setting the font
                 Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
                 contentLabel.setFont(font4);
                 //Setting the color of the text
                 contentLabel.setFill(Color.YELLOW);
                 //Setting the width
                 contentLabel.setStrokeWidth(1);
                 //Setting the stroke color
                 contentLabel.setStroke(Color.DARKGREEN);

            	// Create radio buttons for ticket receipt preference
                 RadioButton emailRadioButton = new RadioButton("Email Receipt");
                 emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
                 RadioButton paperRadioButton = new RadioButton("Paper-based Receipt");
                 paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
            	
            	
            	
            	ToggleGroup receiptToggleGroup = new ToggleGroup();
            	emailRadioButton.setToggleGroup(receiptToggleGroup);
            	paperRadioButton.setToggleGroup(receiptToggleGroup);

            	// Create a text field for entering email address
            	TextField emailTextField = new TextField();
            	emailTextField.setFont(Font.font("Arial", 18)); // set font size to 20
            	emailTextField.setMaxWidth(500); // set preferred width to 300 pixels
            	emailTextField.setPromptText("Enter email address");

            	
            	// Create a button to confirm receipt preference
            	Button confirmReceiptButton = new Button("Confirm");
            	confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                 

                 // Set the background color
            	confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
               

                 // Set the border
            	confirmReceiptButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                

                 // Set the preferred size
            	confirmReceiptButton.setPrefSize(100, 20);
            	
            	confirmReceiptButton.setOnAction(e5 -> {
            	    String receiptPreference = "";
            	    if (emailRadioButton.isSelected()) {
            	    	if (emailTextField.getText().isEmpty()) {
            	            // Email address is required if email option is selected
            	            Alert emailAlert = new Alert(Alert.AlertType.ERROR, "Please enter your email address.");
            	            emailAlert.showAndWait();
            	            return;
            	        }
            	        receiptPreference = "Email";
            	        } else if (paperRadioButton.isSelected()) {
            	        receiptPreference = "Paper-based ticket";
            	    }
            	    // TODO: Implement logic for sending receipt by email or printing paper-based ticket
            	    // ...
            	   //primaryStage.setScene(mainScene);
            	});

            	// Create a VBox to hold the content label, radio buttons, and confirm button
            	VBox contentVBox = new VBox(10);
            	contentVBox.setAlignment(Pos.CENTER);
            	contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,emailTextField, confirmReceiptButton);
            		
            	emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());
            	
            	 // Create an ImageView for the background image
                Image backgroundImageCSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCSB);
                Background backgroundCSB = new Background(backgroundImageObjCSB);
                contentVBox.setBackground(backgroundCSB);
            	
            	// Set the content of the alert box to the content VBox
            	alert.getDialogPane().setContent(contentVBox);

            	// Increase the size of the alert box
            	alert.getDialogPane().setPrefSize(700, 400);

            	// Show the alert box
            	alert.showAndWait();

            	// Set the scene back to the main scene
            	primaryStage.setScene(mainScene);


            }
});

// Add the labels, text fields, and confirm button to the cardDetailsVBox
cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);


// Create an ImageView for the background image
Image backgroundImageCD = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/CD.png");

BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCD);
Background backgroundCD = new Background(backgroundImageObjCD);
cardDetailsVBox.setBackground(backgroundCD);

// Create a new scene with the cardDetailsVBox as the root and show the scene
Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
primaryStage.setScene(cardDetailsScene);
            }

                });

              


                // Add the label, combo box, and confirm button to the paymentVBox
                paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
                	
                // Create an ImageView for the background image
                Image backgroundImagePB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
                Background backgroundPB = new Background(backgroundImageObjPB);
                paymentVBox.setBackground(backgroundPB);
                
                // Create a new scene with the paymentVBox as the root and show the scene
                Scene paymentScene = new Scene(paymentVBox, 1200, 700);
                primaryStage.setScene(paymentScene);
            });

            // Add the label, combo box, and confirm button to the rechargeVBox
            rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);

            // Create an ImageView for the background image
            Image backgroundImageRB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/RB.png");

            BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
            BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
            Background backgroundRB = new Background(backgroundImageObjRB);
            rechargeVBox.setBackground(backgroundRB);
            
            // Create a new scene with the rechargeVBox as the root and show the scene
            Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
            primaryStage.setScene(rechargeScene);
        });

        // Add the language label and combo box to the language box
        // ResourceBundle bundle = ResourceBundle.getBundle("files:/Users/varunaggarwal/Desktop/TeamP-iGo/resources/strings_fr.properties", new Locale("fr"));
        
        // titleLabel.setText(bundle.getString("title"));
        // rechargeButton.setText(bundle.getString("recharge"));
        // purchaseButton.setText(bundle.getString("purchase"));
    }//Englishend

    //frenchstart
   // else if (newValue.equals("French")){
    //     {
       else if (languageCombo.getValue().equals("French")) {
        rechargeButton.setText("Recharger la carte de métro");
        purchaseButton.setText("Acheter un billet");
        


        titleLabel.setText("Bienvenue à la STM de Montréal");
        // Set the action for each button
        rechargeButton.setOnAction(e -> {
            // Create a new VBox for the "Recharge Pass Type" window
            VBox rechargeVBox = new VBox(10);
            rechargeVBox.setAlignment(Pos.CENTER);
            rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

            // Create a label and combo box with the pass type options
//            Label passTypeLabel = new Label("Select Pass Type:");
//            passTypeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 42));
//            passTypeLabel.setTextFill(Color.rgb(255, 255, 51));
            
            Text passTypeLabel = new Text(30.0, 80.0, "Sélectionnez le type de passe :");
            //Setting the font
            Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
            passTypeLabel.setFont(font1);
            //Setting the color of the text
            passTypeLabel.setFill(Color.YELLOW);
            //Setting the width
            passTypeLabel.setStrokeWidth(2);
            //Setting the stroke color
            passTypeLabel.setStroke(Color.DARKBLUE);
            
            
            ComboBox<String> passTypeCombo = new ComboBox<>();
            passTypeCombo.getItems().addAll(
                    "2 semaines - $ 35",
                    "1 mois - $ 56",
                    "2 mois - $ 98",
                    "3 mois - $ 135"
            );
            passTypeCombo.setValue("2 semaines - $ 35");
            
         // Set the preferred width and height
            passTypeCombo.setPrefSize(220, 60);

            // Set the font to a larger size and bold
            passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

            // Set the border color and thickness
            passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
            
           
            
            
            // Create a button to confirm the pass type selection
            Button confirmPassTypeButton = new Button("Confirmer");
            
            // Set the font size and style
            confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
           

            // Set the background color
            confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
          

            // Set the border
            confirmPassTypeButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
           

            // Set the preferred size
            confirmPassTypeButton.setPrefSize(120, 30);
           
            
            confirmPassTypeButton.setOnAction(e2 -> {
                this.passType = passTypeCombo.getValue();
               // this.passAmount = Double.parseDouble(passType.split(" ")[4]);
                
                System.out.println("Pass Type Selected: " + this.passType);
               // System.out.println("Pass amount: " + this.passAmount);
                // Create a new VBox for the "Payment Method" window
                VBox paymentVBox = new VBox(10);
                paymentVBox.setAlignment(Pos.CENTER);
                paymentVBox.setPadding(new Insets(20, 20, 20, 20));

                // Create a label and combo box with the payment method options
               // Label paymentLabel = new Label("Select Payment Method:");
                
                Text paymentLabel = new Text(30.0, 80.0, "Sélectionnez le mode de paiement:");
                //Setting the font
                Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                paymentLabel.setFont(font2);
                //Setting the color of the text
                paymentLabel.setFill(Color.YELLOW);
                //Setting the width
                paymentLabel.setStrokeWidth(2);
                //Setting the stroke color
                paymentLabel.setStroke(Color.DARKBLUE);
                
               
                ComboBox<String> paymentCombo = new ComboBox<>();
                paymentCombo.getItems().addAll(
                        "Payer en espèce",
                        "Payer par carte de débit/crédit"
                );
                paymentCombo.setValue("Payer en espèce");

                // Set the preferred width and height
                paymentCombo.setPrefSize(220, 40);

                // Set the font to a larger size and bold
                paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

                // Set the border color and thickness
                paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
             // Create a button to confirm the payment method selection
                Button confirmPaymentButton = new Button("Confirmer");
                // Set the font size and style
                confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
               

                // Set the background color
                confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
                confirmPaymentButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
                confirmPaymentButton.setPrefSize(120, 30);
                
                
                confirmPaymentButton.setOnAction(e3 -> {
                    String paymentMethod = paymentCombo.getValue();
                    System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

                    if (paymentMethod.equals("Payer en espèce")) {
                       // Some functionality for Pay by cash option
                        // Create a new VBox for the "Cash Payment" window
                        VBox cashVBox = new VBox(10);
                        cashVBox.setAlignment(Pos.CENTER);
                        cashVBox.setPadding(new Insets(20, 20, 20, 20));

                        // Create a label and text field for the cash amount input
                       // Label cashLabel = new Label("Enter Cash Amount:");
                        
                        Text cashLabel = new Text(30.0, 80.0, "Saisissez le montant en espèces :");
                        //Setting the font
                        Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                        cashLabel.setFont(font3);
                        //Setting the color of the text
                        cashLabel.setFill(Color.YELLOW);
                        //Setting the width
                        cashLabel.setStrokeWidth(2);
                        //Setting the stroke color
                        cashLabel.setStroke(Color.DARKBLUE);
                        
                        
                        TextField cashField = new TextField();
                        cashField.setFont(Font.font("Arial", 20)); // set font size to 20
                        cashField.setMaxWidth(200); // set preferred width to 300 pixels
                        
                     // Create a button to confirm the cash amount
                        Button confirmCashButton = new Button("Confirmer");
                        confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                        

                        // Set the background color
                        confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                      

                        // Set the border
                        confirmCashButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                       

                        // Set the preferred size
                        confirmCashButton.setPrefSize(120, 30);
                        
                        
                        confirmCashButton.setOnAction(e4 -> {
                            String cashAmount = cashField.getText();
                            System.out.println("Cash Amount Entered: " + cashAmount);

                          double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
                            double cash = Double.parseDouble(cashAmount);

                            if (cash >= passAmount) {
                                double balance = cash - passAmount;
                                String balanceMessage = String.format("Paiement réussi!\nVeuillez retirer votre carte et le montant du solde : $%.2f", balance);
                               // Label balanceLabel = new Label(balanceMessage);
                                
                                Text balanceLabel = new Text(30.0, 80.0, balanceMessage);
                                //Setting the font
                                Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
                                balanceLabel.setFont(font4);
                                //Setting the color of the text
                                balanceLabel.setFill(Color.YELLOW);
                                //Setting the width
                                balanceLabel.setStrokeWidth(2);
                                //Setting the stroke color
                                balanceLabel.setStroke(Color.DARKBLUE);
                                
                                
                                
                               // balanceLabel.setFont(Font.font("Arial", 16));

                                
                             // Create a new VBox for the "Payment Success" window
                             VBox successVBox = new VBox(10);
                             successVBox.setAlignment(Pos.CENTER);
                             successVBox.setPadding(new Insets(20, 20, 20, 20));
                             successVBox.getChildren().add(balanceLabel);

                             // Create an OK button to navigate back to the original scene
                             Button okButton = new Button("OK");
                             
                             okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                             

                             // Set the background color
                             okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                           

                             // Set the border
                             okButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                            

                             // Set the preferred size
                             okButton.setPrefSize(120, 30);
                             
                             okButton.setOnAction(e5 -> {
                                 primaryStage.setScene(mainScene);
                             });

                             // Add the OK button to the successVBox
                             successVBox.getChildren().add(okButton);
                             
                             
                             // Create an ImageView for the background image
                             Image backgroundImageSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                             BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                             BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeSB);
                             Background backgroundSB = new Background(backgroundImageObjSB);
                             successVBox.setBackground(backgroundSB);
                             
                             // Create a new scene with the successVBox as the root and show the scene
                             Scene successScene = new Scene(successVBox, 1200, 700);
                             primaryStage.setScene(successScene);
                             


                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Le montant saisi est inférieur. Veuillez réessayer.");
                                alert.showAndWait();
                            }
                            //primaryStage.close();
                        });


                        // Add the label, text field, and confirm button to the cashVBox
                        cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);
                        // Create an ImageView for the background image
                        Image backgroundImageCB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                        BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                        BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCB);
                        Background backgroundCB = new Background(backgroundImageObjCB);
                        cashVBox.setBackground(backgroundCB);
                        
                        // Create a new scene with the cashVBox as the root and show the scene
                        Scene cashScene = new Scene(cashVBox, 1200, 700);
                        primaryStage.setScene(cashScene);

		 } else if(paymentMethod.equals("Payer par carte de débit/crédit")) {
                        // add functionality for "Pay by Debit/Credit Card option
// Create a new VBox for the "Card Details" window
			 VBox cardDetailsVBox = new VBox(10);
		        cardDetailsVBox.setAlignment(Pos.CENTER);
		        cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

		        // Create labels and text fields for card number and expiry date
		        //Label cardNumberLabel = new Label("Card Number:");
		        
		        Text cardNumberLabel = new Text(30.0, 80.0, "Numéro de carte:");
                //Setting the font
                Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                cardNumberLabel.setFont(font5);
                //Setting the color of the text
                cardNumberLabel.setFill(Color.YELLOW);
                //Setting the width
                cardNumberLabel.setStrokeWidth(2);
                //Setting the stroke color
                cardNumberLabel.setStroke(Color.DARKBLUE);
		        
		     //   cardNumberLabel.setFont(Font.font("Arial", 16));
		        TextField cardNumberField = new TextField();
		        cardNumberField.setFont(Font.font("Arial", 20)); // set font size to 20
		        cardNumberField.setMaxWidth(500); // set preferred width to 300 pixels
		        cardNumberField.setPromptText("Entrez le numéro de carte");
                
		        //Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
		        
		        Text expiryDateLabel = new Text(30.0, 80.0, "Date d'expiration (MM/YY):");
                //Setting the font
                Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                expiryDateLabel.setFont(font6);
                //Setting the color of the text
                expiryDateLabel.setFill(Color.YELLOW);
                //Setting the width
                expiryDateLabel.setStrokeWidth(2);
                //Setting the stroke color
                expiryDateLabel.setStroke(Color.DARKBLUE);
		      //  expiryDateLabel.setFont(Font.font("Arial", 16));
                
		        TextField expiryDateField = new TextField();
		        expiryDateField.setFont(Font.font("Arial", 20)); // set font size to 20
		        expiryDateField.setMaxWidth(500); // set preferred width to 300 pixels
		        expiryDateField.setPromptText("MM/YY");
		        
		       // Label cvvLabel = new Label("CVV");
		        Text cvvLabel = new Text(30.0, 80.0, "CVV:");
                //Setting the font
                Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
                cvvLabel.setFont(font7);
                //Setting the color of the text
                cvvLabel.setFill(Color.YELLOW);
                //Setting the width
                cvvLabel.setStrokeWidth(2);
                //Setting the stroke color
                cvvLabel.setStroke(Color.DARKBLUE);
		        
		      //  cvvLabel.setFont(Font.font("Arial", 16));
		        TextField cvvField = new TextField();
		        cvvField.setFont(Font.font("Arial", 20)); // set font size to 20
		        cvvField.setMaxWidth(500); // set preferred width to 300 pixels
		        cvvField.setPromptText("Entrez CVV");
		        // Create a button to confirm the card details
		        Button confirmCardDetailsButton = new Button("Confirmer");
		        
		        confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                

                // Set the background color
		        confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
		        confirmCardDetailsButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
		        confirmCardDetailsButton.setPrefSize(120, 30);
                
		        confirmCardDetailsButton.setOnAction(e4 -> {
		            String cardNumber = cardNumberField.getText();
		            String expiryDate = expiryDateField.getText();
		            String cvv = cvvField.getText();
		            
		         // Validate expiry date
		            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
		            Date currentDate = new Date();
		            boolean validExpiryDate = true;
		            try {
		                Date expiryDateObj = dateFormat.parse(expiryDate);
		                if (expiryDateObj.before(currentDate)) {
		                    validExpiryDate = false;
		                }
		            } catch (ParseException ex) {
		                validExpiryDate = false;
		            }
		            
		         // Check for valid card number using Luhn algorithm
		            int sum = 0;
		            boolean alternate = false;
		            for (int i = cardNumber.length() - 1; i >= 0; i--) {
		                int n = Integer.parseInt(cardNumber.substring(i, i + 1));
		                if (alternate) {
		                    n *= 2;
		                    if (n > 9) {
		                        n = (n % 10) + 1;
		                    }
		                }
		                sum += n;
		                alternate = !alternate;
		            }
		            
		            // Validate card details
		            if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Détails de la carte non valides");
		                alert.setContentText("Veuillez entrer des détails de carte valides.");
		                alert.showAndWait();
		            } else if (!cardNumber.matches("^\\d{16}$")) {
		                // The card number must be a 16-digit number
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Numéro de carte invalide");
		                alert.setContentText("Veuillez entrer un numéro de carte valide à 16 chiffres.");
		                alert.showAndWait();
		            }else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
		                // Check if the expiry date is a valid format
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Date d'expiration invalide");
		                alert.setContentText("Veuillez saisir une date d'expiration valide.");
		                alert.showAndWait();
		            }
		            else if (!cvv.matches("^\\d{3}$")) {
		                // Check if the expiry date is a valid format
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Invalide CVV");
		                alert.setContentText("Veuillez entrer un numéro CVV valide.");
		                alert.showAndWait();
		            }else if (!validExpiryDate) {
		                Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Carte expirée");
		                alert.setContentText("La carte saisie a expiré. Veuillez utiliser une carte valide.");
		                alert.showAndWait();
		            }
		            
		            else if (sum % 10 != 0) {
		            	Alert alert = new Alert(Alert.AlertType.ERROR);
		                alert.setTitle("Error");
		                alert.setHeaderText("Numéro de carte invalide");
		                alert.setContentText("S'il vous plaît entrez un numéro de carte valide.");
		                alert.showAndWait();
		            }
		            else {
		            	// Proceed with payment
		            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
		            	alert.setTitle("Confirmation de paiement");
		            	alert.setHeaderText("Paiement réussi");

		            	// Set content text
		            	String contentText = "Paiement par carte de débit/crédit pour " + this.passType + "est réussi.\nMerci d'utiliser igo TVM.\n\nVeuillez sélectionner votre préférence de réception :";
		            	//Label contentLabel = new Label(contentText);
		            	
		            	 Text contentLabel = new Text(30.0, 80.0, contentText);
                         //Setting the font
                         Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
                         contentLabel.setFont(font4);
                         //Setting the color of the text
                         contentLabel.setFill(Color.YELLOW);
                         //Setting the width
                         contentLabel.setStrokeWidth(1);
                         //Setting the stroke color
                         contentLabel.setStroke(Color.DARKGREEN);

		            	// Create radio buttons for ticket receipt preference
                         RadioButton emailRadioButton = new RadioButton("Reçu par e-mail");
                         emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
                         RadioButton paperRadioButton = new RadioButton("Reçu papier");
                         paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
		            	
		            	
		            	
		            	ToggleGroup receiptToggleGroup = new ToggleGroup();
		            	emailRadioButton.setToggleGroup(receiptToggleGroup);
		            	paperRadioButton.setToggleGroup(receiptToggleGroup);

		            	// Create a text field for entering email address
		            	TextField emailTextField = new TextField();
		            	emailTextField.setFont(Font.font("Arial", 18)); // set font size to 20
		            	emailTextField.setMaxWidth(500); // set preferred width to 300 pixels
		            	emailTextField.setPromptText("Entrer l'adresse e-mail");

		            	
		            	// Create a button to confirm receipt preference
		            	Button confirmReceiptButton = new Button("Confirmer");
		            	confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
		                 

		                 // Set the background color
		            	confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
		               

		                 // Set the border
		            	confirmReceiptButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
		                

		                 // Set the preferred size
		            	confirmReceiptButton.setPrefSize(120, 20);
		            	
		            	confirmReceiptButton.setOnAction(e5 -> {
		            	    String receiptPreference = "";
		            	    if (emailRadioButton.isSelected()) {
		            	    	if (emailTextField.getText().isEmpty()) {
		            	            // Email address is required if email option is selected
		            	            Alert emailAlert = new Alert(Alert.AlertType.ERROR, "Veuillez saisir votre adresse e-mail.");
		            	            emailAlert.showAndWait();
		            	            return;
		            	        }
		            	        receiptPreference = "Email";
		            	        } else if (paperRadioButton.isSelected()) {
		            	        receiptPreference = "Paper-based ticket";
		            	    }
		            	    // TODO: Implement logic for sending receipt by email or printing paper-based ticket
		            	    // ...
		            	   //primaryStage.setScene(mainScene);
		            	});

		            	// Create a VBox to hold the content label, radio buttons, and confirm button
		            	VBox contentVBox = new VBox(10);
		            	contentVBox.setAlignment(Pos.CENTER);
		            	contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,emailTextField, confirmReceiptButton);
		            		
		            	emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());
		            	
		            	 // Create an ImageView for the background image
		                Image backgroundImageCSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

		                BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
		                BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCSB);
		                Background backgroundCSB = new Background(backgroundImageObjCSB);
		                contentVBox.setBackground(backgroundCSB);
		            	
		            	// Set the content of the alert box to the content VBox
		            	alert.getDialogPane().setContent(contentVBox);

		            	// Increase the size of the alert box
		            	alert.getDialogPane().setPrefSize(700, 400);

		            	// Show the alert box
		            	alert.showAndWait();

		            	// Set the scene back to the main scene
		            	primaryStage.setScene(mainScene);


		            }
        });

        // Add the labels, text fields, and confirm button to the cardDetailsVBox
        cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);

        
        // Create an ImageView for the background image
        Image backgroundImageCD = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/CD.png");

        BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
        BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCD);
        Background backgroundCD = new Background(backgroundImageObjCD);
        cardDetailsVBox.setBackground(backgroundCD);
        
        // Create a new scene with the cardDetailsVBox as the root and show the scene
        Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
        primaryStage.setScene(cardDetailsScene);
                    }
                });

              


                // Add the label, combo box, and confirm button to the paymentVBox
                paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
                // Create an ImageView for the background image
                Image backgroundImagePB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
                Background backgroundPB = new Background(backgroundImageObjPB);
                paymentVBox.setBackground(backgroundPB);
                
                // Create a new scene with the paymentVBox as the root and show the scene
                Scene paymentScene = new Scene(paymentVBox, 1200, 700);
                primaryStage.setScene(paymentScene);
            });

            // Add the label, combo box, and confirm button to the rechargeVBox
            rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);
            
            // Create an ImageView for the background image
            Image backgroundImageRB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/RB.png");

            BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
            BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
            Background backgroundRB = new Background(backgroundImageObjRB);
            rechargeVBox.setBackground(backgroundRB);
            
            // Create a new scene with the rechargeVBox as the root and show the scene
            Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
            primaryStage.setScene(rechargeScene);
            
        });

        purchaseButton.setOnAction(e -> {
            System.out.println("Purchase Ticket Selected");
            //TODO: Add purchase ticket functionality
            // Create a new VBox for the "Ticket Pass Type" window
            VBox rechargeVBox = new VBox(10);
            rechargeVBox.setAlignment(Pos.CENTER);
            rechargeVBox.setPadding(new Insets(20, 20, 20, 20));

            // Create a label and combo box with the pass type options
            //Label passTypeLabel = new Label("Select Ticket Type:");
            
            Text passTypeLabel = new Text(30.0, 80.0, "Sélectionnez le type de billet :");
            Font font1 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
            passTypeLabel.setFont(font1);
            //Setting the color of the text
            passTypeLabel.setFill(Color.YELLOW);
            //Setting the width
            passTypeLabel.setStrokeWidth(2);
            //Setting the stroke color
            passTypeLabel.setStroke(Color.DARKBLUE);
            
           
            ComboBox<String> passTypeCombo = new ComboBox<>();
            passTypeCombo.getItems().addAll(
                    "1 Voyage - $ 3.5",
                    "2 Voyages - $ 6",
                    "1 Jour - $ 11",
                    "1 Semaine - $ 25",
                    "Weekend illimité - $ 17"
            );
            passTypeCombo.setValue("1 Voyage - $ 3.5");
            // Set the preferred width and height
            passTypeCombo.setPrefSize(220, 60);

            // Set the font to a larger size and bold
            passTypeCombo.setStyle("-fx-font-size: 24pt; -fx-font-weight: bold;");

            // Set the border color and thickness
            passTypeCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
            
           
            // Create a button to confirm the pass type selection
            Button confirmPassTypeButton = new Button("Confirmer");
            
            // Set the font size and style
            confirmPassTypeButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
           

            // Set the background color
            confirmPassTypeButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
          

            // Set the border
            confirmPassTypeButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
           

            // Set the preferred size
            confirmPassTypeButton.setPrefSize(120, 30);
            
            confirmPassTypeButton.setOnAction(e2 -> {
                this.passType = passTypeCombo.getValue();
               // this.passAmount = Double.parseDouble(passType.split(" ")[4]);
                
                System.out.println("Ticket Type Selected: " + this.passType);
               // System.out.println("Pass amount: " + this.passAmount);
                // Create a new VBox for the "Payment Method" window
                VBox paymentVBox = new VBox(10);
                paymentVBox.setAlignment(Pos.CENTER);
                paymentVBox.setPadding(new Insets(20, 20, 20, 20));

                // Create a label and combo box with the payment method options
                Text paymentLabel = new Text(30.0, 80.0, "Sélectionnez le mode de paiement:");
                //Setting the font
                Font font2 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 64);
                paymentLabel.setFont(font2);
                //Setting the color of the text
                paymentLabel.setFill(Color.YELLOW);
                //Setting the width
                paymentLabel.setStrokeWidth(2);
                //Setting the stroke color
                paymentLabel.setStroke(Color.DARKBLUE);
                
               
                ComboBox<String> paymentCombo = new ComboBox<>();
                paymentCombo.getItems().addAll(
                        "Payer en espèce",
                        "Payer par carte de débit/crédit"
                );
                paymentCombo.setValue("Payer en espèce");

                // Set the preferred width and height
                paymentCombo.setPrefSize(220, 40);

                // Set the font to a larger size and bold
                paymentCombo.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");

                // Set the border color and thickness
                paymentCombo.setStyle("-fx-border-color: #000099; -fx-border-width: 3px;");
             // Create a button to confirm the payment method selection
                Button confirmPaymentButton = new Button("Confirmer");
                // Set the font size and style
                confirmPaymentButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
               

                // Set the background color
                confirmPaymentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
              

                // Set the border
                confirmPaymentButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
               

                // Set the preferred size
                confirmPaymentButton.setPrefSize(120, 30);
                
                
                confirmPaymentButton.setOnAction(e3 -> {
                    String paymentMethod = paymentCombo.getValue();
                    System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);

                    if (paymentMethod.equals("Payer en espèce")) {
                       // Some functionality for Pay by cash option
                        // Create a new VBox for the "Cash Payment" window
                        VBox cashVBox = new VBox(10);
                        cashVBox.setAlignment(Pos.CENTER);
                        cashVBox.setPadding(new Insets(20, 20, 20, 20));

                        // Create a label and text field for the cash amount input
                       // Label cashLabel = new Label("Enter Cash Amount:");
                        
                        Text cashLabel = new Text(30.0, 80.0, "Saisissez le montant en espèces :");
                        //Setting the font
                        Font font3 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 52);
                        cashLabel.setFont(font3);
                        //Setting the color of the text
                        cashLabel.setFill(Color.YELLOW);
                        //Setting the width
                        cashLabel.setStrokeWidth(2);
                        //Setting the stroke color
                        cashLabel.setStroke(Color.DARKBLUE);
                        
                        
                        TextField cashField = new TextField();
                        cashField.setFont(Font.font("Arial", 20)); // set font size to 20
                        cashField.setMaxWidth(200); // set preferred width to 300 pixels
                        
                     // Create a button to confirm the cash amount
                        Button confirmCashButton = new Button("Confirmer");
                        confirmCashButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                        

                        // Set the background color
                        confirmCashButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                      

                        // Set the border
                        confirmCashButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                       

                        // Set the preferred size
                        confirmCashButton.setPrefSize(120, 30);
                        
                        
                        confirmCashButton.setOnAction(e4 -> {
                            String cashAmount = cashField.getText();
                            System.out.println("Cash Amount Entered: " + cashAmount);

                          double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
                            double cash = Double.parseDouble(cashAmount);

                            if (cash >= passAmount) {
                                double balance = cash - passAmount;
                                String balanceMessage = String.format("Paiement réussi !\nVeuillez retirer votre billet et le montant du solde : $%.2f", balance);
                               // Label balanceLabel = new Label(balanceMessage);
                                
                                Text balanceLabel = new Text(30.0, 80.0, balanceMessage);
                                //Setting the font
                                Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 42);
                                balanceLabel.setFont(font4);
                                //Setting the color of the text
                                balanceLabel.setFill(Color.YELLOW);
                                //Setting the width
                                balanceLabel.setStrokeWidth(2);
                                //Setting the stroke color
                                balanceLabel.setStroke(Color.DARKBLUE);
                                
                                
                                
                               // balanceLabel.setFont(Font.font("Arial", 16));

                                
                             // Create a new VBox for the "Payment Success" window
                             VBox successVBox = new VBox(10);
                             successVBox.setAlignment(Pos.CENTER);
                             successVBox.setPadding(new Insets(20, 20, 20, 20));
                             successVBox.getChildren().add(balanceLabel);

                             // Create an OK button to navigate back to the original scene
                             Button okButton = new Button("OK");
                             
                             okButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                             

                             // Set the background color
                             okButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
                           

                             // Set the border
                             okButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                            

                             // Set the preferred size
                             okButton.setPrefSize(120, 30);
                             
                             okButton.setOnAction(e5 -> {
                                 primaryStage.setScene(mainScene);
                             });
                                
                                // Add the OK button to the successVBox
                                successVBox.getChildren().add(okButton);
                                
                                // Create an ImageView for the background image
                                Image backgroundImageSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                                BackgroundSize backgroundSizeSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                                BackgroundImage backgroundImageObjSB = new BackgroundImage(backgroundImageSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeSB);
                                Background backgroundSB = new Background(backgroundImageObjSB);
                                successVBox.setBackground(backgroundSB);
                                
                                // Create a new scene with the successVBox as the root and show the scene
                                Scene successScene = new Scene(successVBox, 1200, 700);
                                primaryStage.setScene(successScene);
                            } else {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Le montant saisi est inférieur. Veuillez réessayer.");
                                alert.showAndWait();
                            }
                            //primaryStage.close();
                        });


                        // Add the label, text field, and confirm button to the cashVBox
                        cashVBox.getChildren().addAll(cashLabel, cashField, confirmCashButton);
                        
                        // Create an ImageView for the background image
                        Image backgroundImageCB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                        BackgroundSize backgroundSizeCB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                        BackgroundImage backgroundImageObjCB = new BackgroundImage(backgroundImageCB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCB);
                        Background backgroundCB = new Background(backgroundImageObjCB);
                        cashVBox.setBackground(backgroundCB);
                        
                        // Create a new scene with the cashVBox as the root and show the scene
                        Scene cashScene = new Scene(cashVBox, 1200, 700);
                        primaryStage.setScene(cashScene);
			} else if(paymentMethod.equals("Payer par carte de débit/crédit")) {
                // add functionality for "Pay by Debit/Credit Card option
//Create a new VBox for the "Card Details" window
	 VBox cardDetailsVBox = new VBox(10);
        cardDetailsVBox.setAlignment(Pos.CENTER);
        cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));

        // Create labels and text fields for card number and expiry date
        //Label cardNumberLabel = new Label("Card Number:");
        
        Text cardNumberLabel = new Text(30.0, 80.0, "Numéro de carte:");
        //Setting the font
        Font font5 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        cardNumberLabel.setFont(font5);
        //Setting the color of the text
        cardNumberLabel.setFill(Color.YELLOW);
        //Setting the width
        cardNumberLabel.setStrokeWidth(2);
        //Setting the stroke color
        cardNumberLabel.setStroke(Color.DARKBLUE);
        
     //   cardNumberLabel.setFont(Font.font("Arial", 16));
        TextField cardNumberField = new TextField();
        cardNumberField.setFont(Font.font("Arial", 20)); // set font size to 20
        cardNumberField.setMaxWidth(500); // set preferred width to 300 pixels
        cardNumberField.setPromptText("Entrez le numéro de carte");
        
        //Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
        
        Text expiryDateLabel = new Text(30.0, 80.0, "Date d'expiration (MM/YY):");
        //Setting the font
        Font font6 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        expiryDateLabel.setFont(font6);
        //Setting the color of the text
        expiryDateLabel.setFill(Color.YELLOW);
        //Setting the width
        expiryDateLabel.setStrokeWidth(2);
        //Setting the stroke color
        expiryDateLabel.setStroke(Color.DARKBLUE);
      //  expiryDateLabel.setFont(Font.font("Arial", 16));
        
        TextField expiryDateField = new TextField();
        expiryDateField.setFont(Font.font("Arial", 20)); // set font size to 20
        expiryDateField.setMaxWidth(500); // set preferred width to 300 pixels
        expiryDateField.setPromptText("MM/YY");
        
       // Label cvvLabel = new Label("CVV");
        Text cvvLabel = new Text(30.0, 80.0, "CVV:");
        //Setting the font
        Font font7 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32);
        cvvLabel.setFont(font7);
        //Setting the color of the text
        cvvLabel.setFill(Color.YELLOW);
        //Setting the width
        cvvLabel.setStrokeWidth(2);
        //Setting the stroke color
        cvvLabel.setStroke(Color.DARKBLUE);
        
      //  cvvLabel.setFont(Font.font("Arial", 16));
        TextField cvvField = new TextField();
        cvvField.setFont(Font.font("Arial", 20)); // set font size to 20
        cvvField.setMaxWidth(500); // set preferred width to 300 pixels
        cvvField.setPromptText("Entrez CVV");
        // Create a button to confirm the card details
        Button confirmCardDetailsButton = new Button("Confirmer");
        
        confirmCardDetailsButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        

        // Set the background color
        confirmCardDetailsButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
      

        // Set the border
        confirmCardDetailsButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
       

        // Set the preferred size
        confirmCardDetailsButton.setPrefSize(120, 30);
        
        confirmCardDetailsButton.setOnAction(e4 -> {
            String cardNumber = cardNumberField.getText();
            String expiryDate = expiryDateField.getText();
            String cvv = cvvField.getText();
            
         // Validate expiry date
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
            Date currentDate = new Date();
            boolean validExpiryDate = true;
            try {
                Date expiryDateObj = dateFormat.parse(expiryDate);
                if (expiryDateObj.before(currentDate)) {
                    validExpiryDate = false;
                }
            } catch (ParseException ex) {
                validExpiryDate = false;
            }
            
         // Check for valid card number using Luhn algorithm
            int sum = 0;
            boolean alternate = false;
            for (int i = cardNumber.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(cardNumber.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n = (n % 10) + 1;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
            
            // Validate card details
            if (cardNumber.isEmpty() || expiryDate.isEmpty() || cvv.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Détails de la carte non valides");
                alert.setContentText("Veuillez entrer des détails de carte valides.");
                alert.showAndWait();
            } else if (!cardNumber.matches("^\\d{16}$")) {
                // The card number must be a 16-digit number
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Numéro de carte invalide");
                alert.setContentText("Veuillez entrer un numéro de carte valide à 16 chiffres.");
                alert.showAndWait();
            }else if (!expiryDate.matches("^(0[1-9]|1[0-2])/\\d{2}$")) {
                // Check if the expiry date is a valid format
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Date d'expiration invalide");
                alert.setContentText("Veuillez saisir une date d'expiration valide.");
                alert.showAndWait();
            }
            else if (!cvv.matches("^\\d{3}$")) {
                // Check if the expiry date is a valid format
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalide CVV");
                alert.setContentText("Veuillez entrer un numéro CVV valide.");
                alert.showAndWait();
            }else if (!validExpiryDate) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Carte expirée");
                alert.setContentText("La carte saisie a expiré. Veuillez utiliser une carte valide.");
                alert.showAndWait();
            }
            
            else if (sum % 10 != 0) {
            	Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Numéro de carte invalide");
                alert.setContentText("S'il vous plaît entrez un numéro de carte valide.");
                alert.showAndWait();
            }
            else {
            	// Proceed with payment
            	Alert alert = new Alert(Alert.AlertType.INFORMATION);
            	alert.setTitle("Confirmation de paiement");
            	alert.setHeaderText("Paiement réussi");

            	// Set content text
            	String contentText = "Paiement par carte de débit/crédit pour " + this.passType + "est réussi.\nMerci d'utiliser igo TVM.\n\nVeuillez sélectionner votre préférence de réception :";
            	//Label contentLabel = new Label(contentText);
            	
            	 Text contentLabel = new Text(30.0, 80.0, contentText);
                 //Setting the font
                 Font font4 = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 30);
                 contentLabel.setFont(font4);
                 //Setting the color of the text
                 contentLabel.setFill(Color.YELLOW);
                 //Setting the width
                 contentLabel.setStrokeWidth(1);
                 //Setting the stroke color
                 contentLabel.setStroke(Color.DARKGREEN);

            	// Create radio buttons for ticket receipt preference
                 RadioButton emailRadioButton = new RadioButton("Reçu par e-mail");
                 emailRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
                 RadioButton paperRadioButton = new RadioButton("Paper-based Receipt");
                 paperRadioButton.setStyle("-fx-font-size: 22px; -fx-text-fill: #ffff00;");
            	
            	
            	
            	ToggleGroup receiptToggleGroup = new ToggleGroup();
            	emailRadioButton.setToggleGroup(receiptToggleGroup);
            	paperRadioButton.setToggleGroup(receiptToggleGroup);

            	// Create a text field for entering email address
            	TextField emailTextField = new TextField();
            	emailTextField.setFont(Font.font("Arial", 18)); // set font size to 20
            	emailTextField.setMaxWidth(500); // set preferred width to 300 pixels
            	emailTextField.setPromptText("Entrer l'adresse e-mail");

            	
            	// Create a button to confirm receipt preference
            	Button confirmReceiptButton = new Button("Confirmer");
            	confirmReceiptButton.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                 

                 // Set the background color
            	confirmReceiptButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
               

                 // Set the border
            	confirmReceiptButton.setStyle("-fx-border-color: #009900; -fx-border-width: 3px; -fx-border-radius: 3px;");
                

                 // Set the preferred size
            	confirmReceiptButton.setPrefSize(120, 20);
            	
            	confirmReceiptButton.setOnAction(e5 -> {
            	    String receiptPreference = "";
            	    if (emailRadioButton.isSelected()) {
            	    	if (emailTextField.getText().isEmpty()) {
            	            // Email address is required if email option is selected
            	            Alert emailAlert = new Alert(Alert.AlertType.ERROR, "Veuillez saisir votre adresse e-mail.");
            	            emailAlert.showAndWait();
            	            return;
            	        }
            	        receiptPreference = "Email";
            	        } else if (paperRadioButton.isSelected()) {
            	        receiptPreference = "Paper-based ticket";
            	    }
            	    // TODO: Implement logic for sending receipt by email or printing paper-based ticket
            	    // ...
            	   //primaryStage.setScene(mainScene);
            	});

            	// Create a VBox to hold the content label, radio buttons, and confirm button
            	VBox contentVBox = new VBox(10);
            	contentVBox.setAlignment(Pos.CENTER);
            	contentVBox.getChildren().addAll(contentLabel, emailRadioButton, paperRadioButton,emailTextField, confirmReceiptButton);
            		
            	emailTextField.visibleProperty().bind(emailRadioButton.selectedProperty());
            	
            	 // Create an ImageView for the background image
                Image backgroundImageCSB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/SB.png");

                BackgroundSize backgroundSizeCSB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjCSB = new BackgroundImage(backgroundImageCSB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCSB);
                Background backgroundCSB = new Background(backgroundImageObjCSB);
                contentVBox.setBackground(backgroundCSB);
            	
            	// Set the content of the alert box to the content VBox
            	alert.getDialogPane().setContent(contentVBox);

            	// Increase the size of the alert box
            	alert.getDialogPane().setPrefSize(700, 400);

            	// Show the alert box
            	alert.showAndWait();

            	// Set the scene back to the main scene
            	primaryStage.setScene(mainScene);


            }
});

// Add the labels, text fields, and confirm button to the cardDetailsVBox
cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);


// Create an ImageView for the background image
Image backgroundImageCD = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/CD.png");

BackgroundSize backgroundSizeCD = new BackgroundSize(1.0, 1.0, true, true, false, false);
BackgroundImage backgroundImageObjCD = new BackgroundImage(backgroundImageCD, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeCD);
Background backgroundCD = new Background(backgroundImageObjCD);
cardDetailsVBox.setBackground(backgroundCD);

// Create a new scene with the cardDetailsVBox as the root and show the scene
Scene cardDetailsScene = new Scene(cardDetailsVBox, 1200, 700);
primaryStage.setScene(cardDetailsScene);
            }

                });

              


                // Add the label, combo box, and confirm button to the paymentVBox
                paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
                	
                // Create an ImageView for the background image
                Image backgroundImagePB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/PB.png");

                BackgroundSize backgroundSizePB = new BackgroundSize(1.0, 1.0, true, true, false, false);
                BackgroundImage backgroundImageObjPB = new BackgroundImage(backgroundImagePB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizePB);
                Background backgroundPB = new Background(backgroundImageObjPB);
                paymentVBox.setBackground(backgroundPB);
                
                // Create a new scene with the paymentVBox as the root and show the scene
                Scene paymentScene = new Scene(paymentVBox, 1200, 700);
                primaryStage.setScene(paymentScene);
            });

            // Add the label, combo box, and confirm button to the rechargeVBox
            rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);

            // Create an ImageView for the background image
            Image backgroundImageRB = new Image("file:/Users/varunaggarwal/Desktop/SDM/igoimages/RB.png");

            BackgroundSize backgroundSizeRB = new BackgroundSize(1.0, 1.0, true, true, false, false);
            BackgroundImage backgroundImageObjRB = new BackgroundImage(backgroundImageRB, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, backgroundSizeRB);
            Background backgroundRB = new Background(backgroundImageObjRB);
            rechargeVBox.setBackground(backgroundRB);
            
            // Create a new scene with the rechargeVBox as the root and show the scene
            Scene rechargeScene = new Scene(rechargeVBox, 1200, 700);
            primaryStage.setScene(rechargeScene);
        });


    }



    });

     }



    public static void main(String[] args) {
        launch(args);
    }
}