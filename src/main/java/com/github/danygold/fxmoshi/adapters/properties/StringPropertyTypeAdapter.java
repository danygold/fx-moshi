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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.jetbrains.annotations.NotNull;

/**
 * JsonAdapter for JavaFX {@link StringProperty}.
 * <p>
 * Suppose that the {@code Car} class is defined like this:
 * <pre>
 * {@code
 *     class Car {
 *         private final StringProperty name;
 *
 *         Car(boolean name) {
 *             this.name = new SimpleStringProperty(name);
 *         }
 *     }
 * }</pre>
 * Here is how {@code new Car("Tesla")} is serialized:
 * <pre>
 * {
 *   "name": "Tesla"
 * }
 * </pre>
 */
public class StringPropertyTypeAdapter extends PropertyTypeAdapter<String, StringProperty> {

    /**
     * Instance a new {@code StringPropertyTypeAdapter}
     *
     * @param delegate adapter to use for this type of the property
     */
    public StringPropertyTypeAdapter(JsonAdapter<String> delegate) {
        super(delegate);
    }

    /**
     * Create a given {@code deserializedValue} in a {@link StringProperty}
     *
     * @param deserializedValue value
     * @return a new string property with {@code deserializedValue} as initial value
     */
    @Override
    protected @NotNull StringProperty createProperty(String deserializedValue) {
        return new SimpleStringProperty(deserializedValue);
    }
}
