public class RottenPotato {

    public static void main (String[] args) {

        int [] [] ratings = { {4, 6, 2, 5},
                {7, 9, 4, 8},
                {6, 9, 3, 7} };
        double rating0 = movieAvgRating(ratings, 0);
        System.out.println("Movie zero's average rating: " + rating0);
        double rating1 = movieAvgRating(ratings, 1);
        System.out.println("Movie one's average rating: " + rating1);
        double reviewer0 = reviewerAvgRating(ratings, 0);
        System.out.println("Reviwer zero's average rating: " + reviewer0);
        double reviewer1 = reviewerAvgRating(ratings, 1);
        System.out.println("Reviwer one's average rating: " + reviewer1);
        double overall = avgRating2018(ratings);
        System.out.println("Average overall rating: " + overall);
        double hardestRater = hardestRater2018(ratings);
        System.out.println("Hardest rater: " + hardestRater);
        double worstMovie = worstMovie2018(ratings);
        System.out.println("Worst movie: " + worstMovie);
    }
    //Question 1
    /*  Write the method movieAverageRating() that takes a Rotten Potato database (2D int array)
     * as a parameter and another int that represents a particular movie. 
    Return the average rating for that movie. */
    public static double movieAvgRating(int[][] ratings, int movie) {
        double rating = 0;
        double avg = 0;
        for (int r = 0; r < ratings.length; r ++) {
            rating += ratings[r][movie];
        }
        avg = rating/ratings.length;
        return avg;
    }

    /*Write a method that takes a Rotten Potato database (2D int array) as a parameter 
     * and another int that represents a particular movie reviewer.
    Return the average rating for that particular reviewer. */
    public static double reviewerAvgRating(int[][] ratings, int reviewer) {
        double rating = 0;
        for (int c = 0; c < ratings[0].length; c ++) {
            rating += ratings[reviewer][c];
        }
        return rating/ratings[0].length;
    }

    /* Write a method that takes a Rotten Potato database (2D int array) as a parameter.
    Return the average movie rating for all movies and all reviewers in the database. */ 
    public static double avgRating2018(int[][] ratings) {
        double rating = 0;
        int movieCount = 0;
        for(int r = 0; r < ratings.length; r ++) {
            for (int c = 0; c < ratings[r].length; c ++) {
                rating += ratings[r][c];
                movieCount ++;
            }
        }
        return rating/movieCount;
    }

    /*: Write a method that takes a Rotten Potato database (2D int array) as a parameter.
     * 
    Return the index of the hardest reviewer (the reviewer with the lowest average ranking). */

    public static double hardestRater2018(int[][] ratings) {
        double [] reviewerAverage = new double [ratings.length];
        double rating = 0;
        int lowestReviewer = 0;
        //find all reviewer averages
        for (int r = 0; r < ratings.length; r ++) {
            for (int c = 0; c < ratings[0].length; c ++) {
                rating += ratings[r][c]; 
            }
            reviewerAverage[r] = rating/ratings[0].length;
            rating = 0;
        }

        //compare to find hardesr reviewer
        for (int i = 1; i < reviewerAverage.length; i ++) {
            if (reviewerAverage[i] < reviewerAverage[i - 1] && reviewerAverage[i] < reviewerAverage[0]) lowestReviewer = i;
        }
        return lowestReviewer;
    }

    /* Write a method that takes a Rotten Potato database (2D int array) as a parameter.
    Return the index of the worst movie (the movie with the lowest average ranking). */
    public static double worstMovie2018(int[][] ratings)  {
        double [] movieAverage = new double [ratings[0].length];
        double rating = 0;
        double worstMovie = 0;
        //loop thourgh and collect average ratings for all movies
        for (int c = 0; c < ratings[0].length; c ++) {
            for (int r = 0; r < ratings.length; r ++) {
                rating += ratings[r][c];
            }
            movieAverage[c] = rating/ratings[0].length;
            rating = 0;
        }
        //compare them
        for (int i = 1; i < movieAverage.length; i ++) {
            if (movieAverage[i] < movieAverage[i - 1] && movieAverage[i] < movieAverage[0]) worstMovie = i;
        }
        return worstMovie;
    }

}
