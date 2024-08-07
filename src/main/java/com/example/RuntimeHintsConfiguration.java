package com.example;

import com.hazelcast.instance.GeneratedBuildProperties;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportRuntimeHints;

@ImportRuntimeHints(RuntimeHintsConfiguration.BindingRuntimeHints.class)
@Configuration("cacheRuntimeHintsConfiguration")
public class RuntimeHintsConfiguration {

    static class BindingRuntimeHints implements RuntimeHintsRegistrar {
        @Override
        public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
            try {
                // With the new hazelcast version we no longer need to add this.
                // However, since the new version has not been released I had to add this.
                // Resolved : https://github.com/hazelcast/hazelcast/pull/26386
                hints.reflection().registerField(GeneratedBuildProperties.class.getDeclaredField("ARTIFACT_ID"));
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
