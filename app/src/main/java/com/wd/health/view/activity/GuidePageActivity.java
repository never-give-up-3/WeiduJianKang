package com.wd.health.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnPageChangeListener;
import com.wd.health.R;

import java.util.ArrayList;

//引导页

public class GuidePageActivity extends AppCompatActivity {
    private ArrayList<Integer> arrayList;
    private ConvenientBanner cbTest;
    private Button btnTest;
    private RadioButton rbt1;
    private RadioButton rbt2;
    private RadioButton rbt3;
    private ArrayList<RadioButton> radioButtons;
    private boolean ydy;
    private SharedPreferences.Editor editor;
    private SharedPreferences page;
    int b = 0;
    private int b1;
    private int pa2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_page);
        initView();
        initGuidePage();

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    private void initView() {
        arrayList = new ArrayList<>();
        arrayList.add(R.mipmap.a1);
        arrayList.add(R.mipmap.a2);
        arrayList.add(R.mipmap.a3);
        arrayList.add(R.mipmap.a4);
        arrayList.add(R.mipmap.a5);

        SharedPreferences pager = getSharedPreferences("pager", MODE_PRIVATE);
        pa2 = pager.getInt("pa", 0);
        SharedPreferences.Editor edit = pager.edit();
//        edit.putInt("pa",b);
        edit.commit();



        if (pa2 == 0){
            //跳转到主activity
            Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
            startActivity(intent);
        }

//        SharedPreferences pager3 = getSharedPreferences("pager", MODE_PRIVATE);
//        int pa3 = pager3.getInt("pa", 0);


        if (pa2 != 0){
            //跳转到主activity
            Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
            startActivity(intent);
            Log.e("ydy","true");
        }else {

            pa2 = 1;
            SharedPreferences pager3 = getSharedPreferences("pager", MODE_PRIVATE);
            int pa3 = pager3.getInt("pa", pa2);
            Log.e("ydy","flash");

        }



        cbTest = (ConvenientBanner) findViewById(R.id.page_banner);
        btnTest = (Button) findViewById(R.id.page_btn);
//                        .setBackgroundColor(Color.parseColor("#00000000"));


        btnTest.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
//                int c = 1;
//                SharedPreferences pager = getSharedPreferences("pager", MODE_PRIVATE);
//                p = pager.getInt("pa", 1);
//                SharedPreferences.Editor edit1 = pager.edit();
//                edit1.commit();
//                page = getSharedPreferences("YDY", MODE_PRIVATE);
//                int a = page.getInt("a", 2);
//                b = a;
                //跳转到主activity
                Intent intent = new Intent(GuidePageActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
     /*   rbt1 = (RadioButton) findViewById(R.id.rbt1);
        rbt2 = (RadioButton) findViewById(R.id.rbt2);
        rbt3 = (RadioButton) findViewById(R.id.rbt3);
        radioButtons = new ArrayList<>();
        radioButtons.add(rbt1);
        radioButtons.add(rbt2);
        radioButtons.add(rbt3);*/
    }

    private ImageView ivGuidePage;

    private void initGuidePage() {
        cbTest.setPages(new CBViewHolderCreator() {
            private void initView() {
                ivGuidePage = (ImageView) findViewById(R.id.iv_guide_page);
            }


            @Override
            public Holder createHolder(View itemView) {
                return new LocalImageHolderView(itemView);
            }

            @Override
            public int getLayoutId() {
                //设置加载哪个布局
                return R.layout.item_guide_page;
            }

        }, arrayList)
                // .setPageIndicator(new int[]{R.mipmap.a, R.mipmap.b})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL)
                .setPointViewVisible(true)

                .setCanLoop(false)
                .setOnPageChangeListener(new OnPageChangeListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                    }

                    @Override
                    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

                    }

                    @Override
                    public void onPageSelected(int index) {
                        //总共添加了三张图片，如果index为2表示到了最后一张图片，隐藏下面的指示器，显示跳转到主页的按钮
                        if (index == 4) {

                            btnTest.setVisibility(View.VISIBLE);
                            cbTest.setPointViewVisible(false);
                        } else {
                            btnTest.setVisibility(View.GONE);
                            cbTest.setPointViewVisible(true);

                        }
                    }
                });
    }


    /**
     * 轮播图2 对应的holder
     */
    public class LocalImageHolderView extends Holder<Integer> {
        private ImageView mImageView;

        //构造器
        public LocalImageHolderView(View itemView) {
            super(itemView);
        }

        @Override
        protected void initView(View itemView) {
            mImageView = itemView.findViewById(R.id.iv_guide_page);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        @Override
        public void updateUI(Integer data) {
            mImageView.setImageResource(data);
        }
    }
}
