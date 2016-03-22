package ru.bstu.iitus.vt41.opn;

/**
 * Created by KASPER on 16.03.2016.
 */
public enum ConstrType {
    /**
     * Enumerate of construction
     */
    APARTMENTHOUSE(ApartmentHouse.class),
    BRIDGE(Bridge.class),
    BUILDING(Building.class),
    COTTAGE(Cottage.class),
    SUPERMARKET(Supermarket.class),
    TUNNEL(Tunnel.class),
    VIADUCTCONSTRUCTION(ViaductConstruction.class);

    private Class<? extends Construction> constructionClass;

    ConstrType(Class<? extends Construction> classType) {
        constructionClass = classType;
    }

    public Construction getInstance() throws IllegalAccessException, InstantiationException {
        return constructionClass.newInstance();
    }

    /**
     * Method comparison enumerated types and strings
     *
     * @param string - comparison string
     * @return - value of an enumerated type, if equals, and null otherwise
     */
    public static ConstrType constrEqualsString(String string) {
        ConstrType constr[] = ConstrType.values();
        for (ConstrType s : constr) {
            if (string.equalsIgnoreCase(s.name()))
                return s;
        }
        return null;
    }
}
