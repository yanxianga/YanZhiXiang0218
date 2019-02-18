package yxx.com.yanzhixiang0218.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yxx.com.yanzhixiang0218.R;
import yxx.com.yanzhixiang0218.model.bean.JsonBean;
import yxx.com.yanzhixiang0218.presenter.ShowPresenter;
import yxx.com.yanzhixiang0218.view.adapter.MyAdapter;
import yxx.com.yanzhixiang0218.view.interfaces.IMainView;

public class MainActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private String path = "http://365jia.cn/news/api3/365jia/news/headline?page=1";
    private ShowPresenter showPresenter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
        initData();
    }

    private void initView() {
    }

    private void initData() {
        showPresenter = new ShowPresenter();
        showPresenter.setView(this);
        showPresenter.ShowData(path);
    }


    @Override
    public void ouSeccuess(JsonBean jsonBean) {
        List<JsonBean.DataBeanX.DataBean> data = jsonBean.getData().getData();

        myAdapter = new MyAdapter(MainActivity.this, data);
        recyclerview.setAdapter(myAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(staggeredGridLayoutManager);
        myAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.deattch();
    }

}
