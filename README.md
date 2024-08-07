# native-poc-cache

If you follow the steps below in order, you will encounter the error.
1. mvn clean install
2. mvn spring-boot:build-image -P native 
3. docker run --name hz1 -p 5701:5701 --network=cache-network hazelcast/hazelcast:5.5.0-jdk17
4. docker run --network=cache-network docker.io/library/native-poc-cache-issue:0.0.1-SNAPSHOT

Error : 

```
2024-07-30T13:38:51.976Z  WARN 1 --- [nt_1.internal-2] c.h.i.m.impl.MetricsCollectionCycle      : Collecting metrics from source com.hazelcast.internal.networking.nio.NioNetworking failed

org.graalvm.nativeimage.MissingReflectionRegistrationError: The program tried to reflectively invoke method private long com.hazelcast.internal.networking.nio.NioOutboundPipeline.idleTimeMillis() without it being registered for runtime reflection. Add private long com.hazelcast.internal.networking.nio.NioOutboundPipeline.idleTimeMillis() to the reflection metadata to solve this problem. See https://www.graalvm.org/latest/reference-manual/native-image/metadata/#reflection for help.
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.reflect.MissingReflectionRegistrationUtils.forQueriedOnlyExecutable(MissingReflectionRegistrationUtils.java:72) ~[na:na]
        at java.base@21.0.2/java.lang.reflect.Method.acquireMethodAccessor(Method.java:77) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.reflect.Method.invoke(Method.java:577) ~[com.example.NativePocCacheApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.methodhandles.Util_java_lang_invoke_MethodHandle.invokeInternal(Target_java_lang_invoke_MethodHandle.java:265) ~[na:na]
        at java.base@21.0.2/java.lang.invoke.MethodHandle.invokeBasic(MethodHandle.java:98) ~[com.example.NativePocCacheApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.methodhandles.MethodHandleIntrinsicImpl.execute(MethodHandleIntrinsicImpl.java:179) ~[na:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.methodhandles.Util_java_lang_invoke_MethodHandle.invokeInternal(Target_java_lang_invoke_MethodHandle.java:186) ~[na:na]
        at java.base@21.0.2/java.lang.invoke.MethodHandle.invokeBasic(MethodHandle.java:98) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.invoke.LambdaForm$NamedFunction.invokeWithArguments(LambdaForm.java:96) ~[na:na]
        at java.base@21.0.2/java.lang.invoke.LambdaForm.interpretName(LambdaForm.java:959) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.invoke.LambdaForm.interpretWithArguments(LambdaForm.java:936) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.invoke.MethodHandle.invokeBasic(MethodHandle.java:105) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.invoke.MethodHandle.invokeBasic(MethodHandle.java:0) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.invoke.LambdaForm$MH/0x00000007c16b4800.invokeExact_MT(LambdaForm$MH) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MethodProbe$LongMethodProbe.get(MethodProbe.java:197) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MetricsCollectionCycle.collectLong(MetricsCollectionCycle.java:175) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MetricsCollectionCycle.collect(MetricsCollectionCycle.java:153) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MetricsCollectionCycle.extractAndCollectDynamicMetrics(MetricsCollectionCycle.java:128) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MetricsCollectionCycle$MetricsContext.collect(MetricsCollectionCycle.java:189) ~[na:na]
        at com.hazelcast.internal.networking.nio.NioNetworking.provideDynamicMetrics(NioNetworking.java:371) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.hazelcast.internal.metrics.impl.MetricsCollectionCycle.collectDynamicMetrics(MetricsCollectionCycle.java:94) ~[na:na]
        at com.hazelcast.internal.metrics.impl.MetricsRegistryImpl.collect(MetricsRegistryImpl.java:320) ~[na:na]
        at com.hazelcast.client.impl.statistics.ClientStatisticsService.collectAndSendStats(ClientStatisticsService.java:148) ~[na:na]
        at java.base@21.0.2/java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:572) ~[na:na]
        at java.base@21.0.2/java.util.concurrent.FutureTask.runAndReset(FutureTask.java:358) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:305) ~[na:na]
        at java.base@21.0.2/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642) ~[na:na]
        at java.base@21.0.2/java.lang.Thread.runWith(Thread.java:1596) ~[com.example.NativePocCacheApplication:na]
        at java.base@21.0.2/java.lang.Thread.run(Thread.java:1583) ~[com.example.NativePocCacheApplication:na]
        at com.hazelcast.internal.util.executor.HazelcastManagedThread.executeRun(HazelcastManagedThread.java:76) ~[com.example.NativePocCacheApplication:5.5.0]
        at com.hazelcast.internal.util.executor.PoolExecutorThreadFactory$ManagedThread.executeRun(PoolExecutorThreadFactory.java:74) ~[na:na]
        at com.hazelcast.internal.util.executor.HazelcastManagedThread.run(HazelcastManagedThread.java:111) ~[com.example.NativePocCacheApplication:5.5.0]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.thread.PlatformThreads.threadStartRoutine(PlatformThreads.java:838) ~[com.example.NativePocCacheApplication:na]
        at org.graalvm.nativeimage.builder/com.oracle.svm.core.posix.thread.PosixPlatformThreads.pthreadStartRoutine(PosixPlatformThreads.java:211) ~[na:na]
```
