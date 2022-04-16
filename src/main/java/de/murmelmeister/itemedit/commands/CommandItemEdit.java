package de.murmelmeister.itemedit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Objects;

public class CommandItemEdit extends Commands {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender.hasPermission(Objects.requireNonNull(this.configMessage.getConfig().getString("Permissions.ItemEdit.Command"))))) {
            setSendMessage(sender, this.configMessage.getConfig().getString("NoPermissions"));
            return true;
        }

        if (args.length == 0) {

            setSyntaxErrorMessage(sender);

        } else if (args.length == 1) {

            if (args[0].equalsIgnoreCase("reload")) { // test

                if (!(sender.hasPermission(Objects.requireNonNull(this.configMessage.getConfig().getString("Permissions.ItemEdit.Reload"))))) {
                    setSendMessage(sender, this.configMessage.getConfig().getString("NoPermissions"));
                    return true;
                }

                this.configMessage.createFile();
                setSendMessage(sender, this.configMessage.getConfig().getString("ItemEdit.Message.Reload"));

            } else {
                setSyntaxErrorMessage(sender);
            }


        } else {
            setSyntaxErrorMessage(sender);
        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return null;
    }

    private void setSyntaxErrorMessage(@NotNull CommandSender sender) {
        if (sender.hasPermission(Objects.requireNonNull(this.configMessage.getConfig().getString("Permissions.ItemEdit.Author")))) {
            setSendMessage(sender, " ");
            setSendMessage(sender, "#999999This plugin was created by #09add3" + this.instance.getAuthor());
            setSendMessage(sender, "#999999Plugin version: #09add3" + this.instance.getVersion());
            setSendMessage(sender, " ");
        }
        setSendMessage(sender, "#999999Syntax: #ff0000/itemedit reload "); // TODO: add more commands
    }

}
