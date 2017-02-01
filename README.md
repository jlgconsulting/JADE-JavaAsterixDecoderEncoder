# JADE (Java Asterix Decoder Encoder)

![Build Status](http://176.223.222.182:8082/app/rest/builds/buildType:(id:JadeJavaAsterixDecoderEncoder_Build)/statusIcon)

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

## Show me some code

```java

// in this example, we want to decode categories 62, 65
AsterixDecoder asterixDecoder = new AsterixDecoder(62,65);

// asterix data is represented as byte array
byte[] asterixRawBlock = rawQueue.take();

// decode the byte array and obtain the asterix data blocks
List<AsterixDataBlock> dataBlocks = asterixDecoder.decode(
    asterixRawBlock,
    0,
    asterixRawBlock.length
);

// process data blocks and extract individual records
for (AsterixDataBlock asterixDataBlock : dataBlocks) {
    List<AsterixRecord> asterixRecords = asterixDataBlock.getRecords();
    
    for (AsterixRecord record : asterixRecords) {
        // get category of record
        int cat = record.getCategory();
        if(cat == 62){
            // after we know the category, we can access the specific record info
            Cat062Record cat062Record = record.getCat062Record();
            int trackNb = cat062Record.getItem040().getTrackNb();
        }
    }
}
```

## How to implement a custom Reserved Field (SP,RE) for an Asterix Category

In order to keep this library flexible, custom implementations for RE and SP fields can be
attached to the Asterix Decoder object in your own code.

In order to implement a custom reserved AsterixField, you first need to create
a new class and inherit ReservedAsterixField. Then, you have to add implementations
for the encode and decode methods, like in the example bellow.

```java
public class SomeCustomReservedFiled extends ReservedAsterixField {
    @Override
    public int decode(byte[] input, int offset, int inputLength) {
        //TODO: add custom logic
    }

    @Override
    public byte[] encode() {
        //TODO: add custom logic
    }
}

```

Then, you need to create a custom factory for the new custom fields.

```java
public class SomeCustomAsterixFieldFactory implements ReservedFieldFactory {
    @Override
    public ReservedAsterixField createSpField() {
        //The SP field will contain the new custom field
        return new SomeCustomReservedFiled();
    }

    @Override
    public ReservedAsterixField createReField() {
        //We leave the default implementation
        return new ReservedAsterixField();
    }
}
```

Finally, we have to attach the custom factory to the Asterix Decoder using the attachCustomReservedFieldFactory method.
The custom factory shall be attached to a given category. This way, different factories can be assigned
to various categories.

```java
AsterixDecoder decoder = new AsterixDecoder(62);
decoder.attachCustomReservedFieldFactory(62, new SomeCustomAsterixFieldFactory());
...
List<AsterixDataBlock> dataBlocks = asterixDecoder.decode(...);

```
