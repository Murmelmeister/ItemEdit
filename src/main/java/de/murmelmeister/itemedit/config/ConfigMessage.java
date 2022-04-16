package de.murmelmeister.itemedit.config;

import de.murmelmeister.itemedit.utils.HexColor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigMessage {

    private final File folder = new File("plugins//ItemEdit//");
    private File file;
    private YamlConfiguration config;

    public ConfigMessage() {
        createFile();
        saveFile();
    }

    public void createFile() {
        if(!(this.folder.exists()))
            this.folder.mkdir();

        this.file = new File(this.getFolder(), "message.yml");

        if(!(this.file.exists())) {
            try {
                this.file.createNewFile();
                this.config = YamlConfiguration.loadConfiguration(file);
                createLoadFile();
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.config = YamlConfiguration.loadConfiguration(file);
        loadFile();
    }

    public void saveFile() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createLoadFile() {
        this.getConfig().set("Prefix", HexColor.format("#00Aff0ItemEdit #444444» §r"));
        this.getConfig().set("NoPermissions", HexColor.format("#ff0000You don't have the permission to do that."));
        this.getConfig().set("Permissions.ItemEdit.Command", "itemedit.command.itemedit");
        this.getConfig().set("Permissions.ItemEdit.Author", "itemedit.command.itemedit.author");
        this.getConfig().set("Permissions.ItemEdit.Reload", "itemedit.command.itemedit.reload");
        this.getConfig().set("ItemEdit.Message.Reload", HexColor.format("#00ff00The configuration has been reloaded."));
    }

    public void loadFile() {
        this.getConfig().getString("Prefix");
        this.getConfig().getString("NoPermissions");
        this.getConfig().getString("Permissions.ItemEdit.Command");
        this.getConfig().getString("Permissions.ItemEdit.Author");
        this.getConfig().getString("Permissions.ItemEdit.Reload");
        this.getConfig().getString("ItemEdit.Message.Reload");
    }

    public File getFolder() {
        return folder;
    }

    public File getFile() {
        return file;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

}
