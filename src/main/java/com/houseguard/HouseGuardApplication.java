package com.houseguard;

import java.util.List;

import org.pcap4j.core.NotOpenException;
import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapHandle.BlockingMode;
import org.pcap4j.core.PcapNativeException;
import org.pcap4j.core.PcapNetworkInterface;
import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.namednumber.DataLinkType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.houseguard.listener.HouseGuardPacketListener;

@SpringBootApplication
public class HouseGuardApplication {

    
    public static void main(String[] args) throws PcapNativeException, NotOpenException, InterruptedException  {
        SpringApplication.run(HouseGuardApplication.class, args);

    	int snaplen = 1024 * 1024; 
    	int timeout = 30 * 1000;
        
        List<PcapNetworkInterface> list = Pcaps.findAllDevs();
        
        PcapNetworkInterface test = list.get(0);
        PcapHandle handle = test.openLive(snaplen, PromiscuousMode.PROMISCUOUS, timeout);
        System.out.println(handle.listDatalinks().toString());
        handle.setBlockingMode(BlockingMode.NONBLOCKING);
        handle.setDlt(DataLinkType.IEEE802_11);
        HouseGuardPacketListener packetListener = new HouseGuardPacketListener();
        handle.loop(300000,packetListener);
        
       
     	
        
    }
}
