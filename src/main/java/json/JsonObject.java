package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<JsonPair> pairs;

    public JsonObject(JsonPair... jsonPairs) {
        this.pairs = new ArrayList<JsonPair>(Arrays.asList(jsonPairs));
    }

    public JsonObject() {
        this.pairs = new ArrayList<JsonPair>();
    }

    @Override
    public String toJson() {
        String result = "{";
        for (JsonPair pair : this.pairs) {
            result += "'" + pair.key + "'" + ": " + pair.value.toJson() + ", ";
        }
        if (this.pairs.size() != 0) {
            result = result.substring(0, result.length() - 2);
        }
        result += "}";
        return result;
    }

    public void add(JsonPair jsonPair) {
        this.pairs.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair pair : pairs) {
            if (Objects.equals(pair.key, name)) {
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        ArrayList<String> needed = new ArrayList<String>(Arrays.asList(names));
        JsonObject jsonObject = new JsonObject();
        for (String k : needed){
            for ( JsonPair pair : this.pairs ){
                if (Objects.equals(pair.key, k)){
                    jsonObject.add(pair);
                }
            }
        }
        return jsonObject;
    }

    public boolean contains(String name){
        JsonObject jsonObject = this.projection(name);
        return jsonObject.pairs.size() != 0;
    }
    
}
