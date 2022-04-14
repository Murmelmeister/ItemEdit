package de.murmelmeister.itemedit.commands;

import de.murmelmeister.itemedit.ItemEdit;
import de.murmelmeister.itemedit.utils.HexColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

public abstract class Commands implements TabExecutor {

    protected ItemEdit instance = ItemEdit.getInstance();

    protected void setSendMessage(CommandSender sender, String message) {
        sender.sendMessage(this.instance.getPrefix() + HexColor.format(message));
    }

}
