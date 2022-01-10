package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        Json jYear = new JsonNumber(2);
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair year = new JsonPair("year", jYear);
        JsonPair OOP = new JsonPair("course", new JsonString("OOP"));
        JsonPair markOOP = new JsonPair("mark", new JsonNumber(3));
        JsonPair passedOOP = new JsonPair("passed", new JsonBoolean(true));
        JsonObject oop = new JsonObject(OOP, markOOP, passedOOP);
        JsonPair ENG = new JsonPair("course", new JsonString("English"));
        JsonPair markEng = new JsonPair("mark", new JsonNumber(5));
        JsonPair passedEng = new JsonPair("passed", new JsonBoolean(true));
        JsonObject eng = new JsonObject(ENG, markEng, passedEng);
        JsonPair MATH = new JsonPair("course", new JsonString("Math"));
        JsonPair markMath = new JsonPair("mark", new JsonNumber(2));
        JsonPair passedMath = new JsonPair("passed", new JsonBoolean(false));
        JsonObject math = new JsonObject(MATH, markMath, passedMath);
        JsonArray jExams = new JsonArray(oop, eng, math);
        JsonPair exams = new JsonPair("exams", jExams);
        JsonObject jsonObject = new JsonObject(name, surname, year, exams);
        return jsonObject;
    }
}
