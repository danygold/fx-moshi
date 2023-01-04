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

package io.github.danygold.fxmoshi;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.ToJson;
import javafx.beans.InvalidationListener;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

class FXMoshiTest {

    @Test
    void fullProperties() throws IOException {

    }

    @Test
    void mixedProperties() {

    }

    @Test
    void specializedProperties() {

    }

    @Test
    void nullProperties() throws IOException {
    }

    public static <T> T deepCopy(@NotNull Moshi moshi, T o, Class<T> clazz) {
        try {
            JsonAdapter<T> adapter = moshi.adapter(clazz);
            return adapter.fromJson(adapter.toJson(o));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unused")
    private static class LocalDateAdapter {

        @FromJson
        public LocalDate from(String value) {
            return LocalDate.parse(value);
        }


        @Contract(pure = true)
        @ToJson
        public @NotNull String to(@NotNull LocalDate localDate) {
            return localDate.toString();
        }
    }

    @SuppressWarnings("unused")
    private static class TestClass {
        private CustomProperty customProperty;
    }

    @SuppressWarnings("unused")
    private static class CustomProperty implements Property<String> {

        @Override
        public void bind(ObservableValue<? extends String> observable) {

        }

        @Override
        public void unbind() {

        }

        @Override
        public boolean isBound() {
            return false;
        }

        @Override
        public void bindBidirectional(Property<String> other) {

        }

        @Override
        public void unbindBidirectional(Property<String> other) {

        }

        @Override
        public Object getBean() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }

        @Override
        public void addListener(ChangeListener<? super String> listener) {

        }

        @Override
        public void removeListener(ChangeListener<? super String> listener) {

        }

        @Override
        public String getValue() {
            return null;
        }

        @Override
        public void setValue(String value) {

        }

        @Override
        public void addListener(InvalidationListener listener) {

        }

        @Override
        public void removeListener(InvalidationListener listener) {

        }
    }
}