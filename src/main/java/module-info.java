module io.github.danygold.fx.moshi {
    requires moshi;
    requires transitive javafx.base;
    requires static org.jetbrains.annotations;

    exports io.github.danygold.fxmoshi;
    exports io.github.danygold.fxmoshi.adapters.properties;
    exports io.github.danygold.fxmoshi.adapters.properties.primitives;
    exports io.github.danygold.fxmoshi.adapters.observable;
    exports io.github.danygold.fxmoshi.factories;

    opens io.github.danygold.fxmoshi to moshi;
    opens io.github.danygold.fxmoshi.adapters.properties to moshi;
    opens io.github.danygold.fxmoshi.adapters.properties.primitives to moshi;
    opens io.github.danygold.fxmoshi.adapters.observable to moshi;
    opens io.github.danygold.fxmoshi.factories to moshi;
}