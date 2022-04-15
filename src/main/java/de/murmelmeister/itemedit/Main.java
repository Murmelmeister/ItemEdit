package de.murmelmeister.itemedit;

import org.bukkit.plugin.java.JavaPlugin;

public abstract class Main extends JavaPlugin {

    private String version = "a1.0.0";
    private String author = "Murmelmeister";
    private String pluginName = "ItemEdit";
    private String prefix;


    public abstract void onDisable();

    public abstract void onEnable();

    public abstract void onLoad();

    public abstract void init();

    public void handleDisableMessage() {
        setBukkitMessage("§3" + this.getPluginName() + " §8» §7Plugin is§c disabled§7! §7Version: §e" + this.getVersion() + " §7by §b" + this.getAuthor());
    }

    public void handleEnableMessage() {
        setBukkitMessage("§3" + this.getPluginName() + " §8» §7Plugin is§a enabled§7! §7Version: §e" + this.getVersion() + " §7by §b" + this.getAuthor());
    }

    private void setBukkitMessage(String message) {
        this.getServer().getConsoleSender().sendMessage(message);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPluginName() {
        return pluginName;
    }

    public void setPluginName(String pluginName) {
        this.pluginName = pluginName;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
