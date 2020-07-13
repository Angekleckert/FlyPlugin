package com.ange.flyplugin.config;

import cn.nukkit.utils.Config;
import com.ange.flyplugin.FlyPlugin;

import java.io.File;

/**
 * Author: Ange
 * Version: 1.0
 */
public class FlyConfig {

    private final FlyPlugin PLUGIN;
    private File file;
    private Config config;

    public FlyConfig (FlyPlugin plugin) {
        this.PLUGIN = plugin;
        this.file = new File(plugin.getDataFolder(), "config.yml");
        this.config = new Config(this.file, Config.YAML);
    }

    public void createConfig () {
        addDefault("permission", "commands.fly");
        addDefault("language", "deu/eng/rus/span");
    }

    public String getPermission () {
        return this.config.get("permission") != null ? this.config.getString("permission") : "commands.fly";
    }

    public String getLanguage () {
        String lang = this.config.getString("language") != null ? this.config.getString("language") : "eng";

        switch (lang) {
            case "eng":
            case "deu":
            case "rus":
            case "span":
                return lang;
            default:
                this.PLUGIN.getLogger().warning(PLUGIN.getPrefix() + "§cInvalid language, selected §eEnglish");
                this.PLUGIN.getLogger().warning(PLUGIN.getPrefix() + "Languages:\ndeu - German\neng - English\nrus - Russian\nspan - espanol");
                return "eng";
        }

    }

    public void addDefault (String path, Object object) {
        if (!this.config.exists(path)) {
            this.config.set(path, object);
            this.config.save(this.file);
        }
    }

}
