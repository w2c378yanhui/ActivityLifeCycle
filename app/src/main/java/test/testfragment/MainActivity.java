package test.testfragment;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.PermissionUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import test.testfragment.service.MyService;
import test.testfragment.test.Test;

public class MainActivity extends AppCompatActivity {
    private TextView mTv;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mTv4 = (TextView) findViewById(R.id.tv4);

        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);

            }
        });
        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
                startActivity(intent);

            }
        });

//        getSupportFragmentManager().beginTransaction().add(R.id.container, Fragment1.newInstance("Fragment1")).commit();
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.setAnimation("scan_animation.json");
        animationView.loop(true);
        animationView.playAnimation();
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
        PermissionUtils.requestPermissions(this, 101, new String[]{Manifest.permission.INTERNET}, null);


        String baseurl = "http://www.kuaidi100.com/";
//        /query ? type = yuantong & postid = 11111111111
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseurl).
                addConverterFactory(GsonConverterFactory.create()).
                addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();
        GithubService service = retrofit.create(GithubService.class);
        GithubService2 service2 = retrofit.create(GithubService2.class);
        Call<Test> call = service2.getInfo("yuantong", "11111111111");
        call.enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, Response<Test> response) {
                Log.e("huihui", "repos " + response);
                Log.e("huihui", "repos " + response.body().toString());
            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                Log.e("huihui", "repos " + t);

            }
        });
        service.getInfo("yuantong", "11111111111").subscribeOn(Schedulers.newThread()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Subscriber<Test>() {
                    @Override
                    public void onCompleted() {
                        Log.e("huihui", "onCompleted ");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("huihui", "onError " + e);
                    }

                    @Override
                    public void onNext(Test test) {
                        Log.e("huihui", "onNext " + test.toString());
//                        mTv.setText(test.toString() + test.toString());
//                        mTv.setMovementMethod(ScrollingMovementMethod.getInstance());
                    }
                });
    }

    public interface GithubService {
        @GET("query?")
//        Call<List<Test>> listRepos(@Path("name") String name, @Path("id") String id);

        Observable<Test> getInfo(@Query("type") String type, @Query("postid") String postid);
    }

    public interface GithubService2 {
        @GET("query?")
        Call<Test> getInfo(@Query("type") String type, @Query("postid") String postid);
    }

}
