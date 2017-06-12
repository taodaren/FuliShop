package io.github.taodaren.fulishop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //创建 Material 风格导航栏
        setTabBottom();
    }

    private void setTabBottom() {
        PageBottomTabLayout tab = (PageBottomTabLayout) findViewById(R.id.tab_bottom_layout);

        //对导航栏进行后续的控制
        NavigationController navigationController = tab.material()
                .addItem(R.drawable.tab_new_goods_selected, "新品")
                .addItem(R.drawable.tab_fine, "精选")
                .addItem(R.drawable.tab_sort, "分类")
                .addItem(R.drawable.tab_cart, "购物车")
                .addItem(R.drawable.tab_mine, "我的")
                .build();

        //监听导航栏的 Item 选中事件
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发

            }

            @Override
            public void onRepeat(int index) {
                //重复选中时触发

            }
        });
    }
}
