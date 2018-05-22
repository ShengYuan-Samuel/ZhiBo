package com.jiyun.zhibo.ui.live.fragment;


import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseFragment;
import com.jiyun.zhibo.contract.ZiYouBoContract;
import com.jiyun.zhibo.model.entify.ImageBean;
import com.jiyun.zhibo.model.entify.OpenRoomBean;
import com.jiyun.zhibo.presenter.ZiYouBoPresenter;
import com.jiyun.zhibo.ui.live.activity.MyLiveActivity;
import com.jiyun.zhibo.ui.live.activity.OpenLiveActivity;
import com.jiyun.zhibo.ui.live.adapter.ZiYouAdapter;
import com.jiyun.zhibo.utils.ToastUtil;
import com.jiyun.zhibo.view.MyCountTimer;
import com.jiyun.zhibo.view.RoundImageView;
import com.jiyun.zhibo.view.TimeDownView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.app.Activity.RESULT_OK;
import static android.graphics.BitmapFactory.decodeResource;


public class ZiYouBoFragment extends BaseFragment<ZiYouBoPresenter> implements ZiYouBoContract.View {


    @BindView(R.id.ziyoubo_photo)
    RoundImageView ziyouboPhoto;
    @BindView(R.id.ziyoubo_contentEt)
    EditText ziyouboContentEt;
    @BindView(R.id.ziyoubo_wechat)
    ImageView ziyouboWechat;
    @BindView(R.id.ziyoubo_weibo)
    ImageView ziyouboWeibo;
    @BindView(R.id.ziyoubo_wechat_friend)
    ImageView ziyouboWechatFriend;
    @BindView(R.id.ziyoubo_meiYan)
    LinearLayout ziyouboMeiYan;
    @BindView(R.id.ziyoubo_startBtu)
    Button ziyouboStartBtu;
    @BindView(R.id.ziyoubo_xieyiTv)
    TextView ziyouboXieyiTv;
    @BindView(R.id.meibai_bar)
    SeekBar meibaiBar;
    @BindView(R.id.mopi_bar)
    SeekBar mopiBar;
    @BindView(R.id.hongrui_bar)
    SeekBar hongruiBar;
    @BindView(R.id.meiyan_recycler)
    RecyclerView meiyanRecycler;
    @BindView(R.id.meiyan_linear)
    LinearLayout meiyanLinear;
    @BindView(R.id.meiyan_relative)
    RelativeLayout meiyanRelative;

    @BindView(R.id.relati_kk)
    RelativeLayout relati_kk;
    @BindView(R.id.open_start_tv)
    TimeDownView openStartTv;

    private List<ImageBean> mList;
    private List<Integer> mLists;
    private ZiYouAdapter ziYouAdapter;
    private ImageView index;
    private int meibai = 0;
    private int mobi = 0;
    private int hongrui = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_zi_you_bo;
    }

    @Override
    protected void init() {

        if (MyLiveActivity.mLivePusher != null) {
            MyLiveActivity.mLivePusher.setBeautyFilter(1, 0, 0, 0);
        }
        mList = new ArrayList<>();
        mLists = new ArrayList<>();
        mLists.add(0);
        mLists.add(R.drawable.filter_langman);
        mLists.add(R.drawable.filter_qingxin);
        mLists.add(R.drawable.filter_weimei);
        mLists.add(R.drawable.filter_fennen);
        mLists.add(R.drawable.filter_huaijiu);
        mLists.add(R.drawable.filter_landiao);
        mLists.add(R.drawable.filter_qingliang);
        mLists.add(R.drawable.filter_rixi);
        mList.add(new ImageBean(R.drawable.orginal, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.langman, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.qingxin, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.weimei, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.fennei, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.huaijiu, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.landiao, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.qingliang, R.drawable.select_view));
        mList.add(new ImageBean(R.drawable.rixi, R.drawable.select_view));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        meiyanRecycler.setLayoutManager(linearLayoutManager);
        ziYouAdapter = new ZiYouAdapter(mList);
        meiyanRecycler.setAdapter(ziYouAdapter);
        ziYouAdapter.setOnClick(new ZiYouAdapter.PhotoOnClickCallBack() {
            @Override
            public void setOnCilck(View view, int position) {
                if (index != null) {
                    index.setVisibility(View.INVISIBLE);
                }
                ImageView viewById = view.findViewById(R.id.select_image);
                viewById.setVisibility(View.VISIBLE);
                index = viewById;
                Bitmap bmp = null;


                switch (position) {
                    case 0:
                        bmp = decodeResource(getResources(), mLists.get(0));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;
                    case 1:
                        bmp = decodeResource(getResources(), mLists.get(1));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;
                    case 2:
                        bmp = decodeResource(getResources(), mLists.get(2));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;

                    case 3:
                        bmp = decodeResource(getResources(), mLists.get(3));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;

                    case 4:
                        bmp = decodeResource(getResources(), mLists.get(4));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;

                    case 5:
                        bmp = decodeResource(getResources(), mLists.get(5));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;

                    case 6:
                        bmp = decodeResource(getResources(), mLists.get(6));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;
                    case 7:
                        bmp = decodeResource(getResources(), mLists.get(7));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;
                    case 8:
                        bmp = decodeResource(getResources(), mLists.get(8));
                        if (MyLiveActivity.mLivePusher != null) {
                            MyLiveActivity.mLivePusher.setFilter(bmp);
                        }
                        break;


                }
            }
        });
        meibaiBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                meibai = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MyLiveActivity.mLivePusher.setBeautyFilter(1, mobi, meibai, hongrui);

            }
        });

        mopiBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mobi = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MyLiveActivity.mLivePusher.setBeautyFilter(1, mobi, meibai, hongrui);


            }
        });
        hongruiBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                hongrui = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                MyLiveActivity.mLivePusher.setBeautyFilter(1, mobi, meibai, hongrui);

            }
        });

    }

    @Override
    protected void loadData() {

    }


    @OnClick({R.id.relati_kk, R.id.ziyoubo_photo, R.id.ziyoubo_wechat, R.id.ziyoubo_weibo, R.id.ziyoubo_wechat_friend, R.id.ziyoubo_meiYan, R.id.ziyoubo_startBtu, R.id.ziyoubo_xieyiTv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.relati_kk:
                meiyanRelative.setVisibility(View.VISIBLE);
                meiyanLinear.setVisibility(View.INVISIBLE);
                break;
            case R.id.ziyoubo_photo:
                selectPhoto();
                Toast.makeText(getContext(), "我去选择照片了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_wechat:
                Toast.makeText(getContext(), "我去微信了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_weibo:
                Toast.makeText(getContext(), "我去微博了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_wechat_friend:
                Toast.makeText(getContext(), "我去朋友圈了", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ziyoubo_meiYan:
                Toast.makeText(getContext(), "我去美颜了", Toast.LENGTH_SHORT).show();
                meiyanRelative.setVisibility(View.INVISIBLE);
                meiyanLinear.setVisibility(View.VISIBLE);
                break;
            case R.id.ziyoubo_startBtu:
                presenter.getOpenRoomData("110114", "0", ziyouboContentEt.getText().toString().trim());
                break;
            case R.id.ziyoubo_xieyiTv:
                Toast.makeText(getContext(), "我去协议了", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    private void selectPhoto() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");//相片类型
        startActivityForResult(intent, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1:
                    Uri imageUri = data.getData();
                    if (imageUri != null) {
                        Bitmap bm = compressBitmap(null, null, getContext(), data.getData(), 4, false);
                        ziyouboPhoto.setImageBitmap(bm);
                    }


                    break;

            }
        }
    }

    /*  *//**
     * 获取压缩图片的options
     *
     * @return
     *//*
    public  BitmapFactory.Options getOptions(String path) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, options);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inSampleSize = 4;      //此项参数可以根据需求进行计算
        options.inJustDecodeBounds = false;

        return options;
    }*/

    /**
     * 图片压缩处理，size参数为压缩比，比如size为2，则压缩为1/4
     **/
    private Bitmap compressBitmap(String path, byte[] data, Context context, Uri uri, int size, boolean width) {
        BitmapFactory.Options options = null;
        if (size > 0) {
            BitmapFactory.Options info = new BitmapFactory.Options();
/**如果设置true的时候，decode时候Bitmap返回的为数据将空*/
            info.inJustDecodeBounds = false;
            decodeBitmap(path, data, context, uri, info);
            int dim = info.outWidth;
            if (!width) dim = Math.max(dim, info.outHeight);
            options = new BitmapFactory.Options();
/**把图片宽高读取放在Options里*/
            options.inSampleSize = size;
        }
        Bitmap bm = null;
        try {
            bm = decodeBitmap(path, data, context, uri, options);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bm;
    }


    /**
     * 把byte数据解析成图片
     */
    private Bitmap decodeBitmap(String path, byte[] data, Context context, Uri uri, BitmapFactory.Options options) {
        Bitmap result = null;
        if (path != null) {
            result = BitmapFactory.decodeFile(path, options);
        } else if (data != null) {
            result = BitmapFactory.decodeByteArray(data, 0, data.length, options);
        } else if (uri != null) {
            ContentResolver cr = context.getContentResolver();
            InputStream inputStream = null;
            try {
                inputStream = cr.openInputStream(uri);
                result = BitmapFactory.decodeStream(inputStream, null, options);
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void showOpenRoomData(final OpenRoomBean openRoomBean) {
        if (openRoomBean == null)
            return;
        if (Integer.valueOf(openRoomBean.getCode()) == 200) {
            openStartTv.setVisibility(View.VISIBLE);
          /*  long time = 4000;
            MyCountTimer myCountTimer = new MyCountTimer(time, 1000, openStartTv, "");
            myCountTimer.start();*/
            openStartTv.downSecond(3);
            openStartTv.setOnTimeDownListener(new TimeDownView.DownTimeWatcher() {
                @Override
                public void onTime(int num) {

                }

                @Override
                public void onLastTime(int num) {

                }

                @Override
                public void onLastTimeFinish(int num) {
                    openStartTv.setVisibility(View.GONE);
                    Intent intent = new Intent(getContext(), OpenLiveActivity.class);
                    intent.putExtra("abc", "推");
                    intent.putExtra("url", openRoomBean.getData().getPushUrl());

                    startActivity(intent);
                }
            });



/*
               */
          /*  */
        }
        Log.d("ZiYouBoFragment", openRoomBean.getCode());

    }


    @Override
    public void showErrorMeg(String error) {
        ToastUtil.showShort(getContext(), error);
    }

}

