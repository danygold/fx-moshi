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

package com.github.danygold.fxmoshi.adapters.properties;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import javafx.beans.property.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

/**
 * Abstract JsonAdapter useful for JavaFX {@link Property}
 *
 * @param <I> the type of the property
 * @param <P> the real property that this adapter can serialize/deserialize
 */
public abstract class PropertyTypeAdapter<I, P extends Property<? extends I>> extends JsonAdapter<P> {

    private final JsonAdapter<I> delegate;

    /**
     * Instance a new {@code PropertyTypeAdapter}
     *
     * @param delegate adapter to use for this type of the property
     */
    public PropertyTypeAdapter(JsonAdapter<I> delegate) {
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
        return createProperty(delegate.fromJson(reader));
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
            delegate.toJson(writer, value.getValue());
        } else {
            writer.nullValue();
        }
    }

    /**
     * Create a new property with the given {@code value}
     *
     * @param deserializedValue value
     * @return a new property object containing the given value
     */
    protected abstract @NotNull P createProperty(@Nullable I deserializedValue);
}
