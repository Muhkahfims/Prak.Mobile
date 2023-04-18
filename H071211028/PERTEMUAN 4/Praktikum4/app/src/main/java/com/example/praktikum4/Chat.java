package com.example.praktikum4;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Chat implements Parcelable {

    String nama,waktu,chat;

    public Chat(String nama, String waktu, String chat) {
        this.nama = nama;
        this.waktu = waktu;
        this.chat = chat;

    }

    protected Chat(Parcel in) {
        nama = in.readString();
        waktu = in.readString();
        chat = in.readString();
    }

    public static final Creator<Chat> CREATOR = new Creator<Chat>() {
        @Override
        public Chat createFromParcel(Parcel in) {
            return new Chat(in);
        }

        @Override
        public Chat[] newArray(int size) {
            return new Chat[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(waktu);
        parcel.writeString(chat);
    }
}
