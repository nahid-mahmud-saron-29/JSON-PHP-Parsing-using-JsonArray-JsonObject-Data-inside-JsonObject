package com.example.practicejsonarrayusingbothphpjsonfile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
        ListView listView;
        MyAdapter myAdapter = new MyAdapter();
        HashMap<String, String> hashMapOne = new HashMap<>();
        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listView = findViewById(R.id.listView);
        dataHouse();
        listView.setAdapter(myAdapter);

    } //lastBracketFrist
    private class MyAdapter extends BaseAdapter{
            LayoutInflater layoutInflater;
        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View myView = layoutInflater.inflate(R.layout.layout,parent,false);
            ImageView layout_image = myView.findViewById(R.id.layout_image);
            TextView layout_title = myView.findViewById(R.id.layout_title);
            TextView layout_description = myView.findViewById(R.id.layout_description);
            TextView layout_phone = myView.findViewById(R.id.layout_phone);
            TextView layout_email = myView.findViewById(R.id.layout_email);
            CardView layout_cardView = myView.findViewById(R.id.layout_cardView);

            HashMap<String, String> hashMapTwo = arrayList.get(position);
            String imageStringConnection = hashMapTwo.get("ImageDataHouse");
            String titleStringConnection = hashMapTwo.get("TitleDataHouse");
            String descriptionStringConnection = hashMapTwo.get("DescriptionDataHouse");
            String phoneStringConnection = hashMapTwo.get("PhoneContactHouse");
            String emailStringConnection = hashMapTwo.get("EmailContactHouse");

            Glide.with(MainActivity.this).load(imageStringConnection).into(layout_image);
            layout_title.setText(titleStringConnection);
            layout_description.setText(descriptionStringConnection);
            layout_phone.setText(phoneStringConnection);
            layout_email.setText(emailStringConnection);

            layout_cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent myInt = new Intent(MainActivity.this, MainActivity2.class);
                    myInt.putExtra("ImageForNext", imageStringConnection);
                    myInt.putExtra("TitleForNext", titleStringConnection);
                    myInt.putExtra("DescriptionForNext", descriptionStringConnection);
                    myInt.putExtra("PhoneForNext", phoneStringConnection);
                    myInt.putExtra("EmailForNext", emailStringConnection);
                    startActivity(myInt);
                }
            });

            return myView;
        }
    } //myAdapterFinished
    public void dataHouse(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://192.168.0.107/practiceandroid/datahouse/pakista.json";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            for (int i=0; i<jsonArray.length(); i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String imageStringServerConnect = jsonObject.getString("ImageDataHouse");
                                String titleStringServerConnect = jsonObject.getString("TitleDataHouse");
                                String descriptionStringServerConnect = jsonObject.getString("DescriptionDataHouse");


                                JSONObject contactJSONObject = jsonObject.getJSONObject("ContactDataHouse");
                                String phoneContactHouseString = contactJSONObject.getString("PhoneContactHouse");
                                String emailContactHouseString = contactJSONObject.getString("EmailContactHouse");

                                hashMapOne = new HashMap<>();
                                hashMapOne.put("ImageDataHouse", imageStringServerConnect);
                                hashMapOne.put("TitleDataHouse", titleStringServerConnect);
                                hashMapOne.put("DescriptionDataHouse", descriptionStringServerConnect);

                                hashMapOne.put("PhoneContactHouse", phoneContactHouseString);
                                hashMapOne.put("EmailContactHouse", emailContactHouseString);
                                arrayList.add(hashMapOne);

                            }
                            myAdapter.notifyDataSetChanged();
                        }
                        catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);
    } //dataHouseFinished
} //LastBrachetLast