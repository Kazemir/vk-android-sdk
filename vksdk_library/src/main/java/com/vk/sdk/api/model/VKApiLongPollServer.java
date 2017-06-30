package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONObject;

/**
 * Long Poll server object describes a data, needed to connect to Long Poll server
 */
@SuppressWarnings("unused")
public class VKApiLongPollServer extends VKApiModel implements android.os.Parcelable {

    /**
     * Secret session key
     */
    public String key;

    /**
     * Server address
     */
    public String server;

    /**
     * Last event number
     */
    public long ts;

    /**
     *
     */
    public long pts;

    public VKApiLongPollServer(JSONObject from) {
        parse(from);
    }
    /**
     * Fills an Audio instance from JSONObject.
     */
    public VKApiLongPollServer parse(JSONObject source) {
        JSONObject response = source.optJSONObject("response");
        key = response.optString("key");
        server = response.optString("server");
        ts = response.optLong("ts");
        pts = response.optLong("pts");
        return this;
    }

    /**
     * Creates LP server instance from Parcel.
     */
    public VKApiLongPollServer(Parcel in) {
        this.key = in.readString();
        this.server = in.readString();
        this.ts = in.readLong();
        this.pts = in.readLong();
    }

    /**
     * Creates empty LP server instance.
     */
    public VKApiLongPollServer() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.key);
        dest.writeString(this.server);
        dest.writeLong(this.ts);
        dest.writeLong(this.pts);
    }

    public static Creator<VKApiLongPollServer> CREATOR = new Creator<VKApiLongPollServer>() {
        public VKApiLongPollServer createFromParcel(Parcel source) {
            return new VKApiLongPollServer(source);
        }

        public VKApiLongPollServer[] newArray(int size) {
            return new VKApiLongPollServer[size];
        }
    };

    @Override
    public String toString() {
        return "VKApiLongPollServer{" +
                "key='" + key + '\'' +
                ", server='" + server + '\'' +
                ", ts=" + ts +
                ", pts=" + pts +
                '}';
    }
}