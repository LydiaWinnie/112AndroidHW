//A111221014 資管二乙 黃芊菱
package com.example.hw_0523;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Spinner spinnerMenu;
    private TextView MainCourse, SideDish, Drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerMenu = findViewById(R.id.spinner_menu);
        MainCourse = findViewById(R.id.tv_main_course);
        SideDish = findViewById(R.id.tv_side_dish);
        Drink = findViewById(R.id.tv_drink);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.menu_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMenu.setAdapter(adapter);

        spinnerMenu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        showMainCourseButtons();
                        hideSideDishButtons();
                        hideDrinkButtons();
                        break;
                    case 1:
                        hideMainCourseButtons();
                        showSideDishButtons();
                        hideDrinkButtons();
                        break;
                    case 2:
                        hideMainCourseButtons();
                        hideSideDishButtons();
                        showDrinkButtons();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        findViewById(R.id.btn_main_course1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainCourse.setText("主餐: 牛肉漢堡");
            }
        });

        findViewById(R.id.btn_main_course2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainCourse.setText("主餐: 豬肉漢堡");
            }
        });

        findViewById(R.id.btn_main_course3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainCourse.setText("主餐: 炸雞漢堡");
            }
        });

        findViewById(R.id.btn_main_course4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainCourse.setText("主餐: 炸魚漢堡");
            }
        });

        // 設置附餐按鈕的點擊監聽器
        findViewById(R.id.btn_side_dish1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SideDish.setText("附餐: 薯條");
            }
        });
        findViewById(R.id.btn_side_dish2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SideDish.setText("附餐: 沙拉");
            }
        });
        findViewById(R.id.btn_side_dish3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { SideDish.setText("附餐: 玉米濃湯"); }
        });
        findViewById(R.id.btn_side_dish4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SideDish.setText("附餐: 蘋果派");
            }
        });

        findViewById(R.id.btn_drink1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drink.setText("飲料: 可樂");
            }
        });

        findViewById(R.id.btn_drink2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drink.setText("飲料: 雪碧");
            }
        });

        findViewById(R.id.btn_drink3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drink.setText("飲料: 冰紅茶");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_submit) {
            String mainCourse = MainCourse.getText().toString();
            String sideDish = SideDish.getText().toString();
            String drink = Drink.getText().toString();

            String message = "你的訂單：\n";
            if (!mainCourse.isEmpty()) {
                message += mainCourse + "\n";
            }
            if (!sideDish.isEmpty()) {
                message += sideDish + "\n";
            }
            if (!drink.isEmpty()) {
                message += drink + "\n";
            }

            Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
            intent.putExtra("order_details", message);
            startActivity(intent);

            return true;
        } else if (itemId == R.id.action_cancel) {
            MainCourse.setText("主餐: ");
            SideDish.setText("附餐: ");
            Drink.setText("飲料: ");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showMessageDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message)
                .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });
        builder.create().show();
    }


    private void showMainCourseButtons() {
        findViewById(R.id.btn_main_course1).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_main_course2).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_main_course3).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_main_course4).setVisibility(View.VISIBLE);
    }

    private void hideMainCourseButtons() {
        findViewById(R.id.btn_main_course1).setVisibility(View.GONE);
        findViewById(R.id.btn_main_course2).setVisibility(View.GONE);
        findViewById(R.id.btn_main_course3).setVisibility(View.GONE);
        findViewById(R.id.btn_main_course4).setVisibility(View.GONE);
    }

    private void showSideDishButtons() {
        findViewById(R.id.btn_side_dish1).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_side_dish2).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_side_dish3).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_side_dish4).setVisibility(View.VISIBLE);
    }

    private void hideSideDishButtons() {
        findViewById(R.id.btn_side_dish1).setVisibility(View.GONE);
        findViewById(R.id.btn_side_dish2).setVisibility(View.GONE);
        findViewById(R.id.btn_side_dish3).setVisibility(View.GONE);
        findViewById(R.id.btn_side_dish4).setVisibility(View.GONE);
    }

    private void showDrinkButtons() {
        findViewById(R.id.btn_drink1).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_drink2).setVisibility(View.VISIBLE);
        findViewById(R.id.btn_drink3).setVisibility(View.VISIBLE);
    }

    private void hideDrinkButtons() {
        findViewById(R.id.btn_drink1).setVisibility(View.GONE);
        findViewById(R.id.btn_drink2).setVisibility(View.GONE);
        findViewById(R.id.btn_drink3).setVisibility(View.GONE);
    }

}