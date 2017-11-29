# average-rgb-value
Given a file containing a list of URLs that point to images, find the average color in each one

## Build Instructions
Build the executable and run the unit tests:

```
[colorfinder] mvn clean package
```

Example output:

```
master  ✭
[INFO] Scanning for projects...
[WARNING]
[WARNING] Some problems were encountered while building the effective model for colorfinder:colorfinder:jar:1.0-SNAPSHOT
[WARNING] 'build.plugins.plugin.version' for org.apache.maven.plugins:maven-jar-plugin is missing. @ line 38, column 15
[WARNING]
[WARNING] It is highly recommended to fix these problems because they threaten the stability of your build.
[WARNING]
[WARNING] For this reason, future Maven versions might no longer support building such malformed projects.
[WARNING]
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building colorfinder 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ colorfinder ---
[INFO] Deleting /Users/marissanovak/IdeaProjects/colorfinder/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ colorfinder ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.3:compile (default-compile) @ colorfinder ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/marissanovak/IdeaProjects/colorfinder/target/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ colorfinder ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO]
[INFO] --- maven-compiler-plugin:3.3:testCompile (default-testCompile) @ colorfinder ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 1 source file to /Users/marissanovak/IdeaProjects/colorfinder/target/test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.19.1:test (default-test) @ colorfinder ---
[INFO] Tests are skipped.
[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ colorfinder ---
[INFO] Building jar: /Users/marissanovak/IdeaProjects/colorfinder/target/colorfinder-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-shade-plugin:2.3:shade (default) @ colorfinder ---
[INFO] Including org.apache.directory.studio:org.apache.commons.io:jar:2.4 in the shaded jar.
[INFO] Including commons-io:commons-io:jar:2.4 in the shaded jar.
[INFO] Including net.coobird:thumbnailator:jar:0.4.8 in the shaded jar.
[INFO] Replacing original artifact with shaded artifact.
[INFO] Replacing /Users/marissanovak/IdeaProjects/colorfinder/target/colorfinder-1.0-SNAPSHOT.jar with /Users/marissanovak/IdeaProjects/colorfinder/target/colorfinder-1.0-SNAPSHOT-shaded.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.841 s
[INFO] Finished at: 2017-11-28T19:30:52-08:00
[INFO] Final Memory: 21M/307M
[INFO] ------------------------------------------------------------------------
```

## Run Instructions
After building the executable, the jar will run the main method of ColorFinder and generate the output file.

```
[colorfinder] java -jar target/colorfinder-1.0-SNAPSHOT.jar
```

## Output file

Output file is called colors.csv and is in the format `url;color;color;color`
