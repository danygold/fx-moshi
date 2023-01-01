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
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link BooleanProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final BooleanProperty automaticGear;
 *
 *         Car(boolean automaticGear) {
 *             this.automaticGear = new SimpleBooleanProperty(automaticGear);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(true)} is serialized:
 * <pre>
 * {
 *   "automaticGear": true
 * }
 * </pre>
 */
public class BooleanPropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Boolean, BooleanProperty> {

    /**
     * Instance a new {@code BooleanPropertyTypeAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public BooleanPropertyTypeAdapter(JsonAdapter<Boolean> delegate) {
        super(delegate);
    }

    /**
     * Convert a given BooleanProperty {@code property} to primitive boolean value
     *
     * @param property property
     * @return boolean value
     */
    @Override
    protected @NotNull Boolean extractPrimitiveValue(@NotNull BooleanProperty property) {
        return property.get();
    }

    /**
     * Create a default property useful when input {@link BooleanProperty} is {@code null}
     *
     * @return default boolean property
     */
    @Override
    protected @NotNull BooleanProperty createDefaultProperty() {
        return new SimpleBooleanProperty();
    }

    /**
     * Convert a given boolean {@code deserializedValue} in a {@link BooleanProperty}
     *
     * @param deserializedValue value
     * @return a new boolean property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull BooleanProperty wrapPrimitiveValue(@NotNull Boolean deserializedValue) {
        return new SimpleBooleanProperty(deserializedValue);
    }
}