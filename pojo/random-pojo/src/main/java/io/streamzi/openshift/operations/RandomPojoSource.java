package io.streamzi.openshift.operations;

import io.streamzi.openshift.dataflow.annotations.CloudEventComponent;
import io.streamzi.openshift.dataflow.annotations.CloudEventComponentTimer;
import io.streamzi.openshift.dataflow.annotations.CloudEventProducer;
import io.streamzi.openshift.dataflow.annotations.CloudEventProducerTarget;
import java.util.HashMap;

/**
 * Producer that sends data as a Java Object
 * @author hhiden
 */
@CloudEventComponent
public class RandomPojoSource {
    @CloudEventProducer(name = "OUTPUT_DATA")
    private CloudEventProducerTarget output;
    
    @CloudEventComponentTimer(interval = 1000)
    public void send(){
        HashMap data = new HashMap();
        data.put("X", Math.random());
        data.put("Y", Math.random());
        output.send(data);
    }
}