package yxx.com.yanzhixiang0218.model;

import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

import java.io.IOException;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import yxx.com.yanzhixiang0218.model.bean.JsonBean;

public class HttpUtils {

    private static HttpUtils httpUtils;
    CallbackData callbackData;
    public HttpUtils(){};

    public void setCallBackInstence(CallbackData callBackInstence){
        this.callbackData = callBackInstence;
    }

    public static HttpUtils getInstence(){
        if(httpUtils == null){
            return  new HttpUtils();
        }else{
            return httpUtils;
        }
    }

    public void getpost(String url) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();

        FormBody formBody = new FormBody.Builder().build();

        Request request = new Request.Builder().url(url).build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callbackData.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                JsonBean jsonBean = gson.fromJson(string, JsonBean.class);
                Message message = handler.obtainMessage();
                message.obj = jsonBean;
                handler.sendMessage(message);
            }
        });
    }
    public interface CallbackData<D> {
        void onResponse(D t);

        void onFailure(IOException e);
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Object obj = msg.obj;
            callbackData.onResponse(obj);
        }
    };
}
