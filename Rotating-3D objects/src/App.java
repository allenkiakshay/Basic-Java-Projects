import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Camera;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.stage.Stage;


public class App extends Application{
    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Box box = new Box(100,20,50);

        SmartGroup group = new SmartGroup();
        group.getChildren().add(box);

        Camera camera = new PerspectiveCamera();
        Scene scene = new Scene(group, WIDTH, HEIGHT);
        scene.setFill(Color.WHITE);
        scene.setCamera(camera);

        group.translateXProperty().set(WIDTH/2);
        group.translateYProperty().set(HEIGHT/2);
        group.translateZProperty().set(-1200);

        Transform transform = new Rotate(65, new Point3D(0,1,0));
        group.getTransforms().add(transform);

        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()){
                case W:
                    group.translateZProperty().set(box.getTranslateZ() + 100);
                    break;
                case S:
                    group.translateZProperty().set(box.getTranslateZ() - 100);
                    break;
                case Q:
                    group.rotateByX(10);
                    break;
                case E:
                    group.rotateByX(-10);
                    break;
                case NUMPAD6:
                    group.rotateByY(10);
                    break;
                case NUMPAD4:
                    group.rotateByY(-10);
                    break;
            }
        });

        primaryStage.setTitle("3D Object");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    class SmartGroup extends Group{
        Rotate r;
        Transform t = new Rotate();

        void rotateByX(int ang){
            r = new Rotate(ang, Rotate.X_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }

        void rotateByY(int ang){
            r = new Rotate(ang, Rotate.Y_AXIS);
            t = t.createConcatenation(r);
            this.getTransforms().clear();
            this.getTransforms().addAll(t);
        }
    }
}
