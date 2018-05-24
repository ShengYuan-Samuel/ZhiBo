package com.jiyun.zhibo.ui.live.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.contract.OpenLiveContract;
import com.jiyun.zhibo.model.entify.Data;
import com.jiyun.zhibo.model.entify.GiftBean;
import com.jiyun.zhibo.model.entify.IMGift;
import com.jiyun.zhibo.model.entify.ReceiveUser;
import com.jiyun.zhibo.model.entify.SendUser;
import com.jiyun.zhibo.presenter.OpenLivePresenter;
import com.jiyun.zhibo.ui.live.adapter.GiftGridAdapter;
import com.jiyun.zhibo.ui.live.adapter.ViewVAdapter;
import com.jiyun.zhibo.ui.my.activity.WalletActivity;
import com.jiyun.zhibo.utils.KeyBoardUtils;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.view.BubbleView;
import com.jiyun.zhibo.view.DisplayUtil;
import com.jiyun.zhibo.view.GlideCircleTransform;
import com.jiyun.zhibo.view.LiveGiftUtil;
import com.jiyun.zhibo.view.SoftKeyBoardListener;
import com.tencent.rtmp.TXLivePlayer;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OpenLiveActivity extends BaseActivity<OpenLivePresenter> implements OpenLiveContract.View, View.OnTouchListener {


    @BindView(R.id.open_live_live)
    TXCloudVideoView openLiveLive;
    @BindView(R.id.open_photo)
    ImageView openPhoto;
    @BindView(R.id.open_name)
    TextView openName;
    @BindView(R.id.open_number)
    TextView openNumber;
    @BindView(R.id.open_add)
    ImageView openAdd;
    @BindView(R.id.open_fensihui)
    Button openFensihui;
    @BindView(R.id.open_recycler)
    RecyclerView openRecycler;
    @BindView(R.id.open_finish)
    ImageView openFinish;
    @BindView(R.id.open_room)
    TextView openRoom;
    @BindView(R.id.open_contribute)
    TextView openContribute;
    @BindView(R.id.open_music)
    ImageView openMusic;
    @BindView(R.id.open_xinxi)
    ImageView openXinxi;
    @BindView(R.id.open_gift)
    ImageView openGift;
    @BindView(R.id.open_fanzhuan)
    ImageView openFanzhuan;
    @BindView(R.id.llgiftcontent)
    LinearLayout llgiftcontent;
    @BindView(R.id.open_live_buttom_relative)
    RelativeLayout openLiveButtomRelative;
    @BindView(R.id.etInput)
    EditText etInput;
    @BindView(R.id.sendInput)
    TextView sendInput;
    @BindView(R.id.llinputparent)
    LinearLayout llinputparent;

    private String url;
    private int liveId;
    private int viewNum;
    private String avatar;
    private String nickName;
    private TXLivePusher mLivePusher;
    private TXLivePushConfig txLivePushConfig;
    private TXLivePlayer mLivePlayer;
    private List<GiftBean.DataBean.ListBean> mList;
    private List<View> mView;
    private ViewPager gift_pager;
    private TextView gift_chongzhi;
    private TextView gitf_num_tv;
    private TextView gitf_zengsongBtu;
    private PopupWindow popupWindow;
    private List<GiftBean.DataBean.ListBean> mList1;
    private List<GiftBean.DataBean.ListBean> mList2;
    private List<GiftBean.DataBean.ListBean> mList3;
    private CoutomGridView gift_gridview_view;
    private CoutomGridView gift_gridview_view1;
    private CoutomGridView gift_gridview_view2;
    private LinearLayout popup_linear;
    private float x;
    private float y;
    private BubbleView viewById;
    private IMGift imGift;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_open_live;
    }

    @Override
    protected void init() {
        // TXLivePusher txLivePusher = new TXLivePusher(this);
        //  TXLivePushConfig txLivePushConfig = new TXLivePushConfig();
        // txLivePusher.setConfig(txLivePushConfig);
        //txLivePusher.startCameraPreview(openLiveLive);
        //创建 player 对象
        viewById = findViewById(R.id.open_relative);
        viewById.setDefaultDrawableList();
        viewById.setOnTouchListener(this);
       /* viewById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        //softKeyboardListnenr();
        mList = new ArrayList<>();
        mView = new ArrayList<>();
        Intent intent = getIntent();
        String abc = intent.getStringExtra("abc");
        url = intent.getStringExtra("url");
        liveId = intent.getIntExtra("liveId", 0);
        nickName = intent.getStringExtra("nickName");
        viewNum = intent.getIntExtra("viewNum", 0);
        avatar = intent.getStringExtra("avatar");
        if ("拉".equals(abc)) {
            setData();
            openFanzhuan.setVisibility(View.GONE);
            mLivePlayer = new TXLivePlayer(this);
            //关键 player 对象与界面 view
            mLivePlayer.setPlayerView(openLiveLive);
            //String flvUrl = "rtmp://22048.liveplay.myqcloud.com/live/22048_443362640358539264";
            mLivePlayer.startPlay(url, TXLivePlayer.PLAY_TYPE_LIVE_RTMP); //推荐 FLV
        } else {
            openFanzhuan.setVisibility(View.VISIBLE);
            mLivePusher = new TXLivePusher(this);
            txLivePushConfig = new TXLivePushConfig();
            mLivePusher.setConfig(txLivePushConfig);
            mLivePusher.startPusher(url);
            mLivePusher.startCameraPreview(openLiveLive);
        }

        /*
        rtmp://22048.liveplay.myqcloud.com/live/22048_443362640358539264
         */
    }

    @Override
    protected void loadData() {
        presenter.getGiftBean();

    }

    private void setData() {
        Glide.with(this).load(avatar).bitmapTransform(new GlideCircleTransform(this))
                .diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(openPhoto);
        openName.setText(nickName);
        openNumber.setText(viewNum + "人在线");
        openRoom.setText(liveId + "");
    }


    @OnClick({R.id.sendInput,R.id.open_fanzhuan, R.id.open_photo, R.id.open_add, R.id.open_fensihui, R.id.open_finish, R.id.open_music, R.id.open_xinxi, R.id.open_gift})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sendInput:
                openLiveButtomRelative.setVisibility(View.VISIBLE);
                llinputparent.setVisibility(View.GONE);
                KeyBoardUtils.closeKeybord(etInput,this);
                break;
            case R.id.open_photo:
                break;
            case R.id.open_add:
                break;
            case R.id.open_fensihui:
                break;
            case R.id.open_finish:
                finish();
                break;
            case R.id.open_music:
                break;
            case R.id.open_xinxi:
              //  showSoftInputFromWindow(this,etInput);
                openLiveButtomRelative.setVisibility(View.GONE);
                llinputparent.setVisibility(View.VISIBLE);
              //  KeyBoardUtils.openKeybord(etInput,this);
                //showKeyboard();
                break;
            case R.id.open_gift:
                popupWindow.showAtLocation(findViewById(R.id.open_relative), Gravity.BOTTOM, 0, 0);
                break;
            case R.id.open_fanzhuan:

                txLivePushConfig.setFrontCamera(false);
                mLivePusher.switchCamera();
                break;
        }
    }
    /**
     * EditText获取焦点并显示软键盘
     */
    public static void showSoftInputFromWindow(Activity activity, EditText editText) {
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mLivePlayer != null) {
            mLivePlayer.stopPlay(true); // true 代表清除最后一帧画面
            openLiveLive.onDestroy();
        }
    }

    @Override
    public void showGiftBean(GiftBean giftBean) {
        Log.d("OpenLiveActivity", "giftBean.getData().getList().size():" + giftBean.getData().getList().size());

        mList.addAll(giftBean.getData().getList());
        initGiftPopup();

    }

    private void initGiftPopup() {
        View inflate = getLayoutInflater().inflate(R.layout.gift_popup_view, null);
        gift_pager = inflate.findViewById(R.id.gift_pager);
        gift_chongzhi = inflate.findViewById(R.id.gift_chongzhi);
        gitf_num_tv = inflate.findViewById(R.id.gitf_num_tv);
        popup_linear = inflate.findViewById(R.id.popup_linear);
        gitf_zengsongBtu = inflate.findViewById(R.id.gitf_zengsongBtu);
        inflate.findViewById(R.id.click_yishengyishi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gitf_num_tv.setText("1314");
                popup_linear.setVisibility(View.GONE);
            }
        });

        inflate.findViewById(R.id.click_liu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gitf_num_tv.setText("666");
                popup_linear.setVisibility(View.GONE);
            }
        });
        inflate.findViewById(R.id.click_aiyi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gitf_num_tv.setText("21");
                popup_linear.setVisibility(View.GONE);
            }
        });
        inflate.findViewById(R.id.click_yifen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gitf_num_tv.setText("1");
                popup_linear.setVisibility(View.GONE);
            }
        });
        initGrid();
        popupWindow = new PopupWindow(inflate, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setOutsideTouchable(true);
        gift_chongzhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OpenLiveActivity.this, WalletActivity.class));
            }
        });
        gitf_num_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup_linear.setVisibility(View.VISIBLE);
            }
        });
        gitf_zengsongBtu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LiveGiftUtil liveGiftUtil = new LiveGiftUtil();
                if (llgiftcontent != null) {
                    liveGiftUtil.showGift(imGift, llgiftcontent, OpenLiveActivity.this);
                    liveGiftUtil.clearTiming(llgiftcontent, OpenLiveActivity.this);
                    popupWindow.dismiss();
                }
            }
        });
    }

    private void initGrid() {
        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();
        mList3 = new ArrayList<>();
        gift_gridview_view = new CoutomGridView(mList1,this);
        gift_gridview_view1 = new CoutomGridView(mList2,this);
        gift_gridview_view2 = new CoutomGridView(mList3,this);
        gift_gridview_view.setGiftOnClick(new CoutomGridView.giftOnClick() {
            @Override
            public void giftOnclick(int position, GiftBean.DataBean.ListBean listBean) {
                gift_gridview_view2.clearAdapter();
                gift_gridview_view1.clearAdapter();
                imGift = new IMGift(1, 1527041015267l, new Data(listBean.getId(), Integer.valueOf(gitf_num_tv.getText().toString().trim()), listBean.getGiftName(), listBean.getGiftPic(), new SendUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png"), new ReceiveUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png")));
            }
        });
        gift_gridview_view1.setGiftOnClick(new CoutomGridView.giftOnClick() {
            @Override
            public void giftOnclick(int position, GiftBean.DataBean.ListBean listBean) {
                gift_gridview_view2.clearAdapter();
                gift_gridview_view.clearAdapter();
                imGift = new IMGift(1, 1527041015267l, new Data(listBean.getId(), Integer.valueOf(gitf_num_tv.getText().toString().trim()), listBean.getGiftName(), listBean.getGiftPic(), new SendUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png"), new ReceiveUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png")));
            }
        });
        gift_gridview_view2.setGiftOnClick(new CoutomGridView.giftOnClick() {
            @Override
            public void giftOnclick(int position, GiftBean.DataBean.ListBean listBean) {
                gift_gridview_view.clearAdapter();
                gift_gridview_view1.clearAdapter();
                imGift = new IMGift(1, 1527041015267l, new Data(listBean.getId(), Integer.valueOf(gitf_num_tv.getText().toString().trim()), listBean.getGiftName(), listBean.getGiftPic(), new SendUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png"), new ReceiveUser(SavaShareUtils.getInstance().getUserNo(), "张标", "http://art.nos-eastchina1.126.net/108.png")));

            }
        });


        for (int i = 0; i < mList.size(); i++) {
            if (i <= 7) {
                mList1.add(mList.get(i));
            } else if (i <= 15) {
                mList2.add(mList.get(i));
            } else {
                mList3.add(mList.get(i));
            }

        }
        mView.add(gift_gridview_view.getView());
        mView.add(gift_gridview_view1.getView());
        mView.add(gift_gridview_view2.getView());


        gift_pager.setAdapter(new ViewVAdapter(mView));
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            /**
             * 点击的开始位置
             */
            case MotionEvent.ACTION_DOWN:
                // tvTouchShowStart.setText("起始位置：(" + event.getX() + "," + event.getY());
                break;
            /**
             * 触屏实时位置
             */
            case MotionEvent.ACTION_MOVE:

                break;
            /**
             * 离开屏幕的位置
             */
            case MotionEvent.ACTION_UP:
                // tvTouchShow.setText("结束位置：(" + event.getX() + "," + event.getY());
                x = event.getX();
                Log.d("OpenLiveActivity", x + ":" + y);
                y = event.getY();
                viewById.startAnimation(x, y, 1);
                break;
            default:
                break;
        }
        /**
         *  注意返回值
         *  true：view继续响应Touch操作；
         *  false：view不再响应Touch操作，故此处若为false，只能显示起始位置，不能显示实时位置和结束位置
         */
        return true;
    }
















   /* *//**
     * 显示软键盘并因此头布局
     *//*
    private void showKeyboard() {
        llinputparent.requestFocus();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(etInput, InputMethodManager.SHOW_FORCED);
            }
        }, 100);
    }

    *//**
     * 隐藏软键盘并显示头布局
     *//*
    public void hideKeyboard() {
        openLiveButtomRelative.setVisibility(View.VISIBLE);
        llinputparent.setVisibility(View.GONE);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etInput.getWindowToken(), 0);
    }
    *//**
     * 软键盘显示与隐藏的监听
     *//*
    private void softKeyboardListnenr() {
        SoftKeyBoardListener.setListener(this, new SoftKeyBoardListener.OnSoftKeyBoardChangeListener() {
            @Override
            public void keyBoardShow(int height) {*//*软键盘显示：执行隐藏title动画，并修改listview高度和装载礼物容器的高度*//*
                dynamicChangeGiftParentH(true);
            }
            @Override
            public void keyBoardHide(int height) {*//*软键盘隐藏：隐藏聊天输入框并显示聊天按钮，执行显示title动画，并修改listview高度和装载礼物容器的高度*//*
                openLiveButtomRelative.setVisibility(View.VISIBLE);
                llinputparent.setVisibility(View.GONE);
               // dynamicChangeGiftParentH(false);

            }
        });
    }


    *//**
     * 动态的修改listview的高度
     * @param heightPX
     *//*
    private void dynamicChangeListviewH(int heightPX) {
        ViewGroup.LayoutParams layoutParams =scoll_view .getLayoutParams();
        layoutParams.height= DisplayUtil.dip2px(this,heightPX);
        scoll_view.setLayoutParams(layoutParams);
    }

    *//**
     * 动态修改礼物父布局的高度
     * @param showhide
     *//*
    private void dynamicChangeGiftParentH(boolean showhide){
        if(showhide){*//*如果软键盘显示中*//*
            if(llgiftcontent.getChildCount()!=0){
                *//*判断是否有礼物显示，如果有就修改父布局高度，如果没有就不作任何操作*//*
                ViewGroup.LayoutParams layoutParams = llgiftcontent.getLayoutParams();
                layoutParams.height=llgiftcontent.getChildAt(0).getHeight();
                llgiftcontent.setLayoutParams(layoutParams);
            }
        }else{*//*如果软键盘隐藏中*//*
            *//*就将装载礼物的容器的高度设置为包裹内容*//*
            ViewGroup.LayoutParams layoutParams = llgiftcontent.getLayoutParams();
            layoutParams.height= ViewGroup.LayoutParams.WRAP_CONTENT;
            llgiftcontent.setLayoutParams(layoutParams);
        }
    }
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    break;
            }
        }
    };*/




}

/**
 *



 */

