package logic.MyLogger;
import GUI.SimpleGui;

import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;


public class TheBestLogger {
    //Singleton!
    private static TheBestLogger theBestLogger = new TheBestLogger();
    private Logger logger = Logger.getLogger("");

    private TheBestLogger() {
        FileHandler fh;
        try {
            fh = new FileHandler("src/Logfile.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (IOException e) {
            logger.warning("File to log not found");
        } catch (SecurityException e) {
            logger.warning("Access denied to open logFile");
        } catch (Exception e) {
            logger.warning("Some trouble when logging");
        }
    }

    public static TheBestLogger getInstance() {
        return theBestLogger;
    }

    public void logException(String s) {
        logger.warning(s);
        SimpleGui.getInstance().addInTextArea(s);
    }

    public void logInfo(String s) {
        logger.info(s);
        SimpleGui.getInstance().addInTextArea(s);
    }
}

