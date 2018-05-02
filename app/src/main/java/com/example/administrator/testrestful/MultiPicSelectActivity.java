package com.example.administrator.testrestful;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

import me.nereo.multi_image_selector.MultiImageSelectorActivity;
import me.nereo.multi_image_selector.MultiImageSelectorFragment;

/**
 * 添加图片
 * Created by zlh on 2017/3/3.
 */

public class MultiPicSelectActivity extends AppCompatActivity implements MultiImageSelectorFragment.Callback, View.OnClickListener {

    /**
     *
     * @param activity
     * @param isShowCamera 是否显示拍照
     * @param mode 单选、多选
     * @param count 最大多选数
     * @param requestCode
     */
    public static void launch(Activity activity, boolean isShowCamera, int mode, int count, int requestCode) {
        Intent intent = new Intent(activity, MultiPicSelectActivity.class);
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, count);
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, mode);
        intent.putExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, isShowCamera);
        if(-1 != requestCode) {
            activity.startActivityForResult(intent, requestCode);
        }else {
            activity.startActivity(intent);
        }
    }

    TextView tvPicSelect;

    private ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_pic_select);
        initView();
        initFragment();
    }

    private void initView() {
        tvPicSelect = findViewById(R.id.tv_multi_pic_select);
        tvPicSelect.setOnClickListener(this);
    }

    @Override
    public void onSingleImageSelected(String s) {
        list.add(s);
        Intent intent = new Intent();
        intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT, list);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onImageSelected(String s) {
        if(!list.contains(s)) {
            list.add(s);
        }
    }

    @Override
    public void onImageUnselected(String s) {
        if(list.contains(s)) {
            list.remove(s);
        }
    }

    @Override
    public void onCameraShot(File file) {
        if(null == file) {
            return;
        }

        list.add(file.getAbsolutePath());
        Intent intent = new Intent();
        intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT, list);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            // 完成图片选择
            case R.id.tv_multi_pic_select:
                if(list.size() <= 0) {
                    Toast.makeText(MultiPicSelectActivity.this, "未添加任何图片~", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent();
                intent.putStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT, list);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
            default:
                break;
        }
    }

    private void initFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        Bundle bundle = new Bundle();
        Intent intent = getIntent();
        if(null != intent) {
            // 是否显示相机
            bundle.putBoolean(MultiImageSelectorFragment.EXTRA_SHOW_CAMERA,
                    intent.getBooleanExtra(MultiImageSelectorActivity.EXTRA_SHOW_CAMERA, true));
            // 单选还是多选
            int mode = intent.getIntExtra(MultiImageSelectorActivity.EXTRA_SELECT_MODE, MultiImageSelectorActivity.MODE_MULTI);
            bundle.putInt(MultiImageSelectorFragment.EXTRA_SELECT_MODE,
                    mode);
            tvPicSelect.setVisibility(mode ==MultiImageSelectorActivity.MODE_MULTI ? View.VISIBLE : View.GONE);

            // 最多可选几张
            bundle.putInt(MultiImageSelectorFragment.EXTRA_SELECT_COUNT,
                    intent.getIntExtra(MultiImageSelectorActivity.EXTRA_SELECT_COUNT, 1));
        }
        Fragment fragment = Fragment.instantiate(this, MultiImageSelectorFragment.class.getName(), bundle);
        ft.replace(R.id.frl_multi_pic_select, fragment, MultiImageSelectorFragment.class.getName());
        ft.commitAllowingStateLoss();
    }

}
