
package siit.finalProject.VehicleManagement.dto;

import siit.finalProject.VehicleManagement.domain.VehicleStatus;

public class CreateVehicleRequest {
    private String vmodel;
    private String vname;
    private String vyear;
    private String vcolor;
    private String vcost;
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
}