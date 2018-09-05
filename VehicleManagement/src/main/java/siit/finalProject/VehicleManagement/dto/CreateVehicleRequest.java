
package siit.finalProject.VehicleManagement.dto;

import siit.finalProject.VehicleManagement.domain.VehicleStatus;

public class CreateVehicleRequest {
    private String vmodel;
    private String vname;
    private int vyear;
    private String vcolor;
    private int vcost;
    private VehicleStatus vstatus;


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

    public int getVyear() {
        return vyear;
    }

    public void setVyear(int vyear) {
        this.vyear = vyear;
    }

    public String getVcolor() {
        return vcolor;
    }

    public void setVcolor(String vcolor) {
        this.vcolor = vcolor;
    }

    public int getVcost() {
        return vcost;
    }

    public void setVcost(int vcost) {
        this.vcost = vcost;
    }

    public VehicleStatus getVstatus() {
        return vstatus;
    }

    public void setVstatus(VehicleStatus vstatus) {
        this.vstatus = vstatus;
    }
}