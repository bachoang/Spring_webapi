package webapi.azure.webapi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // Delegated permission route
    @GetMapping("/webapiA")
    @ResponseBody
    @PreAuthorize("hasAuthority('SCOPE_hello')")
    public String fileA() {
        return "Response from WebApiA.";
    }

    // Application permission route
    @GetMapping("/webapiB")
    @ResponseBody
    @PreAuthorize("hasAuthority('APPROLE_app_hello')")
    public String fileB() {
        return "Response from WebApiB.";
    }

    // Either Application or Delegated permission route
    @GetMapping("/webapiC")
    @ResponseBody
    @PreAuthorize("hasAnyAuthority('APPROLE_app_hello','SCOPE_hello')")
    public String fileC() {
        return "Response from WebApiC.";
    }
}
