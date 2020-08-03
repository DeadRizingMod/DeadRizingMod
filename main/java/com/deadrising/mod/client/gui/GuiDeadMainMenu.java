package com.deadrising.mod.client.gui;

import java.io.IOException;

import com.deadrising.mod.Reference;
import com.deadrising.mod.client.gui.api.GuiButtonDead;
import com.deadrising.mod.client.gui.utilities.DeadRenderHelper;
import com.deadrising.mod.client.gui.utilities.ScissorState;
import com.deadrising.mod.utils.handlers.ConfigHandler;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiWorldSelection;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.ResourceLocation;

import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.gui.*;
import java.io.*;
import net.minecraft.client.resources.*;

public class GuiDeadMainMenu extends GuiDead
{
    public String designatedServerIP;
    private static float introFade;
    private static float introFadeFirst;
    private static boolean hasSeenIntro;
    private GuiButton single, multi, community;
    
    private boolean playClicked;
    public static final ResourceLocation MENU_LOGO;
    
    public static boolean hasSeenIntro() {
        return GuiDeadMainMenu.hasSeenIntro;
    }
    
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        this.drawIntro();
        
        if(playClicked)
        {
        	single.visible = true;
        	multi.visible = true;
        	community.visible = true;
        }
        else
        {
        	single.visible = false;
        	multi.visible = false;
        	community.visible = false;
        }
    }

    
    
    public void drawIntro() {
    	
    	DeadRenderHelper.renderRectWithOutline(52, this.height - 157, 100, 150, 1426063360, 1140850688, 1);
        DeadRenderHelper.renderImage(20.0, this.height - 235, new ResourceLocation("deadrising", "textures/gui/logo.png"), 165.0, 43.5);
        DeadRenderHelper.renderCenteredTextScaledWithShadow("v1.34.1", 102, this.height - 20, 16777215, 1.0);
        if (GuiDeadMainMenu.introFadeFirst <= 0.0f) {
            if (GuiDeadMainMenu.introFade > 0.0f) {
                GuiDeadMainMenu.introFade -= 0.02f;
                GuiDeadMainMenu.hasSeenIntro = false;
            }
            else {
                GuiDeadMainMenu.hasSeenIntro = true;
            }
        }
        else {
            GuiDeadMainMenu.hasSeenIntro = false;
        }
        if (GuiDeadMainMenu.introFadeFirst > 0.0f) {
            GuiDeadMainMenu.introFadeFirst -= 0.025f;
        }
        if (!GuiDeadMainMenu.hasSeenIntro) {
            DeadRenderHelper.renderRect(0, 0, this.width, this.height, 2565927, GuiDeadMainMenu.introFade);
            DeadRenderHelper.renderImageCenteredTransparent(this.width / 2, this.height / 2, GuiDeadMainMenu.MENU_LOGO, 296.0, 80.0, GuiDeadMainMenu.introFade);
            DeadRenderHelper.renderRect(0, 0, this.width, this.height, 2565927, GuiDeadMainMenu.introFadeFirst);
            
        }
    }
    
    protected void actionPerformed(final GuiButton button) throws IOException {
        super.actionPerformed(button);
        switch (button.id) {
            case 200: {
                this.openURL("https://discord.gg/gmcMRRk");
                break;
            }
            case 201: {
                this.openURL("https://www.cubgmc.net/");
                break;
            }
            case 207: {
                this.mc.displayGuiScreen((GuiScreen)new GuiWorldSelection((GuiScreen)this));
                break;
            }
            case 208: {
                this.mc.displayGuiScreen((GuiScreen)new GuiMultiplayer((GuiScreen)this));
            }
            case 206: {
                this.mc.displayGuiScreen((GuiScreen)new GuiOptions((GuiScreen)this, this.mc.gameSettings));
                break;
            }
            case 209: {
                this.mc.shutdown();
                break;
            }
            case 210: {
            	mc.displayGuiScreen(new GuiServerBrowser());
                break;
            }
            case 204: {
            	this.playClicked = !this.playClicked;
                break;
            }
        }
    }
    
    public void initGui() {
        this.designatedServerIP = "server.cubgmc.net";
        this.buttonList.add(new GuiButtonDead(204, 42, this.height - 187, 120, 30, I18n.format("gui.button.play", new Object[0])).setScale(2.0).setYOffset(-3).setImage(new ResourceLocation("deadrising", "textures/gui/menu/play.png")));
            this.buttonList.add(new GuiButtonDead(200, 62, this.height - 130, 80, 15, I18n.format("gui.button.discord", new Object[0])));
            this.buttonList.add(new GuiButtonDead(201, 62, this.height - 110, 80, 15, I18n.format("gui.button.website", new Object[0])));
            this.buttonList.add(new GuiButtonDead(206, 62, this.height - 90, 80, 15, I18n.format("gui.button.settings", new Object[0])));
            this.buttonList.add(new GuiButtonDead(209, 62, this.height - 70, 80, 15, I18n.format("gui.button.quit", new Object[0])));
            this.multi = new GuiButtonDead(BUTTON_MULTIPLAYER,155,height - 155,120,15,I18n.format("gui.button.server"));
            this.community = new GuiButtonDead(BUTTON_JOINOFFSERV,155,height - 135,120,15,I18n.format("gui.button.community")).setDisabled(true);
            this.single = new GuiButtonDead(BUTTON_SINGLEPLAYER, 155, height - 115,120,15,I18n.format("gui.button.singleplayer"));
            
            this.buttonList.add(multi);
            this.buttonList.add(community);
            this.buttonList.add(single);
    }
    
    protected void keyTyped(final char typedChar, final int keyCode) throws IOException {
    }
    
    static {
        MENU_LOGO = new ResourceLocation("deadrising", "textures/gui/logo.png");
        GuiDeadMainMenu.introFade = 2.0f;
        GuiDeadMainMenu.introFadeFirst = 1.0f;
        GuiDeadMainMenu.hasSeenIntro = false;
    }
}