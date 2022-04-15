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
    }

    public void loadFile() {
        this.getConfig().getString("Prefix");
    }

    public File getFolder() {
        return folder;
    }

    public YamlConfiguration getConfig() {
        return config;
    }

}
