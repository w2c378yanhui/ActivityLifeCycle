package test.testfragment.test;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import test.testfragment.R;

/**
 * Created by king on 2017/11/8.
 */

public class Fragment1 extends Fragment {
    private TextView textView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        textView = rootView.findViewById(R.id.textview);
        String param = getArguments().getString("param");
        textView.setText(param);
        return rootView;
    }

    public static Fragment1 newInstance(String para) {

        Bundle args = new Bundle();
        args.putString("param", para);
        Fragment1 fragment = new Fragment1();
        fragment.setArguments(args);
        return fragment;
    }
}
