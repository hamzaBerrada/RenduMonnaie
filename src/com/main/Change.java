package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Change {

    public Change(){
        calculateChange();
    }

    public void calculateChange(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("change ");
        int nbrPieces = scanner.nextInt();

        //fail fast if there are no Pieces
        if(nbrPieces < 1) return;

        int[] pieces = new int[nbrPieces];
        for(int i = 0; i < nbrPieces; i++){
            pieces[i] = scanner.nextInt();
        }

        //The size of the remaining amounts is not specified
        while(true) {
            int change = scanner.nextInt();
            List<Integer> result = computeChangePieces(pieces, change);
            if(result.stream().allMatch(e -> e == 0)){
                System.out.print(-1 +" ");
            }
            else
                result.forEach(e -> System.out.print(e +" "));
        }
    }

    public List<Integer> computeChangePieces(int[] pieces, int change){
        int nbrPieces = pieces.length;

        //the result list contains the occurrence of pieces to be returned regarding the change entered
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nbrPieces; i++) {
            int mod = change % pieces[i];

            if(mod == change) {
                result.add(0);
            }
            else if(mod == 0){
                result.add(change / pieces[i]);
                change = change % pieces[i];
            }
            // In this case, we have to check if the modulo of the remaining pieces can complete the change
            //There are two cases: we have to check if we want one or more of the current piece
            else if(mod >= 1){
                int res = 0;
                for (int j = i + 1; j < nbrPieces; j++) {
                    if(mod % pieces[j] == 0) {
                        res = change / pieces[i];
                        change %= pieces[i];
                    }
                    else if ((change-pieces[i]) % pieces[j] == 0) {
                        res = 1;
                        change -= pieces[i];
                    }
                }
                result.add(res);
            }
        }
        return result;
    }

    public static void main(String...args) {
        new Change(); // test case=> 3 pieces: 10 5 2 , change can be any numeric value
    }
}
