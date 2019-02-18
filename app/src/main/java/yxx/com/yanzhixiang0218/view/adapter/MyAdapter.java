package yxx.com.yanzhixiang0218.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import yxx.com.yanzhixiang0218.R;
import yxx.com.yanzhixiang0218.model.bean.JsonBean;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SubViewHolde> {

    private Context context;
    private List<JsonBean.DataBeanX.DataBean> data;
    private SubViewHolde subViewHolde;

    public MyAdapter(Context context, List<JsonBean.DataBeanX.DataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public SubViewHolde onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        subViewHolde = new SubViewHolde(view);
        return subViewHolde;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolde subViewHolde, int i) {
       // subViewHolde.textView.setText(data.get(i).getTitle());
        ImageLoader instance = ImageLoader.getInstance();
        //instance.displayImage("http://365jia.cn/uploads/appletrecommend/201804/5ad6ba6c6bb8b.jpg",subViewHolde.imageview);
        Log.e("yx",""+data.get(i).getTitle());
    }


    public int getItemCount() {
        return data.size();
    }

    public class SubViewHolde extends RecyclerView.ViewHolder {
        @BindView(R.id.textView)
        TextView textView;
        @BindView(R.id.imageview)
        ImageView imageview;
        public SubViewHolde(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this.itemView);
        }
    }
}
