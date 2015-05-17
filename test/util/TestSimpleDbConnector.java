package util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import static org.hibernate.criterion.Restrictions.eq;

import org.junit.Test;

import common.IDbObject;
import connector.SimpleDbConnector;
import container.EasyBean;

public class TestSimpleDbConnector {

	@Test
	public void test() {
		EasyBean bean1 = new EasyBean();
		bean1.setName("test");
		bean1.setValue("dummy1");
		SimpleDbConnector.save(bean1);
		
		EasyBean bean2 = new EasyBean();
		bean2.setName("test");
		bean2.setValue("dummy2");
		SimpleDbConnector.save(bean2);
		
		EasyBean bean3 = new EasyBean();
		bean3.setName("test");
		bean3.setValue("dummy3");
		SimpleDbConnector.save(bean3);
		
		EasyBean bean4 = new EasyBean();
		bean4.setName("test");
		bean4.setValue("dummy4");
		SimpleDbConnector.save(bean4);
		
		EasyBean bean5 = new EasyBean();
		bean5.setName("outscope");
		bean5.setValue("dummy5");
		SimpleDbConnector.save(bean5);

		List<IDbObject> test = new ArrayList<IDbObject>();
		List<IDbObject> rTest = SimpleDbConnector.find(EasyBean.class, eq("name",  "test"));
		List<IDbObject> all = SimpleDbConnector.getAll(EasyBean.class);
		
		// test save and find
		assertTrue(rTest.containsAll(test));
		assertTrue(!rTest.contains(bean5));
		assertTrue(all.containsAll(test));
		assertTrue(all.contains(bean5));
		
		// test update
		bean5.setName("outscope");
		bean5.setValue("dummy6");
		SimpleDbConnector.update(bean5);
		rTest = SimpleDbConnector.find(EasyBean.class, eq("name",  "outscope"));
		assertTrue(rTest.contains(bean5));
		
		// test delete
		all = SimpleDbConnector.getAll(EasyBean.class);
		for(IDbObject each : all) {
			SimpleDbConnector.delete(each);
		}
		all = SimpleDbConnector.getAll(EasyBean.class);
		assertTrue(all.size() == 0);
	}

}
