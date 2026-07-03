package com.example.practicejsonarrayusingbothphpjsonfile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class MainActivity2 extends AppCompatActivity {
        ImageView detail_image;
        TextView detail_title, detail_description, detail_phone, detail_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        detail_image = findViewById(R.id.detail_image);
        detail_title = findViewById(R.id.detail_title);
        detail_description = findViewById(R.id.detail_description);
        detail_phone = findViewById(R.id.detail_phone);
        detail_email = findViewById(R.id.detail_email);

        String imageStringconnectionTwo = getIntent().getStringExtra("ImageForNext");
        String titleStringconnectionTwo = getIntent().getStringExtra("TitleForNext");
        String descriptionStringconnectionTwo = getIntent().getStringExtra("DescriptionForNext");
        String phoneStringconnectionTwo = getIntent().getStringExtra("PhoneForNext");
        String emailStringconnectionTwo = getIntent().getStringExtra("EmailForNext");

        Glide.with(MainActivity2.this).load(imageStringconnectionTwo).into(detail_image);
        detail_title.append(titleStringconnectionTwo);
        detail_description.append(descriptionStringconnectionTwo);
        detail_phone.append(phoneStringconnectionTwo);
        detail_email.append(emailStringconnectionTwo);


    }//LastBracketFirst
}//LastBracketLast