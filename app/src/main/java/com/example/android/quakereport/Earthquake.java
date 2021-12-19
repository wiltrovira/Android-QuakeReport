package com.example.android.quakereport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Earthquake {
    private double mMagnitude;
    private String mDate;
    private String mLocation;
    private String mUrl;

    private static final String LOCATION_SEPARATOR = " of ";
    private static final String KILOMETERS = "km";


    public Earthquake(double vMagnitude, String vDate, String vLocation, String vUrl) {
        this.mMagnitude = vMagnitude;
        this.mDate = vDate;
        this.mLocation = vLocation;
        this.mUrl = vUrl;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String vUrl) {
        this.mUrl = vUrl;
    }

    public double getMagnitude() {
        return this.mMagnitude;
    }

    public void setMagnitude(double vMagnitude) {
        this.mMagnitude = vMagnitude;
    }

    public String getDate() {
        return this.mDate;
    }

    public String getDateFormat() {

        long timeMilliseconds = Long.parseLong(this.mDate);
        Date dateObject = new Date(timeMilliseconds);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM DD, yyyy");

        return simpleDateFormat.format(dateObject);
    }

    /**
     *
     * @return
     */
    public String getPrimaryLocation(){
        String cadenaOriginal = this.mLocation;
        String primaryLocation="";
        String[] partesCadena;
        if (cadenaOriginal.contains(KILOMETERS) && cadenaOriginal.contains(LOCATION_SEPARATOR)){
            partesCadena = cadenaOriginal.split(LOCATION_SEPARATOR);
            primaryLocation = partesCadena[1];
        }else{
            primaryLocation = cadenaOriginal;
        }

        return primaryLocation;
    }

    /**
     *
     * @return
     */
    public String getLocationOffset(){
        String cadenaOriginal = this.mLocation;
        String locationOffset = "";
        String[] partesCadena;
        if (cadenaOriginal.contains(KILOMETERS) && cadenaOriginal.contains(LOCATION_SEPARATOR)){
            partesCadena = cadenaOriginal.split(LOCATION_SEPARATOR);
            locationOffset = partesCadena[0] + LOCATION_SEPARATOR;
        }else{
            locationOffset = "Near of ";
        }

        return locationOffset;
    }


    public String getTimeFormat() {

        long timeMilliseconds = Long.parseLong(this.mDate);
        Date dateObject = new Date(timeMilliseconds);

        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("h:mm a");

        return simpleTimeFormat.format(dateObject);
    }

    public void setDate(String vDate) {
        this.mDate = vDate;
    }

    public String getLocation() {
        return this.mLocation;
    }

    public void setLocation(String vLocation) {
        this.mLocation = vLocation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Earthquake{");
        sb.append("mMagnitude='").append(mMagnitude).append('\'');
        sb.append(", mDate='").append(mDate).append('\'');
        sb.append(", mLocation='").append(mLocation).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
