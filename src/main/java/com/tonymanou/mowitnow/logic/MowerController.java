package com.tonymanou.mowitnow.logic;

import com.tonymanou.mowitnow.model.Command;
import com.tonymanou.mowitnow.model.Garden;
import com.tonymanou.mowitnow.model.Mower;
import com.tonymanou.mowitnow.model.Orientation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MowerController {

    private static final Logger LOGGER = LogManager.getLogger(MowerController.class);

    private final List<Mower> mowers = new ArrayList<>();
    private final Garden garden = new Garden(0, 0);
    private int nextMowerId = 1;

    /**
     * Main.
     * <p/>
     * The garden is reset and all previously existing mowers are removed.
     *
     * @param commands list of commands to process
     */
    public void process(List<String> commands) {
        if (commands == null) {
            throw new IllegalArgumentException("commands must not be null");
        } else if (commands.isEmpty()) {
            throw new IllegalArgumentException("Command list must contain at least one line for garden's creation");
        }

        Mower currentMower = null;
        int counter = 0;
        mowers.clear();

        for (String line : commands) {
            String[] args = line.split("\\s");

            try {
                if (counter == 0) {
                    // First line, creation of the garden...
                    initializeGarden(args);
                } else if (counter % 2 == 1) {
                    // Every odd line, a new mower is created...
                    currentMower = createMower(args);
                    mowers.add(currentMower);
                } else {
                    // Every even line, actions are given to the newly created mower...
                    for (Command command : parseMowerCommands(args)) {
                        processCommand(command, currentMower);
                    }
                    currentMower = null;
                }
            } catch (Exception e) {
                throw new IllegalStateException("Cannot parse line " + counter + " of commands", e);
            }

            counter++;
        }

        if (currentMower != null) {
            throw new IllegalArgumentException("Missing an additional command line for mower " + currentMower.getId());
        }
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public Garden getGarden() {
        return garden;
    }

    private void initializeGarden(String[] args) {
        LOGGER.debug("Initializing garden...");
        if (args.length < 2) {
            throw new IllegalArgumentException("Initializing the garden requires at least 2 parameters");
        }
        try {
            int sizeX = Integer.parseInt(args[0]) + 1;
            int sizeY = Integer.parseInt(args[1]) + 1;
            garden.setSizeX(sizeX);
            garden.setSizeY(sizeY);
        } catch (Exception e) {
            throw new IllegalStateException("Invalid garden parameters", e);
        }
    }

    private Mower createMower(String[] args) {
        LOGGER.debug("Creating mower {}...", nextMowerId);
        if (args.length < 3) {
            throw new IllegalArgumentException("Creating a mower requires at least 3 parameters");
        }
        try {
            int x = Integer.parseInt(args[0]);
            int y = Integer.parseInt(args[1]);
            Orientation orientation = Orientation.valueOf(args[2]);
            return new Mower(nextMowerId++, x, y, orientation);
        } catch (Exception e) {
            throw new IllegalStateException("Invalid mower parameters", e);
        }
    }

    private List<Command> parseMowerCommands(String[] args) {
        LOGGER.debug("Parsing mower commands...");
        if (args.length < 1) {
            throw new IllegalArgumentException("Parsing mower commands requires at least 1 parameter");
        }
        List<Command> commands = new LinkedList<>();
        for (int i = 0, length = args[0].length(); i < length; i++) {
            String name = String.valueOf(args[0].charAt(i));
            Command command;
            try {
                command = Command.valueOf(name);
            } catch (IllegalArgumentException e) {
                throw new IllegalStateException("Cannot parse '" + name + "' (at position " + (i + 1) + ") into a mower command");
            }
            commands.add(command);
        }
        return commands;
    }

    private void processCommand(Command command, Mower mower) {
        switch (command) {
            case A:
                boolean moved = mower.moveForward(garden);
                LOGGER.debug("Mower {} tried to move forward in the garden, success={}", mower.getId(), moved);
                break;
            case G:
                mower.turnToLeft();
                LOGGER.debug("Mower {} turned left", mower.getId());
                break;
            case D:
                mower.turnToRight();
                LOGGER.debug("Mower {} turned right", mower.getId());
                break;
        }
    }
}
