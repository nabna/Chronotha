package util;

import static org.junit.Assert.*;

import org.junit.Test;

import container.EasyBean;

public class TestJXMLHandler {

	@Test
	public void test() {
		JXMLHandler<EasyBean> handler = new JXMLHandler<EasyBean>(EasyBean.class);
		
		EasyBean wrapper = new EasyBean();
		wrapper.setId(100);
		wrapper.setName("test");
		wrapper.setValue("dummy");
		assertEquals(wrapper, handler.fromXML(handler.toXML(wrapper)));
		
	}

}
