package com.deadrising.mod.client.gui;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.deadrising.mod.Reference;
import com.deadrising.mod.client.gui.api.GuiButtonDead;
import com.deadrising.mod.client.gui.utilities.DeadRenderHelper;
import com.deadrising.mod.utils.handlers.ConfigHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiDisconnected;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.multiplayer.GuiConnecting;
import net.minecraft.client.multiplayer.ServerAddress;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerLoginClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.network.EnumConnectionState;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.handshake.client.C00Handshake;
import net.minecraft.network.login.client.CPacketLoginStart;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiDeadStats extends GuiScreen
{
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();

        DeadRenderHelper.renderCenteredTextScaledWithShadow("Player Kills - " + TextFormatting.RED + "" + TextFormatting.BOLD + ConfigHandler.ClientSide.PlayerKills, this.width / 2, this.height / 2, 16777215, 1.0);
        DeadRenderHelper.renderCenteredTextScaledWithShadow("Zombie Kills - " + TextFormatting.RED + "" + TextFormatting.BOLD + ConfigHandler.ClientSide.ZombieKills, this.width / 2, this.height / 2 + 20, 16777215, 1.0);
        DeadRenderHelper.renderCenteredTextScaledWithShadow("Deaths - " + TextFormatting.RED + "" + TextFormatting.BOLD + ConfigHandler.ClientSide.Deaths, this.width / 2, this.height / 2 - 20, 16777215, 1.0);
        super.drawScreen(mouseX, mouseY, partialTicks);
	}
	
	@Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
        
        switch(button.id){
            case 0:
                mc.displayGuiScreen(new GuiDeadMainMenu());
                break;
        }

    }
	
	@Override
    public void initGui()
    {
        this.buttonList.clear();
        this.buttonList.add(new GuiButtonDead(0, width / 2 - 150, this.height / 4 + 140 + 12, 300, 20, "Back"));
    }
}
