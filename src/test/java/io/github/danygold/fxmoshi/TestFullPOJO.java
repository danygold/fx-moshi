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
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;

import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("unused")
public class TestFullPOJO {

    // Primitives Property
    private final BooleanProperty booleanProperty;
    private final DoubleProperty doubleProperty;
    private final FloatProperty floatProperty;
    private final IntegerProperty integerProperty;
    private final LongProperty longProperty;

    // Property
    private final ListProperty<String> listProperty;
    private final MapProperty<String, String> mapProperty;
    private final ObjectProperty<LocalDate> objectProperty;
    private final SetProperty<String> setProperty;
    private final StringProperty stringProperty;

    public TestFullPOJO() {
        this.booleanProperty = new SimpleBooleanProperty();
        this.doubleProperty = new SimpleDoubleProperty();
        this.floatProperty = new SimpleFloatProperty();
        this.integerProperty = new SimpleIntegerProperty();
        this.longProperty = new SimpleLongProperty();

        this.listProperty = new SimpleListProperty<>();
        this.mapProperty = new SimpleMapProperty<>();
        this.objectProperty = new SimpleObjectProperty<>();
        this.setProperty = new SimpleSetProperty<>();
        this.stringProperty = new SimpleStringProperty();
    }

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

    public ObservableList<String> getListProperty() {
        return listProperty.get();
    }

    public ListProperty<String> listPropertyProperty() {
        return listProperty;
    }

    public void setListProperty(ObservableList<String> listProperty) {
        this.listProperty.set(listProperty);
    }

    public ObservableMap<String, String> getMapProperty() {
        return mapProperty.get();
    }

    public MapProperty<String, String> mapPropertyProperty() {
        return mapProperty;
    }

    public void setMapProperty(ObservableMap<String, String> mapProperty) {
        this.mapProperty.set(mapProperty);
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

    public ObservableSet<String> getSetProperty() {
        return setProperty.get();
    }

    public SetProperty<String> setPropertyProperty() {
        return setProperty;
    }

    public void setSetProperty(ObservableSet<String> setProperty) {
        this.setProperty.set(setProperty);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestFullPOJO testFullPOJO = (TestFullPOJO) o;
        return Objects.equals(booleanProperty.get(), testFullPOJO.booleanProperty.get())
                && Objects.equals(doubleProperty.get(), testFullPOJO.doubleProperty.get())
                && Objects.equals(floatProperty.get(), testFullPOJO.floatProperty.get())
                && Objects.equals(integerProperty.get(), testFullPOJO.integerProperty.get())
                && Objects.equals(longProperty.get(), testFullPOJO.longProperty.get())
                && Objects.equals(listProperty.get(), testFullPOJO.listProperty.get())
                && Objects.equals(mapProperty.get(), testFullPOJO.mapProperty.get())
                && Objects.equals(objectProperty.get(), testFullPOJO.objectProperty.get())
                && Objects.equals(setProperty.get(), testFullPOJO.setProperty.get())
                && Objects.equals(stringProperty.get(), testFullPOJO.stringProperty.get());
    }

    @Override
    public int hashCode() {
        return Objects.hash(booleanProperty.get(),
                doubleProperty.get(),
                floatProperty.get(),
                integerProperty.get(),
                longProperty.get(),
                listProperty.get(),
                mapProperty.get(),
                objectProperty.get(),
                setProperty.get(),
                stringProperty.get());
    }
}
