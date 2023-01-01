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

import java.util.Objects;

@SuppressWarnings("unused")
public class TestSpecializedPOJO {

    private final SimpleListProperty<String> listProperty;
    private final SimpleSetProperty<String> setProperty;
    private final SimpleMapProperty<String, String> mapProperty;
    private final SimpleObjectProperty<String> objectProperty;
    private final Property<String> property;

    public TestSpecializedPOJO() {
        this.listProperty = new SimpleListProperty<>();
        this.setProperty = new SimpleSetProperty<>();
        this.mapProperty = new SimpleMapProperty<>();
        this.objectProperty = new SimpleObjectProperty<>();
        this.property = new SimpleObjectProperty<>();
    }

    public ObservableList<String> getListProperty() {
        return listProperty.get();
    }

    public SimpleListProperty<String> listPropertyProperty() {
        return listProperty;
    }

    public void setListProperty(ObservableList<String> listProperty) {
        this.listProperty.set(listProperty);
    }

    public ObservableSet<String> getSetProperty() {
        return setProperty.get();
    }

    public SimpleSetProperty<String> setPropertyProperty() {
        return setProperty;
    }

    public void setSetProperty(ObservableSet<String> setProperty) {
        this.setProperty.set(setProperty);
    }

    public ObservableMap<String, String> getMapProperty() {
        return mapProperty.get();
    }

    public SimpleMapProperty<String, String> mapPropertyProperty() {
        return mapProperty;
    }

    public void setMapProperty(ObservableMap<String, String> mapProperty) {
        this.mapProperty.set(mapProperty);
    }

    public String getObjectProperty() {
        return objectProperty.get();
    }

    public SimpleObjectProperty<String> objectPropertyProperty() {
        return objectProperty;
    }

    public void setObjectProperty(String objectProperty) {
        this.objectProperty.set(objectProperty);
    }

    public String getProperty() {
        return property.getValue();
    }

    public Property<String> propertyProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property.setValue(property);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestSpecializedPOJO that = (TestSpecializedPOJO) o;
        return Objects.equals(listProperty.get(), that.listProperty.get())
                && Objects.equals(setProperty.get(), that.setProperty.get())
                && Objects.equals(mapProperty.get(), that.mapProperty.get())
                && Objects.equals(objectProperty.get(), that.objectProperty.get())
                && Objects.equals(property.getValue(), that.property.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(listProperty.get(),
                setProperty.get(),
                mapProperty.get(),
                objectProperty.get(),
                property.getValue());
    }
}
