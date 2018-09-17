package siit.finalProject.VehicleManagement;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Repeatable(value = HasRoles.class)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface HasRole {
    String role();
}
