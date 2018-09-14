package io.streamzi.openshift.operations;

import io.streamzi.openshift.dataflow.annotations.CloudEventComponent;
import io.streamzi.openshift.dataflow.annotations.CloudEventConsumer;
import io.streamzi.openshift.dataflow.annotations.ObjectType;
import java.util.HashMap;

/**
 * Does logging for POJO
 * @author hhiden
 */
@CloudEventComponent
public class LogPojoData {
    @CloudEventConsumer(name = "INPUT_DATA", type = ObjectType.OBJECT)
    public void onMessage(HashMap<String, Object> value){
        System.out.println("Message:");
        value.keySet().stream().forEach(key->System.out.println(key + ": " + value.get(key)));
        System.out.println();
    }
}
