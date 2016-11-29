package cn.ucai.goddess.controller.activity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ucai.goddess.R;
import cn.ucai.goddess.model.utils.MFGT;

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
        String age=setAge.getText().toString();
        String height=setHeight.getText().toString();
        String weight=setWeight.getText().toString();
        if (!age.matches("[0-9]{1,2}")){
            setAge.setError("年龄不符合");
            setAge.requestFocus();
            return;
        }
        if (!height.matches("[0-9]{3}")&&!height.matches("[0-9]{3}[.][0-9]")){
            setHeight.setError("输入的身高不符合规范");
            setHeight.requestFocus();
            return;
        }
        if (!weight.matches("[0-9]{2}")&&!weight.matches("[0-9]{2}[.][0-9]")){
            setWeight.setError("输入的体重不符合规范");
            setWeight.requestFocus();
            return;
        }
        final Dialog dialog=new Dialog(this);
        final View view = getLayoutInflater().inflate(R.layout.dialog_set, null);
        dialog.setContentView(view);
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        p.height = (int) (d.getHeight() * 0.3); // 高度设置为屏幕的X
        p.width = (int) (d.getWidth() * 0.65); // 宽度设置为屏幕的X
        dialogWindow.setAttributes(p);
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
                    MFGT.gotoMainActivity(SettingActivity.this);
                    finish();
                }else {
                    Toast.makeText(SettingActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        MFGT.gotoMainActivity(this);
        finish();
    }
}
