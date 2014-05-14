package org.openmrs.module.ddisemmeddb.routing;

public class DDISemMedDBContextHolder {
	private static final ThreadLocal<DbType> contextHolder = new ThreadLocal<DbType>();
	
	public static void setCustomerType(DbType customerType) {
	    // Assert.notNull(customerType, "customerType cannot be null");
		contextHolder.set(customerType);
	}

	public static DbType getCustomerType() {
		return (DbType) contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}
