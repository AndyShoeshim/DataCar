package com.datacar.api;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyVisibilityStrategy;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Provider
public class JsonbProvider implements ContextResolver<Jsonb> {

    @Override
    public Jsonb getContext(Class<?> type) {
        JsonbConfig jsonbConfig = new JsonbConfig().withPropertyVisibilityStrategy(new PropertyVisibilityStrategy() {

            @Override
            public boolean isVisible(Method method) {
                return true;
            }

            @Override
            public boolean isVisible(Field field) {
                return true;
            }
        });
        return JsonbBuilder.newBuilder().withConfig(jsonbConfig).build();
    }
}
