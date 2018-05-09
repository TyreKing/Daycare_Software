import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
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
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;
    BorderPane layout;
    
    TableView<Member> table;
    TextField ageInput, phoneNumber, timeIn, timeOut,childFirstName, childLastName,P1FirstName,
    P2FirstName,P1LastName,P2LastName;

    public static void main(String[] args) {
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

        
        
        
        
        
        
        
        
        
        
        
        
        
        TableColumn<Member, String> childFNameCol = new TableColumn<Member, String>("Child First Name");
        childFNameCol.setMinWidth(150);
        childFNameCol.setCellValueFactory(new PropertyValueFactory<>("childFirstName"));
        
        TableColumn<Member, String> childLNameCol = new TableColumn<Member, String>("Child Last Name");
        childLNameCol.setMinWidth(150);
        childLNameCol.setCellValueFactory(new PropertyValueFactory<>("childLastName"));
        
        TableColumn<Member, Integer> AgeCol = new TableColumn<Member, Integer>("Age");
        AgeCol.setMinWidth(75);
        AgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        
        TableColumn<Member, Integer> ContactCol = new TableColumn<Member, Integer>("Contact");
        ContactCol.setMinWidth(250);
        ContactCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        
        TableColumn<Member, String> P1FirstNameCol = new TableColumn<Member, String>("Parent First Name");
        P1FirstNameCol.setMinWidth(200);
        P1FirstNameCol.setCellValueFactory(new PropertyValueFactory<>("P1FirstName"));
        
        TableColumn<Member, String> P1LastNameCol = new TableColumn<Member, String>("Parent Last Name");
        P1LastNameCol.setMinWidth(200);
        P1LastNameCol.setCellValueFactory(new PropertyValueFactory<>("P1LastName"));

      
      
        table = new TableView<Member>();
        table.getColumns().addAll(childFNameCol,childLNameCol,AgeCol,ContactCol,P1FirstNameCol,P1LastNameCol);
        
        
        layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(table);

        Scene scene = new Scene(layout, 830, 600);
        window.setScene(scene);
        window.show();

    }

}
