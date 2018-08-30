package siit.finalProject.VehicleManagement.domain;

public class Vehicle {
    private long id;
    private String vmodel;
    private String vname;
    private String vyear;
    private String vcolor;
    private String vcost;
    private VehicleStatus vstatus;

    public Vehicle(){}

    public Vehicle(long id, String vmodel, String vname, String vyear, String vcolor, String vcost, VehicleStatus vstatus) {
        this.id = id;
        this.vmodel = vmodel;
        this.vname = vname;
        this.vyear = vyear;
        this.vcolor = vcolor;
        this.vcost = vcost;
        this.vstatus = vstatus;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVmodel() {
        return vmodel;
    }

    public void setVmodel(String vmodel) {
        this.vmodel = vmodel;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVyear() {
        return vyear;
    }

    public void setVyear(String vyear) {
        this.vyear = vyear;
    }

    public String getVcolor() {
        return vcolor;
    }

    public void setVcolor(String vcolor) {
        this.vcolor = vcolor;
    }

    public String getVcost() {
        return vcost;
    }

    public void setVcost(String vcost) {
        this.vcost = vcost;
    }

    public VehicleStatus getVstatus() {
        return vstatus;
    }

    public void setVstatus(VehicleStatus vstatus) {
        this.vstatus = vstatus;
    }

//    public String toString(){
//        return "Vehicles{" +
//                "id='" + id + '\'' +
//                ", vmodel='" + vmodel + '\'' +
//                ", vname='" + vname + '\'' +
//                ", vyear=" + vyear +
//                ", vcolor='" + vcolor + '\'' +
//                ", vcost=" + vcost + '\'' +
//                ", vstatus=" + vstatus +
//                '}';

}


