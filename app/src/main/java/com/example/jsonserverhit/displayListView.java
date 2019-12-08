package com.example.jsonserverhit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class displayListView extends AppCompatActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
   ContactAdapter contactAdapter;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list_view);
        contactAdapter= new ContactAdapter(this,R.layout.row_layout);
        listView= (ListView)findViewById(R.id.listView);
        listView.setAdapter(contactAdapter);

        JSON_STRING= getIntent().getStringExtra("json_data");
        String id,name,types,colorofeyes,image;

        try {

            jsonArray = new JSONArray(JSON_STRING);
           // jsonObject=new JSONObject(JSON_STRING);
            int count=0;
//            jsonArray=jsonObject.getJSONArray("");
            while (count<jsonArray.length()){

                JSONObject JO= jsonArray.getJSONObject(count);
                id= JO.getString("id");
                name= JO.getString("name");

                types= JO.getString("types");
                colorofeyes= JO.getString("colorofeyes");
                image= JO.getString("image");

                Contact contacts= new Contact(id,name,types,colorofeyes,image);
                contactAdapter.add(contacts);
                count++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}