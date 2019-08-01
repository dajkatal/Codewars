package AlphabetWars;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        System.out.println(alphabetWar("abde[fgh]ijk"));
    }

    public static String alphabetWar(String battlefield) {

        if (battlefield.indexOf("#") == -1) {
            return battlefield.replace("[", "").replace("]", "");
        }

        ArrayList<int[]> Pos = new ArrayList<>();
        Pos.add(new int[]{0,0});
        ArrayList<String> status = new ArrayList<>();
        ArrayList<Integer> fortressDamage = new ArrayList<>();
        int indexOfStart = -1;
        int indexOfEnd = 0;

        while (true) {
            indexOfStart = battlefield.indexOf("[", indexOfStart + 1);
            if (indexOfStart == -1) {
                break;
            }
            indexOfEnd = battlefield.indexOf("]", indexOfStart+1) + 1;
            String fortress = battlefield.substring(indexOfStart, indexOfEnd);
            Pos.add(new int[]{indexOfStart, indexOfEnd});
            fortressDamage.add(0);
            status.add(fortress);
        }
        Pos.add(new int[]{battlefield.length(),battlefield.length()});

        for (int i = 1; i < Pos.size(); i++) {
            int[] openArea = new int[]{Pos.get(i-1)[1], Pos.get(i)[0]};
            int damage = 0;
            int indexOfBomb = -1;
            while (true) {
                String area = battlefield.substring(openArea[0], openArea[1]);
                indexOfBomb = area.indexOf("#", indexOfBomb + 1);
                if (indexOfBomb == -1) {
                    break;
                }
                damage += 1;
            }


            for (int b = 1; b < Pos.size() - 1; b++){
                if (Pos.get(b)[0] == openArea[1] | Pos.get(b)[1] == openArea[0]) {

                    fortressDamage.set(b-1, fortressDamage.get(b-1) + damage);
                }
            }


        }

        String finalOutput = "";

        for (int i = 0; i < status.size(); i++) {
            if (fortressDamage.get(i) < 2) {
                finalOutput += status.get(i).replace("[", "").replace("]", "");
            }
        }

        return finalOutput;

    }



}
