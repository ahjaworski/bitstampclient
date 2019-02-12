package nl.antek.bitstampclient;

import javax.annotation.security.DeclareRoles;
import javax.ejb.Startup;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Startup
@ApplicationPath("/data")
@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@DeclareRoles({"protected"})
@Slf4j
public class BitstampclientRestApplication extends Application {

}
