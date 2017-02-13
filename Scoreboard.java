//Seperate plugin (Main Class)

//ChatColor.GOLD + "" + ChatColor.BOLD + 

package com.enderqura.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;

public class Main extends JavaPlugin implements Listener{
	static ArrayList<String> A = new ArrayList<String>();
	Scoreboard board;

	public void onEnable(){
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this, this);	
		
		scoreboard();
	}
	
	public void add(){
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
		
		Objective objective = board.registerNewObjective("Test", "Test2");
		objective.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD +"Oasis Factions");
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Team team = board.registerNewTeam("Team");
		team.setDisplayName(ChatColor.RED + "");
		

		int a = Bukkit.getOnlinePlayers().size();
		int c = Bukkit.getMaxPlayers();
		
		Score score = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "   "));
		score.setScore(16);
		
		Score score1 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Online Players"));
		score1.setScore(15);
		
		Score score2 = objective.getScore(Bukkit.getOfflinePlayer(a + " / " + c));
		score2.setScore(14);
		
		Score score3 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "  "));
		score3.setScore(13);
		
		Score score4 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Rank"));
		score4.setScore(12);
		
		Score score5 = objective.getScore(Bukkit.getOfflinePlayer("Owner"));
		score5.setScore(11);
		
		Score score6 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + " "));
		score6.setScore(10);
		
		Score score7 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Store"));
		score7.setScore(9);
		
		Score score8 = objective.getScore(Bukkit.getOfflinePlayer("store.oasisfactions.com"));
		score8.setScore(8);
		
		Score score9 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + ""));
		score9.setScore(7);
		
		Score score10 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Forums"));
		score10.setScore(6);
		
		Score score11 = objective.getScore(Bukkit.getOfflinePlayer("forums.oasisfactions.com"));
		score11.setScore(5);
		
		Score score12 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GRAY + "    "));
		score12.setScore(4);
		
		Score score13 = objective.getScore(Bukkit.getOfflinePlayer(ChatColor.GOLD + "" + ChatColor.BOLD + "Next Realm"));
		score13.setScore(3);
		
		Score score14 = objective.getScore(Bukkit.getOfflinePlayer("Islands Realm"));
		score14.setScore(2);
		
		A.clear();
		A.add("1");
		
		BukkitScheduler Scheduler = Bukkit.getServer().getScheduler();
		Scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				Integer i = A.size();
				if(i == 1) {
					objective.setDisplayName(Colors("&b&lOasis Factions"));
					A.add("A");
				}
				if(i == 2) {
					objective.setDisplayName(Colors("&5&lOasis Factions"));
					A.add("B");
				}
				if(i == 3) {
					objective.setDisplayName(Colors("&d&lOasis Factions"));
					A.add("C");
				}
				if(i == 3) {
					A.clear();
					A.add("1");
				}
			}
		}, 0, 5);
player.setScoreboard(board);
		
	}
	
	@EventHandler
	public void onjoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		this.add(p);
	}
	
	
		
}


