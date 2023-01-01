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

package io.github.danygold.fxmoshi.adapters.properties;

import com.squareup.moshi.JsonAdapter;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.ObservableList;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link ListProperty}.
 * <p>
 * Suppose that the {@code Cars} class is defined like this:
 * <pre>
 * {@code
 *     class Cars {
 *         private final ListProperty<String> names;
 *
 *         Cars(List<String> names) {
 *             this.names = new SimpleListProperty<>(names);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Cars(List.of("Ferrari", "Lamborghini", "Tesla"))} is serialized:
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
 * @param <T> the type of element in this list
 */
public class ListPropertyTypeAdapter<T> extends PropertyTypeAdapter<ObservableList<T>, ListProperty<T>> {

    /**
     * Instance a new {@code ListPropertyTypeAdapter}
     *
     * @param delegate adapter to use for this type of the property
     */
    public ListPropertyTypeAdapter(JsonAdapter<ObservableList<T>> delegate) {
        super(delegate);
    }

    /**
     * Create a given {@code deserializedValue} in a {@link ListProperty}
     *
     * @param deserializedValue value
     * @return a new list property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull ListProperty<T> createProperty(ObservableList<T> deserializedValue) {
        return new SimpleListProperty<>(deserializedValue);
    }
}
