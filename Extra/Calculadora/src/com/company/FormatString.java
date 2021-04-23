package com.company;

public class FormatString {
    public String Format(String Option){
        Option = Option.toLowerCase();
        return Option;
    };

    public boolean ress(String Res){
        Res = Res.toLowerCase();
        if(Res.equalsIgnoreCase("s") || Res.matches("[Ss]im"))
            return true;
        else
            return false;
    };

}
