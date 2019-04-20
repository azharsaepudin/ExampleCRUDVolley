package com.studio.azhar.examplecrudvolley;

import java.io.Serializable;

public class ModelMahasiswa implements Serializable {

    private String id;
    private String npm;
    private String nama;


    public String getId(){
        return id;
    }

    public String getNpm(){
        return npm;
    }

    public String getNama(){
        return nama;
    }

    ModelMahasiswa(String id, String npm, String nama){
        this.id = id;
        this.npm = npm;
        this.nama = nama;
    }
}
