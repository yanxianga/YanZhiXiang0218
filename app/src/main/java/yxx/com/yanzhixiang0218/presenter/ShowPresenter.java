package yxx.com.yanzhixiang0218.presenter;

import java.io.IOException;

import yxx.com.yanzhixiang0218.model.HttpUtils;
import yxx.com.yanzhixiang0218.model.bean.JsonBean;
import yxx.com.yanzhixiang0218.view.interfaces.IMainView;

public class ShowPresenter extends BasePresenter<IMainView>{

    private final HttpUtils httpUtils;

    public ShowPresenter(){
        httpUtils = HttpUtils.getInstence();
        httpUtils.setCallBackInstence(new HttpUtils.CallbackData<JsonBean>() {

            @Override
            public void onResponse(JsonBean t) {
                getView().ouSeccuess(t);
            }

            @Override
            public void onFailure(IOException e) {

            }
        });
    }

    public void ShowData(String url){
        httpUtils.getpost(url);
    }
}
