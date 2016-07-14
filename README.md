GPatch
=======

android patch update【android增量升级】


Download
--------

Download [the latest AAR][2] or grab via Gradle:
```groovy
compile 'com.gutils:gpatch:0.0.1'
```
if JCenter:
```groovy
compile 'com.gutils:GPatch:0.0.1'
```
or Maven:
```xml
<dependency>
  <groupId>com.gutils</groupId>
  <artifactId>gpatch</artifactId>
  <version>0.0.1</version>
</dependency>
```

Snapshots of the development version are available in [Sonatype's `snapshots` repository][snap].



ProGuard
--------

If you are using ProGuard you might need to add the following option:
```
-dontwarn com.gutils.frame.common.**
```

Test
--------

1.build patch
~~~bash
bsdiff demo-old.apk demo-new.apk demo.patch
~~~

2.push the patch to SDCard
~~~bash
adb push demo.patch /sdcard/
~~~

3.install the old apk
~~~bash
adb install demo-old.apk
~~~

4.test


License
--------

    Copyright 2015 hyxf, Inc.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

 [2]: http://search.maven.org/remotecontent?filepath=com/gutils/gpatch/0.0.1/gpatch-0.0.1.aar
 [snap]: https://oss.sonatype.org/content/repositories/snapshots/
