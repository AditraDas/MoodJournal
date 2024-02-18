package com.example.moodjournal;

import static com.example.moodjournal.R.id.nav_history;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomePage extends AppCompatActivity {

    private TextView moodQuestion;
    private TextView dateText;
    private ImageButton emojiRad, emojiHappy, emojiMeh, emojiUnhappy, emojiAnxious, emojiAngry;
    private Button saveButton;
    private BottomNavigationView bottomNav;
    private TextView dateTextFormatted;

    public HomePage() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        moodQuestion = findViewById(R.id.mood_question);
        emojiRad = findViewById(R.id.emoji_rad);
        emojiHappy = findViewById(R.id.emoji_happy);
        emojiMeh = findViewById(R.id.emoji_meh);
        emojiUnhappy = findViewById(R.id.emoji_unhappy);
        emojiAnxious = findViewById(R.id.emoji_anxious);
        emojiAngry = findViewById(R.id.emoji_angry);
        saveButton = findViewById(R.id.save_button);
        bottomNav = findViewById(R.id.bottom_navigation);
        dateTextFormatted=findViewById(R.id.date_text_formatted);




        ImageView accountIcon = findViewById(R.id.account_icon);
        // Set up the click listener for the account icon if needed

        // Set a click listener for the save button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the save button click
                // You can add your logic here to save the selected mood or perform other actions
            }
        });

        // Set click listeners for each emoji ImageButton (if needed)
        emojiRad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the rad emoji
                Toast.makeText(HomePage.this, "You have selected rad", Toast.LENGTH_SHORT).show();
            }
        });

        emojiHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this, "You have selected happy", Toast.LENGTH_SHORT).show();
            }
        });

        emojiMeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the meh emoji
                Toast.makeText(HomePage.this, "You have selected meh", Toast.LENGTH_SHORT).show();
            }
        });

        emojiUnhappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the unhappy emoji
                Toast.makeText(HomePage.this, "You have selected sad", Toast.LENGTH_SHORT).show();
            }
        });

        emojiAnxious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the anxious emoji
                Toast.makeText(HomePage.this, "You have selected anxious", Toast.LENGTH_SHORT).show();
            }
        });

        emojiAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click for the angry emoji
                Toast.makeText(HomePage.this, "You have selected angry", Toast.LENGTH_SHORT).show();
            }
        });

        // Set up the bottom navigation
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }



    private void updateDate() {
    }

    // ...

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    int itemId = item.getItemId();
                    if (itemId == R.id.nav_home) {// Navigate to the HomeFragment or HomeActivity
                        startActivity(new Intent(HomePage.this, HomePage.class));
                        return true;
                    } else if (itemId == R.id.nav_history) {// Navigate to the MoodHistoryPage activity
                        startActivity(new Intent(HomePage.this, MoodHistoryPage.class));
                        return true;
                    } else if (itemId == R.id.nav_insights) {// Navigate to the InsightsPage activity
                        startActivity(new Intent(HomePage.this, InsightsPage.class));
                        return true;
                    } else if (itemId == R.id.nav_settings) {// Navigate to the Settings activity
                        startActivity(new Intent(HomePage.this, Settings.class));
                        return true;
                    }
                    return false;
                }
            };

    private void updateCurrentDateFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("d", Locale.getDefault());
        String day = sdf.format(new Date());

        String formattedDate = getFormattedDate(Integer.parseInt(day));

        dateTextFormatted.setText(formattedDate);
    }

    // Method to get the formatted date with "th," "st," "nd," "rd" suffix
    private String getFormattedDate(int day) {
        if (day >= 11 && day <= 13) {
            return day + "th " + new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
        }

        switch (day % 10) {
            case 1:
                return day + "st " + new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
            case 2:
                return day + "nd " + new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
            case 3:
                return day + "rd " + new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
            default:
                return day + "th " + new SimpleDateFormat("MMMM yyyy", Locale.getDefault()).format(new Date());
        }
    }

}