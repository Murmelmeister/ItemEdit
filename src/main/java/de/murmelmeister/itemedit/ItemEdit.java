package de.murmelmeister.itemedit;

import de.murmelmeister.itemedit.commands.CommandManager;
import de.murmelmeister.itemedit.config.ConfigMessage;

public final class ItemEdit extends Main {

    private static ItemEdit instance;

    private CommandManager commandManager;

    private ConfigMessage configMessage;

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
        setConfigMessage(new ConfigMessage());
        setPrefix(configMessage.getConfig().getString("Prefix"));
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

    public ConfigMessage getConfigMessage() {
        return configMessage;
    }

    public void setConfigMessage(ConfigMessage configMessage) {
        this.configMessage = configMessage;
    }

}
