package com.rifaikuci.hextech_project.datas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pins {

    @Expose
    @SerializedName("p1")
    private int p1;
    @Expose
    @SerializedName("p2")
    private int p2;
    @Expose
    @SerializedName("p3")
    private int p3;
    @Expose
    @SerializedName("p4")
    private int p4;

    public Pins(int p1, int p2, int p3, int p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public int getP2() {
        return p2;
    }

    public void setP2(int p2) {
        this.p2 = p2;
    }

    public int getP3() {
        return p3;
    }

    public void setP3(int p3) {
        this.p3 = p3;
    }

    public int getP4() {
        return p4;
    }

    public void setP4(int p4) {
        this.p4 = p4;
    }
}
