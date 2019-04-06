package com.example.khans.phone2action;

// We import some standard Java classes to make our HTTP Request
import java.net.*;
import java.io.*;
import java.util.Scanner;

import com.eclipsesource.json.*;

// This is the Minimal JSON package, which we've added as a dependency
// It converts the JSON we get from the HTTP Request to a useable format



// Documentation for this package here: https://github.com/ralfstx/minimal-json
import com.eclipsesource.json.JsonObject.Member;

public class APIHelper
{
    public static void main(String[] args) throws IOException
    {
        // Our Phone2Action API Key goes here
        // Super important, we need this to show that we're authorized to make our request
        String xAPIKey = ""; // Should not be an empty String, see the README for info on how to get an API Key

        // First, we construct the URL we'll make our HTTP GET Request to:
        String endpoint = "https://fmrrixuk32.execute-api.us-east-1.amazonaws.com/hacktj/legislators";
        String parameters = "?level=NATIONAL_LOWER&address=";
        String address = "6560 Braddock Rd"; // Change this to match your address!
        String addressFormatted = URLEncoder.encode(address, "UTF-8"); // This formats the article title for our URL
        URL phone2ActionURL = new URL(endpoint + parameters + addressFormatted); // This is the Java URL class, necessary here

        // Then, we set up the HTTP GET Request itself
        HttpURLConnection connection = (HttpURLConnection) phone2ActionURL.openConnection();
        connection.setRequestMethod("GET"); // We need to set the HTTP Request type!
        connection.setRequestProperty("X-API-Key", xAPIKey); // We pass in the API Key to access the Phone2Action API

        // Now, we're able to fire the configured HTTP GET Request with the getInputStream() method
        InputStream response = connection.getInputStream(); // The HttpURLConnection's response is an InputStream

        // Next, we convert the response to a JsonObject with Minimal JSON
        Scanner scanner = new Scanner(response);
        String responseBody = scanner.useDelimiter("\\A").next(); // The response is a String, which isn't useful
        JsonObject responseObject = Json.parse(responseBody).asObject(); // This converts it to a (useful) JsonObject
        scanner.close();

        // Finally, we pick out the data we want and print it to the console
        // Use Postman to figure out what format your data is in and access it accordingly
        // A sample JSON is also available at https://github.com/phone2action/hacktj-examples#legislators-api
        JsonArray responseRepresentatives = responseObject.get("officials").asArray();
        // We don't know what each of the keys of the response's pages will be, so we loop through all of them
        for (JsonValue responseRepresentative : responseRepresentatives) // Each key is a Member object, provided by Minimal JSON
        {
            String firstName = responseRepresentative.asObject().get("first_name").asString();
            String lastName = responseRepresentative.asObject().get("last_name").asString();
            System.out.println("Your Representative in national Congress is " + firstName + " " + lastName); // We convert the key's value to a JsonObject
        }
    }
}

