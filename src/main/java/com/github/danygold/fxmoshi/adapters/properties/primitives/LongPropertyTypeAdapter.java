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
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link LongProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final LongProperty weight;
 *
 *         Car(long weight) {
 *             this.weight = new SimpleLongProperty(weight);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car(12003655489l)} is serialized:
 * <pre>
 * {
 *   "weight": 12003655489
 * }
 * </pre>
 */
public class LongPropertyTypeAdapter extends PrimitivePropertyTypeAdapter<Long, LongProperty> {

    /**
     * Instance a new {@code LongPropertyTypeAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public LongPropertyTypeAdapter(JsonAdapter<Long> delegate) {
        super(delegate);
    }

    /**
     * Convert a given LongProperty {@code property} to primitive long value
     *
     * @param property property
     * @return long value
     */
    @Override
    protected @NotNull Long extractPrimitiveValue(@NotNull LongProperty property) {
        return property.get();
    }

    /**
     * Create a default property useful when input {@link LongProperty} is {@code null}
     *
     * @return default long property
     */
    @Override
    protected @NotNull LongProperty createDefaultProperty() {
        return new SimpleLongProperty();
    }

    /**
     * Convert a given long {@code deserializedValue} in a {@link LongProperty}
     *
     * @param deserializedValue value
     * @return a new long property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull LongProperty wrapPrimitiveValue(@NotNull Long deserializedValue) {
        return new SimpleLongProperty(deserializedValue);
    }
}
