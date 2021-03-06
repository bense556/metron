/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.metron.pcap;

import java.lang.invoke.MethodHandles;
import java.util.Comparator;
import org.krakenapps.pcap.packet.PcapPacket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PcapPacketComparator implements Comparator<PcapPacket> {
  private static final Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

  @Override
  public int compare(PcapPacket p1, PcapPacket p2) {
    long p1time = p1.getPacketHeader().getTsSec() * 1000000L + p1.getPacketHeader().getTsUsec();
    long p2time = p2.getPacketHeader().getTsSec() * 1000000L + p2.getPacketHeader().getTsUsec();
    LOG.debug("p1time: {} p2time: {}", p1time, p2time);
    return Long.compare(p1time, p2time);
  }
}
