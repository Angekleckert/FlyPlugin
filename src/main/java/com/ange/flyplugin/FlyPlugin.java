package com.ange.flyplugin;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import com.ange.flyplugin.command.FlyCommand;
import com.ange.flyplugin.config.FlyConfig;
import lombok.Getter;

import java.util.ArrayList;

/**
 * Author: Ange
 * Version: 1.0
 */
public class FlyPlugin extends PluginBase {

    @Getter
    private String language;
    @Getter
    private String permission;
    @Getter
    private String prefix = "§7[§aFly§7] ";

    @Getter
    private FlyConfig flyConfig;
    @Getter
    private static FlyPlugin instance;

    @Getter
    private ArrayList<Player> flyPlayers = new ArrayList<>();

    @Override
    public void onEnable () {

        this.getServer().getCommandMap().register("fly", new FlyCommand("Fly", "Fly command"));

        this.flyConfig = new FlyConfig(this);
        this.flyConfig.createConfig();

        this.getLogger().info(getPrefix() + "§fSelecting permission...");

        this.permission = this.getFlyConfig().getPermission();

        this.getLogger().info(getPrefix() + "§fPermission §e" + getPermission() + "§f selected!!");

        this.getLogger().info(getPrefix() + "§fSelecting language...");

        this.language = this.getFlyConfig().getLanguage();

        this.getLogger().info(getPrefix() + "§fSelected language §e" + getLanguage());

        instance = this;
    }

    @Override
    public void onDisable () {
        this.getLogger().info(this.getPrefix() + "§fFly disabled!");
    }
}
