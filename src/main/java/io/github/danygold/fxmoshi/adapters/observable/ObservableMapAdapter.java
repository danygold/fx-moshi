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

package io.github.danygold.fxmoshi.adapters.observable;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * JsonAdapter for JavaFX {@link ObservableMap}.
 * <p>
 * Suppose that the {@code Cars} class is defined like this:
 * <pre>
 * {@code
 *     class Cars {
 *         private final ObservableMap<String, Integer> modelsYear;
 *
 *         Cars(Map<String, Integer> modelsYear) {
 *             this.modelsYear = FXCollections.observableMap(modelsYear);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Cars(Map.of("Model S", 2020, "Model X", 2022))} is serialized:
 * <pre>
 * {
 *   "modelsYear": {
 *     "Model S": 2020,
 *     "Model X": 2022
 *   }
 * }
 * </pre>
 *
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class ObservableMapAdapter<K, V> extends JsonAdapter<ObservableMap<K, V>> {

    private final JsonAdapter<Map<K, V>> delegate;

    /**
     * Instance a new {@code ObservableMapAdapter}
     *
     * @param delegate adapter to use for serialize/deserialize
     */
    public ObservableMapAdapter(JsonAdapter<Map<K, V>> delegate) {
        this.delegate = delegate;
    }

    /**
     * @param reader json reader
     * @return deserialized JSON
     * @throws IOException if an I/O errors has occurred in deserialize
     */
    @Override
    public ObservableMap<K, V> fromJson(JsonReader reader) throws IOException {
        Map<K, V> objects = delegate.fromJson(reader);

        if (objects != null) {
            return FXCollections.observableMap(objects);
        } else {
            return FXCollections.observableHashMap();
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
    public void toJson(JsonWriter writer, ObservableMap<K, V> value) throws IOException {
        if (value != null) {
            delegate.toJson(writer, new HashMap<>(value));
        } else {
            writer.nullValue();
        }
    }
}