

import com.sun.media.jfxmedia.events.NewFrameEvent;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExitAlertBox {

    static boolean answer;
    
    public static void inputAlert(String title, String Message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        
        Label label = new Label();
        label.setText(Message);
        label.setPadding(new Insets(10));
        
        
        Button ok = new Button("OK");
        ok.setPadding(new Insets(10));
        
        ok.setOnAction(e -> window.close() );
        
        VBox layout = new VBox();
        layout.getChildren().addAll(label,ok);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(layout,95,95);
        window.setScene(scene);
        window.show();
        
        
    }
    
    public static boolean display(String title, String Message){
        Stage window = new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        
        Label label = new Label();
        label.setText(Message);
        Button yes = new Button("Yes");
        Button no = new Button("No");
        
        yes.setOnAction(e -> {
            answer = true;
            window.close();
                    });
        no.setOnAction(e -> {
            answer = false;
            window.close();
        });
        
        GridPane layout = new GridPane();
        GridPane.setConstraints(label, 1, 0);
        GridPane.setConstraints(yes, 0, 1);
        GridPane.setConstraints(no, 2, 1);
        layout.setVgap(10);
        layout.setHgap(10);
        yes.setPadding(new Insets(10));
        no.setPadding(new Insets(10));
        label.setPadding(new Insets(10));
        
        
        layout.getChildren().addAll(label ,yes, no);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;

    }
   
}


