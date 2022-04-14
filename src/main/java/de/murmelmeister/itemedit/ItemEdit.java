package de.murmelmeister.itemedit;

import de.murmelmeister.itemedit.commands.CommandManager;

public final class ItemEdit extends Main {

    private static ItemEdit instance;

    private CommandManager commandManager;

    @Override
    public void onDisable() {
        handleDisableMessage();
    }

    @Override
    public void onEnable() {
        init();
        handleEnableMessage();
    }

    @Override
    public void onLoad() {
        setInstance(this);
    }

    @Override
    public void init() {
        setCommandManager(new CommandManager());
        commandManager.registerCommands();
    }

    public static ItemEdit getInstance() {
        return instance;
    }

    public static void setInstance(ItemEdit instance) {
        ItemEdit.instance = instance;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}
