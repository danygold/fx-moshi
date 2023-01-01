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

package com.github.danygold.fxmoshi.adapters.properties.primitives;

import com.squareup.moshi.JsonAdapter;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link IntegerProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final IntegerProperty seats;
 *
 *         Car(int seats) {
 *             this.seats = new SimpleIntegerProperty(seats);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(5)} is serialized:
 * <pre>
 * {
 *   "seats": 5
 * }
 * </pre>
 */
public class IntegerPropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Integer, IntegerProperty> {

    /**
     * Instance a new {@code IntegerPropertyTypeAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public IntegerPropertyTypeAdapter(JsonAdapter<Integer> delegate) {
        super(delegate);
    }

    /**
     * Convert a given IntegerProperty {@code property} to primitive int value
     *
     * @param property property
     * @return int value
     */
    @Override
    protected @NotNull Integer extractPrimitiveValue(@NotNull IntegerProperty property) {
        return property.get();
    }

    /**
     * Create a default property useful when input {@link IntegerProperty} is {@code null}
     *
     * @return default int property
     */
    @Override
    protected @NotNull IntegerProperty createDefaultProperty() {
        return new SimpleIntegerProperty();
    }

    /**
     * Convert a given int {@code deserializedValue} in a {@link IntegerProperty}
     *
     * @param deserializedValue value
     * @return a new int property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull IntegerProperty wrapPrimitiveValue(@NotNull Integer deserializedValue) {
        return new SimpleIntegerProperty(deserializedValue);
    }
}
