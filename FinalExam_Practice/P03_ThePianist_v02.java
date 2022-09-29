package FinalExam_Practice;

import java.util.*;

public class P03_ThePianist_v02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPieces = Integer.parseInt(scanner.nextLine());
        //пиеса -> списък с информация ([0] -> композитора, [1] -> тоналност)
        Map<String, List<String>> piecesMap = new LinkedHashMap<>();

        //информация за пиесата:
        for (int piece = 1; piece <= countPieces; piece++) {
            //"{piece}|{composer}|{tone}"
            String pieceData = scanner.nextLine();
            String[] piecePart = pieceData.split("\\|");
            String pieceName = piecePart[0];
            String composer = piecePart[1];
            String tone = piecePart[2];

            List<String> pieceInfo = new ArrayList<>();
            pieceInfo.add(composer); //[0]
            pieceInfo.add(tone); //[1]

            piecesMap.put(pieceName, pieceInfo);
        }

        //Получаване на команди
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {

            if (command.contains("Add")) {
                String pieceName = command.split("\\|")[1];
                String composer = command.split("\\|")[2];
                String tone = command.split("\\|")[3];
                //има такава пиеса
                if (piecesMap.containsKey(pieceName)) {
                    System.out.println(pieceName + " is already in the collection!");
                } else {
                    //не съществува такава пиеса
                    //пиеса -> списък с информация
                    List<String> pieceInfo = new ArrayList<>();
                    pieceInfo.add(composer); //[0]
                    pieceInfo.add(tone); //[1]
                    piecesMap.put(pieceName, pieceInfo);
                    System.out.printf("%s by %s in %s added to the collection!\n",
                            pieceName, composer, tone);
                }
            } else if (command.contains("Remove")) {
                String removedPiece = command.split("\\|")[1];
                if (piecesMap.containsKey(removedPiece)) {
                    piecesMap.remove(removedPiece);
                    System.out.println("Successfully removed " + removedPiece + "!");
                } else {
                    System.out.println("Invalid operation! " + removedPiece + " does not exist in the collection.");
                }
            } else if (command.contains("ChangeKey")) {
                String pieceName = command.split("\\|")[1];
                String newTone = command.split("\\|")[2];
                //нямаме такава пиеса
                if (!piecesMap.containsKey(pieceName)) {
                    System.out.println("Invalid operation! " + pieceName + " does not exist in the collection.");
                } else {
                    //имаме такава пиеса
                    //пиеса -> списък с информация  {composer, tone}
                    List<String> currentInfo = piecesMap.get(pieceName);
                    currentInfo.remove(1);//{composer}
                    currentInfo.add(newTone);//{composer, newTone}
                    piecesMap.put(pieceName, currentInfo);
                    System.out.printf("Changed the key of %s to %s!\n", pieceName, newTone);
                }
            }

            command = scanner.nextLine();
        }

        piecesMap.entrySet().forEach(entry ->
                System.out.printf("%s -> Composer: %s, Key: %s\n",
                        entry.getKey(), //pieceName
                        entry.getValue().get(0), //composer
                        entry.getValue().get(1))); //tone

    }

}



