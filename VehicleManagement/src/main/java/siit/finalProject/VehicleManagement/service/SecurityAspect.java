package siit.finalProject.VehicleManagement.service;

//spring-boot-starter-aop<

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import siit.finalProject.VehicleManagement.HasRole;
import siit.finalProject.VehicleManagement.domain.User;
import siit.finalProject.VehicleManagement.exceptionsHandler.AccessDeniedException;

@Component
@Aspect
public class SecurityAspect {

    @Autowired
    private SecurityService securityService;

    @Around(value = "execution (* siit.finalProject.VehicleManagement.controller.*.*(..)) && @annotation(hasRole) ", argNames = "call, hasRole")
    public Object audit(final ProceedingJoinPoint call, HasRole hasRole) throws Throwable {

        User user = securityService.getCurrentUser();
        if (user == null || !user.getRolesAsString().contains(hasRole.role())) {
            throw new AccessDeniedException();
        }
        return call.proceed();

    }
}
