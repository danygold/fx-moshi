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

package io.github.danygold.fxmoshi.adapters.properties;

import com.squareup.moshi.JsonAdapter;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link Property}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final Property<LocalDate> creation;
 *
 *         Car(LocalDate localDate) {
 *             this.creation = new SimpleObjectProperty<>(automaticGear);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(LocalDate.of(2022, 1, 1))} is serialized:
 * <pre>
 * {
 *   "creation": "2022-01-01"
 * }
 * </pre>
 *
 * @param <T> the type of the wrapped Object
 */
public class ObjectPropertyTypeAdapter<T> extends PropertyTypeAdapter<T, Property<T>> {

    /**
     * Instance a new {@code ObjectPropertyTypeAdapter}
     *
     * @param delegate adapter to use for this type of the property
     */
    public ObjectPropertyTypeAdapter(JsonAdapter<T> delegate) {
        super(delegate);
    }

    /**
     * Create a given {@code deserializedValue} in a {@link Property}
     *
     * @param deserializedValue value
     * @return a new property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull Property<T> createProperty(T deserializedValue) {
        return new SimpleObjectProperty<>(deserializedValue);
    }
}
