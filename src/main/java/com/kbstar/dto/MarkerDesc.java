package com.kbstar.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class MarkerDesc {
    private int id;
    private int marker_id;
    private String item;
    private int price;
    private String imgname;

    public MarkerDesc(int marker_id, String item, int price, String imgname) {
        this.marker_id = marker_id;
        this.item = item;
        this.price = price;
        this.imgname = imgname;
    }
}
