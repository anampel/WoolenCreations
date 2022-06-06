package com.site.woolencreations.user;

import com.site.woolencreations.product.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    private UserService userService;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    @BeforeEach
    void init() {
        this.userService = new UserService(userRepository, productRepository);
    }

    @AfterEach
    void afterEach(){
        System.out.println("Test case finished successfully");
    }

    @Test
    void returnTrueIfAuthorizationIsSuccessful() {
        //given
        String username = "test";
        String pws = "test";
        //when
        Executable executable = () -> UserService.authenticateLogin2(username, pws);
        //then
        assertDoesNotThrow(executable);
    }

    @Test
    void returnTrueIfAuthorizationIsNotSuccessful() {
        //given
        String username = "1234"; //illegal argument
        String pws = "test";
        //when
        Executable executable = () -> UserService.authenticateLogin2(username, pws);
        //then
        assertAll(
                ()-> assertThrows(IllegalArgumentException.class, executable)
        );
    }

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 4})
    void should_getPoints_when_PointsAre20(Long given_id){
        //given
        Long id= Long.valueOf(given_id);
        //when
        int usersPoints = UserService.getPoints(id);
        //then (Expected results)
        /**
         * When we use the assertEquals :
         * comes an error that says that the objects are different
         * case 1: if we compare arrays --> use assertArrayEquals
         * case 2: these are different objects in the store but with the same values --> compare with getValue for every value of the Objects'
         * */
        assertEquals(20, usersPoints);
    }

    @ParameterizedTest(name = "userId={0}, points={1}")
    @CsvSource(value = {"1, 20", "2, 30", "3, 40"})
    void should_getPoints_when_PointsAre30(Long userId, int points){
        //given
        Long id= Long.valueOf(userId);
        int userPoints = points;
        //when
        int usersPoints = UserService.getPoints(id);
        //then (Expected results)
        /**
         * When we use the assertEquals :
         * comes an error that says that the objects are different
         * case 1: if we compare arrays --> use assertArrayEquals
         * case 2: these are different objects in the store but with the same values --> compare with getValue for every value of the Objects'
         * */
        assertEquals(20, usersPoints);
    }

    @Test
    void should_ReturnCorrect_when_UserIsGuest(){
        //given
        String username = "anam@gmail.com";
        //when
        Boolean isGuest = userService.findIfGuest(username);
        //then
        assertTrue(isGuest);
    }
}
