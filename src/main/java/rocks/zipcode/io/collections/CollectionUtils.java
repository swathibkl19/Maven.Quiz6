package rocks.zipcode.io.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

    /**
     * @param collection - object to be converted to list
     * @param <E>        - type of collection
     * @return list with identical contents
     */
    public static <E> List<E> toList(Collection collection) {
        List<E> list = new ArrayList<>();
        list.addAll(collection);

       // return list.toArray(new E[]);
        return list;
    }

    /**
     * @param nestedCollection - collection to be evaluated
     * @param collection       - collections to be sought within `nestedCollection`
     * @return true if `nestedCollection` contains a collection with contents identical to `collection`
     */
    public static Boolean contains(Collection<? extends Collection<?>> nestedCollection, Collection<?> collection) {

//        System.out.println(nestedCollection);
//        System.out.println(collection);
//        System.out.println(nestedCollection.contains(collection));

        return nestedCollection.contains(collection);
    }

    /**
     * @param collections - collections to be nested
     * @return a single collection containing each of the collections passed in as an argument
     */
    public static Collection<? extends Collection<?>> nest(Collection<?>... collections) {


        List<Collection<?>> list = new ArrayList<>();
        list.addAll(Arrays.asList(collections));
       // System.out.println(list);

        return list;
    }

    /**
     * @param collections - collections to be combined
     * @return a single collection containing the aggregate contents of each collection passed in as an argument
     */
    public static Collection<?> flatten(Collection<?>... collections) {
        List<Object> list = new ArrayList<>();
        for (Collection<?> c:collections) {
            for(Object e : c){
                list.add(e);
            }
        }

       // System.out.println(list);
        return list;
    }
}
