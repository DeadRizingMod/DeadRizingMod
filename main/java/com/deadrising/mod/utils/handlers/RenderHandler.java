package com.deadrising.mod.utils.handlers;

import com.deadrising.mod.entity.EntityCrawler;
import com.deadrising.mod.entity.EntityDRZombie;
import com.deadrising.mod.entity.render.RenderCrawler;
import com.deadrising.mod.entity.render.RenderDRZombie;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler 
{
	public static void registerEntityRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityDRZombie.class, new IRenderFactory<EntityDRZombie>()
		{
			@Override
			public Render<? super EntityDRZombie> createRenderFor(RenderManager manager) 
			{
				return new RenderDRZombie(manager);
			}
		});
		
		RenderingRegistry.registerEntityRenderingHandler(EntityCrawler.class, new IRenderFactory<EntityCrawler>()
		{
			@Override
			public Render<? super EntityCrawler> createRenderFor(RenderManager manager) 
			{
				return new RenderCrawler(manager);
			}
		});
		
	}
}
