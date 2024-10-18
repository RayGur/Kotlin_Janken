package com.example.w6_lab;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // 宣告變數
    private EditText ed_name;
    private TextView tv_text, tv_name, tv_winner, tv_mmora, tv_cmora;
    private RadioButton btn_scissor, btn_stone, btn_paper;
    private Button btn_mora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 連結 layout

        // 綁定 XML 的元件
        ed_name = findViewById(R.id.ed_name);
        tv_text = findViewById(R.id.tv_inputname);
        tv_name = findViewById(R.id.tv_end_name);
        tv_winner = findViewById(R.id.tv_end_winner);
        tv_mmora = findViewById(R.id.tv_end_player);
        tv_cmora = findViewById(R.id.tv_end_bot);
        btn_scissor = findViewById(R.id.btn_scissors);
        btn_stone = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_mora = findViewById(R.id.btn_game);

        // 設置按鈕點擊監聽器
        btn_mora.setOnClickListener(view -> {
            // 判斷玩家是否輸入姓名
            if (ed_name.length() < 1) {
                tv_text.setText("請輸入玩家姓名");
            } else {
                // 顯示玩家姓名與出拳
                tv_name.setText(String.format("名字\n%s", ed_name.getText().toString()));

                if (btn_scissor.isChecked()) {
                    tv_mmora.setText("我方出拳\n剪刀");
                } else if (btn_stone.isChecked()) {
                    tv_mmora.setText("我方出拳\n石頭");
                } else {
                    tv_mmora.setText("我方出拳\n布");
                }

                // 使用亂數產生電腦出拳，值為 0~2
                int computer_random = (int) (Math.random() * 3);

                // 顯示電腦出拳
                if (computer_random == 0) {
                    tv_cmora.setText("電腦出拳\n剪刀");
                } else if (computer_random == 1) {
                    tv_cmora.setText("電腦出拳\n石頭");
                } else {
                    tv_cmora.setText("電腦出拳\n布");
                }

                // 判斷勝負
                if ((btn_scissor.isChecked() && computer_random == 2) ||
                        (btn_stone.isChecked() && computer_random == 0) ||
                        (btn_paper.isChecked() && computer_random == 1)) {

                    tv_winner.setText("勝利者\n" + ed_name.getText().toString());
                    tv_text.setText("恭喜您獲勝了！！！");

                } else if ((btn_scissor.isChecked() && computer_random == 1) ||
                        (btn_stone.isChecked() && computer_random == 2) ||
                        (btn_paper.isChecked() && computer_random == 0)) {

                    tv_winner.setText("勝利者\n電腦");
                    tv_text.setText("可惜，電腦獲勝了！");

                } else {
                    tv_winner.setText("勝利者\n平手");
                    tv_text.setText("平局，請再試一次！");
                }
            }
        });
    }
}