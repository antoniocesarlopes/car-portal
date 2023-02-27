package commons.data.entity;

public enum TypeOwner {
	
	RETAILER("RETAILER"),
	PARTICULAR("PARTICULAR");
	
	private final String value;

	TypeOwner(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TypeOwner fromValue(String v) {
        for (TypeOwner c: TypeOwner.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
	

}
