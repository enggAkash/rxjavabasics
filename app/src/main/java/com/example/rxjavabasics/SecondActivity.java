package com.example.rxjavabasics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;
    Observable<String> observable;
    Observer<String> observer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.btn);

        createObservable();
        createObserver();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                observable.subscribe(observer);
            }
        });

    }

    private void createObservable() {

        observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                emitter.onNext(editText.getText().toString());
                emitter.onComplete();
            }
        });

    }

    private void createObserver() {

        observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {
                textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

    }
}
