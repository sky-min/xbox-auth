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
		
		proxy.getEventManager().subscribe(PlayerLoginEvent.class, this::onLogin);
	}
	
	public void onLogin(PlayerLoginEvent ev){
		if(!ev.getPlayer().getLoginData().isXboxAuthed()){
			ev.setCancelReason(kickmsg);
		}
	}
	
}