package se.lexicon.simon.IO;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.simon.model.Pen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class JsonIOTest {

    private JsonIO jsonIO;
    List<Pen> penList;

    @Before
    public void setUp(){
        jsonIO = new JsonIO();

        penList = new ArrayList<>();
        penList.add(new Pen("werfsde634","Finetip","blue"));
        penList.add(new Pen("34ff4","Boldtip","red"));

    }

    @Test
    public void serializePenToJson() {

        boolean success = false;

        success = jsonIO.serializePenToJson(penList,new File("src/test/resources/Write.json"));

        assertTrue(success);


    }

    @Test
    public void deSerializePenFromJson() {

        List<Pen> penList = new ArrayList<>();

        assertTrue(penList.isEmpty());

        penList = jsonIO.deSerializePenFromJson(new File("src/test/resources/Read.json"));

        assertFalse(penList.isEmpty());

    }
}