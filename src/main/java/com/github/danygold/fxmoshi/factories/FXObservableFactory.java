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

import com.github.danygold.fxmoshi.adapters.observable.ObservableListAdapter;
import com.github.danygold.fxmoshi.adapters.observable.ObservableMapAdapter;
import com.github.danygold.fxmoshi.adapters.observable.ObservableSetAdapter;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import com.squareup.moshi.internal.Util;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.collections.ObservableSet;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * JsonAdapter Factory for JavaFX {@link javafx.beans.Observable}.
 */
public class FXObservableFactory implements JsonAdapter.Factory {

    /**
     * Create JavaFx Observable factory
     *
     * @param type        class type
     * @param annotations annotations of this field
     * @param moshi       moshi instance
     * @return the relative JsonAdapter, or {@code null}
     */
    @Override
    public @Nullable JsonAdapter<?> create(Type type, Set<? extends Annotation> annotations, Moshi moshi) {
        Class<?> rawType = Types.getRawType(type);

        if (ObservableList.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type listType = Types.newParameterizedType(List.class, actualTypeArguments[0]);
            return new ObservableListAdapter<>(moshi.adapter(listType));
        }
        if (ObservableSet.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type setType = Types.newParameterizedType(Set.class, actualTypeArguments[0]);
            return new ObservableSetAdapter<>(moshi.adapter(setType));
        }
        if (ObservableMap.class.equals(rawType)) {
            Type[] actualTypeArguments = ((Util.ParameterizedTypeImpl) type).getActualTypeArguments();
            Type mapType = Types.newParameterizedType(Map.class, actualTypeArguments[0], actualTypeArguments[1]);
            return new ObservableMapAdapter<>(moshi.adapter(mapType));
        }

        return null;
    }
}
