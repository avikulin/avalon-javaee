package DAL.Utils.Filter;

import DAL.Utils.Filter.Enums.PredicateType;
import DAL.Utils.Filter.Templates.Predicate;

public class GtePredicate<T extends Integer, Date, Double> extends Predicate {
    public GtePredicate(Class<?> entity, String field, T criteria) {
        super(entity, field,PredicateType.GTE, null, criteria);
    }

    @Override
    public String toString() {
        return String.format("(%s.%s > %d)", this.getEntity().getSimpleName(), this.getField(), this.getRValue());
    }
}
