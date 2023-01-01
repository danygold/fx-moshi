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
import javafx.beans.property.*;
import javafx.collections.FXCollections;
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
        TestFullPOJO testFullPOJO = new TestFullPOJO();
        // Primitives
        testFullPOJO.setBooleanProperty(true);
        testFullPOJO.setDoubleProperty(99D);
        testFullPOJO.setFloatProperty(66F);
        testFullPOJO.setIntegerProperty(9);
        testFullPOJO.setLongProperty(9876543210123L);
        // Property
        testFullPOJO.setListProperty(FXCollections.observableList(List.of("list1", "list2")));
        testFullPOJO.setMapProperty(FXCollections.observableMap(Map.of("key1", "value1", "key2", "value2")));
        testFullPOJO.setObjectProperty(LocalDate.of(1970, 1, 1));
        testFullPOJO.setSetProperty(FXCollections.observableSet(Set.of("set1", "set2")));
        testFullPOJO.setStringProperty("string");

        TestFullPOJO testFullPOJO1 = deepCopy(FXMoshi.createBuilder().add(new LocalDateAdapter()).build(), testFullPOJO, TestFullPOJO.class);
        Assertions.assertEquals(testFullPOJO, testFullPOJO1);

        // LocalDateTime adapter required
        Assertions.assertThrows(IllegalArgumentException.class, () -> deepCopy(FXMoshi.build(), testFullPOJO, TestFullPOJO.class));

        TestFullPOJO emptyPOJO = FXMoshi.createBuilder().add(new LocalDateAdapter()).build().adapter(TestFullPOJO.class).fromJson("{}");
        assert emptyPOJO != null;
        Assertions.assertEquals(new SimpleBooleanProperty().get(), emptyPOJO.booleanPropertyProperty().get());
        Assertions.assertEquals(new SimpleDoubleProperty().get(), emptyPOJO.doublePropertyProperty().get());
        Assertions.assertEquals(new SimpleFloatProperty().get(), emptyPOJO.floatPropertyProperty().get());
        Assertions.assertEquals(new SimpleIntegerProperty().get(), emptyPOJO.integerPropertyProperty().get());
        Assertions.assertEquals(new SimpleLongProperty().get(), emptyPOJO.longPropertyProperty().get());
        Assertions.assertEquals(FXCollections.observableArrayList(), emptyPOJO.listPropertyProperty());
        Assertions.assertEquals(FXCollections.observableHashMap(), emptyPOJO.mapPropertyProperty());
        Assertions.assertEquals(new SimpleObjectProperty<LocalDate>().get(), emptyPOJO.objectPropertyProperty().get());
        Assertions.assertEquals(FXCollections.observableSet(), emptyPOJO.setPropertyProperty());
        Assertions.assertEquals(new SimpleStringProperty().get(), emptyPOJO.stringPropertyProperty().get());

        TestFullPOJO emptyPOJO1 = new TestFullPOJO();
        TestFullPOJO emptyPOJO2 = deepCopy(FXMoshi.createBuilder().add(new LocalDateAdapter()).build(), emptyPOJO1, TestFullPOJO.class);
        Assertions.assertEquals(emptyPOJO1, emptyPOJO2);
    }

    @Test
    void mixedProperties() {
        TestMixedPOJO testMixedPOJO = new TestMixedPOJO();
        testMixedPOJO.setStringProperty("stringProperties");
        testMixedPOJO.setString("string");

        TestMixedPOJO testMixedPOJO1 = deepCopy(FXMoshi.build(), testMixedPOJO, TestMixedPOJO.class);
        Assertions.assertEquals(testMixedPOJO, testMixedPOJO1);
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
        public LocalDate from(String pathString) {
            return LocalDate.parse(pathString);
        }


        @ToJson
        public String to(@NotNull LocalDate path) {
            return path.toString();
        }
    }

}