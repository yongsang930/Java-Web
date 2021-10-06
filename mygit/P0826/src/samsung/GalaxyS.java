package samsung;

public class GalaxyS {
	public static void main(String[] args) {
		GalaxyNote telecom = new GalaxyNote("°¶·°½ºS","±ôÀå", 10);
		
		telecom.powerOn();
		telecom.powerOff();
		telecom.callOn();
		telecom.callOff();
		telecom.sendMessage("Ä£±¸¾ß~ ³îÀÚ");
		telecom.receiveMessage("¿À±×·¦");
		
		telecom.turnOnDmb();
		telecom.channelChange(20);
		telecom.turnOffDmb();
		
		GalaxyNote telephone = new GalaxyNote("°¶·°½Ã³ëÆ®","½Ç¹ö", 20);
		telephone.penDrawing();
		telephone.penDrawingEnd();
		telephone.radioCome();
		telephone.radioTrue();
	}
}
