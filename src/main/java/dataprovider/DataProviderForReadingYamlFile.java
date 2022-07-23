package dataprovider;

import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.LinkPermission;
import java.util.Map;

public class DataProviderForReadingYamlFile {

    @DataProvider
    public static Object[][] dataProvider2() throws FileNotFoundException {
        return readYAML("src/main/resources/testData/contactFormDetails.yaml");
    }

    private static Object[][] readYAML(String fileName) throws FileNotFoundException {
        //InputStream to read the Data
        FileInputStream inputStream = null;
        try{
            inputStream=new FileInputStream(fileName);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        //Create Yaml instance and read yaml file
        Yaml yaml=new Yaml();
        Map<String, Object> data=yaml.load(inputStream);

        //Java Array to store Yaml Data
        Object[][] testData=new Object[1][1];
        testData[0][0]=data;
        return testData;
    }


}
