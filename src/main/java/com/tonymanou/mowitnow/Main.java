package com.tonymanou.mowitnow;

import com.tonymanou.mowitnow.logic.MowerController;
import com.tonymanou.mowitnow.model.Garden;
import com.tonymanou.mowitnow.model.Mower;
import com.tonymanou.mowitnow.util.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.List;

public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String SCENARIO_FILE = "scenario.txt";

    /**
     * Entry point of the program.
     *
     * @param args optional arguments (ignored)
     */
    public static void main(String[] args) {
        LOGGER.info("Welcome to MowItNow!");

        MowerController controller = new MowerController();
        try {
            List<String> commands = IOUtils.loadFileLines(SCENARIO_FILE);

            controller.process(commands);

            Garden garden = controller.getGarden();
            LOGGER.info("Garden is of size {}x{}", garden.getSizeX(), garden.getSizeY());
            for (Mower mower : controller.getMowers()) {
                LOGGER.info("Mower {} is now at position (x={}, y={}) in the garden, with orientation={}",
                        mower.getId(), mower.getPositionX(), mower.getPositionY(), mower.getOrientation());
            }
        } catch (IOException e) {
            LOGGER.error("Unable to load scenario file", e);
        } catch (RuntimeException e) {
            LOGGER.error("An unexpected exception occurred", e);
        }
    }
}
