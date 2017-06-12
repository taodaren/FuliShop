package io.github.taodaren.fulishop;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageBottomTabLayout;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
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

        NavigationController navigationController = tab.custom()
                .addItem(newItem(R.drawable.tab_new_goods, R.drawable.tab_new_goods_selected, "新品"))
                .addItem(newItem(R.drawable.tab_fine, R.drawable.tab_fine_selected, "精选"))
                .addItem(newItem(R.drawable.tab_sort, R.drawable.tab_sort_selected, "分类"))
                .addItem(newItem(R.drawable.tab_cart, R.drawable.tab_cart_selected, "购物车"))
                .addItem(newItem(R.drawable.tab_mine, R.drawable.tab_mine_selected, "我的"))
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

    /**
     * 自定义一个Item
     */
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(0xFFFF5300);
        return normalItemView;
    }
}
