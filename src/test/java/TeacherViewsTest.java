import com.cauandev.controller.teacher_views.TeacherCreateView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

public class TeacherViewsTest extends ApplicationTest {

    @Override
    public void start(Stage stage) {
        TeacherCreateView view = new TeacherCreateView();
        Scene scene = new Scene(view);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void teacherViewsTest() {
        clickOn("#nameTextField").write("Donatello Melhor Tartaruga");
        clickOn("#specificTextField").write("5550583");
        clickOn("#confirmButton");

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
