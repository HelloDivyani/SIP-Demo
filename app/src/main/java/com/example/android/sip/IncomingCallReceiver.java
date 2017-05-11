package com.example.android.sip;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.sip.SipAudioCall;
import android.net.sip.SipProfile;

/**
 * Created by Divyani on 11-05-2017.
 */
public class IncomingCallReceiver extends BroadcastReceiver {
    // Process the incoming call answers it and hands over it to walkie Activity
    // SipAudioCall handles an internet call over Sip

    @Override
    public void onReceive(Context context, Intent intent) {
        SipAudioCall inComingCall = null;
        try {
        SipAudioCall.Listener listener =new SipAudioCall.Listener() {
            @Override
            public void  onRinging(SipAudioCall call,SipProfile caller)
            {
                try
                {
                    call.answerCall(30);
                    // 30 is timeout


                }catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
            Walkie wt  = (Walkie)context;
            // TypeCast this Context
            // Manger of SipManager create Session onReceive intent and SipAudioCall listener
            inComingCall = wt.manager.takeAudioCall(intent,listener);
            inComingCall.answerCall(30);
            inComingCall.startAudio();
            inComingCall.setSpeakerMode(true);
            if(inComingCall.isMuted())
            {
                // SIP audioCall incoming call
                inComingCall.toggleMute();
            }
            wt.call = inComingCall;
            wt.updateStatus(inComingCall);
        }catch(Exception e)
        {
            if(inComingCall!=null)
            {
                inComingCall.close();
            }
            //e.printStackTrace();
        }

    }
}
