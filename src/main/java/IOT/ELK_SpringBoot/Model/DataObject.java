//package com.lemoncode21.ELK_SpringBoot.Model;//package com.example.demo.Model;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Data;
//
//import java.io.Serializable;
//
//@Data
//public class DataObject implements Serializable {
//    private int id;
//    private int packet_no;
//    private double temperature;
//    private double humidity;
//    private double tds;
//    private double pH;
//    @JsonCreator
//    public DataObject(@JsonProperty("id") int id, @JsonProperty("packet_no") int packet_no,
//                      @JsonProperty("temperature") double temperature, @JsonProperty("humidity") double humidity,
//                      @JsonProperty("tds") double tds, @JsonProperty("pH") double pH) {
//        this.id = id;
//        this.packet_no = packet_no;
//        this.temperature = temperature;
//        this.humidity = humidity;
//        this.tds = tds;
//        this.pH = pH;
//    }
//}
