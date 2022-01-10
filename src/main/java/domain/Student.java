package domain;

import json.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private ArrayList<Tuple<String, Integer>> exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super( name, surname, year );
        this.exams = new ArrayList<Tuple<String, Integer>>(Arrays.asList(exams));
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair StudentName = new JsonPair("name", new JsonString(this.name));
        JsonPair StudentSurname = new JsonPair("surname", new JsonString(this.surname));
        JsonPair StudentYear = new JsonPair("year", new JsonNumber(this.year));

        JsonObject[] objects = new JsonObject[this.exams.size()];

        for (int idx = 0; idx < this.exams.size(); idx++){
            JsonObject object = new JsonObject(new JsonPair("course", new JsonString(this.exams.get(idx).key)),
                                                new JsonPair("mark", new JsonNumber(this.exams.get(idx).value)),
                                                new JsonPair("passed", new JsonBoolean(this.exams.get(idx).value > 2)));
            objects[idx] = object;
        }

        return new JsonObject( StudentName, StudentSurname, StudentYear,
                new JsonPair("exams", new JsonArray(objects)));
    }
}