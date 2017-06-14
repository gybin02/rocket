package com.meiyou.plugin.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.meiyou.jet.annotation.JFindViewOnClick;
import com.meiyou.jet.process.Jet;
import com.meiyou.plugin.rocket.Rocket;

public class MainActivity extends Activity implements View.OnClickListener {
    @JFindViewOnClick(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Jet.bind(this);


        Rocket.init(this)
              .inject(AppRocketConfig.class);
//           .setBeeSize(100)
//           .setBeePosition(Gravity.CENTER)
//           .setBeeMargin(0, 0, 0, 200)
        

//        BeeLog.d("MainActivity", "onCreate");
//        BeeLog.d("MainActivity", "user logged in");
//        BeeLog.d("MainActivity", "user logged out");
//        BeeLog.d("MainActivity", "onDestroyed");
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.button:
                Intent intent = new Intent(this, DetailActivity.class);
                startActivity(intent);
                break;
//        case :
//    
//            break;
            default:
                break;
        }
    }
}
