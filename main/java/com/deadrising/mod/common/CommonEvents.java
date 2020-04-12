package com.deadrising.mod.common;

import java.util.HashMap;
import java.util.UUID;

import com.deadrising.mod.utils.DiscordHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class CommonEvents {

	public static boolean replaceBricks = false;
	// public static boolean timerStarted = false;
	private static int ticks = 0;
	private static DiscordHandler discordHandler = DiscordHandler.getInstance();

	private static final HashMap<UUID, String> STATUS_MAP = new HashMap<>();




	@SubscribeEvent
	public void onServerJoin(FMLNetworkEvent.ClientConnectedToServerEvent event) {

		if (event.getManager().getRemoteAddress().toString().split("/")[0].equals("192.99.194.146:25565")) {
			discordHandler.setRichPresence("", "Playing on Undead Island", "cubgcurselogo_png", "DeadRizing", "US_png", "US");
		}
		if (event.getManager().getRemoteAddress().toString().split("/")[0].equals("")) {
			discordHandler.setRichPresence("", "Playing on ...", "D_png", "DeadRizing", "EU_png", "EU");
		}
	}

	@SubscribeEvent
	public void onServerLeave(FMLNetworkEvent.ClientDisconnectionFromServerEvent event) {
		discordHandler.setRichPresence("", "In the Main Menu", "cubgcurselogo_png", "DeadRizing");
	}
}
