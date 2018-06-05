
import java.math.BigInteger;
import java.nio.file.WatchEvent.Kind;
import java.util.Locale;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    GridPane innerlayout;
    BorderPane layout;

    TableView<Member> table;
    TextField ageInput, phoneNumber, timeIn, timeOut, childFirstName,
            childLastName, P1FirstName, P1LastName, addressField;

    Button addButton, deleteButton, undoButton, redoButton, editButon,
            clockInButton, clockOutButton;

    DatePicker checkInDatePicker;
    final String patter = "yyyy-MM-dd";
    
    
    
   
    

    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("DayCare");

        // File menu
        Menu filemenu = new Menu("File");

        // Menu items
        MenuItem newfile = new MenuItem("New");
        newfile.setOnAction(e -> System.out.println("Create a new file..."));
        filemenu.getItems().add(newfile);

        filemenu.getItems().add(new MenuItem("Open..."));
        filemenu.getItems().add(new MenuItem("Save..."));
        filemenu.getItems().add(new SeparatorMenuItem());
        filemenu.getItems().add(new MenuItem("Settings..."));
        filemenu.getItems().add(new SeparatorMenuItem());
        filemenu.getItems().add(new MenuItem("Exit"));

        // fileMenu functionality
        filemenu.getItems().get(0)
                .setOnAction(e -> System.out.println("File-New"));
        filemenu.getItems().get(1).setOnAction(e -> openFile());
        filemenu.getItems().get(2).setOnAction(e -> saveFile());
        filemenu.getItems().get(4)
                .setOnAction(e -> System.out.println("File-Settings"));
        filemenu.getItems().get(6).setOnAction(e -> closeProgram());

        // Edit menu
        Menu editMenu = new Menu("_Edit");
        editMenu.getItems().add(new MenuItem("Cut"));
        editMenu.getItems().add(new MenuItem("Copy"));

        MenuItem paste = new MenuItem("Paste");
        paste.setOnAction(e -> System.out.println("paste crap."));
        paste.setDisable(true);
        editMenu.getItems().add(paste);

        // check menu items
        Menu help = new Menu("Help");
        CheckMenuItem showLines = new CheckMenuItem("Show line numbers");
        showLines.setOnAction(e -> {
            if (showLines.isSelected()) {
                System.out.println("program will now display line numbers");

            }
            else {
                System.out.println("Hiding line numbers");
            }

        });
        // selecting something by default.
        CheckMenuItem autoSave = new CheckMenuItem("Enable AutoSave");
        autoSave.setSelected(true);

        help.getItems().addAll(showLines, autoSave);

        // Difficulty RadioMenuItems
        Menu difficultyMenu = new Menu("Difficulty");
        ToggleGroup difficultyToggle = new ToggleGroup();

        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");

        easy.setToggleGroup(difficultyToggle);
        medium.setToggleGroup(difficultyToggle);
        hard.setToggleGroup(difficultyToggle);

        difficultyMenu.getItems().addAll(easy, medium, hard);

        // Main menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(filemenu, editMenu, help, difficultyMenu);

        TableColumn<Member, String> childFNameCol = new TableColumn<Member, String>(
                "Child First Name");
        childFNameCol.setMinWidth(150);
        childFNameCol.setCellValueFactory(
                new PropertyValueFactory<>("childFirstName"));

        TableColumn<Member, String> childLNameCol = new TableColumn<Member, String>(
                "Child Last Name");
        childLNameCol.setMinWidth(150);
        childLNameCol.setCellValueFactory(
                new PropertyValueFactory<>("childLastName"));

        TableColumn<Member, Integer> AgeCol = new TableColumn<Member, Integer>(
                "Age");
        AgeCol.setMinWidth(75);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));

        TableColumn<Member, Integer> ContactCol = new TableColumn<Member, Integer>(
                "Contact");
        ContactCol.setMinWidth(250);
        ContactCol.setCellValueFactory(
                new PropertyValueFactory<>("phoneNumber"));

        TableColumn<Member, String> P1FirstNameCol = new TableColumn<Member, String>(
                "Parent First Name");
        P1FirstNameCol.setMinWidth(200);
        P1FirstNameCol.setCellValueFactory(
                new PropertyValueFactory<>("P1FirstName"));

        TableColumn<Member, String> P1LastNameCol = new TableColumn<Member, String>(
                "Parent Last Name");
        P1LastNameCol.setMinWidth(200);
        P1LastNameCol
                .setCellValueFactory(new PropertyValueFactory<>("P1LastName"));

        TableColumn<Member, String> addressCol = new TableColumn<Member, String>(
                "Address");
        addressCol.setMinWidth(270);
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));

        HBox directInput = new HBox();
        // create Buttons
        configureButtons();
        // Fill HBox
        fillHBox();
        directInput.setPadding(new Insets(10));
        directInput.setSpacing(10);
        directInput.getChildren().addAll(clockInButton, childFirstName,
                childLastName, ageInput, phoneNumber, P1FirstName, P1LastName,
                addressField, clockOutButton);

        VBox options = new VBox();

        table = new TableView<Member>();
        table.getColumns().addAll(childFNameCol, childLNameCol, AgeCol,
                ContactCol, P1FirstNameCol, P1LastNameCol, addressCol);

        addButton.setOnAction(e -> addFunctionality());
        deleteButton.setOnAction(e -> deleteFunctionality());

        innerlayout = new GridPane();
        GridPane.setConstraints(addButton, 0, 0);
        GridPane.setConstraints(deleteButton, 0, 1);
        GridPane.setConstraints(undoButton, 1, 0);
        GridPane.setConstraints(redoButton, 1, 1);
        innerlayout.setPadding(new Insets(10));
        innerlayout.setVgap(8);
        innerlayout.setHgap(10);
        innerlayout.getChildren().addAll(addButton, deleteButton, undoButton,
                redoButton);

        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setBottom(directInput);
        layout.setCenter(table);
        layout.setRight(innerlayout);
        window.setOnCloseRequest(e -> closeProgram());
        Scene scene = new Scene(layout);
        scene.getStylesheets().add("style.css");
        window.setScene(scene);
        window.show();

    }

    private void deleteFunctionality() {
        boolean ans = ExitAlertBox.display("Delete?",
                "Are you sure you want to delete this selected row?");
        if (ans) {
            ObservableList<Member> memeberselected, allMembers;
            allMembers = table.getItems();
            memeberselected = table.getSelectionModel().getSelectedItems();
            memeberselected.forEach(allMembers::remove);
        }

    }

    private void addFunctionality() {
        if (ageInput.getText().equals("") || addressField.getText().equals("")
                || childFirstName.getText().equals("")
                || childLastName.getText().equals("")
                || phoneNumber.getText().equals("")
                || P1FirstName.getText().equals("")
                || P1LastName.getText().equals("")) {

            ExitAlertBox.inputAlert("Alert",
                    "Please enter the missing information.");
        }
        else if (ageInput.getText().length() > 2) {
            ExitAlertBox.inputAlert("Alert", "Please enter the correct age.");

        }
        else if (phoneNumber.getText().length() != 10) {
            System.out.println("please enter correct number");
            ExitAlertBox.inputAlert("Alert",
                    "The phone number you entered is not the correct length.");
        }
        else {

            Member member = new Member();
            member.setAge(Integer.parseInt(ageInput.getText()));
            member.setAddress(addressField.getText());
            member.setChildFirstName(childFirstName.getText());
            member.setChildLastName(childLastName.getText());
            member.setPhoneNumber(Long.parseLong(phoneNumber.getText()));
            member.setP1FirstName(P1FirstName.getText());
            member.setP1LastName(P1LastName.getText());
            table.getItems().add(member);
            clearInputs();
        }
    }

    private void clearInputs() {
        ageInput.clear();
        addressField.clear();
        childFirstName.clear();
        childLastName.clear();
        phoneNumber.clear();
        P1FirstName.clear();
        P1LastName.clear();
    }

    private void closeProgram() {

        Boolean answer = ExitAlertBox.display("Exit",
                "Sure you want to exit?");
        if (answer) {
            window.close();
        }

    }

    private void saveFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.showSaveDialog(window);
    }

    private void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.showOpenDialog(window);
    }

    private void fillHBox() {
        ageInput = new TextField();
        ageInput.setPromptText("Age");
        ageInput.setMinWidth(10);
        ageInput.setPadding(new Insets(10));

        phoneNumber = new TextField();
        phoneNumber.setPromptText("Contact");
        phoneNumber.setMinWidth(75);
        phoneNumber.setPadding(new Insets(10));

        timeIn = new TextField();
        timeIn.setPromptText("Clock In");
        timeIn.setMinWidth(75);
        timeIn.setPadding(new Insets(10));

        timeOut = new TextField();
        timeOut.setPromptText("Clock Out");
        timeOut.setMinWidth(75);
        timeOut.setPadding(new Insets(10));

        childFirstName = new TextField();
        childFirstName.setPromptText("Child First Name");
        childFirstName.setMinWidth(75);
        childFirstName.setPadding(new Insets(10));

        childLastName = new TextField();
        childLastName.setPromptText("Child Last Name");
        childLastName.setMinWidth(75);
        childLastName.setPadding(new Insets(10));

        P1FirstName = new TextField();
        P1FirstName.setPromptText("Parent First Name");
        P1FirstName.setMinWidth(75);
        P1FirstName.setPadding(new Insets(10));

        P1LastName = new TextField();
        P1LastName.setPromptText("Parent Last Name");
        P1LastName.setMinWidth(75);
        P1LastName.setPadding(new Insets(10));

        addressField = new TextField();
        addressField.setPromptText("Address");
        addressField.setMinWidth(95);
        addressField.setPadding(new Insets(10));

    }

    private void configureButtons() {
        deleteButton = new Button("Delete");
        addButton = new Button("Add");
        undoButton = new Button("Undo");
        redoButton = new Button("Redo");
        clockInButton = new Button("Clock In");
        clockOutButton = new Button("Clock Out");

        undoButton.setPadding(new Insets(10));
        redoButton.setPadding(new Insets(10, 12, 10, 10));
        clockInButton.setPadding(new Insets(10));
        clockOutButton.setPadding(new Insets(10));
        addButton.setPadding(new Insets(10, 22, 10, 10));
        deleteButton.setPadding(new Insets(10));

    }
}
