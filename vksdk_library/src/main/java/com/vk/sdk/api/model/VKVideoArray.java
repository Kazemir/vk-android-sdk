package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Lynnfield on 23.11.2015.
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class VKVideoArray extends VKList<VKApiVideo> {
    @Override
    public VKApiModel parse(JSONObject response) throws JSONException {
        fill(response, VKApiVideo.class);
        return this;
    }

    @SuppressWarnings("unused")
    public VKVideoArray() {
    }

    public VKVideoArray(Parcel in) {
        super(in);
    }

    public static Creator<VKVideoArray> CREATOR = new Creator<VKVideoArray>() {
        public VKVideoArray createFromParcel(Parcel source) {
            return new VKVideoArray(source);
        }

        public VKVideoArray[] newArray(int size) {
            return new VKVideoArray[size];
        }
    };
}
