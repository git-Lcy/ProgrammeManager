package com.longhuang.programme.Imp;


import android.os.Bundle;
import android.os.Handler;

import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SynthesizerListener;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MySynthesizerListener implements SynthesizerListener {

    @Override
    public void onSpeakBegin() {}
    @Override
    public void onBufferProgress(int i, int i1, int i2, String s) {}
    @Override
    public void onSpeakPaused() {}
    @Override
    public void onSpeakResumed() {}
    @Override
    public void onSpeakProgress(int i, int i1, int i2) {}
    @Override
    public void onCompleted(SpeechError speechError) {}

    @Override
    public void onEvent(int i, int i1, int i2, Bundle bundle) {}
}
