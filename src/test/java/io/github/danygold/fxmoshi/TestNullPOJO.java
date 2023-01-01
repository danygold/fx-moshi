/*
 * Copyright 2023 danygold
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.danygold.fxmoshi;

import javafx.beans.property.*;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class TestNullPOJO {

    private BooleanProperty booleanProperty;
    private DoubleProperty doubleProperty;
    private FloatProperty floatProperty;
    private IntegerProperty integerProperty;
    private LongProperty longProperty;
    private ObjectProperty<LocalDate> objectProperty;
    private StringProperty stringProperty;

    public boolean isBooleanProperty() {
        return booleanProperty.get();
    }

    public BooleanProperty booleanPropertyProperty() {
        return booleanProperty;
    }

    public void setBooleanProperty(boolean booleanProperty) {
        this.booleanProperty.set(booleanProperty);
    }

    public double getDoubleProperty() {
        return doubleProperty.get();
    }

    public DoubleProperty doublePropertyProperty() {
        return doubleProperty;
    }

    public void setDoubleProperty(double doubleProperty) {
        this.doubleProperty.set(doubleProperty);
    }

    public float getFloatProperty() {
        return floatProperty.get();
    }

    public FloatProperty floatPropertyProperty() {
        return floatProperty;
    }

    public void setFloatProperty(float floatProperty) {
        this.floatProperty.set(floatProperty);
    }

    public int getIntegerProperty() {
        return integerProperty.get();
    }

    public IntegerProperty integerPropertyProperty() {
        return integerProperty;
    }

    public void setIntegerProperty(int integerProperty) {
        this.integerProperty.set(integerProperty);
    }

    public long getLongProperty() {
        return longProperty.get();
    }

    public LongProperty longPropertyProperty() {
        return longProperty;
    }

    public void setLongProperty(long longProperty) {
        this.longProperty.set(longProperty);
    }

    public LocalDate getObjectProperty() {
        return objectProperty.get();
    }

    public ObjectProperty<LocalDate> objectPropertyProperty() {
        return objectProperty;
    }

    public void setObjectProperty(LocalDate objectProperty) {
        this.objectProperty.set(objectProperty);
    }

    public String getStringProperty() {
        return stringProperty.get();
    }

    public StringProperty stringPropertyProperty() {
        return stringProperty;
    }

    public void setStringProperty(String stringProperty) {
        this.stringProperty.set(stringProperty);
    }
}
