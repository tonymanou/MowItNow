package com.tonymanou.mowitnow;

import com.tonymanou.mowitnow.logic.MowerController;
import com.tonymanou.mowitnow.model.Garden;
import com.tonymanou.mowitnow.model.Mower;
import com.tonymanou.mowitnow.model.Orientation;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ScenarioTest {

    private static final List<String> SCENARIO_COMMANDS = Arrays.asList(
            "5 5",
            "1 2 N",
            "GAGAGAGAA",
            "3 3 E",
            "AADAADADDA"
    );

    @Test
    public void testScenario() {
        MowerController controller = new MowerController();
        controller.process(SCENARIO_COMMANDS);

        Garden garden = controller.getGarden();
        assertNotNull("Garden must not be null", garden);
        assertEquals("Invalid size X for garden", 6, garden.getSizeX());
        assertEquals("Invalid size Y for garden", 6, garden.getSizeY());

        List<Mower> mowers = controller.getMowers();
        assertNotNull("Mowers list must not be null", mowers);
        assertEquals("Invalid number of mowers created", 2, mowers.size());

        Mower mower1 = mowers.get(0);
        assertNotNull("Mower 1 must not be null", mower1);
        assertEquals("Invalid position X for mower 1", 1, mower1.getPositionX());
        assertEquals("Invalid position Y for mower 1", 3, mower1.getPositionY());
        assertEquals("Invalid orientation for mower 1", Orientation.N, mower1.getOrientation());

        Mower mower2 = mowers.get(1);
        assertNotNull("Mower 2 must not be null", mower2);
        assertEquals("Invalid position X for mower 2", 5, mower2.getPositionX());
        assertEquals("Invalid position Y for mower 2", 1, mower2.getPositionY());
        assertEquals("Invalid orientation for mower 2", Orientation.E, mower2.getOrientation());
    }
}
