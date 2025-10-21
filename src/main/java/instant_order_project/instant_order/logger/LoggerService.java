
package instant_order_project.instant_order.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    private static final Logger logger = LogManager.getLogger("instant_order_project");

    // Info log
    public void info(String message) {
        logger.info(message);
    }

    // Debug log
    public void debug(String message) {
        logger.debug(message);
    }

    // Warning log
    public void warn(String message) {
        logger.warn(message);
    }

    // Error log
    public void error(String message, Throwable t) {
        logger.error(message, t);
    }

    // Error log without exception
    public void error(String message) {
        logger.error(message);
    }
}
