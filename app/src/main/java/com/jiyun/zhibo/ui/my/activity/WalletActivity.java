package com.jiyun.zhibo.ui.my.activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jiyun.zhibo.R;
import com.jiyun.zhibo.base.BaseActivity;
import com.jiyun.zhibo.contract.PayContract;
import com.jiyun.zhibo.model.entify.MoneyDataBean;
import com.jiyun.zhibo.model.entify.PayInFoData;
import com.jiyun.zhibo.presenter.PayPresenter;
import com.jiyun.zhibo.ui.my.adapter.MoneyAdapter;
import com.jiyun.zhibo.utils.SavaShareUtils;
import com.jiyun.zhibo.view.GlideCircleTransform;
import com.jiyun.zhibo.view.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
public class WalletActivity extends BaseActivity<PayPresenter> implements PayContract.View {

    @BindView(R.id.pay_finish)
    ImageView payFinish;
    @BindView(R.id.pay_tixian)
    TextView payTixian;
    @BindView(R.id.pay_photo)
    ImageView payPhoto;
    @BindView(R.id.pay_name)
    TextView payName;
    @BindView(R.id.pay_keyong_yue)
    TextView payKeyongYue;
    @BindView(R.id.pay_keti_yue)
    TextView payKetiYue;
    @BindView(R.id.pay_chongzhijilv)
    LinearLayout payChongzhijilv;
    @BindView(R.id.pay_recycler)
    RecyclerView payRecycler;
    @BindView(R.id.pay_zhifubao)
    TextView payZhifubao;
    @BindView(R.id.pay_weixin)
    TextView payWeixin;
    @BindView(R.id.pay_ok)
    Button payOk;
    private LinearLayout linearLayout;

    private View lastView;
    private List<MoneyDataBean.DataBean.ListBean> mList;
    private MoneyAdapter moneyAdapter;

    @Override
    protected int getLayOutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void init() {
        mList = new ArrayList<>();
        payRecycler.setLayoutManager(new GridLayoutManager(this,3));
        payRecycler.addItemDecoration(new SpaceItemDecoration(15,5));
        moneyAdapter = new MoneyAdapter(R.layout.pay_view_view, mList);
        payRecycler.setAdapter(moneyAdapter);
        moneyAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (linearLayout != null){
                    linearLayout.setBackground(getResources().getDrawable(R.drawable.pay_shape));
                }
                LinearLayout viewById = view.findViewById(R.id.pay_view_view_linear);
                viewById.setBackground(getResources().getDrawable(R.drawable.register_shape));
                linearLayout = viewById;
            }
        });

    }

    @Override
    protected void loadData() {
        presenter.getPayInFo();
        presenter.getMoneyData();

    }
    @OnClick({R.id.pay_finish, R.id.pay_tixian, R.id.pay_chongzhijilv, R.id.pay_zhifubao, R.id.pay_weixin, R.id.pay_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pay_finish:
                finish();
                break;
            case R.id.pay_tixian:

                break;
            case R.id.pay_chongzhijilv:
                break;
            case R.id.pay_zhifubao:
                payZhifubao.setBackground(getResources().getDrawable(R.drawable.register_shape));
                payWeixin.setBackground(getResources().getDrawable(R.drawable.pay_shape));
                break;
            case R.id.pay_weixin:
                payWeixin.setBackground(getResources().getDrawable(R.drawable.register_shape));
                payZhifubao.setBackground(getResources().getDrawable(R.drawable.pay_shape));
                break;
            case R.id.pay_ok:

                break;
        }
    }



    @Override
    public void showPayInFoData(PayInFoData payInFoData) {
        if (payInFoData.getData() == null)
            return;
        PayInFoData.DataBean data = payInFoData.getData();
        payName.setText(SavaShareUtils.getInstance().getName());
        Glide.with(this).load(SavaShareUtils.getInstance().getPhoto()).bitmapTransform(new GlideCircleTransform(this)).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(payPhoto);
        payKeyongYue.setText(data.getUserBalance()+"艺币");
        payKetiYue.setText(data.getUsableBalance()+"艺币");
    }

    @Override
    public void showMoneyData(MoneyDataBean moneyDataBean) {
        mList.addAll(moneyDataBean.getData().getList());
        moneyAdapter.notifyDataSetChanged();

    }
}
