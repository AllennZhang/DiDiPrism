package com.xiaojuchefu.prism.playback.model;

import com.xiaojuchefu.prism.monitor.PrismConstants;

import java.util.HashMap;

public class EventInfo {

    public int windowType;

    public int eventType;
    public String eventDesc;
    public HashMap<String, String> eventData;
    public long takeTime;

    public String originData;

    public String content;

    public String getTargetActivity() {
        if (eventType == PrismConstants.Event.ACTIVITY_START && eventData != null){
            return eventData.get(PrismConstants.Symbol.ACTIVITY_NAME);
        }
        return "";
    }
}
