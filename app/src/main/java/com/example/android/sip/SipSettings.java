package com.example.android.sip;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Divyani on 11-05-2017.
 */
public class SipSettings extends PreferenceActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Note that none of the preferences are actually defined here.
        // They're all in the XML file res/xml/preferences.xml.
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }

}
