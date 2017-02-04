package com.enderqura.ohub.events;
 
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;
 
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
 
public class JoinTitle implements Listener{
 
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {
                        PacketPlayOutTitle title = new PacketPlayOutTitle(EnumTitleAction.TITLE, ChatSerializer.a("{\"text\":\"Islands Realm\",\"color\":\"gold\",\"bold\":true}"), 20, 40, 20);
                        PacketPlayOutTitle subtitle = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, ChatSerializer.a("{\"text\":\"Has been released! Go Play!\",\"color\":\"dark_gray\"}"), 20, 40, 20);
                        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(title);
                        ((CraftPlayer) e.getPlayer()).getHandle().playerConnection.sendPacket(subtitle);
                }
        }
}
