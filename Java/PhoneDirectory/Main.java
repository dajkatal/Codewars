package PhoneDirectory;

import java.text.MessageFormat;
import java.util.*;

public class Main {
    public static void main(String[] args){
        String phonebook = "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010\n"
                + "+1-541-984-3012 <P Reed> /PO Box 530; Pollocksville, NC-28573\n :+1-321-512-2222 <Paul Dive> Sequoia Alley PQ-67209\n"
                + "+1-741-984-3090 <Peter Reedgrave> _Chicago\n :+1-921-333-2222 <Anna Stevens> Haramburu_Street AA-67209\n"
                + "+1-111-544-8973 <Peter Pan> LA\n +1-921-512-2222 <Wilfrid Stevens> Wild Street AA-67209\n"
                + "<Peter Gone> LA ?+1-121-544-8974 \n <R Steell> Quora Street AB-47209 +1-481-512-2222\n"
                + "<Arthur Clarke> San Antonio $+1-121-504-8974 TT-45120\n <Ray Chandler> Teliman Pk. !+1-681-512-2222! AB-47209,\n"
                + "<Sophia Loren> +1-421-674-8974 Bern TP-46017\n <Peter O'Brien> High Street +1-908-512-2222; CC-47209\n"
                + "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n <P Salinger> Main Street, +1-098-512-2222, Denver\n"
                + "<C Powel> *+19-421-674-8974 Chateau des Fosses Strasbourg F-68000\n <Bernard Deltheil> +1-498-512-2222; Mount Av.  Eldorado\n"
                + "+1-099-500-8000 <Peter Crush> Labrador Bd.\n +1-931-512-4855 <William Saurin> Bison Street CQ-23071\n"
                + "<P Salinge> Main Street, +1-098-512-2222, Denve\n"+ "<P Salinge> Main Street, +1-098-512-2222, Denve\n";

        System.out.println(phone(phonebook, "1-908-512-2222").replaceAll("\\s+", "*"));
    }

    public static String phone(String phonebook, String num) {
        String[] phonebookSeparated = phonebook.split("\n");

        ArrayList<HashMap> allRelationships = new ArrayList<>();

        for (int i = 0; i < phonebookSeparated.length; i++) {
            HashMap<String, String> relationship = new HashMap<>();
            String str = phonebookSeparated[i].strip();
            int startingPoint = str.indexOf("+");
            int endingPoint = str.indexOf("-", str.indexOf("-", str.indexOf("-", startingPoint) + 1) + 1) + 5;

            relationship.put("Phone", str.substring(startingPoint + 1, endingPoint));
            str = str.replace(str.substring(startingPoint, endingPoint), "");

            relationship.put("Name", str.substring(str.indexOf("<") + 1, str.indexOf(">")));
            str = str.replace(str.substring(str.indexOf("<"), str.indexOf(">") + 1), "");
            str = str.replaceAll("[\\//$||*:;?|']", "");
            str = str.replace("_", " ");
            str = str.strip();
            int indexOfComma = str.indexOf(',');
            if (indexOfComma != -1) {
                str = str.substring(0, indexOfComma) + str.substring(indexOfComma + 1);
            }

            str = str.replace("  ", " ");

            System.out.println(str);

            relationship.put("Address", str);

            allRelationships.add(relationship);

        }

        ArrayList<String> foundValues = new ArrayList<>();


        for (HashMap values: allRelationships) {

            if (values.get("Phone").equals(num)) {
                String Phone = MessageFormat.format("Phone => {0}", values.get("Phone"));
                String Address = MessageFormat.format("Address => {0}", values.get("Address"));
                String Name = MessageFormat.format("Name => {0}", values.get("Name"));

                foundValues.add(MessageFormat.format("{0}, {1}, {2}", Phone, Name, Address));


            }
        }


        if (foundValues.size() > 1) {
            return (MessageFormat.format("Error => Too many people: {0}", num));
        }
        if (foundValues.size() == 1) {
            return foundValues.get(0);
        }

        return (MessageFormat.format("Error => Not found: {0}", num));


    }
}

/*

/+1-541-754-3010 156 Alphand_St. <J Steeve>
[+1-541-754-3010, 156 Alphand Str., <J Steeve>]


 */