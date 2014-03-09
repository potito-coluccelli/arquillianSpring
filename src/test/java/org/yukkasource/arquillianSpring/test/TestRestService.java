package org.yukkasource.arquillianSpring.test;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by tito on 3/2/14.
 */
@RunWith(Arquillian.class)
@RunAsClient
public class TestRestService {
    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "arquillianSpring.war")
                .addPackages(true, "org.yukkasource.arquillianSpring")
                .addAsWebInfResource("restDispatcher-servlet.xml", "restDispatcher-servlet.xml")
                .addAsWebInfResource("web.xml", "web.xml");
    }
    @Test
    public void testRestService(){
        RestTemplate template = new RestTemplate();
        String res = template.getForObject(
                "http://localhost:8080/arquillianSpring/restService?param=parameter", String.class);
        assertEquals("{\"a\":\"parameter\"}",res);
    }
}
