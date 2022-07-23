package dataprovider;

import base.TestBase;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;

public class DataProviderForReadingJSONFile extends TestBase {


    @DataProvider(parallel = true)
    public static Object[][] getJsonData() throws IOException, ParseException {

        //Parse JSON Data in testData.json in resource directory
        JSONParser jsonParser = new JSONParser();

        //initialise JSONObject to store the parsed JSON data in the earlier step
        JSONObject jsonObject;

        //Read JSON File
        Object obj = null; //initialise a Java Object to store the JsonFile from the location set below
        try {
            obj = jsonParser.parse(new FileReader(System.getProperty("user.dir") +
                    "/src/main/resources/testData/testData.json"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        jsonObject = (JSONObject) obj; //We are checking the JSON data we read earlier and storing in an JSONObject

        //Extract Array data from JSONObject
        assert jsonObject!=null;
        JSONArray jsonArray= (JSONArray) jsonObject.get("testData");

        //Our Tests won't be able to work with JSONArray, therefore, we are creating a
        // Java String Array to Store JSON Array
        // The size of this array is set to the size of JSONArray
        String[] dataArray=new String[jsonArray.size()];

        //Creat a new JSONObject to read each JSONArray Object inside the Array
        JSONObject jsonObjectArray;
        String Username, Password;

        //Get data from JSONArray and store in String Array
        for(int i=0;i<jsonArray.size();++i){
            jsonObjectArray= (JSONObject) jsonArray.get(i);
            //go item by item and retrieve all the data from the Array
            Username= (String) jsonObjectArray.get("Username");
            Password= (String) jsonObjectArray.get("Password");

            dataArray[i]=Username+ ","+Password;

        }

        return new String[][]{dataArray};
    }


}
