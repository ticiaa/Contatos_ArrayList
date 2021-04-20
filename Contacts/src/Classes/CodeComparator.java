package Classes;

import java.util.Comparator;

public class CodeComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact ct1, Contact ct2) {
        return
        Integer.compare
        (ct1.getCode(), ct2.getCode());
    }
}