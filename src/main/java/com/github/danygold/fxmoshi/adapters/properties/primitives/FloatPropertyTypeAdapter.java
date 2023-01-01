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
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link FloatProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final FloatProperty width;
 *
 *         Car(float width) {
 *             this.width = new SimpleFloatProperty(width);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(366.5f)} is serialized:
 * <pre>
 * {
 *   "width": 366.5
 * }
 * </pre>
 */
public class FloatPropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Float, FloatProperty> {

    /**
     * Instance a new {@code FloatPropertyTypeAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public FloatPropertyTypeAdapter(JsonAdapter<Float> delegate) {
        super(delegate);
    }

    /**
     * Convert a given FloatProperty {@code property} to primitive float value
     *
     * @param property property
     * @return float value
     */
    @Override
    protected @NotNull Float extractPrimitiveValue(FloatProperty property) {
        return property.get();
    }

    /**
     * Create a default property useful when input {@link FloatProperty} is {@code null}
     *
     * @return default float property
     */
    @Override
    protected @NotNull FloatProperty createDefaultProperty() {
        return new SimpleFloatProperty();
    }

    /**
     * Convert a given float {@code deserializedValue} in a {@link FloatProperty}
     *
     * @param deserializedValue value
     * @return a new float property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull FloatProperty wrapPrimitiveValue(@NotNull Float deserializedValue) {
        return new SimpleFloatProperty(deserializedValue);
    }
}
