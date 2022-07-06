package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class utils {
    public static RequestSpecification requestSpecification;
    public static ResponseSpecification responseSpecification;

    public RequestSpecification requestSpecification() throws IOException {
        if(requestSpecification == null) {
            PrintStream stream = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecification = new RequestSpecBuilder().setBaseUri(getGlobalProperty("baseUrl")).setContentType(ContentType.JSON)
                    .addFilter(RequestLoggingFilter.logRequestTo(stream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                    .build();
        }
        return requestSpecification;

    }

    public ResponseSpecification responseSpecification(){
        if(responseSpecification == null) {
            responseSpecification =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        }
        return responseSpecification;
    }

    public String getGlobalProperty(String key) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ashin\\Documents\\Software Testing\\Cucumber Rest Assured\\src\\test\\java\\resources\\global.properties");
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}
