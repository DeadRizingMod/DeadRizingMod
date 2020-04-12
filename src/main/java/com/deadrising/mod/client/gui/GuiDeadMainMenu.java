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

public class GuiDeadMainMenu extends GuiDead {

    public static String designatedServerIP = Reference.SERVERIP_BEAVER;

    private GuiButton single, multi, community;
    
    private boolean playClicked;
    
    public GuiDeadMainMenu(){
        super();
        setUiTitle(I18n.format("gui.title.mainmenu"));
    }


    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX,mouseY,partialTicks);

        DeadRenderHelper.renderRectWithOutline(width / 2 - 75,3,150,34,0x22FFFFFF,0x22FFFFFF,1);

        DeadRenderHelper.renderCenteredTextWithShadow(I18n.format("gui.subtitle.status"),width / 2,5,0xFFFFFF);

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
        
        GlStateManager.pushMatrix();

        ScissorState.scissor(30, 0, width, height, true);

        float val = (float) (Math.sin(DeadRenderHelper.swing / 55) * 70);
        
        ItemStack head = ConfigHandler.ClientSide.HELMET;
        ItemStack chest = ConfigHandler.ClientSide.CHESTPLATE;
        ItemStack legs = ConfigHandler.ClientSide.LEGGINGS;
        ItemStack boots = ConfigHandler.ClientSide.BOOTS;
        ItemStack hand = ConfigHandler.ClientSide.lastMainItem;
        
        if(hand == null)
        {
        	hand = ItemStack.EMPTY;
        }
        else
        {
        	if(head == null)
        	{
        		head = ItemStack.EMPTY;
        	}
        	else
        	{
        		if(chest == null)
        		{
        			chest = ItemStack.EMPTY;
        		}
        		else
        		{
        			if(legs == null)
        			{
        				legs = ItemStack.EMPTY;
        			}
        			else
        			{
        				if(boots == null)
        				{
        					boots = ItemStack.EMPTY;
        				}
        				else
        				{
        			        DeadRenderHelper.renderPlayer(width / 2 +150,height / 2 + 155,150, -45, head, chest, legs, boots, hand);
        				}
        			}
        		}
        	}
        }
        

        ScissorState.endScissor();

        GlStateManager.popMatrix();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        super.actionPerformed(button);
        
        switch(button.id){
            case BUTTON_LINK_DISCORD:
                this.openURL(Reference.LINK_DISCORD);
                break;
            case BUTTON_LINK_WEBSITE:
                this.openURL(Reference.LINK_WEBSITE);
                break;
            case BUTTON_BEAVER:
                designatedServerIP = Reference.SERVERIP_BEAVER;
                mc.displayGuiScreen(new GuiDeadMainMenu());
                break;
            case BUTTON_KANGAROO:
                designatedServerIP = Reference.SERVERIP_KANGAROO;
                mc.displayGuiScreen(new GuiDeadMainMenu());
                break;
            case BUTTON_SINGLEPLAYER:
                mc.displayGuiScreen(new GuiWorldSelection(this));
                break;
            case BUTTON_MULTIPLAYER:
                mc.displayGuiScreen(new GuiServerBrowser());
                break;
            case BUTTON_NEWS:

                break;
            case BUTTON_SETTINGS:
                mc.displayGuiScreen(new GuiOptions(this,mc.gameSettings));
                break;
            case BUTTON_QUIT:
                mc.shutdown();
                break;
            case BUTTON_PLAY:
            	this.playClicked = !this.playClicked;
                break;
        }

    }

    /**
     * Initialize GUI - Initialize the GUI
     */
    public void initGui() {

        this.buttonList.add(new GuiButtonDead(BUTTON_LINK_DISCORD,this.width - 83,3,80,15,I18n.format("gui.button.discord")));
        this.buttonList.add(new GuiButtonDead(BUTTON_LINK_WEBSITE,this.width - 83,22,80,15,I18n.format("gui.button.website"))
				.setDisabled(true));

        //this.buttonList.add(new GuiButtonDead(BUTTON_NEWS,this.width - 83,height - 18,80,15,I18n.format("gui.button.news"))
				//.setDisabled(true));

        this.buttonList.add(new GuiButtonDead(BUTTON_NEWS, 25, height - 60, 80, 15, I18n.format("gui.button.news")));
        this.buttonList.add(new GuiButtonDead(BUTTON_SETTINGS,25,height - 40,80,15,I18n.format("gui.button.settings")));
        this.buttonList.add(new GuiButtonDead(BUTTON_QUIT, 25, height - 20, 80, 15, I18n.format("gui.button.quit")));
        this.buttonList.add(new GuiButtonDead(BUTTON_PLAY,5,this.height - 120,120,30,I18n.format("gui.button.play"))
                .setScale(2)
                .setYOffset(-3)
                .setImage(new ResourceLocation(Reference.MOD_ID,"textures/gui/menu/play.png")));
            
            this.multi = new GuiButtonDead(BUTTON_MULTIPLAYER,130,height - 125,120,15,I18n.format("gui.button.multiplayer"));
            this.community = new GuiButtonDead(BUTTON_KANGAROO,130,height - 105,120,15,I18n.format("gui.button.kangaroo")).setDisabled(true);
            this.single = new GuiButtonDead(BUTTON_SINGLEPLAYER, 130, height - 85,120,15,I18n.format("gui.button.singleplayer"));
            
            this.buttonList.add(multi);
            this.buttonList.add(community);
            this.buttonList.add(single);
            
            //Official
            //Community
            //Singleplayer
            
        
    }
}