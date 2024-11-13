# The build will fail

Run the following command to build the project:

```shell
./mvnw clean install
```

Then you will see error:

In Markdown, you can’t natively "collapse" code blocks, but you can create a collapsible section with HTML tags:

<details>
  <summary>Click to expand</summary>

```
[INFO] Compiling 3 source files with javac [debug target 8] to target/classes
An exception has occurred in the compiler (17.0.12). Please file a bug against the Java compiler via the Java bug reporting page (https://bugreport.java.com) after checking the Bug Database (https://bugs.java.com) for duplicates. Include your program, the following diagnostic, and the parameters passed to the Java compiler in your report. Thank you.
java.lang.IllegalAccessError: class com.google.errorprone.BaseErrorProneJavaCompiler (in unnamed module @0x6367a688) cannot access class com.sun.tools.javac.api.BasicJavacTask (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.api to unnamed module @0x6367a688
        at com.google.errorprone.BaseErrorProneJavaCompiler.addTaskListener(BaseErrorProneJavaCompiler.java:85)
        at com.google.errorprone.ErrorProneJavacPlugin.init(ErrorProneJavacPlugin.java:34)
        at jdk.compiler/com.sun.tools.javac.api.BasicJavacTask.initPlugin(BasicJavacTask.java:255)
        at jdk.compiler/com.sun.tools.javac.api.BasicJavacTask.initPlugins(BasicJavacTask.java:229)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.prepareCompiler(JavacTaskImpl.java:204)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.lambda$doCall$0(JavacTaskImpl.java:101)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.invocationHelper(JavacTaskImpl.java:152)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.doCall(JavacTaskImpl.java:100)
        at jdk.compiler/com.sun.tools.javac.api.JavacTaskImpl.call(JavacTaskImpl.java:94)
        at org.codehaus.plexus.compiler.javac.JavaxToolsCompiler.compileInProcess(JavaxToolsCompiler.java:136)
        at org.codehaus.plexus.compiler.javac.JavacCompiler.performCompile(JavacCompiler.java:183)
        at org.apache.maven.plugin.compiler.AbstractCompilerMojo.execute(AbstractCompilerMojo.java:1140)
        at org.apache.maven.plugin.compiler.CompilerMojo.execute(CompilerMojo.java:193)
        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:126)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2(MojoExecutor.java:328)
        at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute(MojoExecutor.java:316)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:212)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:174)
        at org.apache.maven.lifecycle.internal.MojoExecutor.access$000(MojoExecutor.java:75)
        at org.apache.maven.lifecycle.internal.MojoExecutor$1.run(MojoExecutor.java:162)
        at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute(DefaultMojosExecutionStrategy.java:39)
        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:159)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:105)
        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:73)
        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:53)
        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:118)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:261)
        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:173)
        at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:101)
        at org.apache.maven.cli.MavenCli.execute(MavenCli.java:906)
        at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:283)
        at org.apache.maven.cli.MavenCli.main(MavenCli.java:206)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
        at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.base/java.lang.reflect.Method.invoke(Method.java:568)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:255)
        at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:201)
        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:361)
        at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:314)
```

</details>

# To make the build pass

## Rename the file .mvn/jvm.config.back to .mvn/jvm.config

Then run `./mvnw clean install`

Then you will see:

```shell
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile (default-compile) on project RestrictedApi: Compilation failure
[ERROR] /RestrictedApi/src/main/java/com/example/restrictedapi/RestrictedApiApplication.java:[8,46] [RestrictedApi] This is a restricted method
[ERROR]     (see https://errorprone.info/bugpattern/RestrictedApi)
[ERROR] 
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```

This is expected, as the RestrictedApiApplication.java file contains a restricted method.

Uncomment out the `@EnableAccessRestrictedApi` annotation in the RestrictedApiApplication.java file, and run `mvn clean install` again, build will succeed.
