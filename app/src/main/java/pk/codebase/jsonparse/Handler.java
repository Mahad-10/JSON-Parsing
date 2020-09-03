package pk.codebase.jsonparse;

import androidx.annotation.NonNull;

public class Handler {
    private String end_date;
    private String style;
    private String start_date;
    private String name;
    private String enabled;
    private String detail;
    private String uid;

    public Handler(String end_date,String style, String start_date,String name,String enabled,
                   String detail, String uid){
        this.end_date = end_date;
        this.style = style;
        this.detail = detail;
        this.start_date = start_date;
        this.enabled = enabled;
        this.name = name;
        this.uid = uid;
    }
    public void setEnd_date(String end_date){
        this.end_date = end_date;
    }
    public void setStyle(String style){
        this.style = style;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDetail(String detail){
        this.detail = detail;
    }
    public void setStart_date(String start_date){
        this.start_date = start_date;
    }
    public void setEnabled(String enabled){
        this.enabled = enabled;
    }
    public void setUid(String uid){
        this.uid = uid;
    }

    public String getDetail() {
        return detail;
    }

    public String getEnabled() {
        return enabled;
    }

    public String getEnd_date() {
        return end_date;
    }

    public String getName() {
        return name;
    }

    public String getStart_date() {
        return start_date;
    }

    public String getStyle() {
        return style;
    }

    public String getUid() {
        return uid;
    }


    @NonNull
    @Override
    public String toString() {
        return "Competition Name : " + name + "\nStarting Date : "
                + start_date + "\nEnding Date : " + end_date + "\nStyle : "
                + style + "\nEnabled : " + enabled + "\nUID : " + uid
                + "\nDetail : " + detail;
    }
}
