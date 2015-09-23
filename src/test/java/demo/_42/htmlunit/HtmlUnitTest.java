package demo._42.htmlunit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import demo.AbstractTest;

/**
 * Created by nlabrot on 16/09/15.
 */
public class HtmlUnitTest extends AbstractTest {

    @Autowired
    WebApplicationContext context;

    private WebClient webClient;

    @Before
    public void setup() {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(context)
                .build();
    }


    @Test
    public void testHtmlUnit() throws Exception {
        HtmlPage homepage = webClient.getPage("http://localhost/");
        Assert.assertEquals("home" , homepage.getTitleText());

        HtmlAnchor form = homepage.getHtmlElementById("homeLink");
        HtmlPage newPage = form.click();
        Assert.assertEquals("home" , newPage.getTitleText());
    }
}
