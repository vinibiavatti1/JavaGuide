/*
 * System Logger
 * - This section explains the logging mechanism provided by the System class in Java, accessible via System.getLogger.
 *   It offers a lightweight, built-in alternative to external logging frameworks for basic logging needs.
 *
 * Overview
 * - System.getLogger was introduced in Java 9 as part of the JEP 264 initiative for a simple logging API.
 * - Provides access to a logger identified by a string name or a class, allowing messages to be logged at different
 *   levels.
 * - The logger is connected to the underlying JVM logging system, which can be configured via system properties.
 * - Primarily intended for lightweight or internal logging, not for full-featured enterprise logging solutions.
 *
 * Key Characteristics
 * - Returns an instance of System.Logger.
 * - Supports multiple logging levels through System.Logger.Level: TRACE, DEBUG, INFO, WARNING, ERROR, OFF.
 * - Methods include log(Level level, String msg) and log(Level level, String msg, Throwable t).
 * - Lightweight: no external dependencies required.
 * - Backed by JVM internal logging; can integrate with java.util.logging if configured.
 * - Designed for simplicity and quick diagnostics rather than advanced logging features like append or layouts.
 *
 * Configuring Logger
 * - The logging level for System.getLogger can be configured via JVM system properties.
 *   - In Command: java -Djdk.internal.logger.level=DEBUG MyApp
 *   - At Runtime: System.setProperty("jdk.internal.logger.level", "DEBUG");
 * - The logging Locale can also be configured to control message formatting, date/time, and number localization.
 *   - In Command: java -Djdk.internal.logger.locale=fr_FR MyApp
 *   - At Runtime: Locale.setDefault(Locale.ENGLISH);
 *
 * Usage
 * - Use System.getLogger to add basic logging to utilities, tools, or small applications where full-featured frameworks
 *   are unnecessary.
 * - Ideal for logging informational messages, warnings, errors, or trace/debug information without adding dependencies.
 * - Use log(Level, String) for simple messages and log(Level, String, Throwable) for exception tracking.
 * - Check isLoggable(Level) before expensive message construction to avoid unnecessary computation.
 * - Output: Depending on the JVM configuration, messages may be printed to the console or handled by the JVM logging
 *   system.
 */
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

void main() {
    /*
     * Get Logger
     * - Retrieves a logger instance from the JVM using System.getLogger.
     * - The parameter is a string name identifying the logger; commonly, this is the class name or a module name.
     * - Use this method when you need a lightweight logger without adding external dependencies like Log4j or SLF4J.
     */
    Logger logger = System.getLogger("_02_Logger");

    /*
     * Configuring Logger
     * - Sets up the logging level and locale for System.getLogger.
     * - These settings control the verbosity and regional formatting of log messages without modifying the logger code.
     */
    System.setProperty("jdk.internal.logger.level", "ALL");
    Locale.setDefault(Locale.ENGLISH);

    /*
     * Logging
     * - Logs a message using the System.Logger instance at the specified level.
     * - The Level parameter determines the severity of the message (TRACE, DEBUG, INFO, WARNING, ERROR).
     * - Output format depends on the JVM's logging configuration and locale settings.
     * - Output: Jan 20, 2026 10:07:04 PM _02_Logger main INFO: Hello World
     */
    logger.log(Level.INFO, "Hello World");

    /*
     * Lazy Logging
     * - Logs a message using a Supplier<String> to defer message construction until it is actually needed.
     * - Useful for expensive-to-create log messages, avoiding unnecessary computation if the log level is not enabled.
     * - The Level parameter determines the severity of the message (TRACE, DEBUG, INFO, WARNING, ERROR).
     * - Output format depends on the JVM's logging configuration and locale settings.
     * - Output: Jan 20, 2026 10:07:04 PM _02_Logger main INFO: Hello World
     */
    logger.log(Level.INFO, () -> "Hello World");

    /*
     * Logging With Throwable
     * - Logs a message along with a Throwable (exception or error) using System.Logger.
     * - The Level parameter determines the severity of the message (TRACE, DEBUG, INFO, WARNING, ERROR).
     * - Useful for tracking exceptions with stack traces while providing context via a log message.
     * - The output format includes timestamp, logger name, thread, level, message, and the full stack trace of the
     *   Throwable.
     * - Output:
     *   Jan 20, 2026 10:07:04 PM _02_Logger main INFO: Hello World
     *   java.lang.Exception: Error!
     *   at _02_Logger.main(_02_Logger.java:72)
     */
    logger.log(Level.ERROR, "Hello World", new Exception("Error!"));
}