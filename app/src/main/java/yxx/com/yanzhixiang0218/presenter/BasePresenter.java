package yxx.com.yanzhixiang0218.presenter;

public class BasePresenter<V> {

    private V view;

    public void setView(V v) {
        this.view = v;
    }

    public void deattch(){
        this.view = null;
    }

    public V getView(){
        return view;
    }
}
