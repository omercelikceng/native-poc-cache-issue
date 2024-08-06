# native-poc-cache

If you follow the steps below in order, you will encounter the error.
1. mvn clean install
2. mvn spring-boot:build-image -P native 
3. docker run --name hz1 -p 5701:5701 --network=cache-network hazelcast/hazelcast:5.5.0-jdk17
4. docker run --network=cache-network docker.io/library/native-poc-cache:0.0.1-SNAPSHOT

Error : 

```
Caused by: java.lang.ExceptionInInitializerError: null
        at com.hazelcast.spi.properties.ClusterProperty.<clinit>(ClusterProperty.java:1692) ~[na:na]
        at com.hazelcast.client.impl.clientside.HazelcastClientInstanceImpl.<init>(HazelcastClientInstanceImpl.java:232) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.hazelcast.client.HazelcastClient.constructHazelcastClient(HazelcastClient.java:475) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.hazelcast.client.HazelcastClient.newHazelcastClientInternal(HazelcastClient.java:425) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.hazelcast.client.HazelcastClient.newHazelcastClient(HazelcastClient.java:142) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.example.HazelcastConfiguration.hazelcastClient(HazelcastConfiguration.java:43) ~[com.example.NativePocCacheApplication:na]
        at com.example.HazelcastConfiguration$$SpringCGLIB$$0.CGLIB$hazelcastClient$1(<generated>) ~[com.example.NativePocCacheApplication:na]
        at com.example.HazelcastConfiguration$$SpringCGLIB$$FastClass$$1.invoke(<generated>) ~[com.example.NativePocCacheApplication:na]
        at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[na:na]
        at com.example.HazelcastConfiguration$$SpringCGLIB$$0.hazelcastClient(<generated>) ~[com.example.NativePocCacheApplication:na]
        at com.example.HazelcastConfiguration__BeanDefinitions.lambda$getHazelcastClientInstanceSupplier$1(HazelcastConfiguration__BeanDefinitions.java:52) ~[na:na]
        at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:68) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:54) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.beans.factory.aot.BeanInstanceSupplier.lambda$get$2(BeanInstanceSupplier.java:206) ~[na:na]
        at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.beans.factory.aot.BeanInstanceSupplier.invokeBeanSupplier(BeanInstanceSupplier.java:218) ~[na:na]
        at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:206) ~[na:na]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[com.example.NativePocCacheApplication:6.1.4]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1217) ~[com.example.NativePocCacheApplication:6.1.4]
        ... 33 common frames omitted
        
Caused by: com.hazelcast.core.HazelcastException: java.lang.NoSuchFieldException: ARTIFACT_ID
        at com.hazelcast.instance.BuildInfoProvider.readStaticStringField(BuildInfoProvider.java:112) ~[na:na]
        at com.hazelcast.instance.BuildInfoProvider.readBuildPropertiesClass(BuildInfoProvider.java:92) ~[na:na]
        at com.hazelcast.instance.BuildInfoProvider.getBuildInfoInternalVersion(BuildInfoProvider.java:71) ~[na:na]
        at com.hazelcast.instance.BuildInfoProvider.populateBuildInfoCache(BuildInfoProvider.java:48) ~[na:na]
        at com.hazelcast.instance.BuildInfoProvider.<clinit>(BuildInfoProvider.java:41) ~[na:na]
        ... 54 common frames omitted

Caused by: java.lang.NoSuchFieldException: ARTIFACT_ID
        at java.base@21.0.2/java.lang.Class.checkField(DynamicHub.java:1041) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.Class.getField(DynamicHub.java:1026) ~[com.example.NativePocCacheApplication:na]
        at com.hazelcast.instance.BuildInfoProvider.readStaticStringField(BuildInfoProvider.java:109) ~[na:na]
        ... 58 common frames omitted
```
