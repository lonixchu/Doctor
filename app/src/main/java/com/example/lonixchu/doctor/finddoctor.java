package com.example.lonixchu.doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class finddoctor extends AppCompatActivity {

    ListView mListView;

    String[] Name = {"董寶然 TUNG PO YIN", "鄧紹興 TANG SIU HING", "莊志剛 Chong Chi Kong", "夏文綺 HAR MAN YEE", "林勇群 LAM YUNG KWAN", "李康銘 LEE HONG MING", "黎厚褔 Lai Hou Fuk", "勞炳和 Lo Ping Wo, Edward"
            , "吳敏僑 Ng Man Kiu", "黃劍輝 WONG KIM FAI", "林根源 LAM KUN YUEN", "劉濤 LIU TAO", "姚大東 YIU TAI TUNG"};
    String[] Subject = {"西醫、普通科", "西醫、普通科", "牙科、普通科", "西醫、兒科", "註冊中醫、全科", "註冊中醫、全科", "表列中醫", "西醫、普通科"
            , "註冊中醫、針灸", "註冊中醫、全科", "西醫、普通科", "有限制註冊中醫", "註冊中醫、骨傷"};
    String[] Address = {"九龍深水埗桂林街143號H座地下F1-F2號舖", "九龍深水埗元州街6號地下", "九龍長沙灣麗閣邨麗薇樓3樓平台2號鋪", "九龍荔枝角美孚新邨第1期百老匯街3號A平台23號舖", "九龍石硤尾南山邨南樂樓201號地下", "九龍荔枝角長裕街18號栢裕工業中心9樓", "九龍荔枝角青山道489-491號香港工業中心A座11樓A9-1室", "九龍深水埗巴域街61A新寧大樓地舖"
            , "九龍荔枝角美孚新邨2期吉利徑7座平台54號舖", "九龍深水埗長沙灣道303號長沙灣政府合署1樓", "九龍深水埗元州邨商場115號舖", "九龍長沙灣長沙灣道303號長沙灣政府合署1樓", "九龍深水埗南昌街180號普泰大廈2樓B室"};
    String[] Phone = {"23868669", "27763718", "23602728", "23109718", "98315745", "23713681", "26851408", "23613090"
            , "35682946", "21949911", "27200968", "21949911", "27771817"};
    int[] countryFlags = {R.drawable.doctoricon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finddoctor);


        mListView = (ListView) findViewById(R.id.listview);
        MyAdapter myAdapter = new MyAdapter(finddoctor.this, Name, Subject, Address, Phone, countryFlags);
        mListView.setAdapter(myAdapter);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent saveIntent = new Intent(finddoctor.this, Confirmation.class);
                saveIntent.putExtra("Name", Name[i]);
                saveIntent.putExtra("Location", Address[i]);
                startActivity(saveIntent);
            }
        });
}}
