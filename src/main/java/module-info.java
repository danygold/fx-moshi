module fx.moshi.main {
    requires moshi;
    requires javafx.base;
    requires org.jetbrains.annotations;

    exports io.github.danygold.fxmoshi;
    exports io.github.danygold.fxmoshi.adapters.properties;
    exports io.github.danygold.fxmoshi.adapters.properties.primitives;
    exports io.github.danygold.fxmoshi.adapters.observable;
    exports io.github.danygold.fxmoshi.factories;
}