package top.qvisa.myviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import top.qvisa.myviewdemo.MyView;

public class MainActivity extends AppCompatActivity {
    private MyView mMyView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyView=findViewById(R.id.MyView);
    }
}
