package igoApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MetroCardApp extends Application {
	
	private String passType;
	//private double passAmount;
	
	@Override
	public void start(Stage primaryStage) {
		
		
		
		// Create the two buttons
		Button rechargeButton = new Button("Recharge OPUS Card");
		Button purchaseButton = new Button("Purchase Subway Ticket");
		
		// Create a VBox for the main window and add the buttons
		VBox mainVBox = new VBox(10);
		mainVBox.setAlignment(Pos.CENTER);
		mainVBox.setPadding(new Insets(20, 20, 20, 20));
		
		// Add a label and a combo box to select the language

		Label languageLabel = new Label("Choose Language:");
		languageLabel.setFont(Font.font("Helvetica", 25));
		
		ComboBox<String> languageCombo = new ComboBox<>();
		languageCombo.getItems().addAll("English", "French");
		languageCombo.setValue("English");
		
		mainVBox.getChildren().addAll(languageLabel, languageCombo, rechargeButton, purchaseButton);
		
		// Create a new scene with the mainVBox as the root and show the scene
		Scene mainScene = new Scene(mainVBox, 700, 600);

		BackgroundImage backgroundImage = new BackgroundImage(
		new Image("file:/Users/aryansaxena/Desktop/SDM/iGoCode/images/background.png"),
		BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
		BackgroundPosition.DEFAULT,
		new BackgroundSize(1.0, 1.0, true, true, false, false)
		);
		
		Background background = new Background(backgroundImage); 

		//Setting the background
		mainVBox.setBackground(background);

		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Metro GUI");
		primaryStage.show();
		
		// Set the action for each button
		rechargeButton.setOnAction(e -> {
			// Create a new VBox for the "Recharge Pass Type" window
			VBox rechargeVBox = new VBox(10);
			rechargeVBox.setAlignment(Pos.CENTER);
			rechargeVBox.setPadding(new Insets(20, 20, 20, 20));
			
			// Create a label and combo box with the pass type options
			Label passTypeLabel = new Label("Select Pass Type:");
			passTypeLabel.setFont(Font.font("Helvetica", 25));
			ComboBox<String> passTypeCombo = new ComboBox<>();
			passTypeCombo.getItems().addAll(
			"2 weeks - $ 35",
			"1 month - $ 56",
			"2 months - $ 98",
			"3 months - $ 135"
			);
			passTypeCombo.setValue("2 weeks - $ 35");
			
			// Create a button to confirm the pass type selection
			Button confirmPassTypeButton = new Button("Confirm");
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
				Label paymentLabel = new Label("Select Payment Method:");
				paymentLabel.setFont(Font.font("Helvetica", 25));
				ComboBox<String> paymentCombo = new ComboBox<>();
				paymentCombo.getItems().addAll(
				"Pay by Cash",
				"Pay by Debit/Credit Card"
				);
				paymentCombo.setValue("Pay by Cash");
				
				
				// Create a button to confirm the payment method selection
				Button confirmPaymentButton = new Button("Confirm");
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
						Label cashLabel = new Label("Enter Cash Amount:");
						cashLabel.setFont(Font.font("Helvetica", 25));
						TextField cashField = new TextField();
						
						// Create a button to confirm the cash amount
						Button confirmCashButton = new Button("Confirm");
						confirmCashButton.setOnAction(e4 -> {
							String cashAmount = cashField.getText();
							System.out.println("Cash Amount Entered: " + cashAmount);
							
							double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
							double cash = Double.parseDouble(cashAmount);
							
							if (cash >= passAmount) {
								double balance = cash - passAmount;
								String balanceMessage = String.format("Payment Successful! Please Collect your balance Amount: $%.2f", balance);
								Label balanceLabel = new Label(balanceMessage);
								balanceLabel.setFont(Font.font("Helvetica", 25));
								
								
								// Create a new VBox for the "Payment Success" window
								VBox successVBox = new VBox(10);
								successVBox.setAlignment(Pos.CENTER);
								successVBox.setPadding(new Insets(20, 20, 20, 20));
								successVBox.getChildren().add(balanceLabel);
								
								// Create an OK button to navigate back to the original scene
								Button okButton = new Button("OK");
								okButton.setOnAction(e5 -> {
									primaryStage.setScene(mainScene);
								});
								
								// Add the OK button to the successVBox
								successVBox.getChildren().add(okButton);
								
								// Create a new scene with the successVBox as the root and show the scene
								Scene successScene = new Scene(successVBox, 700, 600);
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
						
						// Create a new scene with the cashVBox as the root and show the scene
						Scene cashScene = new Scene(cashVBox, 700, 600);
						primaryStage.setScene(cashScene);
						
					} else if(paymentMethod.equals("Pay by Debit/Credit Card")) {
						// add functionality for "Pay by Debit/Credit Card option
						// Create a new VBox for the "Card Details" window
						VBox cardDetailsVBox = new VBox(10);
						cardDetailsVBox.setAlignment(Pos.CENTER);
						cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));
						
						// Create labels and text fields for card number and expiry date
						Label cardNumberLabel = new Label("Card Number:");
						cardNumberLabel.setFont(Font.font("Helvetica", 25));
						TextField cardNumberField = new TextField();
						
						Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
						expiryDateLabel.setFont(Font.font("Helvetica", 25));
						TextField expiryDateField = new TextField();
						
						
						Label cvvLabel = new Label("CVV");
						cvvLabel.setFont(Font.font("Helvetica", 25));
						TextField cvvField = new TextField();
						
						// Create a button to confirm the card details
						Button confirmCardDetailsButton = new Button("Confirm");
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
								String contentText = "Payment by Debit/Credit card for " + this.passType + " is successful. Thank you for using igo TVM.\n\n     Please select your Ticket prefernce :";
								Label contentLabel = new Label(contentText);
								
								// Create radio buttons for ticket receipt preference
								RadioButton emailRadioButton = new RadioButton("Email");
								RadioButton paperRadioButton = new RadioButton("Paper-based ticket");
								ToggleGroup receiptToggleGroup = new ToggleGroup();
								emailRadioButton.setToggleGroup(receiptToggleGroup);
								paperRadioButton.setToggleGroup(receiptToggleGroup);
								
								// Create a text field for entering email address
								TextField emailTextField = new TextField();
								emailTextField.setPromptText("Enter email address");
								
								
								// Create a button to confirm receipt preference
								Button confirmReceiptButton = new Button("Confirm");
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
								
								// Set the content of the alert box to the content VBox
								alert.getDialogPane().setContent(contentVBox);
								
								// Increase the size of the alert box
								alert.getDialogPane().setPrefSize(600, 400);
								
								// Show the alert box
								alert.showAndWait();
								
								// Set the scene back to the main scene
								primaryStage.setScene(mainScene);
								
								
							}
						});
						
						// Add the labels, text fields, and confirm button to the cardDetailsVBox
						cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);
						
						// Create a new scene with the cardDetailsVBox as the root and show the scene
						Scene cardDetailsScene = new Scene(cardDetailsVBox, 700, 600);
						primaryStage.setScene(cardDetailsScene);
					}
				});
				
				
				
				
				// Add the label, combo box, and confirm button to the paymentVBox
				paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
				
				// Create a new scene with the paymentVBox as the root and show the scene
				Scene paymentScene = new Scene(paymentVBox, 700, 600);
				primaryStage.setScene(paymentScene);
			});
			
			// Add the label, combo box, and confirm button to the rechargeVBox
			rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);
			
			// Create a new scene with the rechargeVBox as the root and show the scene
			Scene rechargeScene = new Scene(rechargeVBox, 700, 600);
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
			Label passTypeLabel = new Label("Select Ticket Type:");
			passTypeLabel.setFont(Font.font("Helvetica", 25));
			ComboBox<String> passTypeCombo = new ComboBox<>();
			passTypeCombo.getItems().addAll(
			"1 trip - $ 3.5",
			"2 trips - $ 6",
			"1 Day - $ 11",
			"1 Week - $ 25",
			"Unlimited Weekend - $ 17"
			);
			passTypeCombo.setValue("1 trip - $ 3.5");
			
			// Create a button to confirm the pass type selection
			Button confirmPassTypeButton = new Button("Confirm");
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
				Label paymentLabel = new Label("Select Payment Method:");
				paymentLabel.setFont(Font.font("Helvetica", 25));
				ComboBox<String> paymentCombo = new ComboBox<>();
				paymentCombo.getItems().addAll(
				"Pay by Cash",
				"Pay by Debit/Credit Card"
				);
				paymentCombo.setValue("Pay by Cash");
				
				
				// Create a button to confirm the payment method selection
				Button confirmPaymentButton = new Button("Confirm");
				confirmPaymentButton.setOnAction(e3 -> {
					String paymentMethod = paymentCombo.getValue();
					System.out.println("Pass Type: " + this.passType + ", Payment Method: " + paymentMethod);
					
					if (paymentMethod.equals("Pay by Cash")) {
						// Some functionality for Pay by Cash
						// Create a new VBox for the "Cash Payment" window
						VBox cashVBox = new VBox(10);
						cashVBox.setAlignment(Pos.CENTER);
						cashVBox.setPadding(new Insets(20, 20, 20, 20));
						
						// Create a label and text field for the cash amount input
						Label cashLabel = new Label("Enter Cash Amount:");
						cashLabel.setFont(Font.font("Helvetica", 25));
						TextField cashField = new TextField();
						
						
						// Create a button to confirm the cash amount
						Button confirmCashButton = new Button("Confirm");
						confirmCashButton.setOnAction(e4 -> {
							String cashAmount = cashField.getText();
							System.out.println("Cash Amount Entered: " + cashAmount);
							
							double passAmount = Double.parseDouble(this.passType.split(" ")[4]);
							double cash = Double.parseDouble(cashAmount);
							
							if (cash >= passAmount) {
								double balance = cash - passAmount;
								String balanceMessage = String.format("Payment Successful! Please Collect your balance Amount: $%.2f", balance);
								Label balanceLabel = new Label(balanceMessage);
								balanceLabel.setFont(Font.font("Helvetica", 25));
								
								// Create a new VBox for the "Payment Success" window
								VBox successVBox = new VBox(10);
								successVBox.setAlignment(Pos.CENTER);
								successVBox.setPadding(new Insets(20, 20, 20, 20));
								successVBox.getChildren().add(balanceLabel);
								
								// Create an OK button to navigate back to the original scene
								Button okButton = new Button("OK");
								okButton.setOnAction(e5 -> {
									primaryStage.setScene(mainScene);
								});
								
								// Add the OK button to the successVBox
								successVBox.getChildren().add(okButton);
								
								// Create a new scene with the successVBox as the root and show the scene
								Scene successScene = new Scene(successVBox, 700, 600);
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
						
						// Create a new scene with the cashVBox as the root and show the scene
						Scene cashScene = new Scene(cashVBox, 700, 600);
						primaryStage.setScene(cashScene);
					} else if(paymentMethod.equals("Pay by Debit/Credit Card")) {
						// add functionality for "Pay by Debit/Credit Card option
						// Create a new VBox for the "Card Details" window
						VBox cardDetailsVBox = new VBox(10);
						cardDetailsVBox.setAlignment(Pos.CENTER);
						cardDetailsVBox.setPadding(new Insets(20, 20, 20, 20));
						
						// Create labels and text fields for card number and expiry date
						Label cardNumberLabel = new Label("Card Number:");
						cardNumberLabel.setFont(Font.font("Helvetica", 25));
						TextField cardNumberField = new TextField();
						
						Label expiryDateLabel = new Label("Expiry Date (MM/YY):");
						expiryDateLabel.setFont(Font.font("Helvetica", 25));
						TextField expiryDateField = new TextField();
						
						
						Label cvvLabel = new Label("CVV");
						cvvLabel.setFont(Font.font("Helvetica", 25));
						TextField cvvField = new TextField();
						
						// Create a button to confirm the card details
						Button confirmCardDetailsButton = new Button("Confirm");
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
								String contentText = "Payment by Debit/Credit card for " + this.passType + " is successful. Thank you for using igo TVM.\n\n     Please select your Ticket prefernce :";
								Label contentLabel = new Label(contentText);
								
								// Create radio buttons for ticket receipt preference
								RadioButton emailRadioButton = new RadioButton("Email");
								RadioButton paperRadioButton = new RadioButton("Paper-based ticket");
								ToggleGroup receiptToggleGroup = new ToggleGroup();
								emailRadioButton.setToggleGroup(receiptToggleGroup);
								paperRadioButton.setToggleGroup(receiptToggleGroup);
								
								// Create a text field for entering email address
								TextField emailTextField = new TextField();
								emailTextField.setPromptText("Enter email address");
								
								
								// Create a button to confirm receipt preference
								Button confirmReceiptButton = new Button("Confirm");
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
								
								// Set the content of the alert box to the content VBox
								alert.getDialogPane().setContent(contentVBox);
								
								// Increase the size of the alert box
								alert.getDialogPane().setPrefSize(600, 400);
								
								// Show the alert box
								alert.showAndWait();
								
								// Set the scene back to the main scene
								primaryStage.setScene(mainScene);
								
								
							}
						});
						
						// Add the labels, text fields, and confirm button to the cardDetailsVBox
						cardDetailsVBox.getChildren().addAll(cardNumberLabel, cardNumberField, expiryDateLabel, expiryDateField, cvvLabel,cvvField, confirmCardDetailsButton);
						
						// Create a new scene with the cardDetailsVBox as the root and show the scene
						Scene cardDetailsScene = new Scene(cardDetailsVBox, 700, 600);
						primaryStage.setScene(cardDetailsScene);
					}
					
				});
				
				
				
				
				// Add the label, combo box, and confirm button to the paymentVBox
				paymentVBox.getChildren().addAll(paymentLabel, paymentCombo, confirmPaymentButton);
				
				// Create a new scene with the paymentVBox as the root and show the scene
				Scene paymentScene = new Scene(paymentVBox, 700, 600);
				primaryStage.setScene(paymentScene);
			});
			
			// Add the label, combo box, and confirm button to the rechargeVBox
			rechargeVBox.getChildren().addAll(passTypeLabel, passTypeCombo, confirmPassTypeButton);
			
			// Create a new scene with the rechargeVBox as the root and show the scene
			Scene rechargeScene = new Scene(rechargeVBox, 700, 600);
			primaryStage.setScene(rechargeScene);
		});
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}