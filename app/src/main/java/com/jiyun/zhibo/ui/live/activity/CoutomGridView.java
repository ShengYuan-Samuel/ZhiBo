package com.jiyun.zhibo.ui.live.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.jiyun.zhibo.R;
import com.jiyun.zhibo.model.entify.GiftBean;
import com.jiyun.zhibo.ui.live.adapter.GiftGridAdapter;

import java.util.List;

public class CoutomGridView implements AdapterView.OnItemClickListener{
    private List<GiftBean.DataBean.ListBean > mlist;
    private Context context;
    private GridView gridView;
    private GiftGridAdapter giftAdapter;
    private RelativeLayout relativeLayout;

    public CoutomGridView(List<GiftBean.DataBean.ListBean> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    public View getView(){
        View view = LayoutInflater.from(context).inflate(R.layout.gift_gridview_view,null);
        gridView = view.findViewById(R.id.grid);
        giftAdapter = new GiftGridAdapter(context,mlist);
        gridView.setAdapter(giftAdapter);
        gridView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (relativeLayout != null){
            relativeLayout.setBackground(new ColorDrawable(Color.parseColor("#ffffff")));
        }
        RelativeLayout viewById = view.findViewById(R.id.item_layout);
        viewById.setBackground(context.getResources().getDrawable(R.drawable.register_shape));
        relativeLayout = viewById;
        GiftBean.DataBean.ListBean listBean = mlist.get(position);
        giftOnClick.giftOnclick(position,listBean);
    }
    public void clearAdapter(){
        giftAdapter = new GiftGridAdapter(context,mlist);
        gridView.setAdapter(giftAdapter);
    }

    public interface giftOnClick{
        void giftOnclick(int position, GiftBean.DataBean.ListBean listBean);
    }

    public giftOnClick giftOnClick;

    public void setGiftOnClick(CoutomGridView.giftOnClick giftOnClick) {
        this.giftOnClick = giftOnClick;
    }
}
