package siit.finalProject.VehicleManagement;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HasRoles {
    HasRole[] value();
}
