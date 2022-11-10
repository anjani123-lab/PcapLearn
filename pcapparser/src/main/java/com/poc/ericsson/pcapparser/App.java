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

public class App {

	public static void main(String[] args) {
		final List<JPacket> packetList = new ArrayList<JPacket>();
		String FILENAME = "C:\\Users\\ekaunka\\Downloads\\converted.pcap";
		StringBuilder errbuf = new StringBuilder();
		Pcap pcap = Pcap.openOffline(FILENAME, errbuf);

		pcap.loop(-1, new JPacketHandler<StringBuilder>() {

			@Override
			public void nextPacket(JPacket packet, StringBuilder errbuf) {

				if (packet.hasHeader(new Http())) {
					packetList.add(packet);
				}

			}
		}, errbuf);
		for (int i = 0; i < 20; i++) {
			JPacket jp = packetList.get(i);
			Long reqAck = jp.getHeader(new Tcp()).ack();
			Long reqTime = jp.getCaptureHeader().timestampInMicros();
			int srcPort = jp.getHeader(new Tcp()).source();
			for (int j = i + 1; j < 20; j++) {
				JPacket jo = packetList.get(j);
				Long resSeq = jo.getHeader(new Tcp()).seq();
				Long resTime = jo.getCaptureHeader().timestampInMicros();
				if (reqAck.equals(resSeq)) {
					System.out.println(" Source port :" + srcPort + " Timestamp diff :" + (resTime - reqTime));
				}
			}
		}

	}

}