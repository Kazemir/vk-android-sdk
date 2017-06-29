package com.vk.sdk.api.model;

import android.os.Parcel;

import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("unused")
public class VKApiSticker extends VKAttachments.VKApiAttachment implements Identifiable, android.os.Parcelable {

    public int id;

    public int product_id;

    public String photo_64;
    public String photo_128;
    public String photo_256;
    public String photo_352;
    public String photo_512;

    public VKApiSticker(JSONObject from) throws JSONException
    {
        parse(from);
    }
    /**
     * Fills a Sticker instance from JSONObject.
     */
    public VKApiSticker parse(JSONObject source) throws JSONException {
        id = source.optInt("id");
        product_id = source.optInt("product_id");
        photo_64 = source.optString("photo_64");
        photo_128 = source.optString("photo_128");
        photo_256 = source.optString("photo_256");
        photo_352 = source.optString("photo_352");
        photo_512 = source.optString("photo_512");
        return this;
    }

    /**
     * Creates a Sticker instance from Parcel.
     */
    public VKApiSticker(Parcel in) {
        this.id = in.readInt();
        this.product_id = in.readInt();
        this.photo_64 = in.readString();
        this.photo_128 = in.readString();
        this.photo_256 = in.readString();
        this.photo_352 = in.readString();
        this.photo_512 = in.readString();
    }

    /**
     * Creates empty Sticker instance.
     */
    public VKApiSticker() {

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public CharSequence toAttachmentString() {
        return new StringBuilder(VKAttachments.TYPE_STICKER).append('_').append(id);
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
        dest.writeInt(this.id);
        dest.writeInt(this.product_id);
        dest.writeString(this.photo_64);
        dest.writeString(this.photo_128);
        dest.writeString(this.photo_256);
        dest.writeString(this.photo_352);
        dest.writeString(this.photo_512);
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
                "id=" + id +
                ", product_id=" + product_id +
                ", photo_64='" + photo_64 + '\'' +
                ", photo_128='" + photo_128 + '\'' +
                ", photo_256='" + photo_256 + '\'' +
                ", photo_352='" + photo_352 + '\'' +
                ", photo_512='" + photo_512 + '\'' +
                '}';
    }
}