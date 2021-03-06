/*
(C) copyright 2018 Silviu Ilinescu, Andu Anches, Mihai Florea
All rights reserved
 */

package siit.finalProject.VehicleManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *This application provides an easy and simple way to sell or purchase vehicles online.
 *Customers can view all the details of a vehicle and send a request if they want to purchase a vehicle,
 *from anywhere and at any time. All the data will be stored in the database.
 *
 *Created 17-Aug-2018
 *@author Silviu_Ilinescu, Andu Anches, Mihai Florea
 *
 */
@SpringBootApplication
public class VehicleManagementApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(VehicleManagementApplication.class, args);
	}
}
