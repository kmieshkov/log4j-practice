# log4j-practice

Configuration file <a href="https://logging.apache.org/log4j/2.x/manual/configuration.html">manual</a>


<pre><code>
&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;Configuration status=&quot;WARN&quot;&gt;
&lt;!--    Property for the path of the logs directory--&gt;
    &lt;Properties&gt;
        &lt;Property name=&quot;basePath&quot;&gt;./logs&lt;/Property&gt;
    &lt;/Properties&gt;

    &lt;Appenders&gt;
&lt;!--        Logging into the file--&gt;
        &lt;RollingFile name=&quot;File&quot; fileName=&quot;${basePath}/prints.log&quot; filePattern=&quot;${basePath}/prints-%d{yyyy-MM-dd}.log&quot;&gt;
            &lt;PatternLayout pattern=&quot;%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n&quot;/&gt;
&lt;!--            When file will rich 500KB, log4j will create the new file as specified in filePattern--&gt;
            &lt;SizeBasedTriggeringPolicy size=&quot;500&quot; /&gt;
        &lt;/RollingFile&gt;

        &lt;Console name=&quot;Console&quot; target=&quot;SYSTEM_OUT&quot;&gt;
            &lt;PatternLayout pattern=&quot;%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n&quot;/&gt;
        &lt;/Console&gt;
    &lt;/Appenders&gt;
    &lt;Loggers&gt;

&lt;!--         Provide errors only for alpha package--&gt;
        &lt;Logger name=&quot;alpha.Demo&quot; level=&quot;error&quot; additivity=&quot;false&quot;&gt;
            &lt;AppenderRef ref=&quot;File&quot;/&gt;
        &lt;/Logger&gt;

        &lt;Root level=&quot;trace&quot;&gt;
            &lt;AppenderRef ref=&quot;Console&quot;/&gt;
        &lt;/Root&gt;
    &lt;/Loggers&gt;
&lt;/Configuration&gt;
</code></pre>

# Info

**Where to log?** - &lt;Appenders&gt;
* separate file - &lt;RollingFile&gt;
* console - &lt;Console&gt;

**What to log?** - &lt;Loggers&gt; - change **level** attribute
* error - prints only errors
* trace - prints entire logs


**How to Log?** - &lt;PatternLayout&gt; - change **pattern** attribute

<hr>

To target separate files add Logger in the Logger section:
<pre><code>
&lt;Logger name=&quot;alpha.Demo&quot; level=&quot;error&quot; additivity=&quot;false&quot;&gt;
    &lt;AppenderRef ref=&quot;Console&quot;/&gt;
&lt;/Logger&gt;
</code></pre>

**additivity="false"** - to prevent duplicates in the *Log*

# Rules to use Log4j

**Log.Error()** - to log when elements are not displayed in the page or if any validations fail

**Log.Debug()** - When each Selenium action is performed like click, SendKeys, getText()

**Log.info()** - When operation is successfully completed ex: After loading page, or after any successful validations
It’s just **counterpart to Log.Error()**