/**
 * 
 */
package com.impexora.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.impexora.commons.CommonConstants;
import com.impexora.model.ResponseWrapper;
import com.impexora.ws.ImpexoraWebService;

/**
 * @author ashraf_sarhan
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext.xml")
public class ImpexoraTest extends TestCase {

	@Autowired
	private ImpexoraWebService impexoraWebService;

	@Test
	public void testImpexoraStatus() throws IOException {
		
		String command = CommonConstants.STATUS;

		String solr = "[{\"host\":\"10.68.22.56\", \"port\":8080 , \"core\":\"avago_xref\"}, {\"host\":\"10.68.22.76\", \"port\":8090 , \"core\":\"cyp\"}]";
		
		MockHttpServletResponse httpServletResponse = new MockHttpServletResponse(); 
		
		ResponseWrapper responseWrapper = impexoraWebService.impexer(command, solr, null, httpServletResponse);
		
		System.out.println("Response Status: " + responseWrapper.getMessage() + "\n");
		
		System.out.println("Response Code: " + httpServletResponse.getStatus());
		
		Assert.assertNotNull("%%%%%% Failure in executing solr status AsyncHttpRequest %%%%%%", responseWrapper);
		
		Assert.assertEquals("%%%%%% Failure in executing solr status AsyncHttpRequest %%%%%%", 200, httpServletResponse.getStatus());
	
	}

}
