import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Store store = new Store();
    private TextArea output = new TextArea();

    @Override
    public void start(Stage stage) {
        TextField brand = new TextField();
        brand.setPromptText("Brand");

        TextField model = new TextField();
        model.setPromptText("Model");

        TextField uuidField = new TextField();
        uuidField.setPromptText("UUID");

        Button add = new Button("Add");
        Button show = new Button("Show");
        Button find = new Button("Find");

        add.setOnAction(e -> {
            try {
                Phone p = new SmartPhone(
                        brand.getText(),
                        model.getText(),
                        1000,
                        2024,
                        128,
                        "Android",
                        true
                );

                store.addNewPhone(p, 1);
                update();
            } catch (Exception ex) {
                output.setText("Error: " + ex.getMessage());
            }
        });

        show.setOnAction(e -> update());

        find.setOnAction(e -> {
            try {
                java.util.UUID id = java.util.UUID.fromString(uuidField.getText());

                for (int i = 0; i < store.size(); i++) {
                    Phone p = store.get(i);

                    if (p.getUuid().equals(id)) {
                        output.setText(p.toString());
                        return;
                    }
                }

                output.setText("Not found");

            } catch (Exception ex) {
                output.setText("Invalid UUID");
            }
        });

        VBox root = new VBox(brand, model, add, show, uuidField, find, output);

        stage.setScene(new Scene(root, 400, 500));
        stage.setTitle("Store GUI");
        stage.show();
    }

    private void update() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < store.size(); i++) {
            Phone p = store.get(i);
            sb.append(p.getModel())
                    .append(" | ")
                    .append(p.getUuid())
                    .append("\n");
        }

        output.setText(sb.toString());
    }

    public static void main(String[] args) {
        launch();
    }
}