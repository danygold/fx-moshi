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

package com.github.danygold.fxmoshi.factories;

import com.github.danygold.fxmoshi.adapters.properties.*;
import com.github.danygold.fxmoshi.adapters.properties.primitives.*;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/**
 * JsonAdapter Factory for JavaFX {@link Property}.
 */
public class FXPropertyFactory implements JsonAdapter.Factory {

    /**
     * Create JavaFx Property factory
     *
     * @param type        class type
     * @param annotations annotations of this field
     * @param moshi       moshi instance
     * @return the relative JsonAdapter, or {@code null}
     */
    @Override
    public @Nullable JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
        Class<?> rawType = Types.getRawType(type);

        // This factory support only JavaFx property
        if (!Property.class.isAssignableFrom(rawType)) {
            return null;
        }

        // Primitives
        if (BooleanProperty.class.isAssignableFrom(rawType)) {
            return new BooleanPropertyTypeAdapter(moshi.adapter(boolean.class));
        }
        if (IntegerProperty.class.isAssignableFrom(rawType)) {
            return new IntegerPropertyTypeAdapter(moshi.adapter(int.class));
        }
        if (LongProperty.class.isAssignableFrom(rawType)) {
            return new LongPropertyTypeAdapter(moshi.adapter(long.class));
        }
        if (FloatProperty.class.isAssignableFrom(rawType)) {
            return new FloatPropertyTypeAdapter(moshi.adapter(float.class));
        }
        if (DoubleProperty.class.isAssignableFrom(rawType)) {
            return new DoublePropertyTypeAdapter(moshi.adapter(double.class));
        }

        // String
        if (StringProperty.class.isAssignableFrom(rawType)) {
            return new StringPropertyTypeAdapter(moshi.adapter(String.class));
        }

        // List, Set and Map
        if (ListProperty.class.equals(rawType) || SimpleListProperty.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type observableListType = Types.newParameterizedType(ObservableList.class, actualTypeArguments[0]);
            return new ListPropertyTypeAdapter<>(moshi.adapter(observableListType));
        }
        if (SetProperty.class.equals(rawType) || SimpleSetProperty.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type observableSetType = Types.newParameterizedType(ObservableSet.class, actualTypeArguments[0]);
            return new SetPropertyTypeAdapter<>(moshi.adapter(observableSetType));
        }
        if (MapProperty.class.equals(rawType) || SimpleMapProperty.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type observableMapSet = Types.newParameterizedType(ObservableMap.class, actualTypeArguments[0], actualTypeArguments[1]);
            return new MapPropertyTypeAdapter<>(moshi.adapter(observableMapSet));
        }

        // Generic Property with type parameter
        if (Property.class.equals(rawType) || ObjectProperty.class.equals(rawType) || SimpleObjectProperty.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type parameterType = actualTypeArguments[0];
            return new ObjectPropertyTypeAdapter<>(moshi.adapter(parameterType));
        }

        return null;
    }
}