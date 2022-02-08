package com.example.brother_barbershop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> Mens = new ArrayList<String>();
        Mens.add("MEN’s HAIRCUT Basic");
        Mens.add("SPECIALTY CUT");
        Mens.add("BEARD & MUSTACHE TRIM");
        Mens.add("BEARD TRIM with LINE UP");
        Mens.add("BUZZ CUT");

        List<String> Womens = new ArrayList<String>();
        Womens.add("Haircut");
        Womens.add("Hair Colour");
        Womens.add("Hair Oil");
        Womens.add("Hot Spa");
        Womens.add("Massage");

        List<String> Kids = new ArrayList<String>();
        Kids.add("Simple Cut");
        Kids.add("Semi Hair Color");
        Kids.add("Pernment Hair Color");


        expandableListDetail.put("Mens Services", Mens);
        expandableListDetail.put("Womens Services", Womens);
        expandableListDetail.put("Kids Services", Kids);
        return expandableListDetail;
    }


}
