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
import javafx.beans.property.MapProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.collections.ObservableMap;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link MapProperty}.
 * <p>
 * Suppose that the {@code Cars} class is defined like this:
 * <pre>
 * {@code
 *     class Cars {
 *         private final MapProperty<String, Integer> modelsYear;
 *
 *         Cars(Map<String, Integer> modelsYear) {
 *             this.modelsYear = new SimpleMapProperty<>(modelsYear);
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
public class MapPropertyTypeAdapter<K, V> extends PropertyTypeAdapter<ObservableMap<K, V>, MapProperty<K, V>> {

    /**
     * Instance a new {@code MapPropertyTypeAdapter}
     *
     * @param delegate adapter to use for this type of the property
     */
    public MapPropertyTypeAdapter(JsonAdapter<ObservableMap<K, V>> delegate) {
        super(delegate);
    }

    /**
     * Create a given {@code deserializedValue} in a {@link MapProperty}
     *
     * @param deserializedValue value
     * @return a new map property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull MapProperty<K, V> createProperty(ObservableMap<K, V> deserializedValue) {
        return new SimpleMapProperty<>(deserializedValue);
    }
}
