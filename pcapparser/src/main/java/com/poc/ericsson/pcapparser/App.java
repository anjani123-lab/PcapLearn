package com.poc.ericsson.pcapparser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jnetpcap.Pcap;
import org.jnetpcap.packet.JPacket;
import org.jnetpcap.packet.JPacketHandler;
import org.jnetpcap.protocol.network.Arp;
import org.jnetpcap.protocol.tcpip.Http;
import org.jnetpcap.protocol.tcpip.Tcp;

import com.poc.ericsson.pcapparser.modelPojo.AdmPojo;

public class App {

	public static void main(String[] args) {
		final List<JPacket> packetList = new ArrayList<JPacket>();
		AdmPojo adms= new AdmPojo();
		String FILENAME = "C:\\Users\\ekaunka\\Downloads\\converted.pcap";
		StringBuilder errbuf = new StringBuilder();
		List<Object> poj=new ArrayList<>();
		Pcap pcap = Pcap.openOffline(FILENAME, errbuf);
		
		pcap.loop(-1, new JPacketHandler<StringBuilder>() {

			@Override
			public void nextPacket(JPacket packet, StringBuilder errbuf) {

				if (packet.hasHeader(new Http())) {
					packetList.add(packet);
				}

			}
		}, errbuf);
		for (int i = 0; i < packetList.size(); i++) {
			JPacket jp = packetList.get(i);
			Long reqAck = jp.getHeader(new Tcp()).ack();
			Long reqTime = jp.getCaptureHeader().timestampInMicros();
			int srcPort = jp.getHeader(new Tcp()).source();
			int srcDesPort = jp.getHeader(new Tcp()).destination();
			for (int j = i + 1; j < packetList.size(); j++) {
				JPacket jo = packetList.get(j);
				Long resSeq = jo.getHeader(new Tcp()).seq();
				Long resTime = jo.getCaptureHeader().timestampInMicros();
				if (reqAck.equals(resSeq)) {
					AdmPojo adm = new AdmPojo();
					adm.setReq_ackno_no(reqAck);
					adm.setReq_seque_no(jp.getHeader(new Tcp()).seq());
					poj.add(adm);
					System.out.println("Request Source port =" + srcPort + " || Request Destination port = "
							+ srcDesPort + " || Response Destination Port =" + jo.getHeader(new Tcp()).destination()
							+ " || Timestamp diff :" + (resTime - reqTime));
				}
			}
		}
//		for(int i=0;i<10;i++) {
//			JPacket no=packetList.get(i);
//			Long req_ack=no.getHeader(new Tcp()).ack();
//			adm.setReq_ackno_no(req_ack);
//		}
		
	}

}