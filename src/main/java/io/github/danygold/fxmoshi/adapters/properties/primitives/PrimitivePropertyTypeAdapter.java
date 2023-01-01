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
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import javafx.beans.property.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Abstract JsonAdapter useful for JavaFX primitives {@link Property}.
 *
 * @param <I> the primitives type of the property
 * @param <P> the real property that this adapter can serialize/deserialize
 */
public abstract class PrimitivePropertyTypeAdapter<I, P extends Property<?>> extends JsonAdapter<P> {

    private final JsonAdapter<I> delegate;

    /**
     * Instance a new {@code PrimitivePropertyTypeAdapter}
     *
     * @param delegate adapter to use for primitives type of the property
     */
    public PrimitivePropertyTypeAdapter(JsonAdapter<I> delegate) {
        this.delegate = delegate;
    }

    /**
     * Deserialize an instance of {@link P} from the given {@code reader}
     *
     * @param reader json reader
     * @return deserialized JSON
     * @throws IOException if an I/O errors has occurred in deserialize
     */
    @Override
    public P fromJson(JsonReader reader) throws IOException {
        I i = delegate.fromJson(reader);
        if (i != null) {
            return wrapPrimitiveValue(i);
        } else {
            return createDefaultProperty();
        }
    }

    /**
     * Serialize the given {@code value} using the given {@code writer}
     *
     * @param writer json writer
     * @param value  value to serialize
     * @throws IOException if an I/O errors has occurred in serialize
     */
    @Override
    public void toJson(JsonWriter writer, @Nullable P value) throws IOException {
        if (value != null) {
            delegate.toJson(writer, extractPrimitiveValue(value));
        } else {
            writer.nullValue();
        }
    }

    /**
     * Extract JavaFX {@link Property} in primitives value
     *
     * @param property property
     * @return primitives value of the property
     */
    protected abstract @NotNull I extractPrimitiveValue(P property);

    /**
     * Create a default property useful when input JSON value is {@code null}
     *
     * @return default property value
     */
    protected abstract @NotNull P createDefaultProperty();

    /**
     * Wraps the deserialized primitive value in a JavaFX {@code Property} object of the right type.
     *
     * @param deserializedValue the deserialized inner primitive value of the property
     * @return a new property object containing the given value
     */
    protected abstract @NotNull P wrapPrimitiveValue(@NotNull I deserializedValue);
}
