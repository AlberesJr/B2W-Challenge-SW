package com.b2w.challenge.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.b2w.challenge.service.impl.SWApiServiceImpl;
import com.b2w.challenge.util.Util;

@Component
public class ScheduledRequestUpdate {
	
	private final String TIME_ZONE = "America/Sao_Paulo";
	
	@Autowired
	private SWApiServiceImpl service;
	
	//Atualiza a lista da api do Star Wars a cada 6 horas
	//Para prevenção de possíveis atualizações
	@Scheduled(cron = "0 0 0,6,12,18,21 * * *", zone = TIME_ZONE)
	public void scheduleTaskUpdatePlanetList() {
		Util.planetsList = service.makeSWApiRequest();
	}

}
