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
import static groovyx.javafx.GroovyFX.start
import static smileyfx.SmileyFX.smiley

start {
    stage(title: "Smiley FX", visible: true) {
        scene(id: "canvas", width: 160, height: 160) {
            node(smiley(40)).with {
                // center align
                layoutXProperty().bind((canvas.width() - layoutBounds.width)/2)
                layoutYProperty().bind((canvas.height() - layoutBounds.height)/2)
                // scale by window resize
                scaleXProperty().bind(canvas.width()/canvas.width)
                scaleYProperty().bind(canvas.height()/canvas.height)
            }
        }
    }
}