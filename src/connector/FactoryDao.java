package connector;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class FactoryDao {

	private static Map<Class<? extends GenericDao<?, ?>>, Object> daoContainerMap;

	static {
		daoContainerMap = new HashMap<Class<? extends GenericDao<?, ?>>, Object>();
	}

	private FactoryDao() {
	}

	public static void registerDao(Class<? extends GenericDao<?, ?>> interfaceDao,
			BaseDao<?, ?> implementationDao) {
		daoContainerMap.put(interfaceDao, implementationDao);
	}

	@SuppressWarnings("unchecked")
	public static <T extends GenericDao<?, ?>> T getDao(Class<T> clazz) {
		return (T) daoContainerMap.get(clazz);
	}

	public static Collection<Object> getAllDao() {
		return daoContainerMap.values();
	}
}
