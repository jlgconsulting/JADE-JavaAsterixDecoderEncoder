/* 
* Created by dan-geabunea on 4/19/2016.
* This code is the property of JLG Consulting. Please
* check the license terms for this product to see under what
* conditions you can use or modify this source code.
*/
package jlg.jade.test.asterix.cat062;

import jlg.finalframe.FinalFrameReader;
import jlg.jade.asterix.AsterixDataBlock;
import jlg.jade.asterix.AsterixRecord;
import jlg.jade.example.AsterixDecoder;
import jlg.jade.test.utils.TestHelper;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.Description;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.BitSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Cat062LargeSampleTest {
    @Test
    public void when_file_is_used_as_input_should_decode_cat_062_message_from_larger_sample() throws IOException {
        //arrange
        int receivedBytes;

        AsterixDecoder decoder = new AsterixDecoder(62, 65);
        try (InputStream is = TestHelper.getFileInputStreamFromResource("final_frame_062_30min.ff")) {
            FinalFrameReader ffReader = new FinalFrameReader();
            receivedBytes = readFileToEnd(decoder, is, ffReader);
        }

        //assert
        int expectedBytes = 2725638;
        assertEquals(expectedBytes, receivedBytes);
        assertEquals(34957, decoder.getNbOfDataBlocks().get(62).intValue());
    }

    @Test
    public void
    when_file_is_used_as_input_and_final_frame_packet_is_large_should_decode_cat_062_message_from_larger_sample()
            throws IOException {
        //arrange
        int receivedBytes;

        AsterixDecoder decoder = new AsterixDecoder(62);
        try (InputStream is = TestHelper.getFileInputStreamFromResource("final_frame_062_065_large_packet_30min.ff")) {
            FinalFrameReader ffReader = new FinalFrameReader();
            receivedBytes = readFileToEnd(decoder, is, ffReader);
        }

        //assert
        int expectedBytes = 3003761;
        assertEquals(expectedBytes, receivedBytes);
    }


    @Test
    @Ignore("Can only be executed if an Asterix sender is feeding the decoder")
    public void
    when_upd_unicast_is_used_as_input_and_datagram_is_large_should_decode_cat062_messages_from_larger_sample() throws
            IOException, InterruptedException {
        //arrange
        final int PORT = 3001;
        final int MAX_PACKET_SIZE = 65507;
        final int TIMEOUT = 20000;


        //act
        AsterixDecoder decoder = new AsterixDecoder(62);
        byte[] networkBuffer = new byte[MAX_PACKET_SIZE];
        int receivedDatagrams = 0;
        int receivedBytes = 0;
        try (DatagramSocket client = new DatagramSocket(PORT)) {
            client.setSoTimeout(TIMEOUT);
            DatagramPacket packet = new DatagramPacket(networkBuffer, networkBuffer.length);
            while (true) {
                client.receive(packet);
                List<AsterixDataBlock> dataBlocks = decoder.decode(networkBuffer, 0, packet.getLength());
                for (AsterixDataBlock dataBlock : dataBlocks) {
                   for (AsterixRecord rec : dataBlock.getRecords()){
                       System.out.println("Decoded new record");
                   }
                }

                //accumulate and print info
                receivedDatagrams++;
                receivedBytes += packet.getLength();
                if (receivedDatagrams % 100 == 0) {
                    System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes");
                }
            }
        } catch (InterruptedIOException e) {
            System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes");
        }

        //assert
        //int expectedDatagrams = 34957;
        //int expectedBytes = 2306154;
        //assertEquals(expectedDatagrams, receivedDatagrams);
        //assertEquals(expectedBytes, receivedBytes);
    }

    @Test()
    @Ignore("Can only be executed if an Asterix sender is feeding the decoder")
    public void when_upd_unicast_is_used_as_input_should_decode_cat062_messages_from_larger_sample() throws
            IOException, InterruptedException {
        //arrange
        final int PORT = 3002;
        final int MAX_PACKET_SIZE = 65507;
        final int TIMEOUT = 5000;


        //act
        AsterixDecoder decoder = new AsterixDecoder(62, 65);
        byte[] networkBuffer = new byte[MAX_PACKET_SIZE];
        int receivedDatagrams = 0;
        int receivedBytes = 0;
        try (DatagramSocket client = new DatagramSocket(PORT)) {
            client.setSoTimeout(TIMEOUT);
            DatagramPacket packet = new DatagramPacket(networkBuffer, networkBuffer.length);
            while (true) {
                client.receive(packet);
                decoder.decode(networkBuffer, 0, packet.getLength());

                //accumulate and print info
                receivedDatagrams++;
                receivedBytes += packet.getLength();
                if (receivedDatagrams % 100 == 0) {
                    System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes");
                }
            }
        } catch (InterruptedIOException e) {
            System.out.println("Processed " + receivedDatagrams + " datagrams (" + receivedBytes + ") bytes");
        }

        //assert
        int expectedDatagrams = 18163;
        int expectedBytes = 2785805;
        assertEquals(expectedDatagrams, receivedDatagrams);
        assertEquals(expectedBytes, receivedBytes);
    }

    @Test
    @Description("Used only for printing byte information that can help with developing the tool")
    @Ignore
    public void with_one_packet_should_print_bytes() throws IOException {
        try (InputStream is = TestHelper.getFileInputStreamFromResource("final_frame_062_one_packet_sample2.FF")) {
            FinalFrameReader ffReader = new FinalFrameReader();
            while (is.available() > 0) {
                byte[] ffPayload = ffReader.read(is);
                if (ffPayload != null) {
                    System.out.println("DATA BLOCK START");
                    for (int i = 0; i < ffPayload.length; i++) {
                        BitSet bs = BitSet.valueOf(new byte[]{ffPayload[i]});
                        System.out.print("ORIGINAL [ ");
                        for (int j = 0; j < 8; j++) {
                            if (bs.get(j)) {
                                System.out.print(1 + " ");
                            } else {
                                System.out.print(0 + " ");
                            }
                        }
                        System.out.print("]");

                        System.out.print("   REVERSE [ ");
                        for (int j = 8; j > 0; j--) {
                            if (bs.get(j)) {
                                System.out.print(1 + " ");
                            } else {
                                System.out.print(0 + " ");
                            }
                        }
                        System.out.print("]   ");
                        int unsignedValue = Byte.toUnsignedInt(ffPayload[i]);

                        System.out.println(unsignedValue);


                        if (i == 0 || i == 2) {
                            System.out.println("----------------------------------------------------------------");
                        }
                    }
                }
                System.out.println("DATA BLOCK END");
                System.out.println(System.lineSeparator());
            }
        }
    }

    private int readFileToEnd(AsterixDecoder decoder, InputStream is, FinalFrameReader ffReader) throws IOException {
        int receivedBytes = 0;
        while (is.available() > 0) {
            byte[] ffPayload = ffReader.read(is);
            if (ffPayload != null) {
                decoder.decode(ffPayload, 0, ffPayload.length);
                receivedBytes += ffPayload.length + 12;
            }
        }
        return receivedBytes;
    }
}
