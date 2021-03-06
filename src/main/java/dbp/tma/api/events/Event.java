package dbp.tma.api.events;

import java.util.ArrayList;
import java.util.List;

import dbp.tma.api.material.MaterialRegister;

public class Event {
	public static List<PartRegistrationEvent> PartRegistration = new ArrayList<PartRegistrationEvent>();
	public static List<PartModifcationEvent> PartModifcation = new ArrayList<PartModifcationEvent>();
	public static List<MaterialRegistrationEvent> MaterialRegistration = new ArrayList<MaterialRegistrationEvent>();
	public static List<MaterialModifcationEvent> MaterialModifcation = new ArrayList<MaterialModifcationEvent>();

	public static void listen(List event, BasicEvent call) {
		event.add(call);
	}
	
	public static void runEvents() {
		for (PartRegistrationEvent PartReg : PartRegistration)PartReg.event();
		for (PartModifcationEvent PartMod : PartModifcation)PartMod.event();
		for (MaterialRegistrationEvent MatReg : MaterialRegistration)MatReg.event();
		for (MaterialModifcationEvent MatMod : MaterialModifcation)MatMod.event();
		MaterialRegister.registerItems();
	}

}
