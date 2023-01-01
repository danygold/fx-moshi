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

package io.github.danygold.fxmoshi.adapters.properties.primitives;

import com.squareup.moshi.JsonAdapter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link DoubleProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final DoubleProperty width;
 *
 *         Car(double width) {
 *             this.width = new SimpleDoubleProperty(width);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(366.5d)} is serialized:
 * <pre>
 * {
 *   "width": 366.5
 * }
 * </pre>
 */
public class DoublePropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Double, DoubleProperty> {

    /**
     * Instance a new {@code DoublePropertyTypeAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public DoublePropertyTypeAdapter(JsonAdapter<Double> delegate) {
        super(delegate);
    }

    /**
     * Convert a given DoubleProperty {@code property} to primitive double value
     *
     * @param property property
     * @return double value
     */
    @Override
    protected @NotNull Double extractPrimitiveValue(@NotNull DoubleProperty property) {
        return property.get();
    }

    /**
     * Create a default property useful when input {@link DoubleProperty} is {@code null}
     *
     * @return default double property
     */
    @Override
    protected @NotNull DoubleProperty createDefaultProperty() {
        return new SimpleDoubleProperty();
    }

    /**
     * Convert a given double {@code deserializedValue} in a {@link DoubleProperty}
     *
     * @param deserializedValue value
     * @return a new double property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull DoubleProperty wrapPrimitiveValue(@NotNull Double deserializedValue) {
        return new SimpleDoubleProperty(deserializedValue);
    }
}