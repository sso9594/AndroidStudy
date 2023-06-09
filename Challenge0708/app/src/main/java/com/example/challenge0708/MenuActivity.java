package com.example.challenge0708;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    public static final int MENU_CODE_FROM_MAIN = 101;
    public static final int CUSTOMER_CODE_FROM_MENU = 102;
    public static final int MAIN_CODE_FROM_CUSTOMER = 112;
    public static final int MENU_CODE_FROM_CUSTOMER = 122;
    public static final int SALES_CODE_FROM_MENU = 103;
    public static final int MAIN_CODE_FROM_SALES = 113;
    public static final int MENU_CODE_FROM_SALES = 123;
    public static final int PRODUCT_CODE_FROM_MENU = 104;
    public static final int MAIN_CODE_FROM_PRODUCT = 114;
    public static final int MENU_CODE_FROM_PRODUCT = 124;
    SimpleData data;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode ==  MENU_CODE_FROM_MAIN) {
            Toast.makeText(getApplicationContext(),"메인 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode == MENU_CODE_FROM_CUSTOMER) {
            Toast.makeText(getApplicationContext(),"고객 관리 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode == MAIN_CODE_FROM_CUSTOMER){	//고객관리에서 메인일때
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_CUSTOMER,intent);	//메뉴를 거쳤다가 메인으로 가게 만듦 (코드를 메인으로 전달)
            finish();
        }
        else if(resultCode == MENU_CODE_FROM_SALES) {
            Toast.makeText(getApplicationContext(),"매출 분석 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode == MAIN_CODE_FROM_SALES){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_SALES,intent);
            finish();
        }
        else if(resultCode == MENU_CODE_FROM_PRODUCT){
            Toast.makeText(getApplicationContext(),"상품 분석 -> 메뉴",Toast.LENGTH_LONG).show();
        }
        else if(resultCode == MAIN_CODE_FROM_PRODUCT){
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            setResult(MAIN_CODE_FROM_PRODUCT,intent);
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        data = getData(getIntent());

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                intent.putExtra("data",data);
                startActivityForResult(intent, CUSTOMER_CODE_FROM_MENU);
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
                intent.putExtra("data",data);
                startActivityForResult(intent,SALES_CODE_FROM_MENU);
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
                intent.putExtra("data",data);
                startActivityForResult(intent,  PRODUCT_CODE_FROM_MENU );
            }
        });
    }
    private SimpleData getData(Intent intent){
        if(intent != null){
            Bundle bundle = intent.getExtras();
            SimpleData data = bundle.getParcelable("data");
            return data;
        }
        else{
            return null;
        }
    }
}