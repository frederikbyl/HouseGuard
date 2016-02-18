package com.houseguard.listener;

import org.pcap4j.core.PacketListener;
import org.pcap4j.packet.Packet;
import org.pcap4j.util.ByteArrays;
import org.pcap4j.util.MacAddress;

import com.houseguard.listener.processor.MacAddressProcessor;
import com.houseguard.listener.processor.MacAddressType;

public class HouseGuardPacketListener implements PacketListener {

	private MacAddressProcessor processor = new MacAddressProcessor();

	@Override
	public void gotPacket(Packet packet) {
		
		
			
			String hexPacket = ByteArrays.toHexString(packet.getRawData(), "");
	
			//Probe request
			if(hexPacket.startsWith("40")) {
				
				//MacAddress macAddress = ByteArrays.getMacAddress(packet.getRawData(), 4);
				//System.out.println("Probe Request DESTINATION: "+ByteArrays.toHexString(macAddress.getAddress(), ":"));
				//processor.process(ByteArrays.toHexString(macAddress.getAddress(), ":"), MacAddressType.DESTINATION);
				MacAddress macAddress2 = ByteArrays.getMacAddress(packet.getRawData(), 10);
				//System.out.println("Probe Request SOURCE: "+ByteArrays.toHexString(macAddress2.getAddress(), ":"));
				try {
					processor.process(ByteArrays.toHexString(macAddress2.getAddress(), ":"), MacAddressType.SOURCE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
//		

	}

}
