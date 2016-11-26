package cn.ucai.goddess.controller.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;

/**
 * Created by mac-yk on 2016/11/26.
 */

public class SettingActivity extends BaseActivity {
    @BindView(R.id.set_height)
    EditText setHeight;
    @BindView(R.id.set_weight)
    EditText setWeight;
    @BindView(R.id.set_age)
    EditText setAge;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_setting);
        ButterKnife.bind(this);

        super.onCreate(savedInstanceState);

    }

    @OnClick(R.id.set_btn)
    public void onClick() {
        final Dialog dialog=new Dialog(this);
        final View view = getLayoutInflater().inflate(R.layout.dialog_set, null);
        dialog.setContentView(view);
        dialog.setTitle("验证密码");
        dialog.show();
        view.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText passwd= (EditText) view.findViewById(R.id.et_passwd);
                if (passwd.getText().toString().equals("124578")){
                    dialog.dismiss();
                    SharedPreferences sp=getSharedPreferences("goddess",MODE_PRIVATE);
                    sp.edit().putString("age",setAge.getText().toString())
                            .putString("height",setHeight.getText().toString())
                            .putString("weight",setWeight.getText().toString()).commit();
                    finish();
                }else {
                    Toast.makeText(SettingActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
