package com.skymin;

import dev.waterdog.waterdogpe.plugin.Plugin;

import dev.waterdog.waterdogpe.event.defaults.PlayerLoginEvent;

public class XBoxAuth extends Plugin{
	
	private String kickmsg;
	
	@Override
	public void onEnable(){
		saveResource("config.yml");
		loadConfig();
		kickmsg = getConfig().getString("kick-massage");
		
		this.getProxy().getEventManager().subscribe(PlayerLoginEvent.class, this::onLogin);
	}
	
	public void onLogin(PlayerLoginEvent event){
		if(!event.getPlayer().getLoginData().isXboxAuthed()){
			event.setCancelReason(kickmsg);
		}
	}
	
}