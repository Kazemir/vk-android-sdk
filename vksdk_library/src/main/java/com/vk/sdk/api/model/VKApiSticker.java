package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings({"unused", "WeakerAccess"})
public class VKApiSticker extends VKAttachments.VKApiAttachment implements Identifiable, android.os.Parcelable {

    public int sticker_id;

    public int product_id;

    public String image_64;
    public String image_128;
    public String image_256;
    public String image_352;
    public String image_512;

    public String image_with_background_64;
    public String image_with_background_128;
    public String image_with_background_256;
    public String image_with_background_352;
    public String image_with_background_512;

    public VKApiSticker(JSONObject from) throws JSONException
    {
        parse(from);
    }
    /**
     * Fills a Sticker instance from JSONObject.
     */
    public VKApiSticker parse(JSONObject source) throws JSONException {
        sticker_id = source.optInt("sticker_id");
        product_id = source.optInt("product_id");

        image_64 = source.optJSONArray("images").optJSONObject(0).optString("url");
        image_128 = source.optJSONArray("images").optJSONObject(1).optString("url");
        image_256 = source.optJSONArray("images").optJSONObject(2).optString("url");
        image_352 = source.optJSONArray("images").optJSONObject(3).optString("url");
        image_512 = source.optJSONArray("images").optJSONObject(4).optString("url");

        image_with_background_64 = source.optJSONArray("images_with_background").optJSONObject(0).optString("url");
        image_with_background_128 = source.optJSONArray("images_with_background").optJSONObject(1).optString("url");
        image_with_background_256 = source.optJSONArray("images_with_background").optJSONObject(2).optString("url");
        image_with_background_352 = source.optJSONArray("images_with_background").optJSONObject(3).optString("url");
        image_with_background_512 = source.optJSONArray("images_with_background").optJSONObject(4).optString("url");
        return this;
    }

    /**
     * Creates a Sticker instance from Parcel.
     */
    public VKApiSticker(Parcel in) {
        this.sticker_id = in.readInt();
        this.product_id = in.readInt();

        this.image_64 = in.readString();
        this.image_128 = in.readString();
        this.image_256 = in.readString();
        this.image_352 = in.readString();
        this.image_512 = in.readString();

        this.image_with_background_64 = in.readString();
        this.image_with_background_128 = in.readString();
        this.image_with_background_256 = in.readString();
        this.image_with_background_352 = in.readString();
        this.image_with_background_512 = in.readString();
    }

    /**
     * Creates empty Sticker instance.
     */
    public VKApiSticker() {

    }

    @Override
    public int getId() {
        return sticker_id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(VKAttachments.TYPE_STICKER).append('_').append(sticker_id);
    }

    @Override
    public String getType() {
        return VKAttachments.TYPE_STICKER;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.sticker_id);
        dest.writeInt(this.product_id);

        dest.writeString(this.image_64);
        dest.writeString(this.image_128);
        dest.writeString(this.image_256);
        dest.writeString(this.image_352);
        dest.writeString(this.image_512);

        dest.writeString(this.image_with_background_64);
        dest.writeString(this.image_with_background_128);
        dest.writeString(this.image_with_background_256);
        dest.writeString(this.image_with_background_352);
        dest.writeString(this.image_with_background_512);
    }

    public static Creator<VKApiSticker> CREATOR = new Creator<VKApiSticker>() {
        public VKApiSticker createFromParcel(Parcel source) {
            return new VKApiSticker(source);
        }

        public VKApiSticker[] newArray(int size) {
            return new VKApiSticker[size];
        }
    };

    @Override
    public String toString() {
        return "VKApiSticker{" +
                "sticker_id=" + sticker_id +
                ", product_id=" + product_id +
                ", image_64='" + image_64 + '\'' +
                ", image_128='" + image_128 + '\'' +
                ", image_256='" + image_256 + '\'' +
                ", image_352='" + image_352 + '\'' +
                ", image_512='" + image_512 + '\'' +
                ", image_with_background_64='" + image_with_background_64 + '\'' +
                ", image_with_background_128='" + image_with_background_128 + '\'' +
                ", image_with_background_256='" + image_with_background_256 + '\'' +
                ", image_with_background_352='" + image_with_background_352 + '\'' +
                ", image_with_background_512='" + image_with_background_512 + '\'' +
                '}';
    }
}