package de.murmelmeister.itemedit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CommandItemEdit extends Commands {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender.hasPermission("itemedit.command.itemedit"))) {
            setSendMessage(sender, "#ff0000You don't have the permission to do that.");
            return true;
        }

        setSendMessage(sender, " ");
        setSendMessage(sender, "#999999This plugin was created by #09add3" + this.instance.getAuthor());
        setSendMessage(sender, "#999999Plugin version: #09add3" + this.instance.getVersion());
        setSendMessage(sender, " ");

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }

}
