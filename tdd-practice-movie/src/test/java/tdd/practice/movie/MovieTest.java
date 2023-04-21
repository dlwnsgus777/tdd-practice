package tdd.practice.movie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieTest {

    private Movie movie;

    @BeforeEach
    void setUp() {
        movie = new Movie();
    }

    @Test
    void canCreateMovie() {
        new Movie();
    }

    @Test
    @DisplayName("한번도 rate 되지 않으면 average는 0을 반환한다.")
    void test20230421163034() {

        assertThat(movie.getAverage()).isEqualTo(0);
    }

    @Test
    @DisplayName("한번만 rate 되면 average는 rate된 값.")
    void test20230421163602() {
        movie = new Movie();
        movie.rate(1);
        assertThat(movie.getAverage()).isEqualTo(1);
    }

    @Test
    @DisplayName("두번만 rate 되면 average는 rate의 평균 값.")
    void test20230421163603() {
        movie = new Movie();
        movie.rate(1);
        movie.rate(3);
        assertThat(movie.getAverage()).isEqualTo(2);
    }

    @Test
    @DisplayName("세번만 rate 되면 average는 rate의 평균 값.")
    void test20230421163605() {
        movie = new Movie();
        movie.rate(1);
        movie.rate(10);
        movie.rate(10);
        assertThat(movie.getAverage()).isEqualTo(7);
    }
}
