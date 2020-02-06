package com.wd.health.view.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.dingmouren.layoutmanagergroup.viewpager.OnViewPagerListener;
import com.dingmouren.layoutmanagergroup.viewpager.ViewPagerLayoutManager;
import com.wd.health.R;
import com.wd.health.base.BaseFragment;
import com.wd.health.contract.Video_CategoryListContract;
import com.wd.health.model.bean.ChaXunShiPin_DataBean;
import com.wd.health.model.bean.ChaXunShiPin_ResutBean;
import com.wd.health.model.bean.Video_TablayoutDataBean;
import com.wd.health.model.bean.Video_TablayoutResultBean;
import com.wd.health.presenter.Video_CategoryListPresent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Right_fragment extends BaseFragment<Video_CategoryListPresent> implements Video_CategoryListContract.Video_CategoryView {
    private static final String TAG = "ViewPagerActivity";
    @BindView(R.id.recycler)
    RecyclerView mrecycler;
    @BindView(R.id.line_bottom)
    VideoView lineBottom;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    Unbinder unbinder;
    @BindView(R.id.rbt_one)
    RadioButton rbtOne;
    @BindView(R.id.rbt_two)
    RadioButton rbtTwo;
    @BindView(R.id.rbt_three)
    RadioButton rbtThree;
    @BindView(R.id.rbt_four)
    RadioButton rbtFour;
    @BindView(R.id.rbt_five)
    RadioButton rbtFive;
    @BindView(R.id.rbt_six)
    RadioButton rbtSix;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ViewPagerLayoutManager mLayoutManager;
    public ArrayList<String> list = new ArrayList();

    public ArrayList<RadioButton> rbtlist = new ArrayList();


    private String shearUrl;
    private ChaXunShiPin_DataBean bean;
    private List<ChaXunShiPin_DataBean> result;
    private MyAdapter myAdapter;

    @Override
    protected Video_CategoryListPresent providePresenter() {
        return new Video_CategoryListPresent();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.right;
    }

    @Override
    public void succeed(Video_TablayoutResultBean video_tablayoutResultBean) {
        List<Video_TablayoutDataBean> result = video_tablayoutResultBean.getResult();

            for (int i = 0; i < result.size(); i++) {
                Video_TablayoutDataBean video_tablayoutDataBean = result.get(i);
                String name = video_tablayoutDataBean.getName();

                RadioButton radioButton = rbtlist.get(i);
                radioButton.setText(name);
                radioButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        list.clear();
                        int id = video_tablayoutDataBean.getId();
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("page",1);
                        map.put("count",10);
                        map.put("categoryId",id);
                        mPresenter.chaXun(map);
                        Log.d("id是",id+"");
                    }
                });

            }
        }
    @Override
    public void failure(Throwable throwable) {

    }

    @Override
    public void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean) {
        Log.d("是否成功",chaXunShiPin_resutBean.getMessage());
        Log.d("1111111111111","22222222222222");
        result = chaXunShiPin_resutBean.getResult();
        for (int i=0;i<result.size();i++){
            bean = result.get(i);
            shearUrl = bean.getShearUrl();
            String originalUrl = bean.getOriginalUrl();
            list.add(shearUrl);
            list.add(originalUrl);
        }
        Log.d("456",list.size()+"");

        ArrayList<String> list = this.list;
        myAdapter.setSlist(this.list);
        myAdapter.notifyDataSetChanged();
        mrecycler.setAdapter(mAdapter);
    }


    @Override
    protected void initData() {
        super.initData();


     /*   HashMap<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("count",5);
        map.put("categoryId",1);
        mPresenter.chaXun(map);
       */
        mPresenter.categoryListShow();

        initListener();

        rbtlist.add(rbtOne);
        rbtlist.add(rbtTwo);
        rbtlist.add(rbtThree);
        rbtlist.add(rbtFour);
        rbtlist.add(rbtFive);
        rbtlist.add(rbtSix);

    }

    @Override
    protected void initView() {
        super.initView();
        myAdapter = new MyAdapter();
        mLayoutManager = new ViewPagerLayoutManager(getContext(), OrientationHelper.VERTICAL);
        mAdapter = new MyAdapter();
        mrecycler.setLayoutManager(mLayoutManager);
    }
    private void initListener() {
        mLayoutManager.setOnViewPagerListener(new OnViewPagerListener() {

            @Override
            public void onInitComplete() {
                Log.e(TAG, "onInitComplete");
                playVideo(0);
            }

            @Override
            public void onPageRelease(boolean isNext, int position) {
                Log.e(TAG, "释放位置:" + position + " 下一页:" + isNext);
                int index = 0;
                if (isNext) {
                    index = 0;
                } else {
                    index = 1;
                }
                releaseVideo(index);
            }

            @Override
            public void onPageSelected(int position, boolean isBottom) {
                Log.e(TAG, "选中位置:" + position + "  是否是滑动到底部:" + isBottom);
                playVideo(0);
            }


        });
    }

    private void playVideo(int position) {
        View itemView = mrecycler.getChildAt(0);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final RelativeLayout rootView = itemView.findViewById(R.id.root_view);
        final MediaPlayer[] mediaPlayer = new MediaPlayer[1];
        videoView.start();
        videoView.setOnInfoListener(new MediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(MediaPlayer mp, int what, int extra) {
                mediaPlayer[0] = mp;
                mp.setLooping(true);
                imgThumb.animate().alpha(0).setDuration(200).start();
                return false;
            }
        });
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {

            }
        });


        imgPlay.setOnClickListener(new View.OnClickListener() {
            boolean isPlaying = true;

            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    imgPlay.animate().alpha(1f).start();
                    videoView.pause();
                    isPlaying = false;
                } else {
                    imgPlay.animate().alpha(0f).start();
                    videoView.start();
                    isPlaying = true;
                }
            }
        });
    }

    private void releaseVideo(int index) {
        View itemView = mrecycler.getChildAt(index);
        final VideoView videoView = itemView.findViewById(R.id.video_view);
        final ImageView imgThumb = itemView.findViewById(R.id.img_thumb);
        final ImageView imgPlay = itemView.findViewById(R.id.img_play);
        videoView.stopPlayback();
        imgThumb.animate().alpha(1).start();
        imgPlay.animate().alpha(0f).start();
    }

    //查询视频列表的播放视频
  /*  @Override
    public void onChaXunShiPinSuccess(ChaXunShiPin_ResutBean chaXunShiPin_resutBean) {
        if (chaXunShiPin_resutBean.getMessage().equals("0000")){
            Log.d("是否成功",chaXunShiPin_resutBean.getMessage());
            Log.d("1111111111111","22222222222222");
            result = chaXunShiPin_resutBean.getResult();
            for (int i=0;i<result.size();i++){
                bean = result.get(i);
                shearUrl = bean.getShearUrl();
                list.add(shearUrl);
            }
            Log.d("456",list.size()+"");
            MyAdapter myAdapter = new MyAdapter();
            myAdapter.setSlist(list);
        }


    }*/

    @Override
    public void onChaXunShiPinFailure(Throwable e) {
        Log.d("1111111111111","失败");
    }


  public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        //private int[] imgs = {R.mipmap.img_video_1,R.mipmap.img_video_2};
        //private int[] videos = {R.raw.video_1,R.raw.video_2};
        public ArrayList<String> slist=new ArrayList<>();



      public void setSlist(ArrayList<String> slist) {
          this.slist = slist;
      }

      public MyAdapter() {
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            //holder.img_thumb.setImageResource(imgs[position%2]);

         ArrayList<String> dlist=  Right_fragment.this.list;
         Log.d("123",dlist.size()+"");
         Log.d("489",slist.size()+"");
            if (dlist.size()!=0){
                holder.videoView.setVideoURI(Uri.parse(dlist.get(position)));
                //holder.videoView.setVideoURI(Uri.parse(dlist.get(position % 3)));
            }




        }

        @Override
        public int getItemCount() {
            return 20;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView img_thumb;
            VideoView videoView;
            ImageView img_play;
            RelativeLayout rootView;

            public ViewHolder(View itemView) {
                super(itemView);
                img_thumb = itemView.findViewById(R.id.img_thumb);
                videoView = itemView.findViewById(R.id.video_view);
                img_play = itemView.findViewById(R.id.img_play);
                rootView = itemView.findViewById(R.id.root_view);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
