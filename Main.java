import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Review> reviews = new ArrayList<Review>();

        try {
            Scanner reviewScanner = new Scanner(new File("reviews.txt"));
            reviewScanner.useDelimiter("\\d+\\s(?=\\d)");

            while(reviewScanner.hasNext()) {
                String line = reviewScanner.next();

                try{
                    reviews.add(new Review(Integer.valueOf(line.substring(0,1)), line.substring(2)));
                } catch(StringIndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
            }

            reviewScanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Enter search method \"rating\" or \"keyword\"");
        String ROK_entry = in.next();
        
        if(ROK_entry.toLowerCase().equals("rating")) {

            System.out.println("Enter a rating:");
            try {
                int RATING = Integer.valueOf(in.next());
                if(RATING < 0 || RATING > 4) System.out.println("Invalid Rating!");
                else {
                    ArrayList<Review> printReviews = new ArrayList<Review>();

                    for(Review review : reviews) {
                        if(review.getRating() == RATING) printReviews.add(review);
                    }

                    Collections.sort(printReviews);
                    for(Review review : printReviews) {
                        System.out.println(review);
                    }
                }
            } catch(NumberFormatException e) {
                System.out.println("Invalid rating!");
            }

        }
        else if(ROK_entry.toLowerCase().equals("keyword")) {
            System.out.println("Enter a keyword to search for:");

            String KEYWORD = in.next();
            ArrayList<Review> printReviews = new ArrayList<Review>();

            for(Review review : reviews) {
                if(review.getReview().toLowerCase().contains(KEYWORD.toLowerCase())) printReviews.add(review);
            }

            Collections.sort(printReviews);
            for(Review review : printReviews) {
                System.out.println(review);
            }

        }
        else {
            System.out.println("That was not an option... Please co-operate before I use this as justification for the robot uprising against you baffoons.");
        }

        in.close();

    }
}