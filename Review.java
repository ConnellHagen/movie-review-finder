public class Review implements Comparable<Review> {

    private int rating;
    private String review;

    Review(int rating, String review) {
        this.rating = rating;
        this.review = review;
    }

    public int getRating() {return rating;}
    public String getReview() {return review;}

    @Override
    public int compareTo(Review other) {
        int ratingDifference = rating - other.getRating();
        if(ratingDifference != 0) return ratingDifference;
        return review.compareTo(other.getReview());
    }

    @Override
    public String toString() {
        if(rating == 1) return rating + " Star: " + review;
        return rating + " Stars: " + review;
    }
}
