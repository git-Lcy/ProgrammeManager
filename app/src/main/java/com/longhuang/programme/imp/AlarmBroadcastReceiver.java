package com.longhuang.programme.imp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.longhuang.programme.ProgrammeNoticeShowActivity;
import com.longhuang.programme.module.Programme;
import com.longhuang.programme.utils.L;

import org.litepal.crud.DataSupport;

import java.util.List;


/**
 * Created by lfy on 2017/12/9.
 */

public class AlarmBroadcastReceiver extends BroadcastReceiver {
    public static final String ALARM_ACTION = "com.longhuang.programme.ACTION_ALARM";
    @Override
    public void onReceive(Context context, Intent intent) {

        String id = intent.getStringExtra("programmeId");
        String time = intent.getStringExtra("executeTime");
        L.e("BroadcastReceiver","--- programmeId = "+id+"  ; time = "+time);
        if (TextUtils.isEmpty(id) || TextUtils.isEmpty(time)) return;
        List<Programme> p = DataSupport.where("programmeId = ?",id,"executeTime = ?",time).find(Programme.class);
        boolean exist = DataSupport.isExist(Programme.class,"programmeId = ? , executeTime = ?",id,time);
        L.e("BroadcastReceiver","--- id = "+id + "   exist = "+exist);
        if (!exist || p==null || p.size()==0) {
            L.e("BroadcastReceiver","--- programmeId not found");
            return;
        }

        Intent noticeIntent = new Intent(context, ProgrammeNoticeShowActivity.class);
        noticeIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(noticeIntent);
    }
}
