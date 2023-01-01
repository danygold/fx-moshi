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

package com.github.danygold.fxmoshi.adapters.observable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * JsonAdapter for JavaFX {@link ObservableSet}.
 * <p>
 * Suppose that the {@code Cars} class is defined like this:
 * <pre>
 * {@code
 *     class Cars {
 *         private final ObservableSet<String> names;
 *
 *         Cars(Set<String> names) {
 *             this.names = FXCollections.observableSet(names);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Cars(Set.of("Ferrari", "Lamborghini", "Tesla"))} is serialized:
 * <pre>
 * {
 *   "names": [
 *     "Ferrari",
 *     "Lamborghini",
 *     "Tesla"
 *   ]
 * }
 * </pre>
 *
 * @param <T> the type of element in this set
 */
public class ObservableSetAdapter<T> extends JsonAdapter<ObservableSet<T>> {

    private final JsonAdapter<Set<T>> delegate;

    /**
     * Instance a new {@code ObservableSetAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public ObservableSetAdapter(JsonAdapter<Set<T>> delegate) {
        this.delegate = delegate;
    }

    /**
     * @param reader json reader
     * @return deserialized JSON
     * @throws IOException if an I/O errors has occurred in deserialize
     */
    @Override
    public ObservableSet<T> fromJson(JsonReader reader) throws IOException {
        Set<T> objects = delegate.fromJson(reader);

        return FXCollections.observableSet(Objects.requireNonNullElseGet(objects, HashSet::new));
    }

    /**
     * Serialize the given {@code value} using the given {@code writer}
     *
     * @param writer json writer
     * @param value  value to serialize
     * @throws IOException if an I/O errors has occurred in serialize
     */
    @Override
    public void toJson(JsonWriter writer, ObservableSet<T> value) throws IOException {
        if (value != null) {
            delegate.toJson(writer, new HashSet<>(value));
        } else {
            writer.nullValue();
        }
    }
}