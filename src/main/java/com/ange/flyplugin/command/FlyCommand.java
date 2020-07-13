package com.ange.flyplugin.command;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.ange.flyplugin.FlyPlugin;
import com.ange.flyplugin.messages.Messages;

/**
 * Author: Ange
 * Version: 1.0
 */
public class FlyCommand extends Command {

    public FlyCommand (String name, String description) {
        super(name, description);
    }

    @Override
    public boolean execute (CommandSender commandSender, String s, String[] strings) {

        if (commandSender.isPlayer()) {
            Player player = (Player) commandSender;

            if (!player.hasPermission(FlyPlugin.getInstance().getPermission())) {
                player.sendMessage(Messages.NO_PERMISSION.getMessage());
                return false;
            }

            if (!FlyPlugin.getInstance().getFlyPlayers().contains(player)) {
                player.setAllowFlight(true);
                player.sendMessage(Messages.FLY_ENABLED.getMessage());
                FlyPlugin.getInstance().getFlyPlayers().add(player);
            } else {
                player.setAllowFlight(false);
                player.sendMessage(Messages.FLY_DISABLED.getMessage());
                FlyPlugin.getInstance().getFlyPlayers().remove(player);
            }

        }

        return true;
    }
}
