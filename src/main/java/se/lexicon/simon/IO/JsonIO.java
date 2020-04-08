package se.lexicon.simon.IO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import se.lexicon.simon.model.Pen;

import javax.lang.model.type.ReferenceType;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles Read and Write of Json files for Pen.class ONLY, NOT Generalised.
 */
public class JsonIO {

   private ObjectMapper objectmapper;

    /**
     * Constructor - Preparing the ObjectMapper
     */
    public JsonIO() {
        objectmapper = new ObjectMapper();
        objectmapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectmapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        objectmapper.registerModule( new JavaTimeModule());

        //Added.
        objectmapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectmapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
    }

    /**
     *
     * @param penList List of items to Serialized/Saved.
     * @param file The File to save on.
     * @return True - if successfully saved list to file, otherwise returns false or throw Exception.
     *
     */
    public boolean serializePenToJson(List<Pen> penList, File file) {
        boolean successfullyAdded = false;

        try{
            objectmapper.writeValue(file,penList);
            successfullyAdded = true;

        } catch (FileNotFoundException e){
            System.out.println("Filen kunde inte hittas!");
            e.printStackTrace();

        } catch(IOException e){
            System.out.println("något angående fil hanteringen gick fel");
            e.printStackTrace();
        }

        return successfullyAdded;
    }

    /**
     *
     * @param file File to Deserialize/Read.
     * @return The List of items found in File.
     */
    public List<Pen> deSerializePenFromJson(File file){

        List<Pen> penList = new ArrayList<>();

        try {
            penList = objectmapper.readValue(file, new TypeReference<List<Pen>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return penList;
    }



}
