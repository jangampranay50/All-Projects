package com.cg.demo.bean;


public class Mobile 
{
	SimCard simCard;
	
	public Mobile(SimCard simCard) {
		super();
		this.simCard = simCard;
	}

	public SimCard getSimCard() {
		return simCard;
	}

	public void setSimCard(SimCard simCard) {
		this.simCard = simCard;
	}

	public Mobile() {
		super();
	}

	public String getSimInfo()
	{
		return simCard.getSimInfo();
	}
}
