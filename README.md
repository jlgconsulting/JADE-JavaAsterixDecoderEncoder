# JADE (Java Asterix Decoder Encoder)

JADE is an API for decoding and encoding ASTERIX messages. The following categories are planned to be implemented:
- Category 062
- Category 048
- Category 065
- Category 034
- Category 150
- Category 004

ASTERIX is the EUROCONTROL Standard for the exchange of Surveillance related data.
ASTERIX provides a structured approach to a message format to be applied in the exchange of surveillance related information for various applications. Managed by the ASTERIX Maintenance Group (AMG) with its multinational participation, it ensures a common data representation, thereby facilitating the exchange of surveillance data in an international context.
ASTERIX also defines a structured approach to the encoding of surveillance data. Categories group the information related to a specific application. They consist of a number of data items which are defined in the ASTERIX documents down to the bit-level.

## Running the test application

The test jade application can receive 4 argumens:
- the input mode: file or udp
- a flag for logs: true or false
- the file name for file mode or port number for udp mode
- the allowed categories as a comma separated list

Examples:

1. With data stream from file -> java -jar ./jade-<version>.jar file <true|false> <path to file> <categories separated by comma>
2. With data stream from UDP Unicast -> java -jar ./jade-<version>.jar udp <true|false> <port> <categories separated by comma> 
3. java -jar ./jade-0.9.3 file true D:\Data\data_sample.rec 62,65
