package com.example.khans.phone2action;

// We import some standard Java classes to make our HTTP Request
import android.content.Context;
import android.util.Log;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.eclipsesource.json.*;

// This is the Minimal JSON package, which we've added as a dependency
// It converts the JSON we get from the HTTP Request to a useable format



// Documentation for this package here: https://github.com/ralfstx/minimal-json
import com.eclipsesource.json.JsonObject.Member;

import static java.security.AccessController.getContext;

public class APIHelper
{
    String APIKey;
    String address;
    Context context;

    public APIHelper(String _address, Context _context) throws IOException
    {
        // Our Phone2Action API Key goes here
        // Super important, we need this to show that we're authorized to make our request
        APIKey = "ie5EtNqb2pafUpw0FsMC84hHqrW9L4uf2Ql9YTJF"; // Should not be an empty String, see the README for info on how to get an API Key
        address = _address;
        context = _context;
        // First, we construct the URL we'll make our HTTP GET Request to:

    }

    public String getRepresentativesByAddress() throws MalformedURLException, UnsupportedEncodingException, IOException{
        String url = "https://api.propublica.org/115/1/";
        String retString = "error";

        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.i("in reponse", "test");
                        Log.i("response:", response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("error", "no response");
            }
        });



        return retString;
    }
}


