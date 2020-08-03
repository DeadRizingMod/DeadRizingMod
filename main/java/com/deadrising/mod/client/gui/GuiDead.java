package com.deadrising.mod.client.gui;

import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import com.deadrising.mod.client.gui.api.GuiContainer;
import com.deadrising.mod.client.gui.utilities.DeadRenderHelper;

import java.util.*;
import org.lwjgl.util.*;
import org.lwjgl.util.Color;

import java.awt.*;
import java.io.*;
import java.net.*;
import net.minecraft.client.*;
import net.minecraftforge.fml.client.*;
import net.minecraft.client.multiplayer.*;

public class GuiDead extends GuiScreen
{
    protected ArrayList<GuiContainer> guiContainers;
    public static final ResourceLocation menuBackground;
    public final int BUTTON_LINK_DISCORD = 200;
    public final int BUTTON_LINK_WEBSITE = 201;
    public final int BUTTON_PLAY = 204;
    public final int BUTTON_NEWS = 205;
    public final int BUTTON_SETTINGS = 206;
    public final int BUTTON_SINGLEPLAYER = 207;
    public final int BUTTON_MULTIPLAYER = 210;
    public final int BUTTON_QUIT = 209;
    public final int BUTTON_JOINOFFSERV = 208;
    
    public GuiDead() {
        this.guiContainers = new ArrayList<GuiContainer>();
    }
    
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        DeadRenderHelper.renderImageCentered(this.width / 2, 0.0, GuiDead.menuBackground, this.width, this.height);
        GlStateManager.color(1.0f, 1.0f, 1.0f);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    
    public void addContainer(final GuiContainer container) {
        container.initGui();
        this.guiContainers.add(container);
    }
    
    public void updateContainers() {
        for (final GuiContainer gui : this.guiContainers) {
            gui.updateScreen();
        }
    }
    
    public GuiContainer getContainer(final int containerID) {
        for (final GuiContainer cont : this.guiContainers) {
            if (cont.containerID == containerID) {
                return cont;
            }
        }
        return null;
    }
    
    private static final String pad(final String s) {
        return (s.length() == 1) ? ("0" + s) : s;
    }
    
    public int toHex(final Color color) {
        final String alpha = pad(Integer.toHexString(color.getAlpha()));
        final String red = pad(Integer.toHexString(color.getRed()));
        final String green = pad(Integer.toHexString(color.getGreen()));
        final String blue = pad(Integer.toHexString(color.getBlue()));
        final String hex = "0x" + alpha + red + green + blue;
        return Integer.parseInt(hex, 16);
    }
    
    public void openURL(final String givenURL) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URI(givenURL));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            catch (URISyntaxException e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public void joinServer(final String givenIP, final boolean isLan) {
        if (!(Minecraft.getMinecraft().currentScreen instanceof GuiConnecting)) {
            FMLClientHandler.instance().setupServerList();
            FMLClientHandler.instance().connectToServer(Minecraft.getMinecraft().currentScreen, new ServerData("Server", givenIP, isLan));
        }
    }
    
    static {
        menuBackground = new ResourceLocation("deadrising", "textures/gui/menu/background" + (int)(Math.random() * 4.0) + ".png");
    }
}