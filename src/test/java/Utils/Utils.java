package Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Utils {

    //Method Overloading
    public static void addIntoJsonList (String fileLocation, String transactionId) throws IOException, ParseException {
        String fileName = fileLocation;
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonList = new JSONObject();
        jsonList.put("transactionId",transactionId);

        jsonArray.add(jsonList);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }
    public static void addIntoJsonList (String fileLocation, String firstName, String lastName, String password,String email ) throws IOException, ParseException {
        String fileName = fileLocation;
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray = (JSONArray) obj;
        JSONObject jsonList = new JSONObject();
        jsonList.put("firstName",firstName);
        jsonList.put("lastName",lastName);
        jsonList.put("password",password);
        jsonList.put("email",email);
        jsonArray.add(jsonList);
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
    }

    public static JSONObject readJSONFile(String filename,int index) throws IOException, ParseException {


        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(filename));
        JSONArray jsonArray = (JSONArray) obj;
        int arraySize=jsonArray.size();
        int arrayIn=arraySize-index;

        JSONObject    arryObject= (JSONObject) jsonArray.get(arrayIn);


        return arryObject;



    }

    public static void doScroll(WebDriver driver, int scrollvalue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+scrollvalue+")");
    }
}
