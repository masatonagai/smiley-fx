/*
 * Copyright 2012 Nagai Masato
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SceneBuilder;
import javafx.stage.Stage;
import smileyfx.SmileyFX;


public class JavaFXDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Node smiley = SmileyFX.smiley(40);
        Scene canvas = SceneBuilder.create()
            .root(new Group(smiley))
            .width(160)
            .height(160)
            .build(); 
        
        // center align
        smiley.layoutXProperty().bind(
            canvas.widthProperty()
            .subtract(smiley.getLayoutBounds().getWidth())
            .divide(2));
        smiley.layoutYProperty().bind(
            canvas.heightProperty()
            .subtract(smiley.getLayoutBounds().getHeight())
            .divide(2));
        
        // scale by window resize
        smiley.scaleXProperty().bind(
            canvas.widthProperty()
            .divide(canvas.getWidth()));
        smiley.scaleYProperty().bind(
            canvas.heightProperty()
            .divide(canvas.getHeight()));
        
        stage.setScene(canvas);
        stage.setTitle("Smiley FX");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
