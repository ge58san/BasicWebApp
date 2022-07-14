package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Mario";
        } else if (query.contains("plus")){ // TODO extend the programm here
            int sum = 0;
            int indexNo1 = query.indexOf("is")+3;
            int indexNo2 = query.indexOf("plus")+5;
            if (indexNo1 != -1 && indexNo2 != -1){
                sum = Integer.parseInt(query.substring(indexNo1,indexNo1+1)) +
                        Integer.parseInt(query.substring(indexNo2,indexNo2+1));
            }
            return String.valueOf(sum);
        } else {
            return "";
        }
    }
}
