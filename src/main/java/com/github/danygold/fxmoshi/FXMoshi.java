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

package com.github.danygold.fxmoshi;

import com.github.danygold.fxmoshi.factories.FXObservableFactory;
import com.github.danygold.fxmoshi.factories.FXPropertyFactory;
import com.squareup.moshi.Moshi;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * FXMoshi.
 */
public final class FXMoshi {

    private FXMoshi() {
        // Hide default constructor
    }

    /**
     * Build a ready-to-use Moshi able to serialize/deserialize JavaFX properties
     *
     * @return ready-to-use Moshi
     */
    @Contract(" -> new")
    public static @NotNull Moshi build() {
        return createBuilder().build();
    }

    /**
     * Create a ready-to-use Moshi builder able to serialize/deserialize JavaFX properties
     *
     * @return ready-to-use Moshi builder
     */
    public static @NotNull Moshi.Builder createBuilder() {
        return addJavaFXFactories(new Moshi.Builder());
    }

    /**
     * Add JavaFX support to a given Moshi {@code builder}
     *
     * @param builder builder to use
     * @return same instance of {@code builder} useful for the fluent API
     */
    @Contract("_ -> param1")
    public static @NotNull Moshi.Builder addJavaFXFactories(@NotNull Moshi.Builder builder) {
        builder.add(new FXPropertyFactory());
        builder.add(new FXObservableFactory());

        return builder;
    }
}
