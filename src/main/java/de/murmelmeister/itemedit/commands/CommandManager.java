package de.murmelmeister.itemedit.commands;

import de.murmelmeister.itemedit.ItemEdit;
import org.bukkit.command.TabExecutor;

import java.util.Objects;

public class CommandManager {

    private final ItemEdit instance = ItemEdit.getInstance();

    public void registerCommands() {

    }

    private void setCommand(String commandName, TabExecutor command) {
        Objects.requireNonNull(this.instance.getCommand(commandName)).setExecutor(command);
        Objects.requireNonNull(this.instance.getCommand(commandName)).setTabCompleter(command);
    }

}
